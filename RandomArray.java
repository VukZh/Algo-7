package radixsort;

import static java.lang.Math.random;

//import static java.lang.Math.random;
public class RandomArray {

    private final int[] arr;
    private final int size;

    RandomArray(int minnumber, int maxnumber, int sizeArray) {
        size = sizeArray;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (minnumber + (int) (random() * (maxnumber - minnumber + 1)));
//            arr[i] = i * ((maxnumber - minnumber)/size);
        }
    }

    void display() {
        System.out.println("Array:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            System.out.print(" | ");
        }
        System.out.println();
    }

    int[] getArray() {
        return arr;
    }

}
