package Interfaz;

import Process.ProcessHilo;
import Process.Serpiente;
import javax.swing.JFrame;

public class Frame extends javax.swing.JFrame {

    ProcessHilo  proceso;
    
    
    public Frame() {        
        initComponents();
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(true);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpJuego = new javax.swing.JPanel();
        jpCuadro = new javax.swing.JPanel();
        jpSerpiente = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JLabel();
        txtPuntosPerdidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpJuego.setBackground(new java.awt.Color(0, 0, 0));
        jpJuego.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mauseMoved(evt);
            }
        });

        jpCuadro.setBackground(new java.awt.Color(255, 102, 102));
        jpCuadro.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jpCuadroLayout = new javax.swing.GroupLayout(jpCuadro);
        jpCuadro.setLayout(jpCuadroLayout);
        jpCuadroLayout.setHorizontalGroup(
            jpCuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jpCuadroLayout.setVerticalGroup(
            jpCuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jpSerpiente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpSerpiente.setForeground(new java.awt.Color(0, 153, 51));
        jpSerpiente.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jpSerpienteLayout = new javax.swing.GroupLayout(jpSerpiente);
        jpSerpiente.setLayout(jpSerpienteLayout);
        jpSerpienteLayout.setHorizontalGroup(
            jpSerpienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jpSerpienteLayout.setVerticalGroup(
            jpSerpienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpJuegoLayout = new javax.swing.GroupLayout(jpJuego);
        jpJuego.setLayout(jpJuegoLayout);
        jpJuegoLayout.setHorizontalGroup(
            jpJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpJuegoLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jpCuadro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpJuegoLayout.createSequentialGroup()
                .addComponent(jpSerpiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpJuegoLayout.setVerticalGroup(
            jpJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpJuegoLayout.createSequentialGroup()
                .addComponent(jpSerpiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addComponent(jpCuadro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel1.setText("Puntos ganados:");

        jLabel2.setText("Puntos Perdidos");

        jLabel3.setText("Tiempo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIniciar)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuntosPerdidos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPuntosPerdidos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnIniciar)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTiempo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPuntos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
       verificacionEstadoBtn();       
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void mauseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mauseMoved
        Serpiente.xObjetivo=evt.getX()-(jpSerpiente.getSize().width/2);
        Serpiente.yObjetivo=evt.getY()-(jpSerpiente.getSize().height/2);
        System.out.println("x: "+evt.getX()+" y:"+evt.getY());
    }//GEN-LAST:event_mauseMoved
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
    public void verificacionEstadoBtn(){
        if(!ProcessHilo.estadoBtn){
            btnIniciar.setText("Pausar");
            proceso=new ProcessHilo(jpJuego,jpCuadro,jpSerpiente); 
            ProcessHilo.txtTiempo=txtTiempo;
            proceso.start();             
            ProcessHilo.estadoBtn=true;            
       }else{           
           ProcessHilo.estadoBtn=false;
           proceso.setJpPrincipal(jpJuego);
           ProcessHilo.txtTiempo=txtTiempo;
           btnIniciar.setText("Iniciar");
       }
    }
    public  void limpiarFrame(){
        this.getContentPane().removeAll(); 
        this.revalidate(); // Recalcula la disposición del JFrame
        this.repaint(); // Redibuja el JFrame
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jpCuadro;
    public static javax.swing.JPanel jpJuego;
    public static javax.swing.JPanel jpSerpiente;
    public static javax.swing.JLabel txtPuntos;
    public static javax.swing.JLabel txtPuntosPerdidos;
    private javax.swing.JLabel txtTiempo;
    // End of variables declaration//GEN-END:variables
}
