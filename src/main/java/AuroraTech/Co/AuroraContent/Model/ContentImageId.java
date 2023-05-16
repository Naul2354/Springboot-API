package AuroraTech.Co.AuroraContent.Model;

import javax.persistence.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ContentImageId implements Serializable {
    private int contentId;
    private int imageId;
    public ContentImageId(){

    }
    public ContentImageId(Integer contentId, Integer imageId) {

    }
    //constructor
    public ContentImageId(int contentId, int imageId) {
        this.contentId = contentId;
        this.imageId = imageId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return this.imageId;
    }
}
