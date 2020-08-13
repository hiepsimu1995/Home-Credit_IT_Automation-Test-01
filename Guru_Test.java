package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Guru_Test {
    static WebDriver driver;
	public static  void  login() throws InterruptedException
	  {
		  	System.setProperty("webdriver.chrome.driver", "D:\\Linh\\java-2020-03\\eclipse\\chromedriver.exe");
			driver = new ChromeDriver();
		   	driver.get("http://demo.guru99.com/v4/");
		   	driver.manage().window().maximize();
		   	driver.findElement(By.name("uid")).sendKeys("mngr277916");
		   	driver.findElement(By.name("password")).sendKeys("ajumupY");
		   	driver.findElement(By.name("btnLogin")).click();
		   	
	  }
	public static  String  createcus() throws IOException, InterruptedException
	{
		
			driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
		
		    driver.findElement(By.name("name")).sendKeys("linhABC");

		    driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
		   	WebElement a= driver.findElement(By.xpath("//*[@id=\"dob\"]"));		    		
		   	a.sendKeys("1212");
		   	a.sendKeys("2000");
		   	driver.findElement(By.name("addr")).sendKeys("Nguyen van troi");
		   	driver.findElement(By.name("city")).sendKeys("Ho Chi Minh");
		   	driver.findElement(By.name("state")).sendKeys("VietNam");
		   	driver.findElement(By.name("pinno")).sendKeys("123456");		   	
		   	driver.findElement(By.name("telephoneno")).sendKeys("0900000000");
	   	   	driver.findElement(By.name("emailid")).sendKeys("tes7@a.vn");
		   	driver.findElement(By.name("password")).sendKeys("123456");   		
		   	driver.findElement(By.name("sub")).click();	
		   	Thread.sleep(500);
		   	String cusid= driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
		   	Thread.sleep(500);
		   	System.out.printf("Cus id : ",cusid);
		   	return cusid;
		   	
		   	
		   //	createacc(cusid);
		   	
		   
		

	}
	public static  String  createacc(String x) throws IOException, InterruptedException
	{

	   
	   	driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[5]/a")).click();
	   	driver.findElement(By.name("cusid")).sendKeys(x); 
	   	driver.findElement(By.name("inideposit")).sendKeys("1000"); 
	   	driver.findElement(By.name("button2")).click();			   
	   	String accid= driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText(); 
	 	System.out.printf("account no :",accid);
	   	return accid;
	   	
	  
	}
	public static  void  add_deposit(String x) throws IOException, InterruptedException
	{


	   	driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[8]/a")).click();
	   	driver.findElement(By.name("accountno")).sendKeys(x); 
	   	driver.findElement(By.name("ammount")).sendKeys("1000"); 
		driver.findElement(By.name("desc")).sendKeys("Test"); 
	   	
	   	driver.findElement(By.name("AccSubmit")).click();			   	
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		login();
		Thread.sleep(500);

		
		String a= createcus();
		
		Thread.sleep(500);
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");

		
		
		Thread.sleep(500);
		String b= createacc(a);
		Thread.sleep(500);
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		add_deposit(b);
	}

}
