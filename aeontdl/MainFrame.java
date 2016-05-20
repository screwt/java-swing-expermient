package aeontdl;

import aeontdl.TaskDetailPanel;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements ActionListener, ListSelectionListener {

    ArrayList<Task> taskList;
    TaskDetailPanel taskDetail;
    DefaultTableModel tableModel;
    
    public MainFrame(ArrayList taskList){
        this.taskList = taskList;
        this.setTitle("Todo");
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //this.listModel = new DefaultListModel();
        //JList list = new JList(this.listModel);
	this.tableModel = new DefaultTableModel();
	this.tableModel.addColumn("ID");
	this.tableModel.addColumn("Name");
	this.tableModel.addColumn("Start");
	this.tableModel.addColumn("Priority");

	JTable table = new JTable(tableModel);
	for(int i=0;i<=table.getModel().getColumnCount()-1;i++){
	    TableColumn column = table.getColumnModel().getColumn(i);
	    column.setMaxWidth(100);
	    column.setMinWidth(100);
	}
	
	table.getColumnModel().removeColumn(table.getColumnModel().getColumn(0));
	
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	ListSelectionModel rowSM = table.getSelectionModel();
	rowSM.addListSelectionListener(this);
	
        JScrollPane listScrollPane = new JScrollPane(table);
	listScrollPane.setPreferredSize(new Dimension(300,300));
	listScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridheight = 2;
	//c.gridwidth = 1;
        this.getContentPane().add(listScrollPane,c);

        taskDetail = new TaskDetailPanel();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 1;	
        c.gridheight = 1;
	//c.gridwidth = 2;
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

	JButton b4 = new JButton("Supprimer");
        b4.addActionListener(this);
        taskDetailButtons.add(b4);
        
        this.update();
    }

    private void update(){
        System.out.println("Updating");
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.weightx = 0.5;
	//this.tableModel.setRowCount(0);
	
	for (Task task : this.taskList) {
	    this.tableModel.addRow(new Object[]{task.getId(),task.getName(),"",task.getPriority()});
        }
	this.pack();
        this.setVisible(true);
    }

    public void refresh(Task t){
	boolean found = false;
	for (int i=0;i<tableModel.getRowCount();i++) {
	    if(t.getId()==tableModel.getValueAt(i,0)){
		found = true;
		System.out.println("REMOVE "+i);
		tableModel.setValueAt(t.getName(),i,1);
		//tableModel.setValueAt(t.getName(),i,2);
		tableModel.setValueAt(t.getPriority(),i,3);
		break;
		//this.tableModel.insertRow(i,new Object[]{t.getId(),t.toString()});
	    }
	}
	if(!found){
	    this.tableModel.addRow(new Object[]{t.getId(),t.getName(),"",t.getPriority()});
	}
    }
    
    /**
     * Button Clicks event handling
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
	switch(e.getActionCommand()){
	case "Enregistrer":
	    Task t = this.taskDetail.saveTask();
	    this.refresh(t);
	    break;
	case "Nouveau":
	    t = new Task();
	    taskList.add(t);
	    this.refresh(t);
	    break;
	case "Supprimer":
	    
	    break;
	case "Annuler":
	    break;
	}
    }  

    /**
     * List selection event handling
     */
    public void valueChanged(ListSelectionEvent e){
	ListSelectionModel lsm = (ListSelectionModel)e.getSource();
	int selected = -1;
	for(int i=e.getFirstIndex();i<=e.getLastIndex();i++){
	    if(lsm.isSelectedIndex(i)){
		selected=i;
	    }
	}
	//System.out.println(e.getFirstIndex()+" "+e.getLastIndex()+" "+selected);
	int id = (int)tableModel.getValueAt(selected,0);
	this.loadDetail(id);
    }

    public void loadDetail(int id){
	System.out.println("loadDetail "+id);
	Task t = null;
	for (Task task : this.taskList) {
	    if(task.getId()==id){
		t = task;
	    }
        }

	this.taskDetail.loadTask(t);
    }
}
