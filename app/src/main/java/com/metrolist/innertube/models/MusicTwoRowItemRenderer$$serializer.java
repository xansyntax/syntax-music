package com.metrolist.innertube.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
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
public final /* synthetic */ class MusicTwoRowItemRenderer$$serializer implements GeneratedSerializer {
    public static final MusicTwoRowItemRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicTwoRowItemRenderer$$serializer musicTwoRowItemRenderer$$serializer = new MusicTwoRowItemRenderer$$serializer();
        INSTANCE = musicTwoRowItemRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicTwoRowItemRenderer", musicTwoRowItemRenderer$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", false);
        pluginGeneratedSerialDescriptor.addElement("subtitleBadges", false);
        pluginGeneratedSerialDescriptor.addElement("menu", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnailRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnailOverlay", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = MusicTwoRowItemRenderer.$childSerializers;
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{runs$$serializer, HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue()), HexFormatKt.getNullable(Menu$$serializer.INSTANCE), ThumbnailRenderer$$serializer.INSTANCE, NavigationEndpoint$$serializer.INSTANCE, HexFormatKt.getNullable(MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Runs runs;
        ThumbnailRenderer thumbnailRenderer;
        Runs runs2;
        MusicResponsiveListItemRenderer.Overlay overlay;
        NavigationEndpoint navigationEndpoint;
        Menu menu;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicTwoRowItemRenderer.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        boolean z = false;
        ThumbnailRenderer thumbnailRenderer2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs3 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, runs$$serializer, null);
            Runs runs4 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            Menu menu2 = (Menu) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Menu$$serializer.INSTANCE, null);
            ThumbnailRenderer thumbnailRenderer3 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, ThumbnailRenderer$$serializer.INSTANCE, null);
            NavigationEndpoint navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, NavigationEndpoint$$serializer.INSTANCE, null);
            list = list2;
            runs2 = runs4;
            overlay = (MusicResponsiveListItemRenderer.Overlay) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE, null);
            navigationEndpoint = navigationEndpoint2;
            menu = menu2;
            thumbnailRenderer = thumbnailRenderer3;
            i = 127;
            runs = runs3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            List list3 = null;
            Runs runs5 = null;
            MusicResponsiveListItemRenderer.Overlay overlay2 = null;
            NavigationEndpoint navigationEndpoint3 = null;
            Menu menu3 = null;
            Runs runs6 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = z;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 0:
                        runs6 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs6);
                        i4 |= 1;
                        z = false;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 1:
                        runs5 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs5);
                        i4 |= 2;
                        z = false;
                        break;
                    case 2:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list3);
                        i4 |= 4;
                        z = false;
                        break;
                    case 3:
                        menu3 = (Menu) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Menu$$serializer.INSTANCE, menu3);
                        i4 |= 8;
                        z = false;
                        break;
                    case 4:
                        thumbnailRenderer2 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer2);
                        i4 |= 16;
                        z = false;
                        break;
                    case 5:
                        navigationEndpoint3 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i3, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint3);
                        i4 |= 32;
                        z = false;
                        break;
                    case 6:
                        overlay2 = (MusicResponsiveListItemRenderer.Overlay) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE, overlay2);
                        i4 |= 64;
                        z = false;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list3;
            runs = runs6;
            thumbnailRenderer = thumbnailRenderer2;
            runs2 = runs5;
            overlay = overlay2;
            navigationEndpoint = navigationEndpoint3;
            menu = menu3;
            i = i4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicTwoRowItemRenderer(i, runs, runs2, list, menu, thumbnailRenderer, navigationEndpoint, overlay);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicTwoRowItemRenderer musicTwoRowItemRenderer = (MusicTwoRowItemRenderer) obj;
        musicTwoRowItemRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicTwoRowItemRenderer.$childSerializers;
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, runs$$serializer, musicTwoRowItemRenderer.title);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, musicTwoRowItemRenderer.subtitle);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), musicTwoRowItemRenderer.subtitleBadges);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, Menu$$serializer.INSTANCE, musicTwoRowItemRenderer.menu);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 4, ThumbnailRenderer$$serializer.INSTANCE, musicTwoRowItemRenderer.thumbnailRenderer);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 5, NavigationEndpoint$$serializer.INSTANCE, musicTwoRowItemRenderer.navigationEndpoint);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE, musicTwoRowItemRenderer.thumbnailOverlay);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
