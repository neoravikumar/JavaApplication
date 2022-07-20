package com.practice;

public class Test22 {
	
	
	
	
	
	public static void main(String[] args) {
		try{
			
			class A {}
			class B extends A {}
			class C extends B {}
			B b = new B();
			
			System.out.println(b instanceof B);
			System.out.println((b instanceof B) && (! (b instanceof C)));
			System.out.println((b instanceof C));
			
			int x=0;
			for(x=0;x<4;x++);
			System.out.println(x);
			}
			catch(Exception e){}
			finally{
			System.out.println("Error");
			}
		
	}

}
