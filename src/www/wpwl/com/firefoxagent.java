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
		//�� firefox��ַ������ about:config 
		//��Ѱ extensions.firebug.netexport.alwaysEnableAutoExport ,����firefix�Զ���������
		profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
		//�����Զ��������ļ�λ��
		profile.setPreference("extensions.firebug.netexport.defaultLogDir", "F:\\firefoxfile");
		profile.setPreference("extensions.firebug.netexport.saveFiles", true);
		String proxyIp = "10.0.0.172";
		int proxyPort = 80;
		profile.setPreference("network.proxy.type", 1);
		// httpЭ���������
		profile.setPreference("network.proxy.http", proxyIp);  
		profile.setPreference("network.proxy.http_port", proxyPort);
		  
		profile.setPreference("network.proxy.ssl", proxyIp);  
		profile.setPreference("network.proxy.ssl_port", proxyPort);
		    
		// ����Э�鹫��һ�ִ������ã�����������ã���������Ϊfalse
		profile.setPreference("network.proxy.share_proxy_settings", true);
		    
		// ����localhost�Ĳ��ô����������Ҫ���ã������޷���webdriverͨѶ
		profile.setPreference("network.proxy.no_proxies_on", "localhost");
		WebDriver driver = new FirefoxDriver(profile);
		Navigation navigation = driver.navigate();
		navigation.to("http://www.baidu.com");
//		driver.close();
//		driver = null;
	}
}
