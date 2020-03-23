
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacMain {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char[][] map = { {' ', '|' ,' ' ,'|' , ' '},

						   {'-','+','-','+', '-'},
						   
						   {' ', '|' ,' ', '|',' '},
						   
						   {'-', '+','-' ,'+' ,'-'},
						   
						   {' ', '|' ,' ' ,'|' , ' '}
						 
		  				 };
		ausgeben (map);
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your Placement 1-9");
			int playerPosition = scanner.nextInt();
			
			while (playerPositions.contains(playerPosition)||cpuPosition.contains(playerPosition)) {
				System.out.println("POSITION TAKEN!Please Verify your poisition");
				playerPosition = scanner.nextInt();
			}
			placePosition(map,playerPosition,"Player");
			
			String result = win();
			if (result.length()>0) {
				System.out.println(result);
				break;
				}
			Random rand =  new Random();
			int positionRandom = rand.nextInt(9)+1;
			while (playerPositions.contains(positionRandom)||cpuPosition.contains(positionRandom)) {
				positionRandom = rand.nextInt(9)+1;
			}
			placePosition (map,positionRandom,"CCPU");
			
			ausgeben (map);
			if (result.length()>0) {
			System.out.println(result);
			break;
			}
		}
		
	}
	
	public static void ausgeben (char[][] giveTab) {
		
		for (int i = 0; i < giveTab.length; i++) {
	        for (int j = 0; j < giveTab[i].length; j++) {
	            System.out.print(giveTab[i][j]);
            }
            System.out.println();
        }
	}
	public static void placePosition (char[][] map, int position , String userName) {
		
		char symbol = ' ';
		if (userName.equals("Player")) {
			symbol= 'X';
			playerPositions.add(position);
		}
		else if (userName.equals("CCPU"))
		{
			symbol ='O';
			cpuPosition.add(position);
		}
		
		switch (position) {
		case 1 :
			map[0][0] = symbol;
			break;
		case 2 :
			map[0][2] = symbol;
			break;
		case 3 :
			map[0][4] = symbol;
			break;
		case 4 :
			map[2][0] =symbol;
			break;
		case 5 :
			map[2][2] = symbol;
			break;
		case 6 :
			map[2][4] = symbol; 
			break;
		case 7 :
			map[4][0] = symbol;
			break;
		case 8 :
			map[4][2] =symbol;
			break;
		case 9 :
			map[4][4] = symbol;
			break;
		}
	}

	public static String win () {
		
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List lowRow = Arrays.asList(7,8,9);
		List lefCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List leftDiag = Arrays.asList(1,5,9);
		List rightDiag = Arrays.asList(7,5,3);
	
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(lowRow);	
		winning.add(lefCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(leftDiag);
		winning.add(rightDiag);
		 
		for (List cand : winning) {
			 if (playerPositions.containsAll(cand)) {
				 
				 return "Congratulations you WON the GAME";
			 }
			 else if (cpuPosition.containsAll(cand)) {
				 return "You LOST THE GAME";
				 }else if (playerPositions.size() + cpuPosition.size() == 9)
					 {
						 return "GAME OVER!! ";
					 }
				 
			 
		 }
		return "";
	}
}
