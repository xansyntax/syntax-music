package com.metrolist.music.lyrics;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricLine$$serializer implements GeneratedSerializer {
    public static final LyricLine$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LyricLine$$serializer lyricLine$$serializer = new LyricLine$$serializer();
        INSTANCE = lyricLine$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.lyrics.LyricLine", lyricLine$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("time", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Text.TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("syllabus", true);
        pluginGeneratedSerialDescriptor.addElement("element", true);
        pluginGeneratedSerialDescriptor.addElement("translation", true);
        pluginGeneratedSerialDescriptor.addElement("transliteration", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer nullable = HexFormatKt.getNullable((KSerializer) LyricLine.$childSerializers[3].getValue());
        KSerializer nullable2 = HexFormatKt.getNullable(LineElement$$serializer.INSTANCE);
        KSerializer nullable3 = HexFormatKt.getNullable(Translation$$serializer.INSTANCE);
        KSerializer nullable4 = HexFormatKt.getNullable(Transliteration$$serializer.INSTANCE);
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{longSerializer, longSerializer, StringSerializer.INSTANCE, nullable, nullable2, nullable3, nullable4};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        String str;
        Transliteration transliteration;
        Translation translation;
        LineElement lineElement;
        int i;
        long j;
        long j2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricLine.$childSerializers;
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
            long jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            LineElement lineElement2 = (LineElement) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LineElement$$serializer.INSTANCE, null);
            Translation translation2 = (Translation) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, Translation$$serializer.INSTANCE, null);
            list = list2;
            str = strDecodeStringElement;
            transliteration = (Transliteration) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, Transliteration$$serializer.INSTANCE, null);
            translation = translation2;
            lineElement = lineElement2;
            i = 127;
            j = jDecodeLongElement2;
            j2 = jDecodeLongElement;
        } else {
            boolean z = true;
            int i2 = 0;
            List list3 = null;
            Translation translation3 = null;
            LineElement lineElement3 = null;
            long jDecodeLongElement3 = 0;
            long jDecodeLongElement4 = 0;
            String strDecodeStringElement2 = null;
            Transliteration transliteration2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        jDecodeLongElement4 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
                        i2 |= 1;
                        break;
                    case 1:
                        jDecodeLongElement3 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list3);
                        i2 |= 8;
                        break;
                    case 4:
                        lineElement3 = (LineElement) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LineElement$$serializer.INSTANCE, lineElement3);
                        i2 |= 16;
                        break;
                    case 5:
                        translation3 = (Translation) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, Translation$$serializer.INSTANCE, translation3);
                        i2 |= 32;
                        break;
                    case 6:
                        transliteration2 = (Transliteration) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, Transliteration$$serializer.INSTANCE, transliteration2);
                        i2 |= 64;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                }
                obj = null;
            }
            list = list3;
            str = strDecodeStringElement2;
            transliteration = transliteration2;
            translation = translation3;
            lineElement = lineElement3;
            i = i2;
            j = jDecodeLongElement3;
            j2 = jDecodeLongElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LyricLine(i, j2, j, str, list, lineElement, translation, transliteration);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        LyricLine lyricLine = (LyricLine) obj;
        lyricLine.getClass();
        Transliteration transliteration = lyricLine.transliteration;
        Translation translation = lyricLine.translation;
        LineElement lineElement = lyricLine.element;
        List list = lyricLine.syllabus;
        String str = lyricLine.text;
        long j = lyricLine.duration;
        long j2 = lyricLine.time;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricLine.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || j2 != 0) {
            compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 0, j2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || j != 0) {
            compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 1, j);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(str, "")) {
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || list != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, (SerializationStrategy) lazyArr[3].getValue(), list);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || lineElement != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, LineElement$$serializer.INSTANCE, lineElement);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || translation != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, Translation$$serializer.INSTANCE, translation);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || transliteration != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, Transliteration$$serializer.INSTANCE, transliteration);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
