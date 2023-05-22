package AuroraTech.Co.AuroraContent.Model;

import javax.persistence.*;

@Entity
@Table(name = "content_image")
public class ContentImage {
    @EmbeddedId
    private ContentImageId id;

    @MapsId("contentId")
    @JoinColumn(name = "content_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Content content;

    @MapsId("imageId")
    @JoinColumn(name = "image_id")
    @ManyToOne
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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    //toString

}
