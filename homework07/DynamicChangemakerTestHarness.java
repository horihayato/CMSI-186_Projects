/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DynamicChangemakerTestHarness.java
 *  Purpose       :  Provides a class defining methods for the DynamicChangemakerTestHarness class
 *  @author       :  Hayato Hori
 *  Date written  :  2017-05-02
 *  Description   :  This class provides a bunch of methods which may be useful for the DynamicChangemakerTestHarness class
 *                   for Homework 7.  Includes the following:
 *
 *  Notes         :  Everything should work fine!
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */



public class DynamicChangemakerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        // Add more!
        // A few examples:
        // test_Euros(); // 1,2,5,10,20,50
        // test_SwissFrancs(); // 5,10,20,50 (NO 1 CENT COIN!)
        // test_Keckels(); // 7,3,29,15,53 (Made-up currency with non-standard denominations)

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_USA() {
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(usaDenominations, 99);
        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] randomDenominations = new int[] { 3, 5, 8, 11 };

        Tuple result1 = DynamicChangemaker.makeChangeWithDynamicProgramming(randomDenominations, 55);
        try {
            displaySuccessIfTrue(0 == result1.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result1.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result1.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(5 == result1.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] randomDenominations1 = new int[] { 3, 5, 8, 11 };

        Tuple result2 = DynamicChangemaker.makeChangeWithDynamicProgramming(randomDenominations, 7);
        try {
            displaySuccessIfTrue(result2.isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] randomDenominations2 = new int[] { 3, 5, 8, 11 };

        Tuple result3 = DynamicChangemaker.makeChangeWithDynamicProgramming(randomDenominations, 1234234);
        try {
            displaySuccessIfTrue(0 == result3.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(3 == result3.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result3.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(112201 == result3.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

}
