import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class GadgetsPage {
    WebDriver driver;
    String str;

    public void open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.dns-shop.ru/");
    }
    public void closeConfirmCityModal() throws InterruptedException {
        WebElement confirmCity = driver.findElement(By.className("v-confirm-city"));
        WebElement confirmCityBtn = driver.findElement(By.xpath("/html/body/header/div[2]/div/ul[1]/li[1]/div/div/div[2]/div[1]/div/button[1]"));
        if (confirmCity.isDisplayed()) {
            confirmCityBtn.click();
            Thread.sleep(2000);
        }
    }

    public void pointCategory() throws InterruptedException {

        List<WebElement> a = driver.findElements(By.cssSelector("a.ui-link.menu-desktop__root-title"));
        a.remove(12);

            Random random = new Random();
            WebElement randElement = a.get(random.nextInt(a.size()));
            Actions action = new Actions(driver);
            action.moveToElement(randElement).perform();
            Thread.sleep(2000);

    }

    public void pointSubcategory() throws InterruptedException {
        List<WebElement> a = driver.findElements(By.cssSelector("a.ui-link.menu-desktop__second-level:nth-child(n)"));

        Random random = new Random();
        WebElement randElement = a.get(random.nextInt(a.size()));
        Actions action = new Actions(driver);
        action.moveToElement(randElement).perform();
        action.moveToElement(randElement).build().perform();
        int number = Integer.parseInt(randElement.getText().replaceAll("[^0-9]", ""));
        str = (number + " == ");
        Thread.sleep(2000);
            
    }
    
    public void chooseItemWithLastCategory() throws InterruptedException {
        List<WebElement> a = driver.findElements(By.cssSelector("a.ui-link.menu-desktop__second-level:nth-child(n)"));
        for (int i=0; i<a.size(); i++) {
            try {
                pointLastCategory();
                break;
            }
            catch (IllegalArgumentException ex) {
                pointSubcategory();
            }
        }

    }


    public void printStatistic() {
        List<WebElement> a = driver.findElements(By.cssSelector("a.ui-link.menu-desktop__popup-link:nth-child(n)"));
        

        
        for (WebElement element: a) {

            int number = 0;
            if (a.size()>1) {
                number = Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));
                str+=number + " + ";

            } else {
                number = Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));
                System.out.print(number);
            }
            
        }
        
        if (str.endsWith(" + ")) {
            str = str.substring(0, str.length() - 3);
        }
        
        System.out.println(str);

    }

    public void pointLastCategory() {
        List<WebElement> a = driver.findElements(By.cssSelector("a.ui-link.menu-desktop__popup-link:nth-child(n)"));
        Random random = new Random();
        WebElement randElement = a.get(random.nextInt(a.size()));
        Actions action = new Actions(driver);
        action.moveToElement(randElement).perform();
        action.moveToElement(randElement).build().perform();
    }
}





