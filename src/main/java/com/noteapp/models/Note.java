package secure_notes.src.main.java.com.noteapp.models;

public class Note {
    private int id;
    private String title;
    private String encryptedMessage;

    public Note(int id, String title, String encryptedMessage){
        this.id = id;
        this.title = title;
        this.encryptedMessage = encryptedMessage;
    }

    public void setId(int id){this.id = id;}
    public void setTitle(String title){this.title = title;}
    public void setEncryptedMessage(String encrypted){this.encryptedMessage = encrypted;}
    
    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
    public String getEncryptedMessage(){return this.encryptedMessage;}
}
