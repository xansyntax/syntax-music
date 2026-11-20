package kotlinx.serialization.internal;

import java.util.List;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class NothingSerialDescriptor implements SerialDescriptor {
    public static final NothingSerialDescriptor INSTANCE = new NothingSerialDescriptor();

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getElementAnnotations(int i) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int i) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String str) {
        str.getClass();
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int i) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final Okio__OkioKt getKind() {
        return StructureKind$MAP.INSTANCE$3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return "kotlin.Nothing";
    }

    public final int hashCode() {
        return (StructureKind$MAP.INSTANCE$3.hashCode() * 31) - 1818355776;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int i) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    public final String toString() {
        return "NothingSerialDescriptor";
    }
}
