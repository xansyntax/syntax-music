package kotlinx.serialization.internal;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PrimitiveArrayDescriptor extends ListLikeDescriptor {
    public final String serialName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveArrayDescriptor(SerialDescriptor serialDescriptor) {
        super(serialDescriptor);
        serialDescriptor.getClass();
        this.serialName = serialDescriptor.getSerialName() + "Array";
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }
}
