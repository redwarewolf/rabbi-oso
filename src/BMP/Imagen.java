package BMP;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import javax.imageio.stream.ImageInputStream;

import Main.Rabbit;

public class Imagen {
	
	
	static int HEADER_OFFSET = 100;

	public static byte[] LeerImagen (File bmp) throws IOException {                            
		byte[] data = Files.readAllBytes(bmp.toPath());
    return data;
	}
	
	
	public static byte[] composeByteArray(byte[] a, byte[] b) throws IOException {
				
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    baos.write(a);
	    baos.write(b);
	    byte[] composedEncryptedArray = baos.toByteArray();
		
		return composedEncryptedArray;
	}

	@SuppressWarnings("resource")
	public static void encryptFile(File file) throws IOException {
		
		byte[] fullBMP = Imagen.LeerImagen(file);
		
		byte[] header = Arrays.copyOfRange(fullBMP, 0, HEADER_OFFSET);
		byte[] data = Arrays.copyOfRange(fullBMP,HEADER_OFFSET,fullBMP.length);

		
		Rabbit algorithm = new Rabbit();
		byte[] encryptedData = algorithm.encryptMessage(new String(data), /*keyLabel.getText()*/"abcdefghijklmnqw", "trkfbiuh"/*IVLabel.getText()*/, false);
		
		byte[] fullBMP2 = composeByteArray(header,encryptedData);
		FileOutputStream outFile = new FileOutputStream(Imagen.namePath(file, "E"));
		outFile.write(fullBMP2);

		
	}
	
	
@SuppressWarnings("resource")
public static void decryptFile(File file) throws IOException {
		
	byte[] fullBMP = Imagen.LeerImagen(file);
	
	byte[] header = Arrays.copyOfRange(fullBMP, 0, HEADER_OFFSET);
	byte[] data = Arrays.copyOfRange(fullBMP,HEADER_OFFSET,fullBMP.length);

		Rabbit algorithm = new Rabbit();
		byte [] decryptedData = algorithm.decryptMessage(data, /*keyLabel.getText()*/"abcdefghijklmnqw", "trkfbiuh"/*IVLabel.getText()*/, false).getBytes();
		
		//TODO Revisar porque el largo de <data> no es igual al de <encryptedData>
		byte[] fullBMP2 = composeByteArray(header,decryptedData);
		FileOutputStream outFile = new FileOutputStream(Imagen.namePath(file, "D"));
		outFile.write(fullBMP2);
	}
public static String namePath (File file, String num) {
	return file.getPath().substring(0, file.getPath().length()-4).concat(num).concat(".bmp");
	
}
}
