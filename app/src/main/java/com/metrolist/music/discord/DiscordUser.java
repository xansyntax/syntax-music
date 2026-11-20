package com.metrolist.music.discord;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordUser {
    public final String avatar;
    public final String id;
    public final String name;
    public final String username;

    public DiscordUser(String str, String str2, String str3, String str4) {
        this.id = str;
        this.username = str2;
        this.name = str3;
        this.avatar = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiscordUser)) {
            return false;
        }
        DiscordUser discordUser = (DiscordUser) obj;
        return this.id.equals(discordUser.id) && this.username.equals(discordUser.username) && this.name.equals(discordUser.name) && Intrinsics.areEqual(this.avatar, discordUser.avatar);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.username), 31, this.name);
        String str = this.avatar;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("DiscordUser(id=", this.id, ", username=", this.username, ", name="), this.name, ", avatar=", this.avatar, ")");
    }
}
