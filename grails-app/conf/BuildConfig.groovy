grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits "global"
    log "warn"
    repositories {        
        grailsPlugins()
        grailsHome()
        grailsCentral()
    }
    dependencies {
    	runtime 'mysql:mysql-connector-java:5.1.29'
    	test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
    	//bootstrap "org.grails.plugins:tomcat:7.0.55"
		 // compile 'org.grails.plugins:cache:1.1.8'
		 // compile 'org.grails.plugins:scaffolding:2.1.2'
		  //compile 'org.grails.plugins:resources:1.2.14'
		 // compile 'org.grails.plugins:asset-pipeline:1.9.9'
		 // compile 'org.grails.plugins:spring-security-core:2.0-RC4'
		compile "org.grails.plugins:spring-security-core:2.0-RC4"
    }
    
    plugin{
		build ":tomcat:7.0.55"
		compile ":scaffolding:2.12"
		compile ":cache:1.1.8"
		compile ":asset-pipeline:1.9.9"
	
		runtime ":hibernate4:4.3.6.1"
		runtime ":databasse-migration:1.4.0"
		runtime ":jquerry:1.11.1"
	
		compile ":spring-security-core:2.0-RC4"
	}
}
