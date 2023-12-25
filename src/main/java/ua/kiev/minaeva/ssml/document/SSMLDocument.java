package ua.kiev.minaeva.ssml.document;

import ua.kiev.minaeva.ssml.element.AbstractElement;
import ua.kiev.minaeva.ssml.element.SpeakElement;

public class SSMLDocument {

    private final AbstractElement root = new SpeakElement();

    public SSMLDocument() {
    }

    public AbstractElement getRoot() {
        return root;
    }

}
