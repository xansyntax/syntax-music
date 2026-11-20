package com.metrolist.innertube.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicMultiRowListItemRenderer$$serializer implements GeneratedSerializer {
    public static final MusicMultiRowListItemRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicMultiRowListItemRenderer$$serializer musicMultiRowListItemRenderer$$serializer = new MusicMultiRowListItemRenderer$$serializer();
        INSTANCE = musicMultiRowListItemRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicMultiRowListItemRenderer", musicMultiRowListItemRenderer$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", false);
        pluginGeneratedSerialDescriptor.addElement("secondSubtitle", true);
        pluginGeneratedSerialDescriptor.addElement("secondarySubtitle", true);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("onTap", false);
        pluginGeneratedSerialDescriptor.addElement("playbackProgress", false);
        pluginGeneratedSerialDescriptor.addElement("displayStyle", false);
        pluginGeneratedSerialDescriptor.addElement("menu", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(ThumbnailRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(NavigationEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(MusicMultiRowListItemRenderer$PlaybackProgress$$serializer.INSTANCE), HexFormatKt.getNullable(StringSerializer.INSTANCE), HexFormatKt.getNullable(Menu$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        Runs runs2;
        Runs runs3;
        Runs runs4;
        int i;
        Menu menu;
        ThumbnailRenderer thumbnailRenderer;
        String str;
        MusicMultiRowListItemRenderer.PlaybackProgress playbackProgress;
        NavigationEndpoint navigationEndpoint;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        int i5 = 3;
        char c = 2;
        ThumbnailRenderer thumbnailRenderer2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs5 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, runs$$serializer, null);
            Runs runs6 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            Runs runs7 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, null);
            runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, null);
            ThumbnailRenderer thumbnailRenderer3 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ThumbnailRenderer$$serializer.INSTANCE, null);
            NavigationEndpoint navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, NavigationEndpoint$$serializer.INSTANCE, null);
            MusicMultiRowListItemRenderer.PlaybackProgress playbackProgress2 = (MusicMultiRowListItemRenderer.PlaybackProgress) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, MusicMultiRowListItemRenderer$PlaybackProgress$$serializer.INSTANCE, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            playbackProgress = playbackProgress2;
            navigationEndpoint = navigationEndpoint2;
            thumbnailRenderer = thumbnailRenderer3;
            menu = (Menu) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, Menu$$serializer.INSTANCE, null);
            i = 511;
            runs2 = runs7;
            runs3 = runs6;
            runs4 = runs5;
        } else {
            boolean z = true;
            int i6 = 0;
            runs = null;
            Menu menu2 = null;
            String str2 = null;
            MusicMultiRowListItemRenderer.PlaybackProgress playbackProgress3 = null;
            NavigationEndpoint navigationEndpoint3 = null;
            Runs runs8 = null;
            Runs runs9 = null;
            Runs runs10 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        i5 = 3;
                        continue;
                    case 0:
                        runs10 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs10);
                        i6 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        i5 = 3;
                        break;
                    case 1:
                        runs9 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs9);
                        i6 |= 2;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        break;
                    case 2:
                        i6 |= 4;
                        runs8 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs8);
                        c = 2;
                        i2 = 7;
                        i3 = 6;
                        continue;
                    case 3:
                        runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, Runs$$serializer.INSTANCE, runs);
                        i6 |= 8;
                        break;
                    case 4:
                        thumbnailRenderer2 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer2);
                        i6 |= 16;
                        break;
                    case 5:
                        navigationEndpoint3 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint3);
                        i6 |= 32;
                        break;
                    case 6:
                        playbackProgress3 = (MusicMultiRowListItemRenderer.PlaybackProgress) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, MusicMultiRowListItemRenderer$PlaybackProgress$$serializer.INSTANCE, playbackProgress3);
                        i6 |= 64;
                        break;
                    case 7:
                        str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str2);
                        i6 |= 128;
                        break;
                    case 8:
                        menu2 = (Menu) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, Menu$$serializer.INSTANCE, menu2);
                        i6 |= 256;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                c = 2;
            }
            runs2 = runs8;
            runs3 = runs9;
            runs4 = runs10;
            i = i6;
            menu = menu2;
            thumbnailRenderer = thumbnailRenderer2;
            str = str2;
            playbackProgress = playbackProgress3;
            navigationEndpoint = navigationEndpoint3;
        }
        Runs runs11 = runs;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicMultiRowListItemRenderer(i, runs4, runs3, runs2, runs11, thumbnailRenderer, navigationEndpoint, playbackProgress, str, menu);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer = (MusicMultiRowListItemRenderer) obj;
        musicMultiRowListItemRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        Runs runs = musicMultiRowListItemRenderer.title;
        Runs runs2 = musicMultiRowListItemRenderer.secondarySubtitle;
        Runs runs3 = musicMultiRowListItemRenderer.secondSubtitle;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, runs$$serializer, runs);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, musicMultiRowListItemRenderer.subtitle);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || runs3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, runs3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || runs2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, runs2);
        }
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, ThumbnailRenderer$$serializer.INSTANCE, musicMultiRowListItemRenderer.thumbnail);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, NavigationEndpoint$$serializer.INSTANCE, musicMultiRowListItemRenderer.onTap);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, MusicMultiRowListItemRenderer$PlaybackProgress$$serializer.INSTANCE, musicMultiRowListItemRenderer.playbackProgress);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, musicMultiRowListItemRenderer.displayStyle);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, Menu$$serializer.INSTANCE, musicMultiRowListItemRenderer.menu);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
