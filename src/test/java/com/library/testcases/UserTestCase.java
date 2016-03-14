package com.library.testcases;

import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import com.library.main.Main;

import spark.Spark;
import spark.utils.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UserTestCase {

	@BeforeClass
	public static void beforeClass() {
		Main.main(null);
	}

	@AfterClass
	public static void afterClass() {
		Spark.stop();
	}

	@Test
	public void aNewUserShouldBeCreated() {
		TestResponse res = request("POST", "/createUser?firstname=aditya&lastname=v&middlename=ram&age=24&phone=4088722112&zip=94538&gender=M");
		assertEquals(200, res.status);
		assertEquals("User Added Successfully", res.body);		
	}
	

	private TestResponse request(String method, String path) {
		try {
			URL url = new URL("http://localhost:4567" + path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			connection.connect();
			String body = IOUtils.toString(connection.getInputStream());
			return new TestResponse(connection.getResponseCode(), body);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Sending request failed: " + e.getMessage());
			return null;
		}
	}

	private static class TestResponse {

		public final String body;
		public final int status;

		public TestResponse(int status, String body) {
			this.status = status;
			this.body = body;
		}

		
	}
}