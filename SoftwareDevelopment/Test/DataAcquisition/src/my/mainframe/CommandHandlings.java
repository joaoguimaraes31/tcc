package my.mainframe;

public class CommandHandlings {
    
    int asciiCommandNullId;
    
    //Constructor, receives java ascii identifier for commandsOutput=0, regards hardware
    public CommandHandlings(int asciiCommandNullId){
        this.asciiCommandNullId=asciiCommandNullId;
    }
  
    //Method that converts four boolean values to an single integer value
    public int convertBooleanInteger(boolean state0,boolean state1,boolean state2,boolean state3){
        int output=0;
        
        if (state0){
            output+=1;
        }
        if (state1){
            output+=2;
        }
        if (state2){
            output+=4;
        }
        if (state3){
            output+=8;
        }
        return output;
    }
    
    
    //Method for doing both functions above
    public int commandHandle(boolean state0,boolean state1,boolean state2,boolean state3){
       return (convertBooleanInteger(state0,state1,state2,state3) + asciiCommandNullId);
    }
    
}