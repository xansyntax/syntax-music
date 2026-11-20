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
public final /* synthetic */ class Menu$MenuRenderer$Item$$serializer implements GeneratedSerializer {
    public static final Menu$MenuRenderer$Item$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Menu$MenuRenderer$Item$$serializer menu$MenuRenderer$Item$$serializer = new Menu$MenuRenderer$Item$$serializer();
        INSTANCE = menu$MenuRenderer$Item$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.Menu.MenuRenderer.Item", menu$MenuRenderer$Item$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("menuNavigationItemRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("menuServiceItemRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("toggleMenuServiceItemRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(Menu$MenuRenderer$Item$MenuServiceItemRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
        Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer;
        Menu.MenuRenderer.Item.MenuServiceItemRenderer menuServiceItemRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            menuNavigationItemRenderer = (Menu.MenuRenderer.Item.MenuNavigationItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer.INSTANCE, null);
            menuServiceItemRenderer = (Menu.MenuRenderer.Item.MenuServiceItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Menu$MenuRenderer$Item$MenuServiceItemRenderer$$serializer.INSTANCE, null);
            toggleMenuServiceRenderer = (Menu.MenuRenderer.Item.ToggleMenuServiceRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            menuNavigationItemRenderer = null;
            Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer2 = null;
            Menu.MenuRenderer.Item.MenuServiceItemRenderer menuServiceItemRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    menuNavigationItemRenderer = (Menu.MenuRenderer.Item.MenuNavigationItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer.INSTANCE, menuNavigationItemRenderer);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    menuServiceItemRenderer2 = (Menu.MenuRenderer.Item.MenuServiceItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Menu$MenuRenderer$Item$MenuServiceItemRenderer$$serializer.INSTANCE, menuServiceItemRenderer2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    toggleMenuServiceRenderer2 = (Menu.MenuRenderer.Item.ToggleMenuServiceRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer.INSTANCE, toggleMenuServiceRenderer2);
                    i2 |= 4;
                }
            }
            toggleMenuServiceRenderer = toggleMenuServiceRenderer2;
            menuServiceItemRenderer = menuServiceItemRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Menu.MenuRenderer.Item(i, menuNavigationItemRenderer, menuServiceItemRenderer, toggleMenuServiceRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) obj;
        item.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer.INSTANCE, item.menuNavigationItemRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, Menu$MenuRenderer$Item$MenuServiceItemRenderer$$serializer.INSTANCE, item.menuServiceItemRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer.INSTANCE, item.toggleMenuServiceItemRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
