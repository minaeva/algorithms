package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.element.AbstractElement;
import ua.kiev.minaeva.ssml.element.EmphasisElement;

public class EmphasisTagParser implements TagParser {

    @Override
    public void parse(Element element, AbstractElement parent) {
        String levelAttribute = element.getAttribute("level");

        EmphasisElement emphasisElement = new EmphasisElement(parent, levelAttribute);

        parent.addChild(emphasisElement);
    }
}
