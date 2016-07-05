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
		i.set("way", 2);

		/*
		 * There are 3 ways to invoke beanshell 
		 */
		// First way :- Using inline evaluation
		
		System.out.println("Way of invoking beanshell " + 1);
		System.out.println("Invoking beanshell using inline evalution");
		i.eval("bar = foo*10");  
		System.out.println( i.get("bar") );
		System.out.println("--------------------------------");
		
		//Second way:- using buffered reader
		i.eval(new BufferedReader(new FileReader(new File("./src/main/resources/hello.bsh"))));

		
		
		// Third way:- Source an external script file
		i.source("./src/main/resources/hello.bsh");
		
	}
}
