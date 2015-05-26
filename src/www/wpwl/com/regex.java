package www.wpwl.com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
	public static void main(String args[]){
		String str = "abcafgakkaal";
		System.out.println("初始数组为："+str);
		getvalue(str);
		
	}
	
	public static void getvalue(String str){
		 String re = "a";
	     Pattern p = Pattern.compile(re);
	     Matcher m = p.matcher(str);
	     int num = 0;
	     int arr[] = new int[2];
	     while(m.find()){
	    	num++;
	        if(num==2){
	        	arr[0] = m.start();
	        }
	        if(num==3){
	        	arr[1] = m.start();
	        }
	     }
	     System.out.println("a的个数:"+num);
	     System.out.println("第2到3个a间的字符串：" + str.substring(arr[0]+1,arr[1]));
	     System.out.println("替换第二个a为1："+ str.substring(0,arr[0])+"1"+str.substring(arr[0]+1));   
	     System.out.print("替换所有的a为b："+ str.replaceAll("a","b"));   
	}
}
