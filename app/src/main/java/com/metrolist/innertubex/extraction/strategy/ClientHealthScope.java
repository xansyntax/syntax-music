package com.metrolist.innertubex.extraction.strategy;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.response.BrowseResponse$$ExternalSyntheticLambda0;
import com.metrolist.innertubex.extraction.ContentHints;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/extraction/strategy/ClientHealthScope;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ClientHealthScope {
    public final boolean authenticated;
    public final ClientHealthContent content;
    public final boolean wantVideo;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 29)), null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/extraction/strategy/ClientHealthScope$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/extraction/strategy/ClientHealthScope;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public static ClientHealthScope from(ContentHints contentHints, boolean z) {
            ClientHealthContent clientHealthContent;
            contentHints.getClass();
            Boolean bool = contentHints.isUploaded;
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.areEqual(bool, bool2)) {
                clientHealthContent = ClientHealthContent.UPLOAD;
            } else if (Intrinsics.areEqual(contentHints.isAgeRestricted, bool2)) {
                clientHealthContent = ClientHealthContent.AGE_RESTRICTED;
            } else if (Intrinsics.areEqual(contentHints.isKidsContent, bool2)) {
                clientHealthContent = ClientHealthContent.KIDS;
            } else {
                clientHealthContent = Intrinsics.areEqual(contentHints.isExplicit, bool2) ? ClientHealthContent.EXPLICIT : ClientHealthContent.NORMAL;
            }
            return new ClientHealthScope(clientHealthContent, z);
        }

        public final KSerializer serializer() {
            return ClientHealthScope$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ClientHealthScope(int i, ClientHealthContent clientHealthContent, boolean z, boolean z2) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(ClientHealthScope$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.content = clientHealthContent;
        this.authenticated = z;
        this.wantVideo = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientHealthScope)) {
            return false;
        }
        ClientHealthScope clientHealthScope = (ClientHealthScope) obj;
        return this.content == clientHealthScope.content && this.authenticated == clientHealthScope.authenticated && this.wantVideo == clientHealthScope.wantVideo;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.wantVideo) + IntIntPair$$ExternalSyntheticOutline0.m(this.content.hashCode() * 31, this.authenticated, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ClientHealthScope(content=");
        sb.append(this.content);
        sb.append(", authenticated=");
        sb.append(this.authenticated);
        sb.append(", wantVideo=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.wantVideo, ")");
    }

    public ClientHealthScope(ClientHealthContent clientHealthContent, boolean z) {
        this.content = clientHealthContent;
        this.authenticated = z;
        this.wantVideo = false;
    }
}
