/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DynamicChangemaker.java
 *  Purpose       :  Provides a class defining methods for the DynamicChangemaker class
 *  @author       :  Hayato Hori
 *  Date written  :  2017-05-02
 *  Description   :  This class provides a bunch of methods which may be useful for the DynamicChangemaker class
 *                   for Homework 7.  Includes the following:
 *
 *  Notes         :  Everything should work fine!
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class DynamicChangemaker {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }

    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
        Tuple[][] table = new Tuple[denominations.length][amount + 1];
        Tuple answer = new Tuple(denominations.length);

        // Loops through each denomination
        for (int i = 0; i < denominations.length; i++) {
            // Loops through amount of coin
            for (int j = 0; j < amount + 1; j++) {
                // If the coin index is less than the denomination, Tuple is impossible.
                if (j < denominations[i]) {
                    // Establishes 0, at very beginning of table count, otherwise Tuple is impossible
                    if (j == 0) {
                        table[i][0] = new Tuple(denominations.length);
                    } else {
                        table[i][j] = Tuple.IMPOSSIBLE;    
                    }
                } else {
                    int remainder = j - denominations[i];
                    table[i][j] = new Tuple (denominations.length);
                    table[i][j].setElement(i, 1);

                    // Go back remainder spaces and see if Tuple is impossible or not
                    if (!table[i][remainder].isImpossible()) {
                        table[i][j] = table[i][j].add(table[i][remainder]);
                    } else {
                        table[i][j] = Tuple.IMPOSSIBLE;
                    }
                }

                // Look up and see if there is anything above. If so, bring it down to current array
                // Gets the most optimal change
                if (i > 0) {
                    if (table[i][j].isImpossible() && !table[i - 1][j].isImpossible()) {
                        table[i][j] = table[i - 1][j];
                    } else if (!table[i][j].isImpossible() && !table[i - 1][j].isImpossible()) {
                        if (table[i][j].total() > table[i - 1][j].total()) {
                            table[i][j] = table[i - 1][j];
                        }
                    }
                }

                answer = table[i][j];

            }
        }
        return answer;
    }

    private static void printUsage() {
        System.out.println("Usage: java DynamicChangemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
