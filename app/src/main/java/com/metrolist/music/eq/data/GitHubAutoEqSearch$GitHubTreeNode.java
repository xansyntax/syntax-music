package com.metrolist.music.eq.data;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/eq/data/GitHubAutoEqSearch$GitHubTreeNode", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class GitHubAutoEqSearch$GitHubTreeNode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String mode;
    public final String path;
    public final String sha;
    public final Long size;
    public final String type;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/eq/data/GitHubAutoEqSearch$GitHubTreeNode$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/eq/data/GitHubAutoEqSearch$GitHubTreeNode;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return GitHubAutoEqSearch$GitHubTreeNode$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GitHubAutoEqSearch$GitHubTreeNode(int i, String str, String str2, String str3, String str4, Long l) {
        if (5 != (i & 5)) {
            EnumsKt.throwMissingFieldException(GitHubAutoEqSearch$GitHubTreeNode$$serializer.INSTANCE.getDescriptor(), i, 5);
            throw null;
        }
        this.path = str;
        if ((i & 2) == 0) {
            this.mode = null;
        } else {
            this.mode = str2;
        }
        this.type = str3;
        if ((i & 8) == 0) {
            this.sha = null;
        } else {
            this.sha = str4;
        }
        if ((i & 16) == 0) {
            this.size = null;
        } else {
            this.size = l;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GitHubAutoEqSearch$GitHubTreeNode)) {
            return false;
        }
        GitHubAutoEqSearch$GitHubTreeNode gitHubAutoEqSearch$GitHubTreeNode = (GitHubAutoEqSearch$GitHubTreeNode) obj;
        return Intrinsics.areEqual(this.path, gitHubAutoEqSearch$GitHubTreeNode.path) && Intrinsics.areEqual(this.mode, gitHubAutoEqSearch$GitHubTreeNode.mode) && Intrinsics.areEqual(this.type, gitHubAutoEqSearch$GitHubTreeNode.type) && Intrinsics.areEqual(this.sha, gitHubAutoEqSearch$GitHubTreeNode.sha) && Intrinsics.areEqual(this.size, gitHubAutoEqSearch$GitHubTreeNode.size);
    }

    public final int hashCode() {
        int iHashCode = this.path.hashCode() * 31;
        String str = this.mode;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.type);
        String str2 = this.sha;
        int iHashCode2 = (iM + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.size;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("GitHubTreeNode(path=", this.path, ", mode=", this.mode, ", type=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.type, ", sha=", this.sha, ", size=");
        sbM.append(this.size);
        sbM.append(")");
        return sbM.toString();
    }
}
