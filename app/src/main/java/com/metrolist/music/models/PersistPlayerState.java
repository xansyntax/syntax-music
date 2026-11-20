package com.metrolist.music.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003JY\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\u0014\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010)\u001a\u00020*HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018Ê\u0001\f\b,\u0012\b\b-\u0012\u0004\b\u0003\u0010\u0002¨\u0006+"}, d2 = {"Lcom/metrolist/music/models/PersistPlayerState;", "Ljava/io/Serializable;", "playWhenReady", "", "repeatMode", "", "shuffleModeEnabled", "volume", "", "currentPosition", "", "currentMediaItemIndex", "playbackState", "timestamp", "<init>", "(ZIZFJIIJ)V", "getPlayWhenReady", "()Z", "getRepeatMode", "()I", "getShuffleModeEnabled", "getVolume", "()F", "getCurrentPosition", "()J", "getCurrentMediaItemIndex", "getPlaybackState", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PersistPlayerState implements Serializable {
    public static final int $stable = 0;
    private final int currentMediaItemIndex;
    private final long currentPosition;
    private final boolean playWhenReady;
    private final int playbackState;
    private final int repeatMode;
    private final boolean shuffleModeEnabled;
    private final long timestamp;
    private final float volume;

    public /* synthetic */ PersistPlayerState(boolean z, int i, boolean z2, float f, long j, int i2, int i3, long j2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, f, j, i2, i3, (i4 & 128) != 0 ? System.currentTimeMillis() : j2);
    }

    public static /* synthetic */ PersistPlayerState copy$default(PersistPlayerState persistPlayerState, boolean z, int i, boolean z2, float f, long j, int i2, int i3, long j2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = persistPlayerState.playWhenReady;
        }
        if ((i4 & 2) != 0) {
            i = persistPlayerState.repeatMode;
        }
        if ((i4 & 4) != 0) {
            z2 = persistPlayerState.shuffleModeEnabled;
        }
        if ((i4 & 8) != 0) {
            f = persistPlayerState.volume;
        }
        if ((i4 & 16) != 0) {
            j = persistPlayerState.currentPosition;
        }
        if ((i4 & 32) != 0) {
            i2 = persistPlayerState.currentMediaItemIndex;
        }
        if ((i4 & 64) != 0) {
            i3 = persistPlayerState.playbackState;
        }
        if ((i4 & 128) != 0) {
            j2 = persistPlayerState.timestamp;
        }
        long j3 = j;
        boolean z3 = z2;
        float f2 = f;
        return persistPlayerState.copy(z, i, z3, f2, j3, i2, i3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRepeatMode() {
        return this.repeatMode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getVolume() {
        return this.volume;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getCurrentMediaItemIndex() {
        return this.currentMediaItemIndex;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getPlaybackState() {
        return this.playbackState;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final PersistPlayerState copy(boolean playWhenReady, int repeatMode, boolean shuffleModeEnabled, float volume, long currentPosition, int currentMediaItemIndex, int playbackState, long timestamp) {
        return new PersistPlayerState(playWhenReady, repeatMode, shuffleModeEnabled, volume, currentPosition, currentMediaItemIndex, playbackState, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersistPlayerState)) {
            return false;
        }
        PersistPlayerState persistPlayerState = (PersistPlayerState) other;
        return this.playWhenReady == persistPlayerState.playWhenReady && this.repeatMode == persistPlayerState.repeatMode && this.shuffleModeEnabled == persistPlayerState.shuffleModeEnabled && Float.compare(this.volume, persistPlayerState.volume) == 0 && this.currentPosition == persistPlayerState.currentPosition && this.currentMediaItemIndex == persistPlayerState.currentMediaItemIndex && this.playbackState == persistPlayerState.playbackState && this.timestamp == persistPlayerState.timestamp;
    }

    public final int getCurrentMediaItemIndex() {
        return this.currentMediaItemIndex;
    }

    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    public final boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    public final int getPlaybackState() {
        return this.playbackState;
    }

    public final int getRepeatMode() {
        return this.repeatMode;
    }

    public final boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final float getVolume() {
        return this.volume;
    }

    public int hashCode() {
        return Long.hashCode(this.timestamp) + IntIntPair$$ExternalSyntheticOutline0.m(this.playbackState, IntIntPair$$ExternalSyntheticOutline0.m(this.currentMediaItemIndex, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.volume, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.repeatMode, Boolean.hashCode(this.playWhenReady) * 31, 31), this.shuffleModeEnabled, 31), 31), 31, this.currentPosition), 31), 31);
    }

    public String toString() {
        boolean z = this.playWhenReady;
        int i = this.repeatMode;
        boolean z2 = this.shuffleModeEnabled;
        float f = this.volume;
        long j = this.currentPosition;
        int i2 = this.currentMediaItemIndex;
        int i3 = this.playbackState;
        long j2 = this.timestamp;
        StringBuilder sb = new StringBuilder("PersistPlayerState(playWhenReady=");
        sb.append(z);
        sb.append(", repeatMode=");
        sb.append(i);
        sb.append(", shuffleModeEnabled=");
        sb.append(z2);
        sb.append(", volume=");
        sb.append(f);
        sb.append(", currentPosition=");
        sb.append(j);
        sb.append(", currentMediaItemIndex=");
        sb.append(i2);
        sb.append(", playbackState=");
        sb.append(i3);
        sb.append(", timestamp=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, j2, ")");
    }

    public PersistPlayerState(boolean z, int i, boolean z2, float f, long j, int i2, int i3, long j2) {
        this.playWhenReady = z;
        this.repeatMode = i;
        this.shuffleModeEnabled = z2;
        this.volume = f;
        this.currentPosition = j;
        this.currentMediaItemIndex = i2;
        this.playbackState = i3;
        this.timestamp = j2;
    }
}
