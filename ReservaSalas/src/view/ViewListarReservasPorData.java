
package view;

import beans.Reserva;
import beans.Sala;
import controller.ReservaController;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class ViewListarReservasPorData extends javax.swing.JFrame {
    private static ViewListarReservasPorData instance;
    private String data;
    private ReservaController controller = new ReservaController();

    private ViewListarReservasPorData() {
        initComponents();
    }
    
    public static ViewListarReservasPorData getInstance(){
        if (instance==null)
            instance = new ViewListarReservasPorData();
        instance.popularComboBox();
        return instance;
    }
    
    public void popularComboBox(){
        boolean verificarExistencia = false;
        combo.removeAllItems();
        List<Reserva> reservas = controller.listaReservas();
        if(reservas.size()==0){
            JOptionPane.showMessageDialog(null, "Não há nenhuma reserva cadastrada!");
        }
        else{
            while(!reservas.isEmpty()){
                Reserva r = reservas.get(0);
                if(combo.getItemCount() == 0){
                    combo.addItem(format("##/##/####", r.getData()));
                }else{
                    for(int i=0; i<combo.getItemCount(); i++){
                        if(combo.getItemAt(i).equals(format("##/##/####", r.getData()))){
                            verificarExistencia = true;
                        }
                    }
                    if (verificarExistencia==false){
                        combo.addItem(format("##/##/####", r.getData()));
                    }else{
                        verificarExistencia=false;
                    }
                }
                     
                reservas.remove(0);
            }
            AutoCompleteDecorator.decorate(combo);
        }
    }
    
    private static String format(String pattern, Object value) { 
        MaskFormatter mask; 
        try { 
            mask = new MaskFormatter(pattern); 
            mask.setValueContainsLiteralCharacters(false); 
            return mask.valueToString(value); 
        } catch (ParseException e) { 
            throw new RuntimeException(e); 
        } 
    } 
    
    public String getData(){
        return this.data;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaReservas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        Voltar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("RESERVAS NO SISTEMA");

        jLabel2.setText("Data: ");

        tabelaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Responsável", "Período", "Bloco", "Sala", "Tipo Sala"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaReservas);

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Voltar.setText("VOLTAR");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 9, Short.MAX_VALUE))
                            .addComponent(jSeparator2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(Voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(Voltar)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String valorCombo = combo.getSelectedItem().toString();
        valorCombo = valorCombo.replace( "/" , "" );
        List<Reserva> lista = controller.listaReservasPorData(valorCombo);
        TableModel tb = tabelaReservas.getModel();
        if( !(tb instanceof DefaultTableModel) )
            return;
        
        //limpar tabela para depois re-inserir dados
        DefaultTableModel dtb = (DefaultTableModel) tb;
        int n = dtb.getRowCount();
        for(int i=0; i<n; i++){
            dtb.removeRow(0);
        }
        
        Reserva r;
        Sala s;
        
        while(!lista.isEmpty()){
            r = lista.get(0);
            Object linha[] = new Object[7];
            linha[0] = r.getCodigo();
            linha[1] = format("###-###-###.##", r.getCPF());
            linha[2] = r.getPeriodo();
            s = controller.consultarSalaListarTodasReservas(r.getIdSala());
            linha[3] = s.getBloco();
            linha[4] = s.getNumero();
            if (s.getTipo()==1){
                linha[5] = "Normal";
            }else{
                linha[5] = "Laboratório";
            }
            
            dtb.addRow( linha );
            lista.remove(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar ao menu principal?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( resposta == JOptionPane.YES_OPTION ){
            // fechar esta janela e abrir o menu principal novamente
            Main.menu.setVisible( true );
            this.dispose();
        }
    }//GEN-LAST:event_VoltarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewListarReservasPorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewListarReservasPorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewListarReservasPorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewListarReservasPorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewListarReservasPorData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Voltar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelaReservas;
    // End of variables declaration//GEN-END:variables
}
