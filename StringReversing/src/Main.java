import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean containsSpace = true;
        String input = "";
        while (containsSpace){
            System.out.println("Enter a string");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            if(input.contains(" "))
                continue;
            containsSpace = false;
        }
        char[] charArray = input.toCharArray();
        char[] reversed = new char[charArray.length];
        for (int i = 0; i < reversed.length ; i++) {
            reversed[i] = charArray[charArray.length -i -1];
        }

        String reversedInput = String.valueOf(reversed);
        System.out.println("reversed of " + input + " is " + reversedInput );

        System.out.println("is " + input + " a palindrome? " + isPalindrome(input));


    }
    private  static boolean isPalindrome(String input){
        boolean result = false;
        for(int i = 0; i <input.length()/2; i++){
            input = input.toLowerCase();
            if(input.charAt(i) == input.charAt(input.length()-1-i))
                result = true;
            else {
                result = false;
                break;
            }
        }
        return result;
    }
}