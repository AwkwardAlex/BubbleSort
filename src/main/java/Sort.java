public class Sort implements Runnable {

    private int[] array;
    private int threadNumber;
    private static final int ZERO = 0;

    private Sort(int[] array, int threadNumber) {
        this.array = array;
        this.threadNumber = threadNumber;
    }

    private static void bubbleSort(int[] numArray, int start, int end) {
        boolean run = true;
        int temp;

        while (run) {
            run = false;
            for (int i = start; i < end - 1; i++) {
                if (numArray[i] > numArray[i + 1]) {
                    temp = numArray[i];
                    numArray[i] = numArray[i + 1];
                    numArray[i + 1] = temp;
                    run = true;
                }
            }
        }
    }

    public void run() {
        int split = array.length / 2;
        if (threadNumber == 1) {
            bubbleSort(array, ZERO, split);
        } else {
            bubbleSort(array, split, array.length);
        }
    }

    public static void compareSort(int[] array) {
        fillArray(array);
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        long start = System.nanoTime();
        bubbleSort(array, ZERO, array.length);
        long end = System.nanoTime();
        System.out.println("It took - " + (end - start) + " nanoseconds to sort an array with "
                + array.length + " integers, with bubble sort.");
        start = System.nanoTime();
        threadSort(arrayCopy);
        end = System.nanoTime();
        System.out.println("It took - " + (end - start) + " nanoseconds to sort an array with "
                + arrayCopy.length + " integers, with the use of threads.");
    }

    private static void threadSort(int[] array) {
        Thread thread1 = new Thread(new Sort(array, 1));
        Thread thread2 = new Thread(new Sort(array, 2));
        thread1.start();
        thread2.start();
        bubbleSort(array, ZERO, array.length);
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
    }
}
