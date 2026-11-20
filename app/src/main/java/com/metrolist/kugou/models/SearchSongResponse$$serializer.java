package com.metrolist.kugou.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlinx.serialization.KSerializer;
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
public final /* synthetic */ class SearchSongResponse$$serializer implements GeneratedSerializer {
    public static final SearchSongResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SearchSongResponse$$serializer searchSongResponse$$serializer = new SearchSongResponse$$serializer();
        INSTANCE = searchSongResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.kugou.models.SearchSongResponse", searchSongResponse$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("status", false);
        pluginGeneratedSerialDescriptor.addElement("errcode", false);
        pluginGeneratedSerialDescriptor.addElement("error", false);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, intSerializer, StringSerializer.INSTANCE, SearchSongResponse$Data$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int iDecodeIntElement;
        SearchSongResponse.Data data;
        String str;
        int i;
        int i2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            data = (SearchSongResponse.Data) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, SearchSongResponse$Data$$serializer.INSTANCE, null);
            str = strDecodeStringElement;
            i = iDecodeIntElement2;
            i2 = 15;
        } else {
            boolean z = true;
            iDecodeIntElement = 0;
            int iDecodeIntElement3 = 0;
            int i3 = 0;
            SearchSongResponse.Data data2 = null;
            String strDecodeStringElement2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                    i3 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
                    i3 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                    i3 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    data2 = (SearchSongResponse.Data) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, SearchSongResponse$Data$$serializer.INSTANCE, data2);
                    i3 |= 8;
                }
            }
            data = data2;
            str = strDecodeStringElement2;
            i = iDecodeIntElement3;
            i2 = i3;
        }
        int i4 = iDecodeIntElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SearchSongResponse(i2, i4, i, str, data);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SearchSongResponse searchSongResponse = (SearchSongResponse) obj;
        searchSongResponse.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, searchSongResponse.status);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 1, searchSongResponse.errcode);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, searchSongResponse.error);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, SearchSongResponse$Data$$serializer.INSTANCE, searchSongResponse.data);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
