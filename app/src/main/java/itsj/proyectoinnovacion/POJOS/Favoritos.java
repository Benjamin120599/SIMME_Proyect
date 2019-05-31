package itsj.proyectoinnovacion.POJOS;

public class Favoritos {

    private String title;
    private String pubDate;
    private String content;

    public Favoritos() {

    }

    public Favoritos(String title, String pubDate, String content) {
        this.title = title;
        this.pubDate = pubDate;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
