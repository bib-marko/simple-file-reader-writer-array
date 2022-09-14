import java.util.Scanner;

public class ArrayB {
    public static void main(String[] args) {
        int flag = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input the number of Students: ");
        int numberOfStud = scan.nextInt();
        System.out.print("Please input the number of Quizzes ");

        do {
            System.out.println("Please select an option: ");
            System.out.println("1. sum of the digit\n"
                    + "2. reverse integer\n"
                    + "3. display all the prime number\n"
                    + "4. Palindrome\n" + "5. Odd or even\n"
                    + "6. Terminate program");
            System.out.print("Please select the methods you want to do with the number: ");
            int inputCase = scan.nextInt();
            switch (inputCase) {
                case 1:
//                    UserUtils.sumOfDigits(inputNumber);
                    System.out.println("=========================================================================================");
                    break;
                case 2:
//                    UserUtils.reverseDigits(inputNumber);
                    System.out.println("=========================================================================================");
                    break;
                case 3:
//                    UserUtils.displayAllPrimeNumber(inputNumber);
                    System.out.println("=========================================================================================");
                    break;
                case 4:
//                    UserUtils.checkIfPalindrome(inputNumber);
                    System.out.println("=========================================================================================");
                    break;
                case 5:
//                    UserUtils.checkIfOddOrEven(inputNumber);
                    System.out.println("=========================================================================================");
                    break;
                case 6:
                    flag++;
                    System.out.println("INSERT YOUR NAME HERE");
                    break;
                default:
                    System.out.println("INVALID");
            }
        } while (flag == 0);
    }
}

