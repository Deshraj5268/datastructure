package arrays.others;

/*
* input : aabbcc
* output : a2b2c2
* */
public class RunLengthEncodding {

    public String charEncodding(String str){
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
            i = (i+1)+(j-1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aabbcc";
        /*char [] arr = {'c','b'};
        str = String.valueOf(arr);*/
        RunLengthEncodding runLengthEncodding = new RunLengthEncodding();
        System.out.println(runLengthEncodding.charEncodding(str));
    }
}
