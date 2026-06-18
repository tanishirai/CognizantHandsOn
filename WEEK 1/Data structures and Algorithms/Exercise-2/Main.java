import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        // Sample product catalog, added in the order products were created (unsorted)
        Product[] catalog = {
                new Product(105, "Wireless Mouse", "Electronics"),
                new Product(102, "Yoga Mat", "Fitness"),
                new Product(110, "Bluetooth Speaker", "Electronics"),
                new Product(101, "Running Shoes", "Footwear"),
                new Product(108, "Office Chair", "Furniture"),
                new Product(103, "Coffee Maker", "Appliances"),
                new Product(107, "Backpack", "Accessories"),
                new Product(104, "LED Desk Lamp", "Furniture"),
                new Product(106, "Notebook Set", "Stationery"),
                new Product(109, "Phone Case", "Accessories")
        };

        // Sorted copy of the catalog (sorted by productId), required for binary search
        Product[] sortedCatalog = catalog.clone();
        Arrays.sort(sortedCatalog, Comparator.comparingInt(Product::getProductId));

        System.out.println("---- Original Catalog (used for Linear Search) ----");
        for (Product p : catalog) {
            System.out.println(p);
        }

        System.out.println("\n---- Sorted Catalog (used for Binary Search) ----");
        for (Product p : sortedCatalog) {
            System.out.println(p);
        }

        // One ID that exists, one that doesn't
        int existingId = 107;
        int missingId = 200;

        System.out.println("\n---- Linear Search ----");
        runLinearSearch(catalog, existingId);
        runLinearSearch(catalog, missingId);

        System.out.println("\n---- Binary Search ----");
        runBinarySearch(sortedCatalog, existingId);
        runBinarySearch(sortedCatalog, missingId);

        // Performance comparison on a much larger catalog
        comparePerformance();
    }

    private static void runLinearSearch(Product[] products, int targetId) {
        long start = System.nanoTime();
        int index = SearchAlgorithms.linearSearch(products, targetId);
        long end = System.nanoTime();

        if (index != -1) {
            System.out.println("Found -> " + products[index] + " | Time: " + (end - start) + " ns");
        } else {
            System.out.println("Product with ID " + targetId + " not found | Time: " + (end - start) + " ns");
        }
    }

    private static void runBinarySearch(Product[] sortedProducts, int targetId) {
        long start = System.nanoTime();
        int index = SearchAlgorithms.binarySearch(sortedProducts, targetId);
        long end = System.nanoTime();

        if (index != -1) {
            System.out.println("Found -> " + sortedProducts[index] + " | Time: " + (end - start) + " ns");
        } else {
            System.out.println("Product with ID " + targetId + " not found | Time: " + (end - start) + " ns");
        }
    }

    // Generates a large sorted catalog and times both algorithms on a worst-case search
    private static void comparePerformance() {
        int size = 100000;
        Product[] bigCatalog = new Product[size];

        for (int i = 0; i < size; i++) {
            bigCatalog[i] = new Product(i, "Product" + i, "Category" + (i % 10));
        }
        // bigCatalog is already sorted by productId since it was generated in order

        int searchId = size - 1; // last element = worst case for linear search

        long startLinear = System.nanoTime();
        SearchAlgorithms.linearSearch(bigCatalog, searchId);
        long endLinear = System.nanoTime();

        long startBinary = System.nanoTime();
        SearchAlgorithms.binarySearch(bigCatalog, searchId);
        long endBinary = System.nanoTime();

        System.out.println("\n---- Performance on " + size + " products (worst case search) ----");
        System.out.println("Linear Search time: " + (endLinear - startLinear) + " ns");
        System.out.println("Binary Search time: " + (endBinary - startBinary) + " ns");
    }
}