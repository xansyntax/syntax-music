package kotlinx.serialization.internal;

import io.ktor.http.Url$$ExternalSyntheticLambda1;
import java.util.Arrays;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.ArraysKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumSerializer implements KSerializer {
    public final SynchronizedLazyImpl descriptor$delegate;
    public EnumDescriptor overriddenDescriptor;
    public final Enum[] values;

    public EnumSerializer(String str, Enum[] enumArr) {
        enumArr.getClass();
        this.values = enumArr;
        this.descriptor$delegate = new SynchronizedLazyImpl(new Url$$ExternalSyntheticLambda1(this, str, (byte) 5));
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int iDecodeEnum = decoder.decodeEnum(getDescriptor());
        Enum[] enumArr = this.values;
        if (iDecodeEnum >= 0 && iDecodeEnum < enumArr.length) {
            return enumArr[iDecodeEnum];
        }
        throw new SerializationException(iDecodeEnum + " is not among valid " + getDescriptor().getSerialName() + " enum values, values size is " + enumArr.length);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Enum r5 = (Enum) obj;
        r5.getClass();
        Enum[] enumArr = this.values;
        int iIndexOf = ArraysKt.indexOf(enumArr, r5);
        if (iIndexOf != -1) {
            encoder.encodeEnum(getDescriptor(), iIndexOf);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(r5);
        String serialName = getDescriptor().getSerialName();
        String string = Arrays.toString(enumArr);
        string.getClass();
        sb.append(" is not a valid enum ");
        sb.append(serialName);
        sb.append(", must be one of ");
        sb.append(string);
        throw new SerializationException(sb.toString());
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().getSerialName() + '>';
    }
}
