package demo

import groovy.transform.Canonical
import groovy.transform.CompileStatic
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import grails.plugin.springsecurity.userdetails.GrailsUser

import javax.servlet.http.HttpServletRequest

@Canonical
@CompileStatic
class TwoFactorAuthenticationDetails extends WebAuthenticationDetails {
    String coordinatePosition
    String coordinateValue

    TwoFactorAuthenticationDetails(HttpServletRequest request) {
        super(request)
    }
    
    TwoFactorAuthenticationDetails(coordinatePosition, coordinateValue) {
        this.coordinateValue = coordinateValue;
        this.coordinatePosition = coordinatePosition;                                            
 	}

    
}
