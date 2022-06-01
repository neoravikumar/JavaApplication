package com;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.crypto.codec.Base64;


//import java.util.Base64;

public class Cryptography {
	
	
	
	

	public static void main(String[] args) {

		String[] adPasswordCryptoKeys = {"-62","94","110","117","69","98","70","110"};
		String algo = "DES";
		Cryptography crypt = new Cryptography(adPasswordCryptoKeys, algo);

		String encresult = crypt.encryptPassword("&2DeuaTA%w)3");
		
		System.out.println("Encrypted result::>"+encresult);
		
		System.out.println("DecryptPassword:>>"+crypt.decryptPassword("HMs5BHgqmh+8bPs6FtLpwuFeYe/MNrAK"));

	}

	private Key key;
	private Cipher cipher;

	public Cryptography(String[] publicKeyTokens, String transformation) {
		this(toByteArray(publicKeyTokens), transformation);
	}

	public Cryptography(byte[] publicKey, String transformation) {
		try {
			key = new SecretKeySpec(publicKey, transformation);
			cipher = Cipher.getInstance(transformation);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String encryptString(String in) {
		String result = "";
		try {
			this.cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] newPlainText = this.cipher.doFinal(in.getBytes());
			result = new String(Base64.encode(newPlainText), "UTF8");
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public String decryptPassword(String in) {
		String result = "";
        try {
            this.cipher.init(2, this.key);
            byte[] newPlainText = this.cipher.doFinal(Base64.decode(in.getBytes()));
            result =  new String(newPlainText, "UTF8");
        } catch (Exception e) {
        	System.out.println(">>>>>>>>>>>>>>>>>");
            System.out.println(e);
            System.out.println("<<<<<<<<<<<<<<<<");
        }
		return result;
    }

	public String encryptPassword(String in) {
		String result = "";
		/*try {
			  this.cipher.init(1, this.key); 
			  byte[] utf8 = in.getBytes("UTF8");
			  byte[] enc = this.cipher.doFinal(utf8);
			  //enc = BASE64EncoderStream.encode(enc);
			enc = "BASE64EncoderStream.encode(enc)";
			  result =  new String(enc);
		} catch (Exception e) {
			System.out.println(e);
		}*/
		return result;
	}

	public static byte[] toByteArray(String[] tokens) {
		byte[] output = null;
		if (tokens != null) {
			output = new byte[tokens.length];
			for (int i = 0; i < tokens.length; i++) {
				output[i] = Byte.decode(tokens[i]).byteValue();
			}
			return output;
		}
		return output;
	}

}
