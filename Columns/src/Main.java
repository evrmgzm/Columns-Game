import enigma.core.Enigma;
import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
public class Main {
	static enigma.console.Console cn = Enigma.getConsole("Columns", 96, 38, 20, 10);
	static SLL box = new SLL();
	static DLL PlayerandScore = new DLL();
	static NodeDLL playerNode = new NodeDLL(null);
	static Player p = new Player(null,null,null);
	public static TextMouseListener tmlis; 
	   public static KeyListener klis; 
	   
	 
	   // ----------------------------------------------------
	public static void main(String[] args) throws Exception {
		
	
		Game myGame = new Game();	
		Game.clearScreen();
		myGame.Intro();
		
		TextAttributes attrs = new TextAttributes(Color.YELLOW, Color.BLACK);//Here we added some additional features
        Main.cn.setTextAttributes(attrs);
		cn.getTextWindow().setCursorPosition(35, 20);
		System.out.println("Press enter to continue..");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		TextAttributes attrs1 = new TextAttributes(Color.WHITE, Color.BLACK);//Here we added some additional features
        Main.cn.setTextAttributes(attrs1);		
		Game.clearScreen();				
		Game.Box();
		//Game.Column();
		Game.MultiColumn();
		
		Game.gameScreen();
		myGame.key();
		
		
		//box.display();
		//Columns columns = new Columns();		
		//columns.column1.addLast(4);
		//columns.column1.display();
		//box.display();
		
		//int playerScore=90;
		//highScore(playerScore);
		
	}
	public static void highScore(int playerScore) throws IOException {
		//read file
		Path scorePath = Paths.get("h.txt");											
		Scanner scores = new Scanner(scorePath);	
		
		
		//add player to PlayerandScore double linked list.
			
		try (Scanner scannerFile = new Scanner(System.in).useDelimiter("\\s")) {
			System.out.print("Enter your name: ");
			String winnerName = scannerFile.nextLine();	
			System.out.print("Enter your surname: ");
			String winnerSurname=scannerFile.nextLine();
				
			PlayerandScore.addInsertSort(new NodeDLL(new Player(winnerName,winnerSurname,playerScore)));
		
			
		}
		//read text and add double linked list	
		while (scores.hasNext())  {		
			String firstName = scores.next();
			String lastName = scores.next();
		    int score = Integer.valueOf( scores.next());
			p = new Player(firstName,lastName,score);			
            playerNode = new NodeDLL(p);
            PlayerandScore.addInsertSort(playerNode);			           
                     
		}		
		scores.close();
		
		System.out.print("\n");
		System.out.println("High Score Table");
		System.out.println("----------------");
		//write high score table to text file and console screen. 
		NodeDLL temp = PlayerandScore.head();	
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("h.txt"))); 
		for(int i=0;i<10;i++) {
			System.out.print(temp.getData()+"\n");
			writer.write(temp.getData()+"\n");
			temp = temp.getNext();
			if(temp==null) {
				break;
			}
		}
		
		writer.close();
						
		
	}	 

	
	
	
	
	

}
