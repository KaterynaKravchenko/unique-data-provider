package restservice.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FileReader {

    public static Set<String> readNamesFromFile(String filePath) {
        Set<String> result = new HashSet<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(FileReader.class.getResourceAsStream(filePath))));
            bufferedReader.lines().forEach(result::add);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
