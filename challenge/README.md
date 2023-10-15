# Property api

## Getting started


This project was made with IntelliJ. To open the project with IntelliJ, open the folder (IntelliJ should recognize the folder as a maven project)

### Technologies required

Postgres\
JDK 21\
Postman

### Setup

The project requires the following environment variables (You can set this in the run configurations in IntelliJ):

DB_NAME\
DB_HOST\
DB_PORT\
DB_USERNAME\
DB_PASSWORD

When running the backend, the database entities are synced so that the database tables reflects the entities. So to create the tables needed, simply run the backend.

When the tables are created, 3 nodetypes with the following names must be added:

BUILDING\
CORPORATION\
PROPERTY

### Create nodes

There are no nodes in the system when setting up the project. Nodes can be added by using the following endpoints with postman

POST /api/v1/node/corporation
```
{
    "name": string
    "parentId": int, // Optional
}
```
POST /api/v1/node/building
```
{
    "name": string
    "parentId": int, // Optional
    "zipCode": int, // range: 1000 - 9999
}
```
POST /api/v1/node/property
```
{
    "name": string
    "parentId": int, // Optional
    "monthlyRent": int, // Must be greater or equal 0
}
```
