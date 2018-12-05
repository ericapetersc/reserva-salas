
package view;

import beans.Aluno;
import beans.Servidor;
import beans.Usuario;
import controller.ServidorController;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class ViewAlterarServidor extends javax.swing.JFrame {

    private String cpf;
    private static ViewAlterarServidor instance;
    private ServidorController controller = new ServidorController();
    
    public ViewAlterarServidor() {
        initComponents();
    }
    
    public static ViewAlterarServidor getInstance(){
        if(instance==null)
            instance=new ViewAlterarServidor();
        instance.popularComboBox();
        return instance;
    }    
    
    public void avisoComboBox(){
        JOptionPane.showMessageDialog(null, "Ocorreu um erro. Não foi possível popular o ComboBox!");
    }
    
    public void popularComboBox(){
        combo.removeAllItems();
        List<Servidor> servidores = controller.listaCpf();
        if(servidores.size()==0){
            JOptionPane.showMessageDialog(null, "Não há nenhum servidor cadastrado!");
        }
        else{
            while(!servidores.isEmpty()){
                Servidor s = servidores.get(0);
                combo.addItem(s.getCPF() + " - " + s.getNome());
                servidores.remove(0);
            }
            AutoCompleteDecorator.decorate(combo);
        }
    }

    public boolean verificaCampos(){
        if (nome.getText().equals("")){
            return false;
        }
        if (sobrenome.getText().equals("")){
            return false;
        }
        if (id.getText().equals("")){
            return false;
        }
        if (nascimento.getText().equals("")){
            return false;
        }
        return true;
    }
    
    public String getNome(){
        return nome.getText();
    }
    
    public String getSobrenome(){
        return sobrenome.getText();
    }
    
    public String getNascimento(){
        return nascimento.getText();
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public String getCargo(){
        return boxCargo.getItemAt(boxCargo.getSelectedIndex());
    }
    
    public String getId(){
        return id.getText();
    }
    
    public void AvisoCampos(){
        JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
    }
    
    public void AvisoAlteracaoConcluida(){
        JOptionPane.showMessageDialog(null, "Usuario alterado");
        Main.menu.setVisible(true);
        this.dispose();
    }
    
    public void avisoSetCampos(){
        JOptionPane.showMessageDialog(null, "Houve um erro. Não foi possível buscar os dados desse cpf.");
    }
    
    public void avisoErroNaAlteracao(){
        JOptionPane.showMessageDialog(null, "Houve um erro. Não foi possível alterar os dados desse cpf.");
    }
    
    public void LimparTela(){
        nome.setText("");
        sobrenome.setText("");
        nascimento.setText("");
        id.setText("");
        boxCargo.setSelectedIndex(0);
    }
    
    public void setCampos(Servidor s){
        nome.setText(s.getNome());
        sobrenome.setText(s.getSobrenome());
        nascimento.setText(s.getDataNascimento());
        id.setText(s.getIdentificacao());
        boxCargo.setSelectedItem(s.getCargo());
    }
    
    public String RemoverBarrasDoNascimento (String nascimento){
        nascimento = nascimento.replace("/", ""); //tira barra
        return nascimento;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sobrenome = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        nascimento = new javax.swing.JFormattedTextField();
        Alterar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        boxCargo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ALTERAR SERVIDOR");

        jLabel3.setText("NOME: ");

        jLabel4.setText("SOBRENOME:");

        jLabel5.setText("NASCIMENTO:");

        try {
            nascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        nascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nascimentoActionPerformed(evt);
            }
        });

        Alterar.setText("ALTERAR");
        Alterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AlterarMouseClicked(evt);
            }
        });
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });

        Cancelar.setText("CANCELAR");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("CARGO:");

        boxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Professor", "Supervisor", "Secretário" }));
        boxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCargoActionPerformed(evt);
            }
        });

        jLabel6.setText("ID:");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(id))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sobrenome))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Alterar)
                    .addComponent(Cancelar)))
        );

        jLabel2.setText("CPF:");

        Buscar.setText("BUSCAR");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Buscar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void boxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCargoActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, "Você realmente deseja cancelar essa operação?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( resposta == JOptionPane.YES_OPTION ){
            // fechar esta janela e abrir o menu principal novamente
            this.LimparTela();
            Main.menu.setVisible( true );
            this.dispose();
        }
    }//GEN-LAST:event_CancelarActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Você realmente deseja alterar esse servidor?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( resposta == JOptionPane.YES_OPTION ){
            controller.alteraServidor();
        }
    }//GEN-LAST:event_AlterarActionPerformed

    private void AlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarMouseClicked
        
    }//GEN-LAST:event_AlterarMouseClicked

    private void nascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nascimentoActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed

        String valorCombo = combo.getSelectedItem().toString();
        int pos = valorCombo.indexOf(" - ");
        this.cpf = valorCombo.substring(0, pos);
        controller.consultaServidorAlterar();
        
    }//GEN-LAST:event_BuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAlterarServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAlterarServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAlterarServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAlterarServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAlterarServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JComboBox<String> boxCargo;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField id;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JFormattedTextField nascimento;
    public javax.swing.JTextField nome;
    public javax.swing.JTextField sobrenome;
    // End of variables declaration//GEN-END:variables
}
