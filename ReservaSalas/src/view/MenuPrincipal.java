package view;
import javax.swing.JOptionPane;

        
public class MenuPrincipal extends javax.swing.JFrame {
    
    private static MenuPrincipal instance;
    
    private MenuPrincipal() {
        initComponents();
    }
    
    public static MenuPrincipal getInstance(){
        if(instance==null)
            instance=new MenuPrincipal();
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        popupMenu1 = new java.awt.PopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jDialog1 = new javax.swing.JDialog();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        User = new javax.swing.JMenu();
        CadastrarUser = new javax.swing.JMenuItem();
        AlterarUser = new javax.swing.JMenuItem();
        BuscarUser = new javax.swing.JMenuItem();
        ExcluirUser = new javax.swing.JMenuItem();
        ListarUser = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ListarSalas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        FazerReserva = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        Sistema = new javax.swing.JMenu();
        Sair = new javax.swing.JMenuItem();

        jButton3.setText("Cadastrar Usuário");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        popupMenu1.setLabel("popupMenu1");

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(432, 414));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/background.jpg"))); // NOI18N
        jLabel1.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/user.png"))); // NOI18N
        User.setText("Usuários");

        CadastrarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/user_add.png"))); // NOI18N
        CadastrarUser.setText("Cadastrar Usuário");
        CadastrarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUserActionPerformed(evt);
            }
        });
        User.add(CadastrarUser);

        AlterarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/user_edit.png"))); // NOI18N
        AlterarUser.setText("Alterar Usuário");
        AlterarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarUserActionPerformed(evt);
            }
        });
        User.add(AlterarUser);

        BuscarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/buscar.png"))); // NOI18N
        BuscarUser.setText("Buscar Usuário");
        BuscarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarUserActionPerformed(evt);
            }
        });
        User.add(BuscarUser);

        ExcluirUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/user_delete.png"))); // NOI18N
        ExcluirUser.setText("Excluir Usuário");
        ExcluirUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirUserActionPerformed(evt);
            }
        });
        User.add(ExcluirUser);

        ListarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/page.png"))); // NOI18N
        ListarUser.setText("Listar Usuários");
        ListarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarUserActionPerformed(evt);
            }
        });
        User.add(ListarUser);

        jMenuBar1.add(User);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/sala.png"))); // NOI18N
        jMenu4.setText("Salas");

        ListarSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/page.png"))); // NOI18N
        ListarSalas.setText("Listar Salas");
        ListarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarSalasActionPerformed(evt);
            }
        });
        jMenu4.add(ListarSalas);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/calendario.png"))); // NOI18N
        jMenu5.setText("Reservas");

        FazerReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cadastrar.png"))); // NOI18N
        FazerReserva.setText("Fazer Reserva");
        FazerReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FazerReservaActionPerformed(evt);
            }
        });
        jMenu5.add(FazerReserva);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/buscar.png"))); // NOI18N
        jMenuItem7.setText("Buscar Reserva");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/sair.jpg"))); // NOI18N
        jMenuItem8.setText("Excluir Reserva");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/page.png"))); // NOI18N
        jMenuItem9.setText("Listar Todas as Reservas");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cpfReserva.png"))); // NOI18N
        jMenuItem1.setText("Listar Reservas por CPF");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/calendarioReserva.png"))); // NOI18N
        jMenuItem2.setText("Listar Reservas por Data");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salaReserva.png"))); // NOI18N
        jMenuItem3.setText("Listar Reservas por Sala");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        Sistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/information.png"))); // NOI18N
        Sistema.setText("Sistema");
        Sistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SistemaActionPerformed(evt);
            }
        });

        Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/door_out.png"))); // NOI18N
        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Sistema.add(Sair);

        jMenuBar1.add(Sistema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void CadastrarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarUserActionPerformed
      Object[] options = {"ALUNO","SERVIDOR"};
      int i = JOptionPane.showOptionDialog(null, "Qual o tipo de usuário?", "Usuário", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch(i){
            case 0:
                this.dispose();
                ViewCadastrarAluno janela = ViewCadastrarAluno.getInstance();
                janela.setVisible(true);
                break;
            case 1:
                this.dispose();
                ViewCadastrarServidor janela1 = ViewCadastrarServidor.getInstance();
                janela1.setVisible(true);
                break;
        }
    }//GEN-LAST:event_CadastrarUserActionPerformed

    private void SistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SistemaActionPerformed
      
    }//GEN-LAST:event_SistemaActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        switch(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?")){
            case 0:
                this.dispose();
                System.exit(0);
        }
    }//GEN-LAST:event_SairActionPerformed

    private void ListarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarUserActionPerformed
        this.dispose();
        ViewListarUsuarios listar = ViewListarUsuarios.getInstance();
        listar.setVisible(true);
    }//GEN-LAST:event_ListarUserActionPerformed

    private void BuscarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarUserActionPerformed
        Object[] options = {"ALUNO","SERVIDOR"};
        int i = JOptionPane.showOptionDialog(null, "Qual o tipo de usuário?", "Usuário", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch(i){
            case 0:
                this.dispose();
                ViewBuscarAluno janela = ViewBuscarAluno.getInstance();
                janela.setVisible(true);
                break;
            case 1:
                this.dispose();
                ViewBuscarServidor janela1 = ViewBuscarServidor.getInstance();
                janela1.setVisible(true);
                break;
        }
    }//GEN-LAST:event_BuscarUserActionPerformed

    private void ExcluirUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirUserActionPerformed
        Object[] options = {"ALUNO","SERVIDOR"};
        int i = JOptionPane.showOptionDialog(null, "Qual o tipo de usuário?", "Usuário", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch(i){
            case 0:
                this.dispose();
                ViewExcluirAluno janela = ViewExcluirAluno.getInstance();
                janela.setVisible(true);
                break;
            case 1:
                this.dispose();
                ViewExcluirServidor janela1 = ViewExcluirServidor.getInstance();
                janela1.setVisible(true);
                break;
        }
    }//GEN-LAST:event_ExcluirUserActionPerformed

    private void AlterarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarUserActionPerformed
        Object[] options = {"ALUNO","SERVIDOR"};
        int i = JOptionPane.showOptionDialog(null, "Qual o tipo de usuário?", "Usuário", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch(i){
            case 0:
                this.dispose();
                ViewAlterarAluno janela = ViewAlterarAluno.getInstance();
                janela.setVisible(true);
                break;
            case 1:
                this.dispose();
                ViewAlterarServidor janela1 = ViewAlterarServidor.getInstance();
                janela1.setVisible(true);
                break;
        }
    }//GEN-LAST:event_AlterarUserActionPerformed

    private void ListarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarSalasActionPerformed
        this.dispose();
        ViewListarSalas janela = ViewListarSalas.getInstance();
        janela.setVisible(true);
    }//GEN-LAST:event_ListarSalasActionPerformed

    private void FazerReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FazerReservaActionPerformed
        this.dispose();
        ViewFazerReserva janela = ViewFazerReserva.getInstance();
        janela.setVisible(true);
    }//GEN-LAST:event_FazerReservaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewBuscarReserva janela = ViewBuscarReserva.getInstance();
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewExcluirReserva janela = ViewExcluirReserva.getInstance();
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewListarReservas janela = ViewListarReservas.getInstance();
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewListarReservasPorCPF janela = ViewListarReservasPorCPF.getInstance();
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewListarReservasPorData janela = ViewListarReservasPorData.getInstance();
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewListarReservasPorSala janela = ViewListarReservasPorSala.getInstance();
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AlterarUser;
    private javax.swing.JMenuItem BuscarUser;
    private javax.swing.JMenuItem CadastrarUser;
    private javax.swing.JMenuItem ExcluirUser;
    private javax.swing.JMenuItem FazerReserva;
    private javax.swing.JMenuItem ListarSalas;
    private javax.swing.JMenuItem ListarUser;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenu Sistema;
    private javax.swing.JMenu User;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
