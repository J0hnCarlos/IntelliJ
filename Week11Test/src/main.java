public class main {
    public static void main(String[] args){
        int x[] = {6,5,9,6,5,5,6,5};
        int y[] = {6,5};
        int z = 0;

        for (int i = 0; i<x.length-y.length+1; i++){
            int m = 0;
            for (int j = 0; j<y.length; j++){
                if (x[i+j] == y[j]){
                    m++;
                }

                if (m == y.length){
                    z++;
                }
            }
        }

        System.out.print(z);
    }
}
