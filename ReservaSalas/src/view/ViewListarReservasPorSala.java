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

public class ViewListarReservasPorSala extends javax.swing.JFrame {
    private static ViewListarReservasPorSala instance;
    private ReservaController controller = new ReservaController();


    private ViewListarReservasPorSala() {
        initComponents();
    }
    
    public static ViewListarReservasPorSala getInstance(){
        if (instance==null)
            instance = new ViewListarReservasPorSala();
        instance.popularComboBox();
        return instance;
    }
    
    public void popularComboBox(){
        boolean verificarExistencia=false;
        Reserva r;
        Sala s;
        combo.removeAllItems();
        List<Reserva> reservas = controller.listaReservas();
        if(reservas.size()==0){
            JOptionPane.showMessageDialog(null, "Não há nenhuma reserva cadastrada!");
        }
        else{
            while(!reservas.isEmpty()){
                r = reservas.get(0);
                s = controller.consultarSalaListarTodasReservas(r.getIdSala());
                if (combo.getItemCount()==0){
                    combo.addItem("Numero:"+s.getNumero()+" - Bloco:"+s.getBloco()+" - Id:"+r.getIdSala());
                }else{
                    for (int i=0; i<combo.getItemCount(); i++){
                        if (combo.getItemAt(i).equals("Numero:"+s.getNumero()+" - Bloco:"+s.getBloco()+" - Id:"+r.getIdSala())){
                            verificarExistencia=true;
                        }
                    }
                    if (verificarExistencia==false){
                        combo.addItem("Numero:"+s.getNumero()+" - Bloco:"+s.getBloco()+" - Id:"+r.getIdSala());
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
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaReservas = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        Voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("RESERVAS NO SISTEMA");

        tabelaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código Reserva", "Responsável", "Período", "Bloco", "Número Sala", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        jLabel2.setText("Sala:");

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
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(144, 144, 144)
                            .addComponent(jLabel1)
                            .addGap(152, 152, 152))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jSeparator2)
                            .addContainerGap()))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(206, 206, 206)
                    .addComponent(Voltar)
                    .addContainerGap(207, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jLabel1)
                    .addGap(75, 75, 75)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(235, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(306, Short.MAX_VALUE)
                    .addComponent(Voltar)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
        String valorCombo = combo.getSelectedItem().toString();
        String[] valor = valorCombo.split(" - Id:");
        valorCombo = valor[1];
        List<Reserva> lista = controller.listaReservasPorSala(Integer.parseInt(valorCombo));
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
            java.util.logging.Logger.getLogger(ViewListarReservasPorSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewListarReservasPorSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewListarReservasPorSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewListarReservasPorSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewListarReservasPorSala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Voltar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabelaReservas;
    // End of variables declaration//GEN-END:variables
}
