package maze;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

    public static void saveListToFile(List<String> list, String fileName) {
        try( PrintWriter writer = new PrintWriter(fileName, "UTF-8") ) {
            for(String line : list) {
                writer.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> readListFromFile(String fileName) {
        try( Scanner scanner = new Scanner( new File(fileName) ) ) {
            List<String> list = new ArrayList<>();
            while(scanner.hasNextLine()) {
                list.add( scanner.nextLine() );
            }
            return list;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
