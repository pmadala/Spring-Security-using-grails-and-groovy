package demo

import org.grails.web.util.WebUtils
import javax.servlet.http.HttpServletRequest
import grails.config.Config
import grails.core.support.GrailsConfigurationAware

class LoginController extends grails.plugin.springsecurity.LoginController implements GrailsConfigurationAware {

    List<String> coordinatePositions

	
    def auth() {

        def conf = getConf()

        if (springSecurityService.isLoggedIn()) {
            redirect uri: conf.successHandler.defaultTargetUrl
            return
        }

        Collections.shuffle(coordinatePositions)
        def position = coordinatePositions.first()

        String postUrl = request.contextPath + conf.apf.filterProcessesUrl
        render view: 'auth', model: [postUrl: postUrl,
                                     rememberMeParameter: conf.rememberMe.parameter,
                                     usernameParameter: conf.apf.usernameParameter,
                                     passwordParameter: conf.apf.passwordParameter,
                                     gspLayout: conf.gsp.layoutAuth,
                                     position: position]
    }

    @Override
    void setConfiguration(Config co) {
        coordinatePositions = co.getProperty('security.coordinate.positions', List, []) as List<String>

    }
    
    static String getCurrentUrl(HttpServletRequest request){

	    StringBuilder sb = new StringBuilder()
	    sb << request.getRequestURL().substring(0,request.getRequestURL().indexOf("/", 8))
	    sb << request.getAttribute("javax.servlet.forward.request_uri")
	    if(request.getAttribute("javax.servlet.forward.query_string")){
	        sb << "?"
	        sb << request.getAttribute("javax.servlet.forward.query_string")
	    }
	    return sb.toString();
	}
}