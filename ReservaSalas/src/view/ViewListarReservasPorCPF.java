
package view;

import beans.Reserva;
import beans.Sala;
import beans.Usuario;
import controller.ReservaController;
import controller.UsuarioController;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class ViewListarReservasPorCPF extends javax.swing.JFrame {
    private static ViewListarReservasPorCPF instance;
    private String cpf;
    private UsuarioController controllerUsuario = new UsuarioController();
    private ReservaController controllerReserva = new ReservaController();


    private ViewListarReservasPorCPF() {
        initComponents();
    }
    
    public static ViewListarReservasPorCPF getInstance(){
        if (instance==null)
            instance = new ViewListarReservasPorCPF();
        instance.popularComboBox();
        return instance;
    }
    
    public void popularComboBox(){
        combo.removeAllItems();
        List<Usuario> usuarios = controllerUsuario.listaTodos();
        if(usuarios.size()==0){
            JOptionPane.showMessageDialog(null, "Não há nenhum aluno ou servidor cadastrado!");
        }
        else{
            while(!usuarios.isEmpty()){
                Usuario u = usuarios.get(0);
                combo.addItem(u.getCPF() + " - " + u.getNome());
                usuarios.remove(0);
            }
            AutoCompleteDecorator.decorate(combo);
        }
    }
    
    public String getCPF(){
        return this.cpf;
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
        jButton2 = new javax.swing.JButton();

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
                "Código", "Data", "Período", "Bloco", "Sala", "Tipo Sala"
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

        jLabel2.setText("CPF:");

        jButton2.setText("VOLTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jButton2)))
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(144, 144, 144)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(264, 264, 264)
                            .addComponent(jButton1))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(49, 49, 49))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jLabel1)
                    .addGap(28, 28, 28)
                    .addComponent(jButton1)
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(100, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String valorCombo = combo.getSelectedItem().toString();
        int pos = valorCombo.indexOf(" - ");
        this.cpf = valorCombo.substring(0, pos);
        List<Reserva> lista = controllerReserva.listaReservasPorCPF();
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
            linha[1] = format("##/##/####", r.getData());
            linha[2] = r.getPeriodo();
            s = controllerReserva.consultarSalaListarTodasReservas(r.getIdSala());
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
          int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar ao menu principal?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( resposta == JOptionPane.YES_OPTION ){
            // fechar esta janela e abrir o menu principal novamente
            Main.menu.setVisible( true );
            this.dispose();
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(ViewListarReservasPorCPF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewListarReservasPorCPF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewListarReservasPorCPF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewListarReservasPorCPF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewListarReservasPorCPF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabelaReservas;
    // End of variables declaration//GEN-END:variables
}
