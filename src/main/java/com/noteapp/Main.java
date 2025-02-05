package secure_notes.src.main.java.com.noteapp;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import secure_notes.src.main.java.com.noteapp.models.Note;
import secure_notes.src.main.java.com.noteapp.models.User;
import secure_notes.src.main.java.com.noteapp.services.CryptoService;
import secure_notes.src.main.java.com.noteapp.services.FileService;
import secure_notes.src.main.java.com.noteapp.services.UserFileService;

public class Main {
    public static void main(String[] args){
        try {
            CryptoService instanCryptoService = new CryptoService();
            String encryptedString = instanCryptoService.encrypt("secret message");
            System.out.println("encrypted message : "+encryptedString);
            String decryptedString = instanCryptoService.decrypt(encryptedString);
            System.out.println("decrypted message : "+decryptedString);

            Note note1 = new Note(1, "titre", "encryptedString");
            Note note2 = new Note(2, "titre2", "encryptedString2");
            // FileService.addNote(note1);
            // FileService.addNote(note2);

            // FileService.printAllNotes();

            // FileService.deleteNote(2);

            // FileService.printAllNotes();
            // User user1 = new User();
            // user1.setUserName("user 1");
            // user1.setSalt("salt");
            // User user2 = new User();
            // user2.setUserName("user 2");
            // user2.setSalt("salt2");
            // UserFileService.addUser(user1);
            // UserFileService.addUser(user2);
            UserFileService.printFile();
            System.out.println(UserFileService.exists("salt"));
            User gottenUser;
            gottenUser = UserFileService.getUser("user 2");
            System.out.println(gottenUser.getSalt());
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
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        
    }
}
