package androidx.media3.session;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplLegacy$$ExternalSyntheticLambda2 implements ListenerSet.Event, ListenerSet.IterationFinishedEvent {
    public final /* synthetic */ MediaControllerImplLegacy f$0;

    public /* synthetic */ MediaControllerImplLegacy$$ExternalSyntheticLambda2(MediaControllerImplLegacy mediaControllerImplLegacy) {
        this.f$0 = mediaControllerImplLegacy;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).onMediaMetadataChanged(((PlayerInfo) this.f$0.controllerInfo.weights).mediaMetadata);
    }

    @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
    public void invoke(Object obj, FlagSet flagSet) {
        ((Player.Listener) obj).onEvents(this.f$0.instance, new Player.Events(flagSet));
    }
}
