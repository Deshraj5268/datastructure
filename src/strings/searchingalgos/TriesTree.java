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
                temp = new TriesNode();
                current.children.put(key.charAt(i),temp);
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

    public boolean startsWith(String prefix) {
        TriesNode currentNode=this.root,temp;
        char ch;
        for(int i=0;i<prefix.length();i++){
            ch = prefix.charAt(i);
            temp = currentNode.children.get(ch);
            if(temp == null){
                return false;
            }
            currentNode = temp;
        }
        return true;
    }

    public boolean partialSearch(String word) {
        return searchHelper(word,root,0);

    }

    public boolean searchHelper(String word,TriesNode currentNode,int index){
        TriesNode temp;
        char ch;
        for(int i=index;i<word.length();i++){
            ch = word.charAt(i);
            if(ch == '.' ){
                for(TriesNode entry : currentNode.children.values()){
                    if(entry != null && searchHelper(word,entry,i+1)){
                        return true;
                    }
                }
                return false;
            }else{
                temp = currentNode.children.get(ch);
                if(temp == null){
                    return false;
                }
                currentNode = temp;
            }
        }
        return currentNode.endOfWord;
    }
}
