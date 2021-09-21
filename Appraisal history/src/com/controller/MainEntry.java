package com.controller;

import java.util.Scanner;

import com.dao.RoleDao;
import com.dao.RoleDaoImp;
import com.model.Role;

public class MainEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc =new Scanner(System.in);
    RoleDao rdao=new RoleDaoImp();
    do
    {
    	
    	System.out.println("welcome to  Appraisal system");
    	System.out.println("1 -> add \n2 ->Update \n3>-Delete \n4 -> view All roles \n5 ->Report \n6 -> exit");
    	System.out.println("Enter your choice ");
    	int choice =sc.nextInt();
    	switch(choice)
    	{
    	case 1:
    		     System.out.println("Enter roleid and rolename");
    		     int rid =sc.nextInt();
    		     String nm =sc.next();
    		     Role r=new Role(rid,nm);
    		     boolean isadded=rdao.addRole(r);
    		     if(isadded)
    		    	 System.out.println("Successfully added record");
    		     else
    		    	 System.out.println("Unsuccessful insertion");
    		     break;
    		     
    		     
    	}
    	if(choice==6)
    		break;
    }while(true);
    
    System.out.println("Thanks!!!!");
	}

}
