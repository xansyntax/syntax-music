package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer implements GeneratedSerializer {
    public static final Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer = new Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer();
        INSTANCE = menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.Menu.MenuRenderer.Item.ToggleMenuServiceRenderer", menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("defaultIcon", false);
        pluginGeneratedSerialDescriptor.addElement("defaultServiceEndpoint", false);
        pluginGeneratedSerialDescriptor.addElement("toggledServiceEndpoint", false);
        pluginGeneratedSerialDescriptor.addElement("isSelected", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Icon$$serializer.INSTANCE, DefaultServiceEndpoint$$serializer.INSTANCE, HexFormatKt.getNullable(ToggledServiceEndpoint$$serializer.INSTANCE), BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Icon icon;
        boolean zDecodeBooleanElement;
        ToggledServiceEndpoint toggledServiceEndpoint;
        DefaultServiceEndpoint defaultServiceEndpoint;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            icon = (Icon) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Icon$$serializer.INSTANCE, null);
            DefaultServiceEndpoint defaultServiceEndpoint2 = (DefaultServiceEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, DefaultServiceEndpoint$$serializer.INSTANCE, null);
            ToggledServiceEndpoint toggledServiceEndpoint2 = (ToggledServiceEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ToggledServiceEndpoint$$serializer.INSTANCE, null);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
            toggledServiceEndpoint = toggledServiceEndpoint2;
            defaultServiceEndpoint = defaultServiceEndpoint2;
            i = 15;
        } else {
            boolean z = true;
            boolean zDecodeBooleanElement2 = false;
            int i2 = 0;
            icon = null;
            ToggledServiceEndpoint toggledServiceEndpoint3 = null;
            DefaultServiceEndpoint defaultServiceEndpoint3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    icon = (Icon) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Icon$$serializer.INSTANCE, icon);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    defaultServiceEndpoint3 = (DefaultServiceEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, DefaultServiceEndpoint$$serializer.INSTANCE, defaultServiceEndpoint3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    toggledServiceEndpoint3 = (ToggledServiceEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ToggledServiceEndpoint$$serializer.INSTANCE, toggledServiceEndpoint3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            zDecodeBooleanElement = zDecodeBooleanElement2;
            toggledServiceEndpoint = toggledServiceEndpoint3;
            defaultServiceEndpoint = defaultServiceEndpoint3;
            i = i2;
        }
        Icon icon2 = icon;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Menu.MenuRenderer.Item.ToggleMenuServiceRenderer(i, icon2, defaultServiceEndpoint, toggledServiceEndpoint, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer = (Menu.MenuRenderer.Item.ToggleMenuServiceRenderer) obj;
        toggleMenuServiceRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Icon$$serializer icon$$serializer = Icon$$serializer.INSTANCE;
        Icon icon = toggleMenuServiceRenderer.defaultIcon;
        boolean z = toggleMenuServiceRenderer.isSelected;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, icon$$serializer, icon);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, DefaultServiceEndpoint$$serializer.INSTANCE, toggleMenuServiceRenderer.defaultServiceEndpoint);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, ToggledServiceEndpoint$$serializer.INSTANCE, toggleMenuServiceRenderer.toggledServiceEndpoint);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 3, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
