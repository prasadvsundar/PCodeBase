package com.nanobi.annotation;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	public enum Status {
		STARTED, NOT_STARTED
	}

	String author() default "Yash";

	Priority priority() default Priority.LOW;

	Status status() default Status.NOT_STARTED;
}

public class An{
	@Todo
	public void incompleteMethod1() {
		//Some business logic is written
		//But it’s not complete yet
	}
	
	public static void main(String[] args) {
		Class businessLogicClass = BusinessLogic.class;
		for(Method method : businessLogicClass.getMethods()) {
			Todo todoAnnotation = (Todo)method.getAnnotation(Todo.class);
			if(todoAnnotation != null) {
			System.out.println(" Method Name : " + method.getName());
			System.out.println(" Author : " + todoAnnotation.author());
			System.out.println(" Priority : " + todoAnnotation.priority());
			System.out.println(" Status : " + todoAnnotation.status());
		}
		}
	}
}