package androidx.media3.exoplayer.audio;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioOutput$WriteException extends Exception {
    public final int errorCode;
    public final boolean isRecoverable;

    public AudioOutput$WriteException(int i, boolean z) {
        super(IntIntPair$$ExternalSyntheticOutline0.m(i, "AudioOutput write failed: "));
        this.isRecoverable = z;
        this.errorCode = i;
    }
}
