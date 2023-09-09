package agiletravelproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import agiletravelproject.base.BaseTest;
import utilities.DataUtil;

public class Logout extends BaseTest {
	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 1)
	public void testLogOff(String linkText, String message, String header) {
		Assert.assertTrue(isElementPresent("signoff_lnk_cardPage_LINKTEXT"));
		Assert.assertTrue(getElementText("signoff_lnk_cardPage_LINKTEXT").contains(linkText));
		click("signoff_lnk_cardPage_LINKTEXT");
		Assert.assertTrue(isElementPresent("message_lbl_loginPage_ID"));
		Assert.assertTrue(getElementText("message_lbl_loginPage_ID").contains(message));
		Assert.assertTrue(isElementPresent("header_lbl_loginPage_XPATH"));
		Assert.assertTrue(getElementText("header_lbl_loginPage_XPATH").contains(header));

	}
}
