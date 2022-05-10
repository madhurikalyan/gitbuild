package AllWebElements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelectorsBasics1 {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		//System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/WebTableAll.html");
	
		
		//CSS Selectors :  Cascasing style sheet --
//		html -- develop page -
//		CSS-  appply styles to page
		// can change backgroun
//		<!DOCTYPE html>
//		<html>
//		<head>
//		<style>
//		body {
//		  background-color: green;
//		}
//
//		h1 {
//		  color: pink;
//		  text-align: right;
//		}
//
//		p {
//		  font-family: verdana;
//		  font-size: 30px;
//		}
//		</style>
//
//		</head>
//		<body>
//
//		<h1>My First CSS Example</h1>
//		<p>This is a paragraph.</p>
//
//		</body>
//		</html>

		
		// xpath :   // tagname[@Attrname='attr val']
		// CSS:         tagname[Attrname='attr val']
//		ex: table[id='ListboxTable01']
//		                table[name='ListboxTable']
		//   id, name .class,.. etc  
//		Note:
//		1.id
//		table#TextboxTable01  ==  table[id='TextboxTable01']
		
//		2.class
//		table.HulClassName == table[Class='HulClassName']
		
		
//		3. child node:  / replaced >
//		xpath  ://table[@name='ListboxTable'] / tbody
//		css:     table[name='ListboxTable']   > tbody	
		
//		4.sub child :  // replaced by space
//		Xpath  :  use //  
					//table[@name='ListboxTable']//tr
//		CSS:   use space       table[name='ListboxTable']    tr
				
		
		// starts -with(@atrtname,'attr val')
//		Xpath  :    // tagname[starts-with(@Atrname,'Attr val')]
		          //table[starts-with(@id,'HulTablee')]
//		dont use: table[starts-with(id,'HulTablee')]   -  not ok
//		CSS:      table[id^='HulTablee']        
		
		// CSS :   ^, $ ,*
		// endswith :
//		xpath ;; we dont have any method
		
//		CSS:                 starts -w     id ^= 'HulTablee'
//		                                   id $= 'Tablee01'
//		   	ex:   table[id^='Tablee01']   = id ends with =  Tablee01
		// contains   
//		xpath   contains(@attr,'attr val')  ex://table[contains(@id,'HulTablee')]
//		CSS:   ^, $ ,* 
//			id*='Tablee01'
		
//		 ex:   table[id*Tablee01]
			
		
		// convert xpath to css selector  :covered
//			id (#) .clas use dot,  child (/ replce >), subchild(//  replace space)
		// ^, %*      starts-with (id^='firstid') ,ends -(no xpath) CSS: id $='first' 
		// conatins(@id,'idfir')  css    :    id *= 'firs'
		
		
		// nth index of :
//		synatx: tag:nth-child(2)
//		table[id*='Tablee'] tbody tr:nth-child(2)
	// conbert to xpath
		//table[@id='Tablee']/tbody/tr[2]
//		tr[2]  replace tr:nth-child(2)
		
		//4 followin-sibling :  use ~
//		XPATH: //input[@id='username']/following-sibling:input[1]
//		CSS:                #username > +input:nth-child(1)
//		CSS: #username + input
		
//		ex1:
		//*[@id='HulTablee01']//tr[2]/td[1]/following-sibling::td[2]
//		CSS : table[id='HulTablee01'] tr:nth-child(2) >td:nth-child(1)  +td:nth-child(2)
//		table[id='HulTablee01'] tr:nth-child(2) >td:nth-child(1)+td    not working ax expected ???
//		next-sibling use +
//		table[id='HulTablee01'] tr:nth-child(2) >td:nth-child(1)~td :nth-child(1)
			
		//*[@id='HulTablee01']//td/a[contains(text(),'10110103')]/../following-sibling::td[1]
//		css: table[id='HulTablee01'] td > a[contains(text(),'10110103')]/../following-sibling::td[1]
		
//		xpath : ?????  contains ???
		
		
		//parent in css  ..????
		
//		synatx:
		//table[@id='TestCaseTable01']
		
		//*[@*='TestCaseTable01']
		// first * repsresnt any tag name 
		// 2nd * -  any attr name
	}
}
