package demo


import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.userdetails.GrailsUserDetailsService
import grails.plugin.springsecurity.userdetails.NoStackUsernameNotFoundException
import grails.transaction.Transactional
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UsernameNotFoundException

import javax.servlet.http.HttpServletRequest

class MyUserDetailsService implements GrailsUserDetailsService {

	def springSecurityService
	
   /**
    * Some Spring Security classes (e.g. RoleHierarchyVoter) expect at least
    * one role, so we give a user with no granted roles this one which gets
    * past that restriction but doesn't grant anything.
    */
   static final List NO_ROLES =
      [new SimpleGrantedAuthority(SpringSecurityUtils.NO_ROLE)]

   static def counter = 2L;
   UserDetails loadUserByUsername(String username, boolean loadRoles)
            throws UsernameNotFoundException {
      return loadUserByUsername(username)
   }

   @Transactional(readOnly=true,
        noRollbackFor=[IllegalArgumentException, UsernameNotFoundException])
   UserDetails loadUserByUsername(String username)
         throws UsernameNotFoundException {

      User user;
      if (!"user2".equalsIgnoreCase(username)) {
      	  	user = User.withUsername(username)
	      	if (!user) throw new UsernameNotFoundException(
	                   'MyUserDetailsService User not found', username)
	
	      
        	List<SimpleGrantedAuthority> authList = getAuthorities();
			MyUserDetails grailsUser = new MyUserDetails(user.id, user.passwrod, true, !user.accountExpired,
			!user.passwordExpired, !user.accountLocked, [new SimpleGrantedAuthority(SpringSecurityUtils.NO_ROLE)], counter++)
	        return grailsUser;
	  } else {
		  	def authorities = [new SimpleGrantedAuthority(Role.findByAuthority('ROLE_JSON').authority)]
	        MyUserDetails grailsUser = new MyUserDetails("user2", "user2", true, true,
				true, true, authorities, 1)
	        return grailsUser;
	        
	  }

   }
   
   
    private List<SimpleGrantedAuthority> getAuthorities() {
       def authorities = ['ROLE_CLIENT','ROLE_NOT_CLIENT','ROLE_JSON']
        return authorities;
    }
}