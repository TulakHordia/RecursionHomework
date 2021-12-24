import java.util.Scanner;

public class Recursions {

    public static boolean alternateNumber(int number) {
        if (number < 10) {
            return true;
        }
        if ((number % 10) % 2 == ((number % 100) / 10) % 2) {
            return false;
        }
        return alternateNumber(number / 10);
    }

    public static boolean alternateNumberPairs(int number) {
        if (number < 10) {
            return false;
        }
        if ((number % 10) % 2 == ((number % 100) / 10) % 2) {
            return alternateNumberPairs(number / 10);
        } else {
            return true;
        }
    }

    public static void switchLetters(StringBuilder str, int indexBegin, int indexEnd) {
        if (indexBegin >= indexEnd) {
            return;
        }
        char holder;
        holder = str.charAt(indexBegin);
        str.setCharAt(indexBegin, str.charAt(indexEnd));
        str.setCharAt(indexEnd, holder);
        switchLetters(str, indexBegin + 1, indexEnd - 1);
    }

    public static boolean allCharsAreCapOrCs(char[] charArr, int charIndex, int lcCounter, int ucCounter) {
        if (charIndex == -1) {
            return true;
        }
        boolean isCharLowerCase = Character.isLowerCase(charArr[charIndex]);
        boolean isCharUpperCase = Character.isUpperCase(charArr[charIndex]);

        if (isCharLowerCase && (ucCounter == 0)) {
            return allCharsAreCapOrCs(charArr, charIndex - 1, lcCounter + 1, 0);
        }
        if (isCharUpperCase && (lcCounter == 0)) {
            return allCharsAreCapOrCs(charArr, charIndex - 1, 0, ucCounter + 1);
        } else {
            return false;
        }
    }

    private static int baseTenConverter(int baseTenNumber) {
        if (baseTenNumber == 0) {
            return 0;
        }
        // 78 = 64 8 4 2 ---> 1001110
        // 78/2 = 39
        return ((baseTenConverter(baseTenNumber / 2) * 10) + (baseTenNumber % 2));
    }

    public static boolean continuityCheck(int[] numbersArray, int startingDigit, int numToCheck, int numIndexInArray) {
        if (numIndexInArray == -1) {
            return false;
        }
        if (numbersArray[numIndexInArray] == numToCheck) {
            if (numToCheck == 1) {
                return true;
            }
            return continuityCheck(numbersArray, startingDigit, numToCheck - 1, numIndexInArray - 1);
        }
        int step = (startingDigit == numToCheck) ? 1 : 0;
        return continuityCheck(numbersArray, startingDigit, startingDigit, numIndexInArray - step);
    }

    public static boolean sumOfNumbers(int firstNumber, int secondNumber, int firstSum, int secondSum) {
        if (firstNumber < 0 || secondNumber < 0) {
            return false;
        }

        while (firstNumber != 0) {
            int firstTemp = firstNumber%10;
            firstSum += firstTemp;
            firstNumber /= 10;
        }
        while (secondNumber != 0) {
            int secondTemp = secondNumber%10;
            secondSum += secondTemp;
            secondNumber /= 10;
        }

        if (secondSum == firstSum) {
            return true;
        }
        else {
            return false;
        }
    }

    private static long[] fibonacciCache;
    public static long fibonacci(int num) {
        if (num <= 3) {
            return num;
        }

        if (fibonacciCache[num] != 0) {
            return fibonacciCache[num];
        }
        long nthFibonacciNumber = 0;
        if (num % 2 == 0) {
            nthFibonacciNumber = fibonacci(num-1) + fibonacci(num-2) + fibonacci(num-3);
        }
        else {
            nthFibonacciNumber = fibonacci(num-1) - fibonacci(num-3);
        }

        fibonacciCache[num] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }

    public static void hatchMarksPrinter(int hatchMarks) {
        if (hatchMarks <= 0) {
            return;
        }

        hatchMarksPrinter(hatchMarks-1);
        for (int i = 0; i <= hatchMarks; i++) {
            System.out.print("-");
        }
        System.out.println("-");
        hatchMarksPrinter(hatchMarks-1);

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {

            System.out.println("-----Recursions Assignment Menu-----");
            System.out.println("1. Exercise #8");
            System.out.println("2. Exercise #9");
            System.out.println("3. Exercise #11");
            System.out.println("4. Exercise #12");
            System.out.println("5. Exercise #13");
            System.out.println("6. Exercise #17");
            System.out.println("7. Exercise #19");
            System.out.println("8. Exercise #20");
            System.out.println("9. Exercise #22");


            System.out.println("Type 11 to Exit.");

            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("-----Assignment 8, alternate number.-----");
                    System.out.println("Please enter your number: ");
                    int num1 = input.nextInt();
                    if (alternateNumber(num1)) {
                        System.out.println("Your number is alternate");
                    } else {
                        System.out.println("Your number is not alternate.");
                    }

                    break;

                case 2:

                    System.out.println("-----Assignment 9, alternate number pairs.-----");
                    int num2 = 0;
                    while (num2 <= 0) {
                        System.out.println("Please enter your number: ");
                        num2 = input.nextInt();
                    }
                    if (alternateNumberPairs(num2)) {
                        System.out.println("You have at least one alternate pair.");
                    } else {
                        System.out.println("You don't have a single alternate pair.");
                    }
                    break;

                case 3:

                    System.out.println("-----Assignment 11, switchLetters.-----");
                    System.out.println("Please enter your string: ");
                    StringBuilder stringToSend = new StringBuilder(input.nextLine());
                    stringToSend.append(input.nextLine());
                    int firstIndex = 0;
                    int secondIndex = stringToSend.length() - 1;
                    switchLetters(stringToSend, firstIndex, secondIndex);
                    System.out.println(stringToSend.toString());
                    break;

                case 4:

                    System.out.println("-----Assignment 12, Uppercase or Lowercase.-----");
                    System.out.println("Please enter amount of characters: ");
                    int charArrLength = input.nextInt();
                    char[] charArr = new char[charArrLength];
                    System.out.println("Please enter your characters: ");
                    for (int i = 0; i < charArrLength; i++) {
                        charArr[i] = input.next().charAt(0);
                    }
                    if (allCharsAreCapOrCs(charArr, charArrLength - 1, 0, 0)) {
                        System.out.println("All characters are either capital or case-sensitive.");
                    } else {
                        System.out.println("Not all characters are capital/case-sensitive.");
                    }

                    break;

                case 5:

                    System.out.println("-----Assignment 13, Base-10 to Base-2 converter.-----");
                    System.out.println("Please enter your number: ");
                    int baseTenNumber = input.nextInt();
                    System.out.println("Your Base-2 number is: " + baseTenConverter(baseTenNumber));

                    break;

                case 6:

                    System.out.println("-----Assignment 17, Continuity of numbers.-----");
                    System.out.println("Please enter array length: ");
                    int leadNumsArrayLength = input.nextInt();
                    int[] leadNumsArray = new int[leadNumsArrayLength];
                    System.out.println("Please enter your array values: ");
                    for (int i = 0; i < leadNumsArrayLength; i++) {
                        leadNumsArray[i] = input.nextInt();
                    }

                    System.out.println("Please enter the check digit: ");
                    int checkDigit = input.nextInt();

                    if (continuityCheck(leadNumsArray, checkDigit, checkDigit, leadNumsArrayLength - 1)) {
                        System.out.println("True.");
                    } else {
                        System.out.println("False.");
                    }
                    System.out.println();
                    break;

                case 7:

                    System.out.println("-----Assignment 19, Summary of two numbers.-----");
                    System.out.println("Please enter your first number: ");
                    int firstNumber = input.nextInt();
                    System.out.println("Please enter your second number: ");
                    int secondNumber = input.nextInt();

                    if (sumOfNumbers(firstNumber, secondNumber, 0, 0)) {
                        System.out.println("Their sum is the same.");
                    }
                    else {
                        System.out.println("Their sum is not the same.");
                    }

                    break;

                case 8:

                    System.out.println("-----Assignment 20, Sort of a fibonacci sequence.-----");
                    System.out.println("Enter your index digit: ");
                    int indexNum = input.nextInt();
                    fibonacciCache = new long[indexNum+1];
                    for (int i = 0; i < indexNum+1; i++) {
                        System.out.print(" " + fibonacci(i));
                    }


                    break;

                case 9:

                    System.out.println("-----Assignment 22, Ruler hatch marks.-----");
                    System.out.println("Enter the amount of hatch marks you want on your ruler: ");
                    int hatchMarks = input.nextInt();
                    hatchMarksPrinter(hatchMarks);

                    break;

                default:
                    System.out.println("Invalid option, please choose again.");

            }
            System.out.println("\nDo you want to go back to the main menu? (y/n)");
            char resume = input.next().charAt(0);
            if (resume == 'y' || resume == 'Y') {
            } else {
                System.out.println("Exiting program...");
                System.exit(0);
            }
        } while (choice != 11);
        System.out.println("Exiting program...Thank you!");
        input.close();
    }
}
