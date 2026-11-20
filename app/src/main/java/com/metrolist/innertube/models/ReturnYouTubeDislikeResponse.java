package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/ReturnYouTubeDislikeResponse;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ReturnYouTubeDislikeResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String dateCreated;
    public final Boolean deleted;
    public final Integer dislikes;
    public final String id;
    public final Integer likes;
    public final Double rating;
    public final Integer viewCount;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ReturnYouTubeDislikeResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ReturnYouTubeDislikeResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return ReturnYouTubeDislikeResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ReturnYouTubeDislikeResponse(int i, String str, String str2, Integer num, Integer num2, Double d, Integer num3, Boolean bool) {
        if ((i & 1) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
        if ((i & 2) == 0) {
            this.dateCreated = null;
        } else {
            this.dateCreated = str2;
        }
        if ((i & 4) == 0) {
            this.likes = null;
        } else {
            this.likes = num;
        }
        if ((i & 8) == 0) {
            this.dislikes = null;
        } else {
            this.dislikes = num2;
        }
        if ((i & 16) == 0) {
            this.rating = null;
        } else {
            this.rating = d;
        }
        if ((i & 32) == 0) {
            this.viewCount = null;
        } else {
            this.viewCount = num3;
        }
        if ((i & 64) == 0) {
            this.deleted = null;
        } else {
            this.deleted = bool;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReturnYouTubeDislikeResponse)) {
            return false;
        }
        ReturnYouTubeDislikeResponse returnYouTubeDislikeResponse = (ReturnYouTubeDislikeResponse) obj;
        return Intrinsics.areEqual(this.id, returnYouTubeDislikeResponse.id) && Intrinsics.areEqual(this.dateCreated, returnYouTubeDislikeResponse.dateCreated) && Intrinsics.areEqual(this.likes, returnYouTubeDislikeResponse.likes) && Intrinsics.areEqual(this.dislikes, returnYouTubeDislikeResponse.dislikes) && Intrinsics.areEqual(this.rating, returnYouTubeDislikeResponse.rating) && Intrinsics.areEqual(this.viewCount, returnYouTubeDislikeResponse.viewCount) && Intrinsics.areEqual(this.deleted, returnYouTubeDislikeResponse.deleted);
    }

    public final int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.dateCreated;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.likes;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.dislikes;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d = this.rating;
        int iHashCode5 = (iHashCode4 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num3 = this.viewCount;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.deleted;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ReturnYouTubeDislikeResponse(id=", this.id, ", dateCreated=", this.dateCreated, ", likes=");
        sbM.append(this.likes);
        sbM.append(", dislikes=");
        sbM.append(this.dislikes);
        sbM.append(", rating=");
        sbM.append(this.rating);
        sbM.append(", viewCount=");
        sbM.append(this.viewCount);
        sbM.append(", deleted=");
        sbM.append(this.deleted);
        sbM.append(")");
        return sbM.toString();
    }
}
