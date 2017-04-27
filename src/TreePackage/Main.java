package TreePackage;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class Main {
   public static void main(String[] args) {
      doDictionary();
      //doSearch();
      //doRemoveTest();
   }

   private static void doDictionary() {
      Bictionary<String, String> dict = new Bictionary<>(); 
      dict.add("Ross", "415-264-5441");
      dict.add("Hunter", "320-331-1313");
      dict.add("Steven", "113-323-3458");
      dict.add("Arpun", "885-343-3313");
      dict.add("Casey", "918-331-8574");
      dict.add("Joe", "823-131-1173");
   }
   
   private static void doRemoveTest() {
      SearchTreeInterface<Integer>  btree = new BinarySearchTree<Integer>();
      btree.add(10);
      btree.add(3);
      btree.add(20);
      btree.add(17);
      btree.add(1);
      btree.add(4);
      btree.add(13);
      System.out.println(btree.toString());
      btree.remove(3);
      System.out.println(btree.toString());
      btree.remove(13);
      System.out.println(btree.toString());
      btree.remove(10);
      System.out.println(btree.toString());
   }
   
   private static void doSearch() {
      int SIZE=100000;
      long startTime, endTime, duration;

      System.out.println("Hello BST!");
      SearchTreeInterface<Integer>  b = new BinarySearchTree<Integer>();
      ArrayList<Integer> a = new ArrayList<Integer>();

      System.out.println("Generating...");
      for(int i=0; i<SIZE; i++) {
         Integer num = ThreadLocalRandom.current().nextInt(1, SIZE*16);
         a.add(num);
         b.add(num);
      }

      System.out.println("Searching BST...");
      startTime = System.nanoTime();
      for(int i=0; i<1000; i++) {
         b.contains(i);
      }
      endTime = System.nanoTime();
      System.out.println("Binary Tree Search: " + ms(startTime, endTime) + " ms");
      //      System.out.println(b.toString());

      System.out.println("Searching Array List...");
      startTime = System.nanoTime();
      for(int i=0; i<1000; i++) {
         a.contains(i);  
      }      
      endTime = System.nanoTime();
      System.out.println("Array List Search: " + ms(startTime, endTime) + " ms");
   }

   private static String ms(long s, long e) {
      return "" + (e-s)/1000000;        
   }
}
