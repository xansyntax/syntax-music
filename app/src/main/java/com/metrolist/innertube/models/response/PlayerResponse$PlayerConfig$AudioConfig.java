package com.metrolist.innertube.models.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/innertube/models/response/PlayerResponse$PlayerConfig$AudioConfig", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class PlayerResponse$PlayerConfig$AudioConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Double loudnessDb;
    public final Double perceptualLoudnessDb;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$PlayerConfig$AudioConfig$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/PlayerResponse$PlayerConfig$AudioConfig;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return PlayerResponse$PlayerConfig$AudioConfig$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlayerResponse$PlayerConfig$AudioConfig(int i, Double d, Double d2) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(PlayerResponse$PlayerConfig$AudioConfig$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.loudnessDb = d;
        this.perceptualLoudnessDb = d2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerResponse$PlayerConfig$AudioConfig)) {
            return false;
        }
        PlayerResponse$PlayerConfig$AudioConfig playerResponse$PlayerConfig$AudioConfig = (PlayerResponse$PlayerConfig$AudioConfig) obj;
        return Intrinsics.areEqual(this.loudnessDb, playerResponse$PlayerConfig$AudioConfig.loudnessDb) && Intrinsics.areEqual(this.perceptualLoudnessDb, playerResponse$PlayerConfig$AudioConfig.perceptualLoudnessDb);
    }

    public final int hashCode() {
        Double d = this.loudnessDb;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.perceptualLoudnessDb;
        return iHashCode + (d2 != null ? d2.hashCode() : 0);
    }

    public final String toString() {
        return "AudioConfig(loudnessDb=" + this.loudnessDb + ", perceptualLoudnessDb=" + this.perceptualLoudnessDb + ")";
    }

    public PlayerResponse$PlayerConfig$AudioConfig(Double d, Double d2) {
        this.loudnessDb = d;
        this.perceptualLoudnessDb = d2;
    }
}
