package org.qsp.test;

import org.qsp.genric.BaseTest;
import org.qsp.pom.Home;
import org.testng.annotations.Test;

public class Booking extends BaseTest {

	@Test
	public void Tc_01() throws Exception {
		Home h = new Home(driver);
		h.clickOneWay();
		Thread.sleep(2000);
		h.clicDCity();
		h.enterDepartureCity("kolkata");
		Thread.sleep(2000);
		h.arrivalCity("pune");
		Thread.sleep(2000);
		h.clickDdate();
		h.selectDdate();
		if (!h.checkRData())
			h.clickRTrip();
		h.clickRdate();
		h.selectRDate();
		Thread.sleep(5000);
		h.clickPassenger();
		Thread.sleep(5000);
		h.selectA(2);
		h.selectC(2);
		h.clickSearch();
	}

}
