package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dao.*;
import com.model.Appraise;
import com.model.Employee;
import com.model.Role;

public class MainEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc =new Scanner(System.in);
    RoleDao rdao=new RoleDaoImp(); 
    AppraiseDao appr = new  AppraiseDaoImp();

    EmpDao empDao = new EmpDaoImplement();

    do
    {
    	
    	System.out.println("welcome to  Appraisal system");
    	System.out.println("1 Add \n2 Update \n3 Delete \n4 view All roles  \n5 Add Appraisal \n6 view updated Appraisal  \n7 Add employee details \n8 view employee details \n9 List of employees 1 \n10 Employees list of Employees who did not have appraisal     \n11  list of Employee with maximum appraisals  \n12 exit");
    	System.out.println("Enter your choice ");
    	int choice =sc.nextInt();
    	switch(choice)
    	{
    	case 1:
    		     System.out.println("Enter roleid ,rolename ");
    		     int rid =sc.nextInt();
    		     String nm =sc.next();
    		     Role r=new Role(rid,nm);
    		
    		     boolean isadded=rdao.addRole(r);
    		     if(isadded)
    		    	 System.out.println("Successfully added record");
    		     else
    		    	 System.out.println("Unsuccessful insertion");
    		     break;

		case 2:
			System.out.println("Updation");
			System.out.println("Enter id to update");
			 rid = sc.nextInt(); 
			System.out.println("Enter new name");
			String rolename = sc.next();
	
			Role ob = new Role(rid, rolename);
			boolean isUpdated = rdao.updateRole(ob);
			if (isUpdated)
				System.out.println("Updation Succcessful!!");
			else
				System.out.println("Updation Failed!!!");
			break;

		case 3:
			System.out.println("Enter id to delete");
			rid = sc.nextInt();
			boolean isdelete = rdao.deleteRole(rid);
			if(isdelete)
				System.out.println("Role Deletion Successful!!");
			else
				System.out.println("Role Deletion Unsuccessful");
			break;
		
 
		case 4:
			List<Role> list = rdao.getALLRoles();
			System.out.println("RoleID" +"\tRoleName");
			for (Role rr : list) 
			{
				System.out.println(rr.getRoleid() + "\t " + rr.getRolename());
				   		    
			}
			System.out.println("------------------------------------------------------------------------------");
			break;
		
		case 5 : 
			   System.out.println("Add information  about Appraise");
			   System.out.println("employee_id , AppraisalDate , currentrole, newrole");
			   int empid =sc.nextInt();
			   String appraisaldate =sc.next();
			   String currentrole =sc.next();
			   String newrole =sc.next();
			   Appraise ob1= new Appraise(empid, appraisaldate, currentrole, newrole);
			   boolean isadd=appr.addAppraisal(ob1);
  		       if(isadd)
  		    	 System.out.println("Successfully added record");
  		     else
  		    	 System.out.println("Unsuccessful insertion");
  		     break; 
  		     
		case 6:   
			List<Appraise> list1 = appr.getALLAppraisal();
			System.out.println("view Appraisal Details");
			System.out.println("Empid" + "\tSalarydate"+"\tCurrent_Role"+ "\tNew_Role");
			for (Appraise rr : list1) 
			{
				
				System.out.println(rr.getEmpid() + "\t " + rr.getAppraisaldate()+" \t" + rr.getCurrentrole()+ " \t" +rr.getNewrole());
				   		    
			}
			System.out.println("------------------------------------------------------------------------------");
			break;
			case 7: System.out.println("enter employee details ");
			        System.out.println("employee_id");
			     int empid1 =sc.nextInt();
			     System.out.println("employee_Name");
				 String name =sc.next();
				 System.out.println("employee_emailaddress");
			     String email =sc.next();
			     System.out.println("employee_mobile_number");
				 long mobile =sc.nextLong();
				 System.out.println("employee_role id");
				  int roleid =sc.nextInt();
				  System.out.println("employee_salary");
				 int salary =sc.nextInt();
				  System.out.println("employee_deptid");  
				  int deptid =sc.nextInt();
			
			
			 
			 //Employee obje  =new Employee( empid1,  name,  email,  mobile , roleid,deptid);
			Employee obje  =new Employee( empid1,  name,  email,  mobile ,deptid,salary,roleid);
			 boolean addEmployee = empDao.addEmployee(obje);
		     if(addEmployee)
		    	 System.out.println("Successfully added record");
		     else
		    	 System.out.println("Unsuccessful insertion");
		     break;
			  
		case 8:         System.out.println("view  employee details "); 
					    List<Employee> list2= empDao.getAllEmployee();
					    System.out.println( "empid "+ "\tempname "+"\temail"+"\t\tmobile_no"+"\tDeptid "+"\tSalary" );
					    for(Employee abc :list2) 
					    {   
					    	System.out.println(abc.getEmpid() + "\t" +abc.getName() + "\t "+abc.getEmail()+" \t"+abc.getMobile()+" \t"+abc.getDeptid()+" \t"+abc.getRoleid() );
					    }
					    System.out.println("------------------------------------------------------------------------------------------"); 
					    break;
			  
		case 9: List<Employee> report2 =empDao.report2();
				   System.out.println("----Employee data-----");
				   System.out.println("List of employees who joined as a intern and now are managers ");
				   System.out.println("Empid" + "\tEmpName"+"\t Email id"+"\t\tmobile_no"+"\tsalary"+"\tCurrent_Role"+ "\tNew_Role");
			       for(Employee emp : report2) 
			       {
			    		System.out.println(emp.getEmpid() + "\t " + emp.getName()+" \t" + emp.getEmail()+ " \t" +emp.getMobile()+ "\t"+emp.getRoleid()+"\t"+emp.getSalary()+"\t\t"+emp.getDeptid());
			       }
			       System.out.println("------------------------------------------------------------------------------------------"); 
				 break; 
			   
	  case 10:  List<Employee> report3= empDao.report3();
		         System.out.println(" list of Employees who did not have appraisal ");
		         System.out.println("Empid" + "\tEmpName"+"\t Email id"+"\t\tmobile_no"+"\tRoleId"+"\tsalary"+ "\tDeptId");
			       for(Employee emp1 : report3) 
			       {
			    		System.out.println(emp1.getEmpid() + "\t " + emp1.getName()+" \t" + emp1.getEmail()+ " \t" +emp1.getMobile()+ "\t"+emp1.getRoleid()+"\t"+emp1.getSalary()+"\t\t"+emp1.getDeptid());
			       }
			       System.out.println("------------------------------------------------------------------------------------------"); 
			      break;
	  case 11:
		     List<Employee> report4= empDao.report3();
	         System.out.println(" list of Employee with maximum appraisals  ");
	         System.out.println("Empid" + "\tEmpName"+"\t Email id"+"\t\tmobile_no"+"\tRoleId"+"\tsalary"+ "\tDeptId");
		       for(Employee emp1 : report4) 
		       {
		    		System.out.println(emp1.getEmpid() + "\t " + emp1.getName()+" \t" + emp1.getEmail()+ " \t" +emp1.getMobile()+ "\t"+emp1.getRoleid()+"\t"+emp1.getSalary()+"\t\t"+emp1.getDeptid());
		       }
		       System.out.println("------------------------------------------------------------------------------------------"); 
		       break;
    	} 
    	if(choice==12)
    		break;
    }while(true);
    
    System.out.println("Thanks!!!!");
    
    
	}}

