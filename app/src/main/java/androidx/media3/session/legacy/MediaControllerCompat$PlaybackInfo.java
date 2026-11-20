package androidx.media3.session.legacy;

import androidx.media3.common.AudioAttributes;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat$PlaybackInfo {
    public final AudioAttributes audioAttributes;
    public final int currentVolume;
    public final int maxVolume;
    public final int playbackType;
    public final int volumeControl;
    public final String volumeControlId;

    public MediaControllerCompat$PlaybackInfo(int i, AudioAttributes audioAttributes, int i2, int i3, int i4, String str) {
        this.playbackType = i;
        this.audioAttributes = audioAttributes;
        this.volumeControl = i2;
        this.maxVolume = i3;
        this.currentVolume = i4;
        this.volumeControlId = str;
    }
}
