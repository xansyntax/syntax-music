package kotlinx.serialization.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PrimitiveSerialDescriptor implements SerialDescriptor {
    public final PrimitiveKind$INT kind;
    public final String serialName;

    public PrimitiveSerialDescriptor(String str, PrimitiveKind$INT primitiveKind$INT) {
        primitiveKind$INT.getClass();
        this.serialName = str;
        this.kind = primitiveKind$INT;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrimitiveSerialDescriptor)) {
            return false;
        }
        PrimitiveSerialDescriptor primitiveSerialDescriptor = (PrimitiveSerialDescriptor) obj;
        return this.serialName.equals(primitiveSerialDescriptor.serialName) && Intrinsics.areEqual(this.kind, primitiveSerialDescriptor.kind);
    }

    public final void error$1() {
        throw new IllegalStateException(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("Primitive descriptor "), this.serialName, " does not have elements"));
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getElementAnnotations(int i) {
        error$1();
        throw null;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int i) {
        error$1();
        throw null;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String str) {
        str.getClass();
        error$1();
        throw null;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int i) {
        error$1();
        throw null;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final Okio__OkioKt getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }

    public final int hashCode() {
        return (this.kind.hashCode() * 31) + this.serialName.hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int i) {
        error$1();
        throw null;
    }

    public final String toString() {
        return Format$$ExternalSyntheticOutline0.m(new StringBuilder("PrimitiveDescriptor("), this.serialName, ')');
    }
}
