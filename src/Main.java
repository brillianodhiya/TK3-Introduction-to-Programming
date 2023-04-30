import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<String> correctAnswers = new HashSet<String>();
        int score = 0;
        boolean retry = false;
        String[] letters = {"d", "e", "t", "t", "l", "i"};

        System.out.println("Coepoe Word Puzzle\n===================\n");
        System.out.println("Rules :\n1. Create a word using given characters, min 3 characters & max 6 characters.\n2. Each level, You have 10 chances to answer correctly.\n3. To get through to next level, you have to score 70 points each level.");

        do {
            score = 0;
            correctAnswers.clear();
            retry = false;

            // Level 1
            System.out.println("\nLevel 1\n-------");
            String[] level1Answers = {"die", "led", "lei", "let", "lid", "lie", "lit", "tie", "deli", "diet", "edit", "idle", "lied", "tide", "tied", "tile", "tilt", "tilde", "tiled", "title", "tilted", "titled"};

            for (int i = 0; i < 10; i++) {
                System.out.print((i + 1) + ") Your Answer : ");
                String answer = input.nextLine().toLowerCase();

                if (!answer.matches("[a-z]{3,6}")) {
                    System.out.println("Invalid input. Please input a word with 3 to 6 letters.");
                    i--;
                    continue;
                }

                if (correctAnswers.contains(answer)) {
                    System.out.println("You had already type this word before..");
                    i--;
                    continue;
                }

                if (checkAnswer(answer, letters, level1Answers)) {
                    correctAnswers.add(answer);
                    score += 10;
                    System.out.println("#Right. Score : " + score);
                } else {
                    System.out.println("#Wrong. Score : " + score);
                }
            }

            if (score < 70) {
                System.out.println("\nYou Lose!! Try Again..");
                System.out.print("Do you want to retry [y/t] ? ");
                String retryInput = input.nextLine().toLowerCase();
                retry = retryInput.equals("y");
                continue;
            }

            // Level 2
            System.out.println("\nLevel 2\n-------");
            String[] level2Answers = {"can", "cane", "case", "cease", "scan", "scene", "sec"};

            for (int i = 0; i < 10; i++) {
                System.out.print((i + 1) + ") Your Answer : ");
                String answer = input.nextLine().toLowerCase();

                if (!answer.matches("[a-z]{3,6}")) {
                    System.out.println("Invalid input. Please input a word with 3 to 6 letters.");
                    i--;
                    continue;
                }

                if (correctAnswers.contains(answer)) {
                    System.out.println("You had already type this word before..");
                    i--;
                    continue;
                }

                if (checkAnswer(answer, letters, level2Answers)) {
                    correctAnswers.add(answer);
                    score += 10;
                    System.out.println("#Right. Score : " + score);
                } else {
                    System.out.println("#Wrong. Score : " + score);
                }
            }

            if (score < 70) {
                System.out.println("\nYou Lose!! Try Again..");
                System.out.print("Do you want to retry [y/t] ? ");
                String retryInput = input.nextLine().toLowerCase();
                retry = retryInput.equals("y");
                continue;
            }

            System.out.println("\nYou Win!!\n");

            // End of the game
            System.out.print("Do you want to play again [y/t] ? ");
            String playAgain = input.nextLine().toLowerCase();
            retry = playAgain.equals("y");
        } while (retry);

        System.out.println("Thank you for playing Coepoe Word Puzzle.");
    }

    public static boolean checkAnswer(String answer, String[] letters, String[] possibleAnswers) {
        boolean validAnswer = true;
        for (char c : answer.toCharArray()) {
            if (!new String(Arrays.toString(letters)).contains(Character.toString(c))) {
                validAnswer = false;
                break;
            }
        }

        if (validAnswer) {
            for (String possibleAnswer : possibleAnswers) {
                if (answer.equals(possibleAnswer)) {
                    return true;
                }
            }
        }

        return false;
    }
}