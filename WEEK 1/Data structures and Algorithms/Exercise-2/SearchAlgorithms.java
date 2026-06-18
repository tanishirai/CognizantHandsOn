public class SearchAlgorithms {

    // Linear Search
    // Goes through the array one element at a time until a match is found.
    // Works on both sorted and unsorted arrays.
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i; // index of the matching product
            }
        }
        return -1; // not found
    }

    // Binary Search
    // Repeatedly cuts the search range in half by checking the middle element.
    // Only works correctly if the array is sorted by productId.
    public static int binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return mid;
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // not found
    }
}