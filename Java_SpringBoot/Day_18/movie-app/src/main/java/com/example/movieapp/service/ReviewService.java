package com.example.movieapp.service;

import com.example.movieapp.entity.Movie;
import com.example.movieapp.entity.Reviews;
import com.example.movieapp.entity.Users;
import com.example.movieapp.model.request.CreateReviewRequest;
import com.example.movieapp.model.request.UpdateReviewRequest;
import com.example.movieapp.repository.MovieRepository;
import com.example.movieapp.repository.ReviewsRepository;
import com.example.movieapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewsRepository reviewsRepository;
    private final MovieRepository movieRepository;
    private final UsersRepository usersRepository;

    public List<Reviews> getReviewsByMovieId(Integer movieId) {
        return reviewsRepository.findByMovie_Id(movieId, Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Reviews createReview(CreateReviewRequest request) {
        //TODO: Fix User. Sau nay user se la user dang nhap
        Integer userId = 1;
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found" + userId));

        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie Not Found" + request.getMovieId()));

        //TODO: Bo sung validate rating, content

        Reviews reviews = Reviews.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .movie(movie)
                .user(user)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return reviewsRepository.save(reviews);
    }

    public Reviews updateReview(Integer id, UpdateReviewRequest request) {
        // TODO: Fix user. Sau này user sẽ là user đang đăng nhập
        Integer userId = 1;
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Reviews review = reviewsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));

        if (!review.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You are not owner of this review");
        }

        // TODO: Bổ sung validate rating, content
        review.setContent(request.getContent());
        review.setRating(request.getRating());
        review.setUpdatedAt(LocalDateTime.now());
        return reviewsRepository.save(review);
    }

    public void deleteReview(Integer id) {
        // TODO: Fix user. Sau này user sẽ là user đang đăng nhập
        Integer userId = 1;
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Reviews review = reviewsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));

        if (!review.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You are not owner of this review");
        }
        reviewsRepository.delete(review);
    }
}
