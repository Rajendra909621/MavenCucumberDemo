Feature:Admin

Scenario: Successfully Login with valid Credential

Given : User Launch Chrome Browser
When :  User Open url "https://admin-demo.nopcommerce.com/login"
And :  User Enter UserName as "admin@yourstore.com" and Password "admin"
And :  User Click on login
Then : 	Page Title Should be "Dashboard / nopCommerce administration"
And : Close Browser



Scenario Outline: Login Data Drven

Given : User Launch Chrome Browser
When :  User Open url "https://admin-demo.nopcommerce.com/login"
And :  User Enter UserName as "<email>" and Password "<password>"
And :  User Click on login
Then : 	Page Title Should be "Dashboard / nopCommerce administration"
And : Close Browser

Examples:
|email							|password		|
|admin@yourstore.com|admin			|
|admin@yourstore.com|admin			|
|admin@yourstore.com|admin123		|
	





