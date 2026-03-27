public class BubbleSort {
    int length;
    int[] var;

    public void bubbleSort(int x[]){

        length = x.length;
        int swap;
        for(int i = 0; i < length - 1; i++){
            for(int j = 0; j < length - i - 1; j++){
                if (x[j] > x[j+1]){
                    swap = x[j];
                    x[j] = x[j+1];
                    x[j+1] = swap;
                }
            }
        }

        var = x;
    }

    public void printArray(int sortedArray[]){
        int n = sortedArray.length;
        for (int i = 0; i < n; i++){
            System.out.print(sortedArray[i] + " ");
        }
    }
}
