package ua.kiev.minaeva.ssml.visitor;

import ua.kiev.minaeva.ssml.element.*;

public class PrintingVisitor implements SSMLElementVisitor {

    @Override
    public void visit(AudioElement audioElement) {
        StringBuilder result = new StringBuilder("<AudioElement>");

        if (!audioElement.getSrc().isEmpty()) {
            result.append("src = ").append(audioElement.getSrc()).append("; ");
        }
        if (!audioElement.getClipBegin().isEmpty()) {
            result.append("clipBegin = ").append(audioElement.getClipBegin()).append("; ");
        }
        if (!audioElement.getClipEnd().isEmpty()) {
            result.append("clipEnd = ").append(audioElement.getClipEnd()).append("; ");
        }
        if (!audioElement.getSpeed().isEmpty()) {
            result.append("speed = ").append(audioElement.getSpeed()).append("; ");
        }
        if (!audioElement.getRepeatCount().isEmpty()) {
            result.append("repeatCount = ").append(audioElement.getRepeatCount()).append("; ");
        }
        if (!audioElement.getRepeatDur().isEmpty()) {
            result.append("repeatDur = ").append(audioElement.getRepeatDur()).append("; ");
        }
        if (!audioElement.getSoundLevel().isEmpty()) {
            result.append("repeatDur = ").append(audioElement.getSoundLevel()).append("; ");
        }
        System.out.println(result.toString().trim());

        for (SSMLElementContract child : audioElement.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(BreakElement breakElement) {
        StringBuilder result = new StringBuilder("<BreakElement>");
        if (!breakElement.getTime().isEmpty()) {
            result.append("time = ").append(breakElement.getTime()).append("; ");
        }
        if (!breakElement.getStrength().isEmpty()) {
            result.append("strength = ").append(breakElement.getStrength()).append("; ");
        }
        System.out.println(result.toString().trim());
    }

    @Override
    public void visit(EmphasisElement emphasisElement) {
        StringBuilder result = new StringBuilder("<EmphasisElement>");
        if (!emphasisElement.getLevel().isEmpty()) {
            result.append("level = ").append(emphasisElement.getLevel()).append("; ");
        }
        System.out.println(result.toString().trim());
    }

    @Override
    public void visit(PElement pElement) {
        System.out.println("<PElement>");
        for (SSMLElementContract child : pElement.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(ProsodyElement prosodyElement) {
        StringBuilder result = new StringBuilder("<ProsodyElement>");
        if (!prosodyElement.getRate().isEmpty()) {
            result.append("rate = ").append(prosodyElement.getRate()).append("; ");
        }
        if (!prosodyElement.getPitch().isEmpty()) {
            result.append("pitch = ").append(prosodyElement.getPitch()).append("; ");
        }
        System.out.println(result.toString().trim());

        for (SSMLElementContract child : prosodyElement.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(SayAsElement sayAsElement) {
        StringBuilder result = new StringBuilder("<SayAsElement>");
        if (!sayAsElement.getInterpretAs().isEmpty()) {
            result.append("interpretAs = ").append(sayAsElement.getInterpretAs()).append("; ");
        }
        if (!sayAsElement.getFormat().isEmpty()) {
            result.append("format = ").append(sayAsElement.getFormat()).append("; ");
        }
        if (!sayAsElement.getDetail().isEmpty()) {
            result.append("detail = ").append(sayAsElement.getDetail()).append("; ");
        }
        System.out.println(result.toString().trim());
    }

    @Override
    public void visit(SElement sElement) {
        System.out.println("<SElement>");
        for (SSMLElementContract child : sElement.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(SpeakElement speakElement) {
        System.out.println("<SpeakElement>");
    }

    @Override
    public void visit(SubElement subElement) {
        System.out.println("<SubElement>");
        for (SSMLElementContract child : subElement.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(TextElement textElement) {
        StringBuilder result = new StringBuilder();
        if (!textElement.getTextContent().isEmpty()) {
            result.append(textElement.getTextContent());
        }
        System.out.println(result.toString().trim());
    }

    @Override
    public void visit(VoiceElement voiceElement) {
        StringBuilder result = new StringBuilder("<VoiceElement>");
        if (!voiceElement.getGender().isEmpty()) {
            result.append("interpretAs = ").append(voiceElement.getGender()).append("; ");
        }
        if (!voiceElement.getVariant().isEmpty()) {
            result.append("format = ").append(voiceElement.getVariant()).append("; ");
        }
        if (!voiceElement.getLanguage().isEmpty()) {
            result.append("detail = ").append(voiceElement.getLanguage()).append("; ");
        }
        if (!voiceElement.getRequired().isEmpty()) {
            result.append("required = ").append(voiceElement.getRequired()).append("; ");
        }
        if (!voiceElement.getOrdering().isEmpty()) {
            result.append("ordering = ").append(voiceElement.getOrdering()).append("; ");
        }
        System.out.println(result.toString().trim());
    }


}
