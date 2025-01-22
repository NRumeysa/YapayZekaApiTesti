package pages;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BasePage {
    protected static final String BASE_URL = "https://reqres.in/api";
    protected RequestSpecification request;
    protected Response response;
    protected static WebDriver driver;

    public BasePage() {
        request = given()
                .baseUri(BASE_URL)
                .contentType("application/json");
    }

    public static void initializeDriver() {
        try {
            System.out.println("WebDriver başlatma işlemi başlıyor...");
            System.out.println("Chrome versiyonu kontrol ediliyor...");
            
            if (driver == null) {
                WebDriverManager.chromedriver().clearDriverCache().setup();
                System.out.println("WebDriverManager setup tamamlandı");
                
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--headless"); // Headless mod ekledik
                
                System.out.println("Chrome options ayarlandı");
                
                // Detaylı loglama
                System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
                System.setProperty("webdriver.chrome.verboseLogging", "true");
                
                try {
                    System.out.println("ChromeDriver oluşturuluyor...");
                    driver = new ChromeDriver(options);
                    System.out.println("ChromeDriver başarıyla oluşturuldu");
                    
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                    driver.manage().window().maximize();
                    System.out.println("Driver ayarları tamamlandı");
                } catch (Exception e) {
                    System.out.println("ChromeDriver oluşturulurken hata: " + e.getMessage());
                    e.printStackTrace();
                    throw e;
                }
            }
        } catch (Exception e) {
            System.out.println("WebDriver başlatılırken hata oluştu: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
} 