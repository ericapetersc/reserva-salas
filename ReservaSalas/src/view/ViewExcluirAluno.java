package view;

import beans.Aluno;
import controller.AlunoController;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class ViewExcluirAluno extends javax.swing.JFrame {
    
    private String cpf;
    private static ViewExcluirAluno instance;
    private AlunoController controller = new AlunoController();
    
    public ViewExcluirAluno() {
        initComponents();
    }
    
    public static ViewExcluirAluno getInstance(){
        if(instance==null)
            instance=new ViewExcluirAluno();
        instance.popularComboBox();
        return instance;
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formacao = new javax.swing.JLabel();
        sobrenome = new javax.swing.JLabel();
        semestre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Voltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nascimento = new javax.swing.JLabel();
        curso = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        matricula = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel6.setText("CURSO:");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("EXCLUIR ALUNO");

        jLabel7.setText("DATA DE NASCIMENTO:");

        jLabel2.setText("CPF:");

        jLabel8.setText("MATRÍCULA:");

        jLabel9.setText("SEMESTRE ÍNICIO:");

        Buscar.setText("BUSCAR");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jLabel10.setText("FORMAÇÃO:");

        Voltar.setText("CANCELAR");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        jLabel3.setText("NOME:");

        jLabel5.setText("SOBRENOME:");

        Excluir.setText("EXCLUIR");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(Voltar)
                .addGap(33, 33, 33)
                .addComponent(Excluir)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1))
                            .addGap(23, 23, 23)
                            .addComponent(Buscar))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sobrenome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(12, 12, 12)
                                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(curso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(matricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(semestre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(formacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Voltar)
                    .addComponent(Excluir))
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Buscar))
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7))
                                .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel8))
                        .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(formacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
        nascimento.setText(format("##/##/####", a.getDataNascimento()));
        matricula.setText(a.getMatricula());
        semestre.setText(format("####/#", a.getSemestreInicio()));
        curso.setText(a.getCurso());
        if(controller.tipoAluno(a.getCPF())==0)
            formacao.setText("Graduando");
        else
            formacao.setText("Mestrando");
        combo.setSelectedItem(a.getCPF() + " - " + a.getNome());
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
    
    public String getCpf(){
        return this.cpf;
    }
    
    public void avisoSetCampos(){
        JOptionPane.showMessageDialog(null, "Houve um erro. Não foi possível buscar os dados desse cpf.");
    }
    
    public void avisoErroExcluir(){
        JOptionPane.showMessageDialog(null, "Houve um erro. Não foi possível excluir o aluno.");
    }
    
    public void avisoExclusaoConcluida(){
        JOptionPane.showMessageDialog(null, "Aluno excluído.");
        this.setVisible(false);
        Main.menu.setVisible(true);
    }
    
    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        //Remove o cpf do nome no combo
        String valorCombo = combo.getSelectedItem().toString();
        int pos = valorCombo.indexOf(" - ");
        this.cpf = valorCombo.substring(0, pos);
        controller.consultaAlunoExcluir();
        
    }//GEN-LAST:event_BuscarActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Você realmente deseja cancelar essa operação?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( resposta == JOptionPane.YES_OPTION ){
            // fechar esta janela e abrir o menu principal novamente
            this.LimparTela();
            Main.menu.setVisible( true );
            this.dispose();
        } 
    }//GEN-LAST:event_VoltarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        switch(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse aluno?")){
            case 0:
                controller.excluiAluno();
        }
    }//GEN-LAST:event_ExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(ViewExcluirAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewExcluirAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewExcluirAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewExcluirAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewExcluirAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton Voltar;
    public javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel curso;
    private javax.swing.JLabel formacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel matricula;
    private javax.swing.JLabel nascimento;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel semestre;
    private javax.swing.JLabel sobrenome;
    // End of variables declaration//GEN-END:variables
}
