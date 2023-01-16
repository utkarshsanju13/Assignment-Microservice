STEPS TO RUN ALL THE MICROSERVICES:

1: Run the eureka server (microservice-name: EurekaServer Port:8761)
2: Run the Spring-cloud-config Server (microservice-name: Spring-cloud-config-server Port:8888)
3: Run the ApiGateway   (microservice-name: apigateway Port:8999)
4: Run Both the microservices
		: Customer Management (microservice-name: CustomerManagement Port:8080)
		: Account Managment (microservice-name: AccountManagement Port:8999)


/*---------------------------------------------------------------------------------------------------*/

Customer Management API:
BaseUrl: localhost:8080/customer   BaseUrlForEurekaServer: customermanagement-service/customer

a.	Add customer:

	url: BaseUrl/addCustomer/
	RequestBody: 
			{
   				 "customerId": 10,
   				 "name": "Utkarsh Gupta",
   				 "email": "Utkarshutkarsh10@gmail.com"
			}

b.	Get all Customers:

	url: BaseUrl/getAllCustomer
	
c.	Get single Customer Details:

	url:Baseurl/{customerId}

d.	Update Customer Details:
	Mention the customerId whose details has to update

	url: BaseUrl/{customerId}
	RequestBody: 
			{
   				 "customerId": 10,
   				 "name": "Utkarsh Gupta",
   				 "email": "Utkarshutkarsh10@gmail.com"
			}

e.	Delete Customer:
	
	url: BaseUrl/deleteCustomer/{customerId}


/*---------------------------------------------------------------------------------------------------*/

Account Management API:
BaseUrl: localhost:8081/account   BaseUrlForEurekaServer: accountmanagement-service/account

a.	Add Money to account: 

	url: BaseUrl/addMoney/{accountId}
	RequestParams:
		amount: {mention ammount of money to be added}

b.	Withdraw money from account:

	url: BaseUrl/withdrawMoney/{accountId}
	RequestParams:
		amount: {mention ammount of money to be withdraw}

c.	Get Account details:
	This will give details of account as well as customer associated with it

	url: BaseUrl/getAccountDetails/{accoutId}

d.	Delete Account.

	url: BaseUrl/deleteAccount/{accountId}

/*---------------------------------------------------------------------------------------------------*/

Details of Spring clound config server:

github repo of external-configuration: 
		"https://github.com/utkarshsanju13/ConfigRepo-assignmentMicroService"






