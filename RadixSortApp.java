package radixsort;

import java.util.Arrays;

public class RadixSortApp {

    public static void main(String[] args) {

        RandomArray ra = new RandomArray(-5000, 5000, 1000000);
//        ra.display();
        int[] RandomArray = ra.getArray();
        int RandomArray2[] = Arrays.copyOf(RandomArray, RandomArray.length);
        int RandomArray3[] = Arrays.copyOf(RandomArray, RandomArray.length);

        Counting_Radix_Sort radix = new Counting_Radix_Sort(RandomArray);
        System.out.println("------------");
        long timeStartA1 = System.currentTimeMillis();
        radix.RadixSort();
        long timeStopA1 = System.currentTimeMillis() - timeStartA1;
        System.out.println("время выполнения поразрядной сортировки " + timeStopA1 + " миллисекунд");
//        radix.display();

        Counting_Radix_Sort counting = new Counting_Radix_Sort(RandomArray2);
        System.out.println("------------");
        long timeStartA2 = System.currentTimeMillis();
        counting.CountingSort();
        long timeStopA2 = System.currentTimeMillis() - timeStartA2;
        System.out.println("время выполнения сортировки подсчетом " + timeStopA2 + " миллисекунд");
//        counting.display();

        Counting_Radix_Sort simple_counting = new Counting_Radix_Sort(RandomArray3);
        System.out.println("------------");
        long timeStartA3 = System.currentTimeMillis();
        simple_counting.SimpleCountingSort();
        long timeStopA3 = System.currentTimeMillis() - timeStartA3;
        System.out.println("время выполнения простой сортировки подсчетом " + timeStopA3 + " миллисекунд");
//        counting.display();

    }

}
