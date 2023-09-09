package agiletravelproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import agiletravelproject.base.BaseTest;
import utilities.DataUtil;

public class PassengerDetailsPage extends BaseTest {

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 8)
	public void testVerifyingTripDetails(String tripType, String tripDate, String fromPort, String toPort) {
		Assert.assertTrue(getElementText("flightDetails_lbl_passengerDetailsPage_XPATH").contains(tripType));
		Assert.assertTrue(getElementText("flightDetails_lbl_passengerDetailsPage_XPATH").contains(tripDate));
		Assert.assertTrue(getElementText("flightDetails_lbl_passengerDetailsPage_XPATH").contains(fromPort));
		Assert.assertTrue(getElementText("flightDetails_lbl_passengerDetailsPage_XPATH").contains(toPort));
	}

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 9)
	public void testWithoutPassengerInput(String firstName, String lastName, String message) {
		type("firstName_tbx_passengerDetailsPage_XPATH", firstName);
		type("lastName_tbx_passengerDetailsPage_XPATH", lastName);
		click("next_btn_passengerDetailsPage_XPATH");
		Assert.assertTrue(isElementPresent("alert_lbl_passengerDetailsPage_ID"));
		Assert.assertTrue(getElementText("alert_lbl_passengerDetailsPage_ID").contains(message));
	}

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 10)
	public void testWithPassengerInput(String firstName, String lastName, String message) {
		type("firstName_tbx_passengerDetailsPage_XPATH", firstName);
		type("lastName_tbx_passengerDetailsPage_XPATH", lastName);
		click("next_btn_passengerDetailsPage_XPATH");
		Assert.assertTrue(isElementPresent("header_lbl_cardPage_XPATH"));
		Assert.assertTrue(getElementText("header_lbl_cardPage_XPATH").contains(message));
	}

}
