package applications.way2automate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends AbstractPage {



    public AccountPage(WebDriver driver){
        super(driver);
    }

    // DEPOSIT LINKS
    private final By depositLink = By.xpath("//button[contains(.,'Deposit')]");
    private final By depositInput = By.xpath("//label[text()='Amount to be Deposited :']/following-sibling::input");
    private final By depositBtn = By.xpath("//button[text()='Deposit']");
    private final By successMessage = By.xpath("//span[text()='Deposit Successful']");
    private final By accountSelector = By.id("accountSelect");


    // WITHDRAWAL LINKS
    private final By withDrawalLink = By.xpath("//button[contains(.,'Withdrawl')]");
    private final By withDrawalInput = By.xpath("//label[text()='Amount to be Withdrawn :']/following-sibling::input");
    private final By withDrawalbtn = By.xpath("//button[text()='Withdraw']");
    private final By withDrawalMsg = By.xpath("//span[text()='Transaction successful']");
    private final By withDrawalAccSelector = By.id("accountSelect");


    public boolean makeDeposit(int amount,String accountNumber){

        scw.selectFromDropdown(accountSelector, accountNumber);
        scw.click(depositLink);
        scw.sendKeys(depositInput, amount + "");
        scw.click(depositBtn);

        return scw.findOne(successMessage).isDisplayed();

    }

    public boolean makeWithdrawal(int amount,String accountNumber){

        scw.selectFromDropdown(withDrawalAccSelector, accountNumber);
        scw.click(withDrawalLink);
        scw.sendKeys(withDrawalInput, amount + "");
        scw.click(withDrawalbtn);

        return scw.findOne(withDrawalMsg).isDisplayed();

    }
}
