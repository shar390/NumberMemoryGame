import java.util.Random;
import java.util.Scanner;

public class NumberMemory{
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Generate 7 random numbers from 1 to 5
        int[] randomNumbers = new int[7];
        for (int i = 0; i < 7; i++) {
            randomNumbers[i] = random.nextInt(5) + 1;
        }

        System.out.println("Try to remember the following numbers. The numbers will be shown for 4 seconds.");
        displayNumbers(randomNumbers, 4000); 

        
        clearScreen();

        // Ask the user to input the remembered numbers
        int[] userNumbers = new int[7];
        for (int i = 0; i < 7; i++) {
            System.out.print("Type number " + (i + 1) + ": ");
            userNumbers[i] = scanner.nextInt();
        }

        
        System.out.print("The numbers were: ");
        displayNumbers(randomNumbers, 0); 

        
        System.out.print("Your numbers were: ");
        displayNumbers(userNumbers, 0); 

        
        int correctCount = countCorrectAnswers(randomNumbers, userNumbers);
        double percentage = ((double) correctCount / 7) * 100;
        System.out.println("Number of correct answers: " + correctCount);
        System.out.printf("Percentage of correct answers: %.2f%%\n", percentage);

        scanner.close();
    }
    
    // Display the correct numbers
    private static void displayNumbers(int[] numbers, long duration) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + duration;

        while (System.currentTimeMillis() < endTime) {
            for (int number : numbers) {
                System.out.print(number);
            }
            System.out.println();
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    
    private static int countCorrectAnswers(int[] correctNumbers, int[] userNumbers) {
        int count = 0;
        for (int i = 0; i < correctNumbers.length; i++) {
            if (correctNumbers[i] == userNumbers[i]) {
                count++;
            }
        }
        return count;
    }

    
    private static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
