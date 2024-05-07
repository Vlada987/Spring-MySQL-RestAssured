package endpoints;

import static io.restassured.RestAssured.*;

import api.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.MyResponse;
import pojo.Worker;


public class Methods {
	

public static Response getAllWorkers() {
	
Response resp= given().get(Routes.get);
return resp;
}

public static Response getWorkerByID(int id) {
	
Response resp= given().pathParam("id", id).get(Routes.get+"/{id}");
return resp;
}

public static Response getWorkerByName(String name) {
	
Response resp= given().queryParam("name", name).get(Routes.get+"/name");
return resp;
}

public static Response addWorker(Worker worker) {
	
Response resp= given().contentType("application/json") 
.accept(ContentType.JSON).body(worker).post(Routes.post);
return resp; 
}

public static Response updateWorkerPay(int id,String pay) {
	
String pay2="\""+pay+"\"";
Response resp= given().pathParam("id", id)
.body(pay2).contentType("application/json")
.put(Routes.put+"/{id}");
return resp;
} 

public static Response updateWorker(Worker worker) {
	
Response resp= given().contentType("application/json") 
.accept(ContentType.JSON).body(worker).put(Routes.put2);
return resp;
}

public static Response deleteWorker(int id) {
	
Response resp= given().pathParam("id", id)
.delete(Routes.delete+"/{id}");
return resp;
}

	
	

}
