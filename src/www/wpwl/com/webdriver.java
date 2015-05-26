package www.wpwl.com;

import java.io.BufferedInputStream;
import www.wpwl.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class webdriver {
	
	static String  WebUrl = "http://test.e.ikcrm.com/users/sign_in";
	public static void main(String args[]){
		
		myfirefox();
		
	}
	public static void myfirefox(){
		ProfilesIni allprofile = new ProfilesIni();
		FirefoxProfile profile = allprofile.getProfile("default");
		profile.setPreference("extensions.firebug.currentVersion", "2.0.9");
		WebDriver driver = new FirefoxDriver(profile);
		Navigation navigation = driver.navigate();
		navigation.to(WebUrl);
		login(driver);
		root_page(driver);
//		driver.close();
//		driver = null;
	}
	public static void login(WebDriver driver){
		String username="test@qq.com" , password = "11111111";
		WebElement element2 = driver.findElement(By.xpath(".//*[@id='user_login']"));
		element2.sendKeys(username);
		WebElement element3 = driver.findElement(By.xpath(".//*[@id='user_password']"));
		element3.sendKeys(password);
		WebElement element4 = driver.findElement(By.xpath(".//*[@id='new_user']/div[4]/input"));
		// 
		element4.click();
	}
	
	public static void root_page(WebDriver driver){
		try {
			WebElement btn = driver.findElement(By.xpath(".//*[@id='nav']/section/header/div/div/button"));
			btn.click();
		    //((JavascriptExecutor)driver).executeScript("$($('#nav').find('ul')[0]).css('display','block');");
			WebElement lead_a = driver.findElement(By.xpath(".//*[@id='nav']/section/header/div/div/ul/li[1]/a"));
			lead_a.click();
			Thread.sleep(3000);
			WebElement more = driver.findElement(By.xpath(".//form[@id='new_lead']/div[@class='modal-body']/div[@class='form-group'][last()]//a"));
			more.click();
			String file_path = "file/webconfig/lead_form.properties";
			InputStream inputStream = new BufferedInputStream(
					new FileInputStream(file_path));
			Properties prop = new Properties();
			prop.load(inputStream);
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				String path ="";
				String val_str = prop.getProperty(key);
				String val_arr[] = val_str.split(":");
				switch(val_arr[0]){
				case "text": 
				    path = ".//*[@id='"+key+"']    ";
					Util.setKeysForInputText(driver, path ,val_arr[1]);
					break;
				case "select2": 
					path = ".//*[@id='"+key+"']/a";
					Util.setKeysForInputSelect2(driver, path, val_arr[1]);
					break;
				default:break;
				}
				
				
				System.out.println(key + ":" + prop.getProperty(key));
			}
			inputStream.close();
			String path_arr[] = {".//*[@id='s2id_province-field']/a",".//*[@id='s2id_city-field']/a",".//*[@id='s2id_district-field']/a"};
			String val_arr[] = {"上海","上海市","黄浦区"};
			Util.setKeysForCity(driver,path_arr,val_arr);
			
//			WebElement submit = driver.findElement(By.xpath(".//*[@id='tabreset']"));
//			submit.click();
			
		} catch (IOException | InterruptedException e1) {
			driver.close();
			e1.printStackTrace();
		}      
		
	}
	

	
}
