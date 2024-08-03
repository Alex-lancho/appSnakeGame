
package Process;

import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ProcessHilo extends Thread {
    private JPanel jpPrincipal,jpCuadro;
    public static JTextField txtTiempo;
    public static double ancho,alto;
    public static double randomPositionx,randomPositiony;
    public static boolean estadoBtn=false;
    public static JPanel jpSerpiente;
    public ProcessHilo(JPanel jpPrincipal,JPanel jpCuadro,JPanel jpSerpienteE){
        this.jpPrincipal=jpPrincipal;
        this.jpCuadro=jpCuadro; 
        jpSerpiente=jpSerpienteE;
        
        ancho=jpPrincipal.getSize().width;
        alto=jpPrincipal.getSize().height; 
        randomPositionx=Math.random()*ancho;
        randomPositiony=Math.random()*alto;
        
        new Serpiente(jpSerpiente,jpCuadro,ancho,alto).start();
    }
    
    @Override
    public void run() {
        posicionCuadro();        
    }
    public void posicionCuadro(){
        long tiempoDuracion=10;
        long startTime;        
        try {
            while(estadoBtn){
                this.jpCuadro.setLocation((int)randomPositionx, (int)randomPositiony); 
                startTime = System.currentTimeMillis();
                Tiempo t=new Tiempo((int)tiempoDuracion);
                t.start();
                TimeUnit.SECONDS.sleep(tiempoDuracion);                
                actualizacionPosicion();              
            }            
            startTime=0;          
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void tiempo(long startTime,long endTime){
        while(startTime==0){
            txtTiempo.setText(""+(endTime-startTime));
        }        
    }
    public static void actualizacionPosicion(){
        randomPositionx=Math.random()*ancho;
        randomPositiony=Math.random()*alto;
        if(jpSerpiente.getX()==randomPositionx && jpSerpiente.getY()==randomPositiony){
            randomPositionx=Math.random()*ancho;
            randomPositiony=Math.random()*alto;
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

class Tiempo extends Thread {
    long time;
    
    public Tiempo(long time){
        this.time=time;
    }
    
    @Override
    public void run() {         
        try {
             while(this.time!=0){           
                TimeUnit.SECONDS.sleep(1);
                ProcessHilo.txtTiempo.setText(""+(this.time--));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
           
    }
}