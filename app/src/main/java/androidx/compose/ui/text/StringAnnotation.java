package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StringAnnotation implements AnnotatedString.Annotation {
    public final String value;

    public /* synthetic */ StringAnnotation(String str) {
        this.value = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof StringAnnotation) {
            return Intrinsics.areEqual(this.value, ((StringAnnotation) obj).value);
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("StringAnnotation(value=", this.value, ")");
    }
}
