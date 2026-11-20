package com.metrolist.music.db.entities;

import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CachedAlbum$$serializer implements GeneratedSerializer {
    public static final CachedAlbum$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CachedAlbum$$serializer cachedAlbum$$serializer = new CachedAlbum$$serializer();
        INSTANCE = cachedAlbum$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.db.entities.CachedAlbum", cachedAlbum$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Name, false);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            i = 3;
        } else {
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            boolean z = true;
            int i2 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                }
            }
            strDecodeStringElement = strDecodeStringElement3;
            strDecodeStringElement2 = strDecodeStringElement4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CachedAlbum(i, strDecodeStringElement, strDecodeStringElement2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        CachedAlbum cachedAlbum = (CachedAlbum) obj;
        cachedAlbum.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, cachedAlbum.name);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, cachedAlbum.id);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
