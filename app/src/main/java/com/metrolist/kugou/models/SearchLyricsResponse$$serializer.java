package com.metrolist.kugou.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SearchLyricsResponse$$serializer implements GeneratedSerializer {
    public static final SearchLyricsResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SearchLyricsResponse$$serializer searchLyricsResponse$$serializer = new SearchLyricsResponse$$serializer();
        INSTANCE = searchLyricsResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.kugou.models.SearchLyricsResponse", searchLyricsResponse$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("status", false);
        pluginGeneratedSerialDescriptor.addElement("info", false);
        pluginGeneratedSerialDescriptor.addElement("errcode", false);
        pluginGeneratedSerialDescriptor.addElement("errmsg", false);
        pluginGeneratedSerialDescriptor.addElement("expire", false);
        pluginGeneratedSerialDescriptor.addElement("candidates", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = SearchLyricsResponse.$childSerializers;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, stringSerializer, intSerializer, stringSerializer, intSerializer, lazyArr[5].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        String str2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SearchLyricsResponse.$childSerializers;
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            int iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 4);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            i = iDecodeIntElement;
            str = strDecodeStringElement2;
            i2 = iDecodeIntElement3;
            i3 = iDecodeIntElement2;
            i4 = 63;
            str2 = strDecodeStringElement;
        } else {
            boolean z = true;
            int iDecodeIntElement4 = 0;
            int iDecodeIntElement5 = 0;
            int iDecodeIntElement6 = 0;
            int i5 = 0;
            List list2 = null;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                        i5 |= 1;
                        break;
                    case 1:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i5 |= 2;
                        break;
                    case 2:
                        iDecodeIntElement6 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
                        i5 |= 4;
                        break;
                    case 3:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i5 |= 8;
                        break;
                    case 4:
                        iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 4);
                        i5 |= 16;
                        break;
                    case 5:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list2);
                        i5 |= 32;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                }
                obj = null;
            }
            list = list2;
            i = iDecodeIntElement4;
            str = strDecodeStringElement3;
            i2 = iDecodeIntElement5;
            i3 = iDecodeIntElement6;
            i4 = i5;
            str2 = strDecodeStringElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SearchLyricsResponse(i4, i, str2, i3, str, i2, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SearchLyricsResponse searchLyricsResponse = (SearchLyricsResponse) obj;
        searchLyricsResponse.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SearchLyricsResponse.$childSerializers;
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, searchLyricsResponse.status);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, searchLyricsResponse.info);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 2, searchLyricsResponse.errcode);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, searchLyricsResponse.errmsg);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 4, searchLyricsResponse.expire);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 5, (SerializationStrategy) lazyArr[5].getValue(), searchLyricsResponse.candidates);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
