package org.introduction;

import static org.introduction.Prices.prices;
public class DiscountFunctional {
  public static void main(String[] args) {
    final double totalOfDiscountedPrices =
        prices.stream()
            .filter(price -> price > 20)
            .mapToDouble(price -> price * 0.9)
            .sum();

    System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
  }
}
