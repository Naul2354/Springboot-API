package AuroraTech.Co.AuroraContent.Model;

import javax.persistence.*;

@Entity
@Table(name = "content_image")
public class ContentImage {
    @EmbeddedId
    private ContentImageId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("contentId")
    @JoinColumn(name = "content_id")
    private Content content;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("imageId")
    @JoinColumn(name = "image_id")
    private Image image;
    //constructor
    public ContentImage(){

    }
    public ContentImage(ContentImageId id) {
        this.id = id;
    }
    public ContentImageId getId() {
        return id;
    }

    public void setId(ContentImageId id) {
        this.id = id;
    }

//    public Content getContent() {
//        return content;
//    }
//
//    public void setContent(Content content) {
//        this.content = content;
//    }
//
//    public Image getImage() {
//        return image;
//    }
//
//    public void setImage(Image image) {
//        this.image = image;
//    }
    //toString

}
