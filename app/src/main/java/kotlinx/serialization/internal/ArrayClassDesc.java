package kotlinx.serialization.internal;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ArrayClassDesc extends ListLikeDescriptor {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArrayClassDesc(SerialDescriptor serialDescriptor, byte b) {
        super(serialDescriptor);
        this.$r8$classId = b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        switch (this.$r8$classId) {
            case 0:
                return "kotlin.Array";
            case 1:
                return "kotlin.collections.ArrayList";
            case 2:
                return "kotlin.collections.HashSet";
            default:
                return "kotlin.collections.LinkedHashSet";
        }
    }
}
