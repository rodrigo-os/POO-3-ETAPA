package s1mplenote.entities;

import java.util.ArrayList;

public class Trash {
    private boolean empty = true;
    private ArrayList<NoteDeleted> notesDeleted = new ArrayList<NoteDeleted>();

    public Trash() {

    }

    public Trash(boolean empty) {
        this.empty = empty;
    }

    public boolean getEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public ArrayList<NoteDeleted> getNotesDeleted() {
        return notesDeleted;
    }

    public void setNotesDeleted(ArrayList<NoteDeleted> notesDeleted) {
        this.notesDeleted = notesDeleted;
    }

}