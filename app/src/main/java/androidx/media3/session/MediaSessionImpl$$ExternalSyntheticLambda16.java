package androidx.media3.session;

import androidx.core.app.ActivityRecreator;
import androidx.media3.common.MediaItem;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import kotlinx.coroutines.guava.JobListenableFuture;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionImpl$$ExternalSyntheticLambda16 implements MediaSessionImpl$RemoteControllerTask, MediaSessionLegacyStub.SessionTask {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ MediaSessionImpl$$ExternalSyntheticLambda16(MediaSessionLegacyStub mediaSessionLegacyStub, MediaItem mediaItem, boolean z, boolean z2) {
        this.f$0 = mediaSessionLegacyStub;
        this.f$3 = mediaItem;
        this.f$1 = z;
        this.f$2 = z2;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void run(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f$0;
        ListenableFuture listenableFutureOnSetMediaItemsOnHandler = mediaSessionLegacyStub.sessionImpl.onSetMediaItemsOnHandler(mediaSession$ControllerInfo, ImmutableList.of(this.f$3), -1, -9223372036854775807L);
        ConnectionSpec.Builder builder = new ConnectionSpec.Builder();
        builder.tlsVersions = mediaSessionLegacyStub;
        builder.cipherSuites = mediaSession$ControllerInfo;
        builder.tls = this.f$1;
        builder.supportsTlsExtensions = this.f$2;
        ((JobListenableFuture) listenableFutureOnSetMediaItemsOnHandler).addListener(new ActivityRecreator.AnonymousClass1(listenableFutureOnSetMediaItemsOnHandler, builder, (byte) 1), DirectExecutor.INSTANCE);
    }

    public /* synthetic */ MediaSessionImpl$$ExternalSyntheticLambda16(SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        this.f$0 = sessionPositionInfo;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = mediaSession$ControllerInfo;
    }

    @Override // androidx.media3.session.MediaSessionImpl$RemoteControllerTask
    public void run(MediaSession$ControllerCb mediaSession$ControllerCb, int i) {
        mediaSession$ControllerCb.onPeriodicSessionPositionInfoChanged(i, (SessionPositionInfo) this.f$0, this.f$1, this.f$2, ((MediaSession$ControllerInfo) this.f$3).interfaceVersion);
    }
}
