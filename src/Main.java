import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;


class Main {
	
  static GraphicsConfiguration gc;
  static JTextField messageTextfield, keyTextfield, IVtextField;
	
  public static void main(String[] args) {
	

	  
	Rabbit rabbit = new Rabbit();
	String message = "Hello world!";
	String key = "ThisIsMyKey,DontGiveItAround";
	String IV = "AVeryCoolIV";
	boolean addPadding = true;
	boolean trimPadding = true;
	
	byte[] encryptedMessage = rabbit.encryptMessage(message, key, IV,
			addPadding);
	
    System.out.println(encryptedMessage);
    
    System.out.println(rabbit.decryptMessage(encryptedMessage, key, IV, trimPadding));
    
    
    
    // -------------------------- //
    
    JFrame frame= new JFrame(gc);
    frame.getContentPane().setLayout(new FlowLayout());
    
	frame.setVisible(true);
	frame.setTitle("Rabbi-Oso");
	// frame.setSize(800, 600);
	
    messageTextfield = new JTextField("",10);
    keyTextfield = new JTextField("",10);
    IVtextField = new JTextField("",10);
    frame.getContentPane().add(messageTextfield);
    frame.getContentPane().add(keyTextfield);
    frame.getContentPane().add(IVtextField);
    
    frame.pack();


  }
}