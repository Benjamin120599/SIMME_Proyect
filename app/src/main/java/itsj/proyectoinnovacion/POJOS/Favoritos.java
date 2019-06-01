package itsj.proyectoinnovacion.POJOS;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Favoritos {

    @PrimaryKey
    @NonNull
    private String title;
    @ColumnInfo(name = "pub_date")
    private String pubDate;
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "link")
    private String link;

    public Favoritos() {

    }

    public Favoritos(String title, String pubDate, String content, String link) {
        this.title = title;
        this.pubDate = pubDate;
        this.content = content;
        this.link = link;
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

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
