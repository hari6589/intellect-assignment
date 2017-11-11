POST
http://localhost:8080/user/add/
{
  "fName": "John",
  "lName": "Smith",
  "email": "John.Smith@gmail.com",
  "pinCode": 123456,
  "birthDate": "11-MAY-2017",
  "isActive": "true"
}


PUT
http://localhost:8080/user/update/
{
  "id": "1",
  "fName": "John22222",
  "lName": "Smith",
  "email": "John.Smith@gmail.com",
  "pinCode": 99999,
  "birthDate": "11-MAY-2017"
}

DELETE
http://localhost:8080/user/delete/1

GET
http://localhost:8080/user/view/
-----------------------------------------------

1. Create User
	- Check the email address is already registered with existing active user
	- Return userId if successful
2. Update User
	- Update pincode and Birthdate only
3. Delete existing user
	- Only deactivated
4. Data stored in Collection (HashMap)
5. Validattion
	- Email address should not be empty
	- Birth Date should not be future date
6. Maven Spring-boot project using Rest API - Created as a standalone jar
7. Tested with Chrome RestClient
8. Commited code to GitHub

Incomplete:
- cloud.google.com/apis for defining endpoints and HTTP response codes
- JUnit Test Case