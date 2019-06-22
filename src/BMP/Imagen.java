package BMP;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Stream;

public class Imagen {

	public static byte[] LeerImagen (File bpm) throws IOException {                            
		byte[] data = new byte[(int) bpm.length()];
		FileInputStream fis = new FileInputStream(bpm);
		fis.read(data, 0, data.length);
		fis.close();
    return data;
	}
/*
 * algo no testeado 
	public void encriptarImagen (byte [] bmp, String key, String IV , boolean padding) {
		byte[] header = new byte [13];
		byte [] datos = new byte[(int) bmp.length - 13];
		header =  Arrays.copyOfRange(bmp,0,13);
		// Rabbit.encryptMessage(Arrays.copyOfRange(bmp,13, bmp.length).toString(), key, IV,padding);
		byte[] resultado = new byte[(int) bmp.length];
		System.arraycopy(header, 0, resultado, 0, header.length );
		System.arraycopy( datos, 0, resultado, header.length, datos.length );		
	}
	*/
}
