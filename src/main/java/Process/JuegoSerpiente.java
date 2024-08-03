
package Process;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class JuegoSerpiente extends JFrame{
    private Panel panelJuego;
    private ArrayList<Segmento> serpiente;
    private Comida comida;
    private boolean ejecutando;
    private Thread hiloJuego;
    private Thread hiloComida;
    private int puntuacion = 0;
    private static final int TAMANO_SEGMENTO = 10;

    public JuegoSerpiente() {
        setTitle("Juego de la Serpiente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelJuego = new Panel();
        add(panelJuego);

        serpiente = new ArrayList<>();
        serpiente.add(new Segmento(200, 200));

        comida = new Comida();

        ejecutando = true;

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                moverSerpiente(e.getX(), e.getY());
            }
        });

        hiloJuego = new Thread(this::bucleJuego);
        hiloComida = new Thread(this::moverComida);

        hiloJuego.start();
        hiloComida.start();
    }

    private void bucleJuego() {
        while (ejecutando) {
            verificarColision();
            panelJuego.repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void moverComida() {
        Random rand = new Random();
        while (ejecutando) {
            try {
                Thread.sleep(5000);
                comida.x = rand.nextInt(getWidth());
                comida.y = rand.nextInt(getHeight());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void moverSerpiente(int x, int y) {
        for (int i = serpiente.size() - 1; i > 0; i--) {
            Segmento actual = serpiente.get(i);
            Segmento anterior = serpiente.get(i - 1);
            actual.x = anterior.x;
            actual.y = anterior.y;
        }
        
        Segmento cabeza = serpiente.get(0);
        cabeza.x = x;
        cabeza.y = y;
    }

    private void verificarColision() {
        Segmento cabeza = serpiente.get(0);
        if (distancia(cabeza.x, cabeza.y, comida.x, comida.y) < TAMANO_SEGMENTO) {
            puntuacion++;
            
            // Añadir un nuevo segmento al final de la serpiente
            Segmento ultimoSegmento = serpiente.get(serpiente.size() - 1);
            serpiente.add(new Segmento(ultimoSegmento.x, ultimoSegmento.y));
            
            // Mover la comida a una nueva posición aleatoria
            Random rand = new Random();
            comida.x = rand.nextInt(getWidth());
            comida.y = rand.nextInt(getHeight());
        }
    }

    private double distancia(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private class Panel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Segmento s : serpiente) {
                g.setColor(Color.GREEN);
                g.fillOval(s.x - TAMANO_SEGMENTO/2, s.y - TAMANO_SEGMENTO/2, TAMANO_SEGMENTO, TAMANO_SEGMENTO);
            }
            g.setColor(Color.RED);
            g.fillOval(comida.x - TAMANO_SEGMENTO/2, comida.y - TAMANO_SEGMENTO/2, TAMANO_SEGMENTO, TAMANO_SEGMENTO);
            
            g.setColor(Color.BLACK);
            g.drawString("Puntuación: " + puntuacion, 10, 20);
        }
    }

    private class Segmento {
        int x, y;
        public Segmento(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Comida {
        int x, y;
        public Comida() {
            x = 100;
            y = 100;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JuegoSerpiente().setVisible(true));
    }
}
