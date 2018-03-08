import org.example.*
import com.test.*;

class BootStrap {
	
	
    def init = { servletContext ->
    	def user = new User(username : 'user', password: 'user') .save(flush:true);
		def admin = new User(username : 'admin', password: 'admin') .save(flush:true);
		
		def userRole = new Role (authority:'ROLE_USER').save (flush:true);
		def userRole = new Role (authority:'ROLE_ADMIN').save (flush:true);
		
		new UserRole(user:user, role:userRole).save(flush:true);
		new UserRole(user:admin, role:adminRole).save(flush:true);
		    	  
    }

    def destroy = {
    }
} 
