package com.metrolist.music.discord;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordActivity {
    public final int activityType;
    public final String button1Label;
    public final String button1Url;
    public final String button2Label;
    public final String button2Url;
    public final String details;
    public final Long endTimestamp;
    public final String largeImage;
    public final String largeText;
    public final String name;
    public final String smallImage;
    public final String smallText;
    public final long startTimestamp;
    public final String state;

    public DiscordActivity(int i, String str, String str2, String str3, long j, Long l, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.activityType = i;
        this.name = str;
        this.state = str2;
        this.details = str3;
        this.startTimestamp = j;
        this.endTimestamp = l;
        this.largeImage = str4;
        this.largeText = str5;
        this.smallImage = str6;
        this.smallText = str7;
        this.button1Label = str8;
        this.button1Url = str9;
        this.button2Label = str10;
        this.button2Url = str11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiscordActivity)) {
            return false;
        }
        DiscordActivity discordActivity = (DiscordActivity) obj;
        return this.activityType == discordActivity.activityType && this.name.equals(discordActivity.name) && this.state.equals(discordActivity.state) && this.details.equals(discordActivity.details) && this.startTimestamp == discordActivity.startTimestamp && Intrinsics.areEqual(this.endTimestamp, discordActivity.endTimestamp) && Intrinsics.areEqual(this.largeImage, discordActivity.largeImage) && Intrinsics.areEqual(this.largeText, discordActivity.largeText) && Intrinsics.areEqual(this.smallImage, discordActivity.smallImage) && Intrinsics.areEqual(this.smallText, discordActivity.smallText) && Intrinsics.areEqual(this.button1Label, discordActivity.button1Label) && Intrinsics.areEqual(this.button1Url, discordActivity.button1Url) && Intrinsics.areEqual(this.button2Label, discordActivity.button2Label) && Intrinsics.areEqual(this.button2Url, discordActivity.button2Url);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Integer.hashCode(this.activityType) * 31, 31, this.name), 31, this.state), 31, this.details), 31, this.startTimestamp);
        Long l = this.endTimestamp;
        int iHashCode = (iM + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.largeImage;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.largeText;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.smallImage;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.smallText;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.button1Label;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.button1Url;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.button2Label;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.button2Url;
        return iHashCode8 + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DiscordActivity(activityType=");
        sb.append(this.activityType);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", state=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.state, ", details=", this.details, ", startTimestamp=");
        sb.append(this.startTimestamp);
        sb.append(", endTimestamp=");
        sb.append(this.endTimestamp);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", largeImage=", this.largeImage, ", largeText=", this.largeText);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", smallImage=", this.smallImage, ", smallText=", this.smallText);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", button1Label=", this.button1Label, ", button1Url=", this.button1Url);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", button2Label=", this.button2Label, ", button2Url=", this.button2Url);
        sb.append(")");
        return sb.toString();
    }
}
