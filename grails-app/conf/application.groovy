// tag::providerNames[]
grails.plugin.springsecurity.providerNames = [
		'twoFactorAuthenticationProvider',
		'anonymousAuthenticationProvider',
		'rememberMeAuthenticationProvider']
// end::providerNames[]



//grails.plugin.springsecurity.useSecurityEventListener = true
//grails.plugin.springsecurity.useSessionFixationPrevention = true
//grails.plugin.springsecurity.sessionFixationPrevention.migrate = true
//grails.plugin.springsecurity.apf.storeLastUsername = true
//grails.plugin.springsecurity.filterChain.filterNames = [
//   'authenticationProcessingFilter', 'myAuthenticationFilter',
//]

/*grails.plugin.springsecurity.rest.token.validation.active=true
grails.plugin.springsecurity.rest.token.validation.headerName='X-Auth-Token'
grails.plugin.springsecurity.rest.token.validation.endpointUrl='/api/validate'
grails.plugin.springsecurity.rest.login.useJsonCredentials=true
grails.plugin.springsecurity.rest.login.usernamePropertyName='username'
grails.plugin.springsecurity.rest.login.passwordPropertyName='password'
grails.plugin.springsecurity.rest.logout.endpointUrl='/api/logout'
grails.plugin.springsecurity.rest.token.validation.headerName='X-Auth-Token'*/

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'demo.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'demo.UserRole'
grails.plugin.springsecurity.authority.className = 'demo.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

