package partA;
/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */


import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true; //boolean represent continue game
		int guesses = 0;	//counts the number of times the player has guessed.
		
		while(keepGoing) {//will loop until the user doesn't want to after a game
			
			boolean correct = false; //will be false until the user gets their guess exactly correct
			System.out.print("Input the amount of numbers you want to guess for:" +'\t');
			int userNum = input.nextInt(); //asks for the number of random numbers to be generated
			
			LinkedBag<Integer> randomNums = new LinkedBag<>();
			for(int i = 0; i < userNum; i++) {
				randomNums.add((int) (Math.random() * 10) + 1);
			}
			
			System.out.println("Enter " + userNum + " integers in the range from 1 to 10. Entries may be duplicate.");

			while(!correct) {//loops guessing until user guesses correctly
				System.out.print("Input:" + '\t');
				LinkedBag<Integer> userBag = new LinkedBag<>();
				
				int temp = 0;
				for(int i = 0; i < userNum; i++) {//Checks if the input is out of bounds
					temp = input.nextInt();
					while(temp < 1 || temp > 10) {
						System.out.print("The number is not in the range! Please re-enter integer:"+'\t');
						temp = input.nextInt();
					}
					userBag.add(temp);
				}
				
				if(randomNums.equals(userBag)) {//checks if guess is complete correct
					correct = true; //end loop immediately
				}
				else {
					int numCorrect = 0; //number of guess correct
					guesses++;
					
					//array to help check how many guess are correct. 
					Object[] answerArray = randomNums.toArray();
					Object[] guessArray = userBag.toArray();
					
					for(int i = 0; i < userNum; i++) {
						for(int ii = 0; ii < userNum; ii++) {
							if(answerArray[ii].equals(guessArray[i])) {
								numCorrect+=1;
								answerArray[ii] = null;
								break;
							}
						}
					}
					System.out.println(numCorrect + " of your guesses are correct");
				}
			}
			
			System.out.println("You are correct! It only took you " + guesses + " guesses! Play again?");
			String contAnswer = input.next(); //check if user continue
			
			if(contAnswer.toLowerCase().equals("no")) { //if user inputs "no" then game end
				keepGoing = false;
			}
		}
		
		input.close(); //close scanner
		System.out.println("Good Bye!");
	}
}
