package kotlinx.serialization;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import okio.internal.ResourceFileSystem$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PolymorphicSerializer extends AbstractPolymorphicSerializer {
    public final KClass baseClass;
    public final Lazy descriptor$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ResourceFileSystem$$ExternalSyntheticLambda0(4, this));

    public PolymorphicSerializer(KClass kClass) {
        this.baseClass = kClass;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass getBaseClass() {
        return this.baseClass;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.baseClass + ')';
    }
}
