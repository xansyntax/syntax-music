package kotlinx.serialization.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ListLikeDescriptor implements SerialDescriptor {
    public final SerialDescriptor elementDescriptor;

    public ListLikeDescriptor(SerialDescriptor serialDescriptor) {
        this.elementDescriptor = serialDescriptor;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListLikeDescriptor)) {
            return false;
        }
        ListLikeDescriptor listLikeDescriptor = (ListLikeDescriptor) obj;
        return Intrinsics.areEqual(this.elementDescriptor, listLikeDescriptor.elementDescriptor) && Intrinsics.areEqual(getSerialName(), listLikeDescriptor.getSerialName());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getElementAnnotations(int i) {
        if (i >= 0) {
            return EmptyList.INSTANCE;
        }
        PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Illegal index ", ", "), getSerialName(), " expects only non-negative indices");
        return null;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int i) {
        if (i >= 0) {
            return this.elementDescriptor;
        }
        PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Illegal index ", ", "), getSerialName(), " expects only non-negative indices");
        return null;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String str) {
        str.getClass();
        Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, str);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(str.concat(" is not a valid list index"));
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int i) {
        return String.valueOf(i);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return 1;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final Okio__OkioKt getKind() {
        return StructureKind$MAP.INSTANCE$2;
    }

    public final int hashCode() {
        return getSerialName().hashCode() + (this.elementDescriptor.hashCode() * 31);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int i) {
        if (i >= 0) {
            return false;
        }
        PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Illegal index ", ", "), getSerialName(), " expects only non-negative indices");
        return false;
    }

    public final String toString() {
        return getSerialName() + '(' + this.elementDescriptor + ')';
    }
}
