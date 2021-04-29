package com.testing.script.script.testing.com;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lg washing machine");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//*[@id=\"p_89/LG\"]/span/a/div/label/i")).click();

		List<WebElement> productname = driver.findElements(By.xpath(
				"//div[@data-component-type=\"s-search-result\"]//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
		List<WebElement> productprice = driver.findElements(
				By.xpath("//div[@data-component-type=\"s-search-result\"]//span[@class=\"a-price-whole\"]"));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < productname.size(); i++) {
			map.put(productname.get(i).getText(), Integer.valueOf(productprice.get(i).getText().replace(",", "")));
		}

		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}

		// using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<String, Integer> entry : temp.entrySet())
			System.out.println("Product Name = " + entry.getKey() + ", Product Price = " + entry.getValue());
	driver.close();}
	

}
