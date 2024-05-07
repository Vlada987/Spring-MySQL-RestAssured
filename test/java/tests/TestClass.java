package tests;

import java.util.Random;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.Methods;
import io.restassured.response.Response;
import pojo.Worker;


public class TestClass {
	
//@Test
public void Test01_getAllWorkers() {
	
Response resp= Methods.getAllWorkers();
resp.then().log().all();
}

//@Test
public void Test02_getWorkerByID() {
	
Response resp= Methods.getWorkerByID(3);
resp.then().log().all();
}

//@Test
public void Test03_getWorkerByName() {

Response resp= Methods.getWorkerByName("John Smith");
resp.then().log().all();
}

@Test
public void Test04_addNewWorker() { 
	
Faker faker=new Faker();
Random random=new Random();
Worker worker=new Worker();
worker.setName(faker.name().fullName());
worker.setJob_title(faker.job().position()); 
worker.setPay(String.valueOf(random.nextInt(500, 1000)));
Response resp= Methods.addWorker(worker);
resp.then().log().all();
}

//@Test
public void Test05_updateWorkersPay() {
	
Response resp= Methods.updateWorkerPay(1, "50003$");
resp.then().log().all();
}

//@Test
public void Test06_updateWorker() {
	
Worker worker=new Worker();
worker.setId(3);
worker.setName("Mike Johnson ");
worker.setJob_title("QA Project Lead");
worker.setPay("2850$");
Response resp= Methods.updateWorker(worker);
resp.then().log().all();
}

//@Test
public void Test07_deleteWorker() {
	
Response resp= Methods.deleteWorker(3);
resp.then().log().all();
}










}
