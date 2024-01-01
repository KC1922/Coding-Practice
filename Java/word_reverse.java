import java.util.Scanner;
public class word_reverse {
//Simple program that, similar to string_reverse.java, takes in a user entered string and reverses it, 
//but this time reverses the order of the words in the string instead.
    public static void main(String[] args){
            
        Scanner scanr = new Scanner(System.in);
        String inputString;

        System.out.print("Enter string to be reversed: ");
        inputString = scanr.nextLine();
        scanr.close();

        String outputString = reverseWords(inputString);

        System.out.println("The reverse of \"" + inputString + "\" is: \n" + outputString);
    }
    public static String reverseWords(String inputString){
        String[] inputStringArray = inputString.split(" ");
        int left = 0;
        int right = inputStringArray.length - 1;

        while (left < right){
            String leftString = inputStringArray[left];
            inputStringArray[left] = inputStringArray[right];
            inputStringArray[right] = leftString;

            left++;
            right--;
        }
        String reversedString = String.join(" ", inputStringArray);
        return reversedString;
    }
}
