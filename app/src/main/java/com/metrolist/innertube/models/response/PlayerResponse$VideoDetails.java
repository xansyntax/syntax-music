package com.metrolist.innertube.models.response;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.Thumbnails;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/innertube/models/response/PlayerResponse$VideoDetails", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class PlayerResponse$VideoDetails {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String author;
    public final String channelId;
    public final String lengthSeconds;
    public final String musicVideoType;
    public final Thumbnails thumbnail;
    public final String title;
    public final String videoId;
    public final String viewCount;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$VideoDetails$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/PlayerResponse$VideoDetails;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return PlayerResponse$VideoDetails$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlayerResponse$VideoDetails(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, Thumbnails thumbnails) {
        if (255 != (i & 255)) {
            EnumsKt.throwMissingFieldException(PlayerResponse$VideoDetails$$serializer.INSTANCE.getDescriptor(), i, 255);
            throw null;
        }
        this.videoId = str;
        this.title = str2;
        this.author = str3;
        this.channelId = str4;
        this.lengthSeconds = str5;
        this.musicVideoType = str6;
        this.viewCount = str7;
        this.thumbnail = thumbnails;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerResponse$VideoDetails)) {
            return false;
        }
        PlayerResponse$VideoDetails playerResponse$VideoDetails = (PlayerResponse$VideoDetails) obj;
        return Intrinsics.areEqual(this.videoId, playerResponse$VideoDetails.videoId) && Intrinsics.areEqual(this.title, playerResponse$VideoDetails.title) && Intrinsics.areEqual(this.author, playerResponse$VideoDetails.author) && Intrinsics.areEqual(this.channelId, playerResponse$VideoDetails.channelId) && Intrinsics.areEqual(this.lengthSeconds, playerResponse$VideoDetails.lengthSeconds) && Intrinsics.areEqual(this.musicVideoType, playerResponse$VideoDetails.musicVideoType) && Intrinsics.areEqual(this.viewCount, playerResponse$VideoDetails.viewCount) && Intrinsics.areEqual(this.thumbnail, playerResponse$VideoDetails.thumbnail);
    }

    public final int hashCode() {
        int iHashCode = this.videoId.hashCode() * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.author;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.channelId), 31, this.lengthSeconds);
        String str3 = this.musicVideoType;
        int iHashCode3 = (iM + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.viewCount;
        return this.thumbnail.thumbnails.hashCode() + ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("VideoDetails(videoId=", this.videoId, ", title=", this.title, ", author=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.author, ", channelId=", this.channelId, ", lengthSeconds=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.lengthSeconds, ", musicVideoType=", this.musicVideoType, ", viewCount=");
        sbM.append(this.viewCount);
        sbM.append(", thumbnail=");
        sbM.append(this.thumbnail);
        sbM.append(")");
        return sbM.toString();
    }

    public PlayerResponse$VideoDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, Thumbnails thumbnails) {
        str.getClass();
        this.videoId = str;
        this.title = str2;
        this.author = str3;
        this.channelId = str4;
        this.lengthSeconds = str5;
        this.musicVideoType = str6;
        this.viewCount = str7;
        this.thumbnail = thumbnails;
    }
}
