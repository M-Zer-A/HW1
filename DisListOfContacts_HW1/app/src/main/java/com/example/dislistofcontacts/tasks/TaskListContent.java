package com.example.dislistofcontacts.tasks;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TaskListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Task> ITEMS = new ArrayList<Task>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Task> ITEM_MAP = new HashMap<String, Task>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createTask(i));
        }
    }

    public static void addItem(Task item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static int Id=0;

    private static Task createTask(int position) {
        return new Task(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static void removeItem(int currentItemPosition) {

        String itemId = ITEMS.get(currentItemPosition).id;
        ITEMS.remove(currentItemPosition);
        ITEM_MAP.remove(itemId);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Task implements Parcelable {
        public final String id;
        public final String title;
        public final String details;
        public final String details1;
        public final int soundId;
        public final String picId;


        public Task(String id, String title, String details, String details1, int picId, int soundId) {
            this.id = id;
            this.soundId = soundId;
            this.title = title;
            this.details = details;
            this.details1 = details1;
            this.picId = picId;

        }
        public Task(String id, String title, String details, String details1, int soundId, String picId) {
            this.id = id;
            this.title = title;
            this.details = details;
            this.details1 = details1;
            this.soundId = soundId;
            this.picId = picId;

        }

        protected Task(Parcel in) {
            id = in.readString();
            title = in.readString();
            details = in.readString();
            details1 = in.readString();
            String details2 = in.readString();
            picId = in.readInt();
        }

        public static final Creator<Task> CREATOR = new Creator<Task>() {
            @Override
            public Task createFromParcel(Parcel in) {
                return new Task(in);
            }

            @Override
            public Task[] newArray(int size) {
                return new Task[size];
            }
        };

        @Override
        public String toString() {
            return title;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(title);
            dest.writeString(details);
            dest.writeString(details1);
            Object details2;
            dest.writeString((String) details2);
            dest.writeString(picId);

            dest.writeInt(Integer.parseInt(picId));
        }
    }

    public class task extends Task {
        private final String s;
        private final String s1;
        private final String s2;
        private final void finish;

        public task(String s, String s1, String s2, void finish) {
            super();
            this.s = s;
            this.s1 = s1;
            this.s2 = s2;
            this.finish = finish;
        }
    }
}
