package secure_notes.src.main.java.com.noteapp.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import secure_notes.src.main.java.com.noteapp.models.User;

public class UserFileService {
    private static final String path = "C:/Users/paulc/Bureau/code/revision_macasonic/AllUsers.txt";

    public static void addUser(User user) throws IOException {
        String toAdd = user.getUserName() + "\n"+user.getSalt();
        Files.write(Paths.get(path), Collections.singletonList(toAdd), StandardOpenOption.APPEND);
    }

    public static User getUser(String UserName) throws IOException{
        List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
        int lineIndex = 0;
        while (lineIndex < lines.size() && !UserName.equals(lines.get(lineIndex))){lineIndex +=2;}
        User res = new User();
        res.setUserName(lines.get(lineIndex));
        res.setSalt(lines.get(lineIndex+1));
        return res;
    }

    public static boolean exists(String UserName) throws IOException{
        List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
        int lineIndex = 0;
        while (lineIndex < lines.size() && !UserName.equals(lines.get(lineIndex))){lineIndex +=2;}
        return (lineIndex < lines.size());
    }

    public static void printFile() throws IOException {
        List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
        System.out.println("-------------------------------------------------------");
        for (String line : lines){
            System.out.println("|  "+line);
        }
        System.out.println("-------------------------------------------------------");
    }
}
