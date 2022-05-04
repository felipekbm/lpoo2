/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Jogador;
import models.Jogo;
import models.Juiz;
import models.Selecao;
import models.Treinador;
import persistencia.dao.mysql.MySqlJogadorDAO;
import persistencia.dao.mysql.MySqlJogoDAO;
import persistencia.dao.mysql.MySqlJuizDAO;
import persistencia.dao.mysql.MySqlSelecaoDAO;
import persistencia.dao.mysql.MySqlTreinadorDAO;

/**
 *
 * @author User
 */
public class ListaParticipantes extends javax.swing.JFrame {

    Connection conn = null;
    List<Jogador> jogadores = new ArrayList<Jogador>();
    List<Selecao> selecoes = new ArrayList<Selecao>();
    List<Jogo> jogos = new ArrayList<Jogo>();
    List<Juiz> juizes = new ArrayList<Juiz>();
    List<Treinador> treinadores = new ArrayList<Treinador>();

    public ListaParticipantes(Connection conn) {
        this.conn = conn;
        initComponents();
        this.setVisible(true);
        this.tableJogadores();
        this.tableSelecao();
        this.tableJogos();
        this.tableJuizes();
        this.tableTreinadores();

    }

    public void tableJogadores() {

        contatoTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = contatoTable2.rowAtPoint(evt.getPoint());
                int col = contatoTable2.columnAtPoint(evt.getPoint());
                if (row >= 0) {
                    Jogador jogadorFocus = jogadores.get(row);
                    System.out.println(jogadorFocus.getNome());
                    MySqlJogadorDAO daoJogador = new MySqlJogadorDAO(conn);
                    jogadorFocus = daoJogador.buscaSelecao(jogadorFocus);
                    jogadorFocus = daoJogador.buscaPosicao(jogadorFocus);
                    new ParticipanteTela(jogadores.get(row));
                }
            }
        });

        MySqlJogadorDAO daoJogador = new MySqlJogadorDAO(conn);

        this.jogadores = daoJogador.listaTodos();
        System.out.println(jogadores.get(0).getNome());
        Object[][] jogadoresView = new Object[jogadores.size()][4];
        for (int i = 0; i < jogadores.size(); i++) {
            jogadoresView[i][0] = jogadores.get(i).getNome();
            jogadoresView[i][1] = jogadores.get(i).getData_nasc();
            jogadoresView[i][2] = jogadores.get(i).getNacionalidade();
            jogadoresView[i][3] = jogadores.get(i).getCamisa();

        }
        contatoTable2.setModel(new javax.swing.table.DefaultTableModel(
                jogadoresView,
                new String[]{
                    "Nome", "Nascimento", "Nacionalidade", "Camisa"
                }
        ));
    }

    public void tableTreinadores() {

        MySqlTreinadorDAO daoTreinador = new MySqlTreinadorDAO(conn);

        this.treinadores = daoTreinador.listaTodos();
        Object[][] jogadoresView = new Object[treinadores.size()][3];
        for (int i = 0; i < treinadores.size(); i++) {
            jogadoresView[i][0] = treinadores.get(i).getNome();
            jogadoresView[i][1] = treinadores.get(i).getData_nasc();
            jogadoresView[i][2] = treinadores.get(i).getNacionalidade();

        }
        contatoTable3.setModel(new javax.swing.table.DefaultTableModel(
                jogadoresView,
                new String[]{
                    "Nome", "Nascimento", "Nacionalidade",}
        ));

        contatoTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = contatoTable3.rowAtPoint(evt.getPoint());
                int col = contatoTable3.columnAtPoint(evt.getPoint());
                if (row >= 0) {
                    Treinador treinadorFocus = treinadores.get(row);
                    System.out.println(treinadorFocus.getNome());
                    MySqlTreinadorDAO daoTreinador = new MySqlTreinadorDAO(conn);
                    daoTreinador.buscaSelecao(treinadorFocus);
                    new ParticipanteTela(treinadores.get(row));
                }
            }
        });

    }

    public void tableSelecao() {

        MySqlSelecaoDAO daoSelecao = new MySqlSelecaoDAO(conn);

        this.selecoes = daoSelecao.listaTodos();
        System.out.println(jogadores.get(0).getNome());
        Object[][] jogadoresView = new Object[selecoes.size()][2];
        for (int i = 0; i < selecoes.size(); i++) {
            jogadoresView[i][1] = selecoes.get(i).getNome();
            jogadoresView[i][0] = selecoes.get(i).getId();

        }
        contatoTable.setModel(new javax.swing.table.DefaultTableModel(
                jogadoresView,
                new String[]{
                    "ID", "Seleção"
                }
        ));

        contatoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = contatoTable.rowAtPoint(evt.getPoint());
                int col = contatoTable.columnAtPoint(evt.getPoint());
                if (row >= 0) {
                    System.out.printf(selecoes.get(row).getNome());
                    new SelecaoTela(selecoes.get(row));
                }
            }
        });

    }

    public void tableJogos() {

        MySqlJogoDAO daoJogos = new MySqlJogoDAO(conn);

        this.jogos = daoJogos.listaTodos();
        System.out.println(jogadores.get(0).getNome());
        Object[][] jogadoresView = new Object[jogos.size()][4];
        for (int i = 0; i < jogos.size(); i++) {
            jogadoresView[i][0] = jogos.get(i).getSelecao1().getNome();
            jogadoresView[i][1] = jogos.get(i).getSelecao2().getNome();
            jogadoresView[i][2] = jogos.get(i).getResultado();
            jogadoresView[i][3] = jogos.get(i).getLocal();

        }
        contatoTable1.setModel(new javax.swing.table.DefaultTableModel(
                jogadoresView,
                new String[]{
                    "Selecao A", "Selecao B", "Resultado", "Local"
                }
        ));
          contatoTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = contatoTable1.rowAtPoint(evt.getPoint());
                int col = contatoTable1.columnAtPoint(evt.getPoint());
                if (row >= 0) {
                    
                    new JogoTela(jogos.get(row));
                }
            }
        });
        

    }

    public void tableJuizes() {

        MySqlJuizDAO daoJuizes = new MySqlJuizDAO(conn);

        this.juizes = daoJuizes.listaTodos();

        Object[][] jogadoresView = new Object[juizes.size()][4];
        for (int i = 0; i < juizes.size(); i++) {
            jogadoresView[i][0] = juizes.get(i).getNome();
            jogadoresView[i][1] = juizes.get(i).getData_nasc();
            jogadoresView[i][2] = juizes.get(i).getNacionalidade();

        }
        contatoTable4.setModel(new javax.swing.table.DefaultTableModel(
                jogadoresView,
                new String[]{
                    "Nome", "Nascimento", "Nacionalidade"
                }
        ));
        contatoTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = contatoTable4.rowAtPoint(evt.getPoint());
                int col = contatoTable4.columnAtPoint(evt.getPoint());
                if (row >= 0) {
                    System.out.printf(juizes.get(row).getNome());
                    new ParticipanteTela(juizes.get(row));
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

        mainTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contatoTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        contatoTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        contatoTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        contatoTable3 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        contatoTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

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

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mainTabbedPane.addTab("Seleções", jPanel1);

        contatoTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(contatoTable1);

        mainTabbedPane.addTab("Jogos", jScrollPane2);

        contatoTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(contatoTable2);

        mainTabbedPane.addTab("Jogadores", jScrollPane3);

        contatoTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(contatoTable3);

        mainTabbedPane.addTab("Treinadores", jScrollPane4);

        contatoTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(contatoTable4);

        mainTabbedPane.addTab("Juizes", jScrollPane5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable contatoTable;
    private javax.swing.JTable contatoTable1;
    private javax.swing.JTable contatoTable2;
    private javax.swing.JTable contatoTable3;
    private javax.swing.JTable contatoTable4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane mainTabbedPane;
    // End of variables declaration//GEN-END:variables
}
