package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentHints {
    public boolean allowBoundedRange;
    public boolean allowHls;
    public boolean allowSabr;
    public final Boolean isAgeRestricted;
    public final Boolean isExplicit;
    public final Boolean isKidsContent;
    public final Boolean isUploaded;
    public final String playbackClientOverrideId;

    public /* synthetic */ ContentHints(Boolean bool, Boolean bool2, int i) {
        this((i & 1) != 0 ? null : bool, null, null, (i & 16) != 0 ? null : bool2, null);
    }

    public static ContentHints copy$default(ContentHints contentHints, Boolean bool, String str, int i) {
        Boolean bool2 = Boolean.TRUE;
        Boolean bool3 = contentHints.isExplicit;
        Boolean bool4 = (i & 2) != 0 ? contentHints.isKidsContent : bool2;
        if ((i & 4) != 0) {
            bool2 = contentHints.isAgeRestricted;
        }
        Boolean bool5 = bool2;
        contentHints.getClass();
        if ((i & 16) != 0) {
            bool = contentHints.isUploaded;
        }
        Boolean bool6 = bool;
        contentHints.getClass();
        contentHints.getClass();
        contentHints.getClass();
        if ((i & 256) != 0) {
            str = contentHints.playbackClientOverrideId;
        }
        contentHints.getClass();
        contentHints.getClass();
        contentHints.getClass();
        ContentHints contentHints2 = new ContentHints(bool3, bool4, bool5, bool6, str);
        contentHints2.allowHls = contentHints.allowHls;
        contentHints2.allowSabr = contentHints.allowSabr;
        contentHints2.allowBoundedRange = contentHints.allowBoundedRange;
        return contentHints2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentHints)) {
            return false;
        }
        ContentHints contentHints = (ContentHints) obj;
        return Intrinsics.areEqual(this.isExplicit, contentHints.isExplicit) && Intrinsics.areEqual(this.isKidsContent, contentHints.isKidsContent) && Intrinsics.areEqual(this.isAgeRestricted, contentHints.isAgeRestricted) && Intrinsics.areEqual(this.isUploaded, contentHints.isUploaded) && Intrinsics.areEqual(this.playbackClientOverrideId, contentHints.playbackClientOverrideId);
    }

    public final int hashCode() {
        Boolean bool = this.isExplicit;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        Boolean bool2 = this.isKidsContent;
        int iHashCode2 = (iHashCode + (bool2 != null ? Boolean.hashCode(bool2.booleanValue()) : 0)) * 31;
        Boolean bool3 = this.isAgeRestricted;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? Boolean.hashCode(bool3.booleanValue()) : 0)) * 961;
        Boolean bool4 = this.isUploaded;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode3 + (bool4 != null ? Boolean.hashCode(bool4.booleanValue()) : 0)) * 29791, false, 31);
        String str = this.playbackClientOverrideId;
        return Boolean.hashCode(false) + IntIntPair$$ExternalSyntheticOutline0.m((iM + (str != null ? str.hashCode() : 0)) * 31, false, 961);
    }

    public final String toString() {
        return "{explicit=" + this.isExplicit + ", kids=" + this.isKidsContent + ", ageRestricted=" + this.isAgeRestricted + ", live=null, uploaded=" + this.isUploaded + ", local=null, endpointParamsPresent=false, wantVideo=false, clientOverride=" + this.playbackClientOverrideId + ", sabrFirst=false, maxVideoHeight=null, premium=false, allowHls=" + this.allowHls + ", allowSabr=" + this.allowSabr + ", allowBoundedRange=" + this.allowBoundedRange + "}";
    }

    public ContentHints(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str) {
        this.isExplicit = bool;
        this.isKidsContent = bool2;
        this.isAgeRestricted = bool3;
        this.isUploaded = bool4;
        this.playbackClientOverrideId = str;
        this.allowHls = true;
        this.allowSabr = true;
        this.allowBoundedRange = true;
    }
}
