import os
import pytest
from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.common.by import By

from conftest import driver


url  = "http://the-internet.herokuapp.com/"

def test_web_application_flow(driver: WebDriver):
    driver.get(url)
    assert driver.title == "The Internet"
   
    driver.find_element(By.LINK_TEXT, "Checkboxes").click()

    checkboxes = driver.find_elements(By.CSS_SELECTOR, "#checkboxes input[type='checkbox']")
     
   
    heading = driver.find_element(By.XPATH, "//h3[text()='Checkboxes']").text
    assert heading == "Checkboxes"

   
    checkboxes = driver.find_elements(By.CSS_SELECTOR, "input[type='checkbox']")
    assert len(checkboxes) >= 2,  "Expected at least 2 checkboxes"
    assert not checkboxes[0].is_selected(), "Checkbox 1 should NOT be selected"
    assert checkboxes[1].is_selected(), "Checkbox 2 should be selected"

   
    driver.back()
    
    driver.find_element(By.LINK_TEXT, "File Upload").click()

    heading = driver.find_element(By.TAG_NAME, "h3").text
    assert heading == "File Uploader"

    choose_file = driver.find_element(By.ID, "file-upload")
    choose_file.send_keys("C:\\Users\\Manu\\Capstone_Project\\requirement.txt")  # Adjust this path as needed

    driver.find_element(By.ID, "file-submit").click()

   
   
