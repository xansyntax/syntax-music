package androidx.compose.ui.autofill;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidContentDataType {
    public final byte androidAutofillType;

    public final boolean equals(Object obj) {
        if (obj instanceof AndroidContentDataType) {
            return this.androidAutofillType == ((AndroidContentDataType) obj).androidAutofillType;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.androidAutofillType);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m((int) this.androidAutofillType, "AndroidContentDataType(androidAutofillType=", ")");
    }
}
