package strings.searchingalgos;

public class TriesDriver {

    public static void main(String[] args) {
        TriesTree triesTree = new TriesTree(new TriesNode());
        String data = "apple";
        String prefixSearch = "app";
        triesTree.insert(data);
        System.out.println("search word :"+data+ " found "+ triesTree.searchKey("apple"));
        System.out.println("start with : "+prefixSearch+" result : "+triesTree.startsWith(prefixSearch));
    }
}
