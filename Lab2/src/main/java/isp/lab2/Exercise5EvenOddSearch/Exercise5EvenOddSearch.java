package isp.lab2.Exercise5EvenOddSearch;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {

        String[] num = input.split(",");
        int[] numbers = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            numbers[i] = Integer.parseInt(num[i]);
        }

        int largestEven = Integer.MIN_VALUE;
        int smallestOdd = Integer.MAX_VALUE;
        int largestEvenIndex = -1;
        int smallestOddIndex = -1;
        for(int i =0; i<num.length;i++)
        {
            if(numbers[i]%2==0 && numbers[i] >largestEven) {
                largestEven = numbers[i];
                largestEvenIndex=i;
            }
            else if(numbers[i]%2==1 && numbers[i] <smallestOdd) {
                smallestOdd = numbers[i];
                smallestOddIndex = i;
            }
        }
        int[] ints = new int[4];
        ints[0] = largestEven;
        ints[1] = largestEvenIndex;
        ints[2] = smallestOdd;
        ints[3] = smallestOddIndex;
        return ints;
    }

    public static void main(String[] args) {
        String input = "0,2,3,4,12,6,20,8,9,10";
        int[] result = findEvenOdd(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
