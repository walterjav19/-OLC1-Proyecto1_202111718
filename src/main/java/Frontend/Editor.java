/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Errores.ErrorLexico;
import analizadores.LexicoJSON;
import analizadores.SintacticoJSON;
import analizadores.SintacticoStatPy;
import analizadores.LexicoStatPy;
import analizadores.TokenJson;
import analizadores.sym;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java_cup.runtime.Symbol;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author USUARIO
 */
public class Editor extends javax.swing.JFrame {

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
    }
    
    
 
    
    public static void ReporteErrores(List<ErrorLexico> lista,String nombre){
        PrintWriter escribir=null;
        if(lista.isEmpty()){
            return;
        }
        
        try {
            String cabecera="<html>\n" +
                    "  <head>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <table border=\"7\">\n" +
                    "      <tr>\n" +
                    "        <th>Lexema</th>\n" +
                    "        <th>Línea</th>\n" +
                    "        <th>Columna</th>\n" +
                    "        <th>Descripción</th>\n" +
                    "      </tr>";
            String cuerpo="";
            for (ErrorLexico error:lista) {
                cuerpo+="      <tr>\n" +
                        "        <td>"+error.Lexema+"</td>\n" +
                        "        <td>"+Integer.toString(error.Linea)+"</td>\n" +
                        "        <td>"+Integer.toString(error.Columna)+"</td>\n" +
                        "        <td>"+error.Descripcion+"</td>\n" +
                        "      </tr>";
                
            }   String pie="    </table>\n" +
                    "  </body>\n" +
                    "</html>";  escribir = new PrintWriter(new File("src/main/java/ReporteErrores/ErroresLexicos_"+nombre+".html"));
                    escribir.print(cabecera+cuerpo+pie);
                    escribir.close();
                JOptionPane.showMessageDialog(null, " Errores Lexicos detectados revise reportes ","Error", JOptionPane.ERROR_MESSAGE);    
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro la carpeta");
        } finally {
            escribir.close();
        }
        
    }
    
    public static void ReporteSimbolos(List<Symbol> lista,String nombre){
        PrintWriter escribir=null;
        try {
            String cabecera="<html>\n" +
                    "  <head>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <table border=\"7\">\n" +
                    "      <tr>\n" +
                    "        <th>Token</th>\n" +
                    "        <th>Lexema</th>\n" +
                    "        <th>Linea</th>\n" +
                    "        <th>Columna</th>\n" +
                    "      </tr>";
            String cuerpo="";
            for (Symbol simbolo:lista) {
                cuerpo+="      <tr>\n" +
                        "        <td>"+TokenJson.terminalNames[simbolo.sym]+"</td>\n" +
                        "        <td>"+simbolo.value.toString()+"</td>\n" +
                        "        <td>"+Integer.toString(simbolo.left)+"</td>\n" +
                        "        <td>"+Integer.toString(simbolo.right)+"</td>\n" +
                        "      </tr>";
                
            }   String pie="    </table>\n" +
                    "  </body>\n" +
                    "</html>";  escribir = new PrintWriter(new File("src/main/java/ReporteTokens/TablaSimbolos_"+nombre+".html"));
                    escribir.print(cabecera+cuerpo+pie);
                    escribir.close();
                    
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro la carpeta");
        } finally {
            escribir.close();
        }
    }
    
        public static void ReporteSimbolos_Stat(List<Symbol> lista,String nombre){
        PrintWriter escribir=null;
        try {
            String cabecera="<html>\n" +
                    "  <head>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <table border=\"7\">\n" +
                    "      <tr>\n" +
                    "        <th>Token</th>\n" +
                    "        <th>Lexema</th>\n" +
                    "        <th>Linea</th>\n" +
                    "        <th>Columna</th>\n" +
                    "      </tr>";
            String cuerpo="";
            for (Symbol simbolo:lista) {
                cuerpo+="      <tr>\n" +
                        "        <td>"+sym.terminalNames[simbolo.sym]+"</td>\n" +
                        "        <td>"+simbolo.value.toString()+"</td>\n" +
                        "        <td>"+Integer.toString(simbolo.left)+"</td>\n" +
                        "        <td>"+Integer.toString(simbolo.right)+"</td>\n" +
                        "      </tr>";
                
            }   String pie="    </table>\n" +
                    "  </body>\n" +
                    "</html>";  
                    escribir = new PrintWriter(new File("src/main/java/ReporteTokens/TablaSimbolos_"+nombre+".html"));
                    escribir.print(cabecera+cuerpo+pie);
                    escribir.close();
                    
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro la carpeta");
        } finally {
            escribir.close();
        }
    }
    
    public static String leer(String path){
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      String texto="";
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (path);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            texto+=linea+"\n";
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{

         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      
    return texto;
    }

    public static void escribir(String path,String TextField2){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(path);
            pw = new PrintWriter(fichero);
            String texto=TextField2;
               
            pw.println(texto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
}
    
    public static String removeExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex == -1) {
            return fileName; // Si no se encuentra un punto, no hay extensión para eliminar
        }
        return fileName.substring(0, lastIndex);
    }
    
    
    public static void AnalizarJson(){
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setText("Analizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel1.setText("Entrada");

        jLabel3.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel3.setText("Analizador:");

        jLabel4.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel4.setText("Salida");

        jLabel5.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Save as");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Analyzer");

        jMenuItem4.setText("JSON");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("StatPy");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Report");

        jMenuItem6.setText("Barras");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("Pie");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(735, 735, 735)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 29, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    File selectedFile=null;
    String TipoAnalizador="";
    String Titulo_Barras,TituloEjeX_Barras,TituloEjeY_Barras;
    String Titulo_Pie;
    List<String> EjeX_Pie= new ArrayList<String>();
    List<Double> Valores_Pie= new ArrayList<Double>();
    List<String> EjeX= new ArrayList<String>();
    List<Double> Valores= new ArrayList<Double>();
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        String Texto="";
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            Texto=leer(selectedFile.getAbsolutePath());
            
        }
        jTextArea1.setText(Texto);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String Texto=jTextArea1.getText();
        escribir(selectedFile.getAbsolutePath(),Texto);
        JOptionPane.showMessageDialog(null, "Su Archivo "+selectedFile.getName()+" Fue Guardado Exitosamente", "Archivo Guardado", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        jLabel5.setText("JSON");
        TipoAnalizador="JSON";
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(TipoAnalizador=="JSON"){
            SintacticoJSON pars;
            try {
                LexicoJSON lex=new LexicoJSON(new FileReader(selectedFile.getAbsolutePath()));
                pars=new SintacticoJSON(lex);
                pars.parse();

                //Generamos el Reporte de Errores
                ReporteErrores(lex.ErroresLexicos,removeExtension(selectedFile.getName()));
                //Generamos Tabla de Simbolos
                ReporteSimbolos(lex.T_SIMBOLOS,removeExtension(selectedFile.getName()));
                //HashMap<String, HashMap<String, Object>> t_variables = new HashMap<String, HashMap<String, Object>>();
                //Guardamos el archivo
                String Texto=leer(selectedFile.getAbsolutePath());
                escribir(selectedFile.getName(),Texto);
                
                JOptionPane.showMessageDialog(null, "Archivo Analizado","AVISO", JOptionPane.INFORMATION_MESSAGE);
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, " Error "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }else if(TipoAnalizador=="StatPy"){
            SintacticoStatPy pars;
            try {
                LexicoStatPy lex=new LexicoStatPy(new FileReader(selectedFile.getAbsolutePath()));
                pars=new SintacticoStatPy(lex);
                pars.parse();
                //datos para mis graficas de barras
                Titulo_Barras=pars.Titulo_Barras;
                TituloEjeX_Barras=pars.TituloEjeX_Barras;
                TituloEjeY_Barras=pars.TituloEjeY_Barras;
                EjeX=pars.EjeX;
                Valores=pars.Valores;
                //datos para el pastel
                Titulo_Pie=pars.Titulo_Pie;
                EjeX_Pie=pars.EjeX_Pie;
                Valores_Pie=pars.Valores_Pie;
                
                //Generamos el Reporte de Errores
                ReporteErrores(lex.ErroresLexicos,removeExtension(selectedFile.getName()));
                //Generamos Tabla de Simbolos
                ReporteSimbolos_Stat(lex.T_SIMBOLOS,removeExtension(selectedFile.getName()));
                
                JOptionPane.showMessageDialog(null, "Archivo Analizado","AVISO", JOptionPane.INFORMATION_MESSAGE);
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, " Error "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Elija que tipo de Analizador quiere usar ","AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as");
        fileChooser.setSelectedFile(new File("untitled.txt"));
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            escribir(file.getAbsolutePath(),jTextArea1.getText());
            selectedFile=file;
            JOptionPane.showMessageDialog(null, "Su Archivo "+file.getName()+" Fue Guardado Exitosamente", "Archivo Guardado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        jLabel5.setText("StatPy");
        TipoAnalizador="StatPy";
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Ventana_Pie a=new Ventana_Pie();
        a.setVisible(true);
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < Valores_Pie.size(); i++) {
            dataset.setValue(EjeX_Pie.get(i), Valores_Pie.get(i));
        }
        
        
        JFreeChart chart = ChartFactory.createPieChart(
                Titulo_Pie,
                dataset,
                true,
                true,
                false
        );
        
        ChartPanel panel=new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(700,300));
        
        Ventana_Pie.jPanel1.setLayout(new BorderLayout());
        Ventana_Pie.jPanel1.add(panel,BorderLayout.NORTH);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Ventana_Barras a=new Ventana_Barras();
        a.setVisible(true);
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < Valores.size(); i++) {
            dataset.addValue(Valores.get(i), "Atributo", EjeX.get(i));
        }
        
        
        // Crear la gráfica de barras
        
        JFreeChart chart = ChartFactory.createBarChart(
                Titulo_Barras,// title
                TituloEjeX_Barras,//x axis
                TituloEjeY_Barras,//y axis
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        
        ChartPanel panel=new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(700,300));
        
        Ventana_Barras.jPanel1.setLayout(new BorderLayout());
        Ventana_Barras.jPanel1.add(panel,BorderLayout.NORTH);
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
