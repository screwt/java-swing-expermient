package aeontdl;

import aeontdl.Task;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

class TaskDetailPanel extends JPanel{
    JTextField name;
    JTextField description;
    JTextField priority;
    Task currentTask;
    
    public TaskDetailPanel(){
	super();

	name        = new JTextField(10);
	description = new JTextField(10);
	priority    = new JTextField(10);

	this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
	c.anchor = GridBagConstraints.FIRST_LINE_START;
	c.weightx = 0.5;
	c.weighty = 0;

	c.gridy = 0;
	c.gridx = 0;
	c.weightx = 0;
	this.add(new JLabel("Name:"),c);
	c.weightx = 1;
	c.gridx = 1;
	this.add(name,c);
	
	c.gridy += 1; 
	c.gridx = 0;
	c.weightx = 0;
	this.add(new JLabel("Description:"),c);
	c.gridx = 1;
	c.weightx = 1;
	this.add(description,c);

	c.gridy += 1;
	c.gridx = 0;
	c.weightx = 0;
	this.add(new JLabel("Priority:"),c);
	c.gridx = 1;
	c.weightx = 1;
	this.add(priority,c);

    }

    public void loadTask(Task t){
	System.out.println("loadTask "+t);
	this.currentTask = t;
	this.name.setText(t.getName());
	this.description.setText(t.getDescription());
	this.priority.setText(t.getPriority());
    }

    public Task saveTask(){
	System.out.println("saveTask");
	this.currentTask.setName(this.name.getText());
	this.currentTask.setDescription(this.description.getText());
	this.currentTask.setPriority(this.priority.getText());
	return this.currentTask;
    }
}
