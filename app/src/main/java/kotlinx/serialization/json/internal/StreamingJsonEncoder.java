package kotlinx.serialization.json.internal;

import androidx.media3.common.FlagSet;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {
    public final FlagSet.Builder composer;
    public final JsonConfiguration configuration;
    public boolean forceQuoting;
    public final Json json;
    public final WriteMode mode;
    public final JsonEncoder[] modeReuseCache;
    public String polymorphicDiscriminator;
    public String polymorphicSerialName;
    public final SerializersModule serializersModule;

    public StreamingJsonEncoder(FlagSet.Builder builder, Json json, WriteMode writeMode, JsonEncoder[] jsonEncoderArr) {
        builder.getClass();
        json.getClass();
        this.composer = builder;
        this.json = json;
        this.mode = writeMode;
        this.modeReuseCache = jsonEncoderArr;
        this.serializersModule = json.serializersModule;
        this.configuration = json.configuration;
        int iOrdinal = writeMode.ordinal();
        if (jsonEncoderArr != null) {
            JsonEncoder jsonEncoder = jsonEncoderArr[iOrdinal];
            if (jsonEncoder == null && jsonEncoder == this) {
                return;
            }
            jsonEncoderArr[iOrdinal] = this;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final CompositeEncoder beginStructure(SerialDescriptor serialDescriptor) {
        JsonEncoder jsonEncoder;
        serialDescriptor.getClass();
        Json json = this.json;
        WriteMode writeModeSwitchMode = WriteModeKt.switchMode(serialDescriptor, json);
        char c = writeModeSwitchMode.begin;
        FlagSet.Builder builder = this.composer;
        builder.print(c);
        builder.indent();
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            String serialName = this.polymorphicSerialName;
            if (serialName == null) {
                serialName = serialDescriptor.getSerialName();
            }
            builder.nextItem();
            builder.printQuoted(str);
            builder.print(':');
            builder.space();
            encodeString(serialName);
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        if (this.mode == writeModeSwitchMode) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.modeReuseCache;
        return (jsonEncoderArr == null || (jsonEncoder = jsonEncoderArr[writeModeSwitchMode.ordinal()]) == null) ? new StreamingJsonEncoder(builder, json, writeModeSwitchMode, jsonEncoderArr) : jsonEncoder;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean z) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(z));
        } else {
            ((InternalJsonWriter) this.composer.flags).write(String.valueOf(z));
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte b) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) b));
        } else {
            this.composer.print(b);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char c) {
        encodeString(String.valueOf(c));
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double d) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(d));
        } else {
            ((InternalJsonWriter) this.composer.flags).write(String.valueOf(d));
        }
        if (!this.configuration.allowSpecialFloatingPointValues && Math.abs(d) > Double.MAX_VALUE) {
            throw WriteModeKt.InvalidFloatingPointEncoded(Double.valueOf(d), null);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public final boolean encodeElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        int iOrdinal = this.mode.ordinal();
        FlagSet.Builder builder = this.composer;
        if (iOrdinal == 1) {
            if (!builder.buildCalled) {
                builder.print(',');
            }
            builder.nextItem();
            return true;
        }
        boolean z = false;
        if (iOrdinal == 2) {
            if (builder.buildCalled) {
                this.forceQuoting = true;
                builder.nextItem();
                return true;
            }
            if (i % 2 == 0) {
                builder.print(',');
                builder.nextItem();
                z = true;
            } else {
                builder.print(':');
                builder.space();
            }
            this.forceQuoting = z;
            return true;
        }
        if (iOrdinal == 3) {
            if (i == 0) {
                this.forceQuoting = true;
            }
            if (i == 1) {
                builder.print(',');
                builder.space();
                this.forceQuoting = false;
            }
            return true;
        }
        if (!builder.buildCalled) {
            builder.print(',');
        }
        builder.nextItem();
        Json json = this.json;
        json.getClass();
        WriteModeKt.namingStrategy(serialDescriptor, json);
        encodeString(serialDescriptor.getElementName(i));
        builder.print(':');
        builder.space();
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        encodeString(serialDescriptor.getElementName(i));
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float f) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(f));
        } else {
            ((InternalJsonWriter) this.composer.flags).write(String.valueOf(f));
        }
        if (!this.configuration.allowSpecialFloatingPointValues && Math.abs(f) > Float.MAX_VALUE) {
            throw WriteModeKt.InvalidFloatingPointEncoded(Float.valueOf(f), null);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final Encoder encodeInline(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        boolean zIsUnsignedNumber = StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor);
        WriteMode writeMode = this.mode;
        Json json = this.json;
        FlagSet.Builder composerForUnquotedLiterals = this.composer;
        if (zIsUnsignedNumber) {
            if (!(composerForUnquotedLiterals instanceof ComposerForUnsignedNumbers)) {
                composerForUnquotedLiterals = new ComposerForUnsignedNumbers((InternalJsonWriter) composerForUnquotedLiterals.flags, this.forceQuoting);
            }
            return new StreamingJsonEncoder(composerForUnquotedLiterals, json, writeMode, null);
        }
        if (serialDescriptor.isInline() && serialDescriptor.equals(JsonElementKt.jsonUnquotedLiteralDescriptor)) {
            if (!(composerForUnquotedLiterals instanceof ComposerForUnquotedLiterals)) {
                composerForUnquotedLiterals = new ComposerForUnquotedLiterals((InternalJsonWriter) composerForUnquotedLiterals.flags, this.forceQuoting);
            }
            return new StreamingJsonEncoder(composerForUnquotedLiterals, json, writeMode, null);
        }
        if (this.polymorphicDiscriminator == null) {
            return super.encodeInline(serialDescriptor);
        }
        this.polymorphicSerialName = serialDescriptor.getSerialName();
        return this;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int i) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(i));
        } else {
            this.composer.print(i);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long j) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(j));
        } else {
            this.composer.print(j);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeNull() {
        FlagSet.Builder builder = this.composer;
        builder.getClass();
        ((InternalJsonWriter) builder.flags).write("null");
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy serializationStrategy, Object obj) {
        serialDescriptor.getClass();
        serializationStrategy.getClass();
        if (obj != null || this.configuration.explicitNulls) {
            super.encodeNullableSerializableElement(serialDescriptor, i, serializationStrategy, obj);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003b  */
    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeSerializableValue(SerializationStrategy serializationStrategy, Object obj) {
        String strClassDiscriminator;
        SerializationStrategy serializationStrategyFindPolymorphicSerializer;
        serializationStrategy.getClass();
        Json json = this.json;
        boolean z = serializationStrategy instanceof AbstractPolymorphicSerializer;
        ClassDiscriminatorMode classDiscriminatorMode = json.configuration.classDiscriminatorMode;
        if (!z) {
            int iOrdinal = classDiscriminatorMode.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    Okio__OkioKt kind = serializationStrategy.getDescriptor().getKind();
                    strClassDiscriminator = (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$1) || Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$3)) ? WriteModeKt.classDiscriminator(serializationStrategy.getDescriptor(), json) : null;
                } else if (iOrdinal != 2) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
            }
        } else if (classDiscriminatorMode != ClassDiscriminatorMode.NONE) {
        }
        if (z) {
            AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializationStrategy;
            if (obj == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m("Value for serializer ", abstractPolymorphicSerializer.getDescriptor(), " should always be non-null. Please report issue to the kotlinx.serialization tracker.");
                return;
            }
            serializationStrategyFindPolymorphicSerializer = EntryPoints.findPolymorphicSerializer(abstractPolymorphicSerializer, this, obj);
        } else {
            serializationStrategyFindPolymorphicSerializer = serializationStrategy;
        }
        if (strClassDiscriminator != null) {
            WriteModeKt.checkEncodingConflicts(json, serializationStrategy, serializationStrategyFindPolymorphicSerializer, strClassDiscriminator);
            WriteModeKt.checkKind(serializationStrategyFindPolymorphicSerializer.getDescriptor().getKind());
            String serialName = serializationStrategyFindPolymorphicSerializer.getDescriptor().getSerialName();
            this.polymorphicDiscriminator = strClassDiscriminator;
            this.polymorphicSerialName = serialName;
        }
        serializationStrategyFindPolymorphicSerializer.serialize(this, obj);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short s) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) s));
        } else {
            this.composer.print(s);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeString(String str) {
        str.getClass();
        this.composer.printQuoted(str);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public final void endStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        FlagSet.Builder builder = this.composer;
        builder.unIndent();
        builder.nextItemIfNotFirst();
        builder.print(this.mode.end);
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public final Json getJson() {
        return this.json;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public final boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return this.configuration.encodeDefaults;
    }
}
