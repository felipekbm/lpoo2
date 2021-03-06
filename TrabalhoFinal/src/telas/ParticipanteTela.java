package telas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import models.Jogador;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import models.Juiz;
import models.Treinador;
import persistencia.dao.mysql.MySqlJogadorDAO;
import persistencia.dao.mysql.MySqlJuizDAO;
import persistencia.dao.mysql.MySqlParticipanteDAO;
import persistencia.dao.mysql.MySqlTreinadorDAO;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */
public class ParticipanteTela extends javax.swing.JFrame {

    Jogador jogador = null;
    Treinador treinador = null;
    Juiz juiz = null;
    int tipoParticipante = 0;

    public ParticipanteTela(Jogador jogador) {
        this.jogador = jogador;
        try {
            URL url = new URL(jogador.getFoto());
            Image image = ImageIO.read(url).getScaledInstance(388, 300, Image.SCALE_DEFAULT);;
            JLabel imgLabel = new JLabel(new ImageIcon(image));
            
            imgLabel.setSize(215, 210);
            this.setSize(500, 500);
            setResizable(false);
            this.add(imgLabel).setLocation(20, 35);
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }

        initComponents();
        this.setVisible(true);

        System.out.print(this.jogador.getFoto());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        exibeJogador();
    }

    public ParticipanteTela(Treinador treinador) {
        this.treinador = treinador;
        try {
            URL url = new URL(treinador.getFoto());
            Image image = ImageIO.read(url).getScaledInstance(388, 300, Image.SCALE_DEFAULT);;
            JLabel imgLabel = new JLabel(new ImageIcon(image));

            imgLabel.setSize(215, 210);
            this.setSize(500, 500);
            setResizable(false);
            this.add(imgLabel).setLocation(20, 35);

        } catch (Exception ex) {

        }

        initComponents();
        this.setVisible(true);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        exibeTreinador();

    }

    public ParticipanteTela(Juiz juiz) {
        this.juiz = juiz;
        try {
            URL url = new URL(juiz.getFoto());
            Image image = ImageIO.read(url).getScaledInstance(388, 300, Image.SCALE_DEFAULT);;
            JLabel imgLabel = new JLabel(new ImageIcon(image));

            imgLabel.setSize(215, 210);
            this.setSize(500, 500);
            setResizable(false);
            this.add(imgLabel).setLocation(20, 35);

        } catch (Exception ex) {

        }

        initComponents();
        this.setVisible(true);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        exibeJuiz();
        
        //setLocationRelativeTo(null);

    }

    void exibeJuiz() {
        tipoParticipante = 1;
        btnEditar.setVisible(true);
        
        jTextField1.setText(this.juiz.getNome());
        
        jLabel1.setText("Nacionalidade");
        jTextField2.setText(this.juiz.getNacionalidade());
        
        jLabel2.setText("Data de Nascimento");
        jTextField3.setText(juiz.getData_nasc().toString());

        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jTextField6.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
    }

    void exibeTreinador() {
        tipoParticipante = 2;    
        jTextField1.setText(this.treinador.getNome());
        jLabel1.setText("Nacionalidade");
        jTextField2.setText(this.treinador.getNacionalidade());
        
        jLabel2.setText("Sele????o");
        jTextField3.setText(this.treinador.getSelecao().getNome());
        
        jLabel4.setText("Data de Nascimento");
        jTextField6.setText(treinador.getData_nasc().toString());
        ;

        jLabel3.setVisible(false);
        jLabel5.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
    }

    void exibeJogador() {
        tipoParticipante = 3;
        btnEditar.setVisible(true);
        jTextField1.setText(this.jogador.getNome());
        jLabel1.setText("Posi????o");
        jTextField2.setText(this.jogador.getPosicao().getNome());
        
        jLabel2.setText("Camisa");        
        jTextField3.setText(this.jogador.getCamisa().toString());
        
        jLabel4.setText("Nacionalidade");
        jTextField6.setText(this.jogador.getNacionalidade());
        
        jLabel3.setText("Sele????o");
        jTextField4.setText(this.jogador.getSelecao().getNome());
        
        jLabel5.setText("Data de Nascimento");
        jTextField5.setText(jogador.getData_nasc().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        btnEditar = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome");

        jLabel1.setText("Informa????o 2");

        jLabel2.setText("Informa????o 3");

        jLabel3.setText("Informa????o 5");

        jLabel4.setText("Data de Nascimento");

        jLabel5.setText("Informa????o 6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelNome)
                .addGap(4, 4, 4)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEditar1.setText("Deletar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar1)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnEditar1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        //Update Juiz 
        if(tipoParticipante == 1){
            try{
                MySqlParticipanteDAO partDAO = new MySqlParticipanteDAO(Menu.conn);

                //atualiza Juiz no BD
                juiz.setNome(jTextField1.getText());
                juiz.setNacionalidade(jTextField2.getText());
                //juiz.setData_nasc(jTextField3.getText());
                
                partDAO.atualizar(juiz);

                JOptionPane.showMessageDialog(null, "Juiz [" + juiz.getNome() + "] editado com sucesso.");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "N??o foi poss??vel editar o juiz [" + juiz.getNome() + "]: " + e.getMessage());
            }
        }
        
        //atualiza Treinador no BD 
        if(tipoParticipante == 2){
            try{
                MySqlParticipanteDAO partDAO = new MySqlParticipanteDAO(Menu.conn);

                treinador.setNome(jTextField1.getText());
                treinador.setNacionalidade(jTextField2.getText());
                //treinador.setSelecao(jTextField3.getText());
                //treinador.setData_nasc(jTextField6.getText()));

                partDAO.atualizar(treinador);

                JOptionPane.showMessageDialog(null, "Treinador [" + treinador.getNome() + "] editado com sucesso.");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "N??o foi poss??vel editar o treinador [" + treinador.getNome() + "]: " + e.getMessage());
            }
        }
        
        if(tipoParticipante == 3){
            try{
                MySqlParticipanteDAO partDAO = new MySqlParticipanteDAO(Menu.conn);
                MySqlJogadorDAO jogadorDAO = new MySqlJogadorDAO(Menu.conn);

                //atualiza algumas informa????es do jogador no BD
                jogador.setNome(jTextField1.getText());
                jogador.setCamisa(Integer.parseInt(jTextField3.getText()));
                jogador.setNacionalidade(jTextField6.getText());

                partDAO.atualizar(jogador);
                jogadorDAO.atualizar(jogador);

                JOptionPane.showMessageDialog(null, "Jogador [" + jogador.getNome() + "] editado com sucesso.");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "N??o foi poss??vel editar o jogador [" + jogador.getNome() + "]: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
       if(jogador != null){
           MySqlJogadorDAO daoJ =  new MySqlJogadorDAO(Menu.conn);
           MySqlParticipanteDAO daoP =  new MySqlParticipanteDAO(Menu.conn);
           boolean j = daoJ.excluir(jogador.getId());
            boolean p = daoP.excluir(jogador.getId());
            
            if(j && p){
                  showMessageDialog(null, "O jogador foi excluido com sucesso d?? reload "
                          + "para visualizar os resultados!");
                  dispose();
            }else{
                showMessageDialog(null, "N??o foi poss??vel excluir  o jogador! ");
            }
           
       }
       
        if(treinador != null){
           MySqlTreinadorDAO daoT =  new MySqlTreinadorDAO(Menu.conn);
           MySqlParticipanteDAO daoP =  new MySqlParticipanteDAO(Menu.conn);
           boolean j = daoT.excluir(treinador.getId());
            boolean p = daoP.excluir(treinador.getId());
            
            if(j && p){
                  showMessageDialog(null, "O treinador foi excluido com sucesso d?? reload "
                          + "para visualizar os resultados!");
                  dispose();
            }else{
                showMessageDialog(null, "N??o foi poss??vel excluir  o treinador! ");
            }
           
       }
        
        
         if(juiz != null){
           MySqlJuizDAO daoT =  new MySqlJuizDAO(Menu.conn);
           MySqlParticipanteDAO daoP =  new MySqlParticipanteDAO(Menu.conn);
           boolean j = daoT.excluir(juiz.getId());
            boolean p = daoP.excluir(juiz.getId());
            
            if(j && p){
                  showMessageDialog(null, "O juiz foi excluido com sucesso d?? reload "
                          + "para visualizar os resultados!");
                  dispose();
            }else{
                showMessageDialog(null, "N??o foi poss??vel excluir  o juiz!"
                        + "Cheque se ele n??o est?? relacionado em nenhum jogo! ");
            }
           
       }
    }//GEN-LAST:event_btnEditar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
