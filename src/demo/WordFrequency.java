//Java program to find frequency of words in a sentence

package demo;

//Importing LinkedList class from java.util package
import java.util.LinkedList;
//defining class WordFrequency
public class WordFrequency {

	//main method
	public static void main(String[] args) {
	    
	    //creating string sentence to store the input string
	    String sentence = "To be or not to be";
	    
//splitting the sentence into individual words and storing them in an array called words
	    String[] words = sentence.split(" ");
	    
	    //creating a hash table using a linked list with 10 buckets
	    LinkedList<MyMapNode>[] hashTable = new LinkedList[10];
	    
	    //initializing each bucket with an empty linked list
	    for (int i = 0; i < hashTable.length; i++) {
	        hashTable[i] = new LinkedList<MyMapNode>();
	    }
	    
	    // iterating over the words and adding them to the hash table
	    for (String word : words) {
	        
	        //getting the hash index for the current word
	        int hashIndex = getHashIndex(word);
	        
	        //getting the linked list for the current hash index
	        LinkedList<MyMapNode> list = hashTable[hashIndex];
	        
	 //flag variable to check if the word is already present in the list
	        boolean found = false;
	        
//iterating over the list to check if the current word is already present in the list
	        for (MyMapNode node : list) {
	            if (node.key.equals(word)) {
	                node.value++;
	                found = true;
	                break;
	            }
	        }
	        
//if the word is not present in the list, adding a new MyMapNode to the list with a value of 1
	        if (!found) {
	            MyMapNode newNode = new MyMapNode(word, 1);
	            list.add(newNode);
	        }
	    }
	    
	    //printing the frequency of each word in the hash table
	    for (LinkedList<MyMapNode> list : hashTable) {
	        for (MyMapNode node : list) {
	            System.out.println(node.key + ": " + node.value);
	        }
	    }
	}

	//method to get the hash index for a given key
	public static int getHashIndex(String key) {
	    int hash = key.hashCode();
	    int index = Math.abs(hash % 10);
	    return index;
	}
}