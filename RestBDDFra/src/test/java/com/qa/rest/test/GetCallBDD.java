package com.qa.rest.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


public class GetCallBDD {
	
	@Test
	public void test_numofcircuitfor20107_Season() {
		/*
		 * given(). 
		 * when(). 
		 * then(). 
		 * assert()
		 */
		given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").
		then().
		assertThat().
		
		statusCode(200).
		and().
			body("MRData.CircuitTable.Circuits.circuitId",hasSize(20)).
			and().
			header("date", equalTo("Fri, 29 Jun 2018 17:24:43 GMT"));
	}

}
