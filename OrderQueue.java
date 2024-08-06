package coursework;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private Queue<Order> queue;

    public OrderQueue() {
        queue = new LinkedList<>();
    }

    public void offer(Order order) {
        queue.add(order);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
