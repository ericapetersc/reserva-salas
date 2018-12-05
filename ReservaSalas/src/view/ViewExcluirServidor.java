
package view;

import beans.Servidor;
import controller.ServidorController;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class ViewExcluirServidor extends javax.swing.JFrame {
    
    private String cpf;
    private static ViewExcluirServidor instance;
    private ServidorController controller = new ServidorController();

    public ViewExcluirServidor() {
        initComponents();
    }

    public static ViewExcluirServidor getInstance(){
        if(instance==null)
            instance=new ViewExcluirServidor();
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
    
    public void LimparTela(){
        nome.setText("");
        sobrenome.setText("");
        nascimento.setText("");
        id.setText("");
        cargo.setText("");
    }
    
    public void setCampos(Servidor s){
        nome.setText(s.getNome());
        sobrenome.setText(s.getSobrenome());
        nascimento.setText(format("##/##/####", s.getDataNascimento()));
        id.setText(s.getIdentificacao());
        cargo.setText(s.getCargo());
        combo.setSelectedItem(s.getCPF() + " - " + s.getNome());
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
        JOptionPane.showMessageDialog(null, "Houve um erro. Não foi possível excluir o servidor.");
    }
    
    public void avisoExclusaoConcluida(){
        JOptionPane.showMessageDialog(null, "Servidor excluído.");
        this.setVisible(false);
        Main.menu.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Voltar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sobrenome = new javax.swing.JLabel();
        nascimento = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cargo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel6.setText("IDENTIFICAÇÃO:");

        Voltar.setText("CANCELAR");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        jLabel7.setText("DATA DE NASCIMENTO:");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("EXCLUIR SERVIDOR");

        jLabel3.setText("NOME:");

        jLabel2.setText("CPF:");

        Buscar.setText("BUSCAR");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("SOBRENOME:");

        jLabel8.setText("CARGO:");

        Excluir.setText("EXCLUIR");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Buscar)
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Voltar)
                        .addGap(33, 33, 33)
                        .addComponent(Excluir))
                    .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Voltar)
                    .addComponent(Excluir))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        switch(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar ao menu?")){
            case 0:
                this.LimparTela();
                this.dispose();
                Main.menu.setVisible(true);
        }
    }//GEN-LAST:event_VoltarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        //Remove o cpf do nome no combo
        String valorCombo = combo.getSelectedItem().toString();
        int pos = valorCombo.indexOf(" - ");
        this.cpf = valorCombo.substring(0, pos);
        controller.consultaServidorExcluir();
    }//GEN-LAST:event_BuscarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        switch(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse servidor?")){
            case 0:
                controller.excluiServidor();
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewExcluirServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel cargo;
    public javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nascimento;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel sobrenome;
    // End of variables declaration//GEN-END:variables
}
