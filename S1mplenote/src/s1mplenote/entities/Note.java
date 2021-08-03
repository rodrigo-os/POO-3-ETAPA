package s1mplenote.entities;

import java.util.ArrayList;

public class Note extends Annotation{
    private ArrayList<Tag> tags = new ArrayList<Tag>();

    public Note(String title, String text, ArrayList<Tag> tags) {
        super(title, text);
        this.tags = tags;
    }

    public Note(String title, String text) {
        super(title, text);
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String getStatus() {
        setApagado(false);
        return "Sou uma anotação que ainda existe.";
    }
}