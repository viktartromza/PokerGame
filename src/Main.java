import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        Deck deck = new Deck();
        ArrayList<String> thisDeck = deck.get();

        Stream.of(thisDeck).forEach(System.out::println);
        Random random = new Random();
        String[] playerHand = new String[2];
        String[] ourHand = new String[2];
        String[] flop = new String[3];
        for (int i = 0; i < 2; i++) {
            playerHand[i] = thisDeck.get(random.nextInt(52 - i * 2));
            thisDeck.remove(playerHand[i]);
            ourHand[i] = thisDeck.get(random.nextInt(52 - i * 2 - 1));
            thisDeck.remove(ourHand[i]);
        }
        String[] test = {"2h", "6s"};
        System.out.println(Arrays.toString(playerHand));
        System.out.println(Arrays.toString(ourHand) + " Power: " + Chanses.compCombinations(ourHand, null));
        // System.out.println("Power: "+Chanses.compCombinationsPlayer(test,null));
        // System.out.println(Arrays.toString(test)+" power: "+Chanses.compCombinations(test,null));
        System.out.println(thisDeck);
        // Chanses.compCombinations(ourHand,null);
        System.out.println("Do you continue?");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("y") || scanner.nextLine().equals("Y")) {
            for (int i = 0; i < 3; i++) {
                flop[i] = thisDeck.get(random.nextInt(thisDeck.size() - i));
                thisDeck.remove(flop[i]);
            }
            System.out.println(Arrays.toString(flop));
            StringBuilder ourResult = new StringBuilder();
            StringBuilder playerResult = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                ourResult = new StringBuilder(ourResult + flop[i]);
                playerResult = new StringBuilder(playerResult + flop[i]);
            }
            for (int i = 0; i < 2; i++) {
                ourResult = new StringBuilder(ourResult + ourHand[i]);
                playerResult = new StringBuilder(playerResult + playerHand[i]);
            }
            System.out.println("player cards: " + playerResult +" "+ FiveCardDraw.process(playerResult.toString()));
            System.out.println("our cards: " + ourResult +" "+ FiveCardDraw.process(ourResult.toString()));


        }
    }
}