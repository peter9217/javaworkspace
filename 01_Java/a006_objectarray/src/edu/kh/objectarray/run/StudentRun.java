package edu.kh.objectarray.run;

import edu.kh.objectarray.Service.StudentService;
import edu.kh.objectarray.view.StudentView;

public class StudentRun {
	
	public static void main(String[] args) {
		
		StudentView view = new StudentView();
		StudentService service = new StudentService();
		view.displayMenu();
		
	}

}
