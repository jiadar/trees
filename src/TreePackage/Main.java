package TreePackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class Main {
   public static void main(String[] args) {
      doSearch();
      doDictionary();
      doRemoveTest();
   }

   private static void doDictionary() {
      Bictionary<String, String> dict = new Bictionary<>();

      System.out.println("new dict should be empty: " + dict.isEmpty());

      dict.add("Ross", "111-111-1111");
      dict.add("Hunter", "222-222-2222");
      dict.add("Steven", "333-333-3333");
      dict.add("Arpun", "444-444-4444");
      dict.add("Casey", "555-555-5555");
      dict.add("Joe", "666-666-6666");

      System.out.println("Key Traversal: ");
      Iterator<String> keys = dict.getKeyIterator();
      while (keys.hasNext())
         System.out.print(keys.next() + " - ");   
      System.out.println("");

      System.out.println("Value Traversal: ");
      Iterator<String> values = dict.getValueIterator();
      while (values.hasNext())
         System.out.print(values.next() + " - ");
   
      System.out.println("");

      System.out.println(dict.toString());
      
      String ph = dict.remove("Joe");
      System.out.println("Removed Joe's # " + ph);

      System.out.println(dict.toString());

      boolean c = dict.contains("Hunter");
      System.out.println("Dictionary contains Hunter: " + c);

      c = dict.contains("Joe");
      System.out.println("Dictionary contains Joe: " + c);

      ph = dict.getValue("Steven");
      System.out.println("Looked up Steven's # " + ph);

      System.out.println("# Nodes: " + dict.getSize());

      
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
