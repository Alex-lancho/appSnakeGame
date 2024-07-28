
package Process;

import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ProcessHilo extends Thread {
    private JPanel jpPrincipal,jpCuadro;
    public static JTextField txtTiempo;
    private double ancho,alto;
    private static double randomPositionx,randomPositiony;
    public static boolean estadoBtn=false;
    public JPanel jpSerpiente;
    public ProcessHilo(){}
    public ProcessHilo(JPanel jpPrincipal,JPanel jpCuadro,JPanel jpSerpiente){
        this.jpPrincipal=jpPrincipal;
        this.jpCuadro=jpCuadro; 
        this.jpSerpiente=jpSerpiente;
        
        this.ancho=jpPrincipal.getSize().width;
        this.alto=jpPrincipal.getSize().height; 
        randomPositionx=Math.random()*this.ancho;
        randomPositiony=Math.random()*this.alto;
        
        new Serpiente(jpSerpiente,jpCuadro,this.ancho,this.alto).start();
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
    public void actualizacionPosicion(){
        randomPositionx=Math.random()*this.ancho;
        randomPositiony=Math.random()*this.alto;
        if(jpSerpiente.getX()==randomPositionx && jpSerpiente.getY()==randomPositiony){
            randomPositionx=Math.random()*this.ancho;
            randomPositiony=Math.random()*this.alto;
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