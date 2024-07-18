
package Process;

import javax.swing.JPanel;


public class ProcessHilo extends Thread {
    private JPanel jpPrincipal,jpCuadro;
    private double ancho,alto;
    private double randomPositionx,randomPositiony;
    
    public ProcessHilo(JPanel jpPrincipal,JPanel jpCuadro){
        this.jpPrincipal=jpPrincipal;
        this.jpCuadro=jpCuadro;
        
        this.ancho=jpPrincipal.getSize().width;
        this.alto=jpPrincipal.getSize().height; 
        this.randomPositionx=Math.random()*this.ancho;
        this.randomPositiony=Math.random()*this.alto;
    }
    
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("x:"+randomPositionx+"- Y:"+randomPositiony);
            System.out.println("ancho:"+ancho+"- alto:"+alto);
        }
        
    }
    public void posicionCuadro(){
       
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
