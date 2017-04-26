package TreePackage;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
   public static void main(String[] args) {
      doSearch();
      doRemoveTest();
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
