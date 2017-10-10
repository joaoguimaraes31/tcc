package my.mainframe;

public class ExecutionTimerControl {
    private long timeCount;
 
    public void start(){
       timeCount = 0;
    }
 
    public void stop(){
        timeCount = System.currentTimeMillis();
    }
 
    public long[] getTime() {     
        long output[]= {0,0,0};
        output[2] = timeCount / 60000;
        timeCount=timeCount - (timeCount % 60000);
        output[1] = timeCount / 1000;
        timeCount=timeCount - (timeCount % 1000);
        output[0] = timeCount;
        return output;
    }
}
