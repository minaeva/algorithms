package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.SSMLContext;
import ua.kiev.minaeva.ssml.model.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.model.SayAsElement;

public class SayAsTagParser implements TagParser {

    private final SSMLContext context;

    public SayAsTagParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element, AbstractSSMLElement parent) {
        String interpretAsAttribute = element.getAttribute("interpretAs");
        String formatAttribute = element.getAttribute("format");
        String detailAttribute = element.getAttribute("detail");

        SayAsElement sayAsElement = new SayAsElement(parent, interpretAsAttribute, formatAttribute, detailAttribute);

        parent.addChild(sayAsElement);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE ||
                    childNode.getNodeType() == Node.TEXT_NODE
            ) {
                context.traverseNodes(childNode, sayAsElement);
            }
        }
    }
}
