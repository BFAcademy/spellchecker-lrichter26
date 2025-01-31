import java.util.*;

public class WordWheel {
    private static String[] wheel1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static String[] wheel2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static String[] wheel3 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static String[] wheel4 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static SpellChecker spell = new SpellChecker();
    private static int wordLimit = 4;

    public static void increment(String[] in) {
        String temp = in[in.length - 1];
        for (int i = in.length - 1; i > 0; i--) {
            in[i] = in[i - 1];
        }
        in[0] = temp;
    }
    public static String combineString(String[] in) {
        String returnString = "";
        for (String s : in) {
            returnString += s + " ";
        }
        return returnString;
    }
    public static int checkWords() {
        int wordsFound = 0;
        List<String> printList = new ArrayList();
        for (int i = 0; i < 26; i++) {
            if (spell.spellcheck(wheel1[i] + wheel2[i] + wheel3[i] + wheel4[i])) {
                wordsFound++;
                printList.add(wheel1[i] + wheel2[i] + wheel3[i] + wheel4[i]);
            }
        }
        if (printList.size() >= wordLimit) {
            System.out.println();
            for (int i = 0; i < printList.size(); i++) {
                System.out.println(printList.get(i));
            }
        }
        return wordsFound;
    }
    public static void printWheels() {
        System.out.println();
        System.out.println(combineString(wheel1));
        System.out.println(combineString(wheel2));
        System.out.println(combineString(wheel3));
        System.out.println(combineString(wheel4));
        System.out.println();
    }
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    increment(wheel3);
                    count++;
                    if (checkWords() >= wordLimit) {
                        printWheels();
                    }
                    if (count % 175 == 0) {
                        System.out.println(count/175 + "% done");
                    }
                }
                increment(wheel2);
                if (checkWords() >= wordLimit) {
                    printWheels();
                }
            }
            increment(wheel1);
            if (checkWords() >= wordLimit) {
                printWheels();
            }
        }
    }
}
