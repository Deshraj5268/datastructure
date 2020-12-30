package gfg.stack.lru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache
{
    public static LinkedHashMap<Integer,Integer> linkedHashMap;
    public static int cap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t-- > 0){
            int cap = Integer.parseInt(bufferedReader.readLine());
            int q = Integer.parseInt(bufferedReader.readLine());
            LRUCache lruCache = new LRUCache(cap);
            String [] str = bufferedReader.readLine().trim().split(" ");
            int itr = 0;
            int len = str.length;
            for(int i=0;(i<q && itr<len);i++){
                String qType = str[itr++];
                if(qType.equals("SET")){
                    int key = Integer.parseInt(str[itr++]);
                    int val = Integer.parseInt(str[itr++]);
                    lruCache.set(key,val);
                }
                if(qType.equals("GET")){
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(lruCache.get(key) + " ");
                }
            }
        }

    }

    /*
    * LinkedHashamp arg 1: initial capacity
    * arg 2 : load factor
    * *arg3 :by default it maintain insertion order if we pass access order true then it maintain access order also
    * removeEldestEntry() : it's invoke after every call of put or puttAll() , if true then remove least recently node
    * For Order attribute, true is passed for last access order(move node at he end) and false is passed for insertion order.
    * */
    public LRUCache(int cap)
    {
        // Intialize the cache capacity with the given
        // cap
        this.cap = cap;
        this.linkedHashMap = new LinkedHashMap<Integer,Integer>(cap,.75f,true){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return cap < size();
            }
        };
    }

    // This method works in O(1) //
    public  int get(int key) {
        if(linkedHashMap.size() > 0){
            Integer result = linkedHashMap.get(key);
            if(result != null){
                return result;
            }
        }
        return -1;
    }

    // This method works in O(1)
    public  void set(int key, int value) {
        linkedHashMap.put(key,value);
    }
}