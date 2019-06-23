package Form;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BMP.Imagen;
import Main.Rabbit;

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
    	// Acción de abrir archivo con botón para encriptar
		fileEncrypter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser();
		        chooser.setCurrentDirectory(new File("c:\\"));
		        int value = chooser.showOpenDialog(null);
		        File file = chooser.getSelectedFile();
		        try{
		        	// Lógica tras abrir el archivo a encriptar
		   
	        		Imagen.encryptFile(file);
	        		JOptionPane.showMessageDialog(frame, "Hecho!");
	        		
		        }catch(Exception e){
		            JOptionPane.showMessageDialog(frame, "No se seleccionó el archivo");
		      
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
		      
		        try{
		        	Imagen.decryptFile(file);
		        	JOptionPane.showMessageDialog(frame, "Hecho!");
		        }catch(Exception e){
		        	 JOptionPane.showMessageDialog(frame, "No se seleccionó el archivo");
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