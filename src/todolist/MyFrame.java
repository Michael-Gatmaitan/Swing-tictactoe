/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    
    MyFrame() {
        
//        button.addActionListener(e -> System.out.println("Poo"));
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        button = new JButton();
        button.setText("submit");
        button.addActionListener(this);
        
        checkBox = new JCheckBox();
        checkBox.setText("Micheal");
        checkBox.setFocusable(false);
        this.add(button);
        this.add(checkBox);
       
        this.setSize(500, 500);
        this.setVisible(true);
        
        // Add components;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button) {
            checkBox.isSelected();
        }
    }
}
