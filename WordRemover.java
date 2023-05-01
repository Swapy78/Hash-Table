//Java program to remove specific word from phrase

package demo;

//Importing the LinkedList class from the Java util library
import java.util.LinkedList;
//Defining the class
public class WordRemover {

	// Defining the main method that runs the program
	public static void main(String[] args) {
	    
	    // Defining a string containing the paragraph to process
	    String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
	    
// Splitting the paragraph into individual words and store them in an array
	    String[] words = paragraph.split(" ");
	    
	    // Creating a hash table using a linked list, with 100 buckets
	    LinkedList<MyMapNode>[] hashTable = new LinkedList[100];
	    for (int i = 0; i < hashTable.length; i++) {
	        hashTable[i] = new LinkedList<MyMapNode>();
	    }
	    
// Iterating over the words and add them to the hash table, skipping the word "avoidable"
	    for (String word : words) {
	        if (word.equals("avoidable")) {
	            continue; // skipping the word "avoidable"
	        }
	        int hashIndex = Math.abs(word.hashCode() % hashTable.length);
	        LinkedList<MyMapNode> list = hashTable[hashIndex];
	        boolean found = false;
	        for (MyMapNode node : list) {
	            if (node.key.equals(word)) {
	                node.value++;
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            MyMapNode newNode = new MyMapNode(word, 1);
	            list.add(newNode);
	        }
	    }
	    
	    // Creating the updated string without the word "avoidable"
	    StringBuilder sb = new StringBuilder();
	    for (String word : words) {
	        if (!word.equals("avoidable")) {
	            sb.append(word).append(" ");
	        }
	    }
	    String updatedParagraph = sb.toString().trim();
	    
	    // Printing the updated string
	    System.out.println(updatedParagraph);
	}
}
