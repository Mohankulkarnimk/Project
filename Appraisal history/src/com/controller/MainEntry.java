package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dao.AppraiseDao;
import com.dao.AppraiseDaoImp;
import com.dao.EmpDao;
import com.dao.EmpDaoImplement;
import com.dao.RoleDao;
import com.dao.RoleDaoImp;
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
    	System.out.println("1 Add \n2 Update \n3 Delete \n4 view All roles  \n5 Add Appraisal \n6 Report \n7 add employee details \n8 exit");
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
			for (Role rr : list) 
			{
				System.out.println(rr.getRoleid() + " " + rr.getRolename());
				   		    
			}
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
			System.out.println("Reports");
			   System.out.println("1->ReportDeparmenttwise \n2->Report Rolewise");
			   int ch=sc.nextInt();
			   if(ch==1)
			   {
				  Map<String, Integer> map = null;
				try {
					map = ((EmpDaoImplement) empDao).getDepartmentWiseCount();
				    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  for(String dnm:map.keySet())
				  {  
					  System.out.println(dnm+"-->"+map.get(dnm));
				  }
			   }
			 break; 
		case 7:
			  System.out.println("enter employee details ");
			  System.out.println("employee_id");
			     int empid1 =sc.nextInt();
			     System.out.println("employee_Name");
				 String name =sc.next();
				 System.out.println("employee_emailaddress");
			     String email =sc.next();
			     System.out.println("employee_mobile_number");
				 long mobile =sc.nextLong();
				  System.out.println("employee_deptid");
				  int deptid =sc.nextInt();
				
				  System.out.println("employee_role id");
				 int roleid =sc.nextInt();
				 
				 Employee obje  =new Employee( empid1,  name,  email,  mobile, deptid, roleid);
		       
				 boolean addEmployee = empDao.addEmployee(obje);
    		     if(addEmployee)
    		    	 System.out.println("Successfully added record");
    		     else
    		    	 System.out.println("Unsuccessful insertion");
    		     break;

    	}
    	if(choice==8)
    		break;
    }while(true);
    
    System.out.println("Thanks!!!!");
    
    
	}}

