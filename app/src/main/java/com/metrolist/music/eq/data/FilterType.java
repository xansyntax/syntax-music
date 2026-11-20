package com.metrolist.music.eq.data;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/metrolist/music/eq/data/FilterType;", "", "Companion", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final class FilterType {
    public static final /* synthetic */ FilterType[] $VALUES;
    public static final Lazy $cachedSerializer$delegate;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final FilterType HPQ;
    public static final FilterType HSC;
    public static final FilterType LPQ;
    public static final FilterType LSC;
    public static final FilterType PK;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/eq/data/FilterType$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/eq/data/FilterType;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return (KSerializer) FilterType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        FilterType filterType = new FilterType("PK", 0);
        PK = filterType;
        FilterType filterType2 = new FilterType("LSC", 1);
        LSC = filterType2;
        FilterType filterType3 = new FilterType("HSC", 2);
        HSC = filterType3;
        FilterType filterType4 = new FilterType("LPQ", 3);
        LPQ = filterType4;
        FilterType filterType5 = new FilterType("HPQ", 4);
        HPQ = filterType5;
        $VALUES = new FilterType[]{filterType, filterType2, filterType3, filterType4, filterType5};
        INSTANCE = new Companion();
        $cachedSerializer$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new FilterType$$ExternalSyntheticLambda0((byte) 0));
    }

    public static FilterType valueOf(String str) {
        return (FilterType) Enum.valueOf(FilterType.class, str);
    }

    public static FilterType[] values() {
        return (FilterType[]) $VALUES.clone();
    }
}
