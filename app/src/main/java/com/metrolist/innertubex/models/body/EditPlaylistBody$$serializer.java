package com.metrolist.innertubex.models.body;

import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.Context$$serializer;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EditPlaylistBody$$serializer implements GeneratedSerializer {
    public static final EditPlaylistBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        EditPlaylistBody$$serializer editPlaylistBody$$serializer = new EditPlaylistBody$$serializer();
        INSTANCE = editPlaylistBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.EditPlaylistBody", editPlaylistBody$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("context", false);
        pluginGeneratedSerialDescriptor.addElement("playlistId", false);
        pluginGeneratedSerialDescriptor.addElement("actions", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Context$$serializer.INSTANCE, StringSerializer.INSTANCE, EditPlaylistBody.$childSerializers[2].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Context context;
        int i;
        String strDecodeStringElement;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = EditPlaylistBody.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, null);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            Context context2 = null;
            String strDecodeStringElement2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    context2 = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, context2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list2);
                    i2 |= 4;
                }
            }
            list = list2;
            context = context2;
            i = i2;
            strDecodeStringElement = strDecodeStringElement2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new EditPlaylistBody(i, context, strDecodeStringElement, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        EditPlaylistBody editPlaylistBody = (EditPlaylistBody) obj;
        editPlaylistBody.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = EditPlaylistBody.$childSerializers;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, editPlaylistBody.context);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, editPlaylistBody.playlistId);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), editPlaylistBody.actions);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
