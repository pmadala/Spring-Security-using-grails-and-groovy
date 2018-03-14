package api

import org.springframework.security.core.Authentication
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import grails.plugins.rest.client.RestBuilder;
import grails.plugins.rest.client.RestResponse;
import grails.converters.JSON
import groovy.json.JsonBuilder

class AuthenticationService {

	/*
	* in real application we dont need to pass authentication token as server would generate them . 
	*/
	static String remoteAuthentication(Authentication token) {
        given:
        RestBuilder rest = new RestBuilder()
        def username = "user2";
        def password ="user2";
		
        when:
        RestResponse response = rest.post("http://localhost:8080/auth/remoteAuthentication") {
            	auth(username, password)
			    accept("application/json")
			    contentType("application/x-www-form-urlencoded")
			    body = ("grant_type=password&username=${username}&password=${password}" as String)
        }

        then:
        def response1  = new AuthResponse(
                status:'200',
                username: username,
                token: token   
        )

        return new JsonBuilder( response1 ).toPrettyString()
    }
} 