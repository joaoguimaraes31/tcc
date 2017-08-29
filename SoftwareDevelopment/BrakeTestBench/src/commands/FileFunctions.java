package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileFunctions {


    public void writtingToFile(String[] headers, String[] values, String pathToFile) {

        try {
            //Path file = Paths.get("c:\\data\\myfile.txt");
            File file = new File(pathToFile);
            file.getParentFile().mkdirs();
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter writer = new PrintWriter(fileWriter);
            for (int i = 0; i < values.length; i++) {
                writer.println(headers[i] + "=" + values[i]);
            }
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }

    public void readingFromFile(String[] headers, String[] values) {
        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Select a Configuration File");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("BrakeTestBench Configuration Files (.cfg)", "cfg");
            jfc.addChoosableFileFilter(filter);

            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                System.out.println(jfc.getSelectedFile().getPath());

                FileReader inputFile = new FileReader(jfc.getSelectedFile().getPath());
                BufferedReader bRead = new BufferedReader(inputFile);

                int numberOfParameters = 0;
                String str = "";
                while ((str = bRead.readLine()) != null) {
                    numberOfParameters++;
                }

                inputFile = new FileReader(jfc.getSelectedFile().getPath());
                bRead = new BufferedReader(inputFile);

                if (numberOfParameters == headers.length) {
                    int k = 0;
                    while ((str = bRead.readLine()) != null) {
                        String[] parts = str.split("=");
                        System.out.println(parts[1]);
                        values[k] = parts[1];
                        k++;
                    }
                } else {
                    JFrame frame = null;
                    JOptionPane.showMessageDialog(frame, "Invalid file format", "File corrupted", JOptionPane.ERROR_MESSAGE);
                }
                bRead.close();
            }
        } catch (IOException e) {

        }
    }

}