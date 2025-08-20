package strings.consecutiveremoval;


//https://www.geeksforgeeks.org/dsa/recursively-remove-adjacent-duplicates-given-string/#naive-approach-on2-time-and-on-space
//https://www.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1
public class ConsecutiveRemovalRecursively {
    public static void main(String[] args) {
        String [] str = {"geeksforgeek", "abccbccba", "abcd"};
        for (String s: str) {
            String rs = removeUtil(s);
            System.out.println("".equals(rs) ? "nothing is left":rs);
        }
    }

    public static String removeUtil(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++){
            boolean isRepeated = false;
            while (i+1 < n && s.charAt(i) == s.charAt(i+1)){
                isRepeated = true;
                i++;
            }
            if(!isRepeated){
                sb.append(s.charAt(i));
            }
        }
        if(sb.length() == s.length()){
            return sb.toString();
        }
        return removeUtil(sb.toString());
    }
}
