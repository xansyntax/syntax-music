package androidx.core.view;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.ExoPlaybackException;
import coil3.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DifferentialMotionFlingController$$ExternalSyntheticLambda0 implements ListenerSet.Event {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ DifferentialMotionFlingController$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3, int i) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + ((char) i));
    }

    public static /* synthetic */ void m$1(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalArgumentException((str + obj + obj2 + obj3 + obj4).toString());
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.$r8$classId) {
            case 28:
                listener.onPlayerError(new ExoPlaybackException(2, new HttpException("Player release timed out."), 1003));
                break;
            default:
                listener.onRenderedFirstFrame();
                break;
        }
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void m(String str, Object obj, Throwable th) {
        throw new RuntimeException(str + obj, th);
    }
}
