
import java.lang.*;
import java.util.*;



public class OopsConcept {
	
	public static void main(String[] args) {
	
		
		Person p1=new Person("Akshay",25,"Jabalpur");
		Person p2=new Person("Antra",25,"Bangalore");
		Person p3=new Person("Lakhan",25,"Gurgaon");
		Person p4=new Person("Vishal",25,"Pune");
		Person p5=new Person("apoorva",25,"Jaipur");
		Person p6=new Person("Navansh",25,"Jabalpur");
		Person p7=new Person("Kishan",25,"Jabalpur");
		Person p8=new Person("Pandit",25,"Jabalpur");
		
		p1.setP(Arrays.asList(p2));
		p2.setP(Arrays.asList(p4,p5,p6));
		p3.setP(Arrays.asList(p7,p4));
		p4.setP(Arrays.asList(p8));
		
		List<String> list=new ArrayList<>();
		Person.getAllPerson(p1,list);
		for(String l:list )
			System.out.println(l);
		
		
	}

}


class Person{
	private String name;
	private int age;
	private String city;
	private List<Person> p;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Person(String name,int age,String city) {
		this.name=name;
		this.age=age;
		this.city=city;
	}
	
	
	
	
	
	public List<Person> getP() {
		return p;
	}
	public void setP(List<Person> p) {
		this.p = p;
	}
	public static void accept(List<Integer> list,int a) {
		
		Iterator i=list.iterator();
		
		while(i.hasNext()) {
			Integer j=(Integer) i.next();
			
		
			
					
		}
		
		for(int j=0;j<a;j++) {
			list.remove(j);
		}
		
	}
	
public static void getAllPerson(Person p,List<String> list1){
	
	list1.add(p.getName());
	if(p.getP()==null) {
		return;
	}
	String s=p.getName();
	int sizeOfList=p.getP().size();
	
	for(Person p1:p.getP()) {
		getAllPerson(p1, list1);
	}
	
}
	
}


