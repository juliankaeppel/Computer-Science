package lecture0;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * This is my Hello World program.
 * I was bored, so I made a rudimentary encryption algorithm.
 * Anyway, here's how it works:
 * You can either encrypt or decrypt a string with the 
 * corresponding method. The encryption method takes three
 * parameters: A string input which is encrypted, and encryption
 * key, and a stretch value, which will be explained shortly.
 * The method first duplicates each character in the string by 
 * the stretch value, so if the stretch value was 3, abc would become
 * aaabbbccc. This is because the encryption method is really bad and
 * if the string is too short, if you give the method a certain key,
 * it won't actually encrypt it. I didn't take the time to figure out
 * the relationship between the size of the string and which key values
 * don't encrypt it, but it's probably really complicated. (A.K.A. I 
 * couldn't find a pattern in the 30 seconds I tried to) The encryption 
 * key is just the number of times the string is encrypted, so if you
 * gave it a key of two, it would encrypt your string, then encrypt the
 * result and return that. The actual encryption itself works as follows:
 * First the stretched string is converted to 7-bit (ASCII) binary. Then,
 * it arranges the bits into 7 groups. Each group contains the
 * corresponding bit from each character, so group 1 would contain
 * the first bit from each character. Then it concatenates the 7 groups
 * and converts the bits back into a string. The decryption method works
 * pretty much the same, but in reverse, making a number of groups
 * equivalent to the length of the string, with each group containing
 * 7 bits. The biggest problems I see with encrypting a string like this
 * are that it's not very efficient, it doesn't work with small strings
 * unless you stretch them, so the encrypted code will always be somewhat
 * large, and the encrypted code contains weird ASCII codes that can
 * mess up the decryption process if they aren't properly inputted. 
 * Because of this, the best method for storing the encrypted code is
 * to write it directly to a text file, and then to read it back directly
 * from that file to decrypt it. The only argument for the main method is
 * the path to the encryption code file. You could package the key and
 * stretch values in the code file, but that would compromise the 
 * security of the encryption. However, for the purposes of this project,
 * I included the key and stretch values in the main method for ease of
 * decryption.
 */

public class HelloWorld {

	public static void main(String[] args) {
		int key = 943;
		int stretch = 10;
		
		try {
			System.out.println(decrypt(new String(Files.readAllBytes(Paths.get(args[0]))), key, stretch));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String encrypt(String input, int key, int stretch) {
		String stretchedInput = "";
		String result = "";
		
		for(int i = 0; i < input.length(); i++)
			for(int j = 0; j < stretch; j++)
				stretchedInput += input.charAt(i);
		
		for(int i = 0; i < key; i++) {
			result = "";
			String binInput = "";
			String binOutput = "";
			for(int j = 0; j < 7 * stretchedInput.length(); j++)
				binInput += String.format("%7s", Integer.toString(stretchedInput.charAt(j / 7), 2)).replace(' ',  '0').charAt(j % 7);
			for(int j = 0; j < 7; j++)
				for(int k = 0; k < stretchedInput.length(); k++)
					binOutput += binInput.charAt(k * 7 + j);
			for(int j = 0; j < 7 * stretchedInput.length(); j += 7)
				result += (char)Integer.parseInt(binOutput.substring(j, j + 7), 2);
			stretchedInput = result;
		}
		return result;
	}
	
	static String decrypt(String input, int key, int stretch) {
		String result = "";
		for(int i = 0; i < key; i++) {
			result = "";
			String binInput = "";
			String binOutput = "";
			for(int j = 0; j < 7 * input.length(); j++)
				binInput += String.format("%7s", Integer.toString(input.charAt(j / 7), 2)).replace(' ',  '0').charAt(j % 7);
			for(int j = 0; j < input.length(); j++) {
				binOutput = "";
				for(int k = 0; k < 7; k++)
					binOutput += binInput.charAt(k * input.length() + j);
				result += (char)Integer.parseInt(binOutput, 2);
			}
			input = result;
		}
		
		String shrunkResult = "";
		
		for(int i = 0; i < result.length() / stretch; i++)
			shrunkResult += result.charAt(i * stretch);
		
		return shrunkResult;
	}
}
