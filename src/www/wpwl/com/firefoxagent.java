package www.wpwl.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class firefoxagent {
	public static void main(String args[]){
		myfirefoxagent();
	}
	
	public static void myfirefoxagent(){
		ProfilesIni allprofile = new ProfilesIni();
		FirefoxProfile profile = allprofile.getProfile("default");
		System.out.print("start");
		//在 firefox地址栏输入 about:config 
		//搜寻 extensions.firebug.netexport.alwaysEnableAutoExport ,配置firefix自动导出网络
		profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
		//配置自动导出的文件位置
		profile.setPreference("extensions.firebug.netexport.defaultLogDir", "F:\\firefoxfile");
		profile.setPreference("extensions.firebug.netexport.saveFiles", true);
		String proxyIp = "10.0.0.172";
		int proxyPort = 80;
		profile.setPreference("network.proxy.type", 1);
		// http协议代理配置
		profile.setPreference("network.proxy.http", proxyIp);  
		profile.setPreference("network.proxy.http_port", proxyPort);
		  
		profile.setPreference("network.proxy.ssl", proxyIp);  
		profile.setPreference("network.proxy.ssl_port", proxyPort);
		    
		// 所有协议公用一种代理配置，如果单独配置，这项设置为false
		profile.setPreference("network.proxy.share_proxy_settings", true);
		    
		// 对于localhost的不用代理，这里必须要配置，否则无法和webdriver通讯
		profile.setPreference("network.proxy.no_proxies_on", "localhost");
		WebDriver driver = new FirefoxDriver(profile);
		Navigation navigation = driver.navigate();
		navigation.to("http://www.baidu.com");
//		driver.close();
//		driver = null;
	}
}
