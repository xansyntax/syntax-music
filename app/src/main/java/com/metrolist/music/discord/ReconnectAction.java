package com.metrolist.music.discord;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ReconnectAction {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ReIdentify implements ReconnectAction {
        public static final ReIdentify INSTANCE = new ReIdentify();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof ReIdentify);
        }

        public final int hashCode() {
            return 1069353359;
        }

        public final String toString() {
            return "ReIdentify";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RefreshAndReIdentify implements ReconnectAction {
        public static final RefreshAndReIdentify INSTANCE = new RefreshAndReIdentify();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof RefreshAndReIdentify);
        }

        public final int hashCode() {
            return 47471531;
        }

        public final String toString() {
            return "RefreshAndReIdentify";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Resume implements ReconnectAction {
        public final int seq;
        public final String sessionId;

        public Resume(String str, int i) {
            str.getClass();
            this.sessionId = str;
            this.seq = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resume)) {
                return false;
            }
            Resume resume = (Resume) obj;
            return Intrinsics.areEqual(this.sessionId, resume.sessionId) && this.seq == resume.seq;
        }

        public final int hashCode() {
            return Integer.hashCode(this.seq) + (this.sessionId.hashCode() * 31);
        }

        public final String toString() {
            return "Resume(sessionId=" + this.sessionId + ", seq=" + this.seq + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SurfaceFatal implements ReconnectAction {
        public static final SurfaceFatal INSTANCE = new SurfaceFatal();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof SurfaceFatal);
        }

        public final int hashCode() {
            return -503825529;
        }

        public final String toString() {
            return "SurfaceFatal";
        }
    }
}
