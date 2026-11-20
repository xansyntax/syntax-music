package com.metrolist.lastfm.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/lastfm/models/Authentication;", "", "Companion", "Session", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Authentication {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Session session;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/lastfm/models/Authentication$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/lastfm/models/Authentication;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Authentication$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/lastfm/models/Authentication$Session;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Session {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String key;
        public final String name;
        public final int subscriber;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/lastfm/models/Authentication$Session$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/lastfm/models/Authentication$Session;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return Authentication$Session$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Session(int i, int i2, String str, String str2) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(Authentication$Session$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.name = str;
            this.key = str2;
            this.subscriber = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Session)) {
                return false;
            }
            Session session = (Session) obj;
            return Intrinsics.areEqual(this.name, session.name) && Intrinsics.areEqual(this.key, session.key) && this.subscriber == session.subscriber;
        }

        public final int hashCode() {
            return Integer.hashCode(this.subscriber) + Fragment$5$$ExternalSyntheticOutline0.m(this.name.hashCode() * 31, 31, this.key);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Session(name=", this.name, ", key=", this.key, ", subscriber="), this.subscriber, ")");
        }
    }

    public /* synthetic */ Authentication(int i, Session session) {
        if (1 == (i & 1)) {
            this.session = session;
        } else {
            EnumsKt.throwMissingFieldException(Authentication$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Authentication) && Intrinsics.areEqual(this.session, ((Authentication) obj).session);
    }

    public final int hashCode() {
        return this.session.hashCode();
    }

    public final String toString() {
        return "Authentication(session=" + this.session + ")";
    }
}
