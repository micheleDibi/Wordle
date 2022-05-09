package finestraGrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import comandiPersonalizzati.LimitOneChar;

public class Finestra extends JFrame{
	
	private int numebersOfTry = 0;
	private JTextField[] cells;
	private int nRighe = 6, nColonne = 5;
	private int heightLocationWindow, widthLocationWindow, widthSizeWindow, heightSizeWindow;

	public Finestra() {
		super("Wordle");
		
		System.setProperty("sun.java2d.uiScale","2");
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    //set dimensione finestra
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    widthSizeWindow = (int)(screenSize.getWidth() / 5.1);
	    heightSizeWindow = (int)(screenSize.getHeight() / 2.2);
	    
	    widthLocationWindow = (int) (screenSize.getWidth() / 5.1) * 2;
	    heightLocationWindow = (int)(screenSize.getHeight() / 2.2) / 10;
	    
	    setSize(widthSizeWindow, heightSizeWindow);
	    setLocation(widthLocationWindow, heightLocationWindow);
	    setResizable(false);
	    
	    //set titolo "Wordle"
	    JLabel titolo = new JLabel("<html><font color='white'>Wordle</font></html>");
	    
	    titolo.setBounds((int) (widthLocationWindow / 6),(int) (heightLocationWindow / 2.7), 120, 27);
	    
	    Font myFont = new Font("SansSerif", Font.CENTER_BASELINE, 27);
	    titolo.setFont(myFont);
	    
	    this.add(titolo);
	    
	    //creazione griglia input caratteri
	    createTable(6, 5);
	    
	    //set bottone 'enter' 
	    JButton enterBtn = new JButton("Enter");
	    enterBtn.setBounds((int) (widthLocationWindow / 14), (int) (heightLocationWindow * 8.3), 75, 25);
	    this.add(enterBtn);
	    
	    enterBtn.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	            String parolaInserita = "";
	            
	            for(int i = 0; i < nColonne; i++) {
	            	parolaInserita += cells[(nColonne * numebersOfTry) + i].getText(); 
	            }
	            
	            System.out.println("Numero tentativo: " + numebersOfTry);
	            System.out.println("Dimensione parola inserita: " + parolaInserita.length());
	            System.out.println("parola inserita: " + parolaInserita);
	            
	            if(parolaInserita.length() == nColonne) {
	            	for(int i = 0; i < nColonne; i++) {
	            		cells[(nColonne * numebersOfTry) + i].setEditable(false);
	            		
	            		if (i == 1) {
	            			//Color redL = new Color(255, 153, 153);
	            			
	            			cells[(nColonne * numebersOfTry) + i].setBackground(Color.green);
	            			cells[(nColonne * numebersOfTry) + i].setForeground(Color.white);
	            		} else if (i == 2) {
	            			cells[(nColonne * numebersOfTry) + i].setBackground(Color.green);
	            			cells[(nColonne * numebersOfTry) + i].setForeground(Color.white);

	            		} else if (i == 3) {
	            			cells[(nColonne * numebersOfTry) + i].setBackground(Color.YELLOW);
	            			cells[(nColonne * numebersOfTry) + i].setForeground(Color.white);

	            		}
	            	}
	            	
	            	numebersOfTry++;
	            } else {
	            	
	            	System.out.println("Parola troppo corta...");
	            	
	            	final JFrame error = new JFrame("Errore Parola");
	            	
	            	error.setSize((int) (widthSizeWindow / 1.5), heightSizeWindow / 4);
	            	error.setLocation((int) (widthLocationWindow), (int) (heightLocationWindow * 2));
	            	error.setResizable(false);
	            	
	            	JLabel errorText = new JLabel("<html><font color='red'>Lunghezza della parola non corretta</font></html>");
	        	    	            	
	        	    errorText.setBounds(10, 5, 200, 50);
	        	    
	        	    Font myFont = new Font("SansSerif", Font.CENTER_BASELINE, 15);
	        	    errorText.setFont(myFont);

	        	    error.add(errorText);
	        	    
	            	error.setLayout(null);
	            	error.setVisible(true);
	            	
	            }
	        }  
	    }); 

	    setLayout(null);
	    setVisible(true);
	}
  
	void createTable(int nRighe, int nColonne) {
	  
	  cells = new JTextField[nRighe * nColonne];
	  
	  int sizeCell = widthSizeWindow / 7;
	  
	  Font myFont = new Font("SansSerif", Font.BOLD, 20);
	  int posY = (int)(heightLocationWindow * 1.3);
	  
	  for(int i = 0; i < nRighe; i++) {
		  int posX = (int) (widthLocationWindow / 15.7);
		  
		  for(int j = 0; j < nColonne; j++) {
			  cells[(nColonne * i) + j] = new JTextField(1);
			  cells[(nColonne * i) + j].setDocument(new LimitOneChar(1));
			  //cells[(nColonne * i) + j].setDocument(new JTextFieldLimit(1));
			  
			  cells[(nColonne * i) + j].setBounds(posX, posY, sizeCell , sizeCell);
			  cells[(nColonne * i) + j].setFont(myFont);
			  cells[(nColonne * i) + j].setHorizontalAlignment(JTextField.CENTER);
			  add(cells[(nColonne * i) + j]);
			  
			  posX += (int) (widthLocationWindow / 14);
		  }
		  
		  posY += (int)(heightLocationWindow * 1.15);
		  
	  }
	  
	}
  
  public static void main(String[] arg)
  {
	System.out.println("Creazione finestra...");
    new Finestra();
    System.out.println("finestra creata...");
  }

}
