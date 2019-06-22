package Main;
import Form.Window;


class Main {
	
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
		
		Window.genForm();

		
	}
}