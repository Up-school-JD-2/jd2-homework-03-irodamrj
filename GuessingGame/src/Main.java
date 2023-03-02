import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>(){
            {
                add(new Player("iroda"));
                add(new Player("sezer"));
                add(new Player("melahat"));
            }
        };

        randomGuess(players);

    }
    private static void randomGuess(ArrayList<Player> players){
        int input = 0;
        boolean continueAfterTrueAnswer = false;
        boolean isTrueAnswer = false;
        while(!continueAfterTrueAnswer) {
            Random random = new Random();
            int random2 = random.nextInt(1, 101);
            System.out.println(random2);
            while (!isTrueAnswer) {
                for(int i = 1; i <=players.size(); i++) {
                    input = returnGuess(i);
                    if (input == -1) {
                        System.out.println("game ending..");
                        isTrueAnswer = true;
                        continueAfterTrueAnswer = true;
                        break;
                    }
                    if (input < 1 || input > 100) {
                        System.out.println("please enter a value between 1-100");
                        continue;
                    }
                    if (input < random2 / 2){
                        System.out.println("Too less. Try bigger number");
                        players.get(i-1).setGuessNumber();
                    }
                    else if (input > random2 * 2) {
                        System.out.println("Too big. Try smaller number");
                        players.get(i-1).setGuessNumber();
                    }
                    else if (input == random2) {
                        System.out.println("""
                                Congratulations! Right answer.
                                If you want to continue to play enter 1, else enter 0.
                                """);
                        Scanner sc = new Scanner(System.in);
                        int answer = sc.nextInt();
                        continueAfterTrueAnswer = answer == 0;
                        if(continueAfterTrueAnswer){
                            System.out.println("Ending game..");
                        }
                        players.get(i-1).setGuessNumber();
                        players.get(i-1).setTrueGuessNumber();
                        isTrueAnswer = true;
                        break;
                    }
                    else{
                        System.out.println("Not the right answer but soo close! Try again");
                        players.get(i-1).setGuessNumber();
                    }
                }
            }
        }

        Collections.sort(players);
        System.out.println(players);
    }



    private static int returnGuess(int playernum){

        System.out.println("TURN--> PLAYER: " + playernum);
        System.out.println("Enter an integer between 1-100. -1 for exit.");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }




}