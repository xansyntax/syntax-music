package kotlinx.serialization.internal;

import kotlin.SynchronizedLazyImpl;
import kotlin.UIntArray;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexingIterable;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$ENUM;
import okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda3;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {
    public final SynchronizedLazyImpl elementDescriptors$delegate;
    public final SerialKind$ENUM kind;

    public EnumDescriptor(String str, int i) {
        super(str, null, i);
        this.kind = SerialKind$ENUM.INSTANCE;
        this.elementDescriptors$delegate = new SynchronizedLazyImpl(new Http2Connection$$ExternalSyntheticLambda3(i, str, this));
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        return serialDescriptor.getKind() == SerialKind$ENUM.INSTANCE && this.serialName.equals(serialDescriptor.getSerialName()) && Intrinsics.areEqual(EnumsKt.cachedSerialNames(this), EnumsKt.cachedSerialNames(serialDescriptor));
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int i) {
        return ((SerialDescriptor[]) this.elementDescriptors$delegate.getValue())[i];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final Okio__OkioKt getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final int hashCode() {
        int iHashCode = this.serialName.hashCode();
        UIntArray.Iterator iterator = new UIntArray.Iterator(this);
        int iHashCode2 = 1;
        while (iterator.hasNext()) {
            int i = iHashCode2 * 31;
            String str = (String) iterator.next();
            iHashCode2 = i + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final String toString() {
        return CollectionsKt.joinToString$default(new IndexingIterable((byte) 4, this), ", ", this.serialName.concat("("), ")", null, 56);
    }
}
