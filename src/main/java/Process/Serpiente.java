
package Process;

import Interfaz.Frame;
import javax.swing.JPanel;


public class Serpiente extends Thread{
    public JPanel jpSerpiente;
    public JPanel jpCuadro;
    private static int xInicial;
    private static int yInicial;
    public static int xObjetivo;
    public static int yObjetivo;
    double limiteY,limiteX; 
    public boolean estado=true;
    
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
        int puntos=0;
        while(estado){//!(xInicial==xObjetivo && yInicial==yObjetivo)
            if((xObjetivo<limiteX && yObjetivo<limiteY)){
                if(xObjetivo>xInicial && yObjetivo==yInicial){               
                    if(xInicial==xObjetivo){
                        System.out.println("1: llego");                        		
                    }else{
                        xInicial++;	
                    }
                    posicion(xInicial,yInicial);
                    
                }else if(xObjetivo<xInicial && yObjetivo==yInicial){               
                    if(xInicial==xObjetivo){
                        System.out.println("2: llego");
                    }else{
                        xInicial--;	
                    } 
                    posicion(xInicial,yInicial);
                }else if(xObjetivo<xInicial && yObjetivo<yInicial){               
                    if(xInicial==xObjetivo){
                        yInicial--;			
                    }else if(yInicial == yObjetivo){ 
                        xInicial--;
                    }else{
                        xInicial--;
                        yInicial--;	
                    }
                    posicion(xInicial,yInicial);         

                }else if(xObjetivo==xInicial && yObjetivo<yInicial){              
                    if(yInicial==yObjetivo){ 
                        System.out.println("4: llego");                        		
                    }else{
                        yInicial--;	
                    }
                    posicion(xInicial,yInicial);

                }else if(xObjetivo>xInicial && yObjetivo<yInicial){                
                    if(yInicial==yObjetivo){
                        xInicial++;			
                    }else if(xInicial == xObjetivo){ 
                        yInicial--;
                    }else{
                        xInicial++;
                        yInicial--;	
                    }
                    posicion(xInicial,yInicial);
                    
                }else if(xObjetivo<xInicial && yObjetivo>yInicial){               
                    if(xInicial == xObjetivo){
                        yInicial++;			
                    } else if(yInicial == yObjetivo){
                        xInicial--; 	    	
                    }else {
                        xInicial--;
                        yInicial++;
                    }
                    posicion(xInicial,yInicial);
                    
                }else if(xObjetivo==xInicial && yObjetivo>yInicial){              
                        if(yInicial==yObjetivo){ 
                            //System.out.println("6: llego");
                            //break;		
                        }else{
                            xInicial++;	
                        }
                        posicion(xInicial,yInicial);
                        
                }else if(xObjetivo>xInicial && yObjetivo>yInicial){               
                        if(xInicial == xObjetivo){
                                yInicial++;			
                        }else if(yInicial == yObjetivo){
                                xInicial++; 	    	
                        }else {
                                xInicial++;
                                yInicial++;
                        }
                        posicion(xInicial,yInicial);
                }else{
                    if((xInicial>=jpCuadro.getLocation().x && xInicial<=jpCuadro.getSize().width)&&(yInicial>=jpCuadro.getLocation().y && yInicial<=jpCuadro.getSize().height)){
                        System.out.println("Dentro");
                        System.out.println("x:"+xInicial+"-"+jpCuadro.getLocation().x+"; y: "+yInicial+"-"+jpCuadro.getLocation().y);
                        /*puntos++;
                        jpSerpiente.setSize(jpSerpiente.getWidth()*puntos, jpSerpiente.getHeight()*puntos);   
                        Frame.txtNivel.setText(""+puntos);
                        //new ProcessHilo().actualizacionPosicion();*/
                    }else{
                        System.out.println("Fuera del cuadro");
                    }
                    /*if((xInicial>=jpCuadro.getLocation().x && xInicial<=jpCuadro.getSize().width) && (yInicial==jpCuadro.getSize().height)){
                        System.out.println("1");
                    }else if((xInicial==jpCuadro.getLocation().x)&& (yInicial>=jpCuadro.getLocation().y && yInicial<=jpCuadro.getSize().height)){
                        System.out.println("2");
                    }else if((yInicial==jpCuadro.getSize().height)&&(xInicial>=jpCuadro.getLocation().x && xInicial<=jpCuadro.getSize().width)){
                        System.out.println("3");
                    }else if((xInicial==jpCuadro.getSize().width) && (yInicial>=jpCuadro.getLocation().y && yInicial<=jpCuadro.getSize().height)){
                        System.out.println("4");
                    }else{
                        System.out.println("Fuera");
                    }*/
                    //System.out.println("Fuera condicion ->("+xInicial+","+yInicial+") - ("+xObjetivo+","+yObjetivo+")");
                }
            }else{
                System.out.println("Fuera del rango");
            }                              
        }
                          
    }
    
    public void posicion(int x, int y){        
        try {
            jpSerpiente.setLocation(x, y);            
            Thread.sleep(5);            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
