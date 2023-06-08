package com.ManyToOne;

import java.util.ArrayList;

public class HibernateTest 
{
    public static void main(String[] args)
    {
    	ArrayList subjectList1 = new ArrayList();
    	subjectList1.add("Data Structure");
    	subjectList1.add("Operating System");
    	
    	ArrayList subjectList2 = new ArrayList();
    	subjectList2.add("Compier");
    	subjectList2.add("Networking");
    	subjectList2.add("DBMS");
    	
    	Student student1 = new Student( 0, "Harish", "kansal", "MCA FINAl", "MCA/07/72", 27, subjectList2);
    	
    	Student student2 = new Student(0, "Sunil", "Kumar", "MCA final", "MCA/07/23", 32, subjectList2);
    	
    	student1.setSubject(subjectList1);
    	student2.setSubject(subjectList2);
    	
    	StudentDBOperations obj = new StudentDBOperations();
    	obj.addStudent(student1);
    	obj.addStudent(student2);
    	
    	obj.shoAllStudentDetails();
    	
    }
}
