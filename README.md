# Interview Tasks

## Task 1
Project Folder: resource-server

You are working on an API. You need to create pincode CRUD operations.
Use JDBC as the database framework and store the data in an in-memory h2 database.

The endpoints to implement are listed below:
- Create Pincode
- Update Pincode
- Get All Pincodes
- Count Pincodes
- Get Pincode
- Delete Pincode
- Search Pincode

Secure all endpoints with the OAuth 2.0 standard is plus.

## Task 2
Project Folder: resource-server

You are working on a Resource Server where endpoints are not yet secured.
HelloResource has two endpoints, and one of them should be accessible only to authenticated users.
Secure the "/hello/user" endpoint with the OAuth 2.0 standard.

Below is the required information about the Authorization Server.
You can use Password Grand Flow to get an access token.
```
https://idp.defensepoint.com/auth/realms/interview/.well-known/openid-configuration

client_id: test-client
username: user
password: user
```

## Task 3
Project Folder: keycloak-extension

This is Keycloak Custom SPI Development Task.

You are working on Keycloak Extension. We would like to extend the capability of Keycloak's default Registration Page.
We want to ask users to fill below additional fields:
- Address
- Country
- Pincode

Allow Registrations for only those Users who are matched with Pincode database created in "Task 1". Check Pincode entered by user using Rest API from Custom Keycloak Registration Form Provider (Backend side). On successful registration store all above 3 additional fields in User Attributes in Keycloak.