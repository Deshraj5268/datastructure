package strings;

public class TinyUrl {

    protected static final char [] constCharArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    public static void main(String[] args) {
        int id = 12345;
        String result = idToShortUrl(id);
        System.out.println(result);
        System.out.println(shortUrlToId(result));
    }

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

    public static String idToShortUrl(int id){
        StringBuilder sb = new StringBuilder();
        int len = constCharArr.length;
        while (id>0){
            sb.append(constCharArr[id%len]);
            id/=len;
        }
        return sb.reverse().toString();
    }
}
