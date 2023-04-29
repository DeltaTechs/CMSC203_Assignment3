import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("FOOD"));
		assertTrue(CryptoManager.isStringInBounds("\"FOOD IS GOOD\""));
		assertFalse(CryptoManager.isStringInBounds("food"));
		assertFalse(CryptoManager.isStringInBounds("{FOOD"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("bye", 3));
		assertEquals("HIJ", CryptoManager.caesarEncryption("DEF", 4));
		assertEquals("$%&", CryptoManager.caesarEncryption("DEF", 96));
		assertEquals("@8;5-", CryptoManager.caesarEncryption("WORLD", 105));
		assertEquals("CBMMJOH", CryptoManager.caesarEncryption("BALLING", 1));
		assertEquals("KHUH#LV#D#GLIIHUHQW#WHVW", CryptoManager.caesarEncryption("HERE IS A DIFFERENT TEST", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("BALLING", CryptoManager.caesarDecryption("CBMMJOH", 1));
		assertEquals("LARRY THE CABLE GUY", CryptoManager.caesarDecryption("3(99@G;/,G*()3,G.<@", 999));
		assertEquals("GOODBYE DLROW", CryptoManager.caesarDecryption("3;;0.E1L08>;C", 300));
		assertEquals("HERE IS A DIFFERENT TEST", CryptoManager.caesarDecryption("KHUH#LV#D#GLIIHUHQW#WHVW", 3));
		
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("TFZP\"]1P\"U", CryptoManager.bellasoEncryption("BELLSPROUT", "RANDOM_AMALGAMATION"));
		assertEquals(":2S!-Z\"\"SM%\\;=V", CryptoManager.bellasoEncryption("HAIL JONAH HILL", "21JUMPSTREET"));
		assertEquals("VTF+K;>3?\" STF>", CryptoManager.bellasoEncryption("THE FINAL TRIAL", "BLAKE2023"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("BELLSPROUT", CryptoManager.bellasoDecryption("TFZP\"]1P\"U", "RANDOM_AMALGAMATION"));
		assertEquals("HAIL JONAH HILL", CryptoManager.bellasoDecryption(":2S!-Z\"\"SM%\\;=V", "21JUMPSTREET"));
		assertEquals("THE FINAL TRIAL", CryptoManager.bellasoDecryption("VTF+K;>3?\" STF>", "BLAKE2023"));

	}

}
