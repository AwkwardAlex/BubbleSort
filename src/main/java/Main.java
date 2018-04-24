public class Main {

    private static final int THOUSAND = 1000;
    private static final int TEN_THOUSAND = 10000;
    private static final int HUNDRED_THOUSAND = 100000;
    private static final int MILLION = 1000000;


    public static void main(String[] args) {

        Sort.compareSort(new int[THOUSAND]);
        Sort.compareSort(new int[TEN_THOUSAND]);
        Sort.compareSort(new int[HUNDRED_THOUSAND]);
        Sort.compareSort(new int[MILLION]);
    }
}
