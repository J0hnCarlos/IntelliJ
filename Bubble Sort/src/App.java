public class App {
    public static void main(String[] args){
        int a[] = {70, 61, 83, 38};
        int b[] = {7, 2, 76, 4, 99};

        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(a);
        bs.bubbleSort(b);

        bs.printArray(a);
    }
}
