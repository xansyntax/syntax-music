package com.metrolist.innertubex.extraction.strategy;

import com.metrolist.innertube.models.response.BrowseResponse$$ExternalSyntheticLambda0;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/metrolist/innertubex/extraction/strategy/ClientFailureKind;", "", "Companion", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final class ClientFailureKind {
    public static final /* synthetic */ ClientFailureKind[] $VALUES;
    public static final Lazy $cachedSerializer$delegate;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ClientFailureKind PLAYABILITY;
    public static final ClientFailureKind TOKEN;

    /* JADX INFO: Fake field, exist only in values array */
    ClientFailureKind EF0;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/extraction/strategy/ClientFailureKind$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/extraction/strategy/ClientFailureKind;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return (KSerializer) ClientFailureKind.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        ClientFailureKind clientFailureKind = new ClientFailureKind("PLAYER_REQUEST", 0);
        ClientFailureKind clientFailureKind2 = new ClientFailureKind("PLAYABILITY", 1);
        PLAYABILITY = clientFailureKind2;
        ClientFailureKind clientFailureKind3 = new ClientFailureKind("TOKEN", 2);
        TOKEN = clientFailureKind3;
        $VALUES = new ClientFailureKind[]{clientFailureKind, clientFailureKind2, clientFailureKind3, new ClientFailureKind("MEDIA_FORBIDDEN", 3), new ClientFailureKind("MEDIA_FAILURE", 4)};
        INSTANCE = new Companion();
        $cachedSerializer$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 27));
    }

    public static ClientFailureKind valueOf(String str) {
        return (ClientFailureKind) Enum.valueOf(ClientFailureKind.class, str);
    }

    public static ClientFailureKind[] values() {
        return (ClientFailureKind[]) $VALUES.clone();
    }
}
