package PageObject;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Tools.DateTimeManager;
import Tools.MyDriver;
import Tools.PropertiesManager;

public class T4_event_create_page {
	// https://ticketweb.com.tweb.twqa1.websys.tmcs/web-client/org/141342/create/1001/1/false/createEvent.tw

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"createEventForm:submitCreateButton\"]")
	@CacheLookup
	WebElement submitCreateButton;

	// Below elements are for "EVENT DETAILS"

	@FindBy(how = How.ID, using = "createEventForm:start_date_input")
	WebElement startDate;

	@FindBy(how = How.ID, using = "createEventForm:start_time_input")
	WebElement startTime;

	@FindBy(how = How.ID, using = "createEventForm:end_date_input")
	WebElement endDate;

	@FindBy(how = How.ID, using = "createEventForm:end_time_input")
	WebElement endTime;

	@FindBy(how = How.ID, using = "createEventForm:doorsDate_input")
	WebElement doorDate;

	@FindBy(how = How.ID, using = "createEventForm:doorsTime_input")
	WebElement doorTime;

	@FindBy(how = How.ID, using = "createEventForm:announceDate_input")
	WebElement announceDate;

	@FindBy(how = How.ID, using = "createEventForm:announceTime_input")
	WebElement announceTime;

	@FindBy(how = How.ID, using = "createEventForm:onSaleDate_input")
	WebElement onSaleDate;

	@FindBy(how = How.ID, using = "createEventForm:onSaleTime_input")
	WebElement onSaleTime;

	@FindBy(how = How.ID, using = "createEventForm:offSaleDate_input")
	WebElement offSaleDate;

	@FindBy(how = How.ID, using = "createEventForm:offSaleTime_input")
	WebElement offSaleTime;

	// Elements for "DISPLAY OPTIONS"

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:opt1']/div[2]/span")
	WebElement fullDateAndTime;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:opt2']/div[2]/span")
	WebElement doorTimeOnly;

	// Elements for "VENUE"

	@FindBy(how = How.NAME, using = "createEventForm:venueName:venueNameInput_input")
	WebElement venueName;

	@FindBy(how = How.ID, using = "createEventForm:ticketLimit")
	WebElement ticketLimit;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:popt1']/div[2]/span")
	WebElement allAges;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:popt2']/div[2]/span")
	WebElement ageLimit18;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:popt23']/div[2]/span")
	WebElement ageLimit21;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:popt4']/div[2]/span")
	WebElement custom;

	// Elements for "DISPLAY NAME AND ATTRACTIONS
	@FindBy(how = How.ID, using = "createEventForm:attractionFullList:0:attractionName_input")
	WebElement attractionNameTextfiled;

	@FindBy(how = How.NAME, using = "createEventForm:eventDisplayNameWrap:eventDisplayName")
	WebElement eventDisplayName;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:placeHolderDummyName']/span")
	WebElement addAttraction;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:attractionFullList_content']/ul/li[2]/div/div")
	WebElement attractionTable;

	@FindBy(how = How.ID, using = "additionalInfo-showme")
	WebElement addEventDescription; // This is seen as "ADDITIONAL INFORMATION" tab under 'Event Display Name'
									// section

	// Elements for "TICKETING" section

	@FindBy(how = How.ID, using = "createEventForm:inventory:sectionList:0:inventory:general_admission")
	WebElement sectionName0;

	@FindBy(how = How.ID, using = "createEventForm:inventory:sectionList:0:inventory:j_idt518:j_idt519")
	WebElement sectionPrice0;

	@FindBy(how = How.ID, using = "createEventForm:inventory:sectionList:0:inventory:section_capaticy")
	WebElement sectionCap0; // Section's Capacity

	@FindBy(how = How.ID, using = "createEventForm:inventory:sectionList:0:inventory:pricing_discription")
	WebElement sectionDesc0; // Section's Description

	@FindBy(how = How.ID, using = "createEventForm:inventory:placeHolderSectionName")
	WebElement createNewSectionTextField;

	// Element for "Publish to Facebook"

	@FindBy(how = How.XPATH, using = "//div[@id='createEventForm:fbOfficialpublishable']/div[3]/span")
	WebElement faceBookPublishDropdown;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:fbOfficialpublishable_panel']/div/ul/li[1]")
	WebElement fbAccountDefaultSelection;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:fbOfficialpublishable_panel']/div/ul/li[2]")
	WebElement fbPublishSelection;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:fbOfficialpublishable_panel']/div/ul/li[3]")
	WebElement fbDontPublishSelection;

	// Element for "NOTES"

	@FindBy(how = How.ID, using = "createEventForm:eventNotesId")
	WebElement notes;

	// Elements for OPTIONS

	@FindBy(how = How.ID, using = "createEventForm:ticketLimit")
	WebElement eventTicketLimit;

	// Elements for EDP Type Drop-down

	@FindBy(how = How.XPATH, using = "//div[@id='createEventForm:eventDetailPageTypeId']/div[3]/span")
	WebElement edpTypeDropdown;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:eventDetailPageTypeId_panel']/div/ul/li[1]")
	WebElement edpTypeT3Selection;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:eventDetailPageTypeId_panel']/div/ul/li[2]")
	WebElement edpTypeT4Selection; // Selecting T4

//	    Elements for settlement types.
	@FindBy(how = How.XPATH, using = "//div[@id='createEventForm:settlementCode']/div[3]/span")
	WebElement settlementTypeDropdown;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:settlementCode_panel']/div/ul/li[2]")
	WebElement settlementType;

	// Checkout type
	@FindBy(how = How.XPATH, using = "//div[@id='createEventForm:checkOutChannelType']/div[3]/span")
	WebElement checkoutTypeDropdown;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:checkOutChannelType_panel']/div/ul/li[1]")
	WebElement checkoutTypeT3Selection;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:checkOutChannelType_panel']/div/ul/li[2]")
	WebElement checkoutTypeT4Selection;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:checkOutChannelType_panel']/div/ul/li[3]")
	WebElement checkoutTypeHostedSelection;

	// Elements for "CREATE EVENT" i.e completion of new event (Submitting/Saving
	// new event)

	@FindBy(how = How.ID, using = "createEventForm:submitCreateButton")
	WebElement createEventSave;

	@FindBy(how = How.ID, using = "createEventForm:submitUpdateButton")
	WebElement updateEventSave;

	@FindBy(how = How.CLASS_NAME, using = "warn-icon-wrap")
	List<WebElement> errorField;

	@FindBy(how = How.XPATH, using = ".//*[@id='createEventForm:deliveryOptions']/tbody/tr[9]/td[1]/div/div[2]/span")
	WebElement willCallCheckbox;

	@FindBy(how = How.XPATH, using = "//div[@id='createEventForm:auto_enable']/div[2]/span")
	WebElement autoEnableWillCallOptn;

	@FindBy(how = How.XPATH, using = "//*[@id='createEventForm:hiddenCheckBox']/span")
	WebElement hideEventBtn;

	public void inputBasicEventInformation() {
		String eventDisplayName0 = "alam test " + new Date();
//		System.out.println(startDate.isDisplayed());
//		while (!startDate.isDisplayed()) {
//			try {
//				Thread.sleep(1111);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		inputDateTime(startDate, startTime, 1, 30);
		inputDateTime(announceDate, announceTime, 0, 30);
		inputDateTime(onSaleDate, onSaleTime, 0, 30);
		inputFiledbyEnter(venueName, "Danny Test Venue");
		inputFiledbyEnter(attractionNameTextfiled, "ASD");
		inputFiledbyEnter(eventDisplayName, eventDisplayName0);
		sectionName0.sendKeys("Section 1");
		sectionCap0.sendKeys("999");
		sectionPrice0.sendKeys("11");
		ClicksubmitCreateButton();

//		if (checkUrlDomain("au")) {
//
//		} else if (checkUrlDomain("ie") || checkUrlDomain("uk")) {
//			// need Settlement flag for IE
//			selectSettlementFlag();
//		}
	}

	public void inputDateTime(WebElement input1, WebElement input2, int addOrMinus, int days) {

		input1.clear();
		if (addOrMinus == 1) {
			input1.sendKeys(DateTimeManager.AddDateByDates(days));
		} else if (addOrMinus == 0) {
			input1.sendKeys(DateTimeManager.MinusDateByDates(days));
		} else {
			System.out.println("addOrMinus 0 for minus , 1 for add");
		}
		input2.clear();
		input2.sendKeys(DateTimeManager.CurrentTime());
		try {
			Thread.sleep(1111);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inputFiledbyEnter(WebElement element, String Content) {
		element.clear();
		element.sendKeys(Content);
		try {
			Thread.sleep(3333);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.sendKeys(Keys.ENTER);
	}

	public T4_event_create_page(WebDriver driver) {
		this.driver = driver;
		driver.get(PropertiesManager.GetValueByKey("T4_Create_Event_Url"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public T4_Event_list_page ClicksubmitCreateButton() {

		submitCreateButton.click();
		return new T4_Event_list_page(driver);
	}

	public static void main(String[] args) {

		WebDriver driver = MyDriver.MyChromeDriver();
		T4_login_page lg = PageFactory.initElements(driver, T4_login_page.class);
		lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), PropertiesManager.GetValueByKey("T4_login_PWD"));
		T4_event_create_page cp = PageFactory.initElements(driver, T4_event_create_page.class);
		cp.inputBasicEventInformation();

//		T4_Client_Org_Dashboard_page od = PageFactory.initElements(driver, T4_Client_Org_Dashboard_page.class);
//		od.AccessTop("event");
//		T4_Event_list_page ep = PageFactory.initElements(driver, T4_Event_list_page.class);
//		ep.ClickCreateEventBtn();

	}

}
