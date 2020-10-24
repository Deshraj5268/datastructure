package gfg.stack.lru;

import java.util.LinkedHashSet;

public class LinkedHashSetLRU implements LRU{

    private LinkedHashSet<Integer> linkedHashSet;
    private int frameSize;

    public LinkedHashSetLRU(int frameSize){
        this.frameSize = frameSize;
        this.linkedHashSet = new LinkedHashSet<>(frameSize);
    }

    @Override
    public void setPage(int pageNumber) {
        if(linkedHashSet.contains(pageNumber)){ //move at the end
            linkedHashSet.remove(pageNumber);
            linkedHashSet.add(pageNumber);
        }else {
            if(linkedHashSet.size() == frameSize){
                linkedHashSet.remove(linkedHashSet.iterator().next());
            }
            linkedHashSet.add(pageNumber);
        }
    }

    @Override
    public int getPage(int key) {
        if(linkedHashSet.size() > 0 && linkedHashSet.contains(key)){ //move at the end
            linkedHashSet.remove(key);
            linkedHashSet.add(key);
            return key;
        }
        return -1;
    }
}
