import java.util.Scanner;
//Simple program takes in a user entered string and reverses it.
public class string_reverse {
    public static void main(String[] args){

        Scanner scanr = new Scanner(System.in);
        String inputString;

        System.out.print("Enter string to be reversed: ");
        inputString = scanr.nextLine();
        scanr.close();

        String outputString = reverseString(inputString);

        System.out.println("The reverse of \"" + inputString + "\" is: \n" + outputString);
        
    }
    public static String reverseString(String inputString){

        char[] inputStringArray = inputString.toCharArray();
        int left = 0;
        int right = inputStringArray.length - 1;

        while (left < right){
            char leftChar = inputStringArray[left];
            inputStringArray[left] = inputStringArray[right];
            inputStringArray[right] = leftChar;

            left++;
            right--;
        }
        String reversedString = new String(inputStringArray);
        return reversedString;
        /*More easily, could just use StringBuilder
        String reversedString = new StringBuilder(inputString).reverse().toString();
        */
    }
}