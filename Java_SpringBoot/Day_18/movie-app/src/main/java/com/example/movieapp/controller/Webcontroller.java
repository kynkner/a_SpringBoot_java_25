package com.example.movieapp.controller;

import com.example.movieapp.entity.Blogs;
import com.example.movieapp.entity.Movie;
import com.example.movieapp.entity.Reviews;
import com.example.movieapp.model.enums.MovieType;
import com.example.movieapp.repository.BlogRepository;
import com.example.movieapp.repository.MovieRepository;
import com.example.movieapp.service.BlogService;
import com.example.movieapp.service.MovieService;
import com.example.movieapp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class Webcontroller {
    private final MovieService movieService;
    private final BlogService blogService;
    private final ReviewService reviewService;

    @GetMapping()
    public String getHomePage(Model model){
        List<Movie> listPhimBo = movieService.getMoviesByType(MovieType.PHIM_BO, true, 1, 6).getContent();
        List<Movie> listPhimLe = movieService.getMoviesByType(MovieType.PHIM_LE, true, 1, 6).getContent();
        List<Movie> listPhimChieuRap = movieService.getMoviesByType(MovieType.PHIM_CHIEU_RAP, true, 1, 6).getContent();
        List<Movie> listPhimHot = movieService.getMoviesHot(4);
        List<Blogs> listBlog = blogService.getBlogs(true, 1, 4).getContent();

        model.addAttribute("listPhimBo", listPhimBo);
        model.addAttribute("listPhimLe", listPhimLe);
        model.addAttribute("listPhimChieuRap", listPhimChieuRap);
        model.addAttribute("listPhimHot", listPhimHot);
        model.addAttribute("listBlog", listBlog);
        return "web/index";
    }


    // /phim-bo?page=1&pageSize=12
    @GetMapping("phim-bo")
    public String getPhimBo(Model model,
                            @RequestParam(required = false, defaultValue = "1") int page,
                            @RequestParam(required = false,defaultValue = "12") int pageSize){
        Page<Movie> pageData = movieService.getMoviesByType(MovieType.PHIM_BO, true, page, pageSize);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim-bo";
    }

    @GetMapping("phim-le")
    public String getPhimLe(Model model,
                            @RequestParam(required = false, defaultValue = "1") int page,
                            @RequestParam(required = false,defaultValue = "12") int pageSize){
        Page<Movie> pageData = movieService.getMoviesByType(MovieType.PHIM_LE, true, page, pageSize);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim-le";
    }
    @GetMapping("phim-chieu-rap")
    public String getPhimChieuRap(Model model,
                            @RequestParam(required = false, defaultValue = "1") int page,
                            @RequestParam(required = false,defaultValue = "12") int pageSize){
        Page<Movie> pageData = movieService.getMoviesByType(MovieType.PHIM_CHIEU_RAP, true, page, pageSize);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim-chieu-rap";
    }
    @GetMapping("/phim/{id}/{slug}")
    public String getMovieDetailsPage(Model model,
                                      @PathVariable Integer id,
                                      @PathVariable String slug) {
        Movie movie = movieService.getMovieDetails(id, slug);
        List<Reviews> reviews = reviewService.getReviewsByMovieId(id);
        model.addAttribute("movie", movie);
        model.addAttribute("reviews", reviews);
        return "web/chi-tiet-phim";
    }

    @GetMapping("/tin-tuc")
    public String getBlogPage(Model model,
                              @RequestParam(required = false, defaultValue = "1") int page,
                              @RequestParam(required = false, defaultValue = "10") int pageSize) {
        Page<Blogs> pageData = blogService.getBlogs(true, page, pageSize);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/tin-tuc";
    }

    @GetMapping("/tin-tuc/{id}/{slug}")
    public String getBlogDetailsPage(Model model,
                                     @PathVariable Integer id,
                                     @PathVariable String slug) {
        Blogs blog = blogService.getBlogDetails(id, slug);
        model.addAttribute("blog", blog);
        return "web/chi-tiet-tin-tuc";
    }
}
