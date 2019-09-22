package partA;

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
	public boolean add (T anEntry) {
		Node newNode = new Node(anEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries ++;
		return true;
	}


	@Override
	public boolean remove(T anEntry) {
		
		return false;
	}

	@Override
	public T remove() {
		if(firstNode.next != null) {
			Node initial = firstNode;
			firstNode = firstNode.next;
			numberOfEntries--;
			return initial.data;
		}
		else {
			firstNode = null;
		}
		
		return null;
	}

	@Override
	public void clear() {
		firstNode = null;
	}

	@Override
	public boolean contains(T anEntry) {
		Node check = firstNode;
		while(check != null) {
			if(check.equals(anEntry)) {
				return false;
			}
			check = check.next;
		}
		return false;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		Node check = firstNode;
		while(check != null) {
			if(anEntry.equals(check.data)) {
				counter++;
			}
			check = check.next;
		}
		return counter;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		int idx = 0;
		for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			result[idx ++] = currentNode.data;
		}
		return result;
	}


	@Override
	public T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
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


