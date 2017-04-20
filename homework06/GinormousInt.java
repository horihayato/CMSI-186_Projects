/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  GinormousInt.java
 *  Purpose       :  Provides a class defining methods for the GinormousInt class
 *  @author       :  Hayato Hori
 *  Date written  :  2017-04-20
 *  Description   :  This class provides a bunch of methods which may be useful for the GinormousInt class
 *                   for Homework 6.  Includes the following:
 *
 *  Notes         :  Have not completed Multiplication and Division. Subtraction and Addition should work perfectly fine!
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */



import java.lang.String;
import java.lang.StringBuffer;
import java.lang.Object;
import java.util.Arrays;



public class GinormousInt {
   // a GinormousInt classwide constant for zero
   public static final GinormousInt ZERO = new GinormousInt("0");
   // a GinormousInt classwide constant for one
   public static final GinormousInt ONE = new GinormousInt("1");
   // a GinormousInt classwide constant for ten
   public static final GinormousInt TEN = new GinormousInt("10");
   private String initialVal = "";
   private int[] ginormousArray;
   private int posNegZero;

   public static void main(String[] args) {
      GinormousInt neg = new GinormousInt("-3412343214132412342343241341324123421432341243214131");
      GinormousInt pos = new GinormousInt("3412343214132412342343241341324123421432341243214131");
      GinormousInt zeroes = new GinormousInt("0123");
      GinormousInt zeroes1 = new GinormousInt("000123");
      GinormousInt zeroes2 = new GinormousInt("0000123");
      GinormousInt zeroes3 = new GinormousInt("-0010123");
      GinormousInt zeroes4 = new GinormousInt("0010123");
      GinormousInt zeroes5 = new GinormousInt("999");
      GinormousInt zeroes6 = new GinormousInt("99");
      GinormousInt zeroes7 = new GinormousInt("911");
      GinormousInt zeroes8 = new GinormousInt("99");
      GinormousInt zeroes9 = new GinormousInt("1");
      GinormousInt zeroes10 = new GinormousInt("2");
      GinormousInt zeroes11 = new GinormousInt("-25");
      GinormousInt zeroes12 = new GinormousInt("50");
      System.out.println("\n Creating a negative GinormousInt: " + neg.toString());
      System.out.println("\n Creating a positive GinormousInt: " + pos.toString());
      System.out.println("\n Creating a positive GinormousInt: " + zeroes.toString());
      System.out.println("\n Creating a positive GinormousInt: " + zeroes1.toString());
      System.out.println("\n Creating a positive GinormousInt: " + zeroes2.toString());
      System.out.println("\n Creating a negative GinormousInt: " + zeroes3.toString());
      System.out.println("\n Creating a positive GinormousInt: " + zeroes4.toString());
      System.out.println("\n Is -3412343214132412342343241341324123421432341243214131 positive? " + neg.isPositive());
      System.out.println("\n Is 3412343214132412342343241341324123421432341243214131 positive? " + pos.isPositive());
      System.out.println("\n Comparing two GinormousInt. Expecting ... 0 " +  "Got: " + zeroes.compareTo(zeroes1));
      System.out.println("\n Comparing two GinormousInt. Expecting ... true " +  "Got: " + zeroes.equals(zeroes1));
      System.out.println("\n Comparing two GinormousInt. Expecting ... 1 " +  "Got: " + zeroes.compareTo(neg));
      System.out.println("\n Comparing two GinormousInt. Expecting ... -1 " +  "Got: " + zeroes.compareTo(pos));
      System.out.println("\n Adding two GinormousInt. Expecting ... 246 " +  "Got: " + zeroes.add(zeroes1));
      System.out.println("\n Adding two GinormousInt. Expecting ... 1098 " +  "Got: " + zeroes5.add(zeroes6));
      System.out.println("\n Adding two GinormousInt. Expecting ... double pos " +  "Got: " + pos.add(pos));
      System.out.println("\n Adding two GinormousInt. Expecting ... -20246 " +  "Got: " + zeroes3.add(zeroes3));
      System.out.println("\n Subtracting two GinormousInt. Expecting ... 812 " +  "Got: " + zeroes7.subtract(zeroes8));
      System.out.println("\n Subtracting two GinormousInt. Expecting ... -812 " +  "Got: " + zeroes8.subtract(zeroes7));
      System.out.println("\n Subtracting two GinormousInt. Expecting ... -1 " +  "Got: " + zeroes9.subtract(zeroes10));
      System.out.println("\n Subtracting two GinormousInt. Expecting ... 1 " +  "Got: " + zeroes10.subtract(zeroes9));
      System.out.println("\n Subtracting two GinormousInt. Expecting ... 75 " +  "Got: " + zeroes12.subtract(zeroes11));
      System.out.println("\n Subtracting two GinormousInt. Expecting ... -75 " +  "Got: " + zeroes11.subtract(zeroes12));
      System.out.println("\n Subtracting two GinormousInt. Expecting ... 0 " +  "Got: " + zeroes11.subtract(zeroes11));

      GinormousInt one = new GinormousInt("8");
      GinormousInt two = new GinormousInt("5");
      System.out.println("\n Adding two GinormousInt. Expecting ... 13 " +  "Got: " + one.add(two));
   }

	public GinormousInt( String value ) {
      try{
         initialVal = new String(value);
         
         // If number starts with 0 and is positive
         if (value.charAt(0) == '0') {
            int count = 1;
            for (int i = 0; i < value.length() - 1; i++) {
               if (value.charAt(i) == '0' && value.charAt(i + 1) == '0') {
                  count++;
               }
            }

            value = value.substring(count);
         }

         // If it is a negative number, store the sign in a char Array
         if (initialVal.charAt(0) == '-') {
            posNegZero = -1;
            value = value.substring(1);

            if (value.charAt(0) == '0') {
            int count = 1;
               for (int i = 0; i < value.length() - 1; i++) {
                  if (value.charAt(i) == '0' && value.charAt(i + 1) == '0') {
                     count++;
                  }
               }

               value = value.substring(count);
            }

            ginormousArray = new int[value.length()];

            for (int i = 0; i < value.length(); i++) {
               ginormousArray[i] = Integer.parseInt(String.valueOf(value.charAt(i)));
            }

         
         // If not a negative number, store normally   
         } else {
            posNegZero = 1;
            ginormousArray = new int[value.length()];

            for (int i = 0; i < value.length(); i++) {
               ginormousArray[i] = Integer.parseInt(String.valueOf(value.charAt(i)));
            }
         }
         
      } catch (NumberFormatException ex) {
         throw new NumberFormatException("Sorry, GinormousInt must be numbers only.");
      }
   }

   public boolean isPositive() {
      if (posNegZero == -1) {
         return false;
      }
      return true;
   }

   // returns the decimal string represention of this GinormousInt
   public String toString() {
      String finalAnswer = "";
      String temp = "";
      if (posNegZero == -1) {
         for (int i = 0; i < ginormousArray.length; i++) {
            temp += Integer.toString(ginormousArray[i]);
         }
         finalAnswer = "-" + temp;
      } else {
         for (int i = 0; i < ginormousArray.length; i++) {
            finalAnswer += Integer.toString(ginormousArray[i]);
         }
      }

      return finalAnswer;
   }

   // returns -1/0/1 as this GinormousInt is numerically less than/equal to/greater than the value passed as the argument
   public int compareTo( GinormousInt g ) {

      // If both numbers are positive
      if (g.isPositive() == true && isPositive() == true) {
         if (ginormousArray.length > g.ginormousArray.length) {
            return 1;
         } else if (ginormousArray.length < g.ginormousArray.length) {
            return -1;
         } else if (ginormousArray.length == g.ginormousArray.length) {
            for (int i = 0; i < ginormousArray.length; i++) {
               if (ginormousArray[i] > g.ginormousArray[i]) {
                  return 1;
               } else if (ginormousArray[i] < g.ginormousArray[i]) {
                  return -1;
               } else if (ginormousArray[i] == g.ginormousArray[i]) {
                  return 0;
               }
            }
         }
      } else if (g.isPositive() == false && isPositive() == false) {
         if (ginormousArray.length < g.ginormousArray.length) {
            return 1;
         } else if (ginormousArray.length > g.ginormousArray.length) {
            return -1;
         } else if (ginormousArray.length == g.ginormousArray.length) {
            for (int i = 1; i < ginormousArray.length + 1; i++) {
               if (ginormousArray[i] < g.ginormousArray[i]) {
                  return 1;
               } else if (ginormousArray[i] > g.ginormousArray[i]) {
                  return -1;
               } else if (ginormousArray[i] == g.ginormousArray[i]) {
                  return 0;
               }
            }
         }
      }

      // If only one of the numbers is positive
      if (isPositive() == true && g.isPositive() == false) {
         return 1;
      } else {
         return -1;
      }
   }

   // returns true iff x is a GinormousInt whose value is numerically equal to this GinormousInt
   public boolean equals(GinormousInt g) {
      if (compareTo(g) == 0) {
         return true;
      }
      return false;
   }

   

   // returns a GinormousInt whose value is the sum of this plus the argument
   public String add(GinormousInt g){
      int[] combineArray;
      int carry = 0;
      int[] smallerArray;
      String answer = "";

      // Gives one more space in array to combine numbers
      if (compareTo(g) == 1) {
         combineArray = new int[ginormousArray.length + 1];

         for(int i = 0; i < ginormousArray.length; ++i) {
            combineArray[combineArray.length - 1 - i] = ginormousArray[ginormousArray.length - 1 - i];
         }

         smallerArray = g.ginormousArray.clone();
      } else {
         combineArray = new int[g.ginormousArray.length + 1];
         combineArray = g.ginormousArray.clone();
         smallerArray = ginormousArray.clone();
      }

      // Adds positive numbers
      if (isPositive() == true && g.isPositive() == true) {

         for (int i = 0; i < smallerArray.length; i++) {
            combineArray[combineArray.length - 1 - i] += smallerArray[smallerArray.length - 1 - i];
         }

         for (int i = 0; i < combineArray.length - 1; i++) {
            if (combineArray[combineArray.length - 1 - i] > 9) {
               combineArray[combineArray.length - 2 - i] += 1;
               combineArray[combineArray.length - 1 - i] -= 10;
            }
         }         
         StringBuffer result = new StringBuffer();
         for (int i = 0; i < combineArray.length; i++) {
            result.append(combineArray[i]);
         }
         answer = result.toString();
      }

      // Adds negative numbers
      if (isPositive() == false && g.isPositive() == false) {
         for (int i = 0; i < smallerArray.length; i++) {
            combineArray[combineArray.length - 1 - i] += smallerArray[smallerArray.length - 1 - i];
         }

         for (int i = 0; i < combineArray.length; i++) {
            if (combineArray[combineArray.length - 1 - i] > 9) {
               combineArray[combineArray.length - 2 - i] += 1;
               combineArray[combineArray.length - 1 - i] -= 10;
            }
         }
         StringBuffer result = new StringBuffer();
         for (int i = 0; i < combineArray.length; i++) {
            result.append(combineArray[i]);
         }
         answer = "-" + result.toString();
      }

      // Adds one positive number and one negative number
      if (isPositive() == true && g.isPositive() == false || isPositive() == false && g.isPositive() == true) {
         subtract(g);
         StringBuffer result = new StringBuffer();
         for (int i = 0; i < ginormousArray.length; i++) {
            result.append(ginormousArray[i]);
         }
         answer = result.toString();
      }



      return answer;
   }

   
   // returns a GinormousInt whose value is the difference of this minus the argument
   public String subtract(GinormousInt g) {
      int[] combineArray;
      int carry = 0;
      int[] smallerArray;
      String answer = "";

      // Gives one more space in array to combine numbers
      if (compareTo(g) == 1) {
         combineArray = new int[ginormousArray.length + 1];

         for(int i = 0; i < ginormousArray.length; ++i) {
            combineArray[combineArray.length - 1 - i] = ginormousArray[ginormousArray.length - 1 - i];
         }

         smallerArray = g.ginormousArray.clone();
      } else {
         combineArray = new int[g.ginormousArray.length + 1];
         combineArray = g.ginormousArray.clone();
         smallerArray = ginormousArray.clone();
      }

      // Subtracts Both positive numbers
      if (isPositive() == true && g.isPositive() == true) {
         for (int i = 0; i < smallerArray.length; i++) {
            combineArray[combineArray.length - 1 - i] -= smallerArray[smallerArray.length - 1 - i];
         }

         for (int i = 0; i < combineArray.length; i++) {
            if (combineArray[combineArray.length - 1 - i] < 0) {
               combineArray[combineArray.length - 2 - i] -= 1;
               combineArray[combineArray.length - 1 - i] += 10;
            }
         }

         if (compareTo(g) == 1 || compareTo(g) == 0) {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < combineArray.length; i++) {
               result.append(combineArray[i]);
            }
            answer = result.toString();           
         } else {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < combineArray.length; i++) {
               result.append(combineArray[i]);
            }
            answer = "-" + result.toString();
         }
      }

      // Subtracts if first one is positive and second is negative
      if (isPositive() == true && g.isPositive() == false) {
         for (int i = 0; i < smallerArray.length; i++) {
            combineArray[combineArray.length - 1 - i] += smallerArray[smallerArray.length - 1 - i];
         }

         for (int i = 0; i < combineArray.length; i++) {
            if (combineArray[combineArray.length - 1 - i] > 9) {
               combineArray[combineArray.length - 2 - i] += 1;
               combineArray[combineArray.length - 1 - i] -= 10;
            }
         }         
         StringBuffer result = new StringBuffer();
         for (int i = 0; i < combineArray.length; i++) {
            result.append(combineArray[i]);
         }
         answer = result.toString();
      } 

      // Subtracts if first one is negative and second is positive
      if (isPositive() == false && g.isPositive() == true) {
         for (int i = 0; i < smallerArray.length; i++) {
            combineArray[combineArray.length - 1 - i] += smallerArray[smallerArray.length - 1 - i];
         }

         for (int i = 0; i < combineArray.length; i++) {
            if (combineArray[combineArray.length - 1 - i] > 9) {
               combineArray[combineArray.length - 2 - i] += 1;
               combineArray[combineArray.length - 1 - i] -= 10;
            }
         }

         StringBuffer result = new StringBuffer();
         for (int i = 0; i < combineArray.length; i++) {
            result.append(combineArray[i]);
         }
         answer = "-" + result.toString();
      }

      //Subtracts Both negative numbers
      if (isPositive() == false && g.isPositive() == false) {
         for (int i = 0; i < smallerArray.length; i++) {
            combineArray[combineArray.length - 1 - i] -= smallerArray[smallerArray.length - 1 - i];
         }

         for (int i = 0; i < combineArray.length; i++) {
            if (combineArray[combineArray.length - 1 - i] < 0) {
               combineArray[combineArray.length - 2 - i] -= 1;
               combineArray[combineArray.length - 1 - i] += 10;
            }
         }

         if (compareTo(g) == 1 || compareTo(g) == 0) {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < combineArray.length; i++) {
               result.append(combineArray[i]);
            }
            answer = "-" + result.toString();          
         } else {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < combineArray.length; i++) {
               result.append(combineArray[i]);
            }
            answer = result.toString();
         }
      }

      return answer;  
   }
   
   


/*
	public GinormousInt multiply( BigInteger value );
	// returns a GinormousInt whose value is the product of this times the argument
	public GinormousInt divide( BigInteger value );
	// returns a GinormousInt whose value is the quotient of this divided by the argument
	public GinormousInt remainder( BigInteger value );
	// returns a GinormousInt whose value is the remainder of this divided by the argument
	public static GinormousInt valueOf( long value );
	// a GinormousInt "static factory" for constructing GinormousInt out of longs
*/
}
