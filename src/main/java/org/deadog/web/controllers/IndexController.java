package org.deadog.web.controllers;

import org.deadog.web.models.FeedBackMessage;
import org.deadog.web.models.MovieReview;
import org.deadog.web.models.SingleNews;
import org.deadog.web.services.FeedBackMessageService;
import org.deadog.web.services.MovieReviewService;
import org.deadog.web.services.PremierService;
import org.deadog.web.services.SingleNewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class IndexController {
    private final FeedBackMessageService feedBackMessageService;
    private final PremierService premierService;
    private final MovieReviewService movieReviewService;
    private final SingleNewsService singleNewsService;

    public IndexController(FeedBackMessageService feedBackMessageService, PremierService premierService, MovieReviewService movieReviewService, SingleNewsService singleNewsService) {
        this.feedBackMessageService = feedBackMessageService;
        this.premierService = premierService;
        this.movieReviewService = movieReviewService;
        this.singleNewsService = singleNewsService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("premiers", premierService.findAll());
        model.addAttribute("movieReviews", movieReviewService.findAll());
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("news", singleNewsService.findAll());
        return "news";
    }

    @GetMapping("/news/create")
    public String getCreateNews() {
        return "createNews";
    }

    @PostMapping("/news/create")
    public String createNews(@RequestParam("title") String title,
                             @RequestParam("image") MultipartFile image,
                             @RequestParam("description") String description,
                             @RequestParam("text") String text) {
        SingleNews singleNews = new SingleNews();
        singleNews.setTitle(title);
        singleNews.setDescription(description);
        singleNews.setText(text);

        if (!image.isEmpty()) {
            try {
                byte[] bytes = image.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream("src/main/resources/static/images/" + image.getOriginalFilename()));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
            }
            singleNews.setImageFileName(image.getOriginalFilename());
        } else {
            System.out.println("Вам не удалось загрузить файл, потому что он пустой");
        }
        singleNewsService.create(singleNews);
        return "redirect:/news";
    }

    @PostMapping("/news/delete/{id}")
    public String deleteNews(@PathVariable("id") int id) {
        singleNewsService.deleteById(id);
        return "redirect:/news";
    }

    @GetMapping("/news/{id}")
    public String news(@PathVariable("id") int id, Model model) {
        SingleNews news = singleNewsService.findById(id);
        if (news != null) {
            model.addAttribute("singleNews", news);
            return "singleNews";
        } else {
            return "redirect:/news";
        }
    }

    @GetMapping("/reviews/{id}")
    public String review(@PathVariable("id") int id, Model model) {
        MovieReview movieReview = movieReviewService.findById(id);
        if (movieReview != null) {
            model.addAttribute("movieReview", movieReview);
            return "movieReview";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/contacts/")
    public String feedback(@RequestParam("name") String name, @RequestParam("email") String email,
                           @RequestParam("message") String message) {
        FeedBackMessage feedBackMessage = new FeedBackMessage(name, email, message);
        feedBackMessageService.create(feedBackMessage);
        return "redirect:/contacts";
    }
}
