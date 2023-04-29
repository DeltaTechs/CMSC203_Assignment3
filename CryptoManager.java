/*
 * Class: CMSC203 
 * Instructor: Dr. Tanveer
 * Description:
	CryptoManager: Check if input stays within bounds, and the functionality for encrypting and decrypting both ciphers.
	CryptoManagerGFATest: Double checks if input stays within bounds, and if "HELLO WORLD" is encrypted into right output and decrypted back into "HELLO WORLD."
	CryptoManagerTestPublic: Test all methods of CryptoManager class.
	CryptoManagerTestStudent: Same as CryptoManagerTestPublic but with new string test cases implemented by student.
	FXDriver: Provides layout for spawning the box
	FXMainPane: Proper details on the box: Buttons; labels; title; where to type.
 * Due: 3/13/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aryan Shrestha
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */


public class CryptoManager {
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String text) {
		//throw new RuntimeException("method not implemented");
		boolean within = true;
		for (int i =0; i<text.length();i++)
			if(!(rangeInBetween(text.charAt(i))))
				within=false;
		return within;
		}
	
	private static boolean rangeInBetween(char Btwn)
	{
		if(Btwn>=LOWER_RANGE && Btwn<=UPPER_RANGE)
			return true;
		else
			return false;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String caesarText, int key) {
		//throw new RuntimeException("method not implemented");
		String encryptedCaesar="";
		if(isStringInBounds(caesarText))
		{
			for(int i=0; i<caesarText.length();i++)
			{
				char character = caesarText.charAt(i);
				int encryptedASCII = ((int)character+key);
				while (encryptedASCII>UPPER_RANGE)
					encryptedASCII-=RANGE;
				encryptedCaesar+=(char)encryptedASCII;
			}
		}
		else
			encryptedCaesar="The selected string is not in bounds, Try again.";
		return encryptedCaesar;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String bellasoText, String key) {
		String encryptedBelasso="";
		int bellasoLength=key.length();
		for(int i=0;i<bellasoText.length();i++)
		{
			char character=bellasoText.charAt(i);
			int encryptedASCII=((int)character+(int)key.charAt(i%bellasoLength));
			while (encryptedASCII>UPPER_RANGE)
				encryptedASCII-=RANGE;
			encryptedBelasso+=(char)encryptedASCII;
		}
		return encryptedBelasso;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedCaesar, int key) {
		String decryptedCaesar="";
		for (int i=0; i<encryptedCaesar.length();i++)
		{
			char character = encryptedCaesar.charAt(i);
			int decryptedASCII = ((int)character-key);
			while (decryptedASCII<LOWER_RANGE)
				decryptedASCII+=RANGE;
			decryptedCaesar+=(char)decryptedASCII;
		}
		End();
		return decryptedCaesar;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedBellaso, String key) {
		String decryptedBellaso="";
		int keyLength=key.length();
		for (int i=0;i<encryptedBellaso.length();i++)
		{
			char character=encryptedBellaso.charAt(i);
			int decryptedASCII=((int)character-(int)key.charAt(i%keyLength));
			while (decryptedASCII<LOWER_RANGE)
				decryptedASCII+=RANGE;
			decryptedBellaso+=(char)decryptedASCII;	
		}
		End();
	return decryptedBellaso;
	}
	
	public static void End() {
		System.out.println("Programmer: Aryan Shrestha");
	}
}