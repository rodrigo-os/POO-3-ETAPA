package s1mplenote.entities;

import java.util.ArrayList;

public class NoteDeleted extends Annotation{
    private ArrayList<Tag> tagsDeleted = new ArrayList<Tag>();

    public NoteDeleted(String title, String text, ArrayList<Tag> tagsDeleted) {
        super(title, text);
        this.tagsDeleted = null;
    }

    public NoteDeleted(String title, String text) {
        super(title, text);
    }

    public ArrayList<Tag> getTagsDeleted() {
        return tagsDeleted;
    }

    public void setTagsDeleted(ArrayList<Tag> tagsDeleted) {
        this.tagsDeleted = tagsDeleted;
    }

    @Override
    public String getStatus() {
        setApagado(true);
        return "Sou uma anotação que foi apagada.";
    }
}
