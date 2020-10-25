package gfg.stack.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHasMapLRU implements LRU{

    private int frameSize;
    private LinkedHashMap<Integer,Integer> linkedHashMap;

    public LinkedHasMapLRU(int frameSize) {
        this.frameSize = frameSize;
        this.linkedHashMap = new LinkedHashMap<Integer,Integer>(frameSize,.75f,true){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return frameSize < size();
            }
        };
    }

    @Override
    public void setPage(int pageNumber) {
        linkedHashMap.put(pageNumber,pageNumber); //it will call eldestEntry
    }

    @Override
    public int getPage(int key) {
        if(linkedHashMap.size() > 0){
            Integer pageRef = linkedHashMap.get(key);
            if(pageRef != null){
                return pageRef;
            }
        }
        return -1;
    }
}
