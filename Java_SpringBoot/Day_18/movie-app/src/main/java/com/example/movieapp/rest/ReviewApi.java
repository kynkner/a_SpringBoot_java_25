package com.example.movieapp.rest;

import com.example.movieapp.entity.Reviews;
import com.example.movieapp.model.request.CreateReviewRequest;
import com.example.movieapp.model.request.UpdateReviewRequest;
import com.example.movieapp.model.response.ErrorResponse;
import com.example.movieapp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewApi {
    private final ReviewService reviewService;
    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody CreateReviewRequest request) {
        try {
            Reviews review = reviewService.createReview(request);
            return ResponseEntity.ok(review);
        }catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    // /api/reviews/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@RequestBody UpdateReviewRequest request,
                                          @PathVariable Integer id) {
        try {
            Reviews review = reviewService.updateReview(id, request);
            return ResponseEntity.ok(review);
        }catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer id) {
        try {
            reviewService.deleteReview(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
