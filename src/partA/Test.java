package partA;

public class Test {

	public static void main(String[] args) {
		LinkedBag<Integer> bag1 = new LinkedBag<>();
		System.out.println(bag1.isEmpty()); //tests if the isEmpty method works when bag is empty
		bag1.add(1); //changes bag to have 1,2,3
		bag1.add(2);
		bag1.add(3);
		System.out.println(bag1.isEmpty()); //tests if the isEmpty method works when bag has something
		
		LinkedBag<Integer> bag2 = new LinkedBag<>(); //creates new bag to test other methods
		bag2.add(2); //changes bag to have 2,4,5,6,7,8
		bag2.add(4);
		bag2.add(5);
		bag2.add(6);
		bag2.add(7);
		bag2.add(8);
		
		System.out.println(bag1.remove(4)); //should return false (4 is not in bag)
		System.out.println(bag1.remove(3)); //should return true (3 is in bag)
		
		Integer[] a = (Integer[]) bag1.toArray(new Integer[1]);//testing out if the remove(parameter) method and the toArray(parameter) method works
		for(int i = 0; i < bag1.getCurrentSize(); i++) {
			System.out.println(a[i]); //to test if the the removed element is truly removed and if the toArray(parameter) works
		}
		
		System.out.println(bag2.remove(5)); //should return true
		Object[] b = bag2.toArray(); //tests if the toArray() method works and if object is removed
		for(int i = 0; i < bag2.getCurrentSize(); i++) {
			System.out.println(b[i]); //prints out array to see if it works (if there is still a five it doesn't work)
		}
		
		bag1.clear(); //changes bag to have 1,2,3
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);
		
		bag2.clear(); //changes bag to have 1, 2
		bag2.add(1);
		bag2.add(2);
		
		System.out.println();
		LinkedBag<Integer> intersection = bag2.Intersection(bag1); //testing intersection method
		Object[] c = intersection.toArray(new Integer[1]);
		for(int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		
		System.out.println();
		
		bag1.clear(); //changes bag so that it holds 2,4,6
		bag1.add(2);
		bag1.add(4);
		bag1.add(6);
		
		bag2.clear(); //changes bag to hold 1,3
		bag2.add(1);
		bag2.add(3);
		
		LinkedBag<Integer> union = bag2.Union(bag1);//testing union method
		Object[] d = union.toArray(new Integer[1]);
		for(int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		
		bag1.clear(); //remake bag1 to be just like bag2
		bag1.add(1);
		bag1.add(3);
		
		System.out.print(bag1.equals(bag2)); //prints out boolean if bag1 equals bag2
	}
}
