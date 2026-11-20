package kotlinx.serialization.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.date.GMTDateParser;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.InstantKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DurationSerializer implements KSerializer {
    public static final DurationSerializer INSTANCE = new DurationSerializer();
    public static final PrimitiveSerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.time.Duration", PrimitiveKind$INT.INSTANCE$8);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Path.Companion companion = Duration.Companion;
        String strDecodeString = decoder.decodeString();
        strDecodeString.getClass();
        try {
            long duration$default = InstantKt.parseDuration$default(strDecodeString);
            if (duration$default == Duration.INVALID) {
                throw new IllegalStateException("invariant failed");
            }
            return new Duration(duration$default);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(IntIntPair$$ExternalSyntheticOutline0.m("Invalid ISO duration string format: '", strDecodeString, "'."), e);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        long j = ((Duration) obj).rawValue;
        Path.Companion companion = Duration.Companion;
        StringBuilder sb = new StringBuilder();
        if (j < 0) {
            sb.append('-');
        }
        sb.append("PT");
        long jM1892unaryMinusUwyO8pc = j < 0 ? Duration.m1892unaryMinusUwyO8pc(j) : j;
        long jM1891toLongimpl = Duration.m1891toLongimpl(jM1892unaryMinusUwyO8pc, DurationUnit.HOURS);
        boolean z = false;
        int iM1891toLongimpl = Duration.m1889isInfiniteimpl(jM1892unaryMinusUwyO8pc) ? 0 : (int) (Duration.m1891toLongimpl(jM1892unaryMinusUwyO8pc, DurationUnit.MINUTES) % 60);
        int iM1891toLongimpl2 = Duration.m1889isInfiniteimpl(jM1892unaryMinusUwyO8pc) ? 0 : (int) (Duration.m1891toLongimpl(jM1892unaryMinusUwyO8pc, DurationUnit.SECONDS) % 60);
        int iM1888getNanosecondsComponentimpl = Duration.m1888getNanosecondsComponentimpl(jM1892unaryMinusUwyO8pc);
        if (Duration.m1889isInfiniteimpl(j)) {
            jM1891toLongimpl = 9999999999999L;
        }
        boolean z2 = jM1891toLongimpl != 0;
        boolean z3 = (iM1891toLongimpl2 == 0 && iM1888getNanosecondsComponentimpl == 0) ? false : true;
        if (iM1891toLongimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(jM1891toLongimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(iM1891toLongimpl);
            sb.append(GMTDateParser.MONTH);
        }
        if (z3 || (!z2 && !z)) {
            Duration.m1885appendFractionalimpl(sb, iM1891toLongimpl2, iM1888getNanosecondsComponentimpl, 9, "S", true);
        }
        encoder.encodeString(sb.toString());
    }
}
