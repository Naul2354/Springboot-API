package AuroraTech.Co.AuroraContent.Controller;

import AuroraTech.Co.AuroraContent.Model.Content;
import AuroraTech.Co.AuroraContent.Model.ContentImage;
//import AuroraTech.Co.AuroraContent.Service.ContentImageService;
import AuroraTech.Co.AuroraContent.Model.ContentImageId;
import AuroraTech.Co.AuroraContent.Repository.ContentImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content-image")
public class ContentImageController {

    @Autowired
    private ContentImageRepository contentImageRepository;

    @GetMapping("/{contentId}/{imageId}")
    public ContentImage getContentImageById(@PathVariable(value = "contentId") Integer contentId,
                                            @PathVariable(value = "imageId") Integer imageId) {
        ContentImageId id = new ContentImageId(contentId, imageId);
        return contentImageRepository.findById(id).orElse(null);
    }

    @GetMapping()
    public List<ContentImage> getAllContentImages() {
        return contentImageRepository.findAll();
    }

    @PostMapping("/")
    public ContentImage createContentImage(@RequestBody ContentImage contentImage) {
        return contentImageRepository.save(contentImage);
    }

//    @PutMapping("/{contentId}/{imageId}")
//    public ContentImage updateContentImage(@PathVariable(value = "contentId") Integer contentId,
//                                           @PathVariable(value = "imageId") Integer imageId,
//                                           @RequestBody Content

}
