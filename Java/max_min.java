import java.util.Arrays;
import java.util.Scanner;
//simple program that takes in a list of numbers and determines the maximum and minimum values. 
//for simplicity, the list is limited to a required 10 elements, but this can be changed by changing the size of the inputArray.
//user can also choose to find the 2nd, 3rd, etc. largest/smallest values with error checking to ensure the user doesn't enter a value larger than the list size.
public class max_min {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArray = new int[10];

        System.out.println("Enter 10 numbers to be checked.");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print("Enter number " + i + ": ");
            inputArray[i] = scanner.nextInt();
        }


        System.out.println("The entered array is: ");
        System.out.println(Arrays.toString(inputArray));

        //sort the array to make finding max and min easier
        bubbleSort(inputArray);

        int max = findMax(inputArray);
        int min = findMin(inputArray);
        System.out.println("The maximum value is: " + max);
        System.out.println("The minimum value is: " + min);

        System.out.println("Enter a number to find the nth largest/smallest value in the array.");
        System.out.print("Enter a number between 1 and " + inputArray.length + ": ");
        int n = scanner.nextInt();
        scanner.close();

        int nthMax = findNthMax(inputArray, n);
        int nthMin = findNthMin(inputArray, n);

        System.out.println("The " + n + "th largest value is: " + nthMax);
        System.out.println("The " + n + "th smallest value is: " + nthMin);
    }

    //implement a bubble sort algorithm to sort the array
    public static int[] bubbleSort(int[] inputArray) {
        int temp;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 1; j < inputArray.length - i; j++) {
                if (inputArray[j - 1] > inputArray[j]) {
                    temp = inputArray[j - 1];
                    inputArray[j - 1] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }
        return inputArray;
    }

    public static int findMax(int[] inputArray) {
        return Arrays.stream(inputArray).max().orElse(Integer.MIN_VALUE);
    }

    public static int findMin(int[] inputArray) {
        return Arrays.stream(inputArray).min().orElse(Integer.MAX_VALUE);
    }

    public static int findNthMax(int[] inputArray, int n) {
        return inputArray[inputArray.length - n];
    }

    public static int findNthMin(int[] inputArray, int n) {
        return inputArray[n - 1];
    }
}

