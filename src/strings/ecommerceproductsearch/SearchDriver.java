package strings.ecommerceproductsearch;

import strings.ecommerceproductsearch.elasticSearchway.FullTextSearch;
import strings.ecommerceproductsearch.naivesolution.ProductSearch;

import java.util.Arrays;
import java.util.List;

public class SearchDriver {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Amul milk"),
                new Product(2, "Nandini Chocolate Milk"),
                new Product(3, "Milk Chocolate"),
                new Product(4, "Chocolate Milk"),
                new Product(5, "Milky Way Chocolate Bar")
        );

        String [] searchKeywords = {"Milk", "Chocolate Milk"};
       bruteForceSearch(products,searchKeywords);

        // elastic search way

        elasticSearch(products, searchKeywords);
    }

    private static void elasticSearch(List<Product> products, String [] searchKeywords) {
        FullTextSearch fullTextSearch = new FullTextSearch();

        for (Product product : products){
            fullTextSearch.indexProduct(product);
        }
        System.out.println("using elastic search way");
        for(String searchKeyWord : searchKeywords) {
            System.out.println("Search: "+"'"+searchKeyWord+"'");
            fullTextSearch.search(searchKeyWord).forEach(System.out::println);
        }
    }

    private static void bruteForceSearch(List<Product> products, String [] searchKeywords) {
        SearchProduct searchProduct = new ProductSearch(products);
        for(String searchKeyWord : searchKeywords) {
            System.out.println("Search: "+"'"+searchKeyWord+"'");
            searchProduct.search(searchKeyWord).forEach(System.out::println);
        }
    }
}
