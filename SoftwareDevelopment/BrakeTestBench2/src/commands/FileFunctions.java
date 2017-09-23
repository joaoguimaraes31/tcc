package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import views.SensorSetupView;

public class FileFunctions {

    public void writtingToFileRoutine(String[] headers, String[] values) {
        System.out.println("teste");
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select Configuration File Directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showSaveDialog(null);

            if (result == chooser.APPROVE_OPTION) {
                PrintWriter file = new PrintWriter(new File(chooser.getSelectedFile(), "BrakeTestBench.cfg"));
                for (int i = 0; i < values.length; i++) {
                    file.println(headers[i] + "=" + values[i]);
                }
                file.close();
            } else {

            }

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