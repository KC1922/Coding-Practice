import java.util.Scanner;

//simple program that takes in a user entered string and determines if it is a palindrome or not.
//a palindrome is a word, phrase, or sequence that reads the same backwards as forwards.
public class palindrone {
    public static void main(String[] args){
        Scanner scanr = new Scanner(System.in);
        String inputString;

        System.out.print("Enter a word or number to be checked: ");
        inputString = scanr.nextLine();
        scanr.close();

        boolean isPalindrone = checkPalindrone(inputString);

        if (isPalindrone){
            System.out.println("The string \"" + inputString + "\" is a palindrone.");
        }
        else{
            System.out.println("The string \"" + inputString + "\" is not a palindrone.");
        }
    }
    public static boolean checkPalindrone(String inputString){
        char[] inputStringArray = inputString.toCharArray();
        int left = 0;
        int right = inputStringArray.length - 1;

        while (left < right){
            //could also use Character.toLowerCase() to make case insensitive, but for this example I will leave it case sensitive.
            char leftChar = inputStringArray[left];
            char rightChar = inputStringArray[right];
            if (leftChar != rightChar){
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}

