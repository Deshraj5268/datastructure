package advanceds.leaderboardproblem;


import java.util.*;

/*
* https://www.youtube.com/watch?v=MrXVoWkLVog / good explanation and simple code
* problem : https://leetcode.com/problems/all-oone-data-structure/
* */
public class AllOne {


    Map<String , Node> keyValMap;
    Node head, tail; // head, tail = keep track of min,max Freq respectively
    public static void main(String[] args) {

        AllOne allOne = new AllOne();
        allOne.getMinKey();
        allOne.getMaxKey();

        allOne.inc("hello");
        allOne.inc("hello");
        allOne.getMaxKey();
        allOne.getMinKey();
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        allOne.inc("code");
        allOne.inc("count");
        allOne.inc("count");
        allOne.inc("count");
        allOne.inc("count");
        allOne.getMaxKey();
        allOne.getMinKey();

        allOne.dec("count");
        allOne.getMaxKey();
        allOne.getMinKey();

        allOne.printNodeList();
    }

    private void printNodeList() {
        System.out.println("print list by frequency ");
        Node temp = head.next;
        while (temp.next != null){
            System.out.println(temp.freq + "-" +Arrays.toString(temp.keys.toArray()));
            temp = temp.next;
        }
    }

    public AllOne() {
        this.keyValMap = new HashMap<>();
        this.head = new Node();// dummy node
        this.tail = new Node();// dummy node

        // head<->tail
        head.next = tail;
        tail.prev = head;
    }

    /*
    * linked list maintain the order with freq
    * ex 1-<->2<->3
    *
    * if key present or not
    *
    * add data into next node if present
    * otherwise create new Node at right
    * */
    public void inc(String key) {
        Node currentNode = keyValMap.get(key);
        if(currentNode != null){ // key exist
            incrementFrequency(key, currentNode);
        }else { // key not present
            if(head.next.freq == 1){
                head.next.keys.add(key);
            }else{
                addNewNodeAtRight(head, 1, key);// head.next = newNode(key,1) point each other
            }
            keyValMap.put(key, head.next);
        }

    }

    private void incrementFrequency(String key, Node currentNode) {
        currentNode.keys.remove(key);// remove key from current node

        if(currentNode.next.freq == currentNode.freq+1){ // next node has data then add it
            currentNode.next.keys.add(key);
        }else{
            addNewNodeAtRight(currentNode, currentNode.freq+1, key);
        }
        keyValMap.put(key, currentNode.next);

        if(currentNode.keys.isEmpty()){ // key not present
            removeCurrentNode(currentNode);
        }
    }

    public void dec(String key) {

        Node currentNode = keyValMap.get(key);
        //always exist but we can check it
        if (currentNode != null) {
            currentNode.keys.remove(key);

            if (currentNode.freq == 1) {
                keyValMap.remove(key);
            } else {
                if (currentNode.prev.freq == currentNode.freq - 1) { // prev node has freq node
                    currentNode.prev.keys.add(key);
                } else {
                    addNewNodeAtRight(currentNode.prev, currentNode.freq - 1, key);
                }
                keyValMap.put(key, currentNode.prev);
            }

            if(currentNode.keys.isEmpty()){
                removeCurrentNode(currentNode);
            }
        }
    }
    public String getMinKey() {
        String minKey = head.next == tail ? "" : head.next.keys.iterator().next();// first node
        System.out.println("minKey : "+minKey);
        return minKey;
    }

    public String getMaxKey() {
        String maxKey = head.next == tail ? "" : tail.prev.keys.iterator().next();// last node
        System.out.println("maxKey:"+maxKey);
        return maxKey;
    }

    private void removeCurrentNode(Node currentNode) {
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
    }

    public void addNewNodeAtRight(Node currentNode, int freq , String key){
        Node newNode = new Node(freq, key);
        newNode.prev = currentNode;
        newNode.next = currentNode.next;
        currentNode.next.prev = newNode;
        currentNode.next = newNode;
    }


}

class Node {
    int freq;
    Set<String> keys; // order is matter , u can choose storage as per ur understanding
    Node prev, next;// less and greater freq's node

    public Node(){
        this.keys = new HashSet<>();
    }
    public Node(int freq, String key) {
        this.freq = freq;
        Set<String> keys = new HashSet<>();
        keys.add(key);
        this.keys = keys;
        this.prev = this.next = null;
    }
}
