package com.metrolist.innertube.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
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
public final /* synthetic */ class MusicResponsiveListItemRenderer$$serializer implements GeneratedSerializer {
    public static final MusicResponsiveListItemRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicResponsiveListItemRenderer$$serializer musicResponsiveListItemRenderer$$serializer = new MusicResponsiveListItemRenderer$$serializer();
        INSTANCE = musicResponsiveListItemRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicResponsiveListItemRenderer", musicResponsiveListItemRenderer$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("badges", false);
        pluginGeneratedSerialDescriptor.addElement("fixedColumns", false);
        pluginGeneratedSerialDescriptor.addElement("flexColumns", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("menu", false);
        pluginGeneratedSerialDescriptor.addElement("playlistItemData", false);
        pluginGeneratedSerialDescriptor.addElement("overlay", false);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = MusicResponsiveListItemRenderer.$childSerializers;
        return new KSerializer[]{HexFormatKt.getNullable((KSerializer) lazyArr[0].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[1].getValue()), lazyArr[2].getValue(), HexFormatKt.getNullable(ThumbnailRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(Menu$$serializer.INSTANCE), HexFormatKt.getNullable(MusicResponsiveListItemRenderer$PlaylistItemData$$serializer.INSTANCE), HexFormatKt.getNullable(MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE), HexFormatKt.getNullable(NavigationEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int i;
        List list;
        List list2;
        Menu menu;
        ThumbnailRenderer thumbnailRenderer;
        MusicResponsiveListItemRenderer.PlaylistItemData playlistItemData;
        List list3;
        NavigationEndpoint navigationEndpoint;
        MusicResponsiveListItemRenderer.Overlay overlay;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicResponsiveListItemRenderer.$childSerializers;
        int i2 = 7;
        int i3 = 6;
        char c = 3;
        MusicResponsiveListItemRenderer.PlaylistItemData playlistItemData2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            List list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            ThumbnailRenderer thumbnailRenderer2 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ThumbnailRenderer$$serializer.INSTANCE, null);
            Menu menu2 = (Menu) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Menu$$serializer.INSTANCE, null);
            MusicResponsiveListItemRenderer.PlaylistItemData playlistItemData3 = (MusicResponsiveListItemRenderer.PlaylistItemData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, MusicResponsiveListItemRenderer$PlaylistItemData$$serializer.INSTANCE, null);
            MusicResponsiveListItemRenderer.Overlay overlay2 = (MusicResponsiveListItemRenderer.Overlay) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE, null);
            i = 255;
            list = list6;
            list3 = list4;
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, NavigationEndpoint$$serializer.INSTANCE, null);
            overlay = overlay2;
            playlistItemData = playlistItemData3;
            thumbnailRenderer = thumbnailRenderer2;
            menu = menu2;
            list2 = list5;
        } else {
            int i4 = 2;
            int i5 = 1;
            boolean z = true;
            i = 0;
            List list7 = null;
            Menu menu3 = null;
            ThumbnailRenderer thumbnailRenderer3 = null;
            List list8 = null;
            NavigationEndpoint navigationEndpoint2 = null;
            MusicResponsiveListItemRenderer.Overlay overlay3 = null;
            List list9 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 7;
                        i3 = 6;
                        i5 = 1;
                        i4 = 2;
                        break;
                    case 0:
                        list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list8);
                        i |= 1;
                        i2 = 7;
                        i3 = 6;
                        c = 3;
                        i5 = 1;
                        i4 = 2;
                        break;
                    case 1:
                        list9 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr[i5].getValue(), list9);
                        i |= 2;
                        i2 = 7;
                        i3 = 6;
                        c = 3;
                        i4 = 2;
                        break;
                    case 2:
                        list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr[i4].getValue(), list7);
                        i |= 4;
                        i2 = 7;
                        c = 3;
                        break;
                    case 3:
                        thumbnailRenderer3 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer3);
                        i |= 8;
                        c = 3;
                        i2 = 7;
                        break;
                    case 4:
                        menu3 = (Menu) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Menu$$serializer.INSTANCE, menu3);
                        i |= 16;
                        c = 3;
                        break;
                    case 5:
                        playlistItemData2 = (MusicResponsiveListItemRenderer.PlaylistItemData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, MusicResponsiveListItemRenderer$PlaylistItemData$$serializer.INSTANCE, playlistItemData2);
                        i |= 32;
                        c = 3;
                        break;
                    case 6:
                        overlay3 = (MusicResponsiveListItemRenderer.Overlay) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE, overlay3);
                        i |= 64;
                        c = 3;
                        break;
                    case 7:
                        navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                        i |= 128;
                        c = 3;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list7;
            list2 = list9;
            menu = menu3;
            thumbnailRenderer = thumbnailRenderer3;
            playlistItemData = playlistItemData2;
            list3 = list8;
            navigationEndpoint = navigationEndpoint2;
            overlay = overlay3;
        }
        int i6 = i;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicResponsiveListItemRenderer(i6, list3, list2, list, thumbnailRenderer, menu, playlistItemData, overlay, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = (MusicResponsiveListItemRenderer) obj;
        musicResponsiveListItemRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicResponsiveListItemRenderer.$childSerializers;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, (SerializationStrategy) lazyArr[0].getValue(), musicResponsiveListItemRenderer.badges);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), musicResponsiveListItemRenderer.fixedColumns);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), musicResponsiveListItemRenderer.flexColumns);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, ThumbnailRenderer$$serializer.INSTANCE, musicResponsiveListItemRenderer.thumbnail);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, Menu$$serializer.INSTANCE, musicResponsiveListItemRenderer.menu);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, MusicResponsiveListItemRenderer$PlaylistItemData$$serializer.INSTANCE, musicResponsiveListItemRenderer.playlistItemData);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE, musicResponsiveListItemRenderer.overlay);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, NavigationEndpoint$$serializer.INSTANCE, musicResponsiveListItemRenderer.navigationEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
