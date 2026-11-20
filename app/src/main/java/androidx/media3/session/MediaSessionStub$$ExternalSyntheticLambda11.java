package androidx.media3.session;

import android.view.Surface;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Consumer;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda11 implements MediaControllerImplBase.RemoteSessionTask, MediaSessionStub.SessionTask, Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda11(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        this.$r8$classId = (byte) 0;
        this.f$0 = str;
        this.f$1 = i;
        this.f$2 = i2;
        this.f$3 = libraryParams;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        MediaSessionStub mediaSessionStub = (MediaSessionStub) this.f$0;
        Surface surface = (Surface) this.f$3;
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        ((MediaLibrarySessionImpl) mediaSessionStub.sessionImpl.get()).getClass();
        if (surface == null) {
            playerWrapper.setVideoSurfaceHolder(null);
            mediaSessionStub.surfaceHolderWithSize = null;
        } else {
            MediaSessionStub.SurfaceHolderWithSize surfaceHolderWithSize = new MediaSessionStub.SurfaceHolderWithSize(surface, this.f$1, this.f$2);
            mediaSessionStub.surfaceHolderWithSize = surfaceHolderWithSize;
            playerWrapper.setVideoSurfaceHolder(surfaceHolderWithSize);
        }
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        Object obj = this.f$3;
        Object obj2 = this.f$0;
        switch (b) {
            case 1:
                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) obj2;
                List list = (List) obj;
                ImmutableList.Builder builder = ImmutableList.builder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    builder.add((Object) ((MediaItem) list.get(i2)).toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true));
                }
                BundleListRetriever bundleListRetriever = new BundleListRetriever(builder.build());
                int sessionInterfaceVersion = mediaControllerImplBase.getSessionInterfaceVersion();
                MediaControllerStub mediaControllerStub = mediaControllerImplBase.controllerStub;
                int i3 = this.f$1;
                int i4 = this.f$2;
                if (sessionInterfaceVersion >= 2) {
                    iMediaSession.replaceMediaItems(mediaControllerStub, i, i3, i4, bundleListRetriever);
                } else {
                    iMediaSession.addMediaItemsWithIndex(mediaControllerStub, i, i4, bundleListRetriever);
                    iMediaSession.removeMediaItems(mediaControllerImplBase.controllerStub, i, i3, i4);
                }
                break;
            default:
                int i5 = this.f$2;
                iMediaSession.setVideoSurfaceWithSize(((MediaControllerImplBase) obj2).controllerStub, i, (Surface) obj, this.f$1, i5);
                break;
        }
    }

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda11(Object obj, Object obj2, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$3 = obj2;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        return mediaLibrarySessionImpl.onGetChildrenOnHandler(mediaSession$ControllerInfo, (String) this.f$0, this.f$1, this.f$2, (MediaLibraryService.LibraryParams) this.f$3);
    }
}
