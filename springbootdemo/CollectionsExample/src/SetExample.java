import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SetExample {
	
	public static void main(String[] args) {
		
		Set<String> set1=new HashSet<>();
		List<Employee> e=Arrays.asList(new Employee("Akshay","a",29),new Employee("Akshay","a",29),new Employee("Antra","b",25),new Employee("Abhi","a",25),new Employee("lakhan","b",25));
		int sum=0;
		set1.add("a");
		set1.add("b");
		set1.add("c");
		set1.add("d");
		
		Optional<String> s=set1.stream().reduce((i,j)->i+j);
		
		Map<String,Integer> s1=e.stream().collect(Collectors.groupingBy(j->j.getCity(),Collectors.summingInt(k->k.getAge())));
		
		Set<String> s2=s1.keySet();
		
		for(String i:s2) {
			System.out.println(i+" "+s1.get(i));
		}
		
		System.out.println(s.get());
		
		
		C c=new C();
		System.out.println(c.sum(1, 2));
	}


}

interface A{
	
	default int add(int a,int b) {
		return a+b;
	}
	
	 
	
	
}

interface B{
	default int add(int a,int b) {
		return a+b;
	}
	
	public double min(int a,int b);
}

class C implements B,A{

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		
		return B.super.add(a, b);
	}

	@Override
	public double min(int a, int b) {
		return 0;
		// TODO Auto-generated method stub
		
	}
	

	public int sum(float a,float b) {
		System.out.println("int");
		return 1;
	}
	
	public double sum(long a ,long b) {
		System.out.println("double");
		return 1.0;
	}
	
}

class Employee{
	private String name;
	private String city;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Employee(String name, String city, int age) {
		
		this.name = name;
		this.city = city;
		this.age = age;
	}
	
	
}