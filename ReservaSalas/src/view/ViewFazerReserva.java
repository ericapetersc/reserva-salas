package view;

import beans.Sala;
import beans.Usuario;
import controller.ReservaController;
import controller.UsuarioController;
import java.util.List;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.JOptionPane;

public class ViewFazerReserva extends javax.swing.JFrame {

    private static ViewFazerReserva instance;
    private UsuarioController usuarioController = new UsuarioController();
    private ReservaController reservaController = new ReservaController();
    private String cpf;
    
    public ViewFazerReserva() {
        initComponents();
        Op2.setEnabledAt(1, false);
    }
    
    public static ViewFazerReserva getInstance(){
        if(instance==null)
            instance=new ViewFazerReserva();
        instance.popularUsuarios();
        return instance;
    }
    
    public void avisoComboBox(){
        JOptionPane.showMessageDialog(null, "Ocorreu um erro. Não foi possível popular o ComboBox!");
    }
    
    public void popularUsuarios(){
        boxUsuario.removeAllItems();
        List<Usuario> usuarios = usuarioController.listaTodos();
        if(usuarios.size()==0){
            JOptionPane.showMessageDialog(null, "Não há nenhum usuario cadastrado!");
        }
        else{
            while(!usuarios.isEmpty()){
                Usuario u = usuarios.get(0);
                boxUsuario.addItem(u.getCPF() + " - " + u.getNome());
                usuarios.remove(0);
            }
            AutoCompleteDecorator.decorate(boxUsuario);
        }
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public String getPeriodo(){
        return boxPeriodo.getSelectedItem().toString();
    }
    
    public String getData(){
        return dataCampo.getText();
    }
    
    public String getBloco(){
        return boxBloco.getSelectedItem().toString();
    }
    
    public void setCpf(){
        String valorCombo = boxUsuario.getItemAt(boxUsuario.getSelectedIndex());
        int pos = valorCombo.indexOf(" - ");
        this.cpf = valorCombo.substring(0, pos);
    }
    
    public void popularSalas(List<Sala> salas){
        boxSala.removeAllItems();
        if(salas.size()==0){
            JOptionPane.showMessageDialog(null, "Não há nenhuma sala disponível!");
        }
        else{
            while(!salas.isEmpty()){
                Sala s = salas.get(0);
                String tipo;
                if(s.getTipo()==1)
                    tipo="Normal";
                else
                    tipo="Laboratorio";
                boxSala.addItem(s.getNumero() + " - " + tipo);
                salas.remove(0);
            }
            AutoCompleteDecorator.decorate(boxUsuario);
        }
    }
    
    public int getSala(){
        String valorCombo = boxSala.getItemAt(boxSala.getSelectedIndex());
        int pos = valorCombo.indexOf(" - ");
        String sala = valorCombo.substring(0, pos);
        return Integer.parseInt(sala);
    }
    
    public void AvisoReservaConcluida(int codigo){
        JOptionPane.showMessageDialog(null, "Reserva Concluida. Seu codigo de reserva é " + codigo);
        Main.menu.setVisible(true);
        this.dispose();
    }
    
    public void AvisoErroNaReserva(){
        JOptionPane.showMessageDialog(null, "Houve um erro. Não foi possível realizar a reserva.");
    }
    
    public void LimparTela(){
        dataCampo.setText("");
        boxUsuario.setSelectedIndex(0);
        boxBloco.setSelectedIndex(0);
        boxSala.removeAllItems();
    }
    
    public String RemoverBarrasDaData (String nascimento){
        nascimento = nascimento.replace("/", ""); //tira barra
        return nascimento;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuItem1 = new javax.swing.JMenuItem();
        Op2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        boxUsuario = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        boxPeriodo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dataCampo = new javax.swing.JFormattedTextField();
        Avancar = new javax.swing.JButton();
        Voltar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        boxBloco = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        boxSala = new javax.swing.JComboBox<>();
        Reservar = new javax.swing.JButton();
        Voltar1 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Selecione as opções:");

        jLabel1.setText("Usuário:");

        boxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Período:");

        boxPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde", "Noite" }));

        jLabel3.setText("Data:");

        try {
            dataCampo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        Avancar.setText("AVANÇAR");
        Avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvancarActionPerformed(evt);
            }
        });

        Voltar.setText("CANCELAR");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        jLabel8.setText("Bloco:");

        boxBloco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "F", "G", "L", "K" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(Voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(Avancar)
                .addGap(89, 89, 89))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(boxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxPeriodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataCampo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(boxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(boxBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Avancar)
                    .addComponent(Voltar))
                .addGap(40, 40, 40))
        );

        Op2.addTab("Opções", jPanel1);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Escolha a sala:");

        jLabel7.setText("Salas disponíveis:");

        boxSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSalaActionPerformed(evt);
            }
        });

        Reservar.setText("RESERVAR");
        Reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservarActionPerformed(evt);
            }
        });

        Voltar1.setText("CANCELAR");
        Voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Voltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(151, 151, 151)
                            .addComponent(jLabel5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(Voltar1)
                            .addGap(91, 91, 91)
                            .addComponent(Reservar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(boxSala, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(boxSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reservar)
                    .addComponent(Voltar1))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        Op2.addTab("Sala", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Op2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Op2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvancarActionPerformed
        
        setCpf();
        reservaController.listaSalas();
        
        //Abrir a segunda guia
        Op2.setSelectedIndex(1);
        Op2.setEnabledAt(1, true);

    }//GEN-LAST:event_AvancarActionPerformed

    private void ReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservarActionPerformed
         switch (JOptionPane.showConfirmDialog(null, "Tem certeza que cadastrar essa reserva?")) {
            case 0:
            reservaController.fazReserva();
         }
    }//GEN-LAST:event_ReservarActionPerformed

    private void Voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Voltar1ActionPerformed
        // TODO add your handling code here:
        switch (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar essa operação?")) {
            case 0:
                LimparTela();
                this.dispose();
                Main.menu.setVisible(true);
                break;
        }
    }//GEN-LAST:event_Voltar1ActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        // TODO add your handling code here:
        switch (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar essa operação?")) {
            case 0:
                this.dispose();
                Main.menu.setVisible(true);
                break;
        }
    }//GEN-LAST:event_VoltarActionPerformed

    private void boxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxUsuarioActionPerformed

    private void boxSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSalaActionPerformed

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
            java.util.logging.Logger.getLogger(ViewFazerReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFazerReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFazerReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFazerReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFazerReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Avancar;
    private javax.swing.JTabbedPane Op2;
    private javax.swing.JButton Reservar;
    private javax.swing.JButton Voltar;
    private javax.swing.JButton Voltar1;
    public javax.swing.JComboBox<String> boxBloco;
    public javax.swing.JComboBox<String> boxPeriodo;
    public javax.swing.JComboBox<String> boxSala;
    public javax.swing.JComboBox<String> boxUsuario;
    public javax.swing.JFormattedTextField dataCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
