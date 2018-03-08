package com.test

class User {
	
	    String username
	    String password
	   
	
	    static constraints = {
	        username blank: false, unique: true
	        password blank: false
	    }
	
	    static mapping = {
	        password column: '`password`'
	    }
	
	  
	}
