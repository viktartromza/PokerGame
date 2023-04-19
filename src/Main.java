import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"h", "d", "c", "s"};
        ArrayList<String> deck = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(ranks[i].concat(suits[j]));
            }
        }
        System.out.println(deck);
        Stream.of(deck).forEach(System.out::println);
        Random random = new Random();
        String[] playerHand = new String[2];
        String[] ourHand = new String[2];
        for (int i = 0; i < 2; i++) {
            playerHand[i] = deck.get(random.nextInt(53 - i*2));
            deck.remove(playerHand[i]);
            ourHand[i] = deck.get(random.nextInt(53 - i*2 - 1));
            deck.remove(ourHand[i]);
        }
        System.out.println(Arrays.toString(playerHand));
        System.out.println(Arrays.toString(ourHand));
        System.out.println(deck);
        int [] arr =null;
        while ((arr = Chanses.genCombinations(arr,3,48)) != null){
            System.out.println(Arrays.toString(arr));
        }
    }
}