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
      System.out.println("\n Comparing two GinormousInt. Expecting ... 1 " +  "Got: " + zeroes.compareTo(neg));
      System.out.println("\n Comparing two GinormousInt. Expecting ... -1 " +  "Got: " + zeroes.compareTo(pos));
      System.out.println("\n Adding two GinormousInt. Expecting ... 246 " +  "Got: " + zeroes.add(zeroes1));
      System.out.println("\n Adding two GinormousInt. Expecting ... 1098 " +  "Got: " + zeroes5.add(zeroes6));

      GinormousInt one = new GinormousInt("1");
      GinormousInt two = new GinormousInt("2");
      System.out.println("\n Adding two GinormousInt. Expecting ... 3 " +  "Got: " + one.add(two));
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
   

   // returns a GinormousInt whose value is the sum of this plus the argument
   public String add( GinormousInt g ){
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
            combineArray[combineArray.length - i - 1] = ginormousArray[ginormousArray.length - i - 1] + g.ginormousArray[g.ginormousArray.length - i - 1] + carry;
            if (combineArray[combineArray.length - i - 1] > 9) {
               carry = 1;
               combineArray[combineArray.length - i - 1] -= 10;
            } else {
               carry = 0;
            }
         } 

         if (combineArray[combineArray.length - smallerArray.length] > 9 && carry == 1) {
            for (int j = 0; j < combineArray.length - smallerArray.length; j++) {
               combineArray[combineArray.length - smallerArray.length - 1 - j] = combineArray[combineArray.length - smallerArray.length - 1 - j] + carry;
                if (combineArray[combineArray.length - smallerArray.length - 1 - j] > 9) {
                  carry = 1;
                  combineArray[combineArray.length - smallerArray.length - 1 - j] -= 10;
               } 
            }
         } 
         answer = Arrays.toString(combineArray);
      }
      return answer;
   }
   


/*
	
	public GinormousInt subtract( BigInteger value );
	// returns a GinormousInt whose value is the difference of this minus the argument
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
