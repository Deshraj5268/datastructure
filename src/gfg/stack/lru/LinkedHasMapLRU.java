package gfg.stack.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHasMapLRU implements LRU{

    private int frameSize;
    private LinkedHashMap<Integer,Integer> linkedHashMap;

    public LinkedHasMapLRU(int frameSize) {
        this.frameSize = frameSize;
        this.linkedHashMap = new LinkedHashMap<Integer,Integer>(frameSize){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return frameSize < size();
            }
        };
    }

    @Override
    public void setPage(int pageNumber) {
        Integer value = linkedHashMap.get(pageNumber);
        if(value != null){
            Integer refValue = linkedHashMap.remove(pageNumber);
            linkedHashMap.put(pageNumber,refValue);
        }else{
            linkedHashMap.put(pageNumber,pageNumber); //it will call eldestEntry
        }
    }

    @Override
    public int getPage() {
         return linkedHashMap.size()>0 ? linkedHashMap.entrySet().iterator().next().getValue():0;
    }
}
