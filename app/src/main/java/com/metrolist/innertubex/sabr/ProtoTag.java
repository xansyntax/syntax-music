package com.metrolist.innertubex.sabr;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProtoTag {
    public final int field;
    public final int wireType;

    public ProtoTag(int i, int i2) {
        this.field = i;
        this.wireType = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProtoTag)) {
            return false;
        }
        ProtoTag protoTag = (ProtoTag) obj;
        return this.field == protoTag.field && this.wireType == protoTag.wireType;
    }

    public final int hashCode() {
        return Integer.hashCode(this.wireType) + (Integer.hashCode(this.field) * 31);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.field, "ProtoTag(field=", ", wireType=", this.wireType, ")");
    }
}
