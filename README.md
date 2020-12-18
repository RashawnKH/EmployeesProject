The project is a application which takes in a .csv file of employee records. 
The application will then check the records for duplicate identification numbers (employee id's), and remove all duplicates.
Once the duplicates have been removed it will then insert the processed data into your database.

How to use the application
-Ensure that you have a MySQL Database
-Enter the URL to your database in url variable in the ThreadedDAO class
-Create a login.properties file in the resources folder 
-In the login.properties file create a userName and password in the same syntax for example:
userName = user1
password = pass123
-These will need to be the same as the user name and password for your sql database
-Then add a csv file containing the records you wish to insert into the database, please name this EmployeeRecords.csv
-Then in the EmployeeDAO class please enter the name of your database and the table name after the INSERT INTO statement

You can then run the program through the app class in the runapp package

The application will then print out each stage it is doing as well the time taken to complete that stage


