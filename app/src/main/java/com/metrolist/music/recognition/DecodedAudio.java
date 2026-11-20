package com.metrolist.music.recognition;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DecodedAudio {
    public final byte[] data;
    public final char sampleRate;

    /* JADX WARN: Multi-variable type inference failed */
    public DecodedAudio(byte[] bArr, int i) {
        this.data = bArr;
        this.sampleRate = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!DecodedAudio.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        DecodedAudio decodedAudio = (DecodedAudio) obj;
        return Arrays.equals(this.data, decodedAudio.data) && this.sampleRate == decodedAudio.sampleRate;
    }

    public final int hashCode() {
        return (((((Arrays.hashCode(this.data) * 31) + 1) * 31) + this.sampleRate) * 31) + 2;
    }

    public final String toString() {
        return "DecodedAudio(data=" + Arrays.toString(this.data) + ", channelCount=1, sampleRate=" + ((int) this.sampleRate) + ", pcmEncoding=2)";
    }
}
