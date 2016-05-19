package aeontdl;

import java.util.Date;

public class Task {
    
    private String name;
    private String description;
    private int priority;
    private Date end;
    private Date start;
        
    public Task(String name, Date start, Date end, String description, int priority){
	this.name        = name;
	this.start       = start;
	this.end         = end;
	this.description = description;
	this.priority    = priority;
    }

    public Task(String name){
	this.name        = name;
	this.start       = new Date();
	this.end         = new Date();
	this.description = "";
	this.priority    = 0;
    }

    public String toString(){
	return this.name + " " + this.priority;
    }
}
