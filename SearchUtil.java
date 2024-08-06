package coursework;

import java.util.ArrayList;

public class SearchUtil {
    public static Order linearSearch(ArrayList<Order> orders, int orderId) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
}
