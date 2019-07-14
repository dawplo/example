package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.logging.Level;

public class DriverFactory {
    public static final int IMPLICIT_TIMEOUT = 15;
    public static final int EXPLICIT_TIMEOUT = 35;


    public static ChromeDriver driver;

    @BeforeClass
    public static void executeBeforeClass() {
        File file = new File("src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        setUp();
    }

    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(945, 1020));
        driver.setLogLevel(Level.INFO);
    }

    @AfterClass
        public static void executeAfterClass () {
            driver.quit();
        }

    }
