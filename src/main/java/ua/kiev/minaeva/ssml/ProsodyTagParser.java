package ua.kiev.minaeva.ssml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.model.Prosody;

public class ProsodyTagParser implements TagParser {

    private final SSMLContext context;

    public ProsodyTagParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element) {
        System.out.println("Prosody rate: " + element.getAttribute("rate"));

        Prosody prosody = new Prosody();
        prosody.setRate(element.getAttribute("rate"));
        prosody.setPitch(element.getAttribute("pitch"));

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                context.traverseNodes(childNode);
            }
        }
    }
}
