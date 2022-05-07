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
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public class Menu extends javax.swing.JFrame {

    static Connection conn = null;
    List<Jogador> jogadores = new ArrayList<Jogador>();
    List<Selecao> selecoes = new ArrayList<Selecao>();
    List<Jogo> jogos = new ArrayList<Jogo>();
    List<Juiz> juizes = new ArrayList<Juiz>();
    List<Treinador> treinadores = new ArrayList<Treinador>();

    public Menu(Connection conn) {
        this.conn = conn;
        initComponents();
        this.setVisible(true);
        this.tableJogadores();
        this.tableSelecao();
        this.tableJogos();
        this.tableJuizes();
        this.tableTreinadores();
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh();
            }
        });
        //setLocationRelativeTo(null);

    }

    public void tableJogadores() {

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

    }

    void refresh() {

        new Menu(Menu.conn);
        dispose();
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

        jPanel2 = new javax.swing.JPanel();
        btnCentralCadastros = new javax.swing.JButton();
        mainTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contatoTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        contatoTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        contatoTable2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        contatoTable4 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        contatoTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        btnCentralCadastros.setText("Central de Cadastros");
        btnCentralCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCentralCadastrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnCentralCadastros)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCentralCadastros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

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

        mainTabbedPane.addTab("Juízes", jScrollPane5);

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

        jButton1.setText("RELOAD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCentralCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCentralCadastrosActionPerformed
        new CentralCadastros();
    }//GEN-LAST:event_btnCentralCadastrosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCentralCadastros;
    private javax.swing.JTable contatoTable;
    private javax.swing.JTable contatoTable1;
    private javax.swing.JTable contatoTable2;
    private javax.swing.JTable contatoTable3;
    private javax.swing.JTable contatoTable4;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane mainTabbedPane;
    // End of variables declaration//GEN-END:variables
}
