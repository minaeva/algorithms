package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.SSMLContext;
import ua.kiev.minaeva.ssml.model.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.model.AudioElement;

public class AudioTagParser implements TagParser {

    private final SSMLContext context;

    public AudioTagParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element, AbstractSSMLElement parent) {
        String srcAttribute = element.getAttribute("src");
        String clipBeginAttribute = element.getAttribute("clipBegin");
        String clipEndAttribute = element.getAttribute("clipEnd");
        String speedAttribute = element.getAttribute("speed");
        String repeatCountAttribute = element.getAttribute("repeatCount");
        String repeatDurAttribute = element.getAttribute("repeatDur");
        String soundLevelAttribute = element.getAttribute("soundLevel");

        AudioElement audioElement = new AudioElement(parent, srcAttribute, clipBeginAttribute,
                clipEndAttribute, speedAttribute, repeatCountAttribute, repeatDurAttribute,
                soundLevelAttribute);

        parent.addChild(audioElement);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE ||
                    childNode.getNodeType() == Node.TEXT_NODE
            ) {
                context.traverseNodes(childNode, audioElement);
            }
        }
    }
}
