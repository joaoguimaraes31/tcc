package my.mainframe;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class WriterToFile {
    
    public void CreateFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename + ".txt", true);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    
    public void WriteData(String filename, String data){
        try {
            FileWriter writer = new FileWriter(filename + ".txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
