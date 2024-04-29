
package ordenamientodatos;

import java.text.DecimalFormat;

public class Util {
    
    private static long inicio;
    
    public static void iniciarCronometro(){
        inicio=System.currentTimeMillis();
    }
    
    public static long getTiempoCronometro(){
        return System.currentTimeMillis()-inicio;
    }
    
    public static String getTextoTiempoCronometro(){
        long tiempo= getTiempoCronometro();
        long ms= tiempo % 1000;
        tiempo=(tiempo-ms)/1000;
        long seg=tiempo% 60;
        tiempo=(tiempo-seg)/60;
        long min=tiempo% 60;
        tiempo=(tiempo-min)/60;
        long h=tiempo% 60;
        DecimalFormat df=new DecimalFormat("00");
        DecimalFormat dfMS=new DecimalFormat("000");
        
        return df.format(h)+":"+df.format(min)+":"+df.format(seg)+"."+dfMS.format(ms);
    }
}
