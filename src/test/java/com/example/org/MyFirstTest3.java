package com.example.org;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.TRUE;

public class MyFirstTest3 {
    Boolean DEBUGMODE = TRUE;
    int DEBUGCOUNT = 1;
    WebDriver driver = new ChromeDriver();
    String CURRENTPAGE = new String("");
    int MESSAGES_SENT = 0;

    @Test
    public void startWebDriver(){
        doLogin();
        goToSearch();
        sendMessages();
//        driver.close();

    }

    private void sendMessages() {

        while (TRUE){
            waitForIt();
            int rowSize = driver.findElements(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table[1]/tbody/tr")).size();
            for (int i = 0; i < rowSize; i++)
            {
                List<WebElement> rows = (List<WebElement>) driver.findElements(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table[1]/tbody/tr"));
                WebElement row = rows.get(i);
                System.out.println("--------------------------------------------");
                System.out.println(row.getText());
                System.out.println("--------------------------------------------");

                if (row.getText().contains("ContactsHistory")){
                    continue;
                }

                row.findElement(By.tagName("b")).click();
                waitForIt();
                if(driver.findElement(By.tagName("body")).getText().contains("Sorry, you cannot contact this member, because you do not meet this member's allowed sender criteria")){
                    goToCurrentPage();
                    continue;
                }
                driver.findElement(By.id("txaBody")).sendKeys("meesage goes here");
                driver.findElement(By.id("btnSend")).click();
                MESSAGES_SENT++;
                driver.findElement(By.linkText("Back to Search Results")).click();
                waitForIt();
                System.out.println("messages sent:" + MESSAGES_SENT);
            }
            driver.findElement(By.className("fa-arrow-right")).click();
            setURL();
        }
    }

    public void waitForIt(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setURL(){
        CURRENTPAGE = driver.getCurrentUrl();
    }

    public void goToCurrentPage(){
        driver.navigate().to(CURRENTPAGE);
    }

    private void goToSearch() {
//      arabic
//      CURRENTPAGE = "https://www.mylanguageexchange.com/search.asp?selSrchList=15644661&selX3=18&selX6=1&selCountry=null&txtCity=&txtAgeMin=18&txtAgeMax=24&selGender=0&selIsClass=null&selX4=null&selTxtChat=null&selX13=null&selFace=null&txtFName=&txtDesc=&selOrder=0&txtSrchName=arabic&nRows=10&BtnSubSrch=Search";
//      portugese
//      CURRENTPAGE = "https://www.mylanguageexchange.com/search.asp?selSrchList=15643009&selX3=35&selX6=1&selCountry=null&txtCity=&txtAgeMin=18&txtAgeMax=24&selGender=0&selIsClass=null&selX4=null&selTxtChat=null&selX13=null&selFace=null&txtFName=&txtDesc=&selOrder=0&txtSrchName=main&nRows=10&BtnSubSrch=Search";
//      Spanish
        CURRENTPAGE = "https://www.mylanguageexchange.com/search.asp?selSrchList=15643009&selX3=42&selX6=1&selCountry=null&txtCity=&txtAgeMin=18&txtAgeMax=24&selGender=0&selIsClass=null&selX4=null&selTxtChat=null&selX13=null&selFace=null&txtFName=&txtDesc=&selOrder=0&txtSrchName=main&nRows=10&BtnSubSrch=Search";
        driver.navigate().to(CURRENTPAGE);
    }

    public void doLogin(){
        driver.navigate().to("https://www.mylanguageexchange.com/login.asp?showmenu=1");
        driver.findElement(By.id("txtEmail")).sendKeys("*********");
        driver.findElement(By.id("txtPassw")).sendKeys("**********");
        driver.findElement(By.id("submit1")).click();
    }

    public void info(String info) {
        System.out.println("info::: " + info);
    }

 }

