package androidx.media3.session;

import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.MediaItem;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplBase$$ExternalSyntheticLambda99 implements MediaControllerImplBase.RemoteSessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaControllerImplBase f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda99(MediaControllerImplBase mediaControllerImplBase, List list, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaControllerImplBase;
        this.f$1 = list;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public final void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        int i2 = 0;
        List list = this.f$1;
        MediaControllerImplBase mediaControllerImplBase = this.f$0;
        switch (b) {
            case 0:
                MediaControllerStub mediaControllerStub = mediaControllerImplBase.controllerStub;
                ImmutableList.Builder builder = ImmutableList.builder();
                while (i2 < list.size()) {
                    builder.add((Object) ((MediaItem) list.get(i2)).toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true));
                    i2++;
                }
                iMediaSession.setMediaItemsWithResetPosition(mediaControllerStub, i, new BundleListRetriever(builder.build()), true);
                break;
            default:
                MediaControllerStub mediaControllerStub2 = mediaControllerImplBase.controllerStub;
                ImmutableList.Builder builder2 = ImmutableList.builder();
                while (i2 < list.size()) {
                    builder2.add((Object) ((MediaItem) list.get(i2)).toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true));
                    i2++;
                }
                iMediaSession.addMediaItems(mediaControllerStub2, i, new BundleListRetriever(builder2.build()));
                break;
        }
    }
}
