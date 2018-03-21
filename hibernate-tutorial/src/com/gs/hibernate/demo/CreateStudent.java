package com.gs.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;


public class CreateStudent {

	public static void main(String[] args) {

		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {			
			
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("sai", "hithesh", "hithesh123@gmail.com");
			Student tempStudent1 = new Student("rohit", "sharma", "sharma45@gmail.com");
			
			
			
			session.beginTransaction();
			
		
			System.out.println("Saving the student...");
			session.save(tempStudent);
			session.save(tempStudent1);
		
			session.getTransaction().commit();
			
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");

			
		}
		
		finally {
			factory.close();
		}
	}

}






