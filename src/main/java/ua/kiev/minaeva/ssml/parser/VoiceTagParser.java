package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.SSMLContext;
import ua.kiev.minaeva.ssml.element.AbstractElement;
import ua.kiev.minaeva.ssml.element.VoiceElement;

public class VoiceTagParser implements TagParser {

    private final SSMLContext context;

    public VoiceTagParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element, AbstractElement parent) {
        VoiceElement voiceElement = getVoiceElement(element, parent);

        parent.addChild(voiceElement);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                context.parseElement(childNode, voiceElement);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                context.parseText(childNode, voiceElement);
            }
        }
    }

    private VoiceElement getVoiceElement(Element element, AbstractElement parent) {
        String genderAttribute = element.getAttribute("gender");
        String variantAttribute = element.getAttribute("variant");
        String languageAttribute = element.getAttribute("language");
        String requiredAttribute = element.getAttribute("required");
        String orderingAttribute = element.getAttribute("ordering");

        return new VoiceElement(parent, genderAttribute, variantAttribute,
                languageAttribute, requiredAttribute, orderingAttribute);
    }
}
