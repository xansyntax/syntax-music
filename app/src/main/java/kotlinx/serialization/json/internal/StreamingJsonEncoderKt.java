package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StreamingJsonEncoderKt {
    public static final Set unsignedNumberDescriptors = ArraysKt.toSet(new SerialDescriptor[]{UIntSerializer.descriptor, ULongSerializer.descriptor, UByteSerializer.descriptor, UShortSerializer.descriptor});

    public static final boolean isUnsignedNumber(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        return serialDescriptor.isInline() && unsignedNumberDescriptors.contains(serialDescriptor);
    }
}
