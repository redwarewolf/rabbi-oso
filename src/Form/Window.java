package Form;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BMP.Imagen;

public final class Window {
	
	static GraphicsConfiguration gc;
	static JTextField messageTextfield, keyTextfield, IVtextField;
	
	static JFrame frame;
	static JButton fileEncrypter;
	static JLabel messageLabel;
	static JLabel keyLabel;
	static JLabel IVLabel;
	static JLabel fileContentLabel;
	static JButton fileDesencrypter;
	  
	public static void genForm() {
		defineForm();
		defineActions();
	}
	
    private static void defineActions() {
    	// Acci�n de abrir archivo con bot�n para encriptar
		fileEncrypter.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser();
		        chooser.setCurrentDirectory(new File("c:\\"));
		        int value = chooser.showOpenDialog(null);
		        File file = chooser.getSelectedFile();
		        try{
		        	// L�gica tras abrir el archivo a encriptar
		   
	        		Imagen.encryptFile(file,keyTextfield.getText(),IVtextField.getText());
	        		JOptionPane.showMessageDialog(frame, "Archivo cifrado!");
	        		keyLabel.setText(null);
	        		IVLabel.setText(null);
	        		
		        }catch(Exception e){
		            JOptionPane.showMessageDialog(frame, "No se seleccion� el archivo");
		      
		        }
			}
		});
		
		fileDesencrypter.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser();
		        chooser.setCurrentDirectory(new File("c:\\"));
		        int value = chooser.showOpenDialog(null);
		        File file= chooser.getSelectedFile();
		      
		        try{
		        	Imagen.decryptFile(file,keyTextfield.getText(),IVtextField.getText());
		        	JOptionPane.showMessageDialog(frame, "Archivo descifrado!");
		        }catch(Exception e){
		        	 JOptionPane.showMessageDialog(frame, "No se seleccion� el archivo");
		        }
			}
		});
	}

	public static void defineForm() {
    
	    frame= new JFrame(gc);
	    frame.getContentPane().setLayout(new GridLayout(10,2));
	    
		frame.setVisible(true);
		frame.setTitle("Rabbi-Oso");
		// frame.setSize(800, 600);
		
		
		fileEncrypter=new JButton("Encrypt File");
		fileEncrypter.setBounds(100,100,140, 40); 
		
		JLabel messageLabel = new JLabel();		
		messageLabel.setText("File Content:");
		messageLabel.setBounds(10, 10, 100, 100);
		
		keyLabel = new JLabel();		
		keyLabel.setText("Enter Key:");
		keyLabel.setBounds(10, 15, 100, 100);
		
		IVLabel = new JLabel();		
		IVLabel.setText("Enter IV:");
		IVLabel.setBounds(10, 20, 100, 100);
		
		fileContentLabel = new JLabel();		
		fileContentLabel.setText("-----");
		fileContentLabel.setBounds(10, 10, 100, 100);
		
	    keyTextfield = new JTextField("",80);
	    IVtextField = new JTextField("",80);
	    frame.add(keyLabel);
	    frame.getContentPane().add(keyTextfield);
	    frame.add(IVLabel);
	    frame.getContentPane().add(IVtextField);
	    frame.add(fileEncrypter);
	       
	    
	    frame.add(messageLabel);
	    frame.add(fileContentLabel);
	    
		fileDesencrypter=new JButton("Desencrypt File");
		fileDesencrypter.setBounds(100,100,140, 40);
		
		frame.add(fileDesencrypter);
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    frame.pack();
    }
}