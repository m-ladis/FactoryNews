package hr.ml.plavatvornicazadatak.model.entity;

import java.util.List;

public class NewsResponse {
    private String status;
    private String source;
    private String sortBy;
    private List<Article> articles;

    public NewsResponse(String status, String source, String sortBy, List<Article> articles) {
        this.status = status;
        this.source = source;
        this.sortBy = sortBy;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
