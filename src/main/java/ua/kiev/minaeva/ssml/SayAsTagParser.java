package ua.kiev.minaeva.ssml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SayAsTagParser implements TagParser {

    @Override
    public void parse(Element element) {
        // Retrieve attributes like 'interpret-as' and 'format' from the <say-as> element
        String interpretAs = element.getAttribute("interpret-as");
        String format = element.getAttribute("format"); // Optional attribute

        // Output or process the attributes
        System.out.println("Say as interpret-as: " + interpretAs);
        if (!format.isEmpty()) {
            System.out.println("Say as format: " + format);
        }

        // Don't forget to handle any nested elements or text
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text content: " + childNode.getTextContent().trim());
            }
        }
    }
}
