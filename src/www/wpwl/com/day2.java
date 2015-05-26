package www.wpwl.com;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class day2 {
	public static void main(String args[]){
//		mychrome();
//		myfirefoxdefault();
//		mychromeoptions();
//		myie();
		myfirefox();
	}
	public static void myfirefox(){
		WebDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		navigation.to("http://test.e.ikcrm.com");
		String username="test@qq.com" , password = "11111111";
		WebElement element2 = driver.findElement(By.xpath(".//*[@id='user_login']"));
		element2.sendKeys(username);
		WebElement element3 = driver.findElement(By.xpath(".//*[@id='user_password']"));
		element3.sendKeys(password);
		WebElement element4 = driver.findElement(By.className("btnLogin"));
		// �ύ input ���ڵ� form
		element4.click();
//		driver.close();
//		driver = null;
	}
	
	public static void myfirefoxdefault(){
		ProfilesIni allprofile = new ProfilesIni();
		FirefoxProfile profile = allprofile.getProfile("default");
		System.out.print("start");
		//�� firefox��ַ������ about:config 
		//��Ѱ extensions.firebug.netexport.alwaysEnableAutoExport ,����firefix�Զ���������
		profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
		//�����Զ��������ļ�λ��
		profile.setPreference("extensions.firebug.netexport.defaultLogDir", "F:\\firefoxfile");
		profile.setPreference("extensions.firebug.netexport.saveFiles", true);
		WebDriver driver = new FirefoxDriver(profile);
		Navigation navigation = driver.navigate();
		navigation.to("http://test.e.ikcrm.com");
//		driver.close();
//		driver = null;
	}
	//����ָ������
	public static void getfirefoxprofile(){
		File file = new File("D://myfirefox.default");
		FirefoxProfile profile = new FirefoxProfile(file);
		System.out.print("start");
		WebDriver driver = new FirefoxDriver(profile);
		Navigation navigation = driver.navigate();
		navigation.to("http://www.baidu.com");
//		driver.close();
//		driver = null;
	}
	
	public static void myfirefoxplug(){
		File file = new File("");
		FirefoxProfile firefoxprofile = new FirefoxProfile();
		try{
			firefoxprofile.addExtension(file);
		}catch(Exception e){
			e.printStackTrace();
		}
		firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.9");
		WebDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		navigation.to("http://www.baidu.com");
//		driver.close();
//		driver = null;
	}
	
	public static void mychrome(){
		System.setProperty("webdriver.chrome.driver", "file/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Navigation navigation = driver.navigate();
		navigation.to("http://www.baidu.com");
//		driver.close();
//		driver = null;
	}
	public static void mychromeoptions(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		File file = new File("file/User Data");
		options.addArguments("user-data-dir="+file.getAbsolutePath());
		System.setProperty("webdriver.chrome.driver", "file/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		Navigation navigation = driver.navigate();
		navigation.to("http://www.baidu.com");
//		driver.close();
//		driver = null;
	}
	
	public static void myie(){
		DesiredCapabilities capabilities =DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//IE�ֶ��رձ���ģʽ
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		System.setProperty("webdriver.ie.driver", "file/IEDriverServer64.exe");
		WebDriver driver = new InternetExplorerDriver(capabilities);
		Navigation navigation = driver.navigate();
		navigation.to("http://www.baidu.com");
//		driver.close();
//		driver = null;
	}
	
	
	
}
