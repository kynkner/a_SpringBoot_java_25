package com.example.movieapp;

import com.example.movieapp.entity.*;
import com.example.movieapp.model.enums.MovieType;
import com.example.movieapp.model.enums.UserRole;
import com.example.movieapp.repository.*;
import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
class MovieAppApplicationTests {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UsersRepository UsersRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ActorsRepository actorsRepository;
    @Autowired
    private DirectorsRepository DirectorsRepository;
    @Autowired
    private EpisodesRepository episodesRepository;
    @Autowired
    private FaviritesRepository FaviritesRepository;
    @Autowired
    private GenresRepository GenresRepository;
    @Autowired
    private HistoriesRepository HistoriesRepository;
    @Autowired
    private ReviewsRepository ReviewsRepository;



    @Test
    void save_users() {
        Faker faker = new Faker();
        for (int i = 0; i < 50; i++) {
            String name = faker.name().fullName();
            Users user = Users.builder()
                    .name(name)
                    .email(faker.internet().emailAddress())
                    .avatar("https://placehold.co/200x200?text=" + name.substring(0, 1).toUpperCase())
                    .password("123")
                    .role(i == 0 || i == 1 ? UserRole.ADMIN : UserRole.USER)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            UsersRepository.save(user);
        }
    }

    @Test
    void save_genres() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        for (int i = 0; i < 10; i++) {
            String name = faker.leagueOfLegends().champion();
            Genres genre = Genres.builder()
                    .name(name)
                    .slug(slugify.slugify(name))
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            GenresRepository.save(genre);
        }
    }

    @Test
    void save_countries() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        for (int i = 0; i < 10; i++) {
            String name = faker.country().name();
            Country country = Country.builder()
                    .name(name)
                    .slug(slugify.slugify(name))
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            countryRepository.save(country);
        }
    }

    @Test
    void save_actors() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        for (int i = 0; i < 100; i++) {
            String name = faker.name().fullName();
            Actors actor = Actors.builder()
                    .name(name)
                    .slug(slugify.slugify(name))
                    .avatar("https://placehold.co/200x200?text=" + name.substring(0, 1).toUpperCase())
                    .bio(faker.lorem().paragraph())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            actorsRepository.save(actor);
        }
    }

    @Test
    void save_directors() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        for (int i = 0; i < 20; i++) {
            String name = faker.name().fullName();
            Directors director = Directors.builder()
                    .name(name)
                    .slug(slugify.slugify(name))
                    .avatar("https://placehold.co/200x200?text=" + name.substring(0, 1).toUpperCase())
                    .bio(faker.lorem().paragraph())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            DirectorsRepository.save(director);
        }
    }

    @Test
    void save_movies() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        Random rd = new Random();

        List<Country> countries = countryRepository.findAll();
        List<Actors> actors = actorsRepository.findAll();
        List<Directors> directors = DirectorsRepository.findAll();
        List<Genres> genres = GenresRepository.findAll();

        for (int i = 0; i < 150; i++) {
            // Random 1 country
            Country rdCountry = countries.get(rd.nextInt(countries.size()));

            // Random 1 -> 3 genres
            List<Genres> rdGenres = new ArrayList<>();
            for (int j = 0; j < rd.nextInt(3) + 1; j++) {
                Genres rdGenre = genres.get(rd.nextInt(genres.size()));
                if (!rdGenres.contains(rdGenre)) {
                    rdGenres.add(rdGenre);
                }
            }

            // Random 5 -> 7 actors
            List<Actors> rdActors = new ArrayList<>();
            for (int j = 0; j < rd.nextInt(3) + 5; j++) {
                Actors rdActor = actors.get(rd.nextInt(actors.size()));
                if (!rdActors.contains(rdActor)) {
                    rdActors.add(rdActor);
                }
            }

            // Random 1 -> 3 directors
            List<Directors> rdDirectors = new ArrayList<>();
            for (int j = 0; j < rd.nextInt(3) + 1; j++) {
                Directors rdDirector = directors.get(rd.nextInt(directors.size()));
                if (!rdDirectors.contains(rdDirector)) {
                    rdDirectors.add(rdDirector);
                }
            }

            String name = faker.name().fullName();
            Boolean status = faker.bool().bool();
            Movie movie = Movie.builder()
                    .name(name)
                    .slug(slugify.slugify(name))
                    .description(faker.lorem().paragraph())
                    .poster("https://placehold.co/200x200?text=" + name.substring(0, 1).toUpperCase())
                    .releaseYear(faker.number().numberBetween(2020, 2024))
                    .rating(faker.number().randomDouble(1, 6, 10))
                    .trailerURL("https://www.youtube.com/embed/gCUg6Td5fgQ?si=OCtNkpFF03gq03ny")
                    .type(MovieType.values()[rd.nextInt(MovieType.values().length)])
                    .status(status)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .publishedAt(status ? LocalDateTime.now() : null)
                    .country(rdCountry)
                    .actors(rdActors)
                    .directors(rdDirectors)
                    .genres(rdGenres)
                    .build();
            movieRepository.save(movie);
        }
    }

    @Test
    void save_reviews() {
        Faker faker = new Faker();
        Random rd = new Random();

        List<Movie> movies = movieRepository.findAll();
        List<Users> users = UsersRepository.findAll();

        for (Movie movie : movies) {
            // Create 10 -> 20 reviews for each movie
            for (int i = 0; i < rd.nextInt(11) + 10; i++) {
                // Random 1 user
                Users rdUser = users.get(rd.nextInt(users.size()));

                Reviews review = Reviews.builder()
                        .content(faker.lorem().paragraph())
                        .rating(rd.nextInt(6) + 5)
                        .movie(movie)
                        .user(rdUser)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();
                ReviewsRepository.save(review);
            }
        }
    }

    @Test
    void save_episodes() {
        Faker faker = new Faker();
        Random rd = new Random();

        List<Movie> movies = movieRepository.findAll();

        for (Movie movie : movies) {
            if (movie.getType().equals(MovieType.PHIM_BO)) {
                // Random 5 -> 10 episodes for each movie
                for (int i = 0; i < rd.nextInt(6) + 5; i++) {
                    Episodes episode = Episodes.builder()
                            .name("Tap " + (i + 1))
                            .duration(rd.nextInt(31) + 30)
                            .displayOder(i + 1)
                            .videoURL("https://www.youtube.com/embed/gCUg6Td5fgQ?si=OCtNkpFF03gq03ny")
                            .movie(movie)
                            .status(true)
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .publishedAt(LocalDateTime.now())
                            .build();
                    episodesRepository.save(episode);
                }
            } else {
                Episodes episode = Episodes.builder()
                        .name("Tap full")
                        .duration(rd.nextInt(91) + 30)
                        .displayOder(1)
                        .videoURL("https://www.youtube.com/embed/gCUg6Td5fgQ?si=OCtNkpFF03gq03ny")
                        .movie(movie)
                        .status(true)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .publishedAt(LocalDateTime.now())
                        .build();
                episodesRepository.save(episode);
            }
        }
    }

    @Test
    void save_blogs() {
        Faker faker = new Faker();
        Random rd = new Random();
        Slugify slugify = Slugify.builder().build();

        List<Users> users = UsersRepository.findByRole(UserRole.ADMIN);

        for (int i = 0; i < 100; i++) {
            // random 1 user
            Users rdUser = users.get(rd.nextInt(users.size()));

            String title = faker.book().title();
            boolean status = rd.nextInt(2) == 0;
            Blogs blog = Blogs.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().paragraph())
                    .content(faker.lorem().paragraph(100))
                    .status(status)
                    .thumbnail(generateLinkImage(title))
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .publishedAt(status ? LocalDateTime.now() : null)
                    .user(rdUser)
                    .build();

            blogRepository.save(blog);
        }
    }

    private String generateLinkImage(String name) {
        return "https://placehold.co/200x200?text=" + name.substring(0, 1).toUpperCase();
    }
    @Test
    void test_methods(){
//        List<Movie> movies = movieRepository.findAll();
//        System.out.println("Movies size: " + movies.size());
//
//        Movie movie1 = movieRepository.findById(1).orElse(null);
//        System.out.println("Movie 1: " + movie1);
//
//        List<Movie> movieByIds = movieRepository.findAllById(List.of(1, 2, 3));
//        System.out.println("movieByIds: " + movieByIds);
//
//        //update
//        movie1.setName("chua te nhung chiec nhan");
//        movieRepository.save(movie1);
//
//        //delete
//        movieRepository.delete(movie1);
////        movieRepository.deleteById(2);
////        movieRepository.deleteAllById(List.of(1, 2, 3));
////        movieRepository.deleteAll();
    }
    @Test
    public void testMethodQuery(){
//        long countPhimBo = movieRepository.countByType(MovieType.PHIM_BO);
//        System.out.println("So luong phim bo: " + countPhimBo);
//
//        List<Movie> movies = movieRepository.findByStatus(true, Sort.by("name","releaseYear").descending());
//        movies.forEach(System.out::println);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Movie> pageData = movieRepository.findByStatus(true, pageable);
        System.out.println("Total pages: " + pageData.getTotalPages());
        System.out.println("Total elements: " + pageData.getTotalElements());
        System.out.println("Is first" + pageData.isFirst());
        pageData.getContent().forEach(System.out::println);

    }



}
