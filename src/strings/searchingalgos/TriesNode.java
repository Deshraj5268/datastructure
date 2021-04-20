package strings.searchingalgos;

import java.util.HashMap;
import java.util.Map;

public class TriesNode {

    Map<Character,TriesNode> children;
    boolean endOfWord;

    public TriesNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}
