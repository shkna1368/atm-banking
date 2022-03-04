# atm-banking
atm-banking
ATM Emulator
ATM is a part of our life activity, which helps us in day transactions and business. An automated teller machine (ATM) is a computerized telecommunications instrument that provides the clients of a financial institution with access to financial transactions in a public space without the need for a cashier, human clerk or bank teller.

# Infrastructure Design
The overall project should consist from 2 microservices: "thin client" application (named as "atm-service", for example) and "bank-service" with disvory service ad gateway.

# Tech stack:
java 17-
sprin boot 2.6.3-
spring cloud 2021.0.1-
 eureka discovey service -
spring cloud gateway-
swagger-
Feign

# How to use :
1-import projects in idea <br/>
2-make database shcema in postgresql <br/>
2-compile bank-service project for generate mapper(mapstruct) <br/>
3-run application(after run app,seed data done); <br/>
4-in browser open swagger ui :
http://localhost:8090/swagger-ui.html <br/>
http://localhost:8090/swagger-ui.html <br/>
5-in swagger call these apis:<br/>
login by pin code (card number :1111111111111111   pin:1111) <br/>
get balance by  creditcardId  (id: 1) <br/>
  deposit by  creditcardId  (id: 1)  <br/>
    withdrawal by  creditcardId  (id: 1)   <br/> 
  get last ten transactionby creditcardId(id: 1) <br/>


