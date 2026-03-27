import jdk.jshell.spi.SPIResolutionException;

public class bella {
    public static void main(String[] args){
        double fp, tp, precision;

        tp = 90;
        fp = 5;

        precision = tp / (tp + fp);

        if (precision > 0.8 && precision <= 1){
            System.out.print("Sangat Presisi");
        } else if (precision > 0.6 && precision <= 0.9){
            System.out.print("Presisi");
        } else if (precision >=0 && precision <= 0.7) {
            System.out.print("Tidak Presisi");
        } else{
            System.out.print("Nilai Tidak Valid");
        }
    }
}
