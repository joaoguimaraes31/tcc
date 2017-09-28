package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileFunctions {

    private String[] descriptors;
    private String[][] values;
    private String header;

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final Date date = new Date();
    private final int HEADER_SIZE = 3;

    public FileFunctions(String[] descriptors, String[][] values, String header) {
        this.descriptors = descriptors;
        this.values = values;
        this.header = header;
    }

    public void writtingToFileRoutine() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select Configuration File Directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showSaveDialog(null);
            int maxSize = matrixMaxMemberLength(values);
            header = header + "\n" + "Date modified " + dateFormat.format(date) + "\n";

            if (result == chooser.APPROVE_OPTION) {
                PrintWriter file = new PrintWriter(new File(chooser.getSelectedFile(), "BrakeTestBench.cfg"));
                file.println(header);

                for (int i = 0; i < values[0].length; i++) {
                    for (int j = 0; j < descriptors.length; j++) {
                        file.print(descriptors[j] + "=" + values[j][i] + ";");
                        file.print(spacesString(values[j][i], maxSize));
                    }
                    file.println();

                }
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
            FileNameExtensionFilter filter = new FileNameExtensionFilter("BrakeTestBench Configuration Files (.cfg)", "cfg");
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

                if (numberOfLines == (values[0].length + HEADER_SIZE)) {
                    int k = 0;
                    while ((str = bRead.readLine()) != null) {
                        //divides into sensor parameters
                        if (k > (HEADER_SIZE - 1)) {
                            String[] parts0 = str.split(";");

                            for (int j = 0; j < (parts0.length -1); j++) {
                                //separetes parameter description with value
                                String[] parts1 = parts0[j].split("=");
                                values[j][k-3] = parts1[1];

                            }
                        }
                        k++;
                    }
                } else {
                    JFrame frame = null;
                    JOptionPane.showMessageDialog(frame, "Invalid file format", "File corrupted", JOptionPane.ERROR_MESSAGE);
                    readingFromFile();
                }
                bRead.close();
            }
        } catch (IOException e) {

        }
    }

    public String spacesString(String str, int l) {
        String out = "";
        l -= str.length();
        l += 3;
        for (int i = 0; i < l; i++) {
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

}
