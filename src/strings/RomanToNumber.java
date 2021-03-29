package strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumber {

    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) { //M is worst case 10^4 ,str lenth(10^6) : 10^4*10^6=10^10(in range )
        // code here
        if(str == null || str.isEmpty()){
            return -1;
        }
        Map<Character,Integer> map = romanToDecimalMapping();

        Integer currentSum = 0;
        Integer nextVal;
        Integer currentCharVal;
        for(int i=0;i<str.length();i++){
            currentCharVal = map.get(str.charAt(i));
            if(currentCharVal == null){
                return -1;
            }
            if(i+1<str.length()){

                nextVal = map.get(str.charAt(i+1));
                if(nextVal == null){
                    return -1;
                }
                if(currentCharVal >= nextVal){
                    currentSum+=currentCharVal;
                }else{
                    currentSum += (nextVal - currentCharVal);
                    i++;
                }

            }else{
                currentSum+=currentCharVal;
            }
        }
        return currentSum;

    }

    public Map<Character,Integer> romanToDecimalMapping(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }
}
