package com.metrolist.music.eq.data;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/eq/data/Entry;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Entry {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String form;
    public final String formDirectory;
    public final String label;
    public final String rig;
    public final String source;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/eq/data/Entry$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/eq/data/Entry;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Entry$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Entry(int i, String str, String str2, String str3, String str4, String str5) {
        if (31 != (i & 31)) {
            EnumsKt.throwMissingFieldException(Entry$$serializer.INSTANCE.getDescriptor(), i, 31);
            throw null;
        }
        this.label = str;
        this.form = str2;
        this.rig = str3;
        this.source = str4;
        this.formDirectory = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return Intrinsics.areEqual(this.label, entry.label) && Intrinsics.areEqual(this.form, entry.form) && Intrinsics.areEqual(this.rig, entry.rig) && Intrinsics.areEqual(this.source, entry.source) && Intrinsics.areEqual(this.formDirectory, entry.formDirectory);
    }

    public final int hashCode() {
        return this.formDirectory.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.label.hashCode() * 31, 31, this.form), 31, this.rig), 31, this.source);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Entry(label=", this.label, ", form=", this.form, ", rig=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.rig, ", source=", this.source, ", formDirectory=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.formDirectory, ")");
    }

    public Entry(String str, String str2, String str3, String str4, String str5) {
        str.getClass();
        str4.getClass();
        this.label = str;
        this.form = str2;
        this.rig = str3;
        this.source = str4;
        this.formDirectory = str5;
    }
}
