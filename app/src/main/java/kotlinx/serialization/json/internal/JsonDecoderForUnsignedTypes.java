package kotlinx.serialization.json.internal;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {
    public final AbstractJsonLexer lexer;
    public final SerializersModule serializersModule;

    public JsonDecoderForUnsignedTypes(AbstractJsonLexer abstractJsonLexer, Json json) {
        json.getClass();
        this.lexer = abstractJsonLexer;
        this.serializersModule = json.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String strConsumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            return Okio__OkioKt.toUByte(strConsumeStringLenient);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, Format$$ExternalSyntheticOutline0.m('\'', "Failed to parse type 'UByte' for input '", strConsumeStringLenient), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeElementIndex(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        throw new IllegalStateException("unsupported");
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String strConsumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            strConsumeStringLenient.getClass();
            UInt uIntOrNull = Okio__OkioKt.toUIntOrNull(strConsumeStringLenient);
            if (uIntOrNull != null) {
                return uIntOrNull.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, Format$$ExternalSyntheticOutline0.m('\'', "Failed to parse type 'UInt' for input '", strConsumeStringLenient), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String strConsumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            strConsumeStringLenient.getClass();
            ULong uLongOrNull = Okio__OkioKt.toULongOrNull(strConsumeStringLenient);
            if (uLongOrNull != null) {
                return uLongOrNull.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, Format$$ExternalSyntheticOutline0.m('\'', "Failed to parse type 'ULong' for input '", strConsumeStringLenient), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String strConsumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            return Okio__OkioKt.toUShort(strConsumeStringLenient);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, Format$$ExternalSyntheticOutline0.m('\'', "Failed to parse type 'UShort' for input '", strConsumeStringLenient), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}
