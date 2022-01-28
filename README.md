# employeemanagement

Description :
This application is an full stack application ( angular +spring boot + postgresql) for employee management system. We can add, update, delete and view employees.

Please read the instruction to run this Application

Number of applications
1) employee-management-ui  = Angular app.
2) employee-management-api = Spring boot app.

Artifacts
1) postman collections for api testing.

Instructions
1) Install postgresql server in your local. Open pgadmin from your windows tab.
2) Import the spring boot app employee-management-api into STS and start server. Server runs at http://localhost:8080 by default.
3) Download the employee-management-ui in your local. Open the command prompt in that folder and run following commands

npm install
npm install -g @angular/cli
ng serve

Open browser and enter http://localhost:4200  ( UI application opens)
![image](https://user-images.githubusercontent.com/98563243/151461617-6654e279-d6a4-4edb-979d-6e7619cf1c3b.png)

Now start adding employees, editing and deleting employees.

Add Employee screen
![image](https://user-images.githubusercontent.com/98563243/151465098-7c8f7dd5-6bf5-41b9-9cba-6209076367cd.png)

Update Employee screen
![image](https://user-images.githubusercontent.com/98563243/151465156-b50a742b-81b5-4de9-85d9-fa5b5e23fe2a.png)

After adding employees
![image](https://user-images.githubusercontent.com/98563243/151465025-64f2f916-db2b-4c0e-b114-8d528e5d2d05.png)

For testing purpose we can use Employee.postman_collection.json added.
