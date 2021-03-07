package strings.searchingalgos;


public class TriesTree {

    TriesNode root;

    public TriesTree(TriesNode root){
        this.root = root;
    }

    public void insert(String key){
        TriesNode current = root;
        TriesNode temp;
        for(int i=0;i<key.length();i++){
            temp = current.children.get(key.charAt(i));
            if(temp == null){
                current.children.put(key.charAt(i),new TriesNode());
            }
            current = temp;
        }
        //end of word
        current.endOfWord = true;
    }

    public boolean searchKey(String key){
        TriesNode current = root;
        TriesNode temp;
        for(int i=0;i<key.length();i++){
            temp = current.children.get(key.charAt(i));
            if(temp == null) {
                return false;
            }
            current = temp;
        }
        return current.endOfWord;
    }
}
