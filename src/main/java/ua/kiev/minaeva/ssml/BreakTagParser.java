package ua.kiev.minaeva.ssml;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.model.Break;

public class BreakTagParser implements TagParser {

    @Override
    public void parse(Element element) {
        Break breakTag = new Break();

        System.out.println("Break: " + element.getAttribute("time"));

        String timeAttribute = element.getAttribute("time");
        if (!timeAttribute.isEmpty()) {
            breakTag.setTime(timeAttribute);
//            ssmlDocument.addBreak(breakTag);
        } else {
            // Handle missing or empty 'time' attribute
            // For example, log an error or throw an exception
        }
    }
}
