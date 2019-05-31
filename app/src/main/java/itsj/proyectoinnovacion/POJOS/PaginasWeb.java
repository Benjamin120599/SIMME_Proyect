package itsj.proyectoinnovacion.POJOS;

import android.webkit.WebSettings;
import android.webkit.WebView;

public class PaginasWeb {

    String titulo;
    String link;

    public PaginasWeb() {
    }

    public PaginasWeb(String titulo, String link) {
        this.titulo = titulo;
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public void setPaginas(String link, WebView webView) {
        WebSettings conf = webView.getSettings();
        conf.setJavaScriptEnabled(true);
        webView.loadUrl(link);
    }


}
