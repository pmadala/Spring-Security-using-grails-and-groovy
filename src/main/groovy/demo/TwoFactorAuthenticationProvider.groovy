package demo

import groovy.transform.CompileStatic
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import grails.plugins.rest.client.RestBuilder;
import grails.plugins.rest.client.RestResponse;
import api.AuthenticationService;
import grails.converters.JSON
import groovy.json.JsonSlurper
import api.AuthResponse

@CompileStatic
class TwoFactorAuthenticationProvider extends DaoAuthenticationProvider {

	def hostname ="127.0.0.1:8080"
    CoordinateValidator coordinateValidator

    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
            
        String username = userDetails.username;
        if ("user2".equalsIgnoreCase(username)) {
        
        	Authentication token;
        	String jsonTxt = AuthenticationService.remoteAuthentication(authentication);
        	AuthResponse resp = new AuthResponse(new JsonSlurper().parseText(jsonTxt))
        	def obj = resp.token;
        	if ( (obj instanceof Authentication) ) {
        		token =(Authentication) obj;
        	} 
        	
			SecurityContextHolder.getContext().setAuthentication(token); 
			return ;
        }
        
        super.additionalAuthenticationChecks(userDetails, authentication)

        Object details = authentication.details

        if ( !(details instanceof TwoFactorAuthenticationDetails) ) {
            logger.debug("Authentication failed: authenticationToken principal is not a TwoFactorPrincipal");
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
        def twoFactorAuthenticationDetails = details as TwoFactorAuthenticationDetails


        if ( !coordinateValidator.isValidValueForPositionAndUserName(twoFactorAuthenticationDetails.coordinateValue, twoFactorAuthenticationDetails.coordinatePosition, authentication.name) ) {
            logger.debug("Authentication failed: coordiante note valid");
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
    }

}
