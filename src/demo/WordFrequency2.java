//Java program to find frequency of words in a large paragragh phrase

package demo;

//Importing LinkedList class from Java Util package
import java.util.LinkedList;
//Class declaration for WordFrequency2
public class WordFrequency2 {

	// Main method
	public static void main(String[] args) {
		
		// Input string
		String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		
		// Splitting the string into array of words
		String[] words = paragraph.split(" ");
		
		// creating a hash table using a linked list
		LinkedList<MyMapNode>[] hashTable = new LinkedList[100];
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new LinkedList<MyMapNode>();
		}
		
		// iterating over the words and add them to the hash table
		for (String word : words) {
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
		
		// printing the frequency of each word
		for (LinkedList<MyMapNode> list : hashTable) {
			for (MyMapNode node : list) {
				System.out.println(node.key + ": " + node.value);
			}
		}
	}
}