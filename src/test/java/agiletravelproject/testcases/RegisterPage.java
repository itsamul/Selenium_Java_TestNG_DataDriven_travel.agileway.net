package agiletravelproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import agiletravelproject.base.BaseTest;
import utilities.DataUtil;

public class RegisterPage extends BaseTest {

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 1)
	public void testVerifyingRegisterPage(String header) {
		click("register_btn_common_LINKTEXT");
		Assert.assertTrue(isElementPresent("header_lbl_registerPage_XPATH"));
		Assert.assertEquals(getElementText("header_lbl_registerPage_XPATH"), header);
	}

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class, priority = 2)
	public void testVerifyingLoginPage(String header) {
		click("login_btn_common_LINKTEXT");
		Assert.assertTrue(isElementPresent("header_lbl_loginPage_XPATH"));
		Assert.assertEquals(getElementText("header_lbl_loginPage_XPATH"), header);
	}

}