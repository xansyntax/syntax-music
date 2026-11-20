package io.ktor.openapi;

import coil3.network.HttpException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000e0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u00020\u0019H\u0096\u0080\u0004¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lio/ktor/openapi/GenericElementString;", "Lio/ktor/openapi/GenericElement;", "", "element", "Lkotlinx/serialization/KSerializer;", "elementSerializer", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;)V", "T", "Lkotlinx/serialization/DeserializationStrategy;", "serializer", "deserialize", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "", "Lkotlin/Pair;", "entries", "()Ljava/util/List;", "items", "", "isString", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getElement", "()Ljava/lang/String;", "Lkotlinx/serialization/KSerializer;", "getElementSerializer", "()Lkotlinx/serialization/KSerializer;", "StringDecoder", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementString implements GenericElement {
    private final String element;
    private final KSerializer elementSerializer;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u000eH\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u00020\u0014H\u0096\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0018\u0010\nJ\u0011\u0010\u001a\u001a\u00020\u0019H\u0096\u0080\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\bH\u0096\u0080\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001f\u001a\u00020\u001eH\u0096\u0080\u0004¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010\"\u001a\u00020!H\u0096\u0080\u0004¢\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001a\u00020$H\u0096\u0080\u0004¢\u0006\u0004\b%\u0010&R\u001b\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lio/ktor/openapi/GenericElementString$StringDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "(Lio/ktor/openapi/GenericElementString;Lkotlinx/serialization/modules/SerializersModule;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "", "decodeBoolean", "()Z", "", "decodeByte", "()B", "", "decodeChar", "()C", "", "decodeDouble", "()D", "enumDescriptor", "decodeEnum", "", "decodeFloat", "()F", "decodeInt", "()I", "", "decodeLong", "()J", "", "decodeShort", "()S", "", "decodeString", "()Ljava/lang/String;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class StringDecoder extends AbstractDecoder {
        private final SerializersModule serializersModule;
        final /* synthetic */ GenericElementString this$0;

        public StringDecoder(GenericElementString genericElementString, SerializersModule serializersModule) {
            serializersModule.getClass();
            this.this$0 = genericElementString;
            this.serializersModule = serializersModule;
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public boolean decodeBoolean() {
            String element = this.this$0.getElement();
            element.getClass();
            if (element.equals("true")) {
                return true;
            }
            if (element.equals("false")) {
                return false;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The string doesn't represent a boolean value: ".concat(element));
            return false;
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public byte decodeByte() {
            return Byte.parseByte(this.this$0.getElement());
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public char decodeChar() {
            String element = this.this$0.getElement();
            element.getClass();
            Character chValueOf = element.length() == 1 ? Character.valueOf(element.charAt(0)) : null;
            if (chValueOf != null) {
                return chValueOf.charValue();
            }
            GenericElementKt.serialError("Cannot decode char from string '" + this.this$0.getElement() + '\'');
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return (char) 0;
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public double decodeDouble() {
            return Double.parseDouble(this.this$0.getElement());
        }

        @Override // kotlinx.serialization.encoding.CompositeDecoder
        public int decodeElementIndex(SerialDescriptor descriptor) {
            descriptor.getClass();
            GenericElementKt.serialError("Cannot decode element index for string");
            throw new HttpException();
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public int decodeEnum(SerialDescriptor enumDescriptor) {
            enumDescriptor.getClass();
            return enumDescriptor.getElementIndex(this.this$0.getElement());
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public float decodeFloat() {
            return Float.parseFloat(this.this$0.getElement());
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public int decodeInt() {
            return Integer.parseInt(this.this$0.getElement());
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public long decodeLong() {
            return Long.parseLong(this.this$0.getElement());
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public short decodeShort() {
            return Short.parseShort(this.this$0.getElement());
        }

        @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
        public String decodeString() {
            return this.this$0.getElement();
        }

        @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
        public SerializersModule getSerializersModule() {
            return this.serializersModule;
        }
    }

    public GenericElementString(String str, KSerializer kSerializer) {
        str.getClass();
        kSerializer.getClass();
        this.element = str;
        this.elementSerializer = kSerializer;
    }

    @Override // io.ktor.openapi.GenericElement
    public <T> T deserialize(DeserializationStrategy serializer) {
        serializer.getClass();
        return (T) serializer.deserialize(new StringDecoder(this, Json.Default.serializersModule));
    }

    @Override // io.ktor.openapi.GenericElement
    public List<Pair> entries() {
        GenericElementKt.serialError("Cannot get entries for a string");
        throw new HttpException();
    }

    public boolean equals(Object other) {
        return (other instanceof GenericElementString) && Intrinsics.areEqual(getElement(), ((GenericElementString) other).getElement());
    }

    @Override // io.ktor.openapi.GenericElement
    public KSerializer getElementSerializer() {
        return this.elementSerializer;
    }

    public int hashCode() {
        return getElement().hashCode();
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ boolean isArray() {
        return super.isArray();
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ boolean isObject() {
        return super.isObject();
    }

    @Override // io.ktor.openapi.GenericElement
    public boolean isString() {
        return true;
    }

    @Override // io.ktor.openapi.GenericElement
    public List<GenericElement> items() {
        GenericElementKt.serialError("Cannot get items for a string");
        throw new HttpException();
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ GenericElement plus(GenericElement genericElement) {
        return super.plus(genericElement);
    }

    @Override // io.ktor.openapi.GenericElement
    public String getElement() {
        return this.element;
    }

    public GenericElementString(String str, KSerializer kSerializer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? StringSerializer.INSTANCE : kSerializer);
    }
}
