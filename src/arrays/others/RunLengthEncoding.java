package arrays.others;

/*
* input : aabbcc
* output : a2b2c2
* */
public class RunLengthEncoding {

    public String charEncoding(String str){
        if(str == null || str.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int c = 1;
        int i = 0;
        int j = 0;
        while (i < str.length()){
            c = 1;
            j = i+1;
            while ((j<str.length()) && str.charAt(i) == str.charAt(j)){
                c++;
                j++;
            }
            sb.append(str.charAt(i));
            sb.append(c);
            i = j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aabbcc";
        /*char [] arr = {'c','b'};
        str = String.valueOf(arr);*/
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        System.out.println(runLengthEncoding.charEncoding(str));
    }
}
