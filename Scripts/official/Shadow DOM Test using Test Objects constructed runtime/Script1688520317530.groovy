import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

// You should change Project > Settings > Execution: default wait for element timeout: 30 -> 3 seconds

/**
 * Construct a Katalon-compatible TestObject in memory.
 * @param css (String) The CSS selector used to find the target element.
 * @return (TestObject) The constructed TestObject.
 */
static TestObject makeTO(String css) {
  TestObject to = new TestObject(css)
  to.addProperty("css", ConditionType.EQUALS, css)
  return to
}

static TestObject makeTOforElementInsideShadowDOM(TestObject parentObject, String css) {
	TestObject to = new TestObject(parentObject.toString() + "|" + css)
	to.addProperty("css", ConditionType.EQUALS, css)
	to.setParentObject(parentObject)
	to.setParentObjectShadowRoot(true)
	return to
}

//Open browser and navigate to the AUT website
WebUI.openBrowser('https://books-pwakit.appspot.com/explore?q=')

TestObject book_app = makeTO("*[apptitle='BOOKS']")
TestObject input = makeTOforElementInsideShadowDOM(book_app, "#input")

// make sure the input element is there in the current page
WebUI.verifyElementPresent(input, 1)

// type a text into the search bar
WebUI.setText(input, 'Fairwell to arms')

//Delay 5s to view the result
WebUI.delay(5)

//Close the browser to clean up
WebUI.closeBrowser()

