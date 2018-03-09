package demo

import grails.plugin.springsecurity.annotation.Secured

class ClientController {

    @Secured(['ROLE_CLIENT'])
    def index() {
        render 'Welcome to your Client Page'
    }
}