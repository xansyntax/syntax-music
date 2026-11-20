package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda62 implements ListenerSet.Event, Consumer {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda62(int i, boolean z) {
        this.f$1 = i;
        this.f$0 = z;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        ((PlayerWrapper) obj).setDeviceMuted(this.f$1, this.f$0);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).onDeviceVolumeChanged(this.f$1, this.f$0);
    }

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda62(boolean z, int i) {
        this.f$0 = z;
        this.f$1 = i;
    }
}
