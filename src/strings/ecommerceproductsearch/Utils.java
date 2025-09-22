package strings.ecommerceproductsearch;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {

    private Utils(){

    }

    public static boolean strictMatch(String text , String search){
        String [] strArr = text.split("\\s+");
        int i=0;
        int m,n = search.trim().length();
        for (String str : strArr){
            m = str.trim().length();
            if(m == n){
                while (i< n && str.charAt(i) == search.charAt(i)){
                    i++;
                }
                if(i== n){
                    return true;
                }
            }

        }
        return false;
    }

    public static Set<String> tokenizer(String word, String splitWay){
       return Arrays.stream(word.toLowerCase().split(splitWay)).filter(s->!s.isEmpty()).collect(Collectors.toSet());
    }
}
