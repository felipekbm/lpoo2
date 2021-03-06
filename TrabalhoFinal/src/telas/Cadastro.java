package telas;

import java.sql.Date;

import models.*;
import persistencia.dao.mysql.MySqlJogadorDAO;
import persistencia.dao.mysql.MySqlParticipanteDAO;
import static javax.swing.JOptionPane.showMessageDialog;
import persistencia.dao.mysql.MySqlJuizDAO;
import persistencia.dao.mysql.MySqlSelecaoDAO;
import persistencia.dao.mysql.MySqlTreinadorDAO;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public class Cadastro extends javax.swing.JFrame {

    Posicao posicaoFocus = null;
    Selecao selecaoFocus = null;
    Treinador treinadorFocus = null;
    java.text.SimpleDateFormat sdf
            = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

       public Cadastro(Selecao selecao) {
          initComponents();
        this.selecaoFocus = selecao;
        
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        System.out.println(selecao.getNome());
        editarSelecao();
    }
       
        void editarSelecao() {
        System.out.println(selecaoFocus.getNome());
        jLabel1.setText("Editar SELEÇÃO");
        jButton2.setVisible(false);
        jButton1.setVisible(false);
        jTextField6.setVisible(false);
        jTextField5.setVisible(false);
        jTextField2.setVisible(false);
jTextField3.setText(selecaoFocus.getNome());
                jTextField4.setText(selecaoFocus.getLogo());

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                MySqlSelecaoDAO DAO = new MySqlSelecaoDAO(Menu.conn);
               
                if (DAO.atualizar( new Selecao(selecaoFocus.getId(), 
                        jTextField3.getText(), jTextField4.getText()))) {
                    showMessageDialog(null, "Seleção foi atualizada com sucesso, "
                            + "de refreash na página para visualizar o resultado!");
                    dispose();
                } else {
                    showMessageDialog(null, "Não foi possível atualizar a seleção! ");
                }

            }
        });
    }
    
    public Cadastro(Integer option) {
        initComponents();
        if (option == 1) {
            adicionaJogador();
        } else if (option == 2) {
            adicionaTreinador();
        } else if (option == 3) {
            adicionarJuiz();
        } else if (option == 4) {
            adicionarSelecao();
        }

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

    }

    void adicionarSelecao() {
        jLabel1.setText("ADICIONAR SELEÇÃO");
        jButton2.setVisible(false);
        jButton1.setVisible(false);
        jTextField6.setVisible(false);
        jTextField5.setVisible(false);
        jTextField2.setVisible(false);

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
    System.out.println(jTextField3.getText()+ " " + jTextField4.getText());
                Selecao novo = new Selecao(0, jTextField3.getText(), jTextField4.getText());
                  System.out.println(novo.getNome());
                MySqlSelecaoDAO DAO = new MySqlSelecaoDAO(Menu.conn);

                if (DAO.novo(novo)) {
                    dispose();
                } else {
                    showMessageDialog(null, "Não foi possível criar a nova selecao! ");
                }

            }
        });

    }

    void adicionarJuiz() {
        jLabel1.setText("ADICIONAR JUIZ");
        jButton2.setVisible(false);
        jButton1.setVisible(false);
        jTextField6.setVisible(false);

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                Juiz novo = new Juiz(0, jTextField2.getText(), new Date(1953, 12, 12), jTextField3.getText(),
                        jTextField4.getText());

                MySqlParticipanteDAO partDAO = new MySqlParticipanteDAO(Menu.conn);
                MySqlJuizDAO DAO = new MySqlJuizDAO(Menu.conn);
                partDAO.novo(novo);

                novo.setId(partDAO.ultimo());

                DAO.novo(novo);

                if (novo.getId() > 0) {
                    dispose();
                } else {
                    showMessageDialog(null, "Não foi possível criar o novo juiz! ");
                }

            }
        });

    }

    void adicionaTreinador() {
        jLabel1.setText("ADICIONAR TREINADOR");
        jButton2.setVisible(false);
        jTextField6.setVisible(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                HelperList hp = new HelperList(selecaoFocus, true);

                hp.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = hp.getTable().rowAtPoint(evt.getPoint());
                        int col = hp.getTable().columnAtPoint(evt.getPoint());

                        if (row >= 0) {
                            selecaoFocus = hp.selecoes.get(row);
                            jButton1.setText(selecaoFocus.getNome());
                        }
                    }
                });

            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                Treinador novo = new Treinador(0, jTextField2.getText(), new Date(1953, 12, 12), jTextField3.getText(),
                        jTextField4.getText());
                novo.setSelecao(selecaoFocus);
                MySqlParticipanteDAO partDAO = new MySqlParticipanteDAO(Menu.conn);
                MySqlTreinadorDAO DAO = new MySqlTreinadorDAO(Menu.conn);
                partDAO.novo(novo);

                novo.setId(partDAO.ultimo());

                DAO.novo(novo);

                if (novo.getId() > 0) {
                    dispose();
                } else {
                    showMessageDialog(null, "Não foi possível criar o novo treinador! ");
                }

            }
        });

    }

    void adicionaJogador() {
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                HelperList hp = new HelperList(posicaoFocus);

                hp.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = hp.getTable().rowAtPoint(evt.getPoint());
                        int col = hp.getTable().columnAtPoint(evt.getPoint());
                        setResizable(false);

                        if (row >= 0) {
                            posicaoFocus = hp.posicoes.get(row);
                            jButton2.setText(posicaoFocus.getNome());
                        }
                    }
                });
                jButton2.setText(posicaoFocus.getNome());
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                HelperList hp = new HelperList(selecaoFocus, false);

                hp.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = hp.getTable().rowAtPoint(evt.getPoint());
                        int col = hp.getTable().columnAtPoint(evt.getPoint());
                        setResizable(false);

                        if (row >= 0) {
                            selecaoFocus = hp.selecoes.get(row);
                            jButton1.setText(selecaoFocus.getNome());
                        }
                    }
                });

            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                Jogador novoJogador = new Jogador(0, jTextField2.getText(), new Date(1953, 12, 12), jTextField3.getText(),
                        jTextField4.getText(), Integer.parseInt(jTextField6.getText()));
                novoJogador.setSelecao(selecaoFocus);
                novoJogador.setPosicao(posicaoFocus);
                MySqlParticipanteDAO partDAO = new MySqlParticipanteDAO(Menu.conn);
                MySqlJogadorDAO jogDAO = new MySqlJogadorDAO(Menu.conn);
                partDAO.novo(novoJogador);

                novoJogador.setId(partDAO.ultimo());

                jogDAO.novo(novoJogador);

                if (novoJogador.getId() > 0) {
                    dispose();
                } else {
                    showMessageDialog(null, "Não foi possível criar o novo jogador! ");
                }

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ADICIONAR JOGADOR");

        jTextField2.setText("NACIONALIDADE");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("NOME");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setText("FOTO");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setText("DATA NASCIMENTO");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setText("CAMISA");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton1.setText("SELECAO");

        jButton2.setText("POSICAO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jTextField6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(210, Short.MAX_VALUE)))
        );

        jButton3.setText("CONFIRMAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)
                        .addGap(143, 143, 143)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
