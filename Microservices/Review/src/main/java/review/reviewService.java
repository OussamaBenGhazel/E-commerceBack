package review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewService {

    @Autowired
    private reviewRepository reviewRepository;

    public review addReview(review review) {
        return reviewRepository.save(review);
    }

    public List<review> getReviewsByProduct(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public List<review> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}

