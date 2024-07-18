
package Process;

import javax.swing.JPanel;


public class ProcessHilo extends Thread {
    private JPanel jpPrincipal,jpCuadro;
    private double ancho,alto;
    private static double randomPositionx,randomPositiony;
    public static boolean estadoBtn=false;
    
    public ProcessHilo(JPanel jpPrincipal,JPanel jpCuadro){
        this.jpPrincipal=jpPrincipal;
        this.jpCuadro=jpCuadro;
        
        this.ancho=jpPrincipal.getSize().width;
        this.alto=jpPrincipal.getSize().height; 
        randomPositionx=Math.random()*this.ancho;
        randomPositiony=Math.random()*this.alto;
    }
    
    @Override
    public void run() {
        posicionCuadro();        
    }
    public void posicionCuadro(){        
        try {
            while(estadoBtn){
                this.jpCuadro.setLocation((int)randomPositionx, (int)randomPositiony);
                Thread.sleep(100); 
                actualizacionPosicion();
            }
                      
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void actualizacionPosicion(){
        randomPositionx=Math.random()*this.ancho;
        randomPositiony=Math.random()*this.alto;
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
