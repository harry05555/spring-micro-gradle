# How start gradle-micro project?

1. First install Dock on your computer.
2. Go in the cmd or in Intellij(Terminal) to the project root path.
3. Use ```docker compose up -d``` on cmd it will install the required containers.
4. At http://localhost:5050/browser/ you can reach the postgres db.
5. Your Pwd is ```asdf1234``` .
6. Register a server with the name ```harry05```. The host name is postgres because we use a bridge in Docker. 
7. Your Pwd is ```asdf1234``` admin is ```harry05``` same ports, save.
8. Create 3 DB ```notification```, ```fraud```, ```customer```.
9. Start the app ```EurekaServerApplication```, ```ApiGWApplication```, ```CustomerApplication```, ```FraudApplication```
```NotificationApplication```. in this order.
10. Use postmen with this url http://localhost:8080/api/v1/customers as post Method
11. ```
    {
    "firstName": "Max",
    "lastName": "Mustermann",
    "email": "Max.Mustermann@gmail.com" 
    }
    ```
    
    