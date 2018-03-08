class UrlMappings {
    static mappings = {
        "/"(view: "/index.gsp")
        "/auth"(controller: "auth", action: "index")
        "/auth/*"(controller: "auth")
        "/timeline"(controller: "auth", action: "index")
        "/error" ( controller: "error", action: "serverError")    
       
        "500"(controller: "error", action: "serverError")
        "404"(controller: "error", action: "notFound")
        "403"(controller: "error", action: "forbidden")
         "200"(controller: "auth", action: "index")
    }
}
