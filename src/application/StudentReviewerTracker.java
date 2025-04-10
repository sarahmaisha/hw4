package application;

import java.util.ArrayList;
import java.util.List;

public class StudentReviewerTracker {
    private String studentName = "";
    private List<Integer> viewedReviewIds = null;

    public StudentReviewerTracker(String studentName) {
        this.studentName = studentName;
        this.viewedReviewIds = new ArrayList<>();
        
    }

    public void markReviewAsViewed(int reviewId) {
        if (!viewedReviewIds.contains(reviewId)) {
            viewedReviewIds.add(reviewId);
        }
    }

    public boolean hasViewed(int reviewId) {
        return viewedReviewIds.contains(reviewId);
    }

    public List<Integer> getViewedReviews() {
        return viewedReviewIds;
    }

    public String getStudentName() {
        return studentName;
    }
}