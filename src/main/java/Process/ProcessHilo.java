
package Process;

import Interfaz.Frame;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ProcessHilo extends Thread {
    private JPanel jpPrincipal,jpCuadro;
    public static JLabel txtTiempo;
    public static double ancho,alto;
    public static double randomPositionx,randomPositiony;
    public static boolean estadoBtn=false;
    public static JPanel jpSerpiente;
    public static long currentTiem;
    private static int endTime=5;
    public static int puntosPerdidos=0;
    
    public ProcessHilo(JPanel jpPrincipal,JPanel jpCuadro,JPanel jpSerpienteE){
        this.jpPrincipal=jpPrincipal;
        this.jpCuadro=jpCuadro; 
        jpSerpiente=jpSerpienteE;
        
        ancho=jpPrincipal.getSize().width;
        alto=jpPrincipal.getSize().height; 
        randomPositionx=Math.random()*(ancho-20);
        randomPositiony=Math.random()*(alto-20);
        currentTiem=System.currentTimeMillis()/1000;        
        new Serpiente(jpSerpiente,jpCuadro,ancho,alto).start();
    }
    
    @Override
    public void run() {
        while(estadoBtn){
            actualizacionPosicion(); 
            this.jpCuadro.setLocation((int)randomPositionx, (int)randomPositiony);         
        }        
    }
    
    public static void actualizacionPosicion(){
        long time=System.currentTimeMillis()/1000;
        ProcessHilo.txtTiempo.setText(""+(endTime-(time-currentTiem)));
        if((time-currentTiem)==endTime){
            randomPositionx=Math.random()*(ancho-20);
            randomPositiony=Math.random()*(alto-20);
            if(jpSerpiente.getX()==randomPositionx && jpSerpiente.getY()==randomPositiony){
                randomPositionx=Math.random()*(ancho-20);
                randomPositiony=Math.random()*(alto-20);
            }
            puntosPerdidos++;
            Frame.txtPuntosPerdidos.setText(""+puntosPerdidos);
            currentTiem=System.currentTimeMillis()/1000;            
        }      
    }
    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public void setJpPrincipal(JPanel jpPrincipal) {
        this.jpPrincipal = jpPrincipal;
    }

    public JPanel getJpCuadro() {
        return jpCuadro;
    }

    public void setJpCuadro(JPanel jpCuadro) {
        this.jpCuadro = jpCuadro;
    }
    
}