package com.metrolist.paxsenix.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/paxsenix/models/AppleMusicSearchResponse;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class AppleMusicSearchResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final AppleMusicResources resources;
    public final AppleMusicResults results;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/paxsenix/models/AppleMusicSearchResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/paxsenix/models/AppleMusicSearchResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return AppleMusicSearchResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AppleMusicSearchResponse(int i, AppleMusicResults appleMusicResults, AppleMusicResources appleMusicResources) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(AppleMusicSearchResponse$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.results = appleMusicResults;
        if ((i & 2) == 0) {
            this.resources = null;
        } else {
            this.resources = appleMusicResources;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppleMusicSearchResponse)) {
            return false;
        }
        AppleMusicSearchResponse appleMusicSearchResponse = (AppleMusicSearchResponse) obj;
        return Intrinsics.areEqual(this.results, appleMusicSearchResponse.results) && Intrinsics.areEqual(this.resources, appleMusicSearchResponse.resources);
    }

    public final int hashCode() {
        int iHashCode = this.results.hashCode() * 31;
        AppleMusicResources appleMusicResources = this.resources;
        return iHashCode + (appleMusicResources == null ? 0 : appleMusicResources.hashCode());
    }

    public final String toString() {
        return "AppleMusicSearchResponse(results=" + this.results + ", resources=" + this.resources + ")";
    }
}
