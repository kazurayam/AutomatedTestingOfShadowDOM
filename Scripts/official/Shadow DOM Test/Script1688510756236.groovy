import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Open browser and navigate to the AUT website
WebUI.openBrowser('https://books-pwakit.appspot.com/explore?q=')

// Project > Settings > Execution; Default wait for element timeout is set 3 seconds

WebUI.verifyElementPresent(findTestObject('Object Repository/official/input'), 1)

//Input text into the search bar
WebUI.setText(findTestObject('Object Repository/official/input'), 'hello World')

//Delay 5s to view the result
WebUI.delay(5)

//Close the browser to clean up
WebUI.closeBrowser()
