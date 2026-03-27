public class Week3Ques4a {

    public static void main(String[] args){
//        int[] number = new int[5];
//        number[0] = 1;
//        number[1] = 2;
//        number[2] = 3;
//        number[3] = 4;
//        number[4] = 5;
//
//        int n = 5;
//        while(n > 0){
//            for(int i = 0; i < n; i++){
//                System.out.print(number[i]);
//            }
//
//            System.out.println("");
//            n--;
//        }
//
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//
//        n = 1;
//
//        int[] number2 = new int[5];
//
//        number2[0] = 5;
//        number2[1] = 4;
//        number2[2] = 3;
//        number2[3] = 2;
//        number2[4] = 1;
//
//        while (n < 6){
//            for(int i = 0; i < n; i++){
//                System.out.print(number2[i]);
//            }
//
//            System.out.println("");
//            n++;
//        }
//
//        n = 0;
//
//        while (n < 6) {
//            for (int i = 0; i < n; i++) {
//                System.out.print("*");
//            }
//
//            System.out.println("");
//            n++;
//        }
        for(int i = 1; i <= 100; i++){
            if(i % 10 != 0){
                System.out.print(i + " ");
            } else {
                System.out.println(i + " ");
            }
        }
    }
}