//package AuroraTech.Co.AuroraContent.Pagination;
//
//import AuroraTech.Co.AuroraContent.Model.Image;
//import AuroraTech.Co.AuroraContent.Repository.ImageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/images")
//public class PaginationImageController {
//    private static final int ITEMS_PER_PAGE = 10;
//    private static final int TOTAL_PAGES = 5;
//    @Autowired
//    private ImageRepository imageRepository;
//    @GetMapping("/")
//    public List<Image> getImagesByPage(@RequestParam(value = "page")int pageNumber){
//        int pageIndex = pageNumber -1;
//
//        List<Image> pageImages = imageRepository.findAll(PageRequest.of(pageIndex,ITEMS_PER_PAGE)).getContent();
//
//        return pageImages;
//    }
//
//}
