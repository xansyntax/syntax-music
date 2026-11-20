package com.metrolist.music.listentogether;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/listentogether/ListenTogetherServer;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ListenTogetherServer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String location;
    public final String name;
    public final String operator;
    public final String url;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/listentogether/ListenTogetherServer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/listentogether/ListenTogetherServer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return ListenTogetherServer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ListenTogetherServer(int i, String str, String str2, String str3, String str4) {
        if (15 != (i & 15)) {
            EnumsKt.throwMissingFieldException(ListenTogetherServer$$serializer.INSTANCE.getDescriptor(), i, 15);
            throw null;
        }
        this.name = str;
        this.url = str2;
        this.location = str3;
        this.operator = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListenTogetherServer)) {
            return false;
        }
        ListenTogetherServer listenTogetherServer = (ListenTogetherServer) obj;
        return Intrinsics.areEqual(this.name, listenTogetherServer.name) && Intrinsics.areEqual(this.url, listenTogetherServer.url) && Intrinsics.areEqual(this.location, listenTogetherServer.location) && Intrinsics.areEqual(this.operator, listenTogetherServer.operator);
    }

    public final int hashCode() {
        return this.operator.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.name.hashCode() * 31, 31, this.url), 31, this.location);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("ListenTogetherServer(name=", this.name, ", url=", this.url, ", location="), this.location, ", operator=", this.operator, ")");
    }
}
