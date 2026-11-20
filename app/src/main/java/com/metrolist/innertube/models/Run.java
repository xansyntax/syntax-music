package com.metrolist.innertube.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/Run;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Run {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final NavigationEndpoint navigationEndpoint;
    public final String text;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Run$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Run;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Run$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Run(int i, String str, NavigationEndpoint navigationEndpoint) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(Run$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.text = str;
        this.navigationEndpoint = navigationEndpoint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Run)) {
            return false;
        }
        Run run = (Run) obj;
        return Intrinsics.areEqual(this.text, run.text) && Intrinsics.areEqual(this.navigationEndpoint, run.navigationEndpoint);
    }

    public final int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
        return iHashCode + (navigationEndpoint == null ? 0 : navigationEndpoint.hashCode());
    }

    public final String toString() {
        return "Run(text=" + this.text + ", navigationEndpoint=" + this.navigationEndpoint + ")";
    }

    public Run(String str, NavigationEndpoint navigationEndpoint) {
        str.getClass();
        this.text = str;
        this.navigationEndpoint = navigationEndpoint;
    }
}
