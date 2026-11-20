package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.unit.Velocity;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollConnection {
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    default Object mo99onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return new Velocity(0L);
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    default long mo100onPostScrollDzOQY0M(int i, long j, long j2) {
        return 0L;
    }

    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    default Object mo326onPreFlingQWom1Mo(long j, Continuation continuation) {
        return new Velocity(0L);
    }

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    default long mo178onPreScrollOzD1aCk(int i, long j) {
        return 0L;
    }
}
