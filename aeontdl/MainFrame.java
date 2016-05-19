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

public class MainFrame extends JFrame{

    ArrayList<Task> taskList;
    private DefaultListModel listModel;
    JPanel taskDetail;
    
    public MainFrame(ArrayList taskList){
	this.taskList = taskList;
	
	this.setTitle("Ma première fenêtre Java");
	this.setSize(700, 400);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//this.taskPanel = new JPanel();
	//this.taskPanel.setLayout(new GridLayout(0,1));
	//this.taskPanel.setLayout(new BoxLayout(this.taskPanel, BoxLayout.Y_AXIS));
	//this.taskPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	//this.taskPanel.setLayout(new GridBagLayout());

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
	//taskDetailButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	c.anchor = GridBagConstraints.PAGE_END;
	c.fill = GridBagConstraints.BOTH;
	c.gridx = 1;
	c.gridy = 1;
	c.gridheight = 1;
	//c.weightx = 1;
	c.weighty = 0;
	//c.weighty = 0.1;
	this.getContentPane().add(taskDetailButtons,c);

	JButton b = new JButton("test");
	taskDetailButtons.add(b);
	taskDetailButtons.add(new JButton("test"));
	
	this.update();
    }

    private void update(){
	System.out.println("Updating");
	GridBagConstraints c = new GridBagConstraints();
	c.gridy = 0;
	c.weightx = 0.5;
	//weighty = 0.1;
	//insets = new Insets(10,0,0,0);
	//c.ipady = 0;
	for (Task task : this.taskList) {
	    System.out.println(task);
	    /*
	    JLabel jp = new JLabel(task.toString());
	    jp.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));

	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridwidth = 1;
	    c.gridx = 0;
	    c.anchor = GridBagConstraints.FIRST_LINE_START;
	    
	    this.taskPanel.add(jp, c);
	    c.gridy += 1;
	    */
	    this.listModel.addElement(task.toString());
	}
	
	//this.pack();
	this.setVisible(true);
    }
}
