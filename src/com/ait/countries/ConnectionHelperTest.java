package com.ait.countries;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionHelperTest {

	@Test
	public void testGetIP() {
		ConnectionHelper junit = new ConnectionHelper();
		String newIp = junit.getIP();
		testEquals();
		
		
		
	}

	@Test
	public void testGetConnection() throws Exception {
		ConnectionHelper junit1 = new ConnectionHelper();
		Connection  newgetConection = junit1.getConnection();
		testEquals();
		
	}

	@Test
	public void testClose() {
		ConnectionHelper junit2 = new ConnectionHelper();
//		Connection close = junit2.connection.close();
		testEquals();
		
		
		
	}

	
	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
