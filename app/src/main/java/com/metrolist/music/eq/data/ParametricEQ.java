package com.metrolist.music.eq.data;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/eq/data/ParametricEQ;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ParametricEQ {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final List bands;
    public final Map metadata;
    public final double preamp;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/metrolist/music/eq/data/ParametricEQ$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/eq/data/ParametricEQ;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "MAX_BANDS", "I", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return ParametricEQ$$serializer.INSTANCE;
        }
    }

    static {
        FilterType$$ExternalSyntheticLambda0 filterType$$ExternalSyntheticLambda0 = new FilterType$$ExternalSyntheticLambda0((byte) 2);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, filterType$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new FilterType$$ExternalSyntheticLambda0((byte) 3))};
    }

    public /* synthetic */ ParametricEQ(int i, double d, List list, Map map) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(ParametricEQ$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.preamp = d;
        this.bands = list;
        if ((i & 4) == 0) {
            this.metadata = EmptyMap.INSTANCE;
        } else {
            this.metadata = map;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParametricEQ)) {
            return false;
        }
        ParametricEQ parametricEQ = (ParametricEQ) obj;
        return Double.compare(this.preamp, parametricEQ.preamp) == 0 && Intrinsics.areEqual(this.bands, parametricEQ.bands) && Intrinsics.areEqual(this.metadata, parametricEQ.metadata);
    }

    public final int hashCode() {
        return this.metadata.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Double.hashCode(this.preamp) * 31, 31, this.bands);
    }

    public final String toString() {
        return "ParametricEQ(preamp=" + this.preamp + ", bands=" + this.bands + ", metadata=" + this.metadata + ")";
    }

    public ParametricEQ(double d, List list, Map map) {
        list.getClass();
        map.getClass();
        this.preamp = d;
        this.bands = list;
        this.metadata = map;
    }
}
