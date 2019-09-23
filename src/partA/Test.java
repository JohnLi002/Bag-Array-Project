package partA;

public class Test {

	public static void main(String[] args) {
		LinkedBag<Integer> bag1 = new LinkedBag<>();
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);
		
		LinkedBag<Integer> bag2 = new LinkedBag<>();
		bag2.add(3);
		bag2.add(4);
		bag2.add(5);
		bag2.add(6);
		bag2.add(7);
		bag2.add(8);
		
		System.out.println(bag1.remove(4)); //should return false
		System.out.println(bag1.remove(3)); //should return true
		
		Integer[] a = (Integer[]) bag1.toArray(new Integer[1]);
		for(int i = 0; i < bag1.getCurrentSize(); i++) {
			System.out.println(a[i]);
		}
		
		System.out.println(bag2.remove(5));
		Object[] b = bag2.toArray();
		for(int i = 0; i < bag2.getCurrentSize(); i++) {
			System.out.println(b[i]);
		}
		

	}

}
