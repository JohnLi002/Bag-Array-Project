package partB;

import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;
		
		while(keepGoing) {
			boolean correct = false;
			System.out.println("Input the amount of numbers you want to guess for.");
			int userNum = input.nextInt();
			
			LinkedBag<Integer> randomNums = new LinkedBag<>();
			for(int i = 0; i < userNum; i++) {
				randomNums.add((int) (Math.random() * 10) + 1);
			}
			
			System.out.println("Enter " + userNum + " integars in the range from 1 to 10. Entries may be duplicate.");

			while(!correct) {
				System.out.println("Input guesses");
				LinkedBag<Integer> userBag = new LinkedBag<>();
				
				for(int i = 0; i < userNum; i++) {
					userBag.add(input.nextInt());
				}
				
				if(randomNums.equals(userBag)) {
					correct = true;
				}
				else {
					int numCorrect = 0;
					Object[] answerArray =  randomNums.toArray();
					Object[] guessArray = userBag.toArray();
					
					for(int i = 0; i < userNum; i++) {
						for(int ii = 0; ii < userNum; ii++) {
							if(answerArray[ii].equals(guessArray[i])) {
								numCorrect++;
								System.out.println(answerArray[ii]);
								answerArray[ii] = -1;
								break;
							}
						}
					}
					System.out.println(numCorrect + " of your guesses are correct");
				}
			}
			
			System.out.println("You are correct! Play again?");
			String contAnswer = input.next();
			
			if(contAnswer.toLowerCase().equals("no")) {
				keepGoing = false;
			}
		}
		
		input.close();
		System.out.println("Good Bye!");
	}
}
