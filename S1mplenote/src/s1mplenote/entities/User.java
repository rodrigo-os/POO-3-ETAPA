package s1mplenote.entities;

import java.util.ArrayList;

public class User {
    private String email;
    private String password;
    private Trash trash = new Trash(true);
    private Settings settings = new Settings(true, true);

    private ArrayList<Note> notes = new ArrayList<Note>();

    private ArrayList<Tag> tags = new ArrayList<Tag>();

    private ArrayList<NoteDeleted> notesDeleted = new ArrayList<NoteDeleted>();

    public User(String email, String password, Trash trash, Settings settings) {
        this.email = email;
        this.password = password;
        this.trash = trash;
        this.settings = settings;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Trash getTrash() {
        return trash;
    }

    public void setTrash(Trash trash) {
        this.trash = trash;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public ArrayList<NoteDeleted> getNotesDeleted() {
        return notesDeleted;
    }

    public void setNotesDeleted(ArrayList<NoteDeleted> notesDeleted) {
        this.notesDeleted = notesDeleted;
    }
}
