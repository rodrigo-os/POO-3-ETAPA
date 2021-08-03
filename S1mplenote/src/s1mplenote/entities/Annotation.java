package s1mplenote.entities;

public abstract class Annotation {
    private String title;
    private String text;
    private boolean apagado;

    public Annotation(String title, String text, boolean apagado) {
        this.title = title;
        this.text = text;
        this.apagado = apagado;
    }

    public Annotation(String title, String text) {
        super();
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getApagado() {
        return apagado;
    }

    public void setApagado(boolean apagado) {
        this.apagado = apagado;
    }

    public abstract String getStatus();
}
