package ua.kiev.minaeva.ssml.visitor;

import ua.kiev.minaeva.ssml.element.*;

public interface SSMLElementVisitor {

    void visit(AudioElement audioElement);

    void visit(BreakElement breakElement);

    void visit(EmphasisElement emphasisElement);

    void visit(PElement pElement);

    void visit(ProsodyElement prosodyElement);

    void visit(SayAsElement sayAsElement);

    void visit(SElement sElement);

    void visit(SpeakElement speakElement);

    void visit(SubElement subElement);

    void visit(TextElement textElement);

    void visit(VoiceElement voiceElement);

}
