package aeontdl;

import java.util.ArrayList;

import aeontdl.MainFrame;
import aeontdl.Task;


public class Main {
    
    private static ArrayList taskList = new ArrayList();
    
    public static void main(String []args) {
	for(int i=0;i<10;i++){
	    taskList.add(new Task("t"+i));
	}
	MainFrame fenetre = new MainFrame(taskList);
	
    }
} 
