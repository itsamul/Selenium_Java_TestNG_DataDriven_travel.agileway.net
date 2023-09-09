package agiletravelproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import agiletravelproject.base.BaseTest;
import utilities.DataUtil;

public class CardPage extends BaseTest {

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 1)
	public void testVerifyingTripFareDetails(String tripDetails, String tripFare) {
		Assert.assertTrue(getElementText("flightDetails_lbl_passengerDetailsPage_XPATH").contains(tripDetails));
		Assert.assertTrue(getElementText("flightDetails_lbl_passengerDetailsPage_XPATH").contains(tripFare));
	}

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 2)
	public void testVerifyingPayment(String cardType, String cardHolderName, String cardNumber, String expiryDay, String expiryYear, String confirmHeader) {
		if (cardType.equalsIgnoreCase("Visa")) {
			click("visa_radio_cardPage_XPATH");
		} else if (cardType.equalsIgnoreCase("Master")) {
			click("master_radio_cardPage_XPATH");
		}
		type("cardNumber_tbx_cardPage_XPATH", cardNumber);
		select("day_drp_cardPage_XPATH", expiryDay);
		select("year_drp_cardPage_XPATH", expiryYear);
		click("payNow_btn_cardPage_XPATH");
		Assert.assertTrue(isElementPresent("confirmation_lbl_cardPage_XPATH"));
		Assert.assertTrue(getElementText("confirmation_lbl_cardPage_XPATH").contains(confirmHeader));
	}

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 3)
	public void testBookedDetails(String tripType, String tripDetails, String passengerName) {
		Assert.assertTrue(isElementPresent("flight_lbl_cardPage_XPATH"));
		Assert.assertTrue(getElementText("flight_lbl_cardPage_XPATH").contains(tripType));
		Assert.assertTrue(isElementPresent("flight_lbl_cardPage_XPATH"));
		Assert.assertTrue(getElementText("flight_lbl_cardPage_XPATH").contains(tripDetails));
		Assert.assertTrue(isElementPresent("passenger_lbl_cardPage_XPATH"));
		Assert.assertTrue(getElementText("passenger_lbl_cardPage_XPATH").contains(passengerName));
	}
}
