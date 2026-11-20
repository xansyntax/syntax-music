package androidx.media3.session.legacy;

import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface IMediaSession extends IInterface {
    PlaybackStateCompat getPlaybackState();

    int getRepeatMode();

    int getShuffleMode();

    boolean isCaptioningEnabled();

    void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback);

    void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback);
}
