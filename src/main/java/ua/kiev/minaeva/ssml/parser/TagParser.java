package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.element.AbstractSSMLElement;

public interface TagParser {

    void parse(Element element, AbstractSSMLElement parent);
}
