package JPA_Database;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{ 
	public static void main( String[] args ){
		
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager em = emf.createEntityManager();
    	
    	Scanner scn=new Scanner(System.in);
    	boolean  sel= true;
    	while(sel) {
    		
    	
    	System.out.println("*******Menu-Option*******");
		System.out.println("\n 1. Insert\n 2.Select\n 3.Update\n 4. Delete\n 5. Display First N Record \n 6. Exit");
		int ch;
		System.out.println("Enter option");
		
		ch=scn.nextInt();
		
    	switch(ch)
		{
		case 1: 
		    	Alien a = new Alien();
				Scanner sc = new Scanner(System.in); 
				System.out.print("Enter the id to insert: ");  
				Integer num = sc.nextInt();            
				a.setAid(num);
				
				Scanner sc1 = new Scanner(System.in); 
				System.out.print("Enter the AName to insert: ");  
				String str1 = sc1.nextLine();            
				a.setAname(str1);
				
				Scanner sc2 = new Scanner(System.in); 
				System.out.print("Enter the Tech to insert: ");  
				String str2 = sc2.nextLine();            
				a.setTech(str2);
				System.out.println();
				em.getTransaction().begin();
				em.persist(a);
				em.getTransaction().commit();
				System.out.println("record inserted successfully!!!");
				System.out.println("Student id = "+a.getAid());  
				System.out.println("Student Name = "+a.getAname());  
				System.out.println("Student Tech = "+a.getTech()); 
				break;
		case 2:
			Scanner sc3 = new Scanner(System.in); 
			System.out.print("Enter the id to select: ");  
			Integer num1 = sc3.nextInt();            
			Alien b=em.find(Alien.class, num1);
		
			System.out.println("\n\n------your Selected Record-----");  
			System.out.println("Student id = "+b.getAid());  
			System.out.println("Student Name = "+b.getAname());  
			System.out.println("Student Tech = "+b.getTech());
			break;
		case 3:
			Scanner sc4 = new Scanner(System.in); 
			System.out.print("Enter the id to update data: ");  
			Integer num2 = sc4.nextInt();
			
			Alien s=em.find(Alien.class,num2);  
			
			System.out.println();
			Scanner sc5 = new Scanner(System.in); 
			System.out.print("Enter the Tech to update: ");  
			String str5 = sc5.nextLine();            
			s.setTech(str5);
			 
			System.out.println("*****Record Before Updation*****");  
			System.out.println("Student id = "+s.getAid());  
			System.out.println("Student Name = "+s.getAname());  
			System.out.println("Student Tech = "+s.getTech());
			
			
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			
			System.out.println("\n\n******Record after After Updation******");  
			System.out.println("Student id = "+s.getAid());  
			System.out.println("Student Name = "+s.getAname());  
			System.out.println("Student Tech = "+s.getTech()); 
			break;
		case 4:
			Scanner sc6 = new Scanner(System.in); 
			System.out.print("Enter the id to delete data: ");  
			Integer num4 = sc6.nextInt();
			
			
			Alien c=em.find(Alien.class,num4);  
	        System.out.println("*****Record Before Deletion*****");  
	        System.out.println("Student id = "+c.getAid());  
	        System.out.println("Student Name = "+c.getAname());  
	        System.out.println("Student Tech = "+c.getTech());  
	       
	        em.getTransaction().begin(); 
	        s=em.find(Alien.class,num4);
	        em.remove(s);  
	        em.getTransaction().commit();  
	        emf.close();  
	        em.close();
	        System.out.println("\n\n_____Record deleted successfully..._________");
	        break;
		case 5:
			
			Scanner sc7 = new Scanner(System.in); 
			System.out.print("Enter the number  to display first n number of record: ");  
			Integer n = sc7.nextInt(); 
			
			Alien d;
			for (int i=1;i<n;i++) {
				d=em.find(Alien.class, i);
				System.out.println("Student:"+i);
				System.out.println("Student id = "+d.getAid());  
		        System.out.println("Student Name = "+d.getAname());  
		        System.out.println("Student Tech = "+d.getTech());  
		        System.out.println();
			   }
			break;
		default:
			System.out.println("****Exit****"); 
			sel = false;
			break;
		
		}
		
	}
}
}
