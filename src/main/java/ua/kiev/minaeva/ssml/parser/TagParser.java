package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.element.AbstractElement;

public interface TagParser {

    void parse(Element element, AbstractElement parent);
}
