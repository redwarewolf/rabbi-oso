import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


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
    frame.getContentPane().setLayout(new GridLayout(10,2));
    
	frame.setVisible(true);
	frame.setTitle("Rabbi-Oso");
	// frame.setSize(800, 600);
	
	JButton fileEncrypter=new JButton("Encrypt File");
	fileEncrypter.setBounds(100,100,140, 40); 
	
	JLabel messageLabel = new JLabel();		
	messageLabel.setText("File Content:");
	messageLabel.setBounds(10, 10, 100, 100);
	
	JLabel keyLabel = new JLabel();		
	keyLabel.setText("Enter Key:");
	keyLabel.setBounds(10, 15, 100, 100);
	
	JLabel IVLabel = new JLabel();		
	IVLabel.setText("Enter IV:");
	IVLabel.setBounds(10, 20, 100, 100);
	
	JLabel fileContentLabel = new JLabel();		
	fileContentLabel.setText("-----");
	fileContentLabel.setBounds(10, 10, 100, 100);
	
    keyTextfield = new JTextField("",10);
    IVtextField = new JTextField("",10);
    frame.add(keyLabel);
    frame.getContentPane().add(keyTextfield);
    frame.add(IVLabel);
    frame.getContentPane().add(IVtextField);
    frame.add(fileEncrypter);
       
    
    frame.add(messageLabel);
    frame.add(fileContentLabel);
    
	JButton fileDesencrypter=new JButton("Desencrypt File");
	fileDesencrypter.setBounds(100,100,140, 40);
	
	frame.add(fileDesencrypter);
    
    // Acción de abrir archivo con botón para encriptar
    fileEncrypter.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent arg0) {
    		JFileChooser chooser= new JFileChooser();
            chooser.setCurrentDirectory(new File("c:\\"));
            int value = chooser.showOpenDialog(null);
            File file= chooser.getSelectedFile();
            String path= file.getAbsolutePath();
            
            try{
            	// Lógica tras abrir el archivo a encriptar
            	
            	System.out.println(path);
                
                fileContentLabel.setText(Imagen.LeerImagen(file).toString());
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    	}
    });
    
    
    fileDesencrypter.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent arg0) {
    		JFileChooser chooser= new JFileChooser();
            chooser.setCurrentDirectory(new File("c:\\"));
            int value = chooser.showOpenDialog(null);
            File file= chooser.getSelectedFile();
            String path= file.getAbsolutePath();
            
            try{
            	// Lógica tras abrir el archivo a desencriptar
            	
            	System.out.println(path);
            	
            	fileContentLabel.setText(Imagen.LeerImagen(file).toString());
     
                                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    	}
    });
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.pack();

  }
}