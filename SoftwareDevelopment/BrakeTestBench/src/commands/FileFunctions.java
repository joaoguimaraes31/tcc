package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileFunctions {

    private String fileName;

    private final Date date;
    private FileNameExtensionFilter filter;

    public FileFunctions(String fileName, FileNameExtensionFilter filter) {
        this.fileName = fileName;
        this.filter = filter;
        date = new Date();
    }

    public void writtingToFileRoutine() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select Configuration File Directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showSaveDialog(null);

            if (result == chooser.APPROVE_OPTION) {
                PrintWriter file = new PrintWriter(new File(chooser.getSelectedFile(), fileName));

                writingLogic(file);

                file.close();
            } else {

            }

        } catch (IOException e) {
            // do something
        }
    }

    public void readingFromFile() {
        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Select a Configuration File");
            jfc.setAcceptAllFileFilterUsed(false);
            jfc.addChoosableFileFilter(filter);

            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                System.out.println(jfc.getSelectedFile().getPath());

                FileReader inputFile = new FileReader(jfc.getSelectedFile().getPath());
                BufferedReader bRead = new BufferedReader(inputFile);

                int numberOfLines = 0;
                String str = "";
                while ((str = bRead.readLine()) != null) {
                    numberOfLines++;
                }

                inputFile = new FileReader(jfc.getSelectedFile().getPath());
                bRead = new BufferedReader(inputFile);
                readingLogic(bRead, numberOfLines);
                bRead.close();
            }
        } catch (IOException e) {

        }
    }

    public String spacesString(int numberOfSpaces) {
        String out = "";
        for (int i = 0; i < numberOfSpaces; i++) {
            out += " ";
        }
        return out;
    }

    public int matrixMaxMemberLength(String[][] matrix) {
        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].length() > maxSize) {
                    maxSize = matrix[i][j].length();
                }
            }
        }
        return maxSize;
    }

    public void writingLogic(PrintWriter file) {
        file.println("This has been written to the file");
    }

    public void readingLogic(BufferedReader bRead, int numberOfLines) throws IOException {
        String strTemp = "";
        String str = "";
        int k = 0;
        while ((strTemp = bRead.readLine()) != null) {
            str += strTemp;
            k++;
        }

        if (k != numberOfLines) {
            JFrame frame = null;
            JOptionPane.showMessageDialog(frame, "Invalid file format", "File corrupted", JOptionPane.ERROR_MESSAGE);
            readingFromFile();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public Date getDate() {
        return date;
    }
}
