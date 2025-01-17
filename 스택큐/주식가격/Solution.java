import java.util.*;

public class Solution {     // 복잡도 - O(n2)
    public int[] solution(int[] prices) {
        Queue<ProductPrice> priceQueue = new ArrayDeque<>();  // 각 주식의 location 별 가격 정보 -> 끝까지 갔을 때 몇초간 값이 유지 됐는지?
        int[] graph = new int[prices.length];
        int chart;

        for (int i = 0; i < prices.length; i++) {
            priceQueue.offer(new ProductPrice(prices[i], i));
        }
        while (!priceQueue.isEmpty()) {
            ProductPrice currentPrice = priceQueue.poll();  // 순차적으로.. 맨 앞 주식 정보부터 팝
            chart = 0;
            //System.out.println("currentPrice = " + currentPrice);

            // 앞부터 끝까지 값은 계속 비교 해야하고, 비교하면서 감소하지 않으면 타임에 ++ 해줘야함, 감소하면 ++하고 스톱
            for (ProductPrice product : priceQueue) {
                if (currentPrice.price <= product.price) {
                    chart++;
                }
                if (currentPrice.price > product.price) {
                    chart++;
                    break;
                }
                //System.out.println("product = " + product + "chart =" + chart);
            }
            graph[currentPrice.location] = chart;
            //System.out.println("chart = " + chart);
        }
        System.out.println(getClass().getSimpleName()+ " = " + Arrays.toString(graph));
        return graph;
    }

    public class ProductPrice {
        public int price;
        public int location;

        public ProductPrice(int price, int location) {
            this.price = price;
            this.location = location;
        }

        @Override
        public String toString() {
            return "ProductPrice{" +
                    "price=" + price +
                    ", location=" + location +
                    '}';
        }
    }

}
