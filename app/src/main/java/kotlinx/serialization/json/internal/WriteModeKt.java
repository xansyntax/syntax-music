package kotlinx.serialization.json.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.descriptors.SerialKind$ENUM;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonEncodingException;
import kotlinx.serialization.json.JsonIgnoreUnknownKeys;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WriteModeKt {
    public static final JsonPath.Tombstone JsonDeserializationNamesKey = new JsonPath.Tombstone();

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number number, String str) {
        return new JsonEncodingException(nonFiniteFpMessage(number, str), "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'");
    }

    public static final JsonEncodingException InvalidKeyKindException(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        String str = "Value of type '" + serialDescriptor.getSerialName() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + serialDescriptor.getKind() + '\'';
        serialDescriptor.getSerialName();
        return new JsonEncodingException(str, "Use 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final ReaderJsonLexer ReaderJsonLexer(Json json, InternalJsonReader internalJsonReader, char[] cArr) {
        json.getClass();
        return new ReaderJsonLexer(internalJsonReader, cArr, json.configuration);
    }

    public static final StringJsonLexer StringJsonLexer(Json json, String str) {
        json.getClass();
        str.getClass();
        return new StringJsonLexer(str, json.configuration);
    }

    public static final SerialDescriptor carrierDescriptor(SerialDescriptor serialDescriptor, SerializersModule serializersModule) {
        serialDescriptor.getClass();
        serializersModule.getClass();
        if (!Intrinsics.areEqual(serialDescriptor.getKind(), SerialKind$CONTEXTUAL.INSTANCE)) {
            return serialDescriptor.isInline() ? carrierDescriptor(serialDescriptor.getElementDescriptor(0), serializersModule) : serialDescriptor;
        }
        KClass capturedKClass = RegexKt.getCapturedKClass(serialDescriptor);
        if (capturedKClass == null) {
            return serialDescriptor;
        }
        SerializersModule.getContextual$default(serializersModule, capturedKClass);
        return serialDescriptor;
    }

    public static final byte charToTokenClass(char c) {
        if (c < '~') {
            return CharMappings.CHAR_TO_TOKEN[c];
        }
        return (byte) 0;
    }

    public static final void checkEncodingConflicts(Json json, SerializationStrategy serializationStrategy, SerializationStrategy serializationStrategy2, String str) {
        SerialDescriptor descriptor = serializationStrategy2.getDescriptor();
        descriptor.getClass();
        json.getClass();
        namingStrategy(descriptor, json);
        if (EnumsKt.cachedSerialNames(descriptor).contains(str)) {
            String serialName = serializationStrategy.getDescriptor().getSerialName();
            String serialName2 = serializationStrategy2.getDescriptor().getSerialName();
            throw new JsonEncodingException(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Class '", serialName2, "' cannot be serialized ", (json.configuration.classDiscriminatorMode == ClassDiscriminatorMode.ALL_JSON_OBJECTS && Intrinsics.areEqual(serialName, serialName2)) ? "in ALL_JSON_OBJECTS class discriminator mode" : Format$$ExternalSyntheticOutline0.m('\'', "as base class '", serialName), " because it has property name that conflicts with JSON class discriminator '"), str, "'."), "You can either change class discriminator in JsonConfiguration, or rename property with @SerialName annotation.");
        }
    }

    public static final void checkKind(Okio__OkioKt okio__OkioKt) {
        okio__OkioKt.getClass();
        if (okio__OkioKt instanceof SerialKind$ENUM) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        } else if (okio__OkioKt instanceof PrimitiveKind$INT) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        } else if (okio__OkioKt instanceof PolymorphicKind$OPEN) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    public static final String classDiscriminator(SerialDescriptor serialDescriptor, Json json) {
        serialDescriptor.getClass();
        json.getClass();
        for (Annotation annotation : serialDescriptor.getAnnotations()) {
            if (annotation instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator) annotation).discriminator();
            }
        }
        return json.configuration.classDiscriminator;
    }

    public static final void encodeByWriter(Json json, InternalJsonWriter internalJsonWriter, SerializationStrategy serializationStrategy, Object obj) {
        json.getClass();
        serializationStrategy.getClass();
        new StreamingJsonEncoder(json.configuration.prettyPrint ? new ComposerWithPrettyPrint(internalJsonWriter, json) : new FlagSet.Builder(internalJsonWriter), json, WriteMode.OBJ, new JsonEncoder[WriteMode.$ENTRIES.getSize()]).encodeSerializableValue(serializationStrategy, obj);
    }

    public static final String formatDecodingException(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (i >= 0) {
            sb.append("Unexpected JSON token at offset " + i + ": ");
        }
        sb.append(str);
        if (str2 != null && !StringsKt.isBlank(str2)) {
            sb.append(" at path: ");
            sb.append(str2);
        }
        if (str3 != null && !StringsKt.isBlank(str3)) {
            sb.append("\n".concat(str3));
        }
        if (str4 != null) {
            sb.append("\nJSON input: ");
            sb.append(str4);
        }
        return sb.toString();
    }

    public static final int getJsonNameIndex(SerialDescriptor serialDescriptor, Json json, String str) {
        serialDescriptor.getClass();
        json.getClass();
        str.getClass();
        namingStrategy(serialDescriptor, json);
        int elementIndex = serialDescriptor.getElementIndex(str);
        if (elementIndex != -3 || !json.configuration.useAlternativeNames) {
            return elementIndex;
        }
        ConnectionPool connectionPool = json._schemaCache;
        Url$$ExternalSyntheticLambda1 url$$ExternalSyntheticLambda1 = new Url$$ExternalSyntheticLambda1(serialDescriptor, json, (byte) 6);
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) connectionPool.delegate;
        Map map = (Map) concurrentHashMap.get(serialDescriptor);
        JsonPath.Tombstone tombstone = JsonDeserializationNamesKey;
        Object obj = map != null ? map.get(tombstone) : null;
        Object objInvoke = obj != null ? obj : null;
        if (objInvoke == null) {
            objInvoke = url$$ExternalSyntheticLambda1.invoke();
            Object concurrentHashMap2 = concurrentHashMap.get(serialDescriptor);
            if (concurrentHashMap2 == null) {
                concurrentHashMap2 = new ConcurrentHashMap(2);
                concurrentHashMap.put(serialDescriptor, concurrentHashMap2);
            }
            ((Map) concurrentHashMap2).put(tombstone, objInvoke);
        }
        Integer num = (Integer) ((Map) objInvoke).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int getJsonNameIndexOrThrow(SerialDescriptor serialDescriptor, Json json, String str, String str2) {
        serialDescriptor.getClass();
        json.getClass();
        str.getClass();
        int jsonNameIndex = getJsonNameIndex(serialDescriptor, json, str);
        if (jsonNameIndex != -3) {
            return jsonNameIndex;
        }
        throw new SerializationException(serialDescriptor.getSerialName() + " does not contain element with name '" + str + '\'' + str2);
    }

    public static final boolean ignoreUnknownKeys(SerialDescriptor serialDescriptor, Json json) {
        serialDescriptor.getClass();
        json.getClass();
        if (json.configuration.ignoreUnknownKeys) {
            return true;
        }
        List annotations = serialDescriptor.getAnnotations();
        if (annotations != null && annotations.isEmpty()) {
            return false;
        }
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            if (((Annotation) it.next()) instanceof JsonIgnoreUnknownKeys) {
                return true;
            }
        }
        return false;
    }

    public static final void invalidTrailingComma(AbstractJsonLexer abstractJsonLexer, String str) {
        abstractJsonLexer.fail(abstractJsonLexer.currentPosition - 1, "Trailing comma before the end of JSON ".concat(str), "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingComma = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static final CharSequence minify(CharSequence charSequence, int i) {
        charSequence.getClass();
        if (charSequence.length() >= 200) {
            if (i != -1) {
                int i2 = i - 30;
                int i3 = i + 30;
                String str = i2 <= 0 ? "" : ".....";
                String str2 = i3 >= charSequence.length() ? "" : ".....";
                StringBuilder sb = new StringBuilder(str);
                if (i2 < 0) {
                    i2 = 0;
                }
                int length = charSequence.length();
                if (i3 > length) {
                    i3 = length;
                }
                sb.append(charSequence.subSequence(i2, i3).toString());
                sb.append(str2);
                return sb.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static final void namingStrategy(SerialDescriptor serialDescriptor, Json json) {
        serialDescriptor.getClass();
        json.getClass();
        Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind$MAP.INSTANCE$1);
    }

    public static final String nonFiniteFpMessage(Number number, String str) {
        StringBuilder sb = new StringBuilder("Unexpected special floating-point value ");
        sb.append(number);
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, str != null ? IntIntPair$$ExternalSyntheticOutline0.m(" with key ", str, ". ") : ". ", "By default, non-finite floating point values are prohibited because they do not conform JSON specification.");
    }

    public static final Object readPolymorphicJson(Json json, String str, JsonObject jsonObject, DeserializationStrategy deserializationStrategy) {
        json.getClass();
        str.getClass();
        return new JsonTreeDecoder(json, jsonObject, str, deserializationStrategy.getDescriptor()).decodeSerializableValue(deserializationStrategy);
    }

    public static final WriteMode switchMode(SerialDescriptor serialDescriptor, Json json) {
        json.getClass();
        serialDescriptor.getClass();
        Okio__OkioKt kind = serialDescriptor.getKind();
        if (kind instanceof PolymorphicKind$OPEN) {
            return WriteMode.POLY_OBJ;
        }
        boolean zAreEqual = Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$2);
        WriteMode writeMode = WriteMode.LIST;
        if (zAreEqual) {
            return writeMode;
        }
        if (!Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE)) {
            return WriteMode.OBJ;
        }
        SerialDescriptor serialDescriptorCarrierDescriptor = carrierDescriptor(serialDescriptor.getElementDescriptor(0), json.serializersModule);
        Okio__OkioKt kind2 = serialDescriptorCarrierDescriptor.getKind();
        if ((kind2 instanceof PrimitiveKind$INT) || Intrinsics.areEqual(kind2, SerialKind$ENUM.INSTANCE)) {
            return WriteMode.MAP;
        }
        if (json.configuration.allowStructuredMapKeys) {
            return writeMode;
        }
        throw InvalidKeyKindException(serialDescriptorCarrierDescriptor);
    }

    public static final String tokenDescription(byte b) {
        if (b == 1) {
            return "quotation mark '\"'";
        }
        if (b == 2) {
            return "string escape sequence '\\'";
        }
        if (b == 4) {
            return "comma ','";
        }
        if (b == 5) {
            return "colon ':'";
        }
        if (b == 6) {
            return "start of the object '{'";
        }
        if (b == 7) {
            return "end of the object '}'";
        }
        if (b == 8) {
            return "start of the array '['";
        }
        if (b == 9) {
            return "end of the array ']'";
        }
        if (b == 10) {
            return "end of the input";
        }
        return b == 127 ? "invalid token" : "valid token";
    }
}
