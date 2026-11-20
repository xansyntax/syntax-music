package com.metrolist.lastfm.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/lastfm/models/LastFmError;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class LastFmError {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final int error;
    public final String message;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/lastfm/models/LastFmError$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/lastfm/models/LastFmError;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return LastFmError$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LastFmError(int i, int i2, String str) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(LastFmError$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.error = i2;
        this.message = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LastFmError)) {
            return false;
        }
        LastFmError lastFmError = (LastFmError) obj;
        return this.error == lastFmError.error && Intrinsics.areEqual(this.message, lastFmError.message);
    }

    public final int hashCode() {
        return this.message.hashCode() + (Integer.hashCode(this.error) * 31);
    }

    public final String toString() {
        return "LastFmError(error=" + this.error + ", message=" + this.message + ")";
    }
}
