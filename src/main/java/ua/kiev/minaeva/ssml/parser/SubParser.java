package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.SSMLContext;
import ua.kiev.minaeva.ssml.element.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.element.SubElement;

public class SubParser implements TagParser {

    private final SSMLContext context;

    public SubParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element, AbstractSSMLElement parent) {
        String aliasAttribute = element.getAttribute("alias");
        SubElement subElement = new SubElement(parent, aliasAttribute);

        parent.addChild(subElement);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE ||
                    childNode.getNodeType() == Node.TEXT_NODE
            ) {
                context.traverseNodes(childNode, subElement);
            }
        }
    }
}
