
package Process;

import Interfaz.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Serpiente extends Thread{
    public JPanel jpSerpiente;
    public JPanel jpCuadro;
    
    private static int xInicial,yInicial;
    public static int xObjetivo,yObjetivo;    
    double limiteY,limiteX; 
    
    public List<JPanel>segmentosSerpiente =new ArrayList();    
    
    public boolean estado=true;    
    public static int estadoUbicacion=0;
    public Point ultimaPosicionCabeza=null;
    private int puntos=0; 
    
    public Serpiente(){}
    
    public Serpiente(JPanel jpSerpiente,JPanel jpCuadro,double limiteX, double limiteY){   
        segmentosSerpiente.add(jpSerpiente);
        this.jpSerpiente=jpSerpiente;        
        this.jpCuadro=jpCuadro;
        xInicial=this.jpSerpiente.getX()+20;
        yInicial=this.jpSerpiente.getY()+20;
        
        this.limiteX=limiteX;
        this.limiteY=limiteY;
    }
    
    @Override
    public void run() {
        while(estado){
            System.out.println("condicion: "+(xObjetivo<(limiteX-20) && yObjetivo<(limiteY-20)));
            if((xInicial<(limiteX-20) && yInicial<(limiteY-20)) && (xObjetivo>0 && yObjetivo>0)){                
                if(xObjetivo>xInicial && yObjetivo==yInicial){
                    xInicial ++;
                    //posicionAnterior=new Point(segmentosSerpiente.get(0).getLocation().x-20,segmentosSerpiente.get(0).getLocation().y);
                    estadoUbicacion=1;                
                }else if(xObjetivo<xInicial && yObjetivo==yInicial){
                    xInicial--;
                    //posicionAnterior=new Point(segmentosSerpiente.get(0).getLocation().x,segmentosSerpiente.get(0).getLocation().y+20);
                    estadoUbicacion=2;
                }else if(xObjetivo<xInicial && yObjetivo<yInicial){
                    xInicial--;
                    yInicial--;
                    //posicionAnterior=new Point(segmentosSerpiente.get(0).getLocation().x+20,segmentosSerpiente.get(0).getLocation().y+20);
                    estadoUbicacion=3;
                }else if(xObjetivo==xInicial && yObjetivo<yInicial){
                    yInicial--;
                    ///posicionAnterior=new Point(segmentosSerpiente.get(0).getLocation().x,segmentosSerpiente.get(0).getLocation().y+20);
                    estadoUbicacion=4;
                }else if(xObjetivo>xInicial && yObjetivo<yInicial){
                    xInicial++;
                    yInicial--;
//                    posicionAnterior=new Point(segmentosSerpiente.get(0).getLocation().x-20,segmentosSerpiente.get(0).getLocation().y+20);
                    estadoUbicacion=5;
                }else if(xObjetivo<xInicial && yObjetivo>yInicial){
                    xInicial--;
                    yInicial++;
                    //posicionAnterior=new Point(segmentosSerpiente.get(0).getLocation().x+20,segmentosSerpiente.get(0).getLocation().y-20);
                    estadoUbicacion=6;  
                }else if(xObjetivo==xInicial && yObjetivo>yInicial){
                    yInicial++;
                    //posicionAnterior=new Point(segmentosSerpiente.get(0).getLocation().x,segmentosSerpiente.get(0).getLocation().y-20);
                    estadoUbicacion=7;
                }else if(xObjetivo>xInicial && yObjetivo>yInicial){
                    xInicial++;
                    yInicial++;
                    //posicionAnterior=new Point(segmentosSerpiente.get(0).getLocation().x-20,segmentosSerpiente.get(0).getLocation().y-20);
                    estadoUbicacion=8;
                }else {                
                    condicionCuadroAlimento();
                } 
                posicion(new Point(xInicial,yInicial));
            }else{
//                new Sound("D:/Mega/Proyectos/Programacion en java/Proyectos_java/appSnakeGame/src/main/java/Resources/choque.wav").start();                
                puntos=0;
                ProcessHilo.puntosPerdidos=0;
                Frame.txtPuntos.setText(""+puntos);
                Frame.txtPuntosPerdidos.setText("0");
                ProcessHilo.currentTiem=System.currentTimeMillis()/1000;
                
                Frame.jpJuego.removeAll(); // Elimina todos los componentes del panel                
                Frame.jpJuego.revalidate(); // Recalcula la disposición del panel
                Frame.jpJuego.repaint(); // Redibuja el panel
                Frame.jpJuego.add(jpCuadro);
                Frame.jpJuego.add(jpSerpiente);
                
                JPanel cabeza=segmentosSerpiente.get(0);
                cabeza.setLocation(10,10);
                segmentosSerpiente.clear();
                segmentosSerpiente.add(cabeza);
                Frame.jpJuego.add(segmentosSerpiente.get(0));
                
                System.out.println("Fuera del rango"); 
            }          
        }
    }
    public boolean choqueCola(){
        Point ejes=new Point(segmentosSerpiente.get(segmentosSerpiente.size()-1).getLocation().x+10,segmentosSerpiente.get(segmentosSerpiente.size()-1).getLocation().y+10);
        return (segmentosSerpiente.get(0).getLocation().equals(ejes));
        
    }
    
    public void condicionCuadroAlimento(){
        Rectangle rectangulo = new Rectangle(jpCuadro.getLocation().x, jpCuadro.getLocation().y, jpCuadro.getWidth(), jpCuadro.getHeight());
        if (rectangulo.contains(xInicial + (jpCuadro.getWidth()/2), yInicial + (jpCuadro.getHeight()/2))) {
            puntos++;
            new Sound("D:/Mega/Proyectos/Programacion en java/Proyectos_java/appSnakeGame/src/main/java/Resources/comida.wav").start();
            
            Frame.txtPuntos.setText(""+puntos);
            System.out.println("colisiono");
            for(int i=0;i<=15;i++){
                JPanel nuevoSegmento=new JPanel();
                nuevoSegmento.setSize(jpCuadro.getSize());
                segmentosSerpiente.add(nuevoSegmento);
            }
            
            ProcessHilo.currentTiem=System.currentTimeMillis()/1000;
            ProcessHilo.randomPositionx=Math.random()*(ProcessHilo.ancho-20);
            ProcessHilo.randomPositiony=Math.random()*(ProcessHilo.alto-20);
        }
    }
    
    public void posicion(Point posicionActual){        
        try {
            Thread.sleep(5); 
            posicionDecuerpoSerpiente(posicionActual);       
                       
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void posicionDecuerpoSerpiente(Point posicionActual){        
        SwingUtilities.invokeLater(() -> {
            Point nuevaPosicionCabeza = new Point(posicionActual);    

           // Si la cabeza no se ha movido, no hacemos nada
            if (ultimaPosicionCabeza != null && nuevaPosicionCabeza.equals(ultimaPosicionCabeza)) {
                return;
            }
                 // Movemos la cabeza a la nueva posición
            segmentosSerpiente.get(0).setLocation(posicionActual);
            // Guardamos la posición actual de la cabeza antes de moverla
            Point posicionAnteriorCabeza = segmentosSerpiente.get(0).getLocation();
            // Movemos el resto del cuerpo solo si la cabeza se ha movido
            if (segmentosSerpiente.size()>0) {
                for (int i = 1; i < segmentosSerpiente.size(); i++) {
                    Point temp = segmentosSerpiente.get(i).getLocation();                
                    segmentosSerpiente.get(i).setLocation(posicionAnteriorCabeza.x,posicionAnteriorCabeza.y);
                    Frame.jpJuego.add(segmentosSerpiente.get(i));

                    posicionAnteriorCabeza = temp;

                }
            }
            // Actualizamos la última posición conocida de la cabeza
            ultimaPosicionCabeza = nuevaPosicionCabeza;
        });
        
        
    }            
   
}
