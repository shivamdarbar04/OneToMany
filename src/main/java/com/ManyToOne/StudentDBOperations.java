package com.ManyToOne;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;

public class StudentDBOperations
{

	public Integer addStudent(Student student)
	{
		org.hibernate.Transaction tx = null;
		Integer studentId = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			tx = session.beginTransaction();
			studentId = (Integer) session.save(student);
			tx.commit();
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally
			{
				session.close();
			}
		return studentId;
	}
	
	public void  shoAllStudentDetails()
	{
		org.hibernate.Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			tx = session.beginTransaction();
			List<Student> students = session.createQuery("From Student").list();
			for(Student student : students)
			{
				System.out.println("First Name" + student.getFirstName());
				System.out.println("Last NAme " + student.getLastName());
				System.out.println("Class " + student.getClassName());
				System.out.println("RollNo " + student.getRollNo());
				System.out.println("Age" + student.getAge());
				
				List<Subject> subjects = student.getSubject();
				for(Subject subject : subjects)
				{
					System.out.println("Subject Name" + subject.getSubjectName());
				}
			}
			tx.commit();
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally
		{
			session.close();
		}
	}
	
	
	
}
