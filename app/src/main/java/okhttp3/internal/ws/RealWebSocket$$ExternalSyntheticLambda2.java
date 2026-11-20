package okhttp3.internal.ws;

import androidx.media3.exoplayer.ExoPlayerImpl;
import com.metrolist.music.playback.MusicService;
import java.io.Closeable;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilCommonKt;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RealWebSocket$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Ref$ObjectRef f$0;

    public /* synthetic */ RealWebSocket$$ExternalSyntheticLambda2(Ref$ObjectRef ref$ObjectRef, byte b) {
        this.$r8$classId = b;
        this.f$0 = ref$ObjectRef;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Ref$ObjectRef ref$ObjectRef = this.f$0;
        switch (b) {
            case 0:
                _UtilCommonKt.closeQuietly((Closeable) ref$ObjectRef.element);
                return Unit.INSTANCE;
            case 1:
                boolean z = MusicService.isRunning;
                return (ExoPlayerImpl) ref$ObjectRef.element;
            default:
                ConnectionPool connectionPool = Timber.Forest;
                Objects.toString(ref$ObjectRef.element);
                connectionPool.getClass();
                ConnectionPool.d(new Object[0]);
                return Unit.INSTANCE;
        }
    }
}
