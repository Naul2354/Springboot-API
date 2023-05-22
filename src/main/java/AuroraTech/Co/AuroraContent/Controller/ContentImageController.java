package AuroraTech.Co.AuroraContent.Controller;

import AuroraTech.Co.AuroraContent.Model.Content;
import AuroraTech.Co.AuroraContent.Model.ContentImage;
//import AuroraTech.Co.AuroraContent.Service.ContentImageService;
import AuroraTech.Co.AuroraContent.Model.ContentImageId;
import AuroraTech.Co.AuroraContent.Repository.ContentImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content-image")
public class ContentImageController {

    @Autowired
    private ContentImageRepository contentImageRepository;

    //    @GetMapping("/{contentId}/{imageId}")
//    public ContentImage getContentImageById(@PathVariable(value = "contentId") Integer contentId,
//                                            @PathVariable(value = "imageId") Integer imageId) {
//        ContentImageId id = new ContentImageId(contentId, imageId);
//        return contentImageRepository.findById(id).orElse(null);
//    }
    @GetMapping("/")
    public ContentImage getContentImageById(@RequestParam("contentId") Integer contentId,
                                            @RequestParam("imageId") Integer imageId) {
        return contentImageRepository.findByContentIdAndImageId(contentId, imageId).orElse(null);
    }



    @GetMapping()
    public List<ContentImage> getAllContentImages() {
        return contentImageRepository.findAll();
    }

    @PostMapping("")
    public ContentImage createContentImage(@RequestBody ContentImage contentImage) {
        return contentImageRepository.save(contentImage);
    }
    @PutMapping("/{contentId}/{imageId}")
    public ResponseEntity<ContentImage> updateContentImage(
        @PathVariable("contentId") int contentId,
        @PathVariable("imageId") int imageId,
        @RequestBody ContentImage updatedContentImage) {

        // Check if the content image exists
        ContentImage existingContentImage = contentImageRepository.findById(new ContentImageId(contentId, imageId))
            .orElse(null);

        if (existingContentImage == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the content image
        existingContentImage.setContent(updatedContentImage.getContent());
        existingContentImage.setImage(updatedContentImage.getImage());

        // Save the updated content image
        ContentImage savedContentImage = contentImageRepository.save(existingContentImage);

        return ResponseEntity.ok(savedContentImage);
    }

}

