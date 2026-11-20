package com.metrolist.innertubex;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTubeLogEvent {
    public final Map details;
    public final InnerTubeLogLevel level;
    public final String message;
    public final String tag;

    public InnerTubeLogEvent(InnerTubeLogLevel innerTubeLogLevel, String str, String str2, Map map) {
        map.getClass();
        this.level = innerTubeLogLevel;
        this.tag = str;
        this.message = str2;
        this.details = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InnerTubeLogEvent)) {
            return false;
        }
        InnerTubeLogEvent innerTubeLogEvent = (InnerTubeLogEvent) obj;
        return this.level == innerTubeLogEvent.level && this.tag.equals(innerTubeLogEvent.tag) && this.message.equals(innerTubeLogEvent.message) && Intrinsics.areEqual(this.details, innerTubeLogEvent.details);
    }

    public final int hashCode() {
        return this.details.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.level.hashCode() * 31, 31, this.tag), 961, this.message);
    }

    public final String toString() {
        return "InnerTubeLogEvent(level=" + this.level + ", tag=" + this.tag + ", message=" + this.message + ", mediaId=null, details=" + this.details + ")";
    }
}
