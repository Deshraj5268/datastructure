package gfg.stack.lru;

import java.util.Arrays;

public class LRUDriver {

    public static void main(String[] args) {
        int frameSize = 4;
        int [] pages = {1,2,3,1,4,5};

        //LRU cache using my Linked list function  and hashmap
        LRU customLRU = new CustomLRU(frameSize);
        pageReferenced(pages,customLRU);
        System.out.println(customLRU.getPage(3));

        //LRU cache using linkedHashSet
        LRU linkedHashSetLRU = new LinkedHashSetLRU(frameSize);
        pageReferenced(pages,linkedHashSetLRU);
        System.out.println(linkedHashSetLRU.getPage(3));

        //LRU cache using linkedHasMap
        LRU linkedHasMapLRU = new LinkedHasMapLRU(frameSize);
        pageReferenced(pages,linkedHasMapLRU);
        System.out.println(linkedHasMapLRU.getPage(3));
    }

    private static void pageReferenced(int [] pages,LRU lru){
        Arrays.stream(pages).forEach(lru::setPage);
    }
}
