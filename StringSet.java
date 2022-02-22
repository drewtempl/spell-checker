/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that insert a new 
 * String, finds a String key and prints the contents of the data structure resp.
 */
public class StringSet {

  StringNode [] table;	// Hash table - collisions resolved through chaining.
  int numelements;	// Number of elements actually stored in the structure.
  int size;					// Allocated memory (size of the hash table).

  /** 
   * Constructur: initilaizes numelements, size and initial table size.
   */
  public StringSet() {
    numelements = 0;
    size = 100;
    table = new StringNode[size];
  }

  /*
   * inserts a new key into the set. Inserts it at the head of the linked list given by its hash value.
   */
  public void insert(String key) {

    if (numelements == size) {
      size *= 2;
      StringNode[] oldTable = table;
      table = new StringNode[size];
      numelements = 0;

      for (int i = 0; i < oldTable.length; i++) {
        StringNode node = oldTable[i];
  
        while (node != null) {
          int hash = hash(node.getKey());
          
          if (table[hash] == null) 
            numelements++;
          
          table[hash] = new StringNode(node.getKey(), table[hash]);
          node = node.getNext();
        }
      }
    }
    
    int hash = hash(key);
    if (table[hash] == null)
      numelements++;
      
    table[hash] = new StringNode(key, table[hash]);
  }

  /*
   * finds if a String key is present in the data structure. Returns true if found, else false.
   */
  public boolean find(String key) {
    
    int hash = hash(key);
    boolean found = false;
    StringNode node = table[hash];

    while (node != null && !found) {
      if (node.getKey().equals(key))
        found = true;

      node = node.getNext();
    }

    return found;
  }

  /*
   * Prints the contents of the hash table.
   */
  public void print() {
    
    for (int i = 0; i < table.length; i++) {
      StringNode node = table[i];

      while (node != null) {
        System.out.println(node.getKey());
        node = node.getNext();
      }
    }
  }

  /*
   * The hash function that returns the index into the hash table for a string k.
   */
  private int hash(String k) {
    int h = 0;
    int x = 1171;   // prime number
  
    for (int i = 0; i < k.length(); i++) {
      h = (h * x + (int) k.charAt(i)) % size;
    }

    return h;
  }

}
