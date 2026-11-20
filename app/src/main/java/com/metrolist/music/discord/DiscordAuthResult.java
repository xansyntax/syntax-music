package com.metrolist.music.discord;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordAuthResult {
    public final String accessToken;
    public final long expiresInSec;
    public final String refreshToken;
    public final String scope;

    public DiscordAuthResult(String str, String str2, long j, String str3) {
        this.accessToken = str;
        this.refreshToken = str2;
        this.expiresInSec = j;
        this.scope = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiscordAuthResult)) {
            return false;
        }
        DiscordAuthResult discordAuthResult = (DiscordAuthResult) obj;
        return this.accessToken.equals(discordAuthResult.accessToken) && this.refreshToken.equals(discordAuthResult.refreshToken) && this.expiresInSec == discordAuthResult.expiresInSec && this.scope.equals(discordAuthResult.scope);
    }

    public final int hashCode() {
        return this.scope.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.accessToken.hashCode() * 31, 31, this.refreshToken), 31, this.expiresInSec);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("DiscordAuthResult(accessToken=", this.accessToken, ", refreshToken=", this.refreshToken, ", expiresInSec=");
        sbM.append(this.expiresInSec);
        sbM.append(", scope=");
        sbM.append(this.scope);
        sbM.append(")");
        return sbM.toString();
    }
}
