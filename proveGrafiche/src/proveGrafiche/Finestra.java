package proveGrafiche;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Finestra extends JFrame implements ActionListener, KeyListener{
	
	private int numberOfWords;

	public Finestra() {
	    super("Wordle");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    int heightWindow = (int)(screenSize.getHeight() / 2.2);
	    int widthWindow = (int) (screenSize.getWidth() / 5.1);
	    
	    setSize(widthWindow, heightWindow);
	    setLocation(100, 100);
	    
	    BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
	    getContentPane().setCursor(blankCursor);
	    
	    createTable(6, 5);
	    
	    setLayout(null);
	    setVisible(true);
	}
  
  void createTable(int nRighe, int nColonne) {
	  
	  JTextField[] cells = new JTextField[nRighe * nColonne];
	  Font myFont = new Font("SansSerif", Font.BOLD, 20);
	  int sizeCell = 50;
	  int posY = 50;
	  
	  for(int i = 0; i < nRighe; i++) {
		  int posX = 50;
		  
		  for(int j = 0; j < nColonne; j++) {
			  cells[(nColonne * i) + j] = new JTextField();
			  
			  cells[(nColonne * i) + j].setBounds(posX, posY, sizeCell, sizeCell);
			  cells[(nColonne * i) + j].setFont(myFont);
			  cells[(nColonne * i) + j].setHorizontalAlignment(JTextField.CENTER);
			  add(cells[(nColonne * i) + j]);
			  
			  posX += 55;
		  }
		  
		  posY += 55;
		  
	  }
	  
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
  	
  	
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
  		if(e.getKeyCode() == KeyEvent.VK_ENTER) {  			
  			JOptionPane.showMessageDialog(null, "Hai premuto invio");
  			System.out.println("Hai premuto invio Sys");
  		}
  	
  }

  @Override
  public void keyReleased(KeyEvent arg0) {
  	// TODO Auto-generated method stub
  	
  }

  @Override
  public void keyTyped(KeyEvent arg0) {
  	// TODO Auto-generated method stub
  	
  }
  
  public static void main(String[] arg)
  {
	System.out.println("Creazione finestra...");
    new Finestra();
    System.out.println("finestra creata...");
  }

}
