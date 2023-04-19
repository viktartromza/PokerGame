import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        Deck deck = new Deck();
        ArrayList<String> thisDeck = deck.get();

       Stream.of(thisDeck).forEach(System.out::println);
        Random random = new Random();
        String[] playerHand = new String[2];
        String[] ourHand = new String[2];
        for (int i = 0; i < 2; i++) {
            playerHand[i] = thisDeck.get(random.nextInt(52 - i*2));
            thisDeck.remove(playerHand[i]);
            ourHand[i] = thisDeck.get(random.nextInt(52 - i*2 - 1));
            thisDeck.remove(ourHand[i]);
        }
       // String [] test = {"Kh","Ah"};
        System.out.println(Arrays.toString(playerHand));
        System.out.println(Arrays.toString(ourHand)+" power: "+Chanses.compCombinations(ourHand,null));
        //System.out.println(Arrays.toString(test)+" power: "+Chanses.compCombinations(test,null));
        System.out.println(thisDeck);
        Chanses.compCombinations(ourHand,null);
    }
}