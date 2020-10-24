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

    public LRUCache(int cap)
    {
        // Intialize the cache capacity with the given
        // cap
        this.cap = cap;
        this.linkedHashMap = new LinkedHashMap<Integer,Integer>(cap){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return cap < size();
            }
        };
    }

    // This method works in O(1) //
    public  int get(int key) {
        if(linkedHashMap.size() > 0){
            Integer result = linkedHashMap.get(key);
            if(result == null){
                return -1;
            }else{
                linkedHashMap.remove(key);
                linkedHashMap.put(key,result);
                return result;
            }
        }
        return -1;
    }

    public  void printMap(Map<Integer,Integer> linkedHashMap){
        for(Map.Entry<Integer,Integer> entry : linkedHashMap.entrySet()){
            System.out.print(entry.getKey() + " -> "+entry.getValue() +" ");
        }
    }

    // This method works in O(1)
    public  void set(int key, int value) {
        Integer pageRef = linkedHashMap.get(key);
        if(pageRef != null){
            linkedHashMap.remove(key);
        }
        linkedHashMap.put(key,value);
    }
}