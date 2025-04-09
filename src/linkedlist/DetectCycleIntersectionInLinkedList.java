package linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/*
* You are given a collection of singly-linked lists (SLLs) and several sets of starting nodes. Each starting node is
* pointing at a node which is part of an SLL.

Your program should traverse each set of starting nodes and detect whether any list in the set is cyclic, or any two
* lists in the set are intersecting.

* */
public class DetectCycleIntersectionInLinkedList {

    public static void main(String[] args) {
        String[] edges = {"a->b", "b->c", "f->g", "x->y", "c->d", "r->s", "z->s", "y->z", "d->a", "t->u", "s->t", "e->f"};
        String startPoints = "a,b";
        System.out.println(LinkedListCycleAndIntersection.solve(edges, startPoints));

        startPoints = "x,e";
        System.out.println(LinkedListCycleAndIntersection.solve(edges, startPoints));

        startPoints = "t,f";
        System.out.println(LinkedListCycleAndIntersection.solve(edges, startPoints));

        startPoints = "e,y,r";
        System.out.println(LinkedListCycleAndIntersection.solve(edges,startPoints));
    }
}

class NodeData {
    String value;
    NodeData next;

    NodeData(String value) {
        this.value = value;
        this.next = null;
    }
}
class LinkedListCycleAndIntersection {

    // Method to create the linked list from the given edges
    public static Map<String, NodeData> createLinkedList(String[] edges) {
        Map<String, NodeData> nodeMap = new HashMap<>();

        for (String edge : edges) {
            String[] nodes = edge.split("->");
            String start = nodes[0];
            String end = nodes[1];

            nodeMap.putIfAbsent(start, new NodeData(start));
            nodeMap.putIfAbsent(end, new NodeData(end));

            nodeMap.get(start).next = nodeMap.get(end);
        }

        return nodeMap;
    }

    // Method to check if the linked list has a cycle
    public static boolean hasCycle(NodeData startNode) {
        Set<NodeData> visited = new HashSet<>();
        NodeData current = startNode;

        while (current != null) {
            if (visited.contains(current)) {
                return true; // Cycle detected
            }
            visited.add(current);
            current = current.next;
        }
        return false; // No cycle
    }

    // Method to detect intersection between two linked lists
    public static boolean detectIntersection(NodeData list1Start, NodeData list2Start) {
        Set<NodeData> seen = new HashSet<>();

        // Traverse the first list and add all nodes to the set
        NodeData current = list1Start;
        while (current != null) {
            seen.add(current);
            current = current.next;
        }

        // Traverse the second list and check if any node is in the set
        current = list2Start;
        while (current != null) {
            if (seen.contains(current)) {
                return true; // Intersection found
            }
            current = current.next;
        }

        return false; // No intersection
    }

    // Method to check for cycles and intersections in a list of starting points
    public static String solve(String[] edges, String startPoints) {
        // Create the node map for the given edges
        Map<String, NodeData> nodeMap = createLinkedList(edges);

        // Split the startPoints by commas to get the list of starting points
        String[] starts = startPoints.split(",");

        // Step 1: Check for cycles in each list starting from the given points
        for (String start : starts) {
            NodeData listStart = nodeMap.get(start);
            if (hasCycle(listStart)) {
                return "CYCLE";
            }
        }

        // Step 2: Check for intersections between each pair of lists
        for (int i = 0; i < starts.length; i++) {
            NodeData list1Start = nodeMap.get(starts[i]);
            for (int j = i + 1; j < starts.length; j++) {
                NodeData list2Start = nodeMap.get(starts[j]);
                if (detectIntersection(list1Start, list2Start)) {
                    return "INTERSECTION";
                }
            }
        }

        // Step 3: If no cycles or intersections, return "OK"
        return "OK";
    }
}

