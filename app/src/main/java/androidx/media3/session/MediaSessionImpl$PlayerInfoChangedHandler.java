package androidx.media3.session;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.compose.ui.node.NodeChain;
import androidx.media3.common.Player;
import androidx.media3.common.util.Log;
import com.google.common.collect.ImmutableList;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionImpl$PlayerInfoChangedHandler extends Handler {
    public boolean excludeTimeline;
    public boolean excludeTracks;
    public final /* synthetic */ MediaLibrarySessionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSessionImpl$PlayerInfoChangedHandler(MediaLibrarySessionImpl mediaLibrarySessionImpl, Looper looper) {
        super(looper);
        this.this$0 = mediaLibrarySessionImpl;
        this.excludeTimeline = true;
        this.excludeTracks = true;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        MediaSession$ControllerInfo mediaSession$ControllerInfo;
        int iObtainNextSequenceNumber;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = this.this$0;
        MediaSessionStub mediaSessionStub = mediaLibrarySessionImpl.sessionStub;
        if (message.what != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(message.what, "Invalid message what=");
            return;
        }
        PlayerInfo playerInfoCopyWithTimelineAndSessionPositionInfo = mediaLibrarySessionImpl.playerInfo.copyWithTimelineAndSessionPositionInfo(mediaLibrarySessionImpl.playerWrapper.getCurrentTimelineWithCommandCheck(), mediaLibrarySessionImpl.playerWrapper.createSessionPositionInfo(), mediaLibrarySessionImpl.playerInfo.timelineChangeReason);
        mediaLibrarySessionImpl.playerInfo = playerInfoCopyWithTimelineAndSessionPositionInfo;
        boolean z = this.excludeTimeline;
        boolean z2 = this.excludeTracks;
        PlayerInfo playerInfoUpdatePlayerInfoWithUniqueTrackGroupIds = mediaSessionStub.updatePlayerInfoWithUniqueTrackGroupIds(playerInfoCopyWithTimelineAndSessionPositionInfo);
        Dispatcher dispatcher = mediaSessionStub.connectedControllersManager;
        ImmutableList connectedControllers = dispatcher.getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            MediaSession$ControllerInfo mediaSession$ControllerInfo2 = (MediaSession$ControllerInfo) connectedControllers.get(i);
            try {
                NodeChain.Differ sequencedFutureManager = dispatcher.getSequencedFutureManager(mediaSession$ControllerInfo2);
                if (sequencedFutureManager != null) {
                    iObtainNextSequenceNumber = sequencedFutureManager.obtainNextSequenceNumber();
                } else if (!mediaLibrarySessionImpl.isConnected(mediaSession$ControllerInfo2)) {
                    break;
                } else {
                    iObtainNextSequenceNumber = 0;
                }
                PlayerInfo playerInfoForPlaybackException = dispatcher.getPlayerInfoForPlaybackException(mediaSession$ControllerInfo2);
                if (playerInfoForPlaybackException == null) {
                    dispatcher.getPlaybackException(mediaSession$ControllerInfo2);
                    Player.Commands commandsIntersect = MediaUtils.intersect(dispatcher.getAvailablePlayerCommands(mediaSession$ControllerInfo2), mediaLibrarySessionImpl.playerWrapper.getAvailableCommands());
                    mediaSession$ControllerInfo = mediaSession$ControllerInfo2;
                    try {
                        MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
                        mediaSession$ControllerCb.getClass();
                        try {
                            mediaSession$ControllerCb.onPlayerInfoChanged(iObtainNextSequenceNumber, playerInfoForPlaybackException == null ? playerInfoUpdatePlayerInfoWithUniqueTrackGroupIds : playerInfoForPlaybackException, commandsIntersect, z, z2);
                        } catch (DeadObjectException unused) {
                            mediaSessionStub.connectedControllersManager.removeController(mediaSession$ControllerInfo);
                        } catch (RemoteException e) {
                            e = e;
                            Log.w("MediaSessionImpl", "Exception in " + mediaSession$ControllerInfo, e);
                        }
                    } catch (DeadObjectException unused2) {
                        mediaSession$ControllerInfo = mediaSession$ControllerInfo;
                    } catch (RemoteException e2) {
                        e = e2;
                        mediaSession$ControllerInfo = mediaSession$ControllerInfo;
                    }
                }
            } catch (DeadObjectException unused3) {
                mediaSession$ControllerInfo = mediaSession$ControllerInfo2;
            } catch (RemoteException e3) {
                e = e3;
                mediaSession$ControllerInfo = mediaSession$ControllerInfo2;
            }
        }
        this.excludeTimeline = true;
        this.excludeTracks = true;
    }

    public final void sendPlayerInfoChangedMessage(boolean z, boolean z2) {
        boolean z3 = false;
        this.excludeTimeline = this.excludeTimeline && z;
        if (this.excludeTracks && z2) {
            z3 = true;
        }
        this.excludeTracks = z3;
        if (hasMessages(1)) {
            return;
        }
        sendEmptyMessage(1);
    }
}
