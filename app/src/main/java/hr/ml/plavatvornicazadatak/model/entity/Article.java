package hr.ml.plavatvornicazadatak.model.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "article",
        indices = {@Index(value = "title", unique = true)})
public class Article {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String uriToImage;
    private Long publishedAt;

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setPublishedAt(Long publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setUriToImage(String uriToImage) {
        this.uriToImage = uriToImage;
    }

    public int getId() {
        return id;
    }

    public String getUriToImage() {
        return uriToImage;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public Long getPublishedAt() {
        return publishedAt;
    }
}
