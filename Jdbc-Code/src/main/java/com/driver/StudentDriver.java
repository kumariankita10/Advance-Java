package com.driver;

import java.util.List;
import java.util.Scanner;

import com.entity.Student;
import com.service.StudentService;

public class StudentDriver {
	public static void main(String[] args) {
		StudentService service = new StudentService();
		boolean flag=true;
		while(flag) {

		System.out.println("Welecome");
		System.out.println("Enter 1 to save data");
		System.out.println("Enter 2 to update data ");
		System.out.println("Enter 3 to fetch data");
		System.out.println("Enter 4 to delete data");
		System.out.println(" Enter 5 to Exit");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your choce");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter Student id");
			int id = sc.nextInt();
			System.out.println("Enter Student name");
			String name = sc.next();
			System.out.println("Enter Student mail");
			String mail = sc.next();

			System.out.println("Enter Student age");
			int age = sc.nextInt();

			Student st = new Student();
			st.setId(id);
			st.setName(name);
			st.setMail(mail);
			st.setAge(age);

			int res = service.save(st);
			if (res != 0) {
				System.out.println("Data Saved");
			}
			break;

		// Update
		case 2:

			System.out.println("Enter Student id to update");
			int sid = sc.nextInt();
			System.out.println("Enter Student name to update");
			String sname = sc.next();
			System.out.println("Enter Student mail to update");
			String smail = sc.next();
			System.out.println("Enter Student age to update");
			int sage = sc.nextInt();

			Student stu = new Student();
			stu.setId(sid);
			stu.setName(sname);
			stu.setMail(smail);
			stu.setAge(sage);

			int resu = service.update(stu);
			if (resu != 0) {
				System.out.println("Data Saved");
			}
			break;
			
		case 3:
			 List<Student> ls= service.fetchAll();
			 for(Student s:ls) {
				 System.out.println(s);
			 }
             break;
             
		case 4:
			System.out.println("Enter Student id to delete");
		    int did = sc.nextInt();

		    int dres = service.delete(did);

		    if (dres != 0) {
		        System.out.println("Data Deleted Successfully");
		    } else {
		        System.out.println("No record found with this id");
		    }
		    break;
		    
		case 5 :
			if(service.exitt()) {
			 flag = false;
			}
			
		  default:
			System.out.println();
			break;
		}

	}
}
}
