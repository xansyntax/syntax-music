package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicNavigationButtonRenderer$$serializer implements GeneratedSerializer {
    public static final MusicNavigationButtonRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicNavigationButtonRenderer$$serializer musicNavigationButtonRenderer$$serializer = new MusicNavigationButtonRenderer$$serializer();
        INSTANCE = musicNavigationButtonRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicNavigationButtonRenderer", musicNavigationButtonRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("buttonText", false);
        pluginGeneratedSerialDescriptor.addElement("solid", false);
        pluginGeneratedSerialDescriptor.addElement("iconStyle", false);
        pluginGeneratedSerialDescriptor.addElement("clickCommand", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Runs$$serializer.INSTANCE, HexFormatKt.getNullable(MusicNavigationButtonRenderer$Solid$$serializer.INSTANCE), HexFormatKt.getNullable(MusicNavigationButtonRenderer$IconStyle$$serializer.INSTANCE), NavigationEndpoint$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        NavigationEndpoint navigationEndpoint;
        MusicNavigationButtonRenderer.IconStyle iconStyle;
        MusicNavigationButtonRenderer.Solid solid;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, null);
            MusicNavigationButtonRenderer.Solid solid2 = (MusicNavigationButtonRenderer.Solid) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicNavigationButtonRenderer$Solid$$serializer.INSTANCE, null);
            MusicNavigationButtonRenderer.IconStyle iconStyle2 = (MusicNavigationButtonRenderer.IconStyle) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicNavigationButtonRenderer$IconStyle$$serializer.INSTANCE, null);
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, NavigationEndpoint$$serializer.INSTANCE, null);
            iconStyle = iconStyle2;
            solid = solid2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            NavigationEndpoint navigationEndpoint2 = null;
            MusicNavigationButtonRenderer.IconStyle iconStyle3 = null;
            MusicNavigationButtonRenderer.Solid solid3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    solid3 = (MusicNavigationButtonRenderer.Solid) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicNavigationButtonRenderer$Solid$$serializer.INSTANCE, solid3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    iconStyle3 = (MusicNavigationButtonRenderer.IconStyle) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicNavigationButtonRenderer$IconStyle$$serializer.INSTANCE, iconStyle3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                    i2 |= 8;
                }
            }
            navigationEndpoint = navigationEndpoint2;
            iconStyle = iconStyle3;
            solid = solid3;
            i = i2;
        }
        Runs runs2 = runs;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicNavigationButtonRenderer(i, runs2, solid, iconStyle, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicNavigationButtonRenderer musicNavigationButtonRenderer = (MusicNavigationButtonRenderer) obj;
        musicNavigationButtonRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, musicNavigationButtonRenderer.buttonText);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicNavigationButtonRenderer$Solid$$serializer.INSTANCE, musicNavigationButtonRenderer.solid);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, MusicNavigationButtonRenderer$IconStyle$$serializer.INSTANCE, musicNavigationButtonRenderer.iconStyle);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, NavigationEndpoint$$serializer.INSTANCE, musicNavigationButtonRenderer.clickCommand);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
