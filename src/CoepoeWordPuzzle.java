import java.util.*;

public class CoepoeWordPuzzle {

    public static void main(String[] args) {
        System.out.println("Coepoe Word Puzzle\n===================\n");
        Scanner sc = new Scanner(System.in);
        boolean retry = true;
        int overallScore = 0;

        while (retry) {
            // Display rules
            System.out.println("Rules : ");
            System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters.");
            System.out.println("2. Each level, You have 10 chances to answer correctly.");
            System.out.println("3. To get through to next level, you have to score 70 points each level.");
            System.out.println();

            // Start game
            int score = 0;
            for (int level = 1; level <= 3; level++) {
                System.out.println("Level " + level + "\n-------");
                char[] chars = getCharHint(level);
                System.out.println(chars);
                List<String> correctAnswers = getCorrectAnswers(level);
                Set<String> userAnswers = new HashSet<>();
                score = 0;
                for (int i = 1; i <= 10; i++) {
                    System.out.print(i + ") Your Answer : ");
                    String answer = sc.nextLine();
                    if (userAnswers.contains(answer)) {
                        System.out.println("You had already type this word before..");
                        i--;
                        continue;
                    }
                    if (correctAnswers.contains(answer)) {
                        System.out.println("#Right. Score : " + (score + 10));
                        score += 10;
                        userAnswers.add(answer);
                    } else {
                        System.out.println("#Wrong. Score : " + score);
                    }
                }
                if (score >= 70) {
                    overallScore += score;
                    System.out.println("\nCongratulations! You passed level " + level + ".");
                } else {
                    System.out.println("\nSorry, you did not pass level " + level + ".");
                    break;
                }
                System.out.println("\nCorrect Answers : ");
                for (String correctAnswer : correctAnswers) {
                    System.out.print(correctAnswer + "\t");
                }
                System.out.println("\n");
            }

            if (score >= 70) {
                System.out.println("You Win!!");
            } else {
                System.out.println("You Lose!! Try Again..");
            }
            System.out.print("Overall score : " + overallScore + "\nDo you want to retry [y/t] ? ");
            String retryAnswer = sc.nextLine();
            retry = (retryAnswer.equalsIgnoreCase("y"));
        }
        sc.close();
    }

    // Generate random characters
    public static char[] getCharHint(int level) {
        switch (level) {
            case 1:
                return "dettli".toCharArray();
            case 2:
                return "secaen".toCharArray();
            case 3:
                return "hkrneo".toCharArray();
            default:
                return  "".toCharArray();
        }
    }

    // Get correct answers
    public static List<String> getCorrectAnswers(int level) {
        switch (level) {
            case 1:
                return Arrays.asList("die",
                        "led",
                        "lei",
                        "let",
                        "lid",
                        "lie",
                        "lit",
                        "tie",
                        "deli",
                        "diet",
                        "edit",
                        "idle",
                        "lied",
                        "tide",
                        "tied",
                        "tile",
                        "tilt",
                        "tilde",
                        "tiled",
                        "title",
                        "tilted",
                        "titled");
            case 2:
                return Arrays.asList("can",
                        "sec",
                        "cane",
                        "scan",
                        "scene",
                        "sen",
                        "case",
                        "cease",
                        "acne",
                        "ace",
                        "sac",
                        "sea",
                        "sane",
                        "cans",
                        "cases",
                        "cease",
                        "canes",
                        "scans",
                        "scenes");
            case 3:
                return Arrays.asList(
                        "hen",
                        "her",
                        "one",
                        "ore",
                        "roe",
                        "honk",
                        "hero",
                        "horn",
                        "hone",
                        "norther"
                );
            default:
                return  Arrays.asList("");
        }
    }
}