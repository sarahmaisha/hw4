package application;

import java.util.*;

public class FlagStore {
    private static final Map<String, List<String>> flaggedItems = new HashMap<>();
    private static final Map<String, List<String>> notes = new HashMap<>();
    private static final Map<String, List<String>> discussions = new HashMap<>();

    public static void addFlag(String staffId, String item) {
        flaggedItems.putIfAbsent(staffId, new ArrayList<>());
        flaggedItems.get(staffId).add(item);
    }

    public static void addNoteToFlag(String item, String note) {
        notes.putIfAbsent(item, new ArrayList<>());
        notes.get(item).add(note);
    }

    public static void addDiscussionMessage(String item, String msg) {
        discussions.putIfAbsent(item, new ArrayList<>());
        discussions.get(item).add(msg);
    }

    public static List<String> getDiscussion(String item) {
        return discussions.getOrDefault(item, new ArrayList<>());
    }
}
