package jcharttest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadDataController {

    private NavigationController navigationController;

    //MVC
    private ReadDataModel model;
    private ReadDataView view;

    private ChartOperations chartOperations;

    int amplitude=10;

    //AL
    private ActionListener actionListenerUpdateBT;

    //Constructor
    public ReadDataController() {
        model = new ReadDataModel();
        view = new ReadDataView();
        chartOperations = new ChartOperations("Sample XY Chart","Time (s)","Voltage",500,300,view.getLblChart());
        createView();
    }

    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView() {
        chartOperations.startTimer();
        chartOperations.updateSeries(20);
        chartOperations.createChart();
        view.setVisible(true);
        addListeners();
    }

    //addListeners for controlling view and triggers events
    public void addListeners() {
        actionListenerUpdateBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                chartOperations.updateSeries(amplitude);
                chartOperations.createChart();
                amplitude+=20;
            }
        };
        view.getUpdateBT().addActionListener(actionListenerUpdateBT);
    }

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

}
