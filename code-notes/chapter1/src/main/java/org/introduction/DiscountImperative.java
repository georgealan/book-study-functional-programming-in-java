package org.introduction;
import static org.introduction.Prices.prices;

public class DiscountImperative {
  public static void main(final String[] args) {
    double totalDiscountPrices = 0.0;

    for (int price : prices) {
      if (price > 20) {
        totalDiscountPrices += price * 0.9;
      }
    }
    System.out.println("Total of discounted prices: " + totalDiscountPrices);
  }
}
