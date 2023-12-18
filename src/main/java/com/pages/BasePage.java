package com.pages;

import static com.driver.DriverManager.getDriver;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BasePage 
{
	protected void sendkeys(WebElement element,String value) {
		explicitlyWait(element);
		element.sendKeys(value);
	}
	
	
	protected void click(WebElement element,String elementname){
		explicitlyWait(element);
		element.click();
		System.out.println(elementname+ " is cliked successfully ");
	}
	
	protected void click(By by,String elementname){
		click(DriverManager.getDriver().findElement(by), elementname);
	}
	
	protected void click(String locatortype,String value,String elementname){
		if(locatortype.equalsIgnoreCase("xpath")) {
			click(By.xpath(value), elementname);
		}else if (locatortype.equalsIgnoreCase("id")) {
			click(By.id(value), elementname);
		}else if(locatortype.equalsIgnoreCase("accessibilityId")) {
			click(AppiumBy.accessibilityId(value), elementname);
		}else if (locatortype.equalsIgnoreCase("name")) {
			click(AppiumBy.name(value), elementname);
		}
	}
	
	protected void explicitlyWait(WebElement element) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void choosefromlistandclick(List<WebElement>list,String menu){
		WebElement element = list.parallelStream()
				.filter(e ->e.getText().contentEquals(menu))
				.findFirst().get();
		click(element, menu);
		
	}
	
	protected void tap(AndroidDriver driver, WebElement element) {
	    Point location = element.getLocation();
	    Dimension size = element.getSize();

	    Point centerOfElement = getCenterOfElement(location, size);

	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    Sequence sequence = new Sequence(finger1, 1)
	        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(200)))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    driver.perform(Collections.singletonList(sequence));
	  }

	   Point getCenterOfElement(Point location, Dimension size) {
	    return new Point(location.getX() + size.getWidth() / 2,
	                     location.getY() + size.getHeight() / 2);
	  }
	   
	   protected void doubleTap(AndroidDriver driver, WebElement element) {
		    Point location = element.getLocation();
		    Dimension size = element.getSize();

		    Point centerOfElement = getCenterOfElement(location, size);

		    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(100)))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(100)))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(100)))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    driver.perform(Collections.singletonList(sequence));
	  }
	   
	   protected void longPress(AndroidDriver driver, WebElement element) {
		    Point location = element.getLocation();
		    Dimension size = element.getSize();

		    Point centerOfElement = getCenterOfElement(location, size);

		    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofSeconds(2)))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    driver.perform(Collections.singletonList(sequence));
		  }
	   
	   protected void swipeandscroll(AndroidDriver driver){
		   Dimension size = driver.manage().window().getSize();
		    int startX = size.getWidth() / 2;
		    int startY = size.getHeight() / 2;
		    int endX = startX;
		    int endY = (int) (size.getHeight() * 0.25);
		    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(200)))
		        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    driver.perform(Collections.singletonList(sequence));
	   }
	   
	   protected void draganddrop(AndroidDriver driver, WebElement source, WebElement target)
	   {
		   Point sourceElement = getCenterOfElement(source.getLocation(), source.getSize());
		   Point targetElement =  getCenterOfElement(target.getLocation(), target.getSize());
		   
		   PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		   Sequence sequence = new Sequence(finger1, 1)
				   .addAction(finger1.createPointerMove(Duration.ofMillis(1), PointerInput.Origin.viewport(), sourceElement))
		   		   .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		   		   .addAction(new Pause(finger1, Duration.ofSeconds(2)))
		   		   .addAction(finger1.createPointerMove(Duration.ofMillis(1), PointerInput.Origin.viewport(), targetElement))
		   		   .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		   driver.perform(Collections.singleton(sequence));
		   
		   
	   }

}

