package builders;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarBuilder{
    
    //Menu Bar
    private JMenuBar menuBar;
    
    //Menu's
    private JMenu fileMenu;
    private JMenu helpMenu;
    //Menu items
    private JMenuItem loadCalibrationMenuItem;
    private JMenuItem saveCalibrationMenuItem;
    private JMenuItem loadConfigurationMenuItem;
    private JMenuItem saveConfigurationMenuItem;
    private JMenuItem exitMenuItem;
    public String teste= "teste";
    

    public MenuBarBuilder() {
        menuBar=new JMenuBar();
        fileMenu=new JMenu();
        fileMenu.setText("File");
        menuBar.add(fileMenu);
        
        helpMenu=new JMenu();
        helpMenu.setText("Help");
        menuBar.add(helpMenu);
        
        loadCalibrationMenuItem = new JMenuItem();
        loadCalibrationMenuItem.setText("Load Calibration Settings");
        fileMenu.add(loadCalibrationMenuItem);
        
        saveCalibrationMenuItem = new JMenuItem();
        saveCalibrationMenuItem.setText("Save Calibration Settings");
        fileMenu.add(saveCalibrationMenuItem);
        
        loadConfigurationMenuItem = new JMenuItem();
        loadConfigurationMenuItem.setText("Load Configuration Settings");
        fileMenu.add(loadConfigurationMenuItem);
        
        saveConfigurationMenuItem = new JMenuItem();
        saveConfigurationMenuItem.setText("Save Configuration Settings");
        fileMenu.add(saveConfigurationMenuItem);
        
        exitMenuItem = new JMenuItem();
        exitMenuItem.setText("Exit");
        fileMenu.add(exitMenuItem);
    }

    public JMenuBar getView() {
        return menuBar;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public JMenuItem getLoadCalibrationMenuItem() {
        return loadCalibrationMenuItem;
    }

    public JMenuItem getSaveCalibrationMenuItem() {
        return saveCalibrationMenuItem;
    }

    public JMenuItem getLoadConfigurationMenuItem() {
        return loadConfigurationMenuItem;
    }

    public JMenuItem getSaveConfigurationMenuItem() {
        return saveConfigurationMenuItem;
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public String getTeste() {
        return teste;
    }
    
    
}