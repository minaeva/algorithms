package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.SSMLContext;
import ua.kiev.minaeva.ssml.element.AbstractElement;
import ua.kiev.minaeva.ssml.element.PElement;

public class PParser implements TagParser {

    private final SSMLContext context;

    public PParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element, AbstractElement parent) {
        PElement pElement = new PElement(parent);

        parent.addChild(pElement);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                context.parseElement(childNode, pElement);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                context.parseText(childNode, pElement);
            }
        }
    }
}
