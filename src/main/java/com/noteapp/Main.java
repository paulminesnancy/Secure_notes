package secure_notes.src.main.java.com.noteapp;

import java.security.NoSuchAlgorithmException;

import secure_notes.src.main.java.com.noteapp.services.CryptoService;

public class Main {
    public static void main(String[] args){
        System.out.println("test in main");
        try {
            CryptoService instanCryptoService = new CryptoService();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
    }
}
