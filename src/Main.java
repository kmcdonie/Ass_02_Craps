import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();
        String playAgain;

        do {
            boolean craps = true;
            int rollCount = 0;

            System.out.printf("%-8s %-8s %-8s %-8s%n", "Roll", "Die 1", "Die 2", "Sum");
            System.out.println("-------------------------------");

                rollCount++;
                int die1 = gen.nextInt(6) + 1;
                int die2 = gen.nextInt(6) + 1;
                int crapsRoll = die1 + die2;

                System.out.printf("%-8d %-8d %-8d %-8d%n", rollCount, die1, die2, crapsRoll);

                if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                    System.out.println("You have crapped out :(");
                    craps = false;
                } else if (crapsRoll == 7 || crapsRoll == 11) {
                    System.out.println("You won with a natural :)");
                    craps = false;
                } else {
                    int point = crapsRoll;
                    System.out.println("The sum is now the point. Keep rolling until you hit the point (" + point + ") or a 7)");

                    boolean rollingForPoint = true;
                    while (rollingForPoint) {
                        die1 = gen.nextInt(6) + 1;
                        die2 = gen.nextInt(6) + 1;
                        crapsRoll = die1 + die2;

                        System.out.printf("%-8d %-8d %-8d %-8d%n", rollCount, die1, die2, crapsRoll);

                        if (crapsRoll == 7) {
                            System.out.println("You rolled a 7. You lost :(");
                            rollingForPoint = false;
                            craps = false;
                        } else if (crapsRoll == point) {
                            System.out.println("You made the point! You won :)");
                            rollingForPoint = false;
                            craps = false;
                        }
                    }
                }

                System.out.print("Do you want to play again? (Y/N): ");
                playAgain = in.nextLine();
            } while (playAgain.equalsIgnoreCase("Y")) ;

        System.out.println("Thanks for playing!");
        in.close();
    }
}

