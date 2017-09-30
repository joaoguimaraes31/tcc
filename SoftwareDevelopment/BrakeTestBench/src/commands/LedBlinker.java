package commands;

public class LedBlinker {

    Communicator communicator;

    public LedBlinker(Communicator communicator) {
        this.communicator = communicator;
    }
    
    public void Blink(int delayOn,int delayOff, int numberOfBlinks) {

        for (int i = 0; i <= numberOfBlinks; i++) {
            communicator.writeData(96);
            communicator.writeData(97);
            try {
                Thread.sleep(delayOn);
            } catch (InterruptedException ex) {
                //Logger.getLogger(SensorSetupController.class.getName()).log(Level.SEVERE, null, ex);
            }
            communicator.writeData(96);
            try {
                Thread.sleep(delayOff);
            } catch (InterruptedException ex) {
               // Logger.getLogger(SensorSetupController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
