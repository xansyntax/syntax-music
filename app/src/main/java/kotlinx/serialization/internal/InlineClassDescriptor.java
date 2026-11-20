package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineClassDescriptor extends PluginGeneratedSerialDescriptor {
    public final boolean isInline;

    public InlineClassDescriptor(String str, GeneratedSerializer generatedSerializer) {
        super(str, generatedSerializer, 1);
        this.isInline = true;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InlineClassDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (this.serialName.equals(serialDescriptor.getSerialName())) {
                InlineClassDescriptor inlineClassDescriptor = (InlineClassDescriptor) obj;
                if (inlineClassDescriptor.isInline && Arrays.equals((SerialDescriptor[]) this.typeParameterDescriptors$delegate.getValue(), (SerialDescriptor[]) inlineClassDescriptor.typeParameterDescriptors$delegate.getValue())) {
                    int elementsCount = serialDescriptor.getElementsCount();
                    int i = this.elementsCount;
                    if (i == elementsCount) {
                        for (int i2 = 0; i2 < i; i2++) {
                            if (Intrinsics.areEqual(getElementDescriptor(i2).getSerialName(), serialDescriptor.getElementDescriptor(i2).getSerialName()) && Intrinsics.areEqual(getElementDescriptor(i2).getKind(), serialDescriptor.getElementDescriptor(i2).getKind())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return this.isInline;
    }
}
