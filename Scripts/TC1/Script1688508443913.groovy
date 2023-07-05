import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String url = 'https://books-pwakit.appspot.com/explore?q='
WebUI.openBrowser('')
WebUI.setViewPortSize(1200, 1000)
WebUI.navigateToUrl(url)
WebUI.delay(3)
WebUI.closeBrowser()