package com.metrolist.music.discord;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityPayload {
    public final List buttons;
    public final String details;
    public final Long endMs;
    public final String largeImage;
    public final String largeText;
    public final String name;
    public final String smallImage;
    public final String smallText;
    public final Long startMs;
    public final String state;
    public final byte type;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityPayload(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, Long l, Long l2, List list) {
        this.name = str;
        this.type = i;
        this.details = str2;
        this.state = str3;
        this.largeImage = str4;
        this.largeText = str5;
        this.smallImage = str6;
        this.smallText = str7;
        this.startMs = l;
        this.endMs = l2;
        this.buttons = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityPayload)) {
            return false;
        }
        ActivityPayload activityPayload = (ActivityPayload) obj;
        return this.name.equals(activityPayload.name) && this.type == activityPayload.type && this.details.equals(activityPayload.details) && this.state.equals(activityPayload.state) && Intrinsics.areEqual(this.largeImage, activityPayload.largeImage) && Intrinsics.areEqual(this.largeText, activityPayload.largeText) && Intrinsics.areEqual(this.smallImage, activityPayload.smallImage) && Intrinsics.areEqual(this.smallText, activityPayload.smallText) && Intrinsics.areEqual(this.startMs, activityPayload.startMs) && Intrinsics.areEqual(this.endMs, activityPayload.endMs) && this.buttons.equals(activityPayload.buttons);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((int) this.type, this.name.hashCode() * 31, 31), 31, this.details), 961, this.state);
        String str = this.largeImage;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.largeText;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.smallImage;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.smallText;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.startMs;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.endMs;
        return this.buttons.hashCode() + ((iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ActivityPayload(name=");
        sb.append(this.name);
        sb.append(", type=");
        sb.append((int) this.type);
        sb.append(", details=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.details, ", state=", this.state, ", url=null, largeImage=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.largeImage, ", largeText=", this.largeText, ", smallImage=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.smallImage, ", smallText=", this.smallText, ", startMs=");
        sb.append(this.startMs);
        sb.append(", endMs=");
        sb.append(this.endMs);
        sb.append(", buttons=");
        sb.append(this.buttons);
        sb.append(")");
        return sb.toString();
    }
}
