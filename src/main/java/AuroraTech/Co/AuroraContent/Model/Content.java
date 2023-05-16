package AuroraTech.Co.AuroraContent.Model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "content")
public class Content {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private String title;
    private int status;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
//  @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne()
    @JoinColumn(name = "category")
    private Category category;
    public Content(){

    }
    public Content(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "content",cascade = CascadeType.ALL)
    private List<ContentImage> contentImages;

    // getters and setters

    @Override
    public String toString() {
        return "Content{" +
            "id=" + id +
            ", content='" + content + '\'' +
            ", title='" + title + '\'' +
            ", status=" + status +
            ", createdTime=" + createdTime +
            ", updatedTime=" + updatedTime +
            ", category=" + category +
            '}';
    }
}
