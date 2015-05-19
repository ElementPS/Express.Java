# Express.Java
Integration to Express API using Java

* Questions?  certification@elementps.com
* **Feature request?** Open an issue.
* Feel like **contributing**?  Submit a pull request.

##Overview

This repository demonstrates an integration to the Element Express API using Java.  The code was tested using Eclipse Luna version.  The application itself allows a user to populate a credit sale request or a health check request using either SOAP or XML formats and then send the request to Element's Express API for further processing.  The app then displays the result returned from Element's platform.

![Express.Java](https://github.com/ElementPS/Express.Java/blob/master/screenshot.PNG)

##Prerequisites

Please contact your Integration Team member for any questions about the prerequisite below.

* Create Express test account: http://www.elementps.com/Resources/Create-a-Test-Account

##Documentation/Troubleshooting

* When you create your Express test account an email will be sent containing links to documentation.

##Step 1: Generate a request

You can either generate an XML request or a SOAP request.  The Credentials and Application elements are empty below because these elements are read from the App.config file.  When you receive an email after creating your test account the email will contain the information necessary to populate these fields in the App.config.  Only the credit sale request is shown below, please take a look at the code for the health check message.

This is the XML request:

```

```

And this is the SOAP request:


```

```

##Step 2: Send Request to the Express API

The HttpSender class is used to send both the XML and SOAP requests.  The only difference is the endpoint the data is sent to and the SOAPAction header that is added when sending SOAP requests.

```

```

##Step 3: Receive response from Express API

The response will be in an XML format regardless of sending XML or SOAP but the actual data returned will be slightly different.  This is the response to an XML request.

```
```

This is the response to a SOAP request

```

```


##Step 4: Parse response data

You may parse the XML response in any manner but one way is to load the returned XML direclty into an XmlDocument and then perform XPath queries against that XmlDocument.

```
```


###©2014-2015 Element Payment Services, Inc., a Vantiv company. All Rights Reserved.

Disclaimer:
This software and all specifications and documentation contained herein or provided to you hereunder (the "Software") are provided free of charge strictly on an "AS IS" basis. No representations or warranties are expressed or implied, including, but not limited to, warranties of suitability, quality, merchantability, or fitness for a particular purpose (irrespective of any course of dealing, custom or usage of trade), and all such warranties are expressly and specifically disclaimed. Element Payment Services, Inc., a Vantiv company, shall have no liability or responsibility to you nor any other person or entity with respect to any liability, loss, or damage, including lost profits whether foreseeable or not, or other obligation for any cause whatsoever, caused or alleged to be caused directly or indirectly by the Software. Use of the Software signifies agreement with this disclaimer notice.


![Analytics](https://ga-beacon.appspot.com/UA-60858025-39/Express.Java/readme?pixel)

