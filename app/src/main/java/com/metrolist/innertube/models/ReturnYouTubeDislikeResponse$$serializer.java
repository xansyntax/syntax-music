package com.metrolist.innertube.models;

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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ReturnYouTubeDislikeResponse$$serializer implements GeneratedSerializer {
    public static final ReturnYouTubeDislikeResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ReturnYouTubeDislikeResponse$$serializer returnYouTubeDislikeResponse$$serializer = new ReturnYouTubeDislikeResponse$$serializer();
        INSTANCE = returnYouTubeDislikeResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.ReturnYouTubeDislikeResponse", returnYouTubeDislikeResponse$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("dateCreated", true);
        pluginGeneratedSerialDescriptor.addElement("likes", true);
        pluginGeneratedSerialDescriptor.addElement("dislikes", true);
        pluginGeneratedSerialDescriptor.addElement("rating", true);
        pluginGeneratedSerialDescriptor.addElement("viewCount", true);
        pluginGeneratedSerialDescriptor.addElement("deleted", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer nullable = HexFormatKt.getNullable(stringSerializer);
        KSerializer nullable2 = HexFormatKt.getNullable(stringSerializer);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(DoubleSerializer.INSTANCE), HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        String str2;
        Boolean bool;
        Integer num;
        Integer num2;
        Double d;
        Integer num3;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 6;
        boolean z = false;
        String str3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, intSerializer, null);
            Integer num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, intSerializer, null);
            Double d2 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DoubleSerializer.INSTANCE, null);
            Integer num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, intSerializer, null);
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, null);
            num = num6;
            num2 = num5;
            d = d2;
            num3 = num4;
            i = 127;
            str2 = str4;
        } else {
            boolean z2 = true;
            int i3 = 0;
            str = null;
            Boolean bool2 = null;
            Integer num7 = null;
            Integer num8 = null;
            Double d3 = null;
            Integer num9 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = z;
                        i2 = 6;
                        break;
                    case 0:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str3);
                        i3 |= 1;
                        z = false;
                        i2 = 6;
                        break;
                    case 1:
                        str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str);
                        i3 |= 2;
                        z = false;
                        break;
                    case 2:
                        num9 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num9);
                        i3 |= 4;
                        z = false;
                        break;
                    case 3:
                        num8 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num8);
                        i3 |= 8;
                        z = false;
                        break;
                    case 4:
                        d3 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DoubleSerializer.INSTANCE, d3);
                        i3 |= 16;
                        z = false;
                        break;
                    case 5:
                        num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num7);
                        i3 |= 32;
                        z = false;
                        break;
                    case 6:
                        bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, BooleanSerializer.INSTANCE, bool2);
                        i3 |= 64;
                        z = false;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str2 = str3;
            bool = bool2;
            num = num7;
            num2 = num8;
            d = d3;
            num3 = num9;
            i = i3;
        }
        String str5 = str;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ReturnYouTubeDislikeResponse(i, str2, str5, num3, num2, d, num, bool);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ReturnYouTubeDislikeResponse returnYouTubeDislikeResponse = (ReturnYouTubeDislikeResponse) obj;
        returnYouTubeDislikeResponse.getClass();
        Boolean bool = returnYouTubeDislikeResponse.deleted;
        Integer num = returnYouTubeDislikeResponse.viewCount;
        Double d = returnYouTubeDislikeResponse.rating;
        Integer num2 = returnYouTubeDislikeResponse.dislikes;
        Integer num3 = returnYouTubeDislikeResponse.likes;
        String str = returnYouTubeDislikeResponse.dateCreated;
        String str2 = returnYouTubeDislikeResponse.id;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || num3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || num2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || d != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, DoubleSerializer.INSTANCE, d);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || bool != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, bool);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
