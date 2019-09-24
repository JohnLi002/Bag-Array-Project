package partA;

import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true; //boolean represent continue game
		
		while(keepGoing) {//will loop until the user doesn't want to after a game
			
			boolean correct = false; //will be false until the user gets their guess exactly correct
			System.out.println("Input the amount of numbers you want to guess for.");
			int userNum = input.nextInt(); //asks for the number of random numbers to be generated
			
			LinkedBag<Integer> randomNums = new LinkedBag<>();
			for(int i = 0; i < userNum; i++) {
				randomNums.add((int) (Math.random() * 10) + 1);
			}
			
			System.out.println("Enter " + userNum + " integers in the range from 1 to 10. Entries may be duplicate.");

			while(!correct) {//loops guessing until user guesses correctly
				System.out.println("Input guesses");
				LinkedBag<Integer> userBag = new LinkedBag<>();
				
				for(int i = 0; i < userNum; i++) {
					if(input.nextInt() < 1 || input.nextInt() > 10) {
						System.out.println("The number is not in the range! Please enter the integers again.");
						i--;
					}else {
						userBag.add(input.nextInt());
					}
				}
				
				if(randomNums.equals(userBag)) {//checks if guess is complete correct
					correct = true; //end loop immediately
				}
				else {
					int numCorrect = 0; //number of guess correct
					
					//array to help check how many guess are correct. 
					Object[] answerArray =  randomNums.toArray();
					Object[] guessArray = userBag.toArray();
					
					for(int i = 0; i < userNum; i++) {
						for(int ii = 0; ii < userNum; ii++) {
							if(answerArray[ii].equals(guessArray[i])) {
								numCorrect++;
								answerArray[ii] = -1;
								break;
							}
						}
					}
					System.out.println(numCorrect + " of your guesses are correct");
				}
			}
			
			System.out.println("You are correct! Play again?");
			String contAnswer = input.next(); //check if user continue
			
			if(contAnswer.toLowerCase().equals("no")) { //if user inputs "no" then game end
				keepGoing = false;
			}
		}
		
		input.close(); //close scanner
		System.out.println("Good Bye!");
	}
}
