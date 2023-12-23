package ua.kiev.minaeva.ssml.model;

public class SpeakElement extends AbstractSSMLElement {

    public SpeakElement() {
        super("speak", null);
    }

    @Override
    public String getTagName() {
        return "speak";
    }

    @Override
    public SSMLElementContract getParent() {
        return null;
    }

}
