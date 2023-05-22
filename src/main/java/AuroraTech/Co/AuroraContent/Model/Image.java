package AuroraTech.Co.AuroraContent.Model;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "image")
public class Image {
    @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime createdTime;
    @Lob
    private String image;


//    @OneToMany(mappedBy = "image",cascade = CascadeType.ALL)
//    private List<ContentImage> contentImages;
    //constructor
    public Image(){

    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public List<ContentImage> getContentImages() {
//        return contentImages;
//    }
//
//    public void setContentImages(List<ContentImage> contentImages) {
//        this.contentImages = contentImages;
//    }
    // getters and setters

    public Image(int id, String name, LocalDateTime createdTime, String image, List<ContentImage> contentImages) {
        this.id = id;
        this.name = name;
        this.createdTime = createdTime;
        this.image = image;
    }
}
