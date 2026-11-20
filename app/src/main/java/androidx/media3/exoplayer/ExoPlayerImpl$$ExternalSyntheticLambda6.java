package androidx.media3.exoplayer;

import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.ListenerSet$$ExternalSyntheticLambda1;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.session.LibraryResult;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaSession$ControllerCb;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.SessionCommand;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda6 implements ListenerSet.Event, MediaControllerStub.ControllerTask, Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda6(int i, SessionCommand sessionCommand, Bundle bundle) {
        this.$r8$classId = (byte) 4;
        this.f$1 = i;
        this.f$0 = sessionCommand;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        LibraryResult libraryResultOfError;
        MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) this.f$0;
        int i = this.f$1;
        try {
            libraryResultOfError = (LibraryResult) ((ListenableFuture) obj).get();
            UtilsKt.checkNotNull(libraryResultOfError, "LibraryResult must not be null");
        } catch (InterruptedException e) {
            e = e;
            Log.w("MediaSessionStub", "Library operation failed", e);
            libraryResultOfError = LibraryResult.ofError(-1);
        } catch (CancellationException e2) {
            Log.w("MediaSessionStub", "Library operation cancelled", e2);
            libraryResultOfError = LibraryResult.ofError(1);
        } catch (ExecutionException e3) {
            e = e3;
            Log.w("MediaSessionStub", "Library operation failed", e);
            libraryResultOfError = LibraryResult.ofError(-1);
        }
        try {
            MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
            mediaSession$ControllerCb.getClass();
            mediaSession$ControllerCb.onLibraryResult(i, libraryResultOfError);
        } catch (RemoteException e4) {
            Log.w("MediaSessionStub", "Failed to send result to browser " + mediaSession$ControllerInfo, e4);
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$0;
        int i = this.f$1;
        switch (b) {
            case 0:
                ((Player.Listener) obj).onMediaItemTransition(i, (MediaItem) obj2);
                break;
            default:
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.getClass();
                analyticsListener.onPositionDiscontinuity((Player.PositionInfo) obj2, i);
                break;
        }
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void run(MediaControllerImplBase mediaControllerImplBase) {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        int i = this.f$1;
        switch (b) {
            case 2:
                MediaController mediaController = mediaControllerImplBase.instance;
                ImmutableList immutableList = (ImmutableList) obj;
                if (mediaControllerImplBase.isConnected()) {
                    RegularImmutableList regularImmutableList = mediaControllerImplBase.resolvedMediaButtonPreferences;
                    RegularImmutableList regularImmutableList2 = mediaControllerImplBase.resolvedCustomLayout;
                    mediaControllerImplBase.mediaButtonPreferencesOriginal = ImmutableList.copyOf((Collection) immutableList);
                    RegularImmutableList regularImmutableListResolveMediaButtonPreferences = MediaControllerImplBase.resolveMediaButtonPreferences(immutableList, mediaControllerImplBase.customLayoutOriginal, mediaControllerImplBase.sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, mediaControllerImplBase.sessionExtras);
                    mediaControllerImplBase.resolvedMediaButtonPreferences = regularImmutableListResolveMediaButtonPreferences;
                    mediaControllerImplBase.resolvedCustomLayout = MediaControllerImplBase.resolveCustomLayout(regularImmutableListResolveMediaButtonPreferences, mediaControllerImplBase.customLayoutOriginal, mediaControllerImplBase.sessionExtras, mediaControllerImplBase.sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, mediaControllerImplBase.getSessionInterfaceVersion());
                    boolean zEquals = mediaControllerImplBase.resolvedMediaButtonPreferences.equals(regularImmutableList);
                    mediaControllerImplBase.resolvedCustomLayout.equals(regularImmutableList2);
                    mediaController.getClass();
                    UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
                    MediaController.Listener listener = mediaController.listener;
                    listener.getClass();
                    ImmediateFuture immediateFutureOnSetCustomLayout = MediaController.Listener.onSetCustomLayout();
                    if (!zEquals) {
                        listener.onMediaButtonPreferencesChanged();
                    }
                    mediaControllerImplBase.sendControllerResultWhenReady(i, immediateFutureOnSetCustomLayout);
                    break;
                }
                break;
            case 3:
                MediaController mediaController2 = mediaControllerImplBase.instance;
                List list = (List) obj;
                if (mediaControllerImplBase.isConnected()) {
                    RegularImmutableList regularImmutableList3 = mediaControllerImplBase.resolvedMediaButtonPreferences;
                    RegularImmutableList regularImmutableList4 = mediaControllerImplBase.resolvedCustomLayout;
                    mediaControllerImplBase.customLayoutOriginal = ImmutableList.copyOf((Collection) list);
                    RegularImmutableList regularImmutableListResolveMediaButtonPreferences2 = MediaControllerImplBase.resolveMediaButtonPreferences(mediaControllerImplBase.mediaButtonPreferencesOriginal, list, mediaControllerImplBase.sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, mediaControllerImplBase.sessionExtras);
                    mediaControllerImplBase.resolvedMediaButtonPreferences = regularImmutableListResolveMediaButtonPreferences2;
                    mediaControllerImplBase.resolvedCustomLayout = MediaControllerImplBase.resolveCustomLayout(regularImmutableListResolveMediaButtonPreferences2, list, mediaControllerImplBase.sessionExtras, mediaControllerImplBase.sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, mediaControllerImplBase.getSessionInterfaceVersion());
                    boolean zEquals2 = mediaControllerImplBase.resolvedMediaButtonPreferences.equals(regularImmutableList3);
                    mediaControllerImplBase.resolvedCustomLayout.equals(regularImmutableList4);
                    mediaController2.getClass();
                    UtilsKt.checkState(Looper.myLooper() == mediaController2.applicationHandler.getLooper());
                    MediaController.Listener listener2 = mediaController2.listener;
                    listener2.getClass();
                    ImmediateFuture immediateFutureOnSetCustomLayout2 = MediaController.Listener.onSetCustomLayout();
                    if (!zEquals2) {
                        listener2.onMediaButtonPreferencesChanged();
                    }
                    mediaControllerImplBase.sendControllerResultWhenReady(i, immediateFutureOnSetCustomLayout2);
                    break;
                }
                break;
            default:
                SessionCommand sessionCommand = (SessionCommand) obj;
                MediaController mediaController3 = mediaControllerImplBase.instance;
                if (mediaControllerImplBase.isConnected()) {
                    mediaController3.getClass();
                    UtilsKt.checkState(Looper.myLooper() == mediaController3.applicationHandler.getLooper());
                    ImmediateFuture immediateFutureOnCustomCommand = mediaController3.listener.onCustomCommand(sessionCommand);
                    immediateFutureOnCustomCommand.addListener(new ListenerSet$$ExternalSyntheticLambda1(mediaControllerImplBase, immediateFutureOnCustomCommand, i), DirectExecutor.INSTANCE);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda6(int i, RegularImmutableList regularImmutableList, byte b) {
        this.$r8$classId = b;
        this.f$1 = i;
        this.f$0 = regularImmutableList;
    }

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda6(AnalyticsListener.EventTime eventTime, int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.$r8$classId = (byte) 1;
        this.f$1 = i;
        this.f$0 = positionInfo;
    }

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda6(Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
    }
}
