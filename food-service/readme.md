A mock food service help interacting with the pizzeria

# Food Service
Needs to have at least one store connected then go to view menu page.

After placing some orders, then the store can send an accept order request
`PUT http://localhost:8080/order/{id}/accept`
This request will also notify drivers, if there are any. A configuration settings can adjust whether we send the notification in parallel
see class `Admins`
## View Menu
http://localhost:8080/index.html
see class `Stores`

## Driver Page
http://localhost:8080/drive.html
See class `Drivers`

