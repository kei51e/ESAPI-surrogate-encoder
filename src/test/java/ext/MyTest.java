package ext;

import org.owasp.esapi.ESAPI;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MyTest 
    extends TestCase
{
    public MyTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( MyTest.class );
    }

    public void testSingleLetter()
    {
      // unicode surrogate pair for character U+2070E
      String surrogate = "\uD841\uDF0E";
      String expected = "&#132878;";
      // "&#132878;" is the correct character reference for this surrogate pair.
      assertEquals(expected, ESAPI.encoder().encodeForXML(surrogate));
      assertEquals(expected, ESAPI.encoder().encodeForXMLAttribute(surrogate));
      
      // "&#xd841;&#xdf0e;" is wrong character references. 
      // This surrogate pair should represent 1 character. 
//      assertEquals("&#xd841;&#xdf0e;", ESAPI.encoder().encodeForHTML(surrogate));
//      assertEquals("&#xd841;&#xdf0e;", ESAPI.encoder().encodeForHTMLAttribute(surrogate));
    }
    public void testSentence()
    {
      // sentence including unicode surrogate pair for character U+2070E
      String surrogate = "\u3042\u3044\u3046\uD841\uDF0E\u3042\u3044\u3046abc";
      String expected = "&#x3042;&#x3044;&#x3046;&#132878;&#x3042;&#x3044;&#x3046;abc";
      assertEquals(expected, ESAPI.encoder().encodeForXML(surrogate));
      assertEquals(expected, ESAPI.encoder().encodeForXMLAttribute(surrogate));
    }
}
