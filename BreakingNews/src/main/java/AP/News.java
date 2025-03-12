package AP;

public class News {
    private String title;
    private String author;
    private String description;
    private String sourceName;
    private String url;
    private String publishedAt;

    public News() {
    }

    public void setData(String title, String author, String description, String sourceName, String url, String publishedAt) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.sourceName = sourceName;
        this.url = url;
        this.publishedAt = publishedAt;
    }

    public void displayNews() {
        System.out.println("--Title: " + this.title);
        System.out.println("--Author: " + this.author);
        System.out.println("--Description: " + this.description);
        System.out.println("--Source: " + this.sourceName);
        System.out.println("--URL: " + this.url);
        System.out.println("--Published At: " + this.publishedAt);
    }

    public String toString() {
        return (" --Title: " + title);
    }
}
