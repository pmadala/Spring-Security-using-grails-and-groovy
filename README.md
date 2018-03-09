# Spring-Security-using-grails-and-groovy

A sample application in groovy-grails for implementing spring security for authenticationn and authorization. 
Basic authentication scheme is implemneted here . For future scope, OAuth can be implemented for token based authentication . 

#### version specifications
- Grails Version: 3.3.2
- Groovy Version: 2.4.13
- JVM Version: 1.8.0_151
- Spring-security-core: 3.2.0.M1

#### Steps for moving through teh application 

1. Open http://localhost:8080/ . You will be rendered to login page . 
    ![login page](https://user-images.githubusercontent.com/35917175/37206831-3884d2c0-23c0-11e8-9485-6bd8a747cf40.png)
    
2. Enter your credentials as such . 
   - Authorized user credentials
      username : sherlock
      password : elementary
   - Unauthorized user credentials
      username : user
      password : user
      
   We implemneted two-factor authentication mechanism . For that we need to provide additional information based on teh below matrix.
   
    ['A1': '10', 'A2': '84', 'A3': '93', 'A4': '12', 'A5': '92',
             'A6': '58', 'A7': '38', 'A8': '28', 'A9': '36', 'A10': '02',
             'B1': '99', 'B2': '29', 'B3': '10', 'B4': '23', 'B5': '33',
             'B6': '47', 'B7': '58', 'B8': '39', 'B9': '34', 'B10': '18',
             'C1': '28', 'C2': '05', 'C3': '29', 'C4': '03', 'C5': '94',
             'C6': '14', 'C7': '41', 'C8': '33', 'C9': '11', 'C10': '39',
             'D1': '01', 'D2': '49', 'D3': '39', 'D4': '79', 'D5': '53',
             'D6': '38', 'D7': '17', 'D8': '88', 'D9': '70', 'D10': '12'
            ]

    
3. After authentication home page will be visible as follows . Please note the list of controllers visible . 
    ![homepage](https://user-images.githubusercontent.com/35917175/37206830-384605fe-23c0-11e8-8629-4032a24a7a32.png)
    
4. First controller click after logged in as authorized user . 
  ![client_authorized](https://user-images.githubusercontent.com/35917175/37206829-3815d4ce-23c0-11e8-9a50-7e18a50e8318.png)

5. First controller click after logged in as un-authorized user . 
![not_client_access_denied](https://user-images.githubusercontent.com/35917175/37206832-38c33222-23c0-11e8-8fbb-5461adfa4b27.png)

