package aeontdl;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements ActionListener {

    ArrayList<Task> taskList;
    private DefaultListModel listModel;
    JPanel taskDetail;
    
    public MainFrame(ArrayList taskList){
        this.taskList = taskList;
        this.setTitle("Todo");
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.listModel = new DefaultListModel();
        JList list = new JList(this.listModel);
        JScrollPane listScrollPane = new JScrollPane(list);
	
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.2;
        c.weighty = 0.5;
        c.gridheight = 2;
        this.getContentPane().add(listScrollPane,c);

        taskDetail = new JPanel();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.8;
        c.weighty = 1;	
        c.gridheight = 1;
        this.getContentPane().add(taskDetail,c);

        JPanel taskDetailButtons = new JPanel();
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.TRAILING);
        taskDetailButtons.setLayout(fl);
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.weighty = 0;
        this.getContentPane().add(taskDetailButtons,c);

        JButton b1 = new JButton("Nouveau");
        b1.addActionListener(this);
        taskDetailButtons.add(b1);
        
        JButton b2 = new JButton("Enregistrer");
        b2.addActionListener(this);
        taskDetailButtons.add(b2);
        
        JButton b3 = new JButton("Annuler");
        b3.addActionListener(this);
        taskDetailButtons.add(b3);
        
        this.update();
    }

    private void update(){
        System.out.println("Updating");
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.weightx = 0.5;
		for (Task task : this.taskList) {
            this.listModel.addElement(task.toString());
        }
	
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }  

}
