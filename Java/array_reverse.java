import java.util.Scanner;

//Simple program that lets user populate an array of 10 elements and then reverses the array. Elements can be anything, not just integers.
//When printed, elements are placed in brackets and separated by spaces for clarity when dealing with strings that include whitespace.
public class array_reverse {
    public static void main(String[] args){
        Scanner scanr = new Scanner(System.in);
        
        
        String[] inputStrings = new String[10];
        int i = 0;
        System.out.println("Enter 10 elements to be reversed.");
        while (i < 10){
            System.out.print("Enter element " + i + ": ");
            inputStrings[i] = scanr.nextLine(); 
            i++;
        }
        scanr.close();
        System.out.println("The entered array is: ");
        for (int j = 0; j < inputStrings.length; j++){
            System.out.print("[" + inputStrings[j] + "] ");
        }

        String[] outputString = reverseArray(inputStrings);

        System.out.println("\nThe reverse of the array is: ");
        for (int j = 0; j < outputString.length; j++){
            System.out.print("["+ outputString[j] + "] ");
        }

    }

    public static String[] reverseArray(String[] inputStrings){
        int left = 0;
        int right = inputStrings.length - 1;
        String[] outputString = new String[inputStrings.length];
        outputString = inputStrings.clone();
        while (left < right){
            String leftString = inputStrings[left];
            outputString[left] = outputString[right];
            outputString[right] = leftString;

            left++;
            right--;
        }
        return outputString;
    }
}
