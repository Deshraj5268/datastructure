package gfg.stack.lru;

import linkedlist.doublylinklist.DLinkedList;
import linkedlist.doublylinklist.DListNode;

import java.util.HashMap;
import java.util.Map;

public class CustomLRU implements LRU {

    private Map<Integer, DListNode> map;
    private DLinkedList list;
    private int frameSize;

    public CustomLRU(int frameSize) {
        this.frameSize= frameSize;
        this.map = new HashMap<>(frameSize);
        this.list = new DLinkedList();
    }

    @Override
    public void setPage(int pageNumber) {
        DListNode pageRef = map.get(pageNumber);
        if(pageRef != null){
            list.addLast(list.removeNode(pageRef));
        }else{
            if(list.size == frameSize){
                map.remove(list.removeFirst());
            }
            DListNode pageNode = list.addLast(pageNumber);
            map.put(pageNumber,pageNode);
        }
    }

    @Override
    public int getPage() {
        return (list.getHead() == null? 0: list.getHead().data);
    }
}
