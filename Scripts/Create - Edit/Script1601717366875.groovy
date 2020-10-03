import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.gistUrl)


'Login'
WebUI.click(findTestObject('Header menu/aSign-in'))
WebUI.delay(2)
WebUI.setText(findTestObject('Login page/unameField'),GlobalVariable.uname)
WebUI.setText(findTestObject('Login page/passField'), GlobalVariable.passwd)
WebUI.click(findTestObject('Login page/btnSign-in'))



'Create new gist file'
WebUI.click(findTestObject('Header menu/addNew'))
String desc = "Ini descriptionya, coba aja baca dulu!"
String fileName = "stars.java"
String code = """
int i, j;
  for (i=1; i<=5; i++) {
   for (j=1; j<=i; j++) {
    System.out.print("*"); 
   }
   System.out.println();
  }
"""

WebUI.setText(findTestObject('Add New Page/gistDesc'), desc)
WebUI.setText(findTestObject('Add New Page/gistFileName'), fileName)
WebUI.setText(findTestObject('Add New Page/gistCode'), code)
WebUI.click(findTestObject('Add New Page/btnSelectMenu'))
WebUI.click(findTestObject('Add New Page/selectPublic'))
WebUI.click(findTestObject('Add New Page/btnCreatePublic'))

WebUI.delay(2)



'Verify FileName and Desc created'
String gistDesc = WebUI.getText(findTestObject('Result Page/gitDesc'))
String gistFileName = WebUI.getText(findTestObject('Result Page/gitFilenName'))
WebUI.verifyMatch(gistDesc, desc, false)
WebUI.verifyMatch(gistFileName, fileName, false)



'Edit gist file'
String fileNameEdit = "starsEdit1.java"
WebUI.setText(findTestObject('Add New Page/gistFileName'), fileNameEdit)
WebUI.click(findTestObject('Add New Page/btnUpdate'))
String edited = WebUI.getText(findTestObject('Result Page/gitFilenName'))
WebUI.verifyMatch(edited, fileNameEdit, false)





