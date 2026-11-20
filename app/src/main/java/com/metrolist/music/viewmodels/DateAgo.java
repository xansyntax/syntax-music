package com.metrolist.music.viewmodels;

import java.time.LocalDate;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DateAgo {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LastWeek extends DateAgo {
        public static final LastWeek INSTANCE = new LastWeek();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof LastWeek);
        }

        public final int hashCode() {
            return 1493393551;
        }

        public final String toString() {
            return "LastWeek";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Other extends DateAgo {
        public final LocalDate date;

        public Other(LocalDate localDate) {
            this.date = localDate;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Other) {
                return this.date.equals(((Other) obj).date);
            }
            return this == obj;
        }

        public final int hashCode() {
            return this.date.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ThisWeek extends DateAgo {
        public static final ThisWeek INSTANCE = new ThisWeek();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof ThisWeek);
        }

        public final int hashCode() {
            return -113649513;
        }

        public final String toString() {
            return "ThisWeek";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Today extends DateAgo {
        public static final Today INSTANCE = new Today();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof Today);
        }

        public final int hashCode() {
            return 2128436348;
        }

        public final String toString() {
            return "Today";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Yesterday extends DateAgo {
        public static final Yesterday INSTANCE = new Yesterday();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof Yesterday);
        }

        public final int hashCode() {
            return -281922243;
        }

        public final String toString() {
            return "Yesterday";
        }
    }
}
