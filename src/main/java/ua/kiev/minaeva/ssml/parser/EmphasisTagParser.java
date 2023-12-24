package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.element.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.element.EmphasisElement;

public class EmphasisTagParser implements TagParser {

    @Override
    public void parse(Element element, AbstractSSMLElement parent) {
        String levelAttribute = element.getAttribute("level");

        EmphasisElement emphasisElement = new EmphasisElement(parent, levelAttribute);

        parent.addChild(emphasisElement);
    }
}
