package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyUrl {

    protected static final char[] constCharArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    protected static Map<Character, Integer> map;
    private Random random = new Random();
    private static int NUM_CHARS_SHORT_LINK;

    /*
    * URL with length 5, will give 62⁵ = ~916 Million URLs
URL with length 6, will give 62⁶ = ~56 Billion URLs
URL with length 7, will give 62⁷ = ~3500 Billion URLs
    * */
    public static void main(String[] args) {
        int id = 63;//12345;
        map = prePareMap();
        String result = idToShortUrl(id);
        System.out.println(result);
        System.out.println(shortUrlToId(result));
        System.out.println(shortUrlToIdBase62(result));

        long longId = 999999999;
        System.out.println("long ID : " + idToShortUrLongID(longId));

        NUM_CHARS_SHORT_LINK = 7;
    }


    /*
     * https://medium.com/@sandeep4.verma/system-design-scalable-url-shortener-service-like-tinyurl-106f30f23a82
     * */
    public String generateRandomShortUrl() {

        char[] result = new char[NUM_CHARS_SHORT_LINK];
        //  while (true) {
        for (int i = 0; i < NUM_CHARS_SHORT_LINK; i++) {
            int randomIndex = random.nextInt(constCharArr.length - 1);
            result[i] = constCharArr[randomIndex];
        }
        String shortLink = new String(result);
        // make sure the short link isn't already used
           /* if (!DB.checkShortLinkExists(shortLink)) {
                return shortLink;;
            }*/
        //  }
        return shortLink;
    }


    private static Map<Character,Integer> prePareMap() {
        Map<Character,Integer> baseMap = new HashMap<>();
        for (int i=0;i<constCharArr.length;i++) {
            baseMap.put(constCharArr[i], i);
        }
        return baseMap;
    }

    /*
    * dnh
    * */
    public static int shortUrlToId(String url){
        int id=0;
        char charVal;
        for(int i=0;i<url.length();i++){
            charVal = url.charAt(i);
            if(charVal >= 'a' && charVal <= 'z'){
                id = id* constCharArr.length+(charVal-'a');
            }else if(charVal >= 'A' && charVal <= 'Z'){
                id = id* constCharArr.length+(charVal-'A') + 26;
            }else if(charVal >= '0' && charVal <= '9'){
                id = id* constCharArr.length+(charVal-'0') + 52;
            }
        }
        return id;
    }

    /*
    * TC O(nLogN)
    * */
    public static int shortUrlToIdBase62(String url){
        int id=0;
        char charVal;
        int len = url.length()-1;
        for(int i = len;i>=0;i--){
            charVal = url.charAt(i);
            id += Math.pow(constCharArr.length,len-i)* map.get(charVal); //logn
        }
        return id;
    }

    public static String idToShortUrl(int id){
        StringBuilder sb = new StringBuilder();
        int len = constCharArr.length;
        while (id>0){
            sb.append(constCharArr[id%len]);
            id/=len;
        }
        return sb.reverse().toString();
    }
    public static String idToShortUrLongID(long id){
        StringBuilder sb = new StringBuilder();
        long len = constCharArr.length;
        int rem;
        while (id>0){
            rem = (int) (id%len);
            sb.append(constCharArr[rem]);
            id/=len;
        }
        return sb.reverse().toString();
    }
}
