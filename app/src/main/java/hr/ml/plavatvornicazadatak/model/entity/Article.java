package hr.ml.plavatvornicazadatak.model.entity;

public class Article {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String uriToImage;
    private Long publishedAt;

    public Article(String author, String title, String description, String url,
                   String urlToImage, Long publishedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
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
