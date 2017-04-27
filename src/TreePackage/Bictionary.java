package TreePackage;

import java.util.Iterator;
import java.io.*;

public class Bictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
{
   private BinarySearchTree<Entry<K, V>> st;

   public Bictionary() {
      st = new BinarySearchTree<Entry<K, V>>();
   }
   
   public V add(K key, V value) {
      V result = null;
      Entry<K, V> e = new Entry<>(key, value);
      Entry<K, V> r = st.add(e);
      
      if (r != null)
			result = r.data;
      
      return result;
   }

   public V remove(K key) {
      Entry<K, V> e = new Entry<>(key, null);
      Entry<K, V> r = st.remove(e);
      return r.data;
   }
   
   public V getValue(K key) {
      Entry<K, V> e = new Entry<>(key, null);
      Entry<K, V> r = st.getEntry(e);
      return r.data;
   }
   
   public boolean contains(K key) {
      boolean result = false;
      Entry<K, V> e = new Entry<>(key, null);
      System.out.println("Running: st.contains(" + e.getKey() + ")");
      result = st.contains(e);
      return result;
   }

   public Iterator<K> getKeyIterator() {
      return new KeyIterator();
   }

   private class KeyIterator implements Iterator<K> {
      Iterator<Entry<K, V>> itr;

      public KeyIterator() {
         itr = st.getInorderIterator();
      }
      
      public boolean hasNext() {
         return itr.hasNext();
      }

      public K next() {
         Entry<K, V> n = itr.next();
         return n.getKey();
      }

      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   public Iterator<V> getValueIterator() {
      return new ValueIterator();
   }

   private class ValueIterator implements Iterator<V> {
      Iterator<Entry<K, V>> itr;

      public ValueIterator() {
         itr = st.getInorderIterator();
      }
      
      public boolean hasNext() {
         return itr.hasNext();
      }

      public V next() {
         Entry<K, V> n = itr.next();
         return n.getData();
      }

      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   public boolean isEmpty() {
      return st.isEmpty();
   }
   
   public int getSize() {
      return st.getNumberOfNodes();
   }

   public void clear() {
      st.clear();
   }

   public String toString() {
      return st.toString();
   }
   
   private class Entry<S extends Comparable<? super S>, T>
      implements Comparable<Entry<S, T>> {

      public S key;
      public T data;

      private Entry(S k, T d) {
         key = k;
         data = d;
      }

      public S getKey() { return key; }
      public T getData() { return data; }
      
      public int compareTo(Entry<S, T> other) {
         return key.compareTo(other.getKey());
      }

      public boolean equals(Entry<S, T> other) {
         return key.compareTo(other.getKey())==0;
      }

      public String toString() {
         return key.toString() + ": " + data.toString();
      }
   }
}

