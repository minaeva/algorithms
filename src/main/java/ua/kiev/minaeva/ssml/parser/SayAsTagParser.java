package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.SSMLContext;
import ua.kiev.minaeva.ssml.element.AbstractElement;
import ua.kiev.minaeva.ssml.element.SayAsElement;

public class SayAsTagParser implements TagParser {

    private final SSMLContext context;

    public SayAsTagParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element, AbstractElement parent) {
        SayAsElement sayAsElement = getSayAsElement(element, parent);

        parent.addChild(sayAsElement);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.TEXT_NODE) {
                context.parseText(childNode, sayAsElement);
            }
        }
    }

    private SayAsElement getSayAsElement(Element element, AbstractElement parent) {
        String interpretAsAttribute = element.getAttribute("interpret-as");
        String formatAttribute = element.getAttribute("format");
        String detailAttribute = element.getAttribute("detail");

        return new SayAsElement(parent, interpretAsAttribute, formatAttribute, detailAttribute);
    }
}
