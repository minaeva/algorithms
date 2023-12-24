package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.element.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.element.BreakElement;

public class BreakTagParser implements TagParser {

    @Override
    public void parse(Element element, AbstractSSMLElement parent) {
        String timeAttribute = element.getAttribute("time");
        String strengthAttribute = element.getAttribute("strength");

        BreakElement breakElement = new BreakElement(parent, timeAttribute, strengthAttribute);

        parent.addChild(breakElement);
    }
}
