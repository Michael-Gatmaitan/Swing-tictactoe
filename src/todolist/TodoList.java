/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;

/**
 *
 * @author User
 */
public class TodoList extends javax.swing.JFrame {

    /**
     * Creates new form TodoList
     */
    
    public TodoList() {
        initComponents();
        
        designButtons();
    }
    
    int gameMap[][] = {
            { Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 3 },
            { Integer.MAX_VALUE - 4, Integer.MAX_VALUE - 5, Integer.MAX_VALUE - 6 },
            { Integer.MAX_VALUE - 7, Integer.MAX_VALUE - 8, Integer.MAX_VALUE - 9 },
        }, x = 0, y = 0;
    
    int xScore = 0;
    int oScore = 0;
    
    String player = "O";
    
    public void resetScores() {
        xScore = 0;
        oScore = 0;
        oScoreLabel.setText("O: " + oScore);
        xScoreLabel.setText("X: " + xScore);
    }
    
    public void restartGame() {
        JButton buttons[] = {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9};
        
        int temp = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                temp += 1;
                gameMap[r][c] = Integer.MAX_VALUE - temp;
            }
        }
        
        x = 0;
        y = 0;
        player = "O";
        
        jLabel1.setText("Game restarted, player " + player + " turn.");

        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i]; 
            button.setEnabled(true);
            
            button.setText(">_<");
        }
    }
    
    private void designButtons() {
        JButton buttons[] = {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9};
        
        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i]; 
            button.setFocusable(false);
            button.setSize(60, 60);
            int index = i;
            
            button.setText(">_<");
            button.addActionListener(e -> handleButtonClick(buttons, button, index));    
        }
    }
    
    private void handleButtonClick(JButton buttons[], JButton button, int i) {
        button.setText(player);
        player = player.equals("X") ? "O" : "X";
        jLabel1.setText("TURN:" + player);
        button.setEnabled(false);
        
        checkResult(buttons, i);
    }
    
    private void checkResult(JButton buttons[], int i) {
        
        x = (i <= 2) ? 0 : (i <= 5) ? 1 : 2;
        y = i % 3;
        
        if (player.equals("X")) {
            gameMap[x][y] = 1;
        } else if(player.equals("O")) {
            gameMap[x][y] = 0;
        }
        
//        System.out.println(gameMap[x][y]);
        
        // Display ap for debugging
        System.out.println("\nPrinting map");
        for (int dRow = 0; dRow < 3; dRow++) {
            for (int dCol = 0; dCol < 3; dCol++) {
                System.out.print(gameMap[dRow][dCol] + " ,");
            }
            System.out.println("\n");
        }
        
        int won = 0;
        int winner = Integer.MAX_VALUE;
        // Checking winner
        // Check horizontal winner
        
        for (int row = 0; row < 3; row++) {
            
            // Check horizontal
            if (gameMap[row][0] == gameMap[row][1] && gameMap[row][0] == gameMap[row][2]) {
                System.out.println("Won by horizontal.");
                won = 1;
                winner = gameMap[row][0];
                break;
            }
            
            // Check slunt pattern
            if (gameMap[0][0] == gameMap[1][1] && gameMap[0][0] == gameMap[2][2]) {
                System.out.println("Won by slunt.");
                won = 1;
                winner = gameMap[1][1];
                break;
            }
            if (gameMap[0][2] == gameMap[1][1] && gameMap[0][2] == gameMap[2][0]) {
                System.out.println("Won by slunt.");
                won = 1;
                winner = gameMap[1][1];
                break;
            }
            
            // Check vertical
            if (gameMap[0][row] == gameMap[1][row] && gameMap[0][row] == gameMap[2][row]) {
                System.out.println("Won by vertically.");
                won = 1;
                winner = gameMap[0][row];
                break;
            }
        }
        
        if (won == 1) {
            System.out.println("We have a winner.");
            String playerWinner = (winner == 1) ? "O" : (winner == 0) ? "X" : "We dont have a winner";
            jLabel1.setText("Player " + playerWinner + " win the game!!!");
            
            if (winner == 1) {
                oScore += 1;
            } else if (winner == 0) {
                xScore += 1;
            }
            
            // Display scores
            oScoreLabel.setText("O: " + oScore);
            xScoreLabel.setText("X: " + xScore);
            
            for (JButton btn: buttons) {
                // Disable all button as the game ended.
                btn.setEnabled(false);
            }
        } else {
            
            int allButtonIsDisabled = 0;
            for (int buttonIndex = 0; buttonIndex < buttons.length; buttonIndex++) {
                if (buttons[buttonIndex].isEnabled() == true) {
                    allButtonIsDisabled = 0;
                    break;
                }
                
                allButtonIsDisabled = 1;
            }
            
            if (allButtonIsDisabled == 1) {
                System.out.println("The game is draw.");
                jLabel1.setText("Draw");  
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        scoreHeader = new javax.swing.JLabel();
        restartGameButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        xScoreLabel = new javax.swing.JLabel();
        oScoreLabel = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");

        jButton2.setText("jButton1");

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton1");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton1");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton1");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("jButton1");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("jButton1");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("jButton1");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        scoreHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        scoreHeader.setText("Scores");

        restartGameButton.setText("Another round");
        restartGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartGameButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("TURN:");

        xScoreLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        xScoreLabel.setText("X: 0");

        oScoreLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        oScoreLabel.setText("O: 0");

        jButton10.setText("Reset Score");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scoreHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(xScoreLabel)
                                    .addComponent(oScoreLabel)
                                    .addComponent(jButton10)))
                            .addComponent(restartGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scoreHeader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xScoreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oScoreLabel)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restartGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void restartGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartGameButtonActionPerformed
        // TODO add your handling code here:
        restartGame();
    }//GEN-LAST:event_restartGameButtonActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        resetScores();
    }//GEN-LAST:event_jButton10ActionPerformed

//    porkCB.addItemListener(new ItemListener() {
//        @Override
//        public void itemStateChanged(ItemEvent e) {
//            if (e.getStateChange() == ItemEvent.SELECTED) {
//                System.out.println("CHecked");
//            } else {
//                System.out.println("not CHecked");
//            }
//        }
//    })
    
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
            java.util.logging.Logger.getLogger(TodoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TodoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TodoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TodoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TodoList().setVisible(true);
            }
        });
        
//        new MyFrame();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel oScoreLabel;
    private javax.swing.JButton restartGameButton;
    private javax.swing.JLabel scoreHeader;
    private javax.swing.JLabel xScoreLabel;
    // End of variables declaration//GEN-END:variables
}
