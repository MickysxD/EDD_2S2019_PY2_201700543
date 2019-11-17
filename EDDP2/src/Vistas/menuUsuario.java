/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import eddp2.*;
import Estructuras.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.awt.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Micky
 */
public class menuUsuario extends javax.swing.JFrame {

    Usuario actual = EDDP2.actual;
    Matriz m = actual.getArchivos();
    NodoMatriz matriz = m.getRoot().getAbajo();
    JLabel datos[][];
    boolean carpeta = false;
    boolean archivo = false;

    public menuUsuario() {
        initComponents();
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        ruta.setText("Ruta actual: " + matriz.getRuta());
        usuario.setText("Usuario: " + actual.getNombre());
        agregarVistas();

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EDDP2.padre = matriz;
                new opcionesAgregar();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        cerrar = new javax.swing.JButton();
        ruta = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        ga = new javax.swing.JButton();
        gc = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jMenu7.setText("jMenu7");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cerrar.setText("Cerrar session");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        ruta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ruta.setText("ruta");

        usuario.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        usuario.setText("jLabel1");

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.setBorderPainted(false);
        Actualizar.setContentAreaFilled(false);
        Actualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Actualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        ga.setText("Generar reporte de archivos");
        ga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaActionPerformed(evt);
            }
        });

        gc.setText("Generar reporte de carpetas");
        gc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gcActionPerformed(evt);
            }
        });

        jButton2.setText("Ver reporte de archivos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ver reporte de carpetas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(Actualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cerrar))
                            .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ga)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gc)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton3)))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuario)
                            .addComponent(Actualizar)
                            .addComponent(jButton1))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(ruta)
                .addGap(6, 6, 6)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ga)
                    .addComponent(gc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        dispose();
        new Inicio();
    }//GEN-LAST:event_cerrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!matriz.getNombre().equals("/")) {
            matriz = matriz.getPadre();
            agregarVistas();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        agregarVistas();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void gaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaActionPerformed
        archivo = matriz.getArchivos().graficar();
        if (archivo) {
            JOptionPane.showMessageDialog(null, "Reporte de archivos realizado", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_gaActionPerformed

    private void gcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gcActionPerformed
        carpeta = m.graficarMatriz();
        if (carpeta) {
            JOptionPane.showMessageDialog(null, "Reporte de carpetas realizado", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_gcActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (archivo) {
            EDDP2.imagen = "ReporteAVL.jpg";
            new mostrarReportes();
        }else{
            JOptionPane.showMessageDialog(null, "Error: Realize el reporte de archivos", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (carpeta) {
            EDDP2.imagen = "ReporteMatriz.jpg";
            new mostrarReportes();
        }else{
            JOptionPane.showMessageDialog(null, "Error: Realize el reporte de archivos", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuUsuario().setVisible(true);
            }
        });
    }

    public void agregarVistas() {
        panel.removeAll();

        int size = matriz.getArchivos().getTotal() + matriz.getCarpetas();

        ruta.setText(matriz.getRuta());

        if (size != 0) {
            datos = new JLabel[(size / 5) + 1][5];

            NodoMatriz temp = matriz.getSiguiente();
            NodoAVL array[] = matriz.getArchivos().getArray();

            int a = 0;

            for (int i = 0; i < (size / 5) + 1; i++) {
                for (int j = 0; j < 5; j++) {
                    if (temp != null) {
                        JLabel nuevo = new JLabel();
                        nuevo.setBounds(5 + (105 * j), 5 + (105 * i), 100, 100);

                        ImageIcon imagen = new ImageIcon("carpeta.png");
                        ImageIcon imag = new ImageIcon(imagen.getImage().getScaledInstance(nuevo.getWidth(), nuevo.getHeight() - 25, Image.SCALE_DEFAULT));

                        nuevo.setIcon(imag);
                        nuevo.setText(temp.getNombre());
                        nuevo.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
                        nuevo.setVerticalTextPosition((int) BOTTOM_ALIGNMENT);
                        nuevo.setVerticalAlignment((int) BOTTOM_ALIGNMENT);

                        nuevo.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() == 2) {
                                    if (!matriz.getNombre().equals("/")) {
                                        matriz = m.buscarPadre(matriz.getRuta() + "/" + nuevo.getText());
                                    } else {
                                        matriz = m.buscarPadre("/" + nuevo.getText());
                                    }
                                    agregarVistas();
                                    System.out.println("double clicked");
                                } else if (e.getButton() == MouseEvent.BUTTON3) {
                                    if (!matriz.getNombre().equals("/")) {
                                        EDDP2.padre = matriz;
                                        EDDP2.carpetaC = m.buscarPadre(matriz.getRuta() + "/" + nuevo.getText());
                                    } else {
                                        EDDP2.padre = matriz;
                                        EDDP2.carpetaC = m.buscarPadre("/" + nuevo.getText());
                                    }
                                    new opcionesCarpeta();
                                    agregarVistas();
                                }
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {
//                            if(nuevo.getBorder() == null){
//                                nuevo.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
//                            }else if(nuevo.getBorder().equals(Color.black)){
//                                nuevo.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
//                            }
//                            
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                nuevo.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                nuevo.setBorder(null);
                            }
                        });

                        panel.add(nuevo);
                        datos[i][j] = nuevo;
                        panel.repaint();
                        temp = temp.getSiguiente();
                    } else if (array != null && a < array.length) {
                        JLabel nuevo = new JLabel();
                        nuevo.setBounds(5 + (105 * j), 5 + (105 * i), 100, 100);

                        ImageIcon imagen = new ImageIcon("archivo.png");
                        ImageIcon imag = new ImageIcon(imagen.getImage().getScaledInstance(nuevo.getWidth(), nuevo.getHeight() - 25, Image.SCALE_DEFAULT));

                        nuevo.setIcon(imag);
                        nuevo.setText(array[a].getNombre());
                        nuevo.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
                        nuevo.setVerticalTextPosition((int) BOTTOM_ALIGNMENT);
                        nuevo.setVerticalAlignment((int) BOTTOM_ALIGNMENT);

                        nuevo.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() == 2) {

                                    System.out.println("double clicked");
                                } else if (e.getButton() == MouseEvent.BUTTON3) {
                                    EDDP2.archivos = array;
                                    EDDP2.padre = matriz;
                                    for (int i = 0; i < array.length; i++) {
                                        if (array[i].getNombre().equals(nuevo.getText())) {
                                            EDDP2.archivoM = array[i];
                                        }
                                    }
                                    new opcionesArchivo();

                                    System.out.println("click derecho");;
                                }
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                nuevo.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                nuevo.setBorder(null);
                            }
                        });

                        panel.add(nuevo);
                        datos[i][j] = nuevo;
                        panel.repaint();
                        a++;
                    }
                }
            }

        }

        panel.repaint();

    }

    public void vista() {
        //JFrame frame = new JFrame("JList ImageIcon Demonstration");

        DefaultListModel dlm = new DefaultListModel();
        dlm.addElement(new ListEntry("Carpeta 1", new ImageIcon("carpeta.png")));

        JList list = new JList(dlm);
        list.setCellRenderer(new ListEntryCellRenderer());

        panel.add(BorderLayout.CENTER, new JScrollPane(list));

    }

    class ListEntry {

        private String value;
        private ImageIcon icon;

        public ListEntry(String value, ImageIcon icon) {
            this.value = value;
            this.icon = icon;
        }

        public String getValue() {
            return value;
        }

        public ImageIcon getIcon() {
            return icon;
        }

        public String toString() {
            return value;
        }
    }

    class ListEntryCellRenderer
            extends JLabel implements ListCellRenderer {

        private JLabel label;

        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected,
                boolean cellHasFocus) {
            ListEntry entry = (ListEntry) value;

            setText(value.toString());
            setIcon(entry.getIcon());

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setEnabled(list.isEnabled());
            setFont(list.getFont());
            setOpaque(true);

            return this;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton ga;
    private javax.swing.JButton gc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel ruta;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
