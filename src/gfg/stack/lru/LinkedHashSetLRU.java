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
            linkedHashSet.add(pageNumber);//add at the end
        }else {
            if(linkedHashSet.size() == frameSize){
                linkedHashSet.remove(linkedHashSet.iterator().next());
            }
            linkedHashSet.add(pageNumber);
        }
    }

    @Override
    public int getPage() {
        return (linkedHashSet.size() >0 ?linkedHashSet.iterator().next():0);
    }
}
