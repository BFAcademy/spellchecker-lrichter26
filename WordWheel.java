import java.io.IOException;

public class WordWheel {
    private static String[] wheel1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static String[] wheel2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static String[] wheel3 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static String[] wheel4 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

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
            returnString += s;
        }
        return returnString;
    }
    public static int checkWords() throws IOException {
        int wordsFound = 0;
        SpellChecker spell = new SpellChecker();
        for (int i = 0; i < 26; i++) {
            if (spell.spellcheck(wheel1[i] + wheel2[i] + wheel3[i] + wheel4[i])) {
                wordsFound++;
            }
        }
        return wordsFound;
    }
    public static void printWheels() {
        System.out.println(combineString(wheel1));
        System.out.println(combineString(wheel2));
        System.out.println(combineString(wheel3));
        System.out.println(combineString(wheel4));
        System.out.println();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    increment(wheel3);
                    try {
                        if (checkWords() > 1) {
                            printWheels();
                        }
                    }
                    catch (Exception e) {}
                }
                increment(wheel2);
                try {
                    if (checkWords() > 1) {
                        printWheels();
                    }
                }
                catch (Exception e) {}
            }
            increment(wheel1);
            try {
                if (checkWords() > 1) {
                    printWheels();
                }
            }
            catch (Exception e) {}
        }
    }
}
