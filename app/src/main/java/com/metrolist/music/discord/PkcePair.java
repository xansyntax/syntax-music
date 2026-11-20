package com.metrolist.music.discord;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PkcePair {
    public final String challenge;
    public final String verifier;

    public PkcePair(String str, String str2) {
        this.verifier = str;
        this.challenge = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PkcePair)) {
            return false;
        }
        PkcePair pkcePair = (PkcePair) obj;
        return this.verifier.equals(pkcePair.verifier) && this.challenge.equals(pkcePair.challenge);
    }

    public final int hashCode() {
        return this.challenge.hashCode() + (this.verifier.hashCode() * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("PkcePair(verifier=", this.verifier, ", challenge=", this.challenge, ")");
    }
}
