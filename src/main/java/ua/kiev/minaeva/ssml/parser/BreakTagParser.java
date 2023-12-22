package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.model.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.model.Break;

public class BreakTagParser implements TagParser {

    @Override
    public void parse(Element element, AbstractSSMLElement parent) {

        String timeAttribute = element.getAttribute("time");
        String strengthAttribute = element.getAttribute("strength");

        Break breakTag = new Break(parent, timeAttribute, strengthAttribute);
        parent.addChild(breakTag);
    }
}