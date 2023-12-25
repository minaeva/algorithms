package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kiev.minaeva.ssml.SSMLContext;
import ua.kiev.minaeva.ssml.element.AbstractElement;
import ua.kiev.minaeva.ssml.element.AudioElement;

public class AudioTagParser implements TagParser {

    private final SSMLContext context;

    public AudioTagParser(SSMLContext context) {
        this.context = context;
    }

    @Override
    public void parse(Element element, AbstractElement parent) {
        AudioElement audioElement = getAudioElement(element, parent);

        parent.addChild(audioElement);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                context.parseElement(childNode, audioElement);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                context.parseText(childNode, audioElement);
            }
        }
    }

    private AudioElement getAudioElement(Element element, AbstractElement parent) {
        String srcAttribute = element.getAttribute("src");
        String clipBeginAttribute = element.getAttribute("clipBegin");
        String clipEndAttribute = element.getAttribute("clipEnd");
        String speedAttribute = element.getAttribute("speed");
        String repeatCountAttribute = element.getAttribute("repeatCount");
        String repeatDurAttribute = element.getAttribute("repeatDur");
        String soundLevelAttribute = element.getAttribute("soundLevel");

        return new AudioElement(parent, srcAttribute, clipBeginAttribute,
                clipEndAttribute, speedAttribute, repeatCountAttribute, repeatDurAttribute,
                soundLevelAttribute);
    }
}
