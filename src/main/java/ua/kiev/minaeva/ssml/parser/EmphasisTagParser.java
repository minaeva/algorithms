package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.model.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.model.Emphasis;

public class EmphasisTagParser implements TagParser {

    @Override
    public void parse(Element element, AbstractSSMLElement parent) {

        String levelAttribute = element.getAttribute("level");

        Emphasis emphasis = new Emphasis(parent, levelAttribute);

        parent.addChild(emphasis);
    }
}
