
package Process;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound extends Thread {
    private String path;
    public Sound(String path){
        this.path=path;
    }
    
    @Override
    public void run() {
        sonido();   
    }
    public void sonido(){       
        

        try {
            // Obtener el archivo de audio
            File audioFile = new File(this.path);

            if (!audioFile.exists()) {
                System.out.println("El archivo de audio no existe: " + this.path);
                return;
            }

            // Obtener un stream de audio del archivo
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Obtener un clip para reproducir el audio
            Clip audioClip = AudioSystem.getClip();

            // Añadir un CountDownLatch para esperar a que el audio termine
            CountDownLatch latch = new CountDownLatch(1);

            // Añadir un listener para saber cuándo termina la reproducción
            audioClip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    latch.countDown(); // Decrementa el latch cuando la reproducción termina
                }
            });

            // Abrir el clip de audio con el stream de audio
            audioClip.open(audioStream);

            // Reproducir el clip de audio
            audioClip.start();
            System.out.println("Reproduciendo audio...");


            latch.await();// Esperar hasta que el audio termine de reproducirse
            // Cerrar el clip de audio
            audioClip.close();


            System.out.println("Reproducción finalizada.");
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Reproducción interrumpida: " + e.getMessage());
        }       
        
    }
}
