/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.screens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author soupa
 */
public class App extends javax.swing.JFrame {

    private CardLayout cl;
    
    /**
     * Creates new form App
     */
    
    private final String ORDERS_PANEL = "op";
    private final String STAFF_PANEL = "sp";
    private final String MENU_PANEL = "mp";
    
    public App(String user) {
        initComponents();
        userLabel.setText(user);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("RMS App");
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        onSelected(ordersSidePanel);
        cardsPanel.add(new StaffPanel(),STAFF_PANEL);
        cardsPanel.add(new OrdersPanel(),ORDERS_PANEL);
        cardsPanel.add(new MenuPanel(),MENU_PANEL);
        cl = (CardLayout)cardsPanel.getLayout();
        cl.show(cardsPanel, ORDERS_PANEL);
        jPanel1.requestFocusInWindow();
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
        jPanel2 = new javax.swing.JPanel();
        ordersSidePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        logoutSidePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        staffSidePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        menuSidePanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cardsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));

        ordersSidePanel.setBackground(new java.awt.Color(0, 153, 51));
        ordersSidePanel.setPreferredSize(new java.awt.Dimension(214, 65));
        ordersSidePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersSidePanelMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Orders");
        jLabel1.setToolTipText("");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rms/assets/order.png"))); // NOI18N

        javax.swing.GroupLayout ordersSidePanelLayout = new javax.swing.GroupLayout(ordersSidePanel);
        ordersSidePanel.setLayout(ordersSidePanelLayout);
        ordersSidePanelLayout.setHorizontalGroup(
            ordersSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersSidePanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        ordersSidePanelLayout.setVerticalGroup(
            ordersSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ordersSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addContainerGap())
        );

        logoutSidePanel.setBackground(new java.awt.Color(0, 153, 51));
        logoutSidePanel.setPreferredSize(new java.awt.Dimension(213, 65));
        logoutSidePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutSidePanelMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Logout");
        jLabel2.setToolTipText("");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rms/assets/logout.png"))); // NOI18N

        javax.swing.GroupLayout logoutSidePanelLayout = new javax.swing.GroupLayout(logoutSidePanel);
        logoutSidePanel.setLayout(logoutSidePanelLayout);
        logoutSidePanelLayout.setHorizontalGroup(
            logoutSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutSidePanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        logoutSidePanelLayout.setVerticalGroup(
            logoutSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logoutSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rms/assets/user.png"))); // NOI18N

        userLabel.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setText("Username");

        staffSidePanel.setBackground(new java.awt.Color(0, 153, 51));
        staffSidePanel.setPreferredSize(new java.awt.Dimension(214, 65));
        staffSidePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffSidePanelMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Staff");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rms/assets/membership.png"))); // NOI18N

        javax.swing.GroupLayout staffSidePanelLayout = new javax.swing.GroupLayout(staffSidePanel);
        staffSidePanel.setLayout(staffSidePanelLayout);
        staffSidePanelLayout.setHorizontalGroup(
            staffSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffSidePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        staffSidePanelLayout.setVerticalGroup(
            staffSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staffSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        menuSidePanel.setBackground(new java.awt.Color(0, 153, 51));
        menuSidePanel.setPreferredSize(new java.awt.Dimension(213, 65));
        menuSidePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSidePanelMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri Light", 0, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Menu");
        jLabel14.setToolTipText("");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rms/assets/menu.png"))); // NOI18N

        javax.swing.GroupLayout menuSidePanelLayout = new javax.swing.GroupLayout(menuSidePanel);
        menuSidePanel.setLayout(menuSidePanelLayout);
        menuSidePanelLayout.setHorizontalGroup(
            menuSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuSidePanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel15)
                .addGap(26, 26, 26)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuSidePanelLayout.setVerticalGroup(
            menuSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(staffSidePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addComponent(ordersSidePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addComponent(menuSidePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(staffSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordersSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardsPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardsPanel.setPreferredSize(new java.awt.Dimension(890, 800));
        cardsPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onSelected(JPanel panel){
    
        panel.setBackground(new Color(255,102,0));
        
    }
    
    private void onUnselected(JPanel panel){
    
        panel.setBackground(new Color(0,153,51));
        
    }
    
    private void ordersSidePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersSidePanelMouseClicked
        // TODO add your handling code here:
        onSelected(ordersSidePanel);
        onUnselected(logoutSidePanel);
        onUnselected(staffSidePanel);
        onUnselected(menuSidePanel);
        cl.show(cardsPanel, ORDERS_PANEL);
        
    }//GEN-LAST:event_ordersSidePanelMouseClicked
    
    private void logoutSidePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutSidePanelMouseClicked
        // TODO add your handling code here:
        onSelected(logoutSidePanel);
        onUnselected(ordersSidePanel);
        onUnselected(staffSidePanel);
        onUnselected(menuSidePanel);
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_logoutSidePanelMouseClicked

    private void staffSidePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffSidePanelMouseClicked
        // TODO add your handling code here:
        onSelected(staffSidePanel);
        onUnselected(logoutSidePanel);
        onUnselected(ordersSidePanel);
        onUnselected(menuSidePanel);
        cl.show(cardsPanel, STAFF_PANEL);
    }//GEN-LAST:event_staffSidePanelMouseClicked

    private void menuSidePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSidePanelMouseClicked
        // TODO add your handling code here:
        onSelected(menuSidePanel);
        onUnselected(ordersSidePanel);
        onUnselected(logoutSidePanel);
        onUnselected(staffSidePanel);
        cl.show(cardsPanel, MENU_PANEL);
    }//GEN-LAST:event_menuSidePanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel logoutSidePanel;
    private javax.swing.JPanel menuSidePanel;
    private javax.swing.JPanel ordersSidePanel;
    private javax.swing.JPanel staffSidePanel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
