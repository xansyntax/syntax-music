package androidx.media3.session;

import android.os.Bundle;
import android.os.IInterface;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface IMediaController extends IInterface {
    void onAvailableCommandsChangedFromPlayer(int i, Bundle bundle);

    void onConnected(int i, Bundle bundle);

    void onCustomCommand(int i, Bundle bundle, Bundle bundle2);

    void onDisconnected();

    void onLibraryResult(int i, Bundle bundle);

    void onPeriodicSessionPositionInfoChanged(int i, Bundle bundle);

    void onPlayerInfoChanged(int i, Bundle bundle, boolean z);

    void onPlayerInfoChangedWithExclusions(int i, Bundle bundle, Bundle bundle2);

    void onRenderedFirstFrame(int i);

    void onSearchResultChanged(int i, int i2, Bundle bundle, String str);

    void onSessionResult(int i, Bundle bundle);

    void onSetCustomLayout(int i, List list);

    void onSurfaceSizeChanged(int i, int i2, int i3);
}
