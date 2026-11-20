package com.metrolist.innertube.models;

import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final /* synthetic */ class Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer implements GeneratedSerializer {
    public static final Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer = new Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer();
        INSTANCE = menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.Menu.MenuRenderer.Item.MenuNavigationItemRenderer", menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Text.TYPE, false);
        pluginGeneratedSerialDescriptor.addElement("icon", false);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Runs$$serializer.INSTANCE, Icon$$serializer.INSTANCE, NavigationEndpoint$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        NavigationEndpoint navigationEndpoint;
        Icon icon;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, null);
            icon = (Icon) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, Icon$$serializer.INSTANCE, null);
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            NavigationEndpoint navigationEndpoint2 = null;
            Icon icon2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    icon2 = (Icon) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, Icon$$serializer.INSTANCE, icon2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                    i2 |= 4;
                }
            }
            navigationEndpoint = navigationEndpoint2;
            icon = icon2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Menu.MenuRenderer.Item.MenuNavigationItemRenderer(i, runs, icon, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer = (Menu.MenuRenderer.Item.MenuNavigationItemRenderer) obj;
        menuNavigationItemRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, menuNavigationItemRenderer.text);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, Icon$$serializer.INSTANCE, menuNavigationItemRenderer.icon);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, menuNavigationItemRenderer.navigationEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
