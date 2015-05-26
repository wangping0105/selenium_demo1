package www.wpwl.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

	//input 框的值的添加
	public static void setKeysForInputText(WebDriver driver, String path, String val){
		System.out.println("text"+path+"值为："+val);
		WebElement element = driver.findElement(By.xpath(path));
		element.sendKeys(val);
	}
	//select2值得选择
	public static void setKeysForInputSelect2(WebDriver driver, String path, String val){
		try {
			WebElement select2 = driver.findElement(By.xpath(path));
			System.out.println("select2"+path+"值为："+val);
			select2.click();
			Thread.sleep(1000);
			WebElement li = driver.findElement(By.xpath(".//div[@id='select2-drop']//li/div[text()='"+val+"']"));
			li.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void setKeysForCity(WebDriver driver, String path[], String val[]){
		setKeysForInputSelect2( driver,  path[0],  val[0]);
		setKeysForInputSelect2( driver,  path[1],  val[1]);
		setKeysForInputSelect2( driver,  path[2],  val[2]);
	}
	
}
