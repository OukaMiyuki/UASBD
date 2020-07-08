/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard.Manager.Menu;

import Controller.Jadwal.jadwalController;
import Controller.Kereta.keretaController;
import Controller.Manager.masinisController;
import Controller.Tiket.tiketController;
import Model.Jadwal;
import Model.Kereta;
import Model.Masinis;
import Model.Tiket;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Ouka
 */

public class jadwalCardMenu extends javax.swing.JPanel {
    /**
     * Creates new form jadwalCardMenu
     */
    private Jadwal jadwal;
    private jadwalController controller;
    private DefaultTableModel tbModel;
    private int pos;
    CardLayout menuTab;
    private keretaController keretacontroller;
    private masinisController masiniscontroller;
    
    private Tiket tiket;
    private tiketController tiketcontroller;
    private DefaultTableModel tbmodelTiket;
    public jadwalCardMenu() throws SQLException {
        initComponents();
        menuTab = (CardLayout) contentBodyMenuCard.getLayout();
        menuTab.show(contentBodyMenuCard, "card1");
        keretacontroller = new keretaController();
        masiniscontroller = new masinisController();
        btnInsert.setFocusPainted(false);
        btnUpdate.setFocusPainted(false);
        btnDelete.setFocusPainted(false);
        btnReset.setFocusPainted(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        controller = new jadwalController();
        tbModel = (DefaultTableModel) tbJadwal.getModel();
        JTextFieldDateEditor jadwal = (JTextFieldDateEditor) txtTanggalJadwal.getDateEditor();
        jadwal.setBackground(new Color(0,42,113));
        jadwal.setForeground(new java.awt.Color(255, 255, 255));
        jadwal.setBorder(null);
        jadwal.setEditable(false);
        AutoCompleteDecorator.decorate(txtPilih_Kereta);
        AutoCompleteDecorator.decorate(txtPilih_masinis);
        show_data_to_table();
        showList();
        tiketcontroller = new tiketController();
        txtPilihJadwal.addItemListener(new ItemChangeListener());
        txtIdkelas.setEditable(false);
        tbmodelTiket = (DefaultTableModel) tbTiket.getModel();
        show_data_to_tableTiket();
        AutoCompleteDecorator.decorate(txtPilihJadwal);
        
        
    }
    
    public void show_data_to_table() throws SQLException{
        List<Jadwal> jadArr = controller.selectAll();
        tbModel.setRowCount(0);
        txtPilihJadwal.removeAllItems();
        Object[] kolom = new Object[7];
        for (int i = 0; i < jadArr.size(); i++) {
            kolom[0] = i+1;
            kolom[1] = jadArr.get(i).getId_jadwal();
            kolom[2] = jadArr.get(i).getId_kereta();
            kolom[3] = jadArr.get(i).getId_masinis();
            kolom[4] = jadArr.get(i).getTanggal();
            kolom[5] = jadArr.get(i).getJam();
            kolom[6] = jadArr.get(i).getTujuan();
             
            tbModel.addRow(kolom);
            
            txtPilihJadwal.addItem(jadArr.get(i).getId_jadwal());
        }
    }
    
    public void show_data_to_tableTiket() throws SQLException{
        List<Tiket> tiArr = tiketcontroller.selectAll();
        tbmodelTiket.setRowCount(0);
        Object[] kolom = new Object[6];
        for (int i = 0; i < tiArr.size(); i++) {
            kolom[0] = i+1;
            kolom[1] = tiArr.get(i).getId_tiket();
            kolom[2] = tiArr.get(i).getId_jadwal();
            kolom[3] = tiArr.get(i).getId_kelas();
            kolom[4] = tiArr.get(i).getHarga();
            kolom[5] = tiArr.get(i).getStok();
             
            tbmodelTiket.addRow(kolom);
        }
    }
    
    public void showList() throws SQLException{
        List<Kereta> keArr = keretacontroller.selectAll();
        List<Masinis> maArr = masiniscontroller.selectAllMasinis();
        txtPilih_Kereta.removeAllItems();
        txtPilih_masinis.removeAllItems();
        for (int i = 0; i < keArr.size(); i++) {
            txtPilih_Kereta.addItem(keArr.get(i).getId_kereta());
        }
        
        for (int i = 0; i < maArr.size(); i++) {
            txtPilih_masinis.addItem(maArr.get(i).getId_masinis());
        }
    }
    
    class ItemChangeListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                String item = event.getItem().toString();
                 try {
                    String kelas = controller.pilihJadwal(item);
                    txtIdkelas.setText(kelas);
                } catch (SQLException ex) {
                    Logger.getLogger(jadwalCardMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        headerMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bodyMenuTab = new javax.swing.JPanel();
        btnMenuKereta = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnMenuKelas = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        contentBodyMenuCard = new javax.swing.JPanel();
        contentCardTiket = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTiket = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtIDtiket = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtStoktiket = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtPilihJadwal = new javax.swing.JComboBox<>();
        jSeparator11 = new javax.swing.JSeparator();
        txtIdkelas = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnPrev = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnNext = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnLast = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        contentCardJadwal = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbJadwal = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtId_Jadwal = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        txtKeterangankelas = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnInsertJadwal = new javax.swing.JButton();
        btnUpdateJadwal = new javax.swing.JButton();
        btnDeleteJadwal = new javax.swing.JButton();
        btnResetJadwal = new javax.swing.JButton();
        txtPilih_masinis = new javax.swing.JComboBox<>();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        txtTanggalJadwal = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        txtWaktuJadwal = new javax.swing.JSpinner(sm);
        txtTujuan = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        txtPilih_Kereta = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        btnFirstJadwal = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        btnPrevJadwal = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnNextJadwal = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnLastJadwal = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 30, 84));
        setPreferredSize(new java.awt.Dimension(1150, 660));

        headerMenu.setBackground(new java.awt.Color(227, 237, 240));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Management Kereta Api Sederhana");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Daftar Jadwal");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Home>Daftar Jadwal");

        javax.swing.GroupLayout headerMenuLayout = new javax.swing.GroupLayout(headerMenu);
        headerMenu.setLayout(headerMenuLayout);
        headerMenuLayout.setHorizontalGroup(
            headerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerMenuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(headerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(843, Short.MAX_VALUE))
        );
        headerMenuLayout.setVerticalGroup(
            headerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerMenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        bodyMenuTab.setBackground(new java.awt.Color(0, 42, 113));
        bodyMenuTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenuKereta.setBackground(new java.awt.Color(0, 42, 113));
        btnMenuKereta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuKereta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuKeretaMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tiket");

        javax.swing.GroupLayout btnMenuKeretaLayout = new javax.swing.GroupLayout(btnMenuKereta);
        btnMenuKereta.setLayout(btnMenuKeretaLayout);
        btnMenuKeretaLayout.setHorizontalGroup(
            btnMenuKeretaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnMenuKeretaLayout.setVerticalGroup(
            btnMenuKeretaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bodyMenuTab.add(btnMenuKereta, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, -1, -1));

        btnMenuKelas.setBackground(new java.awt.Color(0, 42, 113));
        btnMenuKelas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuKelasMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Jadwal");

        javax.swing.GroupLayout btnMenuKelasLayout = new javax.swing.GroupLayout(btnMenuKelas);
        btnMenuKelas.setLayout(btnMenuKelasLayout);
        btnMenuKelasLayout.setHorizontalGroup(
            btnMenuKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnMenuKelasLayout.setVerticalGroup(
            btnMenuKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bodyMenuTab.add(btnMenuKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, -1, -1));

        contentBodyMenuCard.setBackground(new java.awt.Color(0, 30, 84));
        contentBodyMenuCard.setLayout(new java.awt.CardLayout());

        contentCardTiket.setBackground(new java.awt.Color(0, 30, 84));

        jPanel5.setBackground(new java.awt.Color(0, 42, 113));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbTiket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "ID Tiket", "ID Jadwal", "ID Kelas", "Harga", "Stok Tiket"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTiketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTiket);
        if (tbTiket.getColumnModel().getColumnCount() > 0) {
            tbTiket.getColumnModel().getColumn(0).setResizable(false);
            tbTiket.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbTiket.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbTiket.getColumnModel().getColumn(2).setPreferredWidth(150);
            tbTiket.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbTiket.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbTiket.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 340));

        jPanel6.setBackground(new java.awt.Color(0, 42, 113));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(0, 42, 113));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID TIket");

        txtIDtiket.setBackground(new java.awt.Color(0, 42, 113));
        txtIDtiket.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtIDtiket.setForeground(new java.awt.Color(255, 255, 255));
        txtIDtiket.setBorder(null);
        txtIDtiket.setCaretColor(new java.awt.Color(255, 0, 0));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        txtStoktiket.setBackground(new java.awt.Color(0, 42, 113));
        txtStoktiket.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtStoktiket.setForeground(new java.awt.Color(255, 255, 255));
        txtStoktiket.setBorder(null);
        txtStoktiket.setCaretColor(new java.awt.Color(255, 0, 0));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Stok Tiket");

        btnInsert.setBackground(new java.awt.Color(0, 74, 163));
        btnInsert.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setText("Insert");
        btnInsert.setBorder(null);
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnInsertMouseReleased(evt);
            }
        });
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 74, 163));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(null);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUpdateMouseReleased(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 74, 163));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(null);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeleteMouseReleased(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 74, 163));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.setBorder(null);
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnResetMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnResetMouseReleased(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ID Jadwal");

        txtPilihJadwal.setBackground(new java.awt.Color(0, 42, 113));
        txtPilihJadwal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPilihJadwal.setForeground(new java.awt.Color(255, 255, 255));
        txtPilihJadwal.setBorder(null);
        txtPilihJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPilihJadwalActionPerformed(evt);
            }
        });

        txtIdkelas.setBackground(new java.awt.Color(0, 42, 113));
        txtIdkelas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtIdkelas.setForeground(new java.awt.Color(255, 255, 255));
        txtIdkelas.setBorder(null);
        txtIdkelas.setCaretColor(new java.awt.Color(255, 0, 0));

        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ID kelas");

        txtHarga.setBackground(new java.awt.Color(0, 42, 113));
        txtHarga.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtHarga.setForeground(new java.awt.Color(255, 255, 255));
        txtHarga.setBorder(null);
        txtHarga.setCaretColor(new java.awt.Color(255, 0, 0));

        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Harga");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStoktiket, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jSeparator7)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtIDtiket)))
                            .addComponent(txtPilihJadwal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdkelas)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHarga)
                            .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtIDtiket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPilihJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtIdkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtStoktiket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 280, 390));

        jPanel7.setBackground(new java.awt.Color(0, 42, 113));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 35));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFirst.setBackground(new java.awt.Color(0, 74, 163));
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFirstMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFirstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFirstMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFirstMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFirstMouseReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("First");

        javax.swing.GroupLayout btnFirstLayout = new javax.swing.GroupLayout(btnFirst);
        btnFirst.setLayout(btnFirstLayout);
        btnFirstLayout.setHorizontalGroup(
            btnFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnFirstLayout.setVerticalGroup(
            btnFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel7.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        btnPrev.setBackground(new java.awt.Color(0, 74, 163));
        btnPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPrevMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPrevMouseReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Prev");

        javax.swing.GroupLayout btnPrevLayout = new javax.swing.GroupLayout(btnPrev);
        btnPrev.setLayout(btnPrevLayout);
        btnPrevLayout.setHorizontalGroup(
            btnPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnPrevLayout.setVerticalGroup(
            btnPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel7.add(btnPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        btnNext.setBackground(new java.awt.Color(0, 74, 163));
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNextMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnNextMouseReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Next");

        javax.swing.GroupLayout btnNextLayout = new javax.swing.GroupLayout(btnNext);
        btnNext.setLayout(btnNextLayout);
        btnNextLayout.setHorizontalGroup(
            btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnNextLayout.setVerticalGroup(
            btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel7.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        btnLast.setBackground(new java.awt.Color(0, 74, 163));
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLastMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLastMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnLastMouseReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Last");

        javax.swing.GroupLayout btnLastLayout = new javax.swing.GroupLayout(btnLast);
        btnLast.setLayout(btnLastLayout);
        btnLastLayout.setHorizontalGroup(
            btnLastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnLastLayout.setVerticalGroup(
            btnLastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel7.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, -1, -1));

        javax.swing.GroupLayout contentCardTiketLayout = new javax.swing.GroupLayout(contentCardTiket);
        contentCardTiket.setLayout(contentCardTiketLayout);
        contentCardTiketLayout.setHorizontalGroup(
            contentCardTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentCardTiketLayout.createSequentialGroup()
                .addGroup(contentCardTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        contentCardTiketLayout.setVerticalGroup(
            contentCardTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentCardTiketLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        contentBodyMenuCard.add(contentCardTiket, "card1");

        contentCardJadwal.setBackground(new java.awt.Color(0, 30, 84));

        jPanel8.setBackground(new java.awt.Color(0, 42, 113));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "ID Jadwal", "ID Kereta", "ID Masinis", "Tanggal", "Waktu", "Tujuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbJadwalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbJadwal);
        if (tbJadwal.getColumnModel().getColumnCount() > 0) {
            tbJadwal.getColumnModel().getColumn(0).setResizable(false);
            tbJadwal.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbJadwal.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbJadwal.getColumnModel().getColumn(2).setPreferredWidth(150);
            tbJadwal.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbJadwal.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbJadwal.getColumnModel().getColumn(5).setPreferredWidth(150);
            tbJadwal.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 340));

        jPanel9.setBackground(new java.awt.Color(0, 42, 113));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(0, 42, 113));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ID Jadwal");

        txtId_Jadwal.setBackground(new java.awt.Color(0, 42, 113));
        txtId_Jadwal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtId_Jadwal.setForeground(new java.awt.Color(255, 255, 255));
        txtId_Jadwal.setBorder(null);
        txtId_Jadwal.setCaretColor(new java.awt.Color(255, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ID Kereta");

        txtKeterangankelas.setBackground(new java.awt.Color(0, 42, 113));
        txtKeterangankelas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtKeterangankelas.setForeground(new java.awt.Color(255, 255, 255));
        txtKeterangankelas.setBorder(null);
        txtKeterangankelas.setCaretColor(new java.awt.Color(255, 0, 0));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ID Masinis");

        btnInsertJadwal.setBackground(new java.awt.Color(0, 74, 163));
        btnInsertJadwal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsertJadwal.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertJadwal.setText("Insert");
        btnInsertJadwal.setBorder(null);
        btnInsertJadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertJadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertJadwalMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnInsertJadwalMouseReleased(evt);
            }
        });
        btnInsertJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertJadwalActionPerformed(evt);
            }
        });

        btnUpdateJadwal.setBackground(new java.awt.Color(0, 74, 163));
        btnUpdateJadwal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateJadwal.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateJadwal.setText("Update");
        btnUpdateJadwal.setBorder(null);
        btnUpdateJadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateJadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateJadwalMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUpdateJadwalMouseReleased(evt);
            }
        });
        btnUpdateJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateJadwalActionPerformed(evt);
            }
        });

        btnDeleteJadwal.setBackground(new java.awt.Color(0, 74, 163));
        btnDeleteJadwal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteJadwal.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteJadwal.setText("Delete");
        btnDeleteJadwal.setBorder(null);
        btnDeleteJadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteJadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteJadwalMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeleteJadwalMouseReleased(evt);
            }
        });
        btnDeleteJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJadwalActionPerformed(evt);
            }
        });

        btnResetJadwal.setBackground(new java.awt.Color(0, 74, 163));
        btnResetJadwal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnResetJadwal.setForeground(new java.awt.Color(255, 255, 255));
        btnResetJadwal.setText("Reset");
        btnResetJadwal.setBorder(null);
        btnResetJadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnResetJadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnResetJadwalMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnResetJadwalMouseReleased(evt);
            }
        });
        btnResetJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetJadwalActionPerformed(evt);
            }
        });

        txtPilih_masinis.setBackground(new java.awt.Color(0, 42, 113));
        txtPilih_masinis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Tanggal");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Waktu");

        JSpinner.DateEditor de = new JSpinner.DateEditor(txtWaktuJadwal, "HH:mm:ss");
        txtWaktuJadwal.setEditor(de);
        txtWaktuJadwal.setBorder(null);

        txtTujuan.setBackground(new java.awt.Color(0, 42, 113));
        txtTujuan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTujuan.setForeground(new java.awt.Color(255, 255, 255));
        txtTujuan.setBorder(null);
        txtTujuan.setCaretColor(new java.awt.Color(255, 0, 0));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tujuan");

        txtPilih_Kereta.setBackground(new java.awt.Color(0, 74, 163));
        txtPilih_Kereta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPilih_Kereta.setBorder(null);
        txtPilih_Kereta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPilih_Kereta.setFocusable(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(btnInsertJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetJadwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTanggalJadwal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtId_Jadwal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPilih_masinis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWaktuJadwal)
                            .addComponent(jSeparator10)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPilih_Kereta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKeterangankelas, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtId_Jadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtPilih_Kereta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtKeterangankelas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPilih_masinis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(txtTanggalJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtWaktuJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel9.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 280, 390));

        jPanel10.setBackground(new java.awt.Color(0, 42, 113));
        jPanel10.setPreferredSize(new java.awt.Dimension(0, 35));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFirstJadwal.setBackground(new java.awt.Color(0, 74, 163));
        btnFirstJadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirstJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFirstJadwalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFirstJadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFirstJadwalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFirstJadwalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFirstJadwalMouseReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("First");

        javax.swing.GroupLayout btnFirstJadwalLayout = new javax.swing.GroupLayout(btnFirstJadwal);
        btnFirstJadwal.setLayout(btnFirstJadwalLayout);
        btnFirstJadwalLayout.setHorizontalGroup(
            btnFirstJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnFirstJadwalLayout.setVerticalGroup(
            btnFirstJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel10.add(btnFirstJadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        btnPrevJadwal.setBackground(new java.awt.Color(0, 74, 163));
        btnPrevJadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrevJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevJadwalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevJadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevJadwalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPrevJadwalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPrevJadwalMouseReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Prev");

        javax.swing.GroupLayout btnPrevJadwalLayout = new javax.swing.GroupLayout(btnPrevJadwal);
        btnPrevJadwal.setLayout(btnPrevJadwalLayout);
        btnPrevJadwalLayout.setHorizontalGroup(
            btnPrevJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnPrevJadwalLayout.setVerticalGroup(
            btnPrevJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel10.add(btnPrevJadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        btnNextJadwal.setBackground(new java.awt.Color(0, 74, 163));
        btnNextJadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNextJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextJadwalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextJadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextJadwalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNextJadwalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnNextJadwalMouseReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Next");

        javax.swing.GroupLayout btnNextJadwalLayout = new javax.swing.GroupLayout(btnNextJadwal);
        btnNextJadwal.setLayout(btnNextJadwalLayout);
        btnNextJadwalLayout.setHorizontalGroup(
            btnNextJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnNextJadwalLayout.setVerticalGroup(
            btnNextJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel10.add(btnNextJadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        btnLastJadwal.setBackground(new java.awt.Color(0, 74, 163));
        btnLastJadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLastJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLastJadwalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastJadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastJadwalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLastJadwalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnLastJadwalMouseReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Last");

        javax.swing.GroupLayout btnLastJadwalLayout = new javax.swing.GroupLayout(btnLastJadwal);
        btnLastJadwal.setLayout(btnLastJadwalLayout);
        btnLastJadwalLayout.setHorizontalGroup(
            btnLastJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnLastJadwalLayout.setVerticalGroup(
            btnLastJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel10.add(btnLastJadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, -1, -1));

        javax.swing.GroupLayout contentCardJadwalLayout = new javax.swing.GroupLayout(contentCardJadwal);
        contentCardJadwal.setLayout(contentCardJadwalLayout);
        contentCardJadwalLayout.setHorizontalGroup(
            contentCardJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentCardJadwalLayout.createSequentialGroup()
                .addGroup(contentCardJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        contentCardJadwalLayout.setVerticalGroup(
            contentCardJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentCardJadwalLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        contentBodyMenuCard.add(contentCardJadwal, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bodyMenuTab, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
                    .addComponent(contentBodyMenuCard, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(bodyMenuTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(contentBodyMenuCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFirstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseEntered
        btnFirst.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnFirstMouseEntered

    private void btnFirstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseExited
        btnFirst.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnFirstMouseExited

    private void btnFirstMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMousePressed
        btnFirst.setBackground(new Color(6, 58, 120));// TODO add your handling code here:
    }//GEN-LAST:event_btnFirstMousePressed

    private void btnFirstMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseReleased
        btnFirst.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnFirstMouseReleased

    private void btnPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseEntered
        btnPrev.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnPrevMouseEntered

    private void btnPrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseExited
        btnPrev.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnPrevMouseExited

    private void btnPrevMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMousePressed
        btnPrev.setBackground(new Color(6, 58, 120));
    }//GEN-LAST:event_btnPrevMousePressed

    private void btnPrevMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseReleased
        btnPrev.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnPrevMouseReleased

    private void btnNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseEntered
        btnNext.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnNextMouseEntered

    private void btnNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseExited
        btnNext.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnNextMouseExited

    private void btnNextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMousePressed
        btnNext.setBackground(new Color(6, 58, 120));
    }//GEN-LAST:event_btnNextMousePressed

    private void btnNextMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseReleased
        btnNext.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnNextMouseReleased

    private void btnLastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseEntered
        btnLast.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnLastMouseEntered

    private void btnLastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseExited
        btnLast.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnLastMouseExited

    private void btnLastMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMousePressed
        btnLast.setBackground(new Color(6, 58, 120));
    }//GEN-LAST:event_btnLastMousePressed

    private void btnLastMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseReleased
        btnLast.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnLastMouseReleased

    private void btnMenuKeretaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuKeretaMouseClicked
        btnMenuKereta.setBackground(new Color(0,74,163));
        btnMenuKelas.setBackground(new Color(0,42,113));
        menuTab.show(contentBodyMenuCard, "card1");
        clearFields();
    }//GEN-LAST:event_btnMenuKeretaMouseClicked

    private void btnMenuKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuKelasMouseClicked
        btnMenuKereta.setBackground(new Color(0,42,113));
        btnMenuKelas.setBackground(new Color(0,74,163));
        menuTab.show(contentBodyMenuCard, "card2");
        clearFields();
    }//GEN-LAST:event_btnMenuKelasMouseClicked

    private void btnFirstJadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstJadwalMouseEntered
        btnFirstJadwal.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnFirstJadwalMouseEntered

    private void btnFirstJadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstJadwalMouseExited
        btnFirstJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnFirstJadwalMouseExited

    private void btnFirstJadwalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstJadwalMousePressed
        btnFirstJadwal.setBackground(new Color(6, 58, 120));
    }//GEN-LAST:event_btnFirstJadwalMousePressed

    private void btnFirstJadwalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstJadwalMouseReleased
        btnFirstJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnFirstJadwalMouseReleased

    private void btnPrevJadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevJadwalMouseEntered
        btnPrevJadwal.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnPrevJadwalMouseEntered

    private void btnPrevJadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevJadwalMouseExited
        btnPrevJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnPrevJadwalMouseExited

    private void btnPrevJadwalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevJadwalMousePressed
        btnPrevJadwal.setBackground(new Color(6, 58, 120));
    }//GEN-LAST:event_btnPrevJadwalMousePressed

    private void btnPrevJadwalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevJadwalMouseReleased
        btnPrevJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnPrevJadwalMouseReleased

    private void btnNextJadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextJadwalMouseEntered
        btnNextJadwal.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnNextJadwalMouseEntered

    private void btnNextJadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextJadwalMouseExited
        btnNextJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnNextJadwalMouseExited

    private void btnNextJadwalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextJadwalMousePressed
        btnNextJadwal.setBackground(new Color(6, 58, 120));
    }//GEN-LAST:event_btnNextJadwalMousePressed

    private void btnNextJadwalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextJadwalMouseReleased
        btnNextJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnNextJadwalMouseReleased

    private void btnLastJadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastJadwalMouseEntered
        btnLastJadwal.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnLastJadwalMouseEntered

    private void btnLastJadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastJadwalMouseExited
        btnLastJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnLastJadwalMouseExited

    private void btnLastJadwalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastJadwalMousePressed
        btnLastJadwal.setBackground(new Color(6, 58, 120));
    }//GEN-LAST:event_btnLastJadwalMousePressed

    private void btnLastJadwalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastJadwalMouseReleased
        btnLastJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnLastJadwalMouseReleased

    private void btnInsertJadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertJadwalMouseEntered
        btnInsertJadwal.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnInsertJadwalMouseEntered

    private void btnInsertJadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertJadwalMouseExited
        btnInsertJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnInsertJadwalMouseExited

    private void btnInsertJadwalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertJadwalMouseReleased
        btnInsertJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnInsertJadwalMouseReleased

    private void btnUpdateJadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateJadwalMouseEntered
        btnUpdateJadwal.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnUpdateJadwalMouseEntered

    private void btnUpdateJadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateJadwalMouseExited
        btnUpdateJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnUpdateJadwalMouseExited

    private void btnUpdateJadwalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateJadwalMouseReleased
        btnUpdateJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnUpdateJadwalMouseReleased

    private void btnDeleteJadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteJadwalMouseEntered
        btnDeleteJadwal.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnDeleteJadwalMouseEntered

    private void btnDeleteJadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteJadwalMouseExited
        btnDeleteJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnDeleteJadwalMouseExited

    private void btnDeleteJadwalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteJadwalMouseReleased
        btnDeleteJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnDeleteJadwalMouseReleased

    private void btnResetJadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetJadwalMouseEntered
        btnResetJadwal.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnResetJadwalMouseEntered

    private void btnResetJadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetJadwalMouseExited
        btnResetJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnResetJadwalMouseExited

    private void btnResetJadwalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetJadwalMouseReleased
        btnResetJadwal.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnResetJadwalMouseReleased

    private void tbJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbJadwalMouseClicked
        if(tbJadwal.getSelectionModel().isSelectionEmpty()){
            System.out.println("null");
        } else{
            btnUpdateJadwal.setEnabled(true);
            btnDeleteJadwal.setEnabled(true);
            btnInsertJadwal.setEnabled(false);
            txtId_Jadwal.setEditable(false);
            int index = tbJadwal.getSelectedRow();
            show_item_in_form_jadwal(index);
        }
    }//GEN-LAST:event_tbJadwalMouseClicked

    private void btnInsertJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertJadwalActionPerformed
        if(cekEmpty()){
            JOptionPane.showMessageDialog(this, "One or more Fields are empty!");
        } else{
            String time = null;
            jadwal = new Jadwal();
            jadwal.setId_jadwal(txtId_Jadwal.getText());
            jadwal.setId_kereta(txtPilih_Kereta.getSelectedItem().toString());
            jadwal.setId_masinis(txtPilih_masinis.getSelectedItem().toString());
            SimpleDateFormat tgl_jadwal = new SimpleDateFormat("dd-MM-yyyy");
            String tanggal_jadwal = tgl_jadwal.format(txtTanggalJadwal.getDate());
            jadwal.setTanggal(tanggal_jadwal);
            Object value = txtWaktuJadwal.getValue();
            if (value instanceof Date) {
                Date date = (Date)value;
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                time = format.format(date);
            }
            jadwal.setJam(time);
            jadwal.setTujuan(txtTujuan.getText());
            try {
                controller.insertRecord(jadwal);
                show_data_to_table();
                clearFields();
            } catch (SQLException ex) {
                Logger.getLogger(petugasCardMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnInsertJadwalActionPerformed

    private void btnUpdateJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateJadwalActionPerformed
        if(cekEmpty()){
            JOptionPane.showMessageDialog(this, "One or more Fields are empty!");
        } else{
            String time = null;
            jadwal = new Jadwal();
            jadwal.setId_jadwal(txtId_Jadwal.getText());
            jadwal.setId_kereta(txtPilih_Kereta.getSelectedItem().toString());
            jadwal.setId_masinis(txtPilih_masinis.getSelectedItem().toString());
            SimpleDateFormat tgl_jadwal = new SimpleDateFormat("dd-MM-yyyy");
            String tanggal_jadwal = tgl_jadwal.format(txtTanggalJadwal.getDate());
            jadwal.setTanggal(tanggal_jadwal);
            Object value = txtWaktuJadwal.getValue();
            if (value instanceof Date) {
                Date date = (Date)value;
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                time = format.format(date);
            }
            jadwal.setJam(time);
            jadwal.setTujuan(txtTujuan.getText());
            try {
                controller.updateRecord(jadwal);
                show_data_to_table();
                clearFields();
            } catch (SQLException ex) {
                Logger.getLogger(petugasCardMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateJadwalActionPerformed

    private void btnDeleteJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJadwalActionPerformed
        int result = JOptionPane.showConfirmDialog(null, 
            "Hapus data masinis "+ txtId_Jadwal.getText() +"?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    try {
                        controller.deleteRecord(txtId_Jadwal.getText());
                        show_data_to_table();
                        clearFields();
                    } catch (SQLException ex) {
                        Logger.getLogger(petugasCardMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else{
                    System.out.println("Abort!");
                }
    }//GEN-LAST:event_btnDeleteJadwalActionPerformed

    private void btnResetJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetJadwalActionPerformed
        clearFields();
    }//GEN-LAST:event_btnResetJadwalActionPerformed

    private void btnFirstJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstJadwalMouseClicked
        pos = 0;
        show_item_in_form_jadwal(pos);
        tbJadwal.setRowSelectionInterval(pos, pos);
        txtId_Jadwal.setEditable(false);
        btnUpdateJadwal.setEnabled(true);
        btnDeleteJadwal.setEnabled(true);
        btnInsertJadwal.setEnabled(false);
    }//GEN-LAST:event_btnFirstJadwalMouseClicked

    private void btnPrevJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevJadwalMouseClicked
        if(tbJadwal.getSelectionModel().isSelectionEmpty()){
            tbJadwal.setRowSelectionInterval(0, 0);
        } else{
            pos = tbJadwal.getSelectedRow();
            pos--;
            if(pos < 0){
                pos = 0;
            }
            tbJadwal.setRowSelectionInterval(pos, pos);
        }
        show_item_in_form_jadwal(pos);
        tbJadwal.setRowSelectionInterval(pos, pos);
        txtIDtiket.setEditable(false);
        txtId_Jadwal.setEditable(false);
        btnUpdateJadwal.setEnabled(true);
        btnDeleteJadwal.setEnabled(true);
        btnInsertJadwal.setEnabled(false);
    }//GEN-LAST:event_btnPrevJadwalMouseClicked

    private void btnNextJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextJadwalMouseClicked
        if(tbJadwal.getSelectionModel().isSelectionEmpty()){
            tbJadwal.setRowSelectionInterval(0, 0);
        } else{
            pos = tbJadwal.getSelectedRow();
            pos++;
            if(pos >= tbJadwal.getRowCount()){
                pos = tbJadwal.getRowCount()-1;
            }
            tbJadwal.setRowSelectionInterval(pos, pos);
        }
        show_item_in_form_jadwal(pos);
        tbJadwal.setRowSelectionInterval(pos, pos);
        txtId_Jadwal.setEditable(false);
        btnUpdateJadwal.setEnabled(true);
        btnDeleteJadwal.setEnabled(true);
        btnInsertJadwal.setEnabled(false);
    }//GEN-LAST:event_btnNextJadwalMouseClicked

    private void btnLastJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastJadwalMouseClicked
        pos = tbJadwal.getRowCount()-1;
        tbJadwal.setRowSelectionInterval(pos, pos);
        show_item_in_form_jadwal(pos);
        txtId_Jadwal.setEditable(false);
        btnUpdateJadwal.setEnabled(true);
        btnDeleteJadwal.setEnabled(true);
        btnInsertJadwal.setEnabled(false);
    }//GEN-LAST:event_btnLastJadwalMouseClicked

    private void tbTiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTiketMouseClicked
        if(tbTiket.getSelectionModel().isSelectionEmpty()){
            System.out.println("null");
        } else{
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnInsert.setEnabled(false);
            txtIDtiket.setEditable(false);
            int index = tbTiket.getSelectedRow();
            show_item_in_form_tiket(index);
        }
    }//GEN-LAST:event_tbTiketMouseClicked

    private void btnFirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseClicked
        pos = 0;
        show_item_in_form_tiket(pos);
        tbTiket.setRowSelectionInterval(pos, pos);
        txtIDtiket.setEditable(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnInsert.setEnabled(false);
    }//GEN-LAST:event_btnFirstMouseClicked

    private void btnPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseClicked
        if(tbTiket.getSelectionModel().isSelectionEmpty()){
            tbTiket.setRowSelectionInterval(0, 0);
        } else{
            pos = tbTiket.getSelectedRow();
            pos--;
            if(pos < 0){
                pos = 0;
            }
            tbTiket.setRowSelectionInterval(pos, pos);
        }
        show_item_in_form_tiket(pos);
        tbTiket.setRowSelectionInterval(pos, pos);
        txtIDtiket.setEditable(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnInsert.setEnabled(false);
    }//GEN-LAST:event_btnPrevMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        if(tbTiket.getSelectionModel().isSelectionEmpty()){
            tbTiket.setRowSelectionInterval(0, 0);
        } else{
            pos = tbTiket.getSelectedRow();
            pos++;
            if(pos >= tbTiket.getRowCount()){
                pos = tbTiket.getRowCount()-1;
            }
            tbTiket.setRowSelectionInterval(pos, pos);
        }
        show_item_in_form_tiket(pos);
        tbTiket.setRowSelectionInterval(pos, pos);
        txtIDtiket.setEditable(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnInsert.setEnabled(false);
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnLastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseClicked
        pos = tbTiket.getRowCount()-1;
        tbTiket.setRowSelectionInterval(pos, pos);
        show_item_in_form_tiket(pos);
        txtIDtiket.setEditable(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnInsert.setEnabled(false);
    }//GEN-LAST:event_btnLastMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearFields();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnResetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseReleased
        btnReset.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnResetMouseReleased

    private void btnResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseExited
        btnReset.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnResetMouseExited

    private void btnResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseEntered
        btnReset.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnResetMouseEntered

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int result = JOptionPane.showConfirmDialog(null, 
            "Hapus data masinis "+ txtIDtiket.getText() +"?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    try {
                        tiketcontroller.deleteRecord(txtIDtiket.getText());
                        show_data_to_tableTiket();
                        clearFields();
                    } catch (SQLException ex) {
                        Logger.getLogger(petugasCardMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else{
                    System.out.println("Abort!");
                }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDeleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseReleased
        btnDelete.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnDeleteMouseReleased

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        btnDelete.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnDeleteMouseExited

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        btnDelete.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(cekEmptyTiket()){
            JOptionPane.showMessageDialog(this, "One or more Fields are empty!");
        } else{
            tiket = new Tiket();
            tiket.setId_tiket(txtIDtiket.getText());
            tiket.setId_jadwal(txtPilihJadwal.getSelectedItem().toString());
            tiket.setId_kelas(txtIdkelas.getText());
            tiket.setHarga(Integer.parseInt(txtHarga.getText()));
            tiket.setStok(Integer.parseInt(txtStoktiket.getText()));
            try {
                tiketcontroller.updateRecord(tiket);
                show_data_to_tableTiket();
                clearFields();
            } catch (SQLException ex) {
                Logger.getLogger(petugasCardMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseReleased
        btnDelete.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnUpdateMouseReleased

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        btnUpdate.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        btnUpdate.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if(cekEmptyTiket()){
            JOptionPane.showMessageDialog(this, "One or more Fields are empty!");
        } else{
            tiket = new Tiket();
            tiket.setId_tiket(txtIDtiket.getText());
            tiket.setId_jadwal(txtPilihJadwal.getSelectedItem().toString());
            tiket.setId_kelas(txtIdkelas.getText());
            tiket.setHarga(Integer.parseInt(txtHarga.getText()));
            tiket.setStok(Integer.parseInt(txtStoktiket.getText()));
            try {
                tiketcontroller.insertRecord(tiket);
                show_data_to_tableTiket();
                clearFields();
            } catch (SQLException ex) {
                Logger.getLogger(petugasCardMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnInsertMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseReleased
        btnInsert.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnInsertMouseReleased

    private void btnInsertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseExited
        btnInsert.setBackground(new Color(0,74,163));
    }//GEN-LAST:event_btnInsertMouseExited

    private void btnInsertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseEntered
        btnInsert.setBackground(new Color(47, 71, 194));
    }//GEN-LAST:event_btnInsertMouseEntered

    private void txtPilihJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPilihJadwalActionPerformed

    }//GEN-LAST:event_txtPilihJadwalActionPerformed
    
    private void show_item_in_form_jadwal(int index){
        txtId_Jadwal.setText(tbJadwal.getValueAt(index, 1).toString());
        String kereta = tbJadwal.getValueAt(index, 2).toString();
        int itemsKereta = txtPilih_Kereta.getItemCount();
        for(int i=0;i<itemsKereta;i++){
            if(kereta.trim().equals(txtPilih_Kereta.getItemAt(i))){
                txtPilih_Kereta.setSelectedIndex(i);
            }
        }
        String masinis = tbJadwal.getValueAt(index, 3).toString();
        int itemsMasinis = txtPilih_masinis.getItemCount();
        for(int i=0;i<itemsMasinis;i++){
            if(masinis.trim().equals(txtPilih_masinis.getItemAt(i))){
                txtPilih_masinis.setSelectedIndex(i);
            }
        }
        try{
            java.util.Date jadwal_tanggal = new SimpleDateFormat("dd-MM-yyyy").parse(tbJadwal.getValueAt(index, 4).toString());
            txtTanggalJadwal.setDate(jadwal_tanggal);
        } catch(ParseException ex){
            System.out.println("Parse Failed for date "+ ex);
        }
        try{
            java.util.Date jam_tanggal = new SimpleDateFormat("HH:mm:ss").parse(tbJadwal.getValueAt(index, 5).toString());
            txtWaktuJadwal.setValue(jam_tanggal);
        } catch(ParseException ex){
            System.out.println("Parse Failed for date "+ ex);
        }
        txtTujuan.setText(tbJadwal.getValueAt(index, 6).toString());
    }
    
    private void show_item_in_form_tiket(int index){
        txtIDtiket.setText(tbTiket.getValueAt(index, 1).toString());
        String idJadwal = tbTiket.getValueAt(index, 2).toString();
        int jadwalList = txtPilihJadwal.getItemCount();
        for(int i=0;i<jadwalList;i++){
            if(idJadwal.trim().equals(txtPilihJadwal.getItemAt(i))){
                txtPilihJadwal.setSelectedIndex(i);
            }
        }
        txtIdkelas.setText(tbTiket.getValueAt(index, 3).toString());
        txtHarga.setText(tbTiket.getValueAt(index, 4).toString());
        txtStoktiket.setText(tbTiket.getValueAt(index, 5).toString());
    }
    
    private boolean cekEmpty(){
        Date date = txtTanggalJadwal.getDate();
        if(txtId_Jadwal.getText().isEmpty() || txtTujuan.getText().isEmpty() || date == null){
            return true;
        } else{
            return false;
        }
    }
    
    private boolean cekEmptyTiket(){
        if(txtIDtiket.getText().isEmpty() || txtIdkelas.getText().isEmpty() || txtHarga.getText().isEmpty() || txtStoktiket.getText().isEmpty()){
            return true;
        } else{
            return false;
        }
    }
    
    private void clearFields(){
        btnInsertJadwal.setEnabled(true);
        txtId_Jadwal.setText("");
        txtId_Jadwal.setEditable(true);
        txtPilih_Kereta.setSelectedIndex(0);
        txtPilih_masinis.setSelectedIndex(0);
        txtTanggalJadwal.setDate(null);
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        txtWaktuJadwal.setModel(sm);
        JSpinner.DateEditor de = new JSpinner.DateEditor(txtWaktuJadwal, "HH:mm:ss");
        txtWaktuJadwal.setEditor(de);
        txtTujuan.setText("");
        btnUpdateJadwal.setEnabled(false);
        btnDeleteJadwal.setEnabled(false);
        tbJadwal.getSelectionModel().clearSelection();
        txtPilihJadwal.setSelectedIndex(0);
        txtIdkelas.setText("");
        txtIDtiket.setText("");
        txtIDtiket.setEditable(true);
        txtHarga.setText("");
        txtStoktiket.setText("");
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnInsert.setEnabled(true);
        tbTiket.getSelectionModel().clearSelection();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyMenuTab;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteJadwal;
    private javax.swing.JPanel btnFirst;
    private javax.swing.JPanel btnFirstJadwal;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnInsertJadwal;
    private javax.swing.JPanel btnLast;
    private javax.swing.JPanel btnLastJadwal;
    private javax.swing.JPanel btnMenuKelas;
    private javax.swing.JPanel btnMenuKereta;
    private javax.swing.JPanel btnNext;
    private javax.swing.JPanel btnNextJadwal;
    private javax.swing.JPanel btnPrev;
    private javax.swing.JPanel btnPrevJadwal;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetJadwal;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateJadwal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel contentBodyMenuCard;
    private javax.swing.JPanel contentCardJadwal;
    private javax.swing.JPanel contentCardTiket;
    private javax.swing.JPanel headerMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable tbJadwal;
    private javax.swing.JTable tbTiket;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIDtiket;
    private javax.swing.JTextField txtId_Jadwal;
    private javax.swing.JTextField txtIdkelas;
    private javax.swing.JTextField txtKeterangankelas;
    private javax.swing.JComboBox<String> txtPilihJadwal;
    private javax.swing.JComboBox<String> txtPilih_Kereta;
    private javax.swing.JComboBox<String> txtPilih_masinis;
    private javax.swing.JTextField txtStoktiket;
    private com.toedter.calendar.JDateChooser txtTanggalJadwal;
    private javax.swing.JTextField txtTujuan;
    private javax.swing.JSpinner txtWaktuJadwal;
    // End of variables declaration//GEN-END:variables
}
