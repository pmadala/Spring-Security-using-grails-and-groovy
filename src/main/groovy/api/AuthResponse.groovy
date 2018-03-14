package api

import org.springframework.security.core.Authentication

class AuthResponse {
    String status
    String username
    Authentication token
    
    AuthResponse(Object obj){
    	if (obj instanceof AuthResponse){
    	    AuthResponse obj1 = (AuthResponse) obj;    
    	    this.status = obj1.status;
    	    this.username = obj1.username;
    	    this.token = obj1.token;        
    	}
    }
}