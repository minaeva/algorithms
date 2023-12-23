package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.model.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.model.EmphasisElement;

public class EmphasisTagParser implements TagParser {

    @Override
    public void parse(Element element, AbstractSSMLElement parent) {
        String levelAttribute = element.getAttribute("level");

        EmphasisElement emphasisElement = new EmphasisElement(parent, levelAttribute);

        parent.addChild(emphasisElement);
    }
}
