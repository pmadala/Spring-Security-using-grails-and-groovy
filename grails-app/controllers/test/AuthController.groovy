package test

class AuthController {

	def index() { 
		//render "index"
		render view: 'auth'
	}
	

    def testuser(){
	   render "test user"
	}
	
	def testuseradmin(){
		
	   	render "test admin"
	   
	}
	def renderFinalView = {
		render(view:"index");
	}
}
