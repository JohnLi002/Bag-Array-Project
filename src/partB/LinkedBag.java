package partB;

import java.util.Arrays;

public class LinkedBag <T> implements BagInterface <T> {
	private Node  firstNode;
	private int numberOfEntries;
	
	public LinkedBag () {    // empty bag
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		if (firstNode == null) {
			assert (numberOfEntries == 0);
			return true;
		}
		return false;
	}

	@Override
	public boolean add (T anEntry) { //creates a new node with the anEntry as data
		Node newNode = new Node(anEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	@Override
	public boolean remove(T anEntry) {
		if(getCurrentSize() == 0) { //if there is no bag, cannot remove so return false
			return false;
		}
		for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			if(currentNode.data.equals(anEntry) && getCurrentSize() == 1) { // if the only entry is to be removed, just turn firstNode to null
				firstNode = null;
				numberOfEntries--;
				return true;
			} else if(currentNode.data.equals(anEntry)) { //finds correct data
				currentNode.data = firstNode.data; //changes that found data into first node data
				firstNode = firstNode.next; //get rid of firstNode so that second node is first node
				numberOfEntries--; //decrease entries
				return true;
			}
		}
		
		return false;
	}

	@Override
	public T remove() {
		if(firstNode.next != null) { //just takes out first entry
			Node initial = firstNode;
			firstNode = firstNode.next;
			numberOfEntries--;
			return initial.data;
		}
		else {
			firstNode = null; //this means there is either one node or no nodes so just make it null
		}
		
		return null;
	}

	@Override
	public void clear() { //resets everything with no nodes and numberOfEntries = 0
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public boolean contains(T anEntry) {
		Node check = firstNode;
		while(check != null) { //loops while the check is not null (looping until it does hit null)
			if(check.equals(anEntry)) {
				return true; //finds entry
			}
			check = check.next;//check changes to node inside node
		}
		return false;//did not find entry
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		Node check = firstNode;
		while(check != null) { //loops till check becomes null
			if(anEntry.equals(check.data)) {
				counter++; //increases number that represents number of found anEntry
			}
			check = check.next; //changes check so that it is the check inside of check
		}
		return counter;
	}

	@Override
	public T[] toArray() { //creates array which will have all data in bag inputted into it
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		int idx = 0;
		for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			result[idx ++] = currentNode.data;
		}
		return result;
	}


	@Override
	public T[] toArray(T[] input) {
		T[] result = Arrays.copyOf(input, numberOfEntries); //turns input array into the array the be returned
		int idx = 0;
		for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			result[idx++] = currentNode.data; //adds all data from firstNode as it goes
		}
		return result;
	}
	
	public boolean equals(LinkedBag<T> other) {
		if(other.getCurrentSize() != getCurrentSize()) { //size different immediately false
			return false;
		}
		
		LinkedBag<T> given = new LinkedBag<>(); //creates a copy of other
		Node temp = other.firstNode; //recreates first node to be copied
		
		while(temp != null) { //adds all data from temp node into given (copy of other bag)
			given.add(temp.data);
			temp = temp.next;
		}
		Node currentNode = firstNode; //goes through the first node
		while(currentNode != null) {
			if(!given.remove(currentNode.data)) {
				return false; //cannot remove so there is an object other does not have
			}
			currentNode = currentNode.next;
		}
		
		return true;
	}
	public LinkedBag<T> Union(LinkedBag<T> other) { 
		LinkedBag<T> result = new LinkedBag<T>(); //create LinkedBag that will be returned
		Node temp = firstNode;
		while(temp != null) { //adds all objects of this LinkedBag.java
			result.add(temp.data);
			temp = temp.next;
		}
		temp = other.firstNode; //temp now has firstNode of other 
		
		while(temp != null) { //adds all objects of other
			result.add(temp.data);
			temp = temp.next;
		}
		
		return result;
	}
	public LinkedBag<T> Intersection(LinkedBag<T> other) {
		LinkedBag<T> temp = new LinkedBag<>(); //create copy of other
		Node otherData = other.firstNode;
		
		while(otherData != null) { //inputs all data from other into copy
			temp.add(otherData.data);
			otherData = otherData.next;
		}
		
		LinkedBag<T> result = new LinkedBag<>(); //create LinkedBag to be returned
		Node thisData = firstNode;
	
		while(!temp.isEmpty() && thisData != null) { 
			if(temp.remove(thisData.data)) { //loops through and checks if element can be removed
				result.add(thisData.data); //if it can add to result
			}
			thisData = thisData.next; //go to next node
		}
		
		return result;
	}
	
	private class Node {
		private  T data;
		private Node next;

		Node ( T data, Node nextNode) {
			this.data = data;
			next = nextNode;
		}

		Node (T data) {
			this (data, null);
		}
	}
}


