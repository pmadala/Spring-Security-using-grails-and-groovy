import demo.CoordinateValidatorService
import demo.TwoFactorAuthenticationDetailsSource
import demo.TwoFactorAuthenticationProvider
import demo.MyUserDetailsService
//import api.DefaultJsonPayloadCredentialsExtractor
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy

// Place your Spring DSL code here
beans = {


   

    coordinateValidator(CoordinateValidatorService)

   	userDetailsService(MyUserDetailsService)
	
	

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
