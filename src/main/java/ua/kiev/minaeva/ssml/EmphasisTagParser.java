package ua.kiev.minaeva.ssml;

import org.w3c.dom.Element;

public class EmphasisTagParser implements TagParser {

    @Override
    public void parse(Element element) {
        String level = element.getAttribute("level");
        System.out.println("Emphasis level " + level);
    }
}
