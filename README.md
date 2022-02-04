# Data Provider

Spring framework @RestController was using.
Provides unique data from existing list. The instance with data is creating once after first calling of method.
Due to using blocking queue only one request can be processed to prevent one data returns for several GET-requests.
If the set will be empty - the request will be waiting for the fist data.

While POST-request the value is checking for duplicate existing in set.

Can be useful for test automation where unique user-name should be getting for tests without data-base communicate.

Send request to *http://localhost:8080*
* **GET** request /getData is providing the data from existing list.
* **POST** request with request parameter "?data=" return back to the set
* **GET** request /getSet returns all set


To change the port add in resources *application.properties* and set the port
```bash
server.port=<your_port>
```


## Local build

  To build the project locally run the following command:

```bash
mvn clean install -P default
```
