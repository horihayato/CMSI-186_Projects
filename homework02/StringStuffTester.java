   /*
   * @return void
   */
public class StringStuffTester {
   public static void main ( String [] args ) {

      test_containsVowel();      // fill in how many tests
      test_isPalindrome();       // fill in how many tests
      test_evensOnly();          // fill in how many tests
      test_oddsOnly();           // fill in how many tests
      test_evensOnlyNoDupes();   // fill in how many tests
      test_oddsOnlyNoDupes();    // fill in how many tests
      test_reverse();            // fill in how many tests
   }

  /**
   * test method to test out the operation of the containsVowel method
   */
   public static void test_containsVowel() {
      System.out.println( " FOUR TESTS FOR containsVowel():" );

      System.out.print( "   Test for containsVowel: " );
      try { System.out.println( StringStuff.containsVowel("a") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for containsVowel: " );
      try { System.out.println( StringStuff.containsVowel("I went to the park") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for containsVowel: " );
      try { System.out.println( StringStuff.containsVowel("try") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for containsVowel: " );
      try { System.out.println( StringStuff.containsVowel("went") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the isPalindrome method
   */
   public static void test_isPalindrome() {
      System.out.println( " FIVE TESTS FOR isPalindrome():" );

      System.out.print( "   Test for isPalindrome: " );
      try { System.out.println( StringStuff.isPalindrome("aba") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for isPalindrome: " );
      try { System.out.println( StringStuff.isPalindrome("a") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for isPalindrome: " );
      try { System.out.println( StringStuff.isPalindrome("dog") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for isPalindrome: " );
      try { System.out.println( StringStuff.isPalindrome("234") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for isPalindrome: " );
      try { System.out.println( StringStuff.isPalindrome("") ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the evensOnly method
   */
   public static void test_evensOnly() {
      System.out.println( " One TESTS FOR evensOnly():" );

      System.out.print( "   Test for evensOnly(): " );
      try { System.out.println( "RHRL".equals(StringStuff.evensOnly("REHEARSALS")) ? "RHRL" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for evensOnly(): " );
      try { System.out.println( "Hll".equals(StringStuff.evensOnly("Hello")) ? "Hll" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the oddsOnly method
   */
   public static void test_oddsOnly() {
      System.out.println( " TWO TESTS FOR oddsOnly():" );

      System.out.print( "   Test for oddsOnly(): " );
      try { System.out.println( "yooes".equals(StringStuff.oddsOnly("xylophones")) ? "yooes" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for oddsOnly(): " );
      try { System.out.println( "YooES".equals(StringStuff.oddsOnly("XYloPHonES")) ? "YooES" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

   public static void test_reverse() {
      System.out.println( " TWO TESTS FOR reverse():" );

      System.out.print( "   Test for reverse(): " );
      try { System.out.println( "olleH".equals(StringStuff.reverse("Hello")) ? "olleH" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for reverse(): " );
      try { System.out.println( "05".equals(StringStuff.reverse("50")) ? "05" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }
   }

   public static void test_oddsOnlyNoDupes() {
      System.out.println( " TWO TESTS FOR oddsOnlyNoDupes():" );

      System.out.print( "   Test for oddsOnlyNoDupes(): " );
      try { System.out.println( "yoes".equals(StringStuff.oddsOnlyNoDupes("xylophones")) ? "yoes" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for oddsOnlyNoDupes(): " );
      try { System.out.println( "ayo".equals(StringStuff.oddsOnlyNoDupes("Hayato")) ? "ayo" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the evensOnlyNoDupes method
   */
   public static void test_evensOnlyNoDupes() {
      System.out.println( " TWO TESTS FOR evensOnlyNoDupes():" );

      System.out.print( "   Test for evensOnlyNoDupes(): " );
      try { System.out.println( "RHL".equals(StringStuff.evensOnlyNoDupes("REHEARSALS")) ? "RHL" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for evensOnlyNoDupes(): " );
      try { System.out.println( "r".equals(StringStuff.evensOnlyNoDupes("Soccer")) ? "r" : "does not work" ); }
      catch( Exception e ) { System.out.println ( false ); }
   }
 }
