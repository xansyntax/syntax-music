package com.metrolist.music.discord;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AuthCodeResult {
    public final String code;
    public final String state;

    public AuthCodeResult(String str, String str2) {
        this.code = str;
        this.state = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthCodeResult)) {
            return false;
        }
        AuthCodeResult authCodeResult = (AuthCodeResult) obj;
        return this.code.equals(authCodeResult.code) && this.state.equals(authCodeResult.state);
    }

    public final int hashCode() {
        return this.state.hashCode() + (this.code.hashCode() * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("AuthCodeResult(code=", this.code, ", state=", this.state, ")");
    }
}
