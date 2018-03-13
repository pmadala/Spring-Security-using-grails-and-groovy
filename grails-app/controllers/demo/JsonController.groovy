package demo

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.Authentication
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder

class JsonController {
	def springSecurityService
	def userDetailsService

    @Secured(['ROLE_JSON'])
    def index() {
       //code for read file nd render the output 
        //InputStream statement = new FileInputStream(new File("statement.txt"))
       	//String responseBody = statement.getText();
       	
       	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
       	
       	session["user"] = currentPrincipalName;
       	
       	def aStudent = session["user"]
       	def responseBody = "Added $aStudent to the session.\n";
    	render responseBody
    }
}