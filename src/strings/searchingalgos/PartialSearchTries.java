package strings.searchingalgos;

public class PartialSearchTries {

    /*
    * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
    * */
    public static void main(String[] args) {

        String [] data = {"bad","dad","pad","mad"};
        String [] searchData = {"mad","b..","b.d","..d"};
        TriesTree triesTree = new TriesTree(new TriesNode());

        for(int i=0;i<data.length;i++) {
            triesTree.insert(data[i]);
        }
        for(int i=0;i<searchData.length;i++) {
            System.out.println("input : "+searchData[i]);
            boolean result = triesTree.partialSearch(searchData[i]);
            System.out.println("result :"+result);
        }
    }
}
