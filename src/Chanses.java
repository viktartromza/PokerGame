import java.util.ArrayList;
import java.util.Arrays;

public class Chanses {

    static int[] genCombinations(int[] arr, int k, int n) {
        if (arr == null) {
            arr = new int[k];
            for (int i = 0; i < k; i++)
                arr[i] = i + 1;
            return arr;
        }
        for (int i = k - 1; i >= 0; i--)
            if (arr[i] < n - k + i + 1) {
                arr[i]++;
                for (int j = i; j < k - 1; j++)
                    arr[j + 1] = arr[j] + 1;
                return arr;
            }
        return null;
    }
/*
    static String[] compCombinations(ArrayList<String> deck, String[] hand) {
        String[] deckCards = (String[]) deck.toArray();
        int z = 0;
        for (int i = 0; i < deckCards.length(); i = i + 2) {
            String s1 = board.substring(i, i + 2);
            boardCards[z++] = s1;
        }
        String[] handCards = new String[hand.length() / 2];
        int n = 0;
        for (int i = 0; i < hand.length(); i = i + 2) {
            String s1 = hand.substring(i, i + 2);
            handCards[n++] = s1;
        }
        int[] arr = null;
        String[] combination = new String[5];
        String[] supercombination = new String[60];
        int count = 0;
        while ((arr = genCombinations(arr, 3, 5)) != null) {
            combination[0] = boardCards[(arr[0] - 1)];
            combination[1] = boardCards[(arr[1] - 1)];
            combination[2] = boardCards[(arr[2] - 1)];
            int[] arr1 = null;
            while ((arr1 = genCombinations(arr1, 2, 4)) != null) {
                combination[3] = handCards[(arr1[0] - 1)];
                combination[4] = handCards[(arr1[1] - 1)];
                supercombination[count++] = Arrays.toString(combination).replaceAll("[^0-9A-z]", "").substring(1, 11);
            }
        }
        return supercombination;
    }*/
}
