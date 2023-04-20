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
        String[] tern = new String[4];
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
            String[] ourHandWithFlop = new String[5];
            String[] playerHandWithFlop = new String[5];
            String[] ourHandWithTern = new String[6];
            String[] playerHandWithTern = new String[6];
            for (int i = 0; i < 3; i++) {
                ourResult = new StringBuilder(ourResult + flop[i]);
                playerResult = new StringBuilder(playerResult + flop[i]);
                ourHandWithFlop[i] = flop[i];
                playerHandWithFlop[i] = flop[i];
            }
            for (int i = 0; i < 2; i++) {
                ourResult = new StringBuilder(ourResult + ourHand[i]);
                playerResult = new StringBuilder(playerResult + playerHand[i]);
                ourHandWithFlop[i + 3] = ourHand[i];
                playerHandWithFlop[i + 3] = playerHand[i];
            }

            System.out.println(Arrays.toString(ourHandWithFlop));
            System.out.println(Chanses.evalCombination(ourHandWithFlop));
            System.out.println("player cards: " + Arrays.toString(playerHandWithFlop) + " " + Chanses.evalCombination(playerHandWithFlop));

            System.out.println("our cards: " + Arrays.toString(ourHandWithFlop) + " " + Chanses.evalCombination(ourHandWithFlop));
            System.out.println("our chances: "+ Chanses.compCombinations(ourHand,flop));

            System.out.println("Do you continue?");
            if (scanner.nextLine().equals("y") || scanner.nextLine().equals("Y")) {
                String ternCard = thisDeck.get(random.nextInt(thisDeck.size()));
                thisDeck.remove(ternCard);

                System.arraycopy(flop, 0, tern, 0, 3);
                tern[3] = ternCard;
                System.out.println(Arrays.toString(tern));

                System.arraycopy(ourHandWithFlop, 0, ourHandWithTern, 1, 5);
                ourHandWithTern[0] = ternCard;
                System.arraycopy(playerHandWithFlop, 0, playerHandWithTern, 1, 5);
                playerHandWithTern[0] = ternCard;

                System.out.println("player cards: " + Arrays.toString(playerHandWithTern) + " " + Chanses.evalCombination(playerHandWithTern));
                System.out.println("our cards: " + Arrays.toString(ourHandWithTern) + " " + Chanses.evalCombination(ourHandWithTern));

            }
            System.out.println("Do you continue?");
            if (scanner.nextLine().equals("y") || scanner.nextLine().equals("Y")) {
                String riverCard = thisDeck.get(random.nextInt(thisDeck.size()));
                thisDeck.remove(riverCard);
                String[] river = new String[5];
                System.arraycopy(tern, 0, river, 0, 4);
               river[4] = riverCard;
                System.out.println(Arrays.toString(river));
                String[] ourHandWithRiver = new String[7];
                String[] playerHandWithRiver = new String[7];
                System.arraycopy(ourHandWithTern, 0, ourHandWithRiver, 1, 6);
                ourHandWithRiver[0] = riverCard;
                System.arraycopy(playerHandWithTern, 0, playerHandWithRiver, 1, 6);
                playerHandWithRiver[0] = riverCard;

                System.out.println("player cards: " + Arrays.toString(playerHandWithRiver) + " " + Chanses.evalCombination(playerHandWithRiver) + " win: "+ (Chanses.evalCombination(playerHandWithRiver)>Chanses.evalCombination(ourHandWithRiver)));
                System.out.println("our cards: " + Arrays.toString(ourHandWithRiver) + " " + Chanses.evalCombination(ourHandWithRiver)+ " win: "+ (Chanses.evalCombination(playerHandWithRiver)<Chanses.evalCombination(ourHandWithRiver)));

            }
        }
    }
}