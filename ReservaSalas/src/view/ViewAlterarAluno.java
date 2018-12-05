
package view;

import beans.Aluno;
import beans.Usuario;
import controller.AlunoController;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ViewAlterarAluno extends javax.swing.JFrame {
    
    private String cpf;
    private static ViewAlterarAluno instance;
    private AlunoController controller = new AlunoController();
    
    public ViewAlterarAluno() {
        initComponents();
    }
    
    public static ViewAlterarAluno getInstance(){
        if(instance==null)
            instance=new ViewAlterarAluno();
        instance.popularComboBox();
        return instance;
    }    
    
    public void avisoComboBox(){
        JOptionPane.showMessageDialog(null, "Ocorreu um erro. Não foi possível popular o ComboBox!");
    }
    
    public void popularComboBox(){
        combo.removeAllItems();
        List<Aluno> alunos = controller.listaCpf();
        if(alunos.size()==0){
            JOptionPane.showMessageDialog(null, "Não há nenhum aluno cadastrado!");
        }
        else{
            while(!alunos.isEmpty()){
                Aluno a = alunos.get(0);
                combo.addItem(a.getCPF() + " - " + a.getNome());
                alunos.remove(0);
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

    public boolean verificaCampos(){
        if (nome.getText().equals("")){
            return false;
        }
        if (sobrenome.getText().equals("")){
            return false;
        }
        if (matricula.getText().equals("")){
            return false;
        }
        if (semestre.getText().equals("")){
            return false;
        }
        if (nascimento.getText().equals("")){
            return false;
        }
        return true;
    }
    
    public boolean verificaCurso(){
        if(boxCurso.getSelectedIndex()>8 && boxFormacao.getSelectedIndex()!=1)
            return false;
        else if(boxCurso.getSelectedIndex()<=8 && boxFormacao.getSelectedIndex()!=0)
            return false;
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
    
    public String getCurso(){
        return boxCurso.getItemAt(boxCurso.getSelectedIndex());
    }
    
    public String getMatricula(){
        return matricula.getText();
    }
    
    public String getSemestre(){
        return semestre.getText();
    }
    
    public String getFormacao(){
        return boxFormacao.getItemAt(boxFormacao.getSelectedIndex());
    }
    
    public void AvisoCampos(){
        JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
    }
    
    public void AvisoCurso(){
        JOptionPane.showMessageDialog(null, "Esse curso nao está disponível para a sua formação!");
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
        matricula.setText("");
        semestre.setText("");
    }
    
    public void setCampos(Aluno a){
        nome.setText(a.getNome());
        sobrenome.setText(a.getSobrenome());
        nascimento.setText(a.getDataNascimento());
        matricula.setText(a.getMatricula());
        semestre.setText(a.getSemestreInicio());
        boxCurso.setSelectedItem(a.getCurso());
        if(a.getTipo()==0)
            boxFormacao.setSelectedItem("Graduando");
        else
            boxFormacao.setSelectedItem("Mestrando");
        combo.setSelectedItem(a.getCPF() + " - " + a.getNome());
    }
    
    public String RemoverBarrasDoNascimento (String nascimento){
        nascimento = nascimento.replace("/", ""); //tira barra
        return nascimento;
    }
    
    public String RemoverBarrasDoSemestreInicio (String semestreInicio){
        semestreInicio = semestreInicio.replace("/", "");
        return semestreInicio;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        boxCurso = new javax.swing.JComboBox<>();
        sobrenome = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nascimento = new javax.swing.JFormattedTextField();
        semestre = new javax.swing.JFormattedTextField();
        Alterar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        boxFormacao = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel3.setText("NOME: ");

        jLabel4.setText("SOBRENOME:");

        jLabel5.setText("NASCIMENTO:");

        jLabel6.setText("CURSO:");

        boxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eng. Civil", "Eng. Elétrica", "Eng. Mecânica", "Eng. Produção", "Computação", "TADS", "Física", "Matemática", "Química", "Computação Aplicada", "Eng. de Materiais", "Química Aplicada" }));
        boxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCursoActionPerformed(evt);
            }
        });

        jLabel2.setText("MATRÍCULA: ");

        jLabel7.setText("SEMESTRE INICIO:");

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

        try {
            semestre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        jLabel9.setText("FORMAÇÃO:");

        boxFormacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Graduando", "Mestrando" }));
        boxFormacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxFormacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(Alterar)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sobrenome))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(boxFormacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(semestre))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nascimento))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(boxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(boxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(boxFormacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Alterar)
                    .addComponent(Cancelar))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ALTERAR ALUNO");

        jLabel1.setText("CPF:");

        Buscar.setText("BUSCAR");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(Buscar)
                        .addGap(26, 26, 26)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCursoActionPerformed

    private void nascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nascimentoActionPerformed

    private void AlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarMouseClicked

    }//GEN-LAST:event_AlterarMouseClicked

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Você realmente deseja alterar esse aluno?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( resposta == JOptionPane.YES_OPTION ){
            controller.alteraAluno();
        }else{
            
        }

    }//GEN-LAST:event_AlterarActionPerformed

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

    private void boxFormacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxFormacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxFormacaoActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed

        String valorCombo = combo.getSelectedItem().toString();
        int pos = valorCombo.indexOf(" - ");
        this.cpf = valorCombo.substring(0, pos);
        controller.consultaAlunoAlterar();
        
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
            java.util.logging.Logger.getLogger(ViewAlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAlterarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JComboBox<String> boxCurso;
    private javax.swing.JComboBox<String> boxFormacao;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField matricula;
    public javax.swing.JFormattedTextField nascimento;
    public javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField semestre;
    public javax.swing.JTextField sobrenome;
    // End of variables declaration//GEN-END:variables
}
