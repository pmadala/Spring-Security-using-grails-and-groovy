import demo.CoordinateValidatorService
import demo.TwoFactorAuthenticationDetailsSource
import demo.TwoFactorAuthenticationProvider
import demo.MyUserDetailsService
//import demo.MyAuthenticationFilter
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy

// Place your Spring DSL code here
beans = {

    // tag::authenticationDetailsSource[]
    //authenticationDetailsSource(TwoFactorAuthenticationDetailsSource)
    // end::authenticationDetailsSource[]

    // tag::coordinateValidatorBeanDefinition[]
    coordinateValidator(CoordinateValidatorService)
    // end::coordinateValidatorBeanDefinition[]
    
    
    // tag::userDetailsService[]
   	userDetailsService(MyUserDetailsService)
	// end::userDetailsService[]
	
	
	/*myAuthenticationFilter(MyAuthenticationFilter){
	    authenticationManager = ref('authenticationManager')
	    sessionAuthenticationStrategy = ref('sessionAuthenticationStrategy')
	    authenticationSuccessHandler = ref('authenticationSuccessHandler')
	    authenticationFailureHandler = ref('authenticationFailureHandler')
	    rememberMeServices = ref('rememberMeServices')
	    authenticationDetailsSource = ref('authenticationDetailsSource')
	    filterProcessesUrl = '/login/auth'
	}*/
	
	

    // tag::twoFactorAuthenticationProviderBeanDefinition[]
    twoFactorAuthenticationProvider(TwoFactorAuthenticationProvider) {
        coordinateValidator = ref('coordinateValidator')
        userDetailsService = ref('userDetailsService')
        passwordEncoder = ref('passwordEncoder')
        userCache = ref('userCache')
        saltSource = ref('saltSource')
        preAuthenticationChecks = ref('preAuthenticationChecks')
        postAuthenticationChecks = ref('postAuthenticationChecks')
        authoritiesMapper = ref('authoritiesMapper')
        hideUserNotFoundExceptions = true
    }
    // end::twoFactorAuthenticationProviderBeanDefinition[]

    sessionAuthenticationStrategy(NullAuthenticatedSessionStrategy)
}
