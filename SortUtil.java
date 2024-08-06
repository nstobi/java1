package coursework;

import java.util.ArrayList;
import java.util.Comparator;

public class SortUtil {

    // Sorts products by name using insertion sort
    public static void sortByName(ArrayList<Product> products) {
        insertionSort(products, Comparator.comparing(Product::getName));
    }
    
    // Sorts products by price using insertion sort
    public static void sortByPrice(ArrayList<Product> products) {
        insertionSort(products, Comparator.comparingDouble(Product::getPrice));
    }

    // Sorts products by author using insertion sort
    public static void sortByAuthor(ArrayList<Product> products) {
        insertionSort(products, Comparator.comparing(Product::getAuthor));
    }

    // Generic insertion sort method
    private static <T> void insertionSort(ArrayList<T> list, Comparator<? super T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            T currentElement = list.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(list.get(j), currentElement) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, currentElement);
        }
    }
}
