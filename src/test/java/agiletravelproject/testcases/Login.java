package agiletravelproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import agiletravelproject.base.BaseTest;
import utilities.DataUtil;

public class Login extends BaseTest {

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 1)
	public void testInvalidLogin(String username, String password, String message) {
		type("username_tbx_loginPage_ID", username);
		type("password_tbx_loginPage_ID", password);
		click("signIn_btn_loginPage_XPATH");
		Assert.assertTrue(isElementPresent("alert_lbl_loginPage_ID"));
		Assert.assertEquals(getElementText("alert_lbl_loginPage_ID"), message);
	}

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 2)
	public void testValidLogin(String username, String password, String message) {
		type("username_tbx_loginPage_ID", username);
		type("password_tbx_loginPage_ID", password);
		click("signIn_btn_loginPage_XPATH");
		Assert.assertTrue(isElementPresent("message_lbl_selectPage_ID"));
		Assert.assertEquals(getElementText("message_lbl_selectPage_ID"), message);
	}
}