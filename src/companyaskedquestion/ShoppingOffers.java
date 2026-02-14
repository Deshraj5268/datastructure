package companyaskedquestion;

import java.util.*;

public class ShoppingOffers {

    Map<List<Integer>, Integer> dp = new HashMap<>(); // for DP


    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 5);

        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(3, 0, 5));  // offer1: 3 of item0, 0 of item1, price = 5
        special.add(Arrays.asList(1, 2, 10)); // offer2

        List<Integer> needs = Arrays.asList(3, 2);

        ShoppingOffers sol = new ShoppingOffers();
        int result = sol.shoppingOffers(price, special, needs);

        System.out.println("Minimum Cost = " + result);
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, new HashMap<>());
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
                    Map<List<Integer>, Integer> memo) {

        if (memo.containsKey(needs)) return memo.get(needs);

        int n = price.size();
        int cost = 0;

        // Cost without any offer → buy all remaining individually
        for (int i = 0; i < n; i++) {
            cost += needs.get(i) * price.get(i);
        }

        // Try each special offer
        for (List<Integer> offer : special) {
            List<Integer> nextNeeds = new ArrayList<>();
            boolean valid = true;

            // Check if offer can be applied
            for (int i = 0; i < n; i++) {
                if (offer.get(i) > needs.get(i)) {
                    valid = false;   // can't apply — exceeds need
                    break;
                }
                nextNeeds.add(needs.get(i) - offer.get(i));
            }

            if (valid) {
                cost = Math.min(cost,
                        offer.get(n) + dfs(price, special, nextNeeds, memo));
            }
        }

        memo.put(needs, cost);
        return cost;
    }

    public int shoppingOffersDP(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return solve(price, special, needs);
    }

    private int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (dp.containsKey(needs)) return dp.get(needs);

        int n = price.size();
        int best = 0;

        // Cost without special offers
        for (int i = 0; i < n; i++) best += needs.get(i) * price.get(i);

        // Try every offer
        for (List<Integer> off : special) {
            boolean valid = true;
            List<Integer> next = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (off.get(i) > needs.get(i)) { valid = false; break; }
                next.add(needs.get(i) - off.get(i));
            }

            if (valid) {
                best = Math.min(best, off.get(n) + solve(price, special, next));
            }
        }

        dp.put(needs, best);
        return best;
    }

}
