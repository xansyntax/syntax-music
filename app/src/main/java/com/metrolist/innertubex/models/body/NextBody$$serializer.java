package com.metrolist.innertubex.models.body;

import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.Context$$serializer;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NextBody$$serializer implements GeneratedSerializer {
    public static final NextBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NextBody$$serializer nextBody$$serializer = new NextBody$$serializer();
        INSTANCE = nextBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.NextBody", nextBody$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("context", false);
        pluginGeneratedSerialDescriptor.addElement("videoId", true);
        pluginGeneratedSerialDescriptor.addElement("playlistId", true);
        pluginGeneratedSerialDescriptor.addElement("playlistSetVideoId", true);
        pluginGeneratedSerialDescriptor.addElement("index", true);
        pluginGeneratedSerialDescriptor.addElement("params", true);
        pluginGeneratedSerialDescriptor.addElement("continuation", true);
        pluginGeneratedSerialDescriptor.addElement("contentCheckOk", true);
        pluginGeneratedSerialDescriptor.addElement("racyCheckOk", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer nullable = HexFormatKt.getNullable(stringSerializer);
        KSerializer nullable2 = HexFormatKt.getNullable(stringSerializer);
        KSerializer nullable3 = HexFormatKt.getNullable(stringSerializer);
        KSerializer nullable4 = HexFormatKt.getNullable(IntSerializer.INSTANCE);
        KSerializer nullable5 = HexFormatKt.getNullable(stringSerializer);
        KSerializer nullable6 = HexFormatKt.getNullable(stringSerializer);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{Context$$serializer.INSTANCE, nullable, nullable2, nullable3, nullable4, nullable5, nullable6, booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Context context;
        String str;
        int i;
        String str2;
        Integer num;
        String str3;
        boolean zDecodeBooleanElement;
        String str4;
        String str5;
        boolean zDecodeBooleanElement2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        String str6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 7);
            str4 = str11;
            str5 = str10;
            str3 = str9;
            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 8);
            num = num2;
            str2 = str8;
            str = str7;
            i = 511;
        } else {
            boolean z = true;
            int i5 = 0;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            context = null;
            String str12 = null;
            Integer num3 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i3 = 6;
                        i4 = 5;
                        break;
                    case 0:
                        context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, context);
                        i5 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        break;
                    case 1:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str15);
                        i5 |= 2;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        break;
                    case 2:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str12);
                        i5 |= 4;
                        i2 = 7;
                        i3 = 6;
                        break;
                    case 3:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str6);
                        i5 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num3);
                        i5 |= 16;
                        i2 = 7;
                        break;
                    case 5:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, StringSerializer.INSTANCE, str14);
                        i5 |= 32;
                        i2 = 7;
                        break;
                    case 6:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str13);
                        i5 |= 64;
                        i2 = 7;
                        break;
                    case 7:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i2);
                        i5 |= 128;
                        break;
                    case 8:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i5 |= 256;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str15;
            i = i5;
            str2 = str12;
            num = num3;
            str3 = str6;
            zDecodeBooleanElement = zDecodeBooleanElement3;
            str4 = str13;
            str5 = str14;
            zDecodeBooleanElement2 = zDecodeBooleanElement4;
        }
        Context context2 = context;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NextBody(i, context2, str, str2, str3, num, str5, str4, zDecodeBooleanElement, zDecodeBooleanElement2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        NextBody nextBody = (NextBody) obj;
        nextBody.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Context$$serializer context$$serializer = Context$$serializer.INSTANCE;
        Context context = nextBody.context;
        boolean z = nextBody.racyCheckOk;
        boolean z2 = nextBody.contentCheckOk;
        String str = nextBody.continuation;
        String str2 = nextBody.params;
        Integer num = nextBody.index;
        String str3 = nextBody.playlistSetVideoId;
        String str4 = nextBody.playlistId;
        String str5 = nextBody.videoId;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, context$$serializer, context);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str5 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str5);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || str4 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || !z2) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 7, z2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 8) || !z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 8, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
