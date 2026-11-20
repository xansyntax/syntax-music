package androidx.media3.exoplayer;

import android.text.TextUtils;
import androidx.core.app.ActivityRecreator;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.LegacyConversions;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaNotification$Provider;
import androidx.media3.session.MediaNotificationManager;
import androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda8;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.SessionResult;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import okhttp3.internal.http.StatusLine;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda5 implements ListenerSet.Event, MediaControllerImplBase.RemoteSessionTask, MediaNotification$Provider.Callback, MediaSessionLegacyStub.SessionTask, MediaSessionStub.SessionTask, Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda5(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.$r8$classId = (byte) 0;
        this.f$0 = i;
        this.f$1 = positionInfo;
        this.f$2 = positionInfo2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d  */
    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        SessionResult sessionResult;
        int i;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.f$1;
        MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) this.f$2;
        try {
            sessionResult = (SessionResult) ((ListenableFuture) obj).get();
            UtilsKt.checkNotNull(sessionResult, "SessionResult must not be null");
        } catch (InterruptedException e) {
            e = e;
            Log.w("MediaSessionStub", "Session operation failed", e);
            if (e.getCause() instanceof UnsupportedOperationException) {
                i = -6;
            } else {
                i = -1;
            }
            sessionResult = new SessionResult(i);
        } catch (CancellationException e2) {
            Log.w("MediaSessionStub", "Session operation cancelled", e2);
            sessionResult = new SessionResult(1);
        } catch (ExecutionException e3) {
            e = e3;
            Log.w("MediaSessionStub", "Session operation failed", e);
            if (e.getCause() instanceof UnsupportedOperationException) {
                i = -6;
            } else {
                i = -1;
            }
            sessionResult = new SessionResult(i);
        }
        MediaSessionStub.sendSessionResult(mediaLibrarySessionImpl, mediaSession$ControllerInfo, this.f$0, sessionResult);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.PositionInfo positionInfo = (Player.PositionInfo) this.f$1;
        Player.PositionInfo positionInfo2 = (Player.PositionInfo) this.f$2;
        Player.Listener listener = (Player.Listener) obj;
        int i = this.f$0;
        listener.onPositionDiscontinuity(i);
        listener.onPositionDiscontinuity(i, positionInfo, positionInfo2);
    }

    @Override // androidx.media3.session.MediaNotification$Provider.Callback
    public void onNotificationChanged(PriorityQueue priorityQueue) {
        MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) this.f$1;
        mediaNotificationManager.mainExecutor.execute(new MediaNotificationManager$$ExternalSyntheticLambda8((byte) 0, this.f$0, mediaNotificationManager, (MediaLibraryService.MediaLibrarySession) this.f$2, priorityQueue));
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        Object obj = this.f$2;
        int i2 = this.f$0;
        MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f$1;
        switch (b) {
            case 1:
                List list = (List) obj;
                MediaControllerStub mediaControllerStub = mediaControllerImplBase.controllerStub;
                ImmutableList.Builder builder = ImmutableList.builder();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    builder.add((Object) ((MediaItem) list.get(i3)).toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true));
                }
                iMediaSession.addMediaItemsWithIndex(mediaControllerStub, i, i2, new BundleListRetriever(builder.build()));
                break;
            default:
                MediaItem mediaItem = (MediaItem) obj;
                int sessionInterfaceVersion = mediaControllerImplBase.getSessionInterfaceVersion();
                MediaControllerStub mediaControllerStub2 = mediaControllerImplBase.controllerStub;
                if (sessionInterfaceVersion >= 2) {
                    iMediaSession.replaceMediaItem(mediaControllerStub2, i, i2, mediaItem.toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true));
                } else {
                    iMediaSession.addMediaItemWithIndex(mediaControllerStub2, i, i2 + 1, mediaItem.toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true));
                    iMediaSession.removeMediaItem(mediaControllerStub2, i, i2);
                }
                break;
        }
    }

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda5(Object obj, int i, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$0 = i;
        this.f$2 = obj2;
    }

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda5(Object obj, Object obj2, int i, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$0 = i;
    }

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda5(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        this.$r8$classId = (byte) 5;
        this.f$1 = str;
        this.f$0 = i2;
        this.f$2 = libraryParams;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void run(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f$1;
        MediaDescriptionCompat mediaDescriptionCompat = (MediaDescriptionCompat) this.f$2;
        if (TextUtils.isEmpty(mediaDescriptionCompat.mediaId)) {
            Log.w("MediaSessionLegacyStub", "onAddQueueItem(): Media ID shouldn't be empty");
            return;
        }
        ListenableFuture listenableFutureOnAddMediaItemsOnHandler = mediaSessionLegacyStub.sessionImpl.onAddMediaItemsOnHandler(mediaSession$ControllerInfo, ImmutableList.of((Object) LegacyConversions.convertToMediaItem(mediaDescriptionCompat)));
        listenableFutureOnAddMediaItemsOnHandler.addListener(new ActivityRecreator.AnonymousClass1(listenableFutureOnAddMediaItemsOnHandler, new StatusLine(mediaSessionLegacyStub, mediaSession$ControllerInfo, this.f$0), (byte) 1), DirectExecutor.INSTANCE);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        return mediaLibrarySessionImpl.onGetSearchResultOnHandler(mediaSession$ControllerInfo, (String) this.f$1, this.f$0, (MediaLibraryService.LibraryParams) this.f$2);
    }
}
