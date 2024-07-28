
package Process;


public class Borrador {
    public static void main(String[] args) {
        int xObjetivo=339, yObjetivo=0;
        int xInicial=21, yInicial=142;
        System.out.println("Iniciando");
                
        if(xObjetivo>xInicial && yObjetivo==yInicial){
            while(!(xInicial==xObjetivo && yInicial==yObjetivo)){                
                if(xInicial==xObjetivo){
                    break;		
                }else{
                    xInicial++;	
                }
                System.out.println("1.-x: "+xInicial+" - y: "+yInicial);
            }
        }else if(xObjetivo<xInicial && yObjetivo==yInicial){
            while(!(xInicial==xObjetivo && yInicial==yObjetivo)){                
                if(xInicial==xObjetivo){
                    break;		
                }else{
                    xInicial--;	
                } 
                System.out.println("2.-x: "+xInicial+" - y: "+yInicial);
            }
        }else if(xObjetivo<xInicial && yObjetivo<yInicial){
            while(!(xInicial==xObjetivo && yInicial==yObjetivo)){                
                if(xInicial==xObjetivo){
                    yInicial--;			
                }else if(yInicial == yObjetivo){ 
                    xInicial--;
                }else{
                    xInicial--;
                    yInicial--;	
                }
                System.out.println("3.-x: "+xInicial+" - y: "+yInicial);
            } 

        }else if(xObjetivo==xInicial && yObjetivo<yInicial){
            while(!(xInicial==xObjetivo && yInicial==yObjetivo)){                
                if(yInicial==yObjetivo){
                    break;		
                }else{
                    yInicial--;	
                }
                System.out.println("4.-x: "+xInicial+" - y: "+yInicial);
            }
        }else if(xObjetivo>xInicial && yObjetivo<yInicial){
            while(!(xInicial==xObjetivo && yInicial==yObjetivo)){                
                if(yInicial==yObjetivo){
                    xInicial++;			
                }else if(xInicial == xObjetivo){ 
                    yInicial--;
                }else{
                    xInicial++;
                    yInicial--;	
                }
                System.out.println("5.-x: "+xInicial+" - y: "+yInicial);
            }
        }else if(xObjetivo<xInicial && yObjetivo>yInicial){
            while(!(xInicial==xObjetivo && yInicial==yObjetivo)){                
                if(xInicial == xObjetivo){
                    yInicial++;			
                } else if(yInicial == yObjetivo){
                    xInicial--; 	    	
                }else {
                    xInicial--;
                    yInicial++;
                }
                System.out.println("6.-x: "+xInicial+" - y: "+yInicial);
            } 

        }else if(xObjetivo==xInicial && yObjetivo>yInicial){
            while(!(xInicial==xObjetivo && yInicial==yObjetivo)){                
                if(yInicial==yObjetivo){
                    break;		
                }else{
                    xInicial++;	
                } 
                System.out.println("7.-x: "+xInicial+" - y: "+yInicial);
            }
        }else if(xObjetivo>xInicial && yObjetivo>yInicial){
            while(!(xInicial==xObjetivo && yInicial==yObjetivo)){                
                if(xInicial == xObjetivo){
                        yInicial++;			
                }else if(yInicial == yObjetivo){
                        xInicial++; 	    	
                }else {
                        xInicial++;
                        yInicial++;
                }
                System.out.println("8.-x: "+xInicial+" - y: "+yInicial);
            }
        }else {

        }        
    }
    
}
