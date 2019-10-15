import java.security.SecureRandom;
import java.util.Scanner;

public class ruiz_p1 {

    public static int chooseDiff(Scanner scn){
        int difficulty;
        int chosenVal = 0;

        System.out.printf("\n\nPlease choose a difficulty:\n" +
                "1: One Digit\n" +
                "2: Two Digits\n" +
                "3: Three Digits\n" +
                "4: Four Digits\n");
        difficulty = scn.nextInt();

        while((difficulty >4) || (difficulty < 1)){
            System.out.println("Invalid. Try again. (1-4)");
            difficulty = scn.nextInt();
        }

        if(difficulty == 1){
            chosenVal = 10;
        }else if(difficulty == 2){
            chosenVal = 100;
        }else if(difficulty == 3){
            chosenVal = 1000;
        }else if(difficulty == 4){
            chosenVal = 10000;
        }

        return chosenVal;
    }

    public static int chooseProblem(Scanner scn){
        int userChoice;

        System.out.printf("\nChoose type of problem:\n" +
                "1: Addition\n" +
                "2: Subtraction\n" +
                "3: Multiplication\n" +
                "4: Division\n" +
                "5: Random\n");

        userChoice = scn.nextInt();

        return userChoice;
    }

    public static void response(SecureRandom rand, boolean correct) {
        int reply = rand.nextInt(4);

        if(correct){
            switch (reply) {
                case 0:
                    System.out.println("Very Good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            };
        }else if(!correct){
            switch(reply) {
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don't give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
            };
        }
        System.out.println();
    }

    public static void add(SecureRandom rand, Scanner scn, int difficulty, int[] corr){
        int num1 = rand.nextInt(difficulty);
        int num2 = rand.nextInt(difficulty);
        double ans = (double)num1 + num2;
        double userIn;

        System.out.println("How much is " + num1 + " plus " + num2 + "?");
        userIn = scn.nextDouble();

        if(Math.abs(ans - userIn) > 0.0001){
            response(rand, false);
            corr[1]++;
        }else{
            response(rand, true);
            corr[0]++;
        }
    }

    public static void subtract(SecureRandom rand, Scanner scn, int difficulty, int[] corr){
        int num1 = rand.nextInt(difficulty);
        int num2 = rand.nextInt(difficulty);
        double ans = (double)num1 - num2;
        double userIn;

        System.out.println("How much is " + num1 + " minus " + num2 + "?");
        userIn = scn.nextDouble();

        if(Math.abs(ans - userIn) > 0.0001){
            response(rand, false);
            corr[1]++;
        }else{
            response(rand, true);
            corr[0]++;
        }
    }

    public static void multiply(SecureRandom rand, Scanner scn, int difficulty, int[] corr){
        int num1 = rand.nextInt(difficulty);
        int num2 = rand.nextInt(difficulty);
        double ans = (double)num1 * num2;
        double userIn;

        System.out.println("How much is " + num1 + " times " + num2 + "?");
        userIn = scn.nextDouble();

        if(Math.abs(ans - userIn) > 0.0001){
            response(rand, false);
            corr[1]++;
        }else{
            response(rand, true);
            corr[0]++;
        }
    }

    public static void divide(SecureRandom rand, Scanner scn, int difficulty, int[] corr){
        int num1 = rand.nextInt(difficulty);
        int num2 = rand.nextInt(difficulty);
        double ans = (double)num1 / num2;
        double userIn;

        System.out.println("How much is " + num1 + " divided by " + num2 + "?");
        userIn = scn.nextDouble();

        if(Math.abs(ans - userIn) > 0.0001){
            response(rand, false);
            corr[1]++;
        }else{
            response(rand, true);
            corr[0]++;
        }
    }


    public static void main(String[] args){
        SecureRandom rand = new SecureRandom();
        Scanner scn = new Scanner(System.in);
        int difficulty;
        int problemChoice;
        char userChar;
        boolean random = false;
        boolean quit = false;
        double percCorrect;

        while(!quit) {
            difficulty = chooseDiff(scn);
            problemChoice = chooseProblem(scn);

            //Checks if choice is random
            if(problemChoice == 5){
                random = true;
            }

            //Initialize new array for each student
            int[] answerCorr = {0, 0};

            //Loops 10 questions per session
            for(int i = 0; i < 10; ++i) {
                if(random){
                    problemChoice = rand.nextInt(4) + 1;
                }

                switch(problemChoice){
                    case 1:
                        add(rand, scn, difficulty, answerCorr);
                        break;
                    case 2:
                        subtract(rand, scn, difficulty, answerCorr);
                        break;
                    case 3:
                        multiply(rand, scn, difficulty, answerCorr);
                        break;
                    case 4:
                        divide(rand, scn, difficulty, answerCorr);
                        break;
                };
            }

            percCorrect = (answerCorr[0] / 10.0) * 100;
            System.out.println("Correct: " + answerCorr[0]);
            System.out.println("Incorrect: " + answerCorr[1]);
            System.out.printf("Percentage Correct: %.2f\n\n", percCorrect);

            //Check for new session
            System.out.println("New Session? (Y or N)");
            userChar = scn.next().charAt(0);
            if(userChar == 'N'){
                System.out.printf("\nThank you for participating, hope to see you again soon!");
                quit = true;
            }
        }

    }
}