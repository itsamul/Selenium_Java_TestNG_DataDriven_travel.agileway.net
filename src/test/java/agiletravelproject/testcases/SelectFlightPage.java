package agiletravelproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import agiletravelproject.base.BaseTest;
import utilities.DataUtil;

public class SelectFlightPage extends BaseTest {

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 1)
	public void testVerifyingOnSelectFlightPage(String message) {
		Assert.assertTrue(isElementPresent("header_lbl_selectPage_XPATH"));
		Assert.assertEquals(getElementText("header_lbl_selectPage_XPATH"), message);
	}

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 2)
	public void testVerifyingUsername(String username) {
		Assert.assertTrue(isElementPresent("username_lbl_SelectFlightPage_XPATH"));
		Assert.assertEquals(getElementText("username_lbl_SelectFlightPage_XPATH"), username);
	}

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 3)
	public void testSelectingOneWayFlight(String tripType, String fromPort, String toPort, String fromDay, String fromMonth, String flightNo, String header) {
		if (tripType.equalsIgnoreCase("Oneway")) {
			click("oneWayTrip_rad_SelectFlightPage_XPATH");
		} else if (tripType.equalsIgnoreCase("Return")) {
			click("returnTrip_rad_SelectFlightPage_XPATH");
		}
		select("from_drp_SelectFlightPage_XPATH", fromPort);
		select("to_drp_SelectFlightPage_XPATH", toPort);
		select("departDay_drp_SelectFlightPage_ID", fromDay);
		select("departMonth_drp_SelectFlightPage_ID", fromMonth);
		selectFlightNo(flightNo);
		click("continue_btn_SelectFlightPage_XPATH");
		Assert.assertTrue(isElementPresent("header_lbl_passengerDetailsPage_XPATH"));
		Assert.assertEquals(getElementText("header_lbl_passengerDetailsPage_XPATH"), header);
	}

}
