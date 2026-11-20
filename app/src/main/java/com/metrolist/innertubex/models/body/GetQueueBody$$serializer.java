package com.metrolist.innertubex.models.body;

import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.Context$$serializer;
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
public final /* synthetic */ class GetQueueBody$$serializer implements GeneratedSerializer {
    public static final GetQueueBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GetQueueBody$$serializer getQueueBody$$serializer = new GetQueueBody$$serializer();
        INSTANCE = getQueueBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.GetQueueBody", getQueueBody$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("context", false);
        pluginGeneratedSerialDescriptor.addElement("videoIds", false);
        pluginGeneratedSerialDescriptor.addElement("playlistId", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Context$$serializer.INSTANCE, HexFormatKt.getNullable((KSerializer) GetQueueBody.$childSerializers[1].getValue()), HexFormatKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Context context;
        String str;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = GetQueueBody.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            Context context2 = null;
            String str2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    context2 = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, context2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str2);
                    i2 |= 4;
                }
            }
            list = list2;
            context = context2;
            str = str2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GetQueueBody(i, context, str, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GetQueueBody getQueueBody = (GetQueueBody) obj;
        getQueueBody.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = GetQueueBody.$childSerializers;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, getQueueBody.context);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), getQueueBody.videoIds);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, getQueueBody.playlistId);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
