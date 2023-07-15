import java.util.Scanner;
import java.lang.Math;

class BookCricketGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 1 To Start The Game And 0 For Exit : ");
		int start = sc.nextInt();
		if(start==1) {
			startGame();
		}
		else if(start==0) {
			System.out.println("GAME EXITTED");
		}
		else {
			System.out.println("INVALID INPUT");
		}	

	}
	
	private static int getRandomNumberTill300() {
		int randomNumber = (int) (Math.random() * 299) + 1;
		return randomNumber;
	}

	private static int startGame() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Player 1 Name : ");
		String PlayerOne = sc.next();
		System.out.print("Enter Player 2 Name : ");
		String PlayerTwo = sc.next();
		int PointOne = 0;
		int RoundOne = 0;
		System.out.println("Player : " + PlayerOne + "\n");
		System.out.print("Enter 1 to Open Book : ");
		int OpenBook = sc.nextInt();
		while (OpenBook == 1 ) {
			RoundOne++;
			int pn = getRandomNumberTill300();
			int RoundPoint = pn % 7;
			System.out.println("Page Number " + pn + " \tPoint : " + RoundPoint + "\tScore : " + (PointOne + RoundPoint) + " ");
			if (RoundPoint == 0) {
				break;
			} else {
				PointOne += RoundPoint;
			}
			System.out.print("Enter 1 to Open Book : ");
			OpenBook = sc.nextInt();
		}
		System.out.println(PlayerOne + " Total Score : " + PointOne + "\n");
		System.out.println(PlayerOne + " Takes " + RoundOne + " Rounds");

		int PointTwo = 0;
		int roundTwo = 0;

		System.out.println(PlayerTwo + " Needs " + (PointOne + 1) + " in "+RoundOne+"rounds To WIN MATCH");
		System.out.println("Player : " + PlayerTwo + "\n");
		System.out.print("Enter 1 to Open Book : ");
		OpenBook = sc.nextInt();
		int roundOneCopy = RoundOne;
		while (OpenBook == 1 && roundOneCopy > 0) {
			roundTwo++;
			int pn = getRandomNumberTill300();
			int RoundPoint = pn % 7;

			roundOneCopy--;
			System.out.println("Page Number " + pn + " \tPoint : " + RoundPoint + "\tScore : " + (PointTwo + RoundPoint)+ "\tRound Left :" + roundOneCopy + " ");
			if (RoundPoint == 0) {
				break;
			} else {
				PointTwo += RoundPoint;
			}

			if (PointTwo > PointOne) {
				System.out.println(PlayerTwo + " Win Match !!\n");
				return 2;
			}
			System.out.print("Enter 1 to Open Book : ");
			OpenBook = sc.nextInt();
		}
		if (PointOne == PointTwo) {
			System.out.println("Match Draw");
			return 0;
		}

		System.out.println(PlayerOne + " Win Match !!\n");
		return 1;

	}


}