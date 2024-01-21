import java.util.Arrays;
import java.util.Random;

public class Task2 {

    public static void main(String[] args) {
        int[] array = generateRandomArray(10);


        Thread insertionSortThread = new Thread(() -> {
            int[] sortedArray = insertionSort(Arrays.copyOf(array, array.length));
            System.out.println("Сортировка вставками: " + Arrays.toString(sortedArray));
        });

        Thread selectionSortThread = new Thread(() -> {
            int[] sortedArray = selectionSort(Arrays.copyOf(array, array.length));
            System.out.println("Сортировка выбором: " + Arrays.toString(sortedArray));
        });

        Thread bubbleSortThread = new Thread(() -> {
            int[] sortedArray = bubbleSort(Arrays.copyOf(array, array.length));
            System.out.println("Сортировка пузырьком: " + Arrays.toString(sortedArray));
        });


        insertionSortThread.start();
        selectionSortThread.start();
        bubbleSortThread.start();
    }


    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));
        return array;
    }


    private static int[] insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
        return array;
    }


    private static int[] selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }


    private static int[] bubbleSort(int[] array) {
        int lengthA = array.length;
        for (int i = 0; i < lengthA - 1; i++) {
            for (int j = 0; j < lengthA - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }
        return array;
    }
}
