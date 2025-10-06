package Hashing;

import java.util.*;


/* Asked in karat
*
* */

/*
*   You are analyzing data for Aquaintly, a hot new social network.

    On Aquaintly, connections are always symmetrical. If a user Alice is connected to Bob, then Bob is also connected to Alice.

    You are given a sequential log of CONNECT and DISCONNECT events of the following form:
    - This event connects users Alice and Bob: ["CONNECT", "Alice", "Bob"]
    - This event disconnects the same users: ["DISCONNECT", "Bob", "Alice"] (order of users does not matter)

    We want to separate users based on their popularity (number of connections). To do this, write a function that takes in the event log and a number N and returns two collections:
    [Users with fewer than N connections], [Users with N or more connections]

    Example:
    events = [
        ["CONNECT","Alice","Bob"],
        ["DISCONNECT","Bob","Alice"],
        ["CONNECT","Alice","Charlie"],
        ["CONNECT","Dennis","Bob"],
        ["CONNECT","Pam","Dennis"],
        ["DISCONNECT","Pam","Dennis"],
        ["CONNECT","Pam","Dennis"],
        ["CONNECT","Edward","Bob"],
        ["CONNECT","Dennis","Charlie"],
        ["CONNECT","Alice","Nicole"],
        ["CONNECT","Pam","Edward"],
        ["DISCONNECT","Dennis","Charlie"],
        ["CONNECT","Dennis","Edward"],
        ["CONNECT","Charlie","Bob"]
    ]

    Aclice -> Charlie
    Charlie -> Aclice
    Dennis -> Bob, Dennis
    Bob -> Dennis
    Pam->Dennis

    hashMap<Strinmg , HashSet<String>>
    Alice --> HashSet<Bob
    Bob --> Alic

    Using a target of 3 connections, the expected results are:
    Users with less than 3 connections: ["Alice", "Charlie", "Pam", "Nicole"]
    Users with 3 or more connections: ["Dennis", "Bob", "Edward"]

    All test cases:
    grouping(events, 3) => [["Alice", "Charlie", "Pam", "Nicole"], ["Dennis", "Bob", "Edward"]]
    grouping(events, 1) => [[], ["Alice", "Charlie", "Dennis", "Bob", "Pam", "Edward", "Nicole"]]
    grouping(events, 10) => [["Alice", "Charlie", "Dennis", "Bob", "Pam", "Edward", "Nicole"], []]
    Complexity Variable:
    E = number of events
* */
public class AquaintlyGrouping {

    public static void main(String[] args) {
        List<String[]> events = Arrays.asList(
                new String[]{"CONNECT","Alice","Bob"},
                new String[]{"DISCONNECT","Bob","Alice"},
                new String[]{"CONNECT","Alice","Charlie"},
                new String[]{"CONNECT","Dennis","Bob"},
                new String[]{"CONNECT","Pam","Dennis"},
                new String[]{"DISCONNECT","Pam","Dennis"},
                new String[]{"CONNECT","Pam","Dennis"},
                new String[]{"CONNECT","Edward","Bob"},
                new String[]{"CONNECT","Dennis","Charlie"},
                new String[]{"CONNECT","Alice","Nicole"},
                new String[]{"CONNECT","Pam","Edward"},
                new String[]{"DISCONNECT","Dennis","Charlie"},
                new String[]{"CONNECT","Dennis","Edward"},
                new String[]{"CONNECT","Charlie","Bob"}
        );

        System.out.println("with connection 3"+grouping(events, 3));
        // [[Alice, Charlie, Nicole, Pam], [Bob, Dennis, Edward]]

        System.out.println("with connection 1"+grouping(events, 1));
        // [[], [Alice, Bob, Charlie, Dennis, Edward, Nicole, Pam]]

        System.out.println("with connection 10"+grouping(events, 10));
        // [[Alice, Bob, Charlie, Dennis, Edward, Nicole, Pam], []]
    }

    public static List<List<String>> grouping(List<String[]> events, int N) {
        // adjacency: user -> set of connections
        Map<String, Set<String>> graph = new HashMap<>();

        for (String[] event : events) {
            String action = event[0];
            String u = event[1];
            String v = event[2];

            graph.putIfAbsent(u, new HashSet<>());
            graph.putIfAbsent(v, new HashSet<>());

            if ("CONNECT".equals(action)) {
                graph.get(u).add(v);
                graph.get(v).add(u);
            } else if ("DISCONNECT".equals(action)) {
                graph.get(u).remove(v);
                graph.get(v).remove(u);
            }
        }

        List<String> less = new ArrayList<>();
        List<String> atleast = new ArrayList<>();

        for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
            String user = entry.getKey();
            int degree = entry.getValue().size();

            if (degree < N) {
                less.add(user);
            } else {
                atleast.add(user);
            }
        }

        Collections.sort(less);
        Collections.sort(atleast);

        return Arrays.asList(less, atleast);
    }
}
