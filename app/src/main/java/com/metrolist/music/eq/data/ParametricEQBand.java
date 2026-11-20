package com.metrolist.music.eq.data;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/eq/data/ParametricEQBand;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ParametricEQBand {
    public final boolean enabled;
    public final FilterType filterType;
    public final double frequency;
    public final double gain;
    public final double q;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new FilterType$$ExternalSyntheticLambda0(4)), null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/eq/data/ParametricEQBand$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/eq/data/ParametricEQBand;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return ParametricEQBand$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ParametricEQBand(int i, double d, double d2, double d3, FilterType filterType, boolean z) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(ParametricEQBand$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.frequency = d;
        this.gain = d2;
        if ((i & 4) == 0) {
            this.q = 1.41d;
        } else {
            this.q = d3;
        }
        if ((i & 8) == 0) {
            this.filterType = FilterType.PK;
        } else {
            this.filterType = filterType;
        }
        if ((i & 16) == 0) {
            this.enabled = true;
        } else {
            this.enabled = z;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParametricEQBand)) {
            return false;
        }
        ParametricEQBand parametricEQBand = (ParametricEQBand) obj;
        return Double.compare(this.frequency, parametricEQBand.frequency) == 0 && Double.compare(this.gain, parametricEQBand.gain) == 0 && Double.compare(this.q, parametricEQBand.q) == 0 && this.filterType == parametricEQBand.filterType && this.enabled == parametricEQBand.enabled;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.enabled) + ((this.filterType.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.q, Fragment$5$$ExternalSyntheticOutline0.m(this.gain, Double.hashCode(this.frequency) * 31, 31), 31)) * 31);
    }

    public final String toString() {
        return "ParametricEQBand(frequency=" + this.frequency + ", gain=" + this.gain + ", q=" + this.q + ", filterType=" + this.filterType + ", enabled=" + this.enabled + ")";
    }

    public ParametricEQBand(double d, double d2, double d3, FilterType filterType) {
        this.frequency = d;
        this.gain = d2;
        this.q = d3;
        this.filterType = filterType;
        this.enabled = true;
    }
}
