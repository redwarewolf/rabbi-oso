package BMP;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;

import Main.Rabbit;

public class Imagen {

	public static byte[] LeerImagen (File bmp) throws IOException {                            
		byte[] data = Files.readAllBytes(bmp.toPath());
    return data;
	}
	
	
	public static byte[] composeByteArray(byte[] a, byte[] b) {
		
		byte[] composedEncryptedArray = new byte[a.length + b.length + 1];
		
		for (int i = 0; i <  a.length; i++) {
			composedEncryptedArray[i] = a[i];
		}
		
		for (int i = a.length; i < b.length; i++) {
			composedEncryptedArray[i] = b[i];
		}
		return composedEncryptedArray;
	}

	public static void encryptFile(File file) throws IOException {
		
		byte[] fullBMP = Imagen.LeerImagen(file);
		
		byte[] header = Arrays.copyOfRange(fullBMP, 0, 32);
		byte[] data = Arrays.copyOfRange(fullBMP,33,fullBMP.length);

		
		Rabbit algorithm = new Rabbit();
		byte[] encryptedData = algorithm.encryptMessage(data.toString(), /*keyLabel.getText()*/"abcdefghijklmnqw", "trkfbiuh"/*IVLabel.getText()*/, true);
		//TODO Revisar porque el largo de <data> no es igual al de <encryptedData>

		FileOutputStream outFile = new FileOutputStream(file.getPath() + "2");
		outFile.write(composeByteArray(header,data));
		
	}
	
}
