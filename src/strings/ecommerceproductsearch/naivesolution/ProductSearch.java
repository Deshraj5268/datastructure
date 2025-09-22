package strings.ecommerceproductsearch.naivesolution;

import strings.ecommerceproductsearch.Product;
import strings.ecommerceproductsearch.SearchProduct;
import strings.ecommerceproductsearch.SearchResult;
import strings.ecommerceproductsearch.Utils;

import java.util.ArrayList;
import java.util.List;

public class ProductSearch implements SearchProduct {

    private List<Product> products;

    public ProductSearch(List<Product> products){
        this.products = products;
    }

    /*
    * O(n * k * m + n log n)
     If you treat k and m as small constants, then it's O(n log n) in practice.
    * */
    @Override
    public List<SearchResult> search(String query){
        String normalizedQuery = query.toLowerCase();
        String[] queryWords = normalizedQuery.split("\\s+");
        int matchWordCount = 0;
        int matchedChars = normalizedQuery.replaceAll(" ", "").length();
        List<SearchResult> results = new ArrayList<>();

        for (Product product : products) {
            String productName = product.getName().toLowerCase();
            matchWordCount=0;
            for (String word : queryWords) {
                if (Utils.strictMatch(productName, word)) {
                    matchWordCount++;
                }
            }

            if (matchWordCount == queryWords.length) {
                int totalChars = productName.replace(" ", "").length(); // exclude spaces
                int score = (int) ((matchedChars * 100.0) / totalChars);
                results.add(new SearchResult(product.getId(), product.getName(), score));
            }
        }

        // Sort: higher score first, then by name
        results.sort((a, b) -> {
            int score = Double.compare(b.getScore(), a.getScore());
            if (score == 0){
                return a.getName().compareToIgnoreCase(b.getName());
            }
            return score;
        });

        return results;
    }
}
