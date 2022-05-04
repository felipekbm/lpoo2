/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.util.ArrayList;
import models.Jogador;
import models.Selecao;
import java.util.List;
import persistencia.dao.mysql.MySqlJogadorDAO;
import static telas.ListaParticipantes.conn;
import static telas.ListaParticipantes.jogadores;

/**
 *
 * @author User
 */
public class ListaEspecifica extends javax.swing.JFrame {

    Selecao selecao = null;

    /**
     * Creates new form ListaEspecifica
     */
    public ListaEspecifica(Selecao selecao) {
        initComponents();
        this.selecao = selecao;
        this.setVisible(true);
        renderPlayers();
        setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jLabel1.setText(this.selecao.getNome());

    }

    public void renderPlayers() {

        contatoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = contatoTable.rowAtPoint(evt.getPoint());
                int col = contatoTable.columnAtPoint(evt.getPoint());
                setResizable(false);
                
                if (row >= 0) {
                  Jogador jogadorFocus = selecao.getJogadores().get(row);
                    System.out.println(jogadorFocus.getNome());
                    System.out.println(jogadorFocus.getSelecao().getNome());
                    System.out.println(jogadorFocus.getPosicao().getNome());
                    
                    
                    new ParticipanteTela(jogadorFocus);
                }
            }
        });

        Object[][] jogadoresView = new Object[this.selecao.getJogadores().size()][5];
        for (int i = 0; i < this.selecao.getJogadores().size(); i++) {
            jogadoresView[i][0] = this.selecao.getJogadores().get(i).getNome();
            jogadoresView[i][1] = this.selecao.getJogadores().get(i).getData_nasc();
            jogadoresView[i][2] = this.selecao.getJogadores().get(i).getNacionalidade();
            jogadoresView[i][3] = this.selecao.getJogadores().get(i).getCamisa();
            jogadoresView[i][4] = this.selecao.getJogadores().get(i).getPosicao().getNome();

        }
        contatoTable.setModel(new javax.swing.table.DefaultTableModel(
                jogadoresView,
                new String[]{
                    "Nome", "Nascimento", "Nacionalidade", "Camisa", "Poição"
                }
        ));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        contatoTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contatoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Title 3", "Email"
            }
        ));
        jScrollPane1.setViewportView(contatoTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("SELECAO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 278, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 23, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable contatoTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}