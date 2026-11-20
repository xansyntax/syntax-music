package kotlinx.serialization.json.internal;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.room.RoomDatabase$createConnectionManager$2;
import com.google.common.base.Joiner;
import dagger.hilt.EntryPoints;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.ElementMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonDecodingException;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {
    public final JsonConfiguration configuration;
    public int currentIndex;
    public Joiner discriminatorHolder;
    public final JsonElementMarker elementMarker;
    public final Json json;
    public final AbstractJsonLexer lexer;
    public final WriteMode mode;
    public final SerializersModule serializersModule;

    public StreamingJsonDecoder(Json json, WriteMode writeMode, AbstractJsonLexer abstractJsonLexer, SerialDescriptor serialDescriptor, Joiner joiner) {
        json.getClass();
        serialDescriptor.getClass();
        this.json = json;
        this.mode = writeMode;
        this.lexer = abstractJsonLexer;
        this.serializersModule = json.serializersModule;
        this.currentIndex = -1;
        this.discriminatorHolder = joiner;
        JsonConfiguration jsonConfiguration = json.configuration;
        this.configuration = jsonConfiguration;
        this.elementMarker = jsonConfiguration.explicitNulls ? null : new JsonElementMarker(serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        Json json = this.json;
        WriteMode writeModeSwitchMode = WriteModeKt.switchMode(serialDescriptor, json);
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        JsonPath jsonPath = (JsonPath) abstractJsonLexer.path;
        int i = jsonPath.currentDepth + 1;
        jsonPath.currentDepth = i;
        if (i == ((Object[]) jsonPath.currentObjectPath).length) {
            jsonPath.resize();
        }
        ((Object[]) jsonPath.currentObjectPath)[i] = serialDescriptor;
        abstractJsonLexer.consumeNextToken(writeModeSwitchMode.begin);
        if (abstractJsonLexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        int iOrdinal = writeModeSwitchMode.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
            return new StreamingJsonDecoder(this.json, writeModeSwitchMode, abstractJsonLexer, serialDescriptor, this.discriminatorHolder);
        }
        return (this.mode == writeModeSwitchMode && json.configuration.explicitNulls) ? this : new StreamingJsonDecoder(this.json, writeModeSwitchMode, abstractJsonLexer, serialDescriptor, this.discriminatorHolder);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        boolean z;
        boolean z2;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        int iSkipWhitespaces = abstractJsonLexer.skipWhitespaces();
        if (iSkipWhitespaces == abstractJsonLexer.getSource().length()) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "EOF", 0, null, 6);
            throw null;
        }
        if (abstractJsonLexer.getSource().charAt(iSkipWhitespaces) == '\"') {
            iSkipWhitespaces++;
            z = true;
        } else {
            z = false;
        }
        int iPrefetchOrEof = abstractJsonLexer.prefetchOrEof(iSkipWhitespaces);
        if (iPrefetchOrEof >= abstractJsonLexer.getSource().length() || iPrefetchOrEof == -1) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "EOF", 0, null, 6);
            throw null;
        }
        int i = iPrefetchOrEof + 1;
        int iCharAt = abstractJsonLexer.getSource().charAt(iPrefetchOrEof) | ' ';
        if (iCharAt == 102) {
            abstractJsonLexer.consumeBooleanLiteral(i, "alse");
            z2 = false;
        } else {
            if (iCharAt != 116) {
                AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected valid boolean literal prefix, but had '" + abstractJsonLexer.consumeStringLenient() + '\'', 0, null, 6);
                throw null;
            }
            abstractJsonLexer.consumeBooleanLiteral(i, "rue");
            z2 = true;
        }
        if (!z) {
            return z2;
        }
        if (abstractJsonLexer.currentPosition == abstractJsonLexer.getSource().length()) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "EOF", 0, null, 6);
            throw null;
        }
        if (abstractJsonLexer.getSource().charAt(abstractJsonLexer.currentPosition) == '\"') {
            abstractJsonLexer.currentPosition++;
            return z2;
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        long jConsumeNumericLiteral = abstractJsonLexer.consumeNumericLiteral();
        byte b = (byte) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == b) {
            return b;
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse byte for input '" + jConsumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String strConsumeStringLenient = abstractJsonLexer.consumeStringLenient();
        if (strConsumeStringLenient.length() == 1) {
            return strConsumeStringLenient.charAt(0);
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, Format$$ExternalSyntheticOutline0.m('\'', "Expected single char, but got '", strConsumeStringLenient), 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String strConsumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            double d = Double.parseDouble(strConsumeStringLenient);
            if (this.json.configuration.allowSpecialFloatingPointValues || Math.abs(d) <= Double.MAX_VALUE) {
                return d;
            }
            AbstractJsonLexer.fail$default(abstractJsonLexer, WriteModeKt.nonFiniteFpMessage(Double.valueOf(d), null), 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, Format$$ExternalSyntheticOutline0.m('\'', "Failed to parse type 'double' for input '", strConsumeStringLenient), 0, null, 6);
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeElementIndex(SerialDescriptor serialDescriptor) {
        int jsonNameIndex;
        char c;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        JsonPath jsonPath = (JsonPath) abstractJsonLexer.path;
        serialDescriptor.getClass();
        WriteMode writeMode = this.mode;
        int iOrdinal = writeMode.ordinal();
        char c2 = ':';
        int i = 0;
        zTryConsumeComma = false;
        boolean zTryConsumeComma = false;
        Json json = this.json;
        byte b = 1;
        int i2 = -1;
        if (iOrdinal == 0) {
            boolean zTryConsumeComma2 = abstractJsonLexer.tryConsumeComma();
            while (true) {
                boolean zCanConsumeValue = abstractJsonLexer.canConsumeValue();
                byte b2 = b;
                JsonElementMarker jsonElementMarker = this.elementMarker;
                if (zCanConsumeValue) {
                    boolean z = this.configuration.isLenient;
                    String strConsumeStringLenientNotNull = z ? abstractJsonLexer.consumeStringLenientNotNull() : abstractJsonLexer.consumeKeyString();
                    abstractJsonLexer.consumeNextToken(c2);
                    jsonNameIndex = WriteModeKt.getJsonNameIndex(serialDescriptor, json, strConsumeStringLenientNotNull);
                    if (jsonNameIndex == -3) {
                        if (!WriteModeKt.ignoreUnknownKeys(serialDescriptor, json)) {
                            Joiner joiner = this.discriminatorHolder;
                            if (joiner == null || !Intrinsics.areEqual(joiner.separator, strConsumeStringLenientNotNull)) {
                                int i3 = jsonPath.currentDepth;
                                int[] iArr = (int[]) jsonPath.indicies;
                                if (iArr[i3] == -2) {
                                    iArr[i3] = -1;
                                    i3--;
                                    jsonPath.currentDepth = i3;
                                }
                                if (i3 != -1) {
                                    jsonPath.currentDepth = i3 - 1;
                                }
                                abstractJsonLexer.fail(StringsKt.lastIndexOf$default(abstractJsonLexer.substring(0, abstractJsonLexer.currentPosition), strConsumeStringLenientNotNull, 6), Format$$ExternalSyntheticOutline0.m('\'', "Encountered an unknown key '", strConsumeStringLenientNotNull), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.");
                                throw null;
                            }
                            joiner.separator = null;
                        }
                        ArrayList arrayList = new ArrayList();
                        byte bPeekNextToken = abstractJsonLexer.peekNextToken();
                        if (bPeekNextToken == 8 || bPeekNextToken == 6) {
                            while (true) {
                                byte bPeekNextToken2 = abstractJsonLexer.peekNextToken();
                                byte b3 = b2;
                                if (bPeekNextToken2 == b3) {
                                    if (z) {
                                        abstractJsonLexer.consumeStringLenient();
                                    } else {
                                        abstractJsonLexer.consumeKeyString();
                                    }
                                    b2 = b3;
                                } else {
                                    c = 6;
                                    if (bPeekNextToken2 == 8 || bPeekNextToken2 == 6) {
                                        arrayList.add(Byte.valueOf(bPeekNextToken2));
                                    } else if (bPeekNextToken2 == 9) {
                                        if (((Number) CollectionsKt.last(arrayList)).byteValue() != 8) {
                                            AbstractJsonLexer.fail$default(abstractJsonLexer, "found ] instead of }", 0, null, 6);
                                            throw null;
                                        }
                                        CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                                    } else if (bPeekNextToken2 == 7) {
                                        if (((Number) CollectionsKt.last(arrayList)).byteValue() != 6) {
                                            AbstractJsonLexer.fail$default(abstractJsonLexer, "found } instead of ]", 0, null, 6);
                                            throw null;
                                        }
                                        CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                                    } else if (bPeekNextToken2 == 10) {
                                        AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6);
                                        throw null;
                                    }
                                    abstractJsonLexer.consumeNextToken();
                                    if (arrayList.size() == 0) {
                                        break;
                                    }
                                    b2 = 1;
                                }
                            }
                        } else {
                            abstractJsonLexer.consumeStringLenient();
                            c = 6;
                        }
                        zTryConsumeComma2 = abstractJsonLexer.tryConsumeComma();
                        c2 = ':';
                        b = 1;
                    } else if (jsonElementMarker != null) {
                        ElementMarker elementMarker = jsonElementMarker.origin;
                        if (jsonNameIndex < 64) {
                            elementMarker.lowerMarks |= 1 << jsonNameIndex;
                        } else {
                            int i4 = (jsonNameIndex >>> 6) - 1;
                            long[] jArr = elementMarker.highMarksArray;
                            jArr[i4] = jArr[i4] | (1 << (jsonNameIndex & 63));
                        }
                    }
                } else if (!zTryConsumeComma2) {
                    if (jsonElementMarker == null) {
                        break;
                    }
                    ElementMarker elementMarker2 = jsonElementMarker.origin;
                    RoomDatabase$createConnectionManager$2 roomDatabase$createConnectionManager$2 = elementMarker2.readIfAbsent;
                    SerialDescriptor serialDescriptor2 = elementMarker2.descriptor;
                    int elementsCount = serialDescriptor2.getElementsCount();
                    while (true) {
                        long j = elementMarker2.lowerMarks;
                        long j2 = -1;
                        if (j == -1) {
                            if (elementsCount <= 64) {
                                break;
                            }
                            long[] jArr2 = elementMarker2.highMarksArray;
                            int length = jArr2.length;
                            loop3: while (i < length) {
                                int i5 = i + 1;
                                int i6 = i5 * 64;
                                long j3 = jArr2[i];
                                while (true) {
                                    if (j3 != j2) {
                                        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j3);
                                        j3 |= 1 << iNumberOfTrailingZeros;
                                        jsonNameIndex = iNumberOfTrailingZeros + i6;
                                        if (((Boolean) roomDatabase$createConnectionManager$2.invoke(serialDescriptor2, Integer.valueOf(jsonNameIndex))).booleanValue()) {
                                            jArr2[i] = j3;
                                        } else {
                                            j2 = -1;
                                        }
                                    } else {
                                        jArr2[i] = j3;
                                        i = i5;
                                        j2 = -1;
                                    }
                                }
                            }
                            break;
                        }
                        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(~j);
                        elementMarker2.lowerMarks |= 1 << iNumberOfTrailingZeros2;
                        if (((Boolean) roomDatabase$createConnectionManager$2.invoke(serialDescriptor2, Integer.valueOf(iNumberOfTrailingZeros2))).booleanValue()) {
                            i2 = iNumberOfTrailingZeros2;
                            break;
                        }
                    }
                } else {
                    JsonConfiguration jsonConfiguration = json.configuration;
                    WriteModeKt.invalidTrailingComma(abstractJsonLexer, "object");
                    throw null;
                }
                i2 = jsonNameIndex;
                break;
            }
        } else if (iOrdinal != 2) {
            boolean zTryConsumeComma3 = abstractJsonLexer.tryConsumeComma();
            if (abstractJsonLexer.canConsumeValue()) {
                int i7 = this.currentIndex;
                if (i7 != -1 && !zTryConsumeComma3) {
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected end of the array or comma", 0, null, 6);
                    throw null;
                }
                i2 = i7 + 1;
                this.currentIndex = i2;
            } else if (zTryConsumeComma3) {
                JsonConfiguration jsonConfiguration2 = json.configuration;
                WriteModeKt.invalidTrailingComma(abstractJsonLexer, "array");
                throw null;
            }
        } else {
            int i8 = this.currentIndex;
            Object[] objArr = i8 % 2 != 0;
            if (objArr != true) {
                abstractJsonLexer.consumeNextToken(':');
            } else if (i8 != -1) {
                zTryConsumeComma = abstractJsonLexer.tryConsumeComma();
            }
            if (abstractJsonLexer.canConsumeValue()) {
                if (objArr != false) {
                    int i9 = this.currentIndex;
                    int i10 = abstractJsonLexer.currentPosition;
                    if (i9 == -1) {
                        if (zTryConsumeComma) {
                            AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected leading comma", i10, null, 4);
                            throw null;
                        }
                    } else if (!zTryConsumeComma) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected comma after the key-value pair", i10, null, 4);
                        throw null;
                    }
                }
                i2 = this.currentIndex + 1;
                this.currentIndex = i2;
            } else if (zTryConsumeComma) {
                JsonConfiguration jsonConfiguration3 = json.configuration;
                WriteModeKt.invalidTrailingComma(abstractJsonLexer, "object");
                throw null;
            }
        }
        if (writeMode != WriteMode.MAP) {
            ((int[]) jsonPath.indicies)[jsonPath.currentDepth] = i2;
        }
        return i2;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        return WriteModeKt.getJsonNameIndexOrThrow(serialDescriptor, this.json, decodeString(), " at path ".concat(((JsonPath) this.lexer.path).getPath()));
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String strConsumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            float f = Float.parseFloat(strConsumeStringLenient);
            if (this.json.configuration.allowSpecialFloatingPointValues || Math.abs(f) <= Float.MAX_VALUE) {
                return f;
            }
            AbstractJsonLexer.fail$default(abstractJsonLexer, WriteModeKt.nonFiniteFpMessage(Float.valueOf(f), null), 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, Format$$ExternalSyntheticOutline0.m('\'', "Failed to parse type 'float' for input '", strConsumeStringLenient), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final Decoder decodeInline(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        return StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor) ? new JsonDecoderForUnsignedTypes(this.lexer, this.json) : super.decodeInline(serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        long jConsumeNumericLiteral = abstractJsonLexer.consumeNumericLiteral();
        int i = (int) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == i) {
            return i;
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse int for input '" + jConsumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.configuration, this.lexer).read();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean decodeNotNullMark() {
        boolean z;
        JsonElementMarker jsonElementMarker = this.elementMarker;
        if (!(jsonElementMarker != null ? jsonElementMarker.isUnmarkedNull : false)) {
            AbstractJsonLexer abstractJsonLexer = this.lexer;
            int iPrefetchOrEof = abstractJsonLexer.prefetchOrEof(abstractJsonLexer.skipWhitespaces());
            int length = abstractJsonLexer.getSource().length() - iPrefetchOrEof;
            if (length >= 4 && iPrefetchOrEof != -1) {
                int i = 0;
                while (true) {
                    if (i >= 4) {
                        if (length <= 4 || WriteModeKt.charToTokenClass(abstractJsonLexer.getSource().charAt(iPrefetchOrEof + 4)) != 0) {
                            abstractJsonLexer.currentPosition = iPrefetchOrEof + 4;
                            z = true;
                            break;
                        }
                    } else if ("null".charAt(i) == abstractJsonLexer.getSource().charAt(iPrefetchOrEof + i)) {
                        i++;
                    }
                    z = false;
                    break;
                }
            } else {
                z = false;
                break;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final Void decodeNull() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public final Object decodeSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj) {
        JsonPath jsonPath = (JsonPath) this.lexer.path;
        serialDescriptor.getClass();
        deserializationStrategy.getClass();
        boolean z = this.mode == WriteMode.MAP && (i & 1) == 0;
        if (z) {
            int[] iArr = (int[]) jsonPath.indicies;
            int i2 = jsonPath.currentDepth;
            if (iArr[i2] == -2) {
                ((Object[]) jsonPath.currentObjectPath)[i2] = JsonPath.Tombstone.INSTANCE;
            }
        }
        Object objDecodeSerializableElement = super.decodeSerializableElement(serialDescriptor, i, deserializationStrategy, obj);
        if (z) {
            int[] iArr2 = (int[]) jsonPath.indicies;
            int i3 = jsonPath.currentDepth;
            if (iArr2[i3] != -2) {
                int i4 = i3 + 1;
                jsonPath.currentDepth = i4;
                if (i4 == ((Object[]) jsonPath.currentObjectPath).length) {
                    jsonPath.resize();
                }
            }
            Object[] objArr = (Object[]) jsonPath.currentObjectPath;
            int i5 = jsonPath.currentDepth;
            objArr[i5] = ((JsonConfiguration) jsonPath.configuration).exceptionsWithDebugInfo ? objDecodeSerializableElement : JsonPath.Tombstone.INSTANCE$1;
            ((int[]) jsonPath.indicies)[i5] = -2;
        }
        return objDecodeSerializableElement;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0135  */
    /* JADX WARN: Code duplicated, block: B:43:0x0136  */
    /* JADX WARN: Instruction removed from duplicated block: B:43:0x0136, please report this as an issue */
    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final Object decodeSerializableValue(DeserializationStrategy deserializationStrategy) {
        String message;
        Json json = this.json;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        JsonPath jsonPath = (JsonPath) abstractJsonLexer.path;
        deserializationStrategy.getClass();
        try {
            if (!(deserializationStrategy instanceof AbstractPolymorphicSerializer)) {
                return deserializationStrategy.deserialize(this);
            }
            JsonConfiguration jsonConfiguration = json.configuration;
            String strClassDiscriminator = WriteModeKt.classDiscriminator(((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor(), json);
            String strPeekLeadingMatchingValue = abstractJsonLexer.peekLeadingMatchingValue(strClassDiscriminator, this.configuration.isLenient);
            if (strPeekLeadingMatchingValue != null) {
                try {
                    DeserializationStrategy deserializationStrategyFindPolymorphicSerializer = EntryPoints.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializationStrategy, this, strPeekLeadingMatchingValue);
                    Joiner joiner = new Joiner();
                    joiner.separator = strClassDiscriminator;
                    this.discriminatorHolder = joiner;
                    return deserializationStrategyFindPolymorphicSerializer.deserialize(this);
                } catch (SerializationException e) {
                    String message2 = e.getMessage();
                    message2.getClass();
                    String strRemoveSuffix = StringsKt.removeSuffix(StringsKt.substringBefore$default(message2, '\n'), ".");
                    String message3 = e.getMessage();
                    message3.getClass();
                    AbstractJsonLexer.fail$default(abstractJsonLexer, strRemoveSuffix, 0, StringsKt.substringAfter('\n', message3, ""), 2);
                    throw null;
                }
            }
            JsonConfiguration jsonConfiguration2 = json.configuration;
            String strClassDiscriminator2 = WriteModeKt.classDiscriminator(((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor(), json);
            JsonElement jsonElementDecodeJsonElement = decodeJsonElement();
            String serialName = ((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor().getSerialName();
            if (jsonElementDecodeJsonElement instanceof JsonObject) {
                JsonObject jsonObject = (JsonObject) jsonElementDecodeJsonElement;
                JsonElement jsonElement = (JsonElement) jsonObject.get(strClassDiscriminator2);
                try {
                    return WriteModeKt.readPolymorphicJson(json, strClassDiscriminator2, jsonObject, EntryPoints.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializationStrategy, this, jsonElement != null ? JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(jsonElement)) : null));
                } catch (SerializationException e2) {
                    String message4 = e2.getMessage();
                    message4.getClass();
                    throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, message4, null, null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonObject.toString(), -1).toString() : null));
                }
            }
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName, jsonPath.getPath(), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementDecodeJsonElement.toString(), -1).toString() : null));
            message = e.getMessage();
            message.getClass();
            if (StringsKt.contains(message, "at path", false)) {
                throw e;
            }
            throw new MissingFieldException(e.getMessage() + " at path: " + jsonPath.getPath(), e, e.missingFields, e.serialName);
        } catch (MissingFieldException e3) {
            message = e3.getMessage();
            message.getClass();
            if (StringsKt.contains(message, "at path", false)) {
                throw e3;
            }
            throw new MissingFieldException(e3.getMessage() + " at path: " + jsonPath.getPath(), e3, e3.missingFields, e3.serialName);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        long jConsumeNumericLiteral = abstractJsonLexer.consumeNumericLiteral();
        short s = (short) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == s) {
            return s;
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse short for input '" + jConsumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        boolean z = this.configuration.isLenient;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        return z ? abstractJsonLexer.consumeStringLenientNotNull() : abstractJsonLexer.consumeString();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public final void endStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        int elementsCount = serialDescriptor.getElementsCount();
        Json json = this.json;
        if (elementsCount == 0 && WriteModeKt.ignoreUnknownKeys(serialDescriptor, json)) {
            while (decodeElementIndex(serialDescriptor) != -1) {
            }
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        if (abstractJsonLexer.tryConsumeComma()) {
            JsonConfiguration jsonConfiguration = json.configuration;
            WriteModeKt.invalidTrailingComma(abstractJsonLexer, "");
            throw null;
        }
        abstractJsonLexer.consumeNextToken(this.mode.end);
        JsonPath jsonPath = (JsonPath) abstractJsonLexer.path;
        int i = jsonPath.currentDepth;
        int[] iArr = (int[]) jsonPath.indicies;
        if (iArr[i] == -2) {
            iArr[i] = -1;
            i--;
            jsonPath.currentDepth = i;
        }
        if (i != -1) {
            jsonPath.currentDepth = i - 1;
        }
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json getJson() {
        return this.json;
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}
