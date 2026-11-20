package androidx.media3.session;

import androidx.media3.common.Player;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MediaSession$ControllerCb {
    default void onDisconnected() {
    }

    default void onRenderedFirstFrame(int i) {
    }

    default void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) {
    }

    default void onLibraryResult(int i, LibraryResult libraryResult) {
    }

    default void onSessionResult(int i, SessionResult sessionResult) {
    }

    default void sendCustomCommand(int i, SessionCommand sessionCommand) {
    }

    default void setCustomLayout(int i, List list) {
    }

    default void onSearchResultChanged(int i, String str, MediaLibraryService.LibraryParams libraryParams) {
    }

    default void onSurfaceSizeChanged(int i, int i2, int i3) {
    }

    default void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i2) {
    }

    default void onPlayerInfoChanged(int i, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2) {
    }
}
