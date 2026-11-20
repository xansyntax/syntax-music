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
public final /* synthetic */ class MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer implements GeneratedSerializer {
    public static final MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer musicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer = new MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer();
        INSTANCE = musicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer", musicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("defaultIcon", true);
        pluginGeneratedSerialDescriptor.addElement("defaultServiceEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("toggledServiceEndpoint", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(Icon$$serializer.INSTANCE), HexFormatKt.getNullable(DefaultServiceEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(ToggledServiceEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Icon icon;
        ToggledServiceEndpoint toggledServiceEndpoint;
        DefaultServiceEndpoint defaultServiceEndpoint;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            icon = (Icon) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Icon$$serializer.INSTANCE, null);
            defaultServiceEndpoint = (DefaultServiceEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, DefaultServiceEndpoint$$serializer.INSTANCE, null);
            toggledServiceEndpoint = (ToggledServiceEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ToggledServiceEndpoint$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            icon = null;
            ToggledServiceEndpoint toggledServiceEndpoint2 = null;
            DefaultServiceEndpoint defaultServiceEndpoint2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    icon = (Icon) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Icon$$serializer.INSTANCE, icon);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    defaultServiceEndpoint2 = (DefaultServiceEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, DefaultServiceEndpoint$$serializer.INSTANCE, defaultServiceEndpoint2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    toggledServiceEndpoint2 = (ToggledServiceEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ToggledServiceEndpoint$$serializer.INSTANCE, toggledServiceEndpoint2);
                    i2 |= 4;
                }
            }
            toggledServiceEndpoint = toggledServiceEndpoint2;
            defaultServiceEndpoint = defaultServiceEndpoint2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer(i, icon, defaultServiceEndpoint, toggledServiceEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer toggleButtonRenderer = (MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer) obj;
        toggleButtonRenderer.getClass();
        ToggledServiceEndpoint toggledServiceEndpoint = toggleButtonRenderer.toggledServiceEndpoint;
        DefaultServiceEndpoint defaultServiceEndpoint = toggleButtonRenderer.defaultServiceEndpoint;
        Icon icon = toggleButtonRenderer.defaultIcon;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || icon != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, Icon$$serializer.INSTANCE, icon);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || defaultServiceEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, DefaultServiceEndpoint$$serializer.INSTANCE, defaultServiceEndpoint);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || toggledServiceEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, ToggledServiceEndpoint$$serializer.INSTANCE, toggledServiceEndpoint);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
