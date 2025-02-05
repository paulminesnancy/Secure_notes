package secure_notes.src.main.java.com.noteapp.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import secure_notes.src.main.java.com.noteapp.models.Note;

public class FileService {
    private static final String path = "C:/Users/paulc/Bureau/code/revision_macasonic/AllNotes.txt";

    public static void addLine(String line) throws IOException {
        Files.write(Paths.get(path), Collections.singletonList(line), StandardOpenOption.APPEND);
    }

    public static void addNote(Note note) throws IOException {
        String toAdd = note.getId() + "\n"+note.getTitle()+"\n"+note.getEncryptedMessage();
        Files.write(Paths.get(path), Collections.singletonList(toAdd), StandardOpenOption.APPEND);
    }

    public static Note getNote(int id) throws IOException{
        List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
        int lineIndex = 0;
        while (lineIndex < lines.size() && id != Integer.parseInt(lines.get(lineIndex))){lineIndex +=3;}
        Note res = new Note(Integer.parseInt(lines.get(lineIndex)), lines.get(lineIndex+1), lines.get(lineIndex+2));
        return res;
    }

    public static void deleteNote(int id) throws IOException {
        List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
        int lineIndex = 0;
        while (lineIndex < lines.size() && id != Integer.parseInt(lines.get(lineIndex))){
            lineIndex +=3;}
        if (lineIndex < lines.size()){
            lines.remove(lineIndex);
            lines.remove(lineIndex);
            lines.remove(lineIndex);
        }
        Files.write(Paths.get(path), lines);
    }

    public static void printAllNotes() throws IOException {
        List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
        System.out.println("-------------------------------------------------------");
        for (String line : lines){
            System.out.println("|  "+line);
        }
        System.out.println("-------------------------------------------------------");
    }

    public static void printNote(int id) throws IOException {
        List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
        int lineIndex = 0;
        while (lineIndex < lines.size() && id != Integer.parseInt(lines.get(lineIndex))){
            lineIndex +=4;}
        if (lineIndex < lines.size()){
            System.out.println(lines.get(lineIndex));
            System.out.println(lines.get(lineIndex+1));
            System.out.println(lines.get(lineIndex+2));
        }
    }
}
