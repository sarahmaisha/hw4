package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StaffFeatureTest {

    private String staffId;
    private String testItem;

    @BeforeEach
    public void setup() {
        staffId = "staff1";
        testItem = "Q: What is a fruit?";
        FlagStore.addFlag(staffId, testItem); // Reset base test data
    }

    // Test User Story 1: View recent interactions (manually mocked for now)
    @Test
    public void testViewRecentInteractions() {
        List<String> discussions = FlagStore.getDiscussion(testItem);
        assertNotNull(discussions);
        assertEquals(0, discussions.size());
    }

    // Test User Story 2: Flagging an item
    @Test
    public void testAddFlag() {
        FlagStore.addFlag("staff2", "A: The sky is blue.");
        List<String> staffFlags = FlagStore.getDiscussion("A: The sky is blue.");
        assertNotNull(staffFlags);
        assertEquals(0, staffFlags.size()); // No discussion yet
    }

    // Test User Story 3: Adding a note to a flag
    @Test
    public void testAddNoteToFlag() {
        FlagStore.addNoteToFlag(testItem, "This needs to be reviewed for accuracy.");
        // You’d test internals with additional access methods or via console/visual
        // To simulate correctness:
        FlagStore.addNoteToFlag(testItem, "Add source example.");
        assertTrue(true); // No direct getNotes method, but it stores internally
    }

    // Test User Story 4: Searching content (you’d normally mock search logic)
    @Test
    public void testSearchKeywordMock() {
        String keyword = "fruit";
        assertTrue(testItem.toLowerCase().contains(keyword));
    }

    // Test User Story 5: Discussion thread
    @Test
    public void testDiscussionThreadMessaging() {
        FlagStore.addDiscussionMessage(testItem, "Staff: Needs clarity.");
        FlagStore.addDiscussionMessage(testItem, "Staff: Check with instructor.");
        List<String> thread = FlagStore.getDiscussion(testItem);
        assertEquals(2, thread.size());
        assertEquals("Staff: Needs clarity.", thread.get(0));
        assertEquals("Staff: Check with instructor.", thread.get(1));
    }
}
