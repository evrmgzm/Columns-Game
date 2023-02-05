import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import enigma.core.Enigma;
import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.Color;
import enigma.console.TextAttributes;
import java.lang.*;
public class Game {
		public static enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");
	   public TextMouseListener tmlis; 
	   public static KeyListener klis; 

	   // ------ Standard variables for mouse and keyboard ------
	   public int mousepr;          // mouse pressed?
	   public int mousex, mousey;   // mouse text coords.
	   public static int keypr;   // key pressed?
	   public static int rkey;    // key   (for press/release)
	   // ----------------------------------------------------
	   static int columnNo=1;
	   static int element=1;
	   static int cursorX = 0;
	   static int cursorY = 2;
	  
		static DLL tempElements = new DLL();
		static NodeDLL nodeElement = null;
		static NodeDLL tempColumn1= null;
		static NodeDLL tempColumn2= null;
		static NodeDLL tempColumn3= null;
		static NodeDLL tempColumn4= null;
		static NodeDLL tempColumn5= null;
		static Object temp1,temp2,temp3,temp4,temp5;
		static Object tempBox = "";
		static int tempZcolumnNo = 1;
		static DLL tempDLL = new DLL();
		static boolean b = false;
		static boolean z = false;
		static int transfer = 0;
		static MultiLinkedList column = new MultiLinkedList();
		static NumberNode nodeNumber = null;
		static NumberNode MtempColumn1= null;
		static NumberNode MtempColumn2= null;
		static NumberNode MtempColumn3= null;
		static NumberNode MtempColumn4= null;
		static NumberNode MtempColumn5= null;
		static boolean zPress=false;
		static int endGameScore = 0;
		static int finishedOrderedSet = 0;
		static int playerScore = 0;
		
		public static void MultiColumn() {
			
			column.addColumn("C1");
			column.addColumn("C2");
			column.addColumn("C3");
			column.addColumn("C4");
			column.addColumn("C5");
			
			
			for (int i = 0; i < 6; i++)
			{
				column.addNumber("C1",(int)Main.box.deletelast());
				column.addNumber("C2",(int)Main.box.deletelast());
				column.addNumber("C3",(int)Main.box.deletelast());
				column.addNumber("C4",(int)Main.box.deletelast());
				column.addNumber("C5",(int)Main.box.deletelast());
				
			}
			MtempColumn1= column.columnFirstElement("C1");
			MtempColumn2= column.columnFirstElement("C2");
			MtempColumn3= column.columnFirstElement("C3");
			MtempColumn4= column.columnFirstElement("C4");
			MtempColumn5= column.columnFirstElement("C5");
			
		}

	   public void key() throws Exception {   // --- Contructor
              
		      // ------ Standard code for mouse and keyboard ------ Do not change
		      tmlis=new TextMouseListener() {
		         public void mouseClicked(TextMouseEvent arg0) {}
		         public void mousePressed(TextMouseEvent arg0) {
		            if(mousepr==0) {
		               mousepr=1;
		               mousex=arg0.getX();
		               mousey=arg0.getY();
		            }
		         }
		         public void mouseReleased(TextMouseEvent arg0) {}
		      };
		      cn.getTextWindow().addTextMouseListener(tmlis);
		    
		      klis=new KeyListener() {
		         public void keyTyped(KeyEvent e) {}
		         public void keyPressed(KeyEvent e) {
		            if(keypr==0) {
		               keypr=1;
		               rkey=e.getKeyCode();
		            }
		         }
		         public void keyReleased(KeyEvent e) {}
		      };
		      cn.getTextWindow().addKeyListener(klis);
		      // ----------------------------------------------------
		      
		      boolean flag = false;
		      
		      Main.cn.getTextWindow().setCursorPosition(cursorX, cursorY);
		      
		      keypr=0;
		      while(!flag) {		    	 		         
		         if(keypr==1) {    // if keyboard button pressed		        	 		        	
		            if(rkey==KeyEvent.VK_LEFT) {
		            	if(cursorX==0) {
		            		cursorX=20;
		            		columnNo=5;
		            		
		            	}
		            	else {
			            	cursorX -= 5;
			            	columnNo --;		            	
		            	}		            			            	
		            	cursorReset();
		            } 
		            if(rkey==KeyEvent.VK_RIGHT) {
		            	if(cursorX==20) {
		            		columnNo =1;
		            		cursorX=0;
		            	}
		            	else {
			            	columnNo ++;
			            	cursorX += 5;			            	
		            	}		           			            	
			            	
		            	cursorReset();
		            }
		            if(rkey==KeyEvent.VK_UP && cursorY>2) {
		            	element--;
		            	cursorY --;
		            	McolumnElementUp();	   		      	
		            }
		            if(rkey==KeyEvent.VK_DOWN) {	
		            	element++;
		            	cursorY ++;		            			   		      			   		    		   		   
		   		     	McolumnElementDown();		   		      	
		            }
		            if(rkey==KeyEvent.VK_B) {
		            	cardOpen();
		            			            			            	
		            }
		            if(rkey==KeyEvent.VK_Z&&!zPress) {
		            	McolumnToColumn();
		            	zPress=true;
		            	
		            }	
		            if(rkey==KeyEvent.VK_E) {
		            	clearScreen();
		            	if(transfer!=0) {
			            	endGameScore=100*finishedOrderedSet+((playerScore/transfer));
			            	Main.highScore(endGameScore);
		            	}
		            	break;
		            }	
		            
		            if(z==true) {
		            	MreplaceWithXColumn();
		            	
		            }
		            else if(b==true) {
		            	MreplaceWithX();		            	
		            }
		            isCompletedSet();
		            gameScreen();
		           
		            flag=false;
		            keypr=0;    // last action  
		         }
		         
		         Thread.sleep(20);
		      }
		   }
	   public static void cardOpen() {
		   if(rkey==KeyEvent.VK_B&&Main.box.size()!=0) {
           	Main.cn.getTextWindow().setCursorPosition(32, 5);
   			tempBox = Main.box.deletelast();
   			System.out.println(tempBox);
   			Main.box.addLast(tempBox);
   			b = true;
           }
		
		 
	   }
	   
	   public static void isCompletedSet() {
		   		   
		   if(column.size("C1")==10) {	
			   int count = 0;
			   for(int i = 1;i<=10;i++) {
				  if(column.count("C1", i)==1) {
					  count++;
				  }
				  else {
					  break;
				  }
			   }
			   if(count==10) {
				   for(int i=0;i<10;i++) {
					   column.deletelast("C1");
				   }
				   finishedOrderedSet++;
				   playerScore+=1000;
			   }
			   
			   
		   }
		   if(column.size("C2")==10) {	
			   int count = 0;
			   for(int i = 1;i<=10;i++) {
				  if(column.count("C2", i)==1) {
					  count++;
				  }
				  else {
					  break;
				  }
			   }
			   if(count==10) {
				   for(int i=0;i<10;i++) {
					   column.deletelast("C2");
				   }
				   finishedOrderedSet++;
				   playerScore+=1000;
			   }
			  
			   
		   }
		   if(column.size("C3")==10) {	
			   int count = 0;
			   for(int i = 1;i<=10;i++) {
				  if(column.count("C3", i)==1) {
					  count++;
				  }
				  else {
					  break;
				  }
			   }
			   if(count==10) {
				   for(int i=0;i<10;i++) {
					   column.deletelast("C3");
				   }
				   finishedOrderedSet++;
				   playerScore+=1000;
			   }
			   
		   }
		   if(column.size("C4")==10) {	
			   int count = 0;
			   for(int i = 1;i<=10;i++) {
				  if(column.count("C4", i)==1) {
					  count++;
				  }
				  else {
					  break;
				  }
			   }
			   if(count==10) {
				   for(int i=0;i<10;i++) {
					   column.deletelast("C4");
				   }
				   finishedOrderedSet++;
				   playerScore+=1000;
			   }
			   
		   }
		   if(column.size("C5")==10) {	
			   int count = 0;
			   for(int i = 1;i<=10;i++) {
				  if(column.count("C5", i)==1) {
					  count++;
				  }
				  else {
					  break;
				  }
			   }
			   if(count==10) {
				   for(int i=0;i<10;i++) {
					   column.deletelast("C5");
				   }
				   finishedOrderedSet++;
				   playerScore+=1000;
			   }
			   
		   }
			   
		
	   }

	   public static void MreplaceWithX() {
		   if(rkey==KeyEvent.VK_X) {		            	
			   if(columnNo==1&&((int)column.lastElement("C1")-(int)Main.box.lastElement()==0||Math.abs((int)column.lastElement("C1")-(int)Main.box.lastElement())==1)) {
				   column.addNumber("C1",(int)Main.box.deletelast()); 
				   tempBox="";
				   transfer++;
			   }
			   if(columnNo==2&&((int)column.lastElement("C2")-(int)Main.box.lastElement()==0||Math.abs((int)column.lastElement("C2")-(int)Main.box.lastElement())==1)) {
				   column.addNumber("C2",(int)Main.box.deletelast());  
				   tempBox="";
				   transfer++;
			   }
			   if(columnNo==3&&((int)column.lastElement("C3")-(int)Main.box.lastElement()==0||Math.abs((int)column.lastElement("C3")-(int)Main.box.lastElement())==1)) {
				   column.addNumber("C3",(int)Main.box.deletelast()); 
				   tempBox="";
				   transfer++;
			   }
			   if(columnNo==4&&((int)column.lastElement("C4")-(int)Main.box.lastElement()==0||Math.abs((int)column.lastElement("C4")-(int)Main.box.lastElement())==1)) {
				   column.addNumber("C4",(int)Main.box.deletelast()); 
				   tempBox="";
				   transfer++;
			   }
			   if(columnNo==5&&((int)column.lastElement("C5")-(int)Main.box.lastElement()==0||Math.abs((int)column.lastElement("C5")-(int)Main.box.lastElement())==1)) {
				   column.addNumber("C5",(int)Main.box.deletelast()); 
				   tempBox="";
				   transfer++;
			   }
			   
			   b=false;
			   cursorReset();
			   gameScreen();
           }
		   
	   }
	  

 public static  void McolumnElementDown() {
		   
		   if(columnNo==1&&MtempColumn1.getNext()!=null) {
			  MtempColumn1=MtempColumn1.getNext();			  
			   
		   }
		   if(columnNo==2&&MtempColumn2.getNext()!=null) {
			   MtempColumn2=MtempColumn2.getNext();			   
		   }
		   if(columnNo==3&&MtempColumn3.getNext()!=null) {
			   MtempColumn3=MtempColumn3.getNext();			   
		   }
		   if(columnNo==4&&MtempColumn4.getNext()!=null) {
			   MtempColumn4=MtempColumn4.getNext();			   
		   }
		   if(columnNo==5&&MtempColumn5.getNext()!=null) {
			   MtempColumn5=MtempColumn5.getNext();			   
		   }		  
		
	   }
 public static void McolumnToColumn() {
	   if(rkey==KeyEvent.VK_Z) {			   
		   z = true;
		   tempZcolumnNo= columnNo;
		 while(columnNo==1&&MtempColumn1.getData()!=null) {
			tempElements.addLast(MtempColumn1.getData());
			if(MtempColumn1.getNext()!=null) {
				MtempColumn1=MtempColumn1.getNext();					
			}
			else {
				break;
			 }
				   
		}
		 while(columnNo==2&&MtempColumn2.getData()!=null) {
				tempElements.addLast(MtempColumn2.getData());
				if(MtempColumn2.getNext()!=null) {
					MtempColumn2=MtempColumn2.getNext();						
				}
				else {
					break;
				 }
					   
			}
		 while(columnNo==3&&MtempColumn3.getData()!=null) {
				tempElements.addLast(MtempColumn3.getData());
				if(MtempColumn3.getNext()!=null) {
					MtempColumn3=MtempColumn3.getNext();						
				}
				else {
					break;
				 }
					   
			}
		 while(columnNo==4&&MtempColumn4.getData()!=null) {
				tempElements.addLast(MtempColumn4.getData());
				if(MtempColumn4.getNext()!=null) {
					MtempColumn4=MtempColumn4.getNext();						
				}
				else {
					break;
				 }
					   
			}
		 while(columnNo==5&&MtempColumn5.getData()!=null) {
				tempElements.addLast(MtempColumn5.getData());
				if(MtempColumn5.getNext()!=null) {
					MtempColumn5=MtempColumn5.getNext();						
				}
				else {
					break;
				 }					   
			}			   
	   }
	 		   
 }

	   public static void deleteColumnWithZ() {
		   if(tempZcolumnNo==1) {
				  for(int i = 0; i<tempDLL.size();i++) {
					  column.deletelast("C1");
				  }
			  }
		   if(tempZcolumnNo==2) {
				  for(int i = 0; i<tempDLL.size();i++) {
					  column.deletelast("C2");
				  }
			  }
		   if(tempZcolumnNo==3) {
				  for(int i = 0; i<tempDLL.size();i++) {
					  column.deletelast("C3");
				  }
			  }
		   if(tempZcolumnNo==4) {
				  for(int i = 0; i<tempDLL.size();i++) {
					  column.deletelast("C4");
				  }
			  }
		   if(tempZcolumnNo==5) {
				  for(int i = 0; i<tempDLL.size();i++) {
					  column.deletelast("C5");
				  }
			  }
	   }
	   
	   public static void MreplaceWithXColumn() {
			gameScreen(); 
		   if(rkey==KeyEvent.VK_X) {	
			  zPress=false;
			   nodeElement = tempElements.head();
			   int temp=(int)nodeElement.getData();
			  
				  while(tempElements.size()!=0) {					   
					   tempDLL.addLast(tempElements.deletelast()); 
					   
				   }
				  
				  if(columnNo==1&&column.size("C1")==0&&(temp==1||temp==10)) {
					  deleteColumnWithZ();
					  while(tempDLL.size()!=0) {					   
						   column.addNumber("C1",(int)tempDLL.deletelast()); 
						   
					   }
					  
					  transfer++;
				  }
				  else if(columnNo==2&&column.size("C2")==0&&(temp==1||temp==10)) {
					  deleteColumnWithZ();
					  while(tempDLL.size()!=0) {					   
						   column.addNumber("C2",(int)tempDLL.deletelast()); 
						   
					   }
					  
					  transfer++;
					  cursorReset();
				  }
				  else if(columnNo==3&&column.size("C3")==0&&(temp==1||temp==10)) {
					  deleteColumnWithZ();
					  while(tempDLL.size()!=0) {					   
						   column.addNumber("C3",(int)tempDLL.deletelast()); 
						   
					   }
					  
					  transfer++;
					  cursorReset();
				  }
				  else if(columnNo==4&&column.size("C4")==0&&(temp==1||temp==10)) {
					  deleteColumnWithZ();
					  while(tempDLL.size()!=0) {					   
						   column.addNumber("C4",(int)tempDLL.deletelast()); 
						   
					   }
					  
					  transfer++;
					  cursorReset();
				  }
				  else if(columnNo==5&&column.size("C5")==0&&(temp==1||temp==10)) {
					  deleteColumnWithZ();
					  while(tempDLL.size()!=0) {					   
						   column.addNumber("C5",(int)tempDLL.deletelast()); 
						   
					   }
					  
					  transfer++;
					  cursorReset();
				  }
				  else if(columnNo==1&&column.size("C1")!=0&&((int)column.lastElement("C1")-temp==0||Math.abs((int)column.lastElement("C1")-temp)==1)) {
					  deleteColumnWithZ();
				   while(tempDLL.size()!=0) {					   
					   column.addNumber("C1",(int)tempDLL.deletelast()); 
					   
				       }
				   transfer++;
				   cursorReset();
			      }
				  else if(columnNo==2&&column.size("C2")!=0&&((int)column.lastElement("C2")-temp==0||Math.abs((int)column.lastElement("C2")-temp)==1)) {
					  deleteColumnWithZ();
				   while(tempDLL.size()!=0) {					   
					   column.addNumber("C2",(int)tempDLL.deletelast()); 
					   
				      }
				   transfer++;
				   cursorReset();
			      }
				  else if(columnNo==3&&column.size("C3")!=0&&((int)column.lastElement("C3")-temp==0||Math.abs((int)column.lastElement("C3")-temp)==1)) {
					  deleteColumnWithZ();
				   while(tempDLL.size()!=0) {					   
					   column.addNumber("C3",(int)tempDLL.deletelast()); 
					   
				      }
				   transfer++;
				   cursorReset();
			      }
			      else if(columnNo==4&&column.size("C4")!=0&&((int)column.lastElement("C4")-temp==0||Math.abs((int)column.lastElement("C4")-temp)==1)){
			    	  deleteColumnWithZ();
				   while(tempDLL.size()!=0) {					   
					   column.addNumber("C4",(int)tempDLL.deletelast()); 
					   
				      }
				   transfer++;
				   cursorReset();
			      }
				  else if(columnNo==5&&column.size("C5")!=0&&((int)column.lastElement("C5")-temp==0||Math.abs((int)column.lastElement("C5")-temp)==1)) {
					  deleteColumnWithZ();
				   while(tempDLL.size()!=0) {					   
					   column.addNumber("C5",(int)tempDLL.deletelast()); 
					   
				      }
				   transfer++;
				   cursorReset();
			      }
				  else {
					  while(tempDLL.size()!=0) {					   
						   tempDLL.deletelast(); 						   
					   }
					  
				  }
					  
				  
				 
			   
			   z=false;
			  gameScreen();
			  
           }
		   
		   gameScreen();
	   }
	  
	   public static void cursorReset() {
		   cursorY=2;
          	element=1;
          	if(column.size("C1")!=0) {
	          	MtempColumn1=column.columnFirstElement("C1");	          	
          	}
          	if(column.size("C2")!=0) {
	          	MtempColumn2=column.columnFirstElement("C2");	          	
          	}
          	if(column.size("C3")!=0) {
	          	MtempColumn3=column.columnFirstElement("C3");	          	
          	}
          	if(column.size("C4")!=0) {
	          	MtempColumn4=column.columnFirstElement("C4");	          	
          	}
          	if(column.size("C5")!=0) {
	          	MtempColumn5=column.columnFirstElement("C5");	          	
          	}
	   }
 public static  void McolumnElementUp() {
		   
		   if(columnNo==1&&MtempColumn1.getPrev()!=null) {
			   MtempColumn1 = MtempColumn1.getPrev();
			   
		   }
		   if(columnNo==2&&MtempColumn2.getPrev()!=null) {
			   MtempColumn2 = MtempColumn2.getPrev();
		   }
		   if(columnNo==3&&MtempColumn3.getPrev()!=null) {
			   MtempColumn3 = MtempColumn3.getPrev();
		   }
		   if(columnNo==4&&MtempColumn4.getPrev()!=null) {
			   MtempColumn4 = MtempColumn4.getPrev();
		   }
		   if(columnNo==5&&MtempColumn5.getPrev()!=null) {
			   MtempColumn5 = MtempColumn5.getPrev();
		   }
		
		  
		
	   }

	  
	   public static void gameScreen() {
			clearScreen();
		
			//---------------------------------------------------------------------------------------------
		
		      klis=new KeyListener() {
		         public void keyTyped(KeyEvent e) {}
		         public void keyPressed(KeyEvent e) {
		            if(keypr==0) {
		               keypr=1;
		               rkey=e.getKeyCode();
		            }
		         }
		         public void keyReleased(KeyEvent e) {}
		      };
		      cn.getTextWindow().addKeyListener(klis);
		
			//-------------------------------------------------------------------------------------------------
			
		    
				Object[] ary1=column.display2("C1");
				Object[] ary2=column.display2("C2");
				Object[] ary3=column.display2("C3");
				Object[] ary4=column.display2("C4");
				Object[] ary5=column.display2("C5");
			int C1x,C2x,C3x,C4x,C5x;
			int boxX = 26;
			int boxY = 5;
			C1x=0;
			C2x=5;
			C3x=10;
			C4x=15;
			C5x=20;
			int C1y,C2y,C3y,C4y,C5y = 2;
			
			
			Main.cn.getTextWindow().setCursorPosition(C1x, 0);
			System.out.println("C1");	
			
			for (int i = 0; i < ary1.length; i++) 
			{
				Main.cn.getTextWindow().setCursorPosition(C1x, i+2);
				if(i + 2== cursorY && cursorX == C1x) cn.setTextAttributes(new TextAttributes(Color.RED));
				else cn.setTextAttributes(new TextAttributes(Color.WHITE));
				System.out.println(ary1[i]);
				cn.setTextAttributes(new TextAttributes(Color.WHITE));
				
			}
		
	   		Main.cn.getTextWindow().setCursorPosition(C2x, 0);
			System.out.println("C2");
			
			for (int i = 0; i < ary2.length; i++) 
			{
				if(i + 2== cursorY && cursorX == C2x) cn.setTextAttributes(new TextAttributes(Color.RED));
				else cn.setTextAttributes(new TextAttributes(Color.WHITE));
				Main.cn.getTextWindow().setCursorPosition(C2x, i+2);
				System.out.println(ary2[i]);
				cn.setTextAttributes(new TextAttributes(Color.WHITE));
			}
			

			
			Main.cn.getTextWindow().setCursorPosition(C3x, 0);	
			System.out.println("C3");		
			
			for (int i = 0; i < ary3.length; i++) 
			{
				if(i + 2== cursorY && cursorX == C3x) cn.setTextAttributes(new TextAttributes(Color.RED));
				else cn.setTextAttributes(new TextAttributes(Color.WHITE));
				Main.cn.getTextWindow().setCursorPosition(C3x, i+2);
				System.out.println(ary3[i]);
				cn.setTextAttributes(new TextAttributes(Color.WHITE));
				
			}
			
			Main.cn.getTextWindow().setCursorPosition(C4x, 0);
			System.out.println("C4");	
			
			for (int i = 0; i <ary4.length; i++) 
			{
				if(i + 2== cursorY && cursorX == C4x) cn.setTextAttributes(new TextAttributes(Color.RED));
				else cn.setTextAttributes(new TextAttributes(Color.WHITE));
				Main.cn.getTextWindow().setCursorPosition(C4x, i+2);
				System.out.println(ary4[i]);
				cn.setTextAttributes(new TextAttributes(Color.WHITE));
				
			}
			
			Main.cn.getTextWindow().setCursorPosition(C5x, 0);
			System.out.println("C5");

			
			for (int i = 0; i < ary5.length; i++) 
			{
				if(i+ 2 == cursorY && cursorX == C5x) cn.setTextAttributes(new TextAttributes(Color.RED));
				else cn.setTextAttributes(new TextAttributes(Color.WHITE));
				Main.cn.getTextWindow().setCursorPosition(C5x, i+2);
				System.out.println(ary5[i]);
				cn.setTextAttributes(new TextAttributes(Color.WHITE));
				
			}
			
			for(int i=0;i<5;i++) {
				Main.cn.getTextWindow().setCursorPosition(C1x, 1);
				System.out.print("--");
				C1x=C1x+5;
			}
			C1x=0;
			Main.cn.getTextWindow().setCursorPosition(30, 0);
			System.out.println("Transfer: ");	
			Main.cn.getTextWindow().setCursorPosition(30, 1);
			System.out.println("Score: ");
			Main.cn.getTextWindow().setCursorPosition(30, 4);
			System.out.println("+---+");
			Main.cn.getTextWindow().setCursorPosition(30, 5);
			System.out.println("|   |");
			Main.cn.getTextWindow().setCursorPosition(30, 6);
			System.out.println("+---+");
			Main.cn.getTextWindow().setCursorPosition(32, 5);
			 System.out.println(tempBox);
			 Main.cn.getTextWindow().setCursorPosition(40, 0);
				System.out.println(transfer);	
				Main.cn.getTextWindow().setCursorPosition(37, 1);
				System.out.println(playerScore);
		}
	public void Intro() {
		TextAttributes attrs = new TextAttributes(Color.GREEN, Color.BLACK);//Here we added some additional features
        Main.cn.setTextAttributes(attrs);
        System.out.println(" \n\n\n\n\n\n\n  █████████     ███████    █████       █████  █████ ██████   ██████ ██████   █████  █████████ \r\n"
				+ "  ███░░░░░███  ███░░░░░███ ░░███       ░░███  ░░███ ░░██████ ██████ ░░██████ ░░███  ███░░░░░███\r\n"
				+ " ███     ░░░  ███     ░░███ ░███        ░███   ░███  ░███░█████░███  ░███░███ ░███ ░███    ░░░ \r\n"
				+ "░███         ░███      ░███ ░███        ░███   ░███  ░███░░███ ░███  ░███░░███░███ ░░█████████ \r\n"
				+ "░███         ░███      ░███ ░███        ░███   ░███  ░███ ░░░  ░███  ░███ ░░██████  ░░░░░░░░███\r\n"
				+ "░░███     ███░░███     ███  ░███      █ ░███   ░███  ░███      ░███  ░███  ░░█████  ███    ░███\r\n"
				+ " ░░█████████  ░░░███████░   ███████████ ░░████████   █████     █████ █████  ░░█████░░█████████ \r\n"
				+ "  ░░░░░░░░░     ░░░░░░░    ░░░░░░░░░░░   ░░░░░░░░   ░░░░░     ░░░░░ ░░░░░    ░░░░░  ░░░░░░░░░  \r\n"
				+ "                                                                                               \r\n"
				+ "                                                                                               \r\n"
				+ "                                                                                               ");
	}
	static void clearScreen() {
			
			enigma.console.Console cn = Enigma.getConsole("Columns", 96, 30, 20, 10);
			
			for (int i = 0; i < 96; i++) {
				for (int j = 0; j < 50; j++) {
					cn.getTextWindow().setCursorPosition(i, j);
					cn.getTextWindow().output(" ");
				}
			}
			cn.getTextWindow().setCursorPosition(0, 0);
		
		}
	
	static void Box() {
		for(int i=0;i<5;i++) {
			for(int j=1;j<=10;j++) {
				randomNumberAdd();
				}
			}
	}



	public static boolean isRandomCountFive(int g) {
		boolean flag = false;		
		if(Main.box.count(g) == 5) {
			flag = true;				
		}
		return flag;
	}

	public static void randomNumberAdd() {
		boolean flag = false;
		Random rnd = new Random();
		for(int i=1;i<=10;i++) {			
			while(!flag) {
				int g = rnd.nextInt(10) + 1;
				if(!isRandomCountFive(g)) {
					Main.box.addLast(g);
					flag = true;
					break;
				}
			}
			
		}
	}
	
	

}
