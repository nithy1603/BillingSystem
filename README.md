Software Requirements
        Java JDK 1.5 or above    

Please download the files into a folder named BTS_System. 


Set environment variables as following:

set JAVA_HOME=<your jdk path>

set PATH=%JAVA_HOME%\bin


Compile:

javac -d classes source/sg/edu/nus/iss/utility/*.java source/sg/edu/nus/iss/system/*.java source/sg/edu/nus/iss/customer/*.java source/sg/edu/nus/iss/subscription/*.java



Run :

set classpath=%classpath%;./classes;

java sg.edu.nus.iss.system.ApplicationMaster



Alternatively,

You can create a project in eclipse and give the project location pointing to the BTS_System. Clean the project. Right Click on source/sg/edu/nus/iss/system/ApplicationMaster , select Run As Java application from the menu.





How to use the application


A login page is displayed at first.


Enter any username or password and click OK enter the application. Its mandatory to enter some username or password although I have not concentrated on user authentication here. This is just to give an idea that only authorized users from the service providing company can use this system.


A simple page with some menus is displayed. You can log off/ exit using admin menu. Click on Help Menu to know more about the system.


Click on Services menu and select customers. A customer search page appears. Click on Search button and it will display all the customers available. I have stored the customer data in datafiles for retrieval. You can also give some search criteria and click on search to get the specified customer. 


Click on create button to create a new customer.   First Name, Last Name and NRIC are mandatory fields. NRIC is just an identification number like the passport number .   You can further update the selected customer by clicking on the Modify Button, View button to view selected customer details  and Activate and deactivate to do the respective actions. 


Select a customer and click on Manage Subscriptions to subscribe (for a new customer), view and modify services for the customer like digital voice, mobile voice and cable TV. 

Corresponding Local feature is selected by default on selecting Digital and Mobile Subscription and Standard Channels feature is selected by default on selecting CableTv Subscription.   If a service (eg. Digital/Mobile/Cable) is terminated it is assumed that all the corresponding features are terminated. You can terminate a service only by entering the Date Terminated. Some validation checks are done on the page to enable wrong data submission. 

