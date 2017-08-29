package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import views.*;

public class TestController {

    //upper controller
    private NavigationController navigationController;

    //MVC
    private TestView view;

    private ActionListener actionListenerLoadFileBT;
    private ActionListener actionListenerSetFileBT;

    public TestController() {
        createView();
    }

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView() {
        view = new TestView();
        view.setVisible(true);
        addListeners();
        //System.out.println("deu certo!");
    }

    //addListeners for controlling view and triggers events
    public void addListeners() {
        actionListenerSetFileBT = new ActionListener() {
            @SuppressWarnings("empty-statement")
            public void actionPerformed(ActionEvent actionEvent) {
                //event for set/write file
                System.out.println("SET BT");
                String[] headers = {"Info1", "Info2", "Info3"};
                String[] values = {view.getInfo1TF().getText(), view.getInfo2TF().getText(), view.getInfo3TF().getText()};
                writtingToFileRoutine(headers, values, "C:\\user\\Desktop\\dir2\\filename.txt");
            }
        };
        view.getSetFileBT().addActionListener(actionListenerSetFileBT);

        actionListenerLoadFileBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //event for loading file
                System.out.println("LOAD BT");
                String[] headers = {"Info1", "Info2", "Info3"};
                String[] values = {view.getInfo1TF().getText(), view.getInfo2TF().getText(), view.getInfo3TF().getText()};
                readingFromFileRoutine(headers, values);

            }
        };
        view.getLoadFileBT().addActionListener(actionListenerLoadFileBT);

    }

    public void writtingToFileRoutine(String[] headers, String[] values, String pathToFile) {

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

    public void readingFromFileRoutine(String[] headers, String[] values) {
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
