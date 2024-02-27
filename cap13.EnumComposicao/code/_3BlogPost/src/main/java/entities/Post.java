package entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private Instant moment;
    private String title;
    private String content;
    private int likes = 0;
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String content) {
        this.moment = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        this.title = title;
        this.content = content;
    }

    public Instant getMoment() {
        return moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(this.title + "\n" +
                this.likes + " Likes - " + momentFormatted() + "\n" +
                this.content + "\n");

        if(!comments.isEmpty()) {
            output.append("Comments:").append("\n");
            for (Comment comment: comments) {
                output.append(comment.getText()).append("\n");
            }
        }
        return output.toString();
    }

    private String momentFormatted() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        return dateTimeFormatter.format(this.moment);
    }
}
