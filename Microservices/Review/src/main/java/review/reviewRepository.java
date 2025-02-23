package review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reviewRepository extends JpaRepository<review, Long> {
    List<review> findByProductId(Long productId);
    List<review> findByUserId(Long userId);
}
