package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.SSMLContext;
import ua.kiev.minaeva.ssml.element.AbstractElement;
import ua.kiev.minaeva.ssml.element.SElement;

public class SParser implements TagParser {

    private final SSMLContext context;

    public SParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element, AbstractElement parent) {
        SElement sElement = new SElement(parent);

        parent.addChild(sElement);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.TEXT_NODE) {
                context.parseText(childNode, sElement);
            }
        }
    }

}
