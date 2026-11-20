package com.metrolist.music.eq.data;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/eq/data/GitHubAutoEqSearch$GitHubTreeResponse", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class GitHubAutoEqSearch$GitHubTreeResponse {
    public final String sha;
    public final List tree;
    public final boolean truncated;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new FilterType$$ExternalSyntheticLambda0((byte) 1)), null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/eq/data/GitHubAutoEqSearch$GitHubTreeResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/eq/data/GitHubAutoEqSearch$GitHubTreeResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return GitHubAutoEqSearch$GitHubTreeResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GitHubAutoEqSearch$GitHubTreeResponse(int i, String str, List list, boolean z) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(GitHubAutoEqSearch$GitHubTreeResponse$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.sha = str;
        this.tree = list;
        if ((i & 4) == 0) {
            this.truncated = false;
        } else {
            this.truncated = z;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GitHubAutoEqSearch$GitHubTreeResponse)) {
            return false;
        }
        GitHubAutoEqSearch$GitHubTreeResponse gitHubAutoEqSearch$GitHubTreeResponse = (GitHubAutoEqSearch$GitHubTreeResponse) obj;
        return Intrinsics.areEqual(this.sha, gitHubAutoEqSearch$GitHubTreeResponse.sha) && Intrinsics.areEqual(this.tree, gitHubAutoEqSearch$GitHubTreeResponse.tree) && this.truncated == gitHubAutoEqSearch$GitHubTreeResponse.truncated;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.truncated) + Fragment$5$$ExternalSyntheticOutline0.m(this.sha.hashCode() * 31, 31, this.tree);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GitHubTreeResponse(sha=");
        sb.append(this.sha);
        sb.append(", tree=");
        sb.append(this.tree);
        sb.append(", truncated=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.truncated, ")");
    }
}
