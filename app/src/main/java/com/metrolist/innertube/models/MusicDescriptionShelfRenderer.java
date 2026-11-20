package com.metrolist.innertube.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicDescriptionShelfRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicDescriptionShelfRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Runs description;
    public final Runs footer;
    public final Runs header;
    public final Runs subheader;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicDescriptionShelfRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicDescriptionShelfRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicDescriptionShelfRenderer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MusicDescriptionShelfRenderer(int i, Runs runs, Runs runs2, Runs runs3, Runs runs4) {
        if (15 != (i & 15)) {
            EnumsKt.throwMissingFieldException(MusicDescriptionShelfRenderer$$serializer.INSTANCE.getDescriptor(), i, 15);
            throw null;
        }
        this.header = runs;
        this.subheader = runs2;
        this.description = runs3;
        this.footer = runs4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicDescriptionShelfRenderer)) {
            return false;
        }
        MusicDescriptionShelfRenderer musicDescriptionShelfRenderer = (MusicDescriptionShelfRenderer) obj;
        return Intrinsics.areEqual(this.header, musicDescriptionShelfRenderer.header) && Intrinsics.areEqual(this.subheader, musicDescriptionShelfRenderer.subheader) && Intrinsics.areEqual(this.description, musicDescriptionShelfRenderer.description) && Intrinsics.areEqual(this.footer, musicDescriptionShelfRenderer.footer);
    }

    public final int hashCode() {
        Runs runs = this.header;
        int iHashCode = (runs == null ? 0 : runs.hashCode()) * 31;
        Runs runs2 = this.subheader;
        int iHashCode2 = (iHashCode + (runs2 == null ? 0 : runs2.hashCode())) * 31;
        Runs runs3 = this.description;
        int iHashCode3 = (iHashCode2 + (runs3 == null ? 0 : runs3.hashCode())) * 31;
        Runs runs4 = this.footer;
        return iHashCode3 + (runs4 != null ? runs4.hashCode() : 0);
    }

    public final String toString() {
        return "MusicDescriptionShelfRenderer(header=" + this.header + ", subheader=" + this.subheader + ", description=" + this.description + ", footer=" + this.footer + ")";
    }
}
