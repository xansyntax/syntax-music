package androidx.media3.session;

import android.os.Looper;
import androidx.media3.common.Player;
import coil3.util.UtilsKt;
import com.google.common.collect.RegularImmutableList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionImpl$$ExternalSyntheticLambda17 implements MediaControllerStub.ControllerTask, MediaSessionImpl$RemoteControllerTask {
    public final /* synthetic */ Player.Commands f$0;

    public /* synthetic */ MediaSessionImpl$$ExternalSyntheticLambda17(Player.Commands commands) {
        this.f$0 = commands;
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void run(MediaControllerImplBase mediaControllerImplBase) {
        boolean z;
        boolean z2;
        MediaController mediaController = mediaControllerImplBase.instance;
        if (mediaControllerImplBase.isConnected()) {
            Player.Commands commands = mediaControllerImplBase.playerCommandsFromPlayer;
            Player.Commands commands2 = this.f$0;
            if (Objects.equals(commands, commands2)) {
                return;
            }
            mediaControllerImplBase.playerCommandsFromPlayer = commands2;
            Player.Commands commands3 = mediaControllerImplBase.intersectedPlayerCommands;
            Player.Commands commandsCreateIntersectedCommandsWithControllerOverrides = mediaControllerImplBase.createIntersectedCommandsWithControllerOverrides(mediaControllerImplBase.playerCommandsFromSession, commands2);
            mediaControllerImplBase.intersectedPlayerCommands = commandsCreateIntersectedCommandsWithControllerOverrides;
            if (commandsCreateIntersectedCommandsWithControllerOverrides.equals(commands3)) {
                z = false;
                z2 = false;
            } else {
                RegularImmutableList regularImmutableList = mediaControllerImplBase.resolvedMediaButtonPreferences;
                RegularImmutableList regularImmutableList2 = mediaControllerImplBase.resolvedCustomLayout;
                RegularImmutableList regularImmutableListResolveMediaButtonPreferences = MediaControllerImplBase.resolveMediaButtonPreferences(mediaControllerImplBase.mediaButtonPreferencesOriginal, mediaControllerImplBase.customLayoutOriginal, mediaControllerImplBase.sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, mediaControllerImplBase.sessionExtras);
                mediaControllerImplBase.resolvedMediaButtonPreferences = regularImmutableListResolveMediaButtonPreferences;
                mediaControllerImplBase.resolvedCustomLayout = MediaControllerImplBase.resolveCustomLayout(regularImmutableListResolveMediaButtonPreferences, mediaControllerImplBase.customLayoutOriginal, mediaControllerImplBase.sessionExtras, mediaControllerImplBase.sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, mediaControllerImplBase.getSessionInterfaceVersion());
                z = !mediaControllerImplBase.resolvedMediaButtonPreferences.equals(regularImmutableList);
                z2 = !mediaControllerImplBase.resolvedCustomLayout.equals(regularImmutableList2);
                mediaControllerImplBase.listeners.sendEvent(13, new MediaControllerImplBase$$ExternalSyntheticLambda3(mediaControllerImplBase, (byte) 2));
            }
            if (z2) {
                mediaController.getClass();
                UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
                mediaController.listener.getClass();
            }
            if (z) {
                mediaController.getClass();
                UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
                mediaController.listener.onMediaButtonPreferencesChanged();
            }
        }
    }

    @Override // androidx.media3.session.MediaSessionImpl$RemoteControllerTask
    public void run(MediaSession$ControllerCb mediaSession$ControllerCb, int i) {
        mediaSession$ControllerCb.onAvailableCommandsChangedFromPlayer(i, this.f$0);
    }
}
