package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class FleetVerification {
	public WebDriver driver;
	public FleetVerification(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='AccountNo']//parent::div/preceding-sibling::div/span") WebElement FleetNbrlbl;
	@FindBy(xpath="//input[@id='AccountNo']/preceding-sibling::span") WebElement FleetNbr;
	
	@FindBy(xpath="//input[@id='CustomerType']//parent::div/preceding-sibling::div/span") WebElement FleetRegistrantTypelbl;
	@FindBy(xpath="//input[@id='CustomerType']") WebElement FleetRegistrantType;
	
	@FindBy(xpath="//input[@id='FleetNbr']//parent::div/preceding-sibling::div/span") WebElement FleetfltNbrlbl;
	@FindBy(xpath="//input[@id='FleetNbr']") WebElement FleetfltNbr;
	
	@FindBy(xpath="//input[@id='FltStatus']//parent::div/preceding-sibling::div/span") WebElement FleetfltStatuslbl;
	@FindBy(xpath="//input[@id='FltStatus']") WebElement FleetfltStatus;
	
	@FindBy(xpath="//input[@id='CarrierType']//parent::div/preceding-sibling::div/span") WebElement FleetCarriertypelbl;
	@FindBy(xpath="//input[@id='CarrierType']") WebElement FleetCarriertype;
	
	@FindBy(xpath="//input[@id='RegistrantName']//parent::div/preceding-sibling::div/span") WebElement FleetLegalNamelbl;
	@FindBy(xpath="//input[@id='RegistrantName']") WebElement FleetLegalName;
	
	@FindBy(xpath="//input[@id='DBA']//parent::div/preceding-sibling::div/span") WebElement FleetDBANamelbl;
	@FindBy(xpath="//input[@id='DBA']") WebElement FleetDBAName;
	
	@FindBy(xpath="//input[@id='Addressess_0__AddrLine1']//parent::div/preceding-sibling::div/span") WebElement FleetStreet0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__AddrLine1']") WebElement FleetStreet0;
	
	@FindBy(xpath="//input[@id='Addressess_0__Zip']//parent::div/preceding-sibling::div/span") WebElement FleetZip0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__Zip']") WebElement FleetZip0;
	
	@FindBy(xpath="//input[@id='Addressess_0__Jur']//parent::div/preceding-sibling::div/span") WebElement FleetJur0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__Jur']") WebElement FleetJur0;
	

	@FindBy(xpath="//input[@id='Addressess_0__City']//parent::div/preceding-sibling::div/span") WebElement FleetCity0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__City']") WebElement FleetCity0;
	
	@FindBy(xpath="//input[@id='Addressess_0__County']//parent::div/preceding-sibling::div/span") WebElement FleetCounty0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__County']") WebElement FleetCounty0;
	
	@FindBy(xpath="//input[@id='Addressess_0__Country']//parent::div/preceding-sibling::div/span") WebElement FleetCountry0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__Country']") WebElement FleetCountry0;
	
	@FindBy(xpath="//input[@id='Addressess_0__IsNonDeliverableAddr']//parent::div/preceding-sibling::div/span") WebElement FleetNonDeliverable0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__IsNonDeliverableAddr']") WebElement FleetNonDeliverable0;
	@FindBy(xpath="//input[@id='Addressess_1__addressOverridenFlag']//parent::div/preceding-sibling::div/span") WebElement FleetAddressOverridenlbl;;
	@FindBy(xpath="//input[@id='Addressess_1__addressOverridenFlag']") WebElement FleetAddressOverriden;
	
	@FindBy(xpath="//input[@id='Addressess_1__AddrLine1']//parent::div/preceding-sibling::div/span") WebElement FleetStreet1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__AddrLine1']") WebElement FleetStreet1;
	
	@FindBy(xpath="//input[@id='Addressess_1__Zip']//parent::div/preceding-sibling::div/span") WebElement FleetZip1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__Zip']") WebElement FleetZip1;
	
	@FindBy(xpath="//input[@id='Addressess_1__Jur']//parent::div/preceding-sibling::div/span") WebElement FleetJur1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__Jur']") WebElement FleetJur1;
	
	@FindBy(xpath="//input[@id='Addressess_1__City']//parent::div/preceding-sibling::div/span") WebElement FleetCity1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__City']") WebElement FleetCity1;
	
	@FindBy(xpath="//input[@id='Addressess_1__County']//parent::div/preceding-sibling::div/span") WebElement FleetCounty1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__County']") WebElement FleetCounty1;
	
	@FindBy(xpath="//input[@id='Addressess_1__Country']//parent::div/preceding-sibling::div/span") WebElement FleetCountry1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__Country']") WebElement FleetCountry1;
	
	@FindBy(xpath="//input[@id='Addressess_1__IsNonDeliverableAddr']//parent::div/preceding-sibling::div/span") WebElement FleetNonDeliverable1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__IsNonDeliverableAddr']") WebElement FleetNonDeliverable1;
	
	@FindBy(xpath="//input[@id='Addressess_1__AttnTo']//parent::div/preceding-sibling::div/span") WebElement FleetAttentionTOlbl;
	@FindBy(xpath="//input[@id='Addressess_1__AttnTo']") WebElement FleetAttentionTO;
	@FindBy(xpath="(//input[@id='Addressess_1__addressOverridenFlag'])[2]//parent::div/preceding-sibling::div/span") WebElement FleetAddressOverriden1lbl;;
	@FindBy(xpath="(//input[@id='Addressess_1__addressOverridenFlag'])[2]") WebElement FleetAddressOverriden1;
	
	@FindBy(xpath="//input[@id='reportingServices_ServiceProviderID']//parent::div/preceding-sibling::div/span") WebElement FleetServiceProviderlbl;
	@FindBy(xpath="//input[@id='reportingServices_ServiceProviderID']/preceding-sibling::span") WebElement FleetServiceProvider;
	
	@FindBy(xpath="//input[@id='reportingServices_LegalName']//parent::div/preceding-sibling::div/span") WebElement FleetServiceLegalNamelbl;
	@FindBy(xpath="//input[@id='reportingServices_LegalName']") WebElement FleetServiceLegalName;
	
	@FindBy(xpath="//input[@id='reportingServices_DBAName']//parent::div/preceding-sibling::div/span") WebElement FleetService_DBANamelbl;
	@FindBy(xpath="//input[@id='reportingServices_DBAName']") WebElement FleetService_DBAName;
	
	@FindBy(xpath="//input[@id='reportingServices_checkedPwrattoony']//parent::div/preceding-sibling::div/span") WebElement FleetService_PowerOfAttroneylbl;
	@FindBy(xpath="//input[@id='reportingServices_checkedPwrattoony']/preceding-sibling::span") WebElement FleetService_PowerOfAttroney;
	
	@FindBy(xpath="//input[@id='reportingServices_PowerOfAttEffDate']//parent::div/preceding-sibling::div/span") WebElement FleetService_PowerOfAttroneyEffDatelbl;
	@FindBy(xpath="//input[@id='reportingServices_PowerOfAttEffDate']") WebElement FleetService_PowerOfAttroneyEffDate;
	
	@FindBy(xpath="//input[@id='reportingServices_PowerOfAttExpDate']//parent::div/preceding-sibling::div/span") WebElement FleetService_PowerOfAttroneyExpDatelbl;
	@FindBy(xpath="//input[@id='reportingServices_PowerOfAttExpDate']") WebElement FleetService_PowerOfAttroneyExpDate;
	
	
	@FindBy(xpath="//input[@id='reportingServices_EmailID']//parent::div/preceding-sibling::div/span") WebElement FleetService_EmailIDlbl;
	@FindBy(xpath="//input[@id='reportingServices_EmailID']") WebElement FleetService_EmailID;
	
	@FindBy(xpath="//input[@id='reportingServices_PhoneNo']//parent::div/preceding-sibling::div/span") WebElement FleetService_PhoneNolbl;
	@FindBy(xpath="//input[@id='reportingServices_PhoneNo']") WebElement FleetService_PhoneNo;
	
	@FindBy(xpath="//input[@id='reportingServices_Fax']//parent::div/preceding-sibling::div/span") WebElement FleetService_FaxNolbl;
	@FindBy(xpath="//input[@id='reportingServices_Fax']") WebElement FleetService_FaxNo;
	
	@FindBy(xpath="//input[@id='reportingServices_Street1']//parent::div/preceding-sibling::div/span") WebElement FleetService_Streetlbl;
	@FindBy(xpath="//input[@id='reportingServices_Street1']") WebElement FleetService_Street;
	
	@FindBy(xpath="//input[@id='reportingServices_City']//parent::div/preceding-sibling::div/span") WebElement FleetService_Citylbl;
	@FindBy(xpath="//input[@id='reportingServices_City']") WebElement FleetService_City;
	
	@FindBy(xpath="//input[@id='reportingServices_Jur']//parent::div/preceding-sibling::div/span") WebElement FleetService_Jurlbl;
	@FindBy(xpath="//input[@id='reportingServices_Jur']") WebElement FleetService_Jur;
	
	@FindBy(xpath="//input[@id='reportingServices_ZipCode']//parent::div/preceding-sibling::div/span") WebElement FleetService_ZipCodelbl;
	@FindBy(xpath="//input[@id='reportingServices_ZipCode']") WebElement FleetService_ZipCode;
	
	@FindBy(xpath="//input[@id='reportingServices_Country']//parent::div/preceding-sibling::div/span") WebElement FleetService_Countrylbl;
	@FindBy(xpath="//input[@id='reportingServices_Country']") WebElement FleetService_Country;
	
	@FindBy(xpath="//input[@id='Addressess_2__AddrLine1']//parent::div/preceding-sibling::div/span") WebElement FleetServiceMailing_Streetlbl;
	@FindBy(xpath="//input[@id='Addressess_2__AddrLine1']") WebElement FleetServiceMailing_Street;
	
	@FindBy(xpath="//input[@id='Addressess_2__Zip']//parent::div/preceding-sibling::div/span") WebElement FleetServiceMailing_ZipCodelbl;
	@FindBy(xpath="//input[@id='Addressess_2__Zip']") WebElement FleetServiceMailing_ZipCode;
	
	@FindBy(xpath="//input[@id='Addressess_2__Jur']//parent::div/preceding-sibling::div/span") WebElement FleetServiceMailing_Jurlbl;
	@FindBy(xpath="//input[@id='Addressess_2__Jur']") WebElement FleetServiceMailing_Jur;
	
	@FindBy(xpath="//input[@id='Addressess_2__City']//parent::div/preceding-sibling::div/span") WebElement FleetServiceMailing_Citylbl;
	@FindBy(xpath="//input[@id='Addressess_2__City']") WebElement FleetServiceMailing_City;
	
	@FindBy(xpath="//input[@id='Addressess_2__County']//parent::div/preceding-sibling::div/span") WebElement FleetServiceMailing_Countylbl;
	@FindBy(xpath="//input[@id='Addressess_2__County']") WebElement FleetServiceMailing_County;
	
	@FindBy(xpath="//input[@id='Addressess_2__Country']//parent::div/preceding-sibling::div/span") WebElement FleetServiceMailing_Countrylbl;
	@FindBy(xpath="//input[@id='Addressess_2__Country']") WebElement FleetServiceMailing_Country;
	
	@FindBy(xpath="//input[@id='Addressess_2__AttnTo']//parent::div/preceding-sibling::div/span") WebElement FleetServiceMailing_AttentionTOlbl;
	@FindBy(xpath="//input[@id='Addressess_2__AttnTo']") WebElement FleetServiceMailing_AttentionTO;
	@FindBy(xpath="//input[@id='Addressess_2__addressOverridenFlag']//parent::div/preceding-sibling::div/span") WebElement FleetServiceMailing_AdsressOverriddenlbl;
	@FindBy(xpath="//input[@id='Addressess_2__addressOverridenFlag']") WebElement FleetServiceMailing_AdsressOverridden;
	
	@FindBy(xpath="//input[@id='ContactName']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_ContactNamelbl;
	@FindBy(xpath="//input[@id='ContactName']") WebElement FleetDetails_ContactName;
	
	@FindBy(xpath="//input[@id='Email']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_EmailIDlbl;
	@FindBy(xpath="//input[@id='Email']") WebElement FleetDetails_EmailID;
	
	@FindBy(xpath="//input[@id='PhoneNumber']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_PrimaryCellNbrlbl;
	@FindBy(xpath="//input[@id='PhoneNumber']") WebElement FleetDetails_PrimaryCellNbr;
	
	@FindBy(xpath="//input[@id='FlCellNbr']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_AlternateCellNbrlbl;
	@FindBy(xpath="//input[@id='FlCellNbr']") WebElement FleetDetails_AlternateCellNbr;
	
	@FindBy(xpath="//input[@id='FaxNo']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_FaxNolbl;
	@FindBy(xpath="//input[@id='FaxNo']") WebElement FleetDetails_FaxNo;
	
	@FindBy(xpath="//input[@id='TinNbr']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_TPIDlbl;
	@FindBy(xpath="//input[@id='TinNbr']") WebElement FleetDetails_TPID;
	
	@FindBy(xpath="//input[@id='UsdotNbr']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_UsdotNbrlbl;
	@FindBy(xpath="//input[@id='UsdotNbr']") WebElement FleetDetails_UsdotNbr;
	
	@FindBy(xpath="//input[@id='ChangeVehUsdotTin']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_ChangeVehUsdotTinlbl;
	@FindBy(xpath="//input[@id='ChangeVehUsdotTin']") WebElement FleetDetails_ChangeVehUsdotTin;
	
	@FindBy(xpath="//input[@id='FltType']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_FltTypelbl;
	@FindBy(xpath="//input[@id='FltType']") WebElement FleetDetails_FltType;
	
	@FindBy(xpath="//input[@id='CommodityClass']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_CommodityClasslbl;
	@FindBy(xpath="//input[@id='CommodityClass']") WebElement FleetDetails_CommodityClass;
	
	@FindBy(xpath="//input[@id='FltEffDate']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_FltEffDatelbl;
	@FindBy(xpath="//input[@id='FltEffDate']") WebElement FleetDetails_FltEffDate;
	
	@FindBy(xpath="//span[@class='confirmPageLabel' and text()='Expiration Date']") WebElement FleetDetails_FltExpDatelbl;
	@FindBy(xpath="//input[@id='FltExpDate']") WebElement FleetDetails_FltExpDate;
	
	@FindBy(xpath="//input[@id='changeAddrOnUsdot']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_changeAddrOnUsdotlbl;
	@FindBy(xpath="//input[@id='changeAddrOnUsdot']") WebElement FleetDetails_changeAddrOnUsdot;
	
	@FindBy(xpath="//input[@id='FirstOperationDate']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_FirstOperatedDatelbl;
	@FindBy(xpath="//input[@id='FirstOperationDate']") WebElement FleetDetails_FirstOperatedDate;
	
	@FindBy(xpath="//input[@id='WyIntraStF']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_WyomingIndicatorlbl;
	@FindBy(xpath="//input[@id='WyIntraStF']") WebElement FleetDetails_WyomingIndicator;
	
	@FindBy(xpath="//input[@id='IftaMileageChk']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_IFTADistancelbl;
	@FindBy(xpath="//input[@id='IftaMileageChk']") WebElement FleetDetails_IFTADistance;
	
	@FindBy(xpath="//input[@id='MobileIND']//parent::div/preceding-sibling::div/span") WebElement FleetDetails_MobileNotificationlbl;
	@FindBy(xpath="//input[@id='MobileIND']") WebElement FleetDetails_MobileNotification;
	
	//Document Collection
	@FindBy(xpath="//input[@id='IRPRequirementsForm']//parent::div/preceding-sibling::div/span") WebElement FleetDocCollection_IRPRequirementsFormlbl;
	@FindBy(xpath="//input[@id='IRPRequirementsForm']/preceding-sibling::span") WebElement FleetDocCollection_IRPRequirementsForm;
	
	@FindBy(xpath="//input[@id='StatementOfUnderstanding']//parent::div/preceding-sibling::div/span") WebElement FleetDocCollection_StatementOfUnderstandinglbl;
	@FindBy(xpath="//input[@id='StatementOfUnderstanding']/preceding-sibling::span") WebElement FleetDocCollection_StatementOfUnderstanding;
	
	@FindBy(xpath="//input[@id='InstallmentAgreement']//parent::div/preceding-sibling::div/span") WebElement FleetDocCollection_InstallmentAgreementlbl;
	@FindBy(xpath="//input[@id='InstallmentAgreement']/preceding-sibling::span") WebElement FleetDocCollection_InstallmentAgreement;
	
	@FindBy(xpath="//input[@id='PowerOfAttorney']//parent::div/preceding-sibling::div/span") WebElement FleetDocCollection_PowerOfAttorneylbl;
	@FindBy(xpath="//input[@id='PowerOfAttorney']/preceding-sibling::span") WebElement FleetDocCollection_PowerOfAttorney;
	
	//Vehicle Document 
	
	@FindBy(xpath="//input[@id='HVUTForm2290']//parent::div/preceding-sibling::div/span") WebElement FleetVehDocument_HVUTFormlbl;
	@FindBy(xpath="//input[@id='HVUTForm2290']/preceding-sibling::span") WebElement FleetVehDocument_HVUTForm;
	
	@FindBy(xpath="//input[@id='PropertyTaxVehDocument']//parent::div/preceding-sibling::div/span") WebElement FleetVehDocument_PropertyTaxlbl;
	@FindBy(xpath="//input[@id='PropertyTaxVehDocument']/preceding-sibling::span") WebElement FleetVehDocument_PropertyTax;
	
	
	public String FleetNbrlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetNbrlbl);
	}

	public String FleetNbr() {
		return ElementUtil.FetchTextBoxValuewithText(FleetNbr);
	}

	public String FleetRegistrantTypelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetRegistrantTypelbl);
	}

	public String FleetRegistrantType() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetRegistrantType,"value");
	}
	public String FleetfltNbrlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetfltNbrlbl);
	}

	public String FleetfltNbr() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetfltNbr,"value");
	}

	public String FleetfltStatuslbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetfltStatuslbl);
	}

	public String FleetfltStatus() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetfltStatus,"value");
	}
	public String FleetCarriertypelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetCarriertypelbl);
	}
	public String FleetCarriertype() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetCarriertype,"value");
	}

	public String FleetLegalNamelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetLegalNamelbl);
	}

	public String FleetLegalName() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetLegalName,"value");
	}
	public String FleetDBANamelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDBANamelbl);
	}

	public String FleetDBAName() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDBAName,"value");
	}
	public String FleetStreet0lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetStreet0lbl);
	}

	public String FleetStreet0() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetStreet0,"value");
	}
	
	public String FleetZip0lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetZip0lbl);
	}

	public String FleetZip0() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetZip0,"value");
	}
	public String FleetJur0lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetJur0lbl);
	}

	public String FleetJur0() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetJur0,"value");
	}
	public String FleetCity0lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetCity0lbl);
	}

	public String FleetCity0() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetCity0,"value");
	}
	public String FleetCounty0lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetCounty0lbl);
	}

	public String FleetCounty0() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetCounty0,"value");
	}
	public String FleetCountry0lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetCountry0lbl);
	}

	public String FleetCountry0() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetCountry0,"value");
	}
	public String FleetNonDeliverable0lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetNonDeliverable0lbl);
	}

	public String FleetNonDeliverable0() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetNonDeliverable0,"value");
	}
	public String FleetAddressOverridenlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetAddressOverridenlbl);
	}

	public String FleetAddressOverriden() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetAddressOverriden,"value");
	}
	
	public String FleetStreet1lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetStreet1lbl);
	}

	public String FleetStreet1() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetStreet1,"value");
	}
	
	public String FleetZip1lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetZip1lbl);
	}

	public String FleetZip1() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetZip1,"value");
	}
	public String FleetJur1lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetJur1lbl);
	}

	public String FleetJur1() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetJur1,"value");
	}
	public String FleetCity1lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetCity1lbl);
	}

	public String FleetCity1() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetCity1,"value");
	}
	public String FleetCounty1lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetCounty1lbl);
	}

	public String FleetCounty1() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetCounty1,"value");
	}
	public String FleetCountry1lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetCountry1lbl);
	}

	public String FleetCountry1() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetCountry1,"value");
	}
	public String FleetNonDeliverable1lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetNonDeliverable1lbl);
	}

	public String FleetNonDeliverable1() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetNonDeliverable1,"value");
	}
	public String FleetAttentionTOlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetAttentionTOlbl);
	}

	public String FleetAttentionTO() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetAttentionTO,"value");
	}
	
	public String FleetAddressOverriden1lbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetAddressOverriden1lbl);
	}

	public String FleetAddressOverriden1() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetAddressOverriden1,"value");
	}

	public String FleetServiceProviderlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceProviderlbl);
	}

	public String FleetServiceProvider() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceProvider);
	}
	public String FleetServiceLegalNamelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceLegalNamelbl);
	}

	public String FleetServiceLegalName() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceLegalName,"value");
	}
	public String FleetService_DBANamelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_DBANamelbl);
	}

	public String FleetService_DBAName() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_DBAName,"value");
	}
	public String FleetService_PowerOfAttroneylbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_PowerOfAttroneylbl);
	}

	public String FleetService_PowerOfAttroney() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_PowerOfAttroney);
	}
	public String FleetService_PowerOfAttroneyEffDatelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_PowerOfAttroneyEffDatelbl);
	}

	public String FleetService_PowerOfAttroneyEffDate() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_PowerOfAttroneyEffDate,"value");
	}
	public String FleetService_PowerOfAttroneyExpDatelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_PowerOfAttroneyExpDatelbl);
	}

	public String FleetService_PowerOfAttroneyExpDate() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_PowerOfAttroneyExpDate,"value");
	}
	
	public String FleetService_EmailIDlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_EmailIDlbl);
	}

	public String FleetService_EmailID() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_EmailID,"value");
	}
	public String FleetService_PhoneNolbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_PhoneNolbl);
	}

	public String FleetService_PhoneNo() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_PhoneNo,"value");
	}
	public String FleetService_FaxNolbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_FaxNolbl);
	}

	public String FleetService_FaxNo() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_FaxNo,"value");
	}
	public String FleetService_Streetlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_Streetlbl);
	}

	public String FleetService_Street() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_Street,"value");
	}
	public String FleetService_Citylbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_Citylbl);
	}

	public String FleetService_City() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_City,"value");
	}
	public String FleetService_Jurlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_Jurlbl);
	}

	public String FleetService_Jur() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_Jur,"value");
	}
	public String FleetService_ZipCodelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_ZipCodelbl);
	}

	public String FleetService_ZipCode() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_ZipCode,"value");
	}
	
	public String FleetService_Countrylbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetService_Countrylbl);
	}

	public String FleetService_Country() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetService_Country,"value");
	}
	public String FleetServiceMailing_Streetlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Streetlbl);
	}

	public String FleetServiceMailing_Street() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_Street,"value");
	}
	
	public String FleetServiceMailing_ZipCodelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_ZipCodelbl);
	}

	public String FleetServiceMailing_ZipCode() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_ZipCode,"value");
	}
	public String FleetServiceMailing_Jurlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Jurlbl);
	}

	public String FleetServiceMailing_Jur() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_Jur,"value");
	}
	public String FleetServiceMailing_Citylbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Citylbl);
	}

	public String FleetServiceMailing_City() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_City,"value");
	}
	public String FleetServiceMailing_Countylbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Countylbl);
	}
	public String FleetServiceMailing_County() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_County,"value");
	}
	public String FleetServiceMailing_Countrylbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Countrylbl);
	}

	public String FleetServiceMailing_Country() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_Country,"value");
	}
	public String FleetServiceMailing_AttentionTOlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_AttentionTOlbl);
	}

	public String FleetServiceMailing_AttentionTO() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_AttentionTO,"value");
	}
	public String FleetServiceMailing_AdsressOverriddenlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_AdsressOverriddenlbl);
	}
	public String FleetServiceMailing_AdsressOverridden() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_AdsressOverridden,"value");
	}
	
	public String FleetDetails_ContactNamelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_ContactNamelbl);
	}

	public String FleetDetails_ContactName() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_ContactName,"value");
	}
	public String FleetDetails_EmailIDlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_EmailIDlbl);
	}
	public String FleetDetails_EmailID() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_EmailID,"value");
	}
	public String FleetDetails_PrimaryCellNbrlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_PrimaryCellNbrlbl);
	}

	public String FleetDetails_PrimaryCellNbr() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_PrimaryCellNbr,"value");
	}
	public String FleetDetails_AlternateCellNbrlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_AlternateCellNbrlbl);
	}

	public String FleetDetails_AlternateCellNbr() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_AlternateCellNbr,"value");
	}
	public String FleetDetails_FaxNolbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FaxNolbl);
	}
	public String FleetDetails_FaxNo() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FaxNo,"value");
	}
	public String FleetDetails_TPIDlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_TPIDlbl);
	}

	public String FleetDetails_TPID() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_TPID,"value");
	}
	public String FleetDetails_UsdotNbrlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_UsdotNbrlbl);
	}
	public String FleetDetails_UsdotNbr() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_UsdotNbr,"value");
	}
	public String FleetDetails_ChangeVehUsdotTinlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_ChangeVehUsdotTinlbl);
	}

	public String FleetDetails_ChangeVehUsdotTin() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_ChangeVehUsdotTin,"value");
	}
	public String FleetDetails_FltTypelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FltTypelbl);
	}

	public String FleetDetails_FltType() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FltType,"value");
	}
	public String FleetDetails_CommodityClasslbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_CommodityClasslbl);
	}
	public String FleetDetails_CommodityClass() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_CommodityClass,"value");
	}
	public String FleetDetails_FltEffDatelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FltEffDatelbl);
	}

	public String FleetDetails_FltEffDatedtPicker() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FltEffDate,"value");
	}
	public String FleetDetails_FltExpDatelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FltExpDatelbl);
	}
	public String FleetDetails_FltExpDate() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FltExpDate,"value");
	}
	public String FleetDetails_changeAddrOnUsdotlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_changeAddrOnUsdotlbl);
	}

	public String FleetDetails_changeAddrOnUsdot() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_changeAddrOnUsdot,"value");
	}
	public String FleetDetails_FirstOperatedDatelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FirstOperatedDatelbl);
	}

	public String FleetDetails_FirstOperatedDate() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FirstOperatedDate,"value");
	}
	public String FleetDetails_WyomingIndicatorlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_WyomingIndicatorlbl);
	}
	public String FleetDetails_WyomingIndicator() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_WyomingIndicator,"value");
	}
	public String FleetDetails_IFTADistancelbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_IFTADistancelbl);
	}

	public String FleetDetails_IFTADistance() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_IFTADistance,"value");
	}
	public String FleetDetails_MobileNotificationlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDetails_MobileNotificationlbl);
	}
	public String FleetDetails_MobileNotification() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_MobileNotification,"value");
	}
	
	public String FleetDocCollection_IRPRequirementsFormlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_IRPRequirementsFormlbl);
	}
	public String FleetDocCollection_IRPRequirementsForm() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_IRPRequirementsForm);
	}
	public String FleetDocCollection_StatementOfUnderstandinglbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_StatementOfUnderstandinglbl);
	}
	public String FleetDocCollection_StatementOfUnderstanding() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_StatementOfUnderstanding);
	}
	public String FleetDocCollection_InstallmentAgreementlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_InstallmentAgreementlbl);
	}
	public String FleetDocCollection_InstallmentAgreement() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_InstallmentAgreement);
	}
	public String FleetDocCollection_PowerOfAttorneylbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_PowerOfAttorneylbl);
	}
	public String FleetDocCollection_PowerOfAttorney() {
		return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_PowerOfAttorney);
	}
	public String FleetVehDocument_HVUTFormlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetVehDocument_HVUTFormlbl);
	}
	public String FleetVehDocument_HVUTForm() {
		return ElementUtil.FetchTextBoxValuewithText(FleetVehDocument_HVUTForm);
	}
	public String FleetVehDocument_PropertyTaxlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetVehDocument_PropertyTaxlbl);
	}
	public String FleetVehDocument_PropertyTax() {
		return ElementUtil.FetchTextBoxValuewithText(FleetVehDocument_PropertyTax);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
