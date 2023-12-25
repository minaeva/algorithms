package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.SSMLContext;
import ua.kiev.minaeva.ssml.element.AbstractElement;
import ua.kiev.minaeva.ssml.element.ProsodyElement;

public class ProsodyTagParser implements TagParser {

    private final SSMLContext context;

    public ProsodyTagParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element, AbstractElement parent) {
        ProsodyElement prosodyElement = getProsodyElement(element, parent);

        parent.addChild(prosodyElement);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.TEXT_NODE) {
                context.parseText(childNode, prosodyElement);
            }
        }
    }

    private static ProsodyElement getProsodyElement(Element element, AbstractElement parent) {
        String rateElement = element.getAttribute("rate");
        String pitchElement = element.getAttribute("pitch");

        return new ProsodyElement(parent, rateElement, pitchElement);
    }
}
