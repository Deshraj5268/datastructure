package strings.ecommerceproductsearch.elasticSearchway;

import strings.ecommerceproductsearch.Product;
import strings.ecommerceproductsearch.SearchProduct;
import strings.ecommerceproductsearch.SearchResult;
import strings.ecommerceproductsearch.Utils;

import java.util.*;

public class FullTextSearch implements SearchProduct {

    private static String splitWay = "\\s+";
    private Map<Integer, Product> productMap = new HashMap<>();
    private Map<Integer, Set<String>> productTokens = new HashMap<>();
    private Map<String, Set<Integer>> invertedIndexMap = new HashMap<>();

    public void indexProduct(Product product){
        productMap.put(product.getId(), product);
        Set<String> tokens = Utils.tokenizer(product.getName(), splitWay);

        productTokens.put(product.getId() , tokens);
        for (String token : tokens){
            invertedIndexMap.computeIfAbsent(token, k->new HashSet<>()).add(product.getId());
        }
    }


    public List<SearchResult> search(String query){
        Set<String> queryTokenSet = Utils.tokenizer(query, splitWay);
        int queryCountChar = query.replaceAll(splitWay, "").length();
        int totalWords = queryTokenSet.size();
        double score = 0.0;
        int productId;
        int matchCount = 0;

        Map<Integer, Integer> matchIdCountMap = new HashMap<>(); // Id --> count

        for (String searchToken : queryTokenSet){
            Set<Integer> matchedIdsSet = invertedIndexMap.get(searchToken); // elastic search index way

            for(int id : matchedIdsSet){
                matchIdCountMap.put(id, matchIdCountMap.getOrDefault(id, 0)+1);
            }
        }
        List<SearchResult> result = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : matchIdCountMap.entrySet()){
            productId = entry.getKey();
            matchCount = entry.getValue();
            if(totalWords == matchCount){ // all keyword should match 'Chocolate Milk'
                score = (queryCountChar * 100.0)/(productMap.get(productId).getName().replaceAll(splitWay, "").length());
                result.add(new SearchResult(productId, productMap.get(productId).getName(), score));
            }
        }

        result.sort(Comparator.comparing(SearchResult::getScore, Comparator.reverseOrder())
                .thenComparing(SearchResult::getName));
        return result;
    }
}
