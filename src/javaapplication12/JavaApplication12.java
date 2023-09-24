/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication12;
import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}
/**
 *
 * @author Lenovo
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = scan.nextInt();
			String fname = scan.next();
			double cgpa = scan.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        scan.close();

        Collections.sort(studentList, new StdComp());
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
    }
    
}

class StdComp implements Comparator<Student> {
    double epsilon = 0.001;
    @Override
    public int compare(Student std1, Student std2) {
        
        if (Math.abs(std1.getCgpa() - std2.getCgpa()) > epsilon) {
            return std1.getCgpa() < std2.getCgpa() ? 1 : -1; 
        } else if (!std1.getFname().equals(std2.getFname())) {
            return std1.getFname().compareTo(std2.getFname());
        } else {
            return std1.getId() - std2.getId();
        }
    }
}