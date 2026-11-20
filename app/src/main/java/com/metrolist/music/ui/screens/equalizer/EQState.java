package com.metrolist.music.ui.screens.equalizer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EQState {
    public final String activeProfileId;
    public final String error;
    public final String importStatus;
    public final List profiles;

    public EQState(String str, String str2, String str3, List list) {
        list.getClass();
        this.profiles = list;
        this.activeProfileId = str;
        this.importStatus = str2;
        this.error = str3;
    }

    public static EQState copy$default(EQState eQState, List list, String str, String str2, String str3, int i) {
        if ((i & 1) != 0) {
            list = eQState.profiles;
        }
        if ((i & 2) != 0) {
            str = eQState.activeProfileId;
        }
        if ((i & 4) != 0) {
            str2 = eQState.importStatus;
        }
        if ((i & 8) != 0) {
            str3 = eQState.error;
        }
        eQState.getClass();
        list.getClass();
        return new EQState(str, str2, str3, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EQState)) {
            return false;
        }
        EQState eQState = (EQState) obj;
        return Intrinsics.areEqual(this.profiles, eQState.profiles) && Intrinsics.areEqual(this.activeProfileId, eQState.activeProfileId) && Intrinsics.areEqual(this.importStatus, eQState.importStatus) && Intrinsics.areEqual(this.error, eQState.error);
    }

    public final int hashCode() {
        int iHashCode = this.profiles.hashCode() * 31;
        String str = this.activeProfileId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.importStatus;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.error;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EQState(profiles=");
        sb.append(this.profiles);
        sb.append(", activeProfileId=");
        sb.append(this.activeProfileId);
        sb.append(", importStatus=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.importStatus, ", error=", this.error, ")");
    }
}
