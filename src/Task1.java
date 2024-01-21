import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        int[] array = vvod();


        Thread minThread = new Thread(() -> {
            int min = findMin(array);
            System.out.println("Минимум: " + min);
        });

        Thread maxThread = new Thread(() -> {
            int max = findMax(array);
            System.out.println("Максимум: " + max);
        });


        minThread.start();
        maxThread.start();


        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Работа завершена.");
    }


    private static int[] vvod() {

        System.out.print("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();


        int[] array = new int[size];
        System.out.println("Введите элементы массива:");

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }


    private static int findMin(int[] array) {
        int min = array[0];

        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }


    private static int findMax(int[] array) {
        int max = array[0];

        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
}
