const stars = document.querySelectorAll(".rating .star");
const ratingValue = document.getElementById("rating-value");
const reviewListEl = document.querySelector(".review-list");
const formReviewEl = document.getElementById("form-review");
const reviewContentEl = document.getElementById("review-content");
const reviewIdEl = document.getElementById("review-id");
const modalReviewLabel = document.getElementById("modalReviewLabel");

let currentRating = 0;

stars.forEach((star) => {
    star.addEventListener("mouseover", () => {
        resetStars();
        const rating = parseInt(star.getAttribute("data-rating"));
        highlightStars(rating);
    });

    star.addEventListener("mouseout", () => {
        resetStars();
        highlightStars(currentRating);
    });

    star.addEventListener("click", () => {
        currentRating = parseInt(star.getAttribute("data-rating"));
        ratingValue.textContent = `Bạn đã đánh giá ${currentRating} sao.`;
        highlightStars(currentRating);
    });
});

function resetStars() {
    stars.forEach((star) => {
        star.classList.remove("active");
    });
}

function highlightStars(rating) {
    stars.forEach((star) => {
        const starRating = parseInt(star.getAttribute("data-rating"));
        if (starRating <= rating) {
            star.classList.add("active");
        }else{
            star.classList.remove("active");
        }
    });
}

// Hien thi danh sach review
const reviewListEl = document.querySelector(".review-list");
const renderReviews = reviews => {
    let html = "";
    reviews.forEach(review => {
        html += `
            <div class="rating-item d-flex align-items-center mb-3 pb-3">
                <div class="rating-avatar">
                    <img src="${review.user.avatar}" alt="${review.user.name}">
                </div>
                <div class="rating-info ms-3">
                    <div class="d-flex align-items-center">
                        <p class="rating-name mb-0"><strong>${review.user.name}</strong></p>
                        <p class="rating-time mb-0 ms-2">${formatDate(review.createdAt)}</p>
                    </div>
                    <div class="rating-star">
                        <p class="mb-0 fw-medium">
                            <span class="rating-icon me-1"><i class="fa fa-star"></i></span>
                            <span>${review.rating}/10</span>
                        </p>
                    </div>
                    <p class="rating-content mt-1 mb-0 text-muted">${review.content}</p>
                    <div class="mt-2">
                        <button class="btn btn-sm btn-primary btn-edit-review" data-id="${review.id}" data-rating="${review.rating}" data-content="${review.content}">Chỉnh sửa</button>
                        <button class="btn btn-sm btn-danger btn-delete-review" data-id="${review.id}">Xóa</button>
                    </div>
                </div>
            </div>
        `;
    });
    reviewListEl.innerHTML = html;
    // attachReviewButtons();

}

const formatDate = dateString => {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = ("0" + (date.getMonth() + 1)).slice(-2); // 09 -> 09 , 011 -> 11
    const day = ("0" + date.getDate()).slice(-2);
    return `${day}/${month}/${year}`;
}

const formReviewEl = document.getElementById("form-review");
const reviewContentEl = document.getElementById("review-content");
formReviewEl.addEventListener("submit", (e) => {
    e.preventDefault();
    const reviewId = reviewIdEl.value;
    if(reviewId){
        updateReview(reviewId);
    }else{
        createReview();
    }
})

// Tạo review
const createReview = async () => {
    if (currentRating === 0) {
        alert("Vui lòng chọn số sao");
        return;
    }

    if (reviewContentEl.value.trim() === "") {
        alert("Vui lòng nhập nội dung bình luận");
        return;
    }

    const request = {
        rating: currentRating,
        content: reviewContentEl.value,
        movieId: movie.id
    }
    console.log(request);

    try {
        let res = await axios.post("/api/reviews", request);
        console.log(res.data)
        reviews.unshift(res.data);
        renderReviews(reviews);
    } catch (error) {
        console.log(error);
    }
}

// Cập nhật review
const updateReview = async (id) => {
    if (currentRating === 0) {
        alert("Vui lòng chọn số sao");
        return;
    }

    if (reviewContentEl.value.trim() === "") {
        alert("Vui lòng nhập nội dung bình luận");
        return;
    }

    const request = {
        rating: currentRating,
        content: reviewContentEl.value
    };
    console.log(request);

    try {
        let res = await axios.put(`/api/reviews/${id}`, request);
        console.log(res.data);
        // Cập nhật review trong mảng reviews
        const index = reviews.findIndex(review => review.id === id);
        if (index !== -1) {
            reviews[index] = res.data;
            renderReviews(reviews);
        }
        // Reset form
        resetForm();
        // Ẩn modal
        const modal = bootstrap.Modal.getInstance(document.getElementById('modalReview'));
        modal.hide();
    } catch (error) {
        console.error(error);
        alert("Đã xảy ra lỗi khi cập nhật bình luận.");
    }
};


// Xóa review
const deleteReview = async (id) => {
    if (!confirm("Bạn có chắc chắn muốn xóa bình luận này?")) {
        return;
    }

    try {
        await axios.delete(`/api/reviews/${id}`);
        reviews = reviews.filter(review => review.id !== id);
        renderReviews(reviews);
    } catch (error) {
        console.error(error);
        alert("Đã xảy ra lỗi khi xóa bình luận.");
    }
};

// reset form
const resetForm = () => {
    formReviewEl.reset();
    reviewIdEl.value = "";
    currentRating = 0;
    resetStars();
    ratingValue.textContent = "Vui lòng chọn đánh giá";
    modalReviewLabel.textContent = "Tạo bình luận";
};
// Hàm để điền dữ liệu vào form khi chỉnh sửa review
const populateFormForEdit = (id, rating, content) => {
    reviewIdEl.value = id;
    currentRating = rating;
    highlightStars(currentRating);
    reviewContentEl.value = content;
    ratingValue.textContent = `Bạn đã đánh giá ${currentRating} sao.`;
    modalReviewLabel.textContent = "Cập nhật bình luận";
    // Hiển thị modal
    const modal = new bootstrap.Modal(document.getElementById('modalReview'));
    modal.show();
};

// Hàm để gắn sự kiện cho các nút Chỉnh sửa và Xóa
const attachReviewButtons = () => {
    const editButtons = document.querySelectorAll(".btn-edit-review");
    const deleteButtons = document.querySelectorAll(".btn-delete-review");

    editButtons.forEach(button => {
        button.addEventListener("click", () => {
            const id = parseInt(button.getAttribute("data-id"));
            const rating = parseInt(button.getAttribute("data-rating"));
            const content = button.getAttribute("data-content");
            populateFormForEdit(id, rating, content);
        });
    });

    deleteButtons.forEach(button => {
        button.addEventListener("click", () => {
            const id = parseInt(button.getAttribute("data-id"));
            deleteReview(id);
        });
    });
};