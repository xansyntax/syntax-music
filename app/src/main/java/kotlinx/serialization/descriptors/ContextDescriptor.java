package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.reflect.KClass;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ContextDescriptor implements SerialDescriptor {
    public final KClass kClass;
    public final SerialDescriptorImpl original;
    public final String serialName;

    public ContextDescriptor(SerialDescriptorImpl serialDescriptorImpl, KClass kClass) {
        this.original = serialDescriptorImpl;
        this.kClass = kClass;
        this.serialName = serialDescriptorImpl.serialName + '<' + kClass.getSimpleName() + '>';
    }

    public final boolean equals(Object obj) {
        ContextDescriptor contextDescriptor = obj instanceof ContextDescriptor ? (ContextDescriptor) obj : null;
        return contextDescriptor != null && this.original.equals(contextDescriptor.original) && contextDescriptor.kClass.equals(this.kClass);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return this.original.annotations;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getElementAnnotations(int i) {
        return this.original.elementAnnotations[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int i) {
        return this.original.elementDescriptors[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String str) {
        str.getClass();
        return this.original.getElementIndex(str);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int i) {
        return this.original.elementNames[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.original.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final Okio__OkioKt getKind() {
        return this.original.kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }

    public final int hashCode() {
        return this.serialName.hashCode() + (this.kClass.hashCode() * 31);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int i) {
        return this.original.elementOptionality[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isNullable() {
        return false;
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.kClass + ", original: " + this.original + ')';
    }
}
