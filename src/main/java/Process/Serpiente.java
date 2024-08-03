
package Process;

import Interfaz.Frame;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


public class Serpiente extends Thread{
    public JPanel jpSerpiente;
    public JPanel jpCuadro;
    public static List<JPanel>cuerpoSerpiente=new ArrayList();
    private static int xInicial;
    private static int yInicial;
    public static int xObjetivo;
    public static int yObjetivo;
    double limiteY,limiteX; 
    public boolean estado=true;
    public static int estadoUbicacion=0;
    private int puntos=0;
    
    public Serpiente(){}
    
    public Serpiente(JPanel jpSerpiente,JPanel jpCuadro,double limiteX, double limiteY){       
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
         siguimientoPuntero();   
        }
    }
    public void siguimientoPuntero(){
        if((xObjetivo<limiteX && yObjetivo<limiteY)){        
            if(xObjetivo>xInicial && yObjetivo==yInicial){
                xInicial ++;
                estadoUbicacion=1;
            }else if(xObjetivo<xInicial && yObjetivo==yInicial){
                xInicial--;
                estadoUbicacion=2;
            }else if(xObjetivo<xInicial && yObjetivo<yInicial){
                xInicial--;
                yInicial--;
                estadoUbicacion=3;
            }else if(xObjetivo==xInicial && yObjetivo<yInicial){
                yInicial--;
                estadoUbicacion=4;
            }else if(xObjetivo>xInicial && yObjetivo<yInicial){
                xInicial++;
                yInicial--;
                estadoUbicacion=5;
            }else if(xObjetivo<xInicial && yObjetivo>yInicial){
                xInicial--;
                yInicial++;
                estadoUbicacion=6;  
            }else if(xObjetivo==xInicial && yObjetivo>yInicial){
                yInicial++;
                estadoUbicacion=7;
            }else if(xObjetivo>xInicial && yObjetivo>yInicial){
                xInicial++;
                yInicial++;
                estadoUbicacion=8;
            }else {                
                condicionCuadroAlimento();
            }
            posicion(xInicial,yInicial);     
        }else{
            System.out.println("Fuera del rango"); 
        }
    }
    
    public void condicionCuadroAlimento(){
        Rectangle rectangulo=new Rectangle(jpCuadro.getLocation().x, jpCuadro.getLocation().y,jpCuadro.getWidth(),jpCuadro.getHeight());
        if(rectangulo.contains(xInicial+(jpCuadro.getWidth()/2),yInicial+(jpCuadro.getHeight()/2))) {                        
            Frame.txtPuntos.setText(""+this.puntos); 
            
            cuerpoSerpiente.add(new JPanel());
            cuerpoSerpiente.get(puntos).setSize(jpCuadro.getSize().width, jpCuadro.getSize().height);
            Frame.jpJuego.add(cuerpoSerpiente.get(puntos));
            
            this.puntos++;
            System.out.println("cuerpo"+cuerpoSerpiente.size());
            ProcessHilo.actualizacionPosicion();
            this.jpCuadro.setLocation((int)ProcessHilo.randomPositionx, (int)ProcessHilo.randomPositiony);
        }else{
            //System.out.println("aun llego");
        }
    }
    
    public void posicion(int x, int y){        
        try {            
            jpSerpiente.setLocation(x, y); 
            posicionDecuerpoSerpiente(x,y);
            Thread.sleep(5);            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void posicionDecuerpoSerpiente(int x,int y){        
        if(!cuerpoSerpiente.isEmpty()){            
            for(int i=0;i<cuerpoSerpiente.size();i++){
                if(i==0){
                    switch(estadoUbicacion){               
                    case 1:
                        System.out.println("1:"+i);
                        cuerpoSerpiente.get(i).setLocation((x-(i+1))-jpCuadro.getSize().width*(i+1),y);
                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
                        break;
                    case 2:
                        System.out.println("2:"+i);
                        cuerpoSerpiente.get(i).setLocation((x+(i+1))+jpCuadro.getSize().width*(i+1),y);
                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
                        break;
                    case 3:
                        System.out.println("3:"+i);
                        cuerpoSerpiente.get(i).setLocation((x+(i+1))+jpCuadro.getSize().width*(i+1),(y+(i+1))+jpCuadro.getSize().height*(i+1));
                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
                        break;
                    case 4:
                        System.out.println("4:"+i);
                        cuerpoSerpiente.get(i).setLocation(x,(y+(i+1))+jpCuadro.getSize().height*(i+1));
                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
                        break;
                    case 5:
                        System.out.println("5:"+i);
                        cuerpoSerpiente.get(i).setLocation((x-(i+1))-jpCuadro.getSize().width*(i+1),(y+(i+1))+jpCuadro.getSize().height*(i+1));
                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
                        break;
                    case 6:
                        System.out.println("6:"+i);
                        cuerpoSerpiente.get(i).setLocation((x+(i+1))+jpCuadro.getSize().width*(i+1),(y-(i+1))-jpCuadro.getSize().height*(i+1));
                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
                        break;
                    case 7:
                        System.out.println("7:"+i);
                        cuerpoSerpiente.get(i).setLocation(x,(y-(i+1))-jpCuadro.getSize().height*(i+1));
                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
                        break;
                    case 8:
                        System.out.println("8:"+i);
                        cuerpoSerpiente.get(i).setLocation((x-(i+1))-jpCuadro.getSize().width*(i+1),(y-(i+1))-jpCuadro.getSize().height*(i+1));
                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
                        break;
                    default:
                    break;
                }
                
                }else{
                    cuerpoSerpiente.get(i).setLocation(cuerpoSerpiente.get(i-1).getLocation().x,cuerpoSerpiente.get(i-1).getLocation().y);
                }
                
//                switch(estadoUbicacion){               
//                    case 1:
//                        System.out.println("1:"+i);
//                        cuerpoSerpiente.get(i).setLocation((x-(i+1))-jpCuadro.getSize().width*(i+1),y);
//                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
//                        break;
//                    case 2:
//                        System.out.println("2:"+i);
//                        cuerpoSerpiente.get(i).setLocation((x+(i+1))+jpCuadro.getSize().width*(i+1),y);
//                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
//                        break;
//                    case 3:
//                        System.out.println("3:"+i);
//                        cuerpoSerpiente.get(i).setLocation((x+(i+1))+jpCuadro.getSize().width*(i+1),(y+(i+1))+jpCuadro.getSize().height*(i+1));
//                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
//                        break;
//                    case 4:
//                        System.out.println("4:"+i);
//                        cuerpoSerpiente.get(i).setLocation(x,(y+(i+1))+jpCuadro.getSize().height*(i+1));
//                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
//                        break;
//                    case 5:
//                        System.out.println("5:"+i);
//                        cuerpoSerpiente.get(i).setLocation((x-(i+1))-jpCuadro.getSize().width*(i+1),(y+(i+1))+jpCuadro.getSize().height*(i+1));
//                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
//                        break;
//                    case 6:
//                        System.out.println("6:"+i);
//                        cuerpoSerpiente.get(i).setLocation((x+(i+1))+jpCuadro.getSize().width*(i+1),(y-(i+1))-jpCuadro.getSize().height*(i+1));
//                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
//                        break;
//                    case 7:
//                        System.out.println("7:"+i);
//                        cuerpoSerpiente.get(i).setLocation(x,(y-(i+1))-jpCuadro.getSize().height*(i+1));
//                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
//                        break;
//                    case 8:
//                        System.out.println("8:"+i);
//                        cuerpoSerpiente.get(i).setLocation((x-(i+1))-jpCuadro.getSize().width*(i+1),(y-(i+1))-jpCuadro.getSize().height*(i+1));
//                        System.out.print("("+cuerpoSerpiente.get(i).getLocation().x+","+cuerpoSerpiente.get(i).getLocation().y+")");
//                        break;
//                    default:
//                    break;
//                }
//                System.out.println("For: "+i);
            }                       
        }else{
            System.out.println("esta vacio, aun no comio");
        }                   
    }
}
