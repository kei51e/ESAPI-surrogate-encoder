package ext;

import org.owasp.esapi.codecs.XMLEntityCodec;

public class MyXMLEntityCodec extends XMLEntityCodec {

  @Override
  public String encode(char[] immune, String input) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      // Encode surrogates
      if (Character.isHighSurrogate(c)) {
        char c0 = input.charAt(++i);
        int cp = Character.toCodePoint(c, c0);
        sb.append("&#").append(cp).append(";");
      } else {
        sb.append(encodeCharacter(immune, c));
      }
    }
    return sb.toString();
  }
}
