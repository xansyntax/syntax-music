package androidx.compose.runtime.tooling;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeStackTraceFrame {
    public final int groupKey;
    public final Integer groupOffset;
    public final Cache.RealCacheRequest sourceInfo;

    public ComposeStackTraceFrame(int i, Cache.RealCacheRequest realCacheRequest, Integer num) {
        this.groupKey = i;
        this.sourceInfo = realCacheRequest;
        this.groupOffset = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComposeStackTraceFrame)) {
            return false;
        }
        ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) obj;
        return this.groupKey == composeStackTraceFrame.groupKey && Intrinsics.areEqual(this.sourceInfo, composeStackTraceFrame.sourceInfo) && Intrinsics.areEqual(this.groupOffset, composeStackTraceFrame.groupOffset);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.groupKey) * 31;
        Cache.RealCacheRequest realCacheRequest = this.sourceInfo;
        int iHashCode2 = (iHashCode + (realCacheRequest == null ? 0 : realCacheRequest.hashCode())) * 31;
        Integer num = this.groupOffset;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        return "ComposeStackTraceFrame(groupKey=" + this.groupKey + ", sourceInfo=" + this.sourceInfo + ", groupOffset=" + this.groupOffset + ")";
    }
}
