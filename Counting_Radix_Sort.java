package radixsort;

import static java.lang.Math.abs;

public class Counting_Radix_Sort { // Сортировка подсчётом с возможностью сортировки отрицательных чисел

    private int[] arr;
    private final int range;
    private int minElement, maxElement;
    private int dig = 0; // разрядность чисел в массиве

    Counting_Radix_Sort(int[] a) {
        arr = a;
        minElement = arr[0];
        maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) { // поиск минимум и максимума массива, определение диапазона значений
            if (minElement > arr[i]) {
                minElement = arr[i];
            }
            if (maxElement < arr[i]) {
                maxElement = arr[i];
            }
        }
        range = maxElement - minElement + 1;
//        System.out.println("minElement " + minElement + " maxElement " + maxElement + " range " + range);

    }

    int Digits() {         // число разрядов в числах массива
        int min = minElement;
        int max = maxElement;
        if (abs(max) > abs(min)) {
            while (max != 0) {
                dig++;
                max = max / 10;
            }
        } else {
            while (min != 0) {
                dig++;
                min = min / 10;
            }
        }
        return dig;
    }

    void SimpleCountingSort() { // Простая сортировка подсчётом 
        int[] Counts = new int[range];
        for (int i = 0; i < arr.length; i++) {
            Counts[arr[i] - minElement] = Counts[arr[i] - minElement] + 1;
        }
        int j = 0;
        for (int i = 0; i < range; i++) {
            for (int k = 0; k < Counts[i]; k++) {
                arr[j] = i + minElement;
                j++;
            }
        }
    }

    void CountingSort(Integer... args) {  // Устойчивая сортировка подсчётом
        int d;
        int dec; // разряд
        if (args.length != 0) { // настройки для поразрядной сортировки
            d = args[0];
            dec = 10;
        } else {   //  настройки для сортировки подсчетом без поразрядной сортировки
            d = 1;
            dec = (int) Math.pow(10, Digits());
        }

        int[] Counts = new int[range];
        int[] arrRes = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            Counts[arr[i] / d % dec - minElement] = Counts[arr[i] / d % dec - minElement] + 1;
        }
        for (int i = 1; i < range; i++) {
            Counts[i] = Counts[i] + Counts[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            Counts[arr[i] / d % dec - minElement] = Counts[arr[i] / d % dec - minElement] - 1;
            arrRes[Counts[arr[i] / d % dec - minElement]] = arr[i];
        }
        arr = arrRes;

    }

    void RadixSort() {
        for (int exp = 1; maxElement / exp > 0; exp *= 10) {
            CountingSort(exp);
//            display();            
        }
    }

    void display() {
        System.out.println("CountingSortArray:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" | ");
        }
        System.out.println();
    }

}
