package androidx.compose.runtime;

import androidx.compose.runtime.internal.AwaiterQueue$Awaiter;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NextFrameEndCallbackQueue$NextFrameEndAwaiter extends AwaiterQueue$Awaiter {
    public RoomDatabase$$ExternalSyntheticLambda0 onNextFrameEnd;

    @Override // androidx.compose.runtime.internal.AwaiterQueue$Awaiter
    public final void cancel() {
        this.onNextFrameEnd = null;
    }

    public final void resume() {
        RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0 = this.onNextFrameEnd;
        if (roomDatabase$$ExternalSyntheticLambda0 != null) {
            roomDatabase$$ExternalSyntheticLambda0.invoke();
        }
    }

    @Override // androidx.compose.runtime.internal.AwaiterQueue$Awaiter
    public void resumeWithException(Throwable th) throws Throwable {
        throw th;
    }
}
