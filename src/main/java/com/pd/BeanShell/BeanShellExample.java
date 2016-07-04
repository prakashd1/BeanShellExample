package com.pd.BeanShell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

import bsh.Interpreter;

public class BeanShellExample {

	public static void main(String[] args) throws Exception{

		Interpreter i = new Interpreter();  // Construct an interpreter
		i.set("foo", 5);                    // Set variables
		i.set("date", new Date() ); 

		Date date = (Date)i.get("date");    // retrieve a variable

		// Eval a statement and get the result
		
		/*String content = new Scanner(new File("./src/main/resources/hello.bsh")).useDelimiter("\\Z").next();
		System.out.println(content);*/
		
		
		i.eval("bar = foo*10");  
		
		System.out.println( i.get("bar") );
		i.eval(new BufferedReader(new FileReader(new File("./src/main/resources/hello.bsh"))));
		// Source an external script file
		
		i.source("./src/main/resources/hello.bsh");
	}
}
