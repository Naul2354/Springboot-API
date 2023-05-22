package AuroraTech.Co.AuroraContent.Controller;

import AuroraTech.Co.AuroraContent.Model.Content;
import AuroraTech.Co.AuroraContent.Model.Image;
//import AuroraTech.Co.AuroraContent.Service.ImageService;
import AuroraTech.Co.AuroraContent.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://20.187.126.190:9999")

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    // Get all images
    @GetMapping()
    public List<Image> getAllImages() {
        List<Image> a = imageRepository.findAll();
        return a;
    }

    @GetMapping("/")
    public ResponseEntity<Image> getImageById(@RequestParam ("id") Integer id) {
        Optional<Image> image = imageRepository.findById(id);
        if (image.isPresent()) {
            return new ResponseEntity<>(image.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Get image by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Image> getImageById(@PathVariable int id) {
//        Optional<Image> image = imageRepository.findById(id);
//        if (image.isPresent()) {
//            return new ResponseEntity<>(image.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    // Create image
    @PostMapping()
    public ResponseEntity<Image> createImage(@RequestBody Image image) {
        Image savedImage = imageRepository.save(image);
        return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
    }

    // Update image
    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable int id, @RequestBody Image image) {
        Optional<Image> existingImage = imageRepository.findById(id);
        if (existingImage.isPresent()) {
            image.setId(id);
            Image savedImage = imageRepository.save(image);
            return new ResponseEntity<>(savedImage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete image
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteImage(@PathVariable int id) {
        Optional<Image> existingImage = imageRepository.findById(id);
        if (existingImage.isPresent()) {
            imageRepository.delete(existingImage.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

