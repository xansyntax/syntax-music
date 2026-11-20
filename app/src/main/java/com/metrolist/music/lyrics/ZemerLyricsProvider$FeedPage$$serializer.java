package com.metrolist.music.lyrics;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
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
public final /* synthetic */ class ZemerLyricsProvider$FeedPage$$serializer implements GeneratedSerializer {
    public static final ZemerLyricsProvider$FeedPage$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ZemerLyricsProvider$FeedPage$$serializer zemerLyricsProvider$FeedPage$$serializer = new ZemerLyricsProvider$FeedPage$$serializer();
        INSTANCE = zemerLyricsProvider$FeedPage$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.lyrics.ZemerLyricsProvider.FeedPage", zemerLyricsProvider$FeedPage$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("data", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{ZemerLyricsProvider.FeedPage.$childSerializers[0].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ZemerLyricsProvider.FeedPage.$childSerializers;
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                    i2 = 1;
                }
            }
            list = list2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ZemerLyricsProvider.FeedPage(i, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ZemerLyricsProvider.FeedPage feedPage = (ZemerLyricsProvider.FeedPage) obj;
        feedPage.getClass();
        List list = feedPage.data;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ZemerLyricsProvider.FeedPage.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, (SerializationStrategy) lazyArr[0].getValue(), list);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
