package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource$Factory;
import com.google.common.base.Supplier;
import com.metrolist.music.playback.MusicService$createRenderersFactory$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                return (DefaultLoadControl) obj;
            case 1:
                return (DefaultMediaSourceFactory) obj;
            case 2:
                return (MusicService$createRenderersFactory$1) obj;
            default:
                try {
                    return (MediaSource$Factory) ((Class) obj).getConstructor(null).newInstance(null);
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
        }
    }
}
