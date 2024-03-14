package isp.lab2.Exercise1RandomArray;

import java.util.Random;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        Random element = new Random();
        for (int i=0; i<n; i++) {
            array[i] = element.nextInt(100);
        }
        return array;
    }

    public static int[] findMaxAndMin(int[] array) {
        int[] mm = new int[2];
        mm[0] = 100;
        mm[1] = -1;
        for (int j = 0; j < array.length; j++){
            if(array[j]>mm[1])
                mm[1] = array[j];
            if(array[j] < mm[0])
                mm[0] = array[j];
        }
        return mm;
    }

    public static void main(String[] args) {

        Random random = new Random();

        //genereaza numar random intre 10 si 100
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size);
        int[] mm = findMaxAndMin(a);
        System.out.println("Min is:"+mm[0]+" Max is:"+mm[1] );
    }
}
