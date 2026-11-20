package com.metrolist.innertube.models;

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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicShelfRenderer$$serializer implements GeneratedSerializer {
    public static final MusicShelfRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicShelfRenderer$$serializer musicShelfRenderer$$serializer = new MusicShelfRenderer$$serializer();
        INSTANCE = musicShelfRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicShelfRenderer", musicShelfRenderer$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("continuations", false);
        pluginGeneratedSerialDescriptor.addElement("bottomEndpoint", false);
        pluginGeneratedSerialDescriptor.addElement("moreContentButton", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = MusicShelfRenderer.$childSerializers;
        return new KSerializer[]{HexFormatKt.getNullable(Runs$$serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[1].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue()), HexFormatKt.getNullable(NavigationEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(Button$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Runs runs;
        NavigationEndpoint navigationEndpoint;
        Button button;
        int i;
        List list2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicShelfRenderer.$childSerializers;
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs runs2 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            runs = runs2;
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, NavigationEndpoint$$serializer.INSTANCE, null);
            button = (Button) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Button$$serializer.INSTANCE, null);
            i = 31;
            list2 = list3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list4 = null;
            Runs runs3 = null;
            NavigationEndpoint navigationEndpoint2 = null;
            Button button2 = null;
            List list5 = null;
            while (z) {
                obj = obj;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    runs3 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list5);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list4);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                    }
                    button2 = (Button) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Button$$serializer.INSTANCE, button2);
                    i2 |= 16;
                }
            }
            list = list4;
            runs = runs3;
            navigationEndpoint = navigationEndpoint2;
            button = button2;
            i = i2;
            list2 = list5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicShelfRenderer(i, runs, list2, list, navigationEndpoint, button);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicShelfRenderer musicShelfRenderer = (MusicShelfRenderer) obj;
        musicShelfRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicShelfRenderer.$childSerializers;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, musicShelfRenderer.title);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), musicShelfRenderer.contents);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), musicShelfRenderer.continuations);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, NavigationEndpoint$$serializer.INSTANCE, musicShelfRenderer.bottomEndpoint);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, Button$$serializer.INSTANCE, musicShelfRenderer.moreContentButton);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
