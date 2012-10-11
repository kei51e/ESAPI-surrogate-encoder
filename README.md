ESAPI-surrogate-encoder
=======================
A sample ESAPI XML encoder implementation that can handle Unicode surrogate characters.


Description
-----------------------

It is a sample ESAPI (https://www.owasp.org/index.php/Category:OWASP_Enterprise_Security_API) XML encoder implementation that can handle Unicode surrogate characters. It only covers following 2 APIs

    ESAPI.encoder().encodeForXML(String)
    ESAPI.encoder().encodeForXMLAttribute(String)


Usage
-----------------------
Compile

    mvn package
  
Test

    mvn test


License
-----------------------
<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/deed.en_US"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/deed.en_US">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.
Same as ESAPI itself.
