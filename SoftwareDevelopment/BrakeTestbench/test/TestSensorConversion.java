
import controller.SensorDataConverter;

public class TestSensorConversion {

    public static void main(String args[]) {
        int[] readings;
        readings=stringSensorConverter("123,234,345,456,567,678.");
        
        System.out.println(readings[0]);
        System.out.println(readings[1]);
        System.out.println(readings[2]);
        System.out.println(readings[3]);
        System.out.println(readings[4]);
        System.out.println(readings[5]);
    }

    public static int[] stringSensorConverter(String sensorsReadingsString) {
        int i=0;
        int k=0;
        String curReading = "";
        int[] readings = {0,0,0,0,0,0};
        
        while (i<(sensorsReadingsString.length())){
            if (sensorsReadingsString.charAt(i)==',' || sensorsReadingsString.charAt(i)=='.'){
                readings[k]=Integer.parseInt(curReading);
                curReading="";
                k++;
                
            }else{
                curReading+=Character.toString(sensorsReadingsString.charAt(i));
            }
            i++;
        }
        return readings;
    }

}
