package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class AudioElement extends AbstractSSMLElement {

    private String src;
    private String clipBegin;
    private String clipEnd;
    private String speed;
    private String repeatCount;
    private String repeatDur;
    private String soundLevel;

    public AudioElement(AbstractSSMLElement parent, String src,
                        String clipBegin, String clipEnd, String speed,
                        String repeatCount, String repeatDur, String soundLevel) {
        super("audio", parent);
        this.src = src;
        this.clipBegin = clipBegin;
        this.clipEnd = clipEnd;
        this.speed = speed;
        this.repeatCount = repeatCount;
        this.repeatDur = repeatDur;
        this.soundLevel = soundLevel;
    }

    @Override
    public String getTagName() {
        return "audio";
    }

    @Override
    public void addAttribute(String key, String value) {
        switch (key) {
            case "src" -> this.src = value;
            case "clipBegin" -> this.clipBegin = value;
            case "clipEnd" -> this.clipEnd = value;
            case "speed" -> this.speed = value;
            case "repeatCount" -> this.repeatCount = value;
            case "repeatDur" -> this.repeatDur = value;
            case "soundLevel" -> this.soundLevel = value;
            default -> super.addAttribute(key, value);
        }
    }

    @Override
    public String getAttribute(String key) {
        return switch (key) {
            case "src" -> this.src;
            case "clipBegin" -> this.clipBegin;
            case "clipEnd" -> this.clipEnd;
            case "speed" -> this.speed;
            case "repeatCount" -> this.repeatCount;
            case "repeatDur" -> this.repeatDur;
            case "soundLevel" -> this.soundLevel;
            default -> super.getAttribute(key);
        };
    }

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
    }

    public String getSrc() {
        return src;
    }

    public String getClipBegin() {
        return clipBegin;
    }

    public String getClipEnd() {
        return clipEnd;
    }

    public String getSpeed() {
        return speed;
    }

    public String getRepeatCount() {
        return repeatCount;
    }

    public String getRepeatDur() {
        return repeatDur;
    }

    public String getSoundLevel() {
        return soundLevel;
    }
}
