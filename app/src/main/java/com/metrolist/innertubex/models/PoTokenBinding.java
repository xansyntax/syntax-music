package com.metrolist.innertubex.models;

import com.metrolist.lastfm.LastFM$$ExternalSyntheticLambda1;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/metrolist/innertubex/models/PoTokenBinding;", "", "Companion", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final class PoTokenBinding {
    public static final /* synthetic */ PoTokenBinding[] $VALUES;
    public static final Lazy $cachedSerializer$delegate;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final PoTokenBinding VIDEO_ID;
    public static final PoTokenBinding VISITOR_DATA;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/PoTokenBinding$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/PoTokenBinding;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return (KSerializer) PoTokenBinding.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        PoTokenBinding poTokenBinding = new PoTokenBinding("VIDEO_ID", 0);
        VIDEO_ID = poTokenBinding;
        PoTokenBinding poTokenBinding2 = new PoTokenBinding("VISITOR_DATA", 1);
        VISITOR_DATA = poTokenBinding2;
        $VALUES = new PoTokenBinding[]{poTokenBinding, poTokenBinding2};
        INSTANCE = new Companion();
        $cachedSerializer$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LastFM$$ExternalSyntheticLambda1((byte) 2));
    }

    public static PoTokenBinding valueOf(String str) {
        return (PoTokenBinding) Enum.valueOf(PoTokenBinding.class, str);
    }

    public static PoTokenBinding[] values() {
        return (PoTokenBinding[]) $VALUES.clone();
    }
}
