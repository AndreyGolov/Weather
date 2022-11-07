import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndreyGolovTest {

    @Test
    public void testURLandTitle_onGuidePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andre\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultURL = "https://openweathermap.org/guide";
        String expectedResultTitle = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement guideButton = driver.findElement(
                By.xpath("//nav[@id = 'nav-website']//ul[@id = 'first-level-nav']//a[text() = 'Guide']")
        );

        guideButton.click();

        String actualResultURL = driver.getCurrentUrl();
        String actualResultTitle = driver.getTitle();

        Assert.assertEquals(actualResultURL, expectedResultURL);
        Assert.assertEquals(actualResultTitle, expectedResultTitle);

        driver.quit();


    }

    @Test
    public void testTempInFahrenheit_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andre\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultCurrentWeatherImperial = "F";


        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement showTempInFahrenheit = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[@class = 'switch-container']//div[3]")
        );

        showTempInFahrenheit.click();

        WebElement currentTemp = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[@class = 'current-temp']//span")
        );


        String actualResultCurrentWeatherImperial
                = String.valueOf(currentTemp.getText().charAt(currentTemp.getText().length() - 1));

        Assert.assertEquals(actualResultCurrentWeatherImperial, expectedResultCurrentWeatherImperial);

        driver.quit();


    }

    @Test
    public void testCookiesWarning_OnMainPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andre\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultCookiesWarning = "We use cookies which are essential for the site to work. " +
                "We also use non-essential cookies to help us improve our services. " +
                "Any data collected is anonymised. You can allow all cookies or manage them individually.";
        String expectedResultAllowAllButton = "Allow all";
        String expectedResultManageCookiesButton = "Manage cookies";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement textCookieWarning = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//p")
        );

        String actualResult = textCookieWarning.getText();

        Assert.assertEquals(actualResult, expectedResultCookiesWarning);

        //div[@id = 'stick-footer-panel']//button

        WebElement allowAllButton = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//button")
        );

        String actualResultAllowAllButton = allowAllButton.getText();

        Assert.assertEquals(actualResultAllowAllButton, expectedResultAllowAllButton);

        WebElement manageCookiesButton = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//a")
        );

        String actualResultManageCookiesButton = manageCookiesButton.getText();

        Assert.assertEquals(actualResultManageCookiesButton, expectedResultManageCookiesButton);



        driver.quit();


    }







}