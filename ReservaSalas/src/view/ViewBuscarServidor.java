package view;

import beans.Servidor;
import controller.ServidorController;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class ViewBuscarServidor extends javax.swing.JFrame {

    private String cpf;
    private static ViewBuscarServidor instance;
    private ServidorController controller = new ServidorController();
    
    private ViewBuscarServidor() {
        initComponents();
    }
    
    public static ViewBuscarServidor getInstance(){
        if(instance==null)
            instance=new ViewBuscarServidor();
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
        sobrenome1.setText("");
        nascimento.setText("");
        id.setText("");
        cargo.setText("");
        combo.setSelectedIndex(0);
    }
    
    public void setCampos(Servidor s){
        nome.setText(s.getNome());
        sobrenome1.setText(s.getSobrenome());
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Voltar = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        nascimento = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sobrenome = new javax.swing.JLabel();
        cargo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sobrenome1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel8.setText("Cargo:");

        Voltar.setText("VOLTAR");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome:");

        Buscar.setText("BUSCAR");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("Sobrenome:");

        jLabel6.setText("Identificação:");

        jLabel7.setText("Data de nascimento:");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("BUSCAR SERVIDOR");

        jLabel2.setText("CPF:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Voltar)
                        .addGap(164, 164, 164))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sobrenome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)
                            .addComponent(Buscar))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(91, 91, 91)
                                    .addComponent(sobrenome))
                                .addComponent(jLabel3))))
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(sobrenome1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Voltar)
                .addGap(24, 24, 24))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Buscar))
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addComponent(jLabel3)
                    .addGap(18, 18, 18)
                    .addComponent(sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(249, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar ao menu principal?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( resposta == JOptionPane.YES_OPTION ){
            // fechar esta janela e abrir o menu principal novamente
            this.LimparTela();
            Main.menu.setVisible( true );
            this.dispose();
        } 
    }//GEN-LAST:event_VoltarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        //Remove o cpf do nome no combo
        String valorCombo = combo.getSelectedItem().toString();
        int pos = valorCombo.indexOf(" - ");
        this.cpf = valorCombo.substring(0, pos);
        controller.consultaServidorBuscar();
    }//GEN-LAST:event_BuscarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBuscarServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel cargo;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nascimento;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel sobrenome;
    private javax.swing.JLabel sobrenome1;
    // End of variables declaration//GEN-END:variables
}
