package com.metrolist.innertubex.models.body;

import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.Context$$serializer;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CreatePlaylistBody$$serializer implements GeneratedSerializer {
    public static final CreatePlaylistBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CreatePlaylistBody$$serializer createPlaylistBody$$serializer = new CreatePlaylistBody$$serializer();
        INSTANCE = createPlaylistBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.CreatePlaylistBody", createPlaylistBody$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("context", false);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("privacyStatus", false);
        pluginGeneratedSerialDescriptor.addElement("videoIds", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer nullable = HexFormatKt.getNullable((KSerializer) CreatePlaylistBody.$childSerializers[3].getValue());
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{Context$$serializer.INSTANCE, stringSerializer, stringSerializer, nullable};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Context context;
        String str;
        int i;
        String str2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = CreatePlaylistBody.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Context context2 = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            context = context2;
            str = strDecodeStringElement2;
            i = 15;
            str2 = strDecodeStringElement;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            Context context3 = null;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    context3 = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, context3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list2);
                    i2 |= 8;
                }
            }
            list = list2;
            context = context3;
            str = strDecodeStringElement3;
            i = i2;
            str2 = strDecodeStringElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CreatePlaylistBody(i, context, str2, str, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        CreatePlaylistBody createPlaylistBody = (CreatePlaylistBody) obj;
        createPlaylistBody.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = CreatePlaylistBody.$childSerializers;
        Context$$serializer context$$serializer = Context$$serializer.INSTANCE;
        Context context = createPlaylistBody.context;
        List list = createPlaylistBody.videoIds;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, context$$serializer, context);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, createPlaylistBody.title);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, createPlaylistBody.privacyStatus);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || list != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, (SerializationStrategy) lazyArr[3].getValue(), list);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
