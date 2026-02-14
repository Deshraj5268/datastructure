package stack;

public class ValidParaExtendedProblem {

    public static void main(String[] args) {
        String [] inputs = {"()", "(*)", "((*", "(*)(())"};
        for(int i = 0;i < inputs.length;i++){
            System.out.println("input : "+inputs[i] + " is valid : "+checkValidString(inputs[i]));
        }
    }


    /*
 just like matching para using count '(' para if zero then fine otherwise return false if negative
   maxOpen = 0
   minOpen = 0
   loop
   if '(' then inc both
   else if ')' then dec both
   else *
    maxOpne++ , minOpen--

    if(maxOpen < 0) at any point that means no possible matching para
    minOpne = Math.max(minOpen , 0); // reset
    end loop
    return minOpen == 0 ;

   */
    public static boolean checkValidString(String s) {
        int maxOpen = 0;
        int minOpen = 0;
        int len = s.length();
        char para;
        for(int i = 0;i < len;i++){
            para = s.charAt(i);
            if(para == '('){
                maxOpen++;
                minOpen++;
            }else if(para == ')'){
                maxOpen--;
                minOpen--;
            }else {
                minOpen--;
                maxOpen++;
            }

            if(maxOpen < 0){
                return false;
            }
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
}
