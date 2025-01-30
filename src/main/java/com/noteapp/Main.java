package secure_notes.src.main.java.com.noteapp;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import secure_notes.src.main.java.com.noteapp.services.CryptoService;

public class Main {
    public static void main(String[] args){
        try {
            CryptoService instanCryptoService = new CryptoService();
            String encryptedString = instanCryptoService.encrypt("secret message");
            System.out.println("encrypted message : "+encryptedString);
            String decryptedString = instanCryptoService.decrypt(encryptedString);
            System.out.println("decrypted message : "+decryptedString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
