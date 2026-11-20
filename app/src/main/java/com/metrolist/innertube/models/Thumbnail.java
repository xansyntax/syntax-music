package com.metrolist.innertube.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/Thumbnail;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Thumbnail {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Integer height;
    public final String url;
    public final Integer width;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Thumbnail$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Thumbnail;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Thumbnail$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Thumbnail(int i, String str, Integer num, Integer num2) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(Thumbnail$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.url = str;
        this.width = num;
        this.height = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Thumbnail)) {
            return false;
        }
        Thumbnail thumbnail = (Thumbnail) obj;
        return Intrinsics.areEqual(this.url, thumbnail.url) && Intrinsics.areEqual(this.width, thumbnail.width) && Intrinsics.areEqual(this.height, thumbnail.height);
    }

    public final int hashCode() {
        int iHashCode = this.url.hashCode() * 31;
        Integer num = this.width;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        return "Thumbnail(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public Thumbnail(String str, Integer num, Integer num2) {
        str.getClass();
        this.url = str;
        this.width = num;
        this.height = num2;
    }
}
