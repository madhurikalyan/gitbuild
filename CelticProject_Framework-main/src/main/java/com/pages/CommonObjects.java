package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

public class CommonObjects {
	public WebDriver driver;
	ExcelReader reader = new ExcelReader();
	public CommonObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//div[@class='PageHeader row']//h3)[1]") WebElement lefthdr;  //Account Details,FleetDetails ,Distance Details, Weight Group Selection Details, 
	//Renewal Vehicle Processing, Vehicle Details
	@FindBy(xpath="(//div[@class='PageHeader row']//h3)[2]") WebElement Righthdr; //Renew Fleet
	
	//get values by using element.getattribute("value")
		@FindBy(xpath="//div[@id='myPopover']/ul//input[@id='supplementVM_RegistrantName']") WebElement Registrationvalue;
		@FindBy(xpath="//div[@id='myPopover']/ul//input[@id='supplementVM_AccountNO']") WebElement AccountNovalue;
		@FindBy(xpath="//div[@id='myPopover']/ul//input[@id='supplementVM_FleetNo']") WebElement FleetNovalue;
		@FindBy(xpath="//div[@id='myPopover']/ul//input[@id='supplementVM_FleetExpiryMonth']") WebElement FleetExpMonthvalue;
		@FindBy(xpath="//div[@id='myPopover']/ul//input[@id='supplementVM_FleetExpiryYear']") WebElement FleetExpYearvalue;
		@FindBy(xpath="//div[@id='myPopover']/ul//input[@id='supplementVM_SupplementNo']") WebElement SupplementNovalue;
		
		//...+
		@FindBy(xpath="//div[@id='myPopover']/ul//li[@tabindex='0']") WebElement DotsTab;
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_AccountNO']") WebElement collapseAccountNolbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//input[@id='supplementVM_AccountNO']/preceding-sibling::span[@class='view-text']") WebElement collapseAccountNovalue;
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_FleetNo']") WebElement collapseFleetNolbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_FleetNo']/following-sibling::span[@class='font-medium']") WebElement collapseFleetNovalue;
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//span[@class='confirmPageLabel']") WebElement collapseFleetExpyearlbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//span[@class='confirmPageLabel']/following-sibling::span[@class='font-medium']") WebElement collapseFleetExpyearvalue;
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_SupplementNo']") WebElement collapseSupplementNolbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_SupplementNo']/following-sibling::span[@class='font-medium']") WebElement collapseSupplementNovalue;
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_Tin']") WebElement collapseSupplementTINlbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//input[@id='supplementVM_AccountNO']/preceding-sibling::span[@class='view-text']") WebElement collapseSupplementTinvalue; 
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_USDOTNo']") WebElement collapseUSDOTlbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//input[@id='supplementVM_USDOTNo']/preceding-sibling::span[@class='view-text']") WebElement collapseUSDOTvalue;
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_RegistrantName']") WebElement collapseRegistrationNamelbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_RegistrantName']/following-sibling::span[@class='font-medium']") WebElement collapseRegistrationnamevalue;
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_DBA']") WebElement collapseDBANamelbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//input[@id='supplementVM_DBA']/preceding-sibling::span[@class='view-text']") WebElement collapseDBANamevalue;
		
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_FleetType']") WebElement collapseFleetTypelbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//input[@id='supplementVM_FleetType']/preceding-sibling::span[@class='view-text']") WebElement collapseFleetTypevalue;
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_SupplementEffDate']") WebElement collapseSupplementEfeDatelbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//input[@id='supplementVM_SupplementEffDate']/preceding-sibling::span[@class='view-text']") WebElement collapseSupplementEfeDatevalue;
		
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_SupplementDesc']") WebElement collapseSupplementDesclbl;
		@FindBy(xpath="//div[@class='popoverWrapperList']//label[@for='supplementVM_SupplementDesc']/following-sibling::span[@class='font-medium']") WebElement collapseSupplementDescvalue;
		
		
		//Comments
		@FindBy(xpath="//div[@class='bottom-comments']//a[contains(text(),'omments')]") WebElement Commentssubhdr;
		@FindBy(xpath="//label[@for='editComment_CommentTxtcommentsVM1']") WebElement Commentlbl;
		@FindBy(xpath="//textarea[@id='editComment_CommentTxtcommentsVM1']") WebElement Commenttxt;
		@FindBy(xpath="//label[@for='DefaultAccessLevelcommentsVM1']") WebElement AccessLevellbl;
		@FindBy(xpath="//select[@id='DefaultAccessLevelcommentsVM1']") WebElement AccessLeveldd;
		@FindBy(xpath="//div[@class='delete-comments']/label") WebElement DeleteAllowedCommentlbl;
		@FindBy(xpath="//input[@id='editComment_DelAllowedcommentsVM1']") WebElement DeleteAllowedCommentchk;
		
		@FindBy(xpath="//input[@id='addUpdateCommentBtncommentsVM1']") WebElement AddorUpdateCommentbtn;
		@FindBy(xpath="//input[@id='refreshCommentBtncommentsVM1']") WebElement RefreshCommentbtn;
		
		//comment table section
		@FindBy(xpath="//tr[@class='myCommentTableHeader']/th[1]") WebElement CommentEditDeletetbl;
		@FindBy(xpath="//tr[@class='myCommentTableHeader']/th[2]") WebElement CommentTexttbl;
		@FindBy(xpath="//tr[@class='myCommentTableHeader']/th[3]") WebElement CommentTimeStamptbl;
		@FindBy(xpath="//tr[@class='myCommentTableHeader']/th[4]") WebElement CommentuserIDtbl;
		@FindBy(xpath="//a[contains(@href,'Editcomment')]") WebElement CommentEditimg;
		@FindBy(xpath="//a[contains(@href,'Deletecomment')]") WebElement CommentDeleteimg;
		@FindBy(xpath="//td[contains(@id,'CommentTxt_0')]") WebElement CommententeredTextvalue;
		@FindBy(xpath="//td[contains(@id,'LastUpdT')]") WebElement CommentTimestampvalue;
		@FindBy(xpath="//td[contains(@id,'Userid')]") WebElement CommentUseridvalue;
		
		
		@FindBy(xpath="//input[@id='btnProceed']") WebElement Proceedbtn;
		@FindBy(xpath="//input[@id='btnRefresh']") WebElement Refershbtn;
		@FindBy(xpath="//input[@id='btnQuit']") WebElement Quitbtn;
		@FindBy(xpath="//input[@id='btnDone']") WebElement Donebtn;
		@FindBy(xpath="//input[@id='btnBack']") WebElement Backbtn;
		@FindBy(xpath="//input[@id='btnHelp']") WebElement Helpbtn;
		@FindBy(xpath="//input[@id='btnCancel']") WebElement Cancelbtn;
		@FindBy(xpath="//input[@id='btnConfirmCancel']") WebElement ConfirmCancelbtn;
		@FindBy(xpath="//input[@id='btnGoToWeightGroupSelection']") WebElement WeightGroupSelectionbtn;
		@FindBy(xpath="//input[@id='btnDeleteWeightGroup']") WebElement DeleteWeightGroupbtn;
		
		@FindBy(xpath="//ul[@class='errorMessage']//span") WebElement ErrorMessage;
		@FindBy(xpath="//div[contains(@class,'alert-info')]") WebElement InformationMessage;
		@FindBy(xpath="//div[contains(@class,'alert-info')]//li//span") List<WebElement> InfoMsgs;
		//Reinstatement
	
		
		public void expandCommentSection() throws Exception {
			if(ElementUtil.FetchTextBoxValuewithattribute(Commentssubhdr,"aria-expanded").equalsIgnoreCase("false")) {
			//ElementUtil.clickElementUsingJavscriptExecutor(Commentssubhdr);
			ElementUtil.scrollToViewAndClickElement(Commentssubhdr);
			//ElementUtil.clickElementUsingActions(Commentssubhdr);
			//ElementUtil.waitUntilElementClickable(Commentssubhdr);
			//ElementUtil.clickElement(Commentssubhdr);
			}
		}		
		public void enterComments(String commentsvalue) {
			ElementUtil.webEditTxtChange(Commenttxt,commentsvalue);
		}
		public void selectaccesslevel(String accesslevelvalue) {
			ElementUtil.selectFromDropdownByVisibleText(AccessLeveldd,accesslevelvalue);
		}
		public void checkDeleteAllowed() {
			ElementUtil.webCheckON(DeleteAllowedCommentchk);
		}
		public void clickAddorUpdateComment() {
			ElementUtil.waitUntilElementClickable(AddorUpdateCommentbtn);
			ElementUtil.clickElement(AddorUpdateCommentbtn);
		}
		public void clickClearComment() {
			ElementUtil.waitUntilElementClickable(RefreshCommentbtn);
			ElementUtil.clickElement(RefreshCommentbtn);
		}
		public void clickProceed() throws InterruptedException {
			ElementUtil.waitUntilElementClickable(Proceedbtn);
			ElementUtil.clickElement(Proceedbtn);
			Thread.sleep(2000);
		}
		public void ClickConfirmCancel() {
			ElementUtil.waitUntilElementClickable(ConfirmCancelbtn);
			ElementUtil.clickElement(ConfirmCancelbtn);
		}
		public void clickRefresh() {
			ElementUtil.waitUntilElementClickable(Refershbtn);
			ElementUtil.clickElement(Refershbtn);
		}
		public void clickQuit() {
			ElementUtil.waitUntilElementClickable(Quitbtn);
			ElementUtil.clickElement(Quitbtn);
		}
		public void clickBack() {
			ElementUtil.waitUntilElementClickable(Backbtn);
			ElementUtil.clickElement(Backbtn);
		}
		public void clickCancelbtn() {
			ElementUtil.waitUntilElementClickable(Cancelbtn);
			ElementUtil.clickElement(Cancelbtn);
		}
		public void clickDonebtn() throws Exception {
			ElementUtil.waitUntilElementClickable(Donebtn);
		//	ElementUtil.clickElement(Donebtn);
			ElementUtil.clickElementIgnoreStaleElementReferenceException(Donebtn);
		}
		public void validateErrorMessage(String errormessagevalue) {
			if(ErrorMessage.getText().contains(errormessagevalue))
				assert true;
			
		}
		public void validateInfoMessage(String inforMsg) {
			if(InformationMessage.getText().contains(inforMsg)) {
				System.out.println("true");
				System.out.println("InformationMessage"+ InformationMessage.getText());
			assert true;
			}
		}
	public ArrayList<String> validateinfomsgs() {
		ArrayList<String> InfoMsgs_Array = new ArrayList<String>();
		for(int i=0;i<InfoMsgs.size();i++) {
			InfoMsgs_Array.add(InfoMsgs.get(i).getText());	
		}
		return InfoMsgs_Array;
	}
}
