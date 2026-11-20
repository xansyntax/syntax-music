package kotlinx.serialization.internal;

import kotlin.Unit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UnitSerializer implements KSerializer {
    public static final UnitSerializer INSTANCE = new UnitSerializer();
    public final /* synthetic */ ObjectSerializer $$delegate_0 = new ObjectSerializer();

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        this.$$delegate_0.deserialize(decoder);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.$$delegate_0.getDescriptor();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Unit unit = (Unit) obj;
        unit.getClass();
        this.$$delegate_0.serialize(encoder, unit);
    }
}
