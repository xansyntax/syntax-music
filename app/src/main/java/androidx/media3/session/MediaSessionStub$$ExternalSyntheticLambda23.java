package androidx.media3.session;

import androidx.media3.common.MediaItem;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda23 implements MediaSessionStub.SessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaItem f$0;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda23(MediaItem mediaItem, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaItem;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public final Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        byte b = this.$r8$classId;
        MediaItem mediaItem = this.f$0;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
        }
        return mediaLibrarySessionImpl.onAddMediaItemsOnHandler(mediaSession$ControllerInfo, ImmutableList.of((Object) mediaItem));
    }
}
