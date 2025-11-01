package companyaskedquestion;

import java.util.*;

// asked in amazon
/*
Given a log of website requests, where each line contains an entry with the following fields (time, customerId, pageVisited) in
it represents a request made by customer at time T to one of the website's pages,
write algorithm to find the top sequence (with exactly 3 pages) visited given a list of log entries.
For example, given the following log file containing::

[0,C1,A,
0,C2,E
1,C1,B
1,C2,B
2,C1,C
2,C2,C
3,C1,D
3,C2,D
4,C1,E
5,C2,A]]

We can see that we have two customers, and we know that customer C1 visited the pages A -> B -> C -> D -> E (visiting order matters)
and customer C2 visited E -> B -> C -> D -> A, then we can tell that the overall most visited sequence of 3 pages is is B -> C -> D
because it occurs twice.*/
public class PageVisitSequence {

    public static void main(String[] args) {
        List<LogEntry> logs = Arrays.asList(
                new LogEntry(0, "C1", "A"),
                new LogEntry(0, "C2", "E"),
                new LogEntry(2, "C1", "B"),
                new LogEntry(2, "C2", "B"),
                new LogEntry(1, "C1", "C"),
                new LogEntry(1, "C2", "C"),
                new LogEntry(3, "C1", "D"),
                new LogEntry(3, "C2", "D"),
                new LogEntry(4, "C1", "E"),
                new LogEntry(5, "C2", "A")
        );

        List<String> result = mostFrequent3PageSequence(logs);
        System.out.println("Most frequent 3-page sequence: " + result); // Output: [B, C, D]
    }

    public static List<String> mostFrequent3PageSequence(List<LogEntry> logs) {
        Map<String , List<LogEntry>> userLogs = new HashMap<>();

        for(LogEntry logEntry : logs){
            userLogs.computeIfAbsent(logEntry.customerId, k-> new ArrayList<>()).add(logEntry);
        }

        // sort based on time
        for(Map.Entry<String , List<LogEntry>> logsEntry : userLogs.entrySet()){
            logsEntry.getValue().sort(Comparator.comparingInt(l -> l.time));
        }

        Map<String, Integer> countSequences = new HashMap<>();
        for(Map.Entry<String , List<LogEntry>> logsEntry : userLogs.entrySet()){
            // Set<String> seenSequences = new HashSet<>();
            List<LogEntry> logEntries = logsEntry.getValue();
            for(int i=0;i<logEntries.size() - 2;i++){
                String sequence = logEntries.get(i).page+","+logEntries.get(i+1).page+","+logEntries.get(i+2).page;
                countSequences.put(sequence, countSequences.getOrDefault(sequence, 0)+1);
            }
        }
        String topSequence = "";
        int maxCount = 0;
        for(Map.Entry<String, Integer> countSequence : countSequences.entrySet()){
            if(maxCount < countSequence.getValue()){
                topSequence = countSequence.getKey();
                maxCount = countSequence.getValue();
            }
        }
        return Arrays.asList(topSequence.split(","));
    }
}

class LogEntry {
    int time;
    String customerId;
    String page;

    LogEntry(int time, String customerId, String page) {
        this.time = time;
        this.customerId = customerId;
        this.page = page;
    }
}