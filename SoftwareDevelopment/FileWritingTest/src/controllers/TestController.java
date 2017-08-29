package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                writtingToFileRoutine(headers, values);
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

    public void writtingToFileRoutine(String[] headers, String[] values) {

        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select Configuration File Directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showSaveDialog(view);

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
