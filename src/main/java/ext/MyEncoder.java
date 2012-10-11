package ext;

import java.util.ArrayList;
import java.util.List;

import org.owasp.esapi.Encoder;
import org.owasp.esapi.codecs.XMLEntityCodec;
import org.owasp.esapi.reference.DefaultEncoder;

public class MyEncoder extends DefaultEncoder {

        private XMLEntityCodec _xmlCodec = new MyXMLEntityCodec();

        private final static char[] IMMUNE_XML = { ',', '.', '-', '_', ' ' };
        private final static char[] IMMUNE_XMLATTR = { ',', '.', '-', '_' };
        
        private static volatile Encoder singletonInstance;

        public static Encoder getInstance() {
            if ( singletonInstance == null ) {
                synchronized ( MyEncoder.class ) {
                    if ( singletonInstance == null ) {
                        singletonInstance = new MyEncoder(new ArrayList<String>());
                    }
                }
            }
            return singletonInstance;
        }

        public MyEncoder( List<String> codecNames ) {
          super(codecNames);
        }
        
        @Override
        public String encodeForXML(String input) {
            if( input == null ) {
                return null;    
            }
            return _xmlCodec.encode( IMMUNE_XML, input);
        }
        
        @Override
        public String encodeForXMLAttribute(String input) {
            if( input == null ) {
                return null;    
            }
            return _xmlCodec.encode( IMMUNE_XMLATTR, input);
        }
}
