package assignment;

import java.io.IOException;

public class Test {
	
	public static void main(String args[]){
		
		A a = new A(new B(new A(), new A()));
		C c = new C(new B(new A(), new A()));
		a.b.c = c.b.a;
		
		Assignment2 f1= new Assignment2();
		try {
			f1.printFileCount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

