
package Process;



public class Borrador {  
    public static void main(String[] args) {
        int xObjetivo=8, yObjetivo=13;
        int xInicial=4, yInicial=9;
        System.out.println("Iniciando");
       while(true){         
            if(xObjetivo>xInicial && yObjetivo==yInicial){
                xInicial ++;
//                System.out.println("1: ("+xInicial+","+yInicial+")");
            }else if(xObjetivo<xInicial && yObjetivo==yInicial){
                xInicial--;
//                System.out.println("2: ("+xInicial+","+yInicial+")");
            }else if(xObjetivo<xInicial && yObjetivo<yInicial){
                xInicial--;
                yInicial--;
//                System.out.println("3: ("+xInicial+","+yInicial+")");
            }else if(xObjetivo==xInicial && yObjetivo<yInicial){
                yInicial--;
//                System.out.println("4: ("+xInicial+","+yInicial+")");
            }else if(xObjetivo>xInicial && yObjetivo<yInicial){
                xInicial++;
                yInicial--;
//                System.out.println("5: ("+xInicial+","+yInicial+")");
            }else if(xObjetivo<xInicial && yObjetivo>yInicial){
                xInicial--;
                yInicial++;  
//                System.out.println("6: ("+xInicial+","+yInicial+")");
            }else if(xObjetivo==xInicial && yObjetivo>yInicial){
                yInicial++;
//                System.out.println("7: ("+xInicial+","+yInicial+")");
            }else if(xObjetivo>xInicial && yObjetivo>yInicial){
                xInicial++;
                yInicial++;
//                System.out.println("8: ("+xInicial+","+yInicial+")");
            }else {
                System.out.println("llego: ("+xInicial+","+yInicial+")");
                break;
            }
            System.out.println("g: ("+xInicial+","+yInicial+")");
       }
    }
    
}
