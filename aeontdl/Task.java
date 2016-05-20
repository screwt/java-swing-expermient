package aeontdl;

import java.util.Date;

public class Task {

    public static int nextIndex = 0;
    
    private String name;
    private String description;
    private int priority;
    private Date end;
    private Date start;
    private int id;
        
    public Task(String name, Date start, Date end, String description, int priority){
	this.id          = Task.nextIndex;
	this.name        = name;
	this.start       = start;
	this.end         = end;
	this.description = description;
	this.priority    = priority;
	Task.nextIndex  += 1;
    }

    public Task(){
	this.id          = Task.nextIndex;
	Task.nextIndex  += 1;
    }
    
    public Task(String name){
	this.id          = Task.nextIndex;
	this.name        = name;
	this.start       = new Date();
	this.end         = new Date();
	this.description = "";
	this.priority    = 0;
	Task.nextIndex  += 1;
    }

    public String toString(){
	return this.id+" "+this.name + " " + this.priority;
    }

    public int  getId(){
	return this.id;
    }

    public String getName(){
	return this.name;
    }

    public String getDescription(){
	return this.description;
    }

    public String getPriority(){
	return ""+this.priority;
    }

    public void setName(String n){
	this.name = n;
    }

    public void setDescription(String d){
	this.description = d;
    }

    public void setPriority(String p){
	this.priority = Integer.parseInt(p);;
    }
}
