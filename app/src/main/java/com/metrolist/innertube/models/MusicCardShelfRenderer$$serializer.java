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
public final /* synthetic */ class MusicCardShelfRenderer$$serializer implements GeneratedSerializer {
    public static final MusicCardShelfRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicCardShelfRenderer$$serializer musicCardShelfRenderer$$serializer = new MusicCardShelfRenderer$$serializer();
        INSTANCE = musicCardShelfRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicCardShelfRenderer", musicCardShelfRenderer$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("header", false);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("buttons", false);
        pluginGeneratedSerialDescriptor.addElement("onTap", false);
        pluginGeneratedSerialDescriptor.addElement("subtitleBadges", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = MusicCardShelfRenderer.$childSerializers;
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{runs$$serializer, runs$$serializer, ThumbnailRenderer$$serializer.INSTANCE, HexFormatKt.getNullable(MusicCardShelfRenderer$Header$$serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[4].getValue()), lazyArr[5].getValue(), NavigationEndpoint$$serializer.INSTANCE, HexFormatKt.getNullable((KSerializer) lazyArr[7].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Runs runs;
        List list2;
        List list3;
        int i;
        ThumbnailRenderer thumbnailRenderer;
        Runs runs2;
        NavigationEndpoint navigationEndpoint;
        MusicCardShelfRenderer.Header header;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicCardShelfRenderer.$childSerializers;
        int i2 = 6;
        char c = 3;
        int i3 = 7;
        int i4 = 0;
        ThumbnailRenderer thumbnailRenderer2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs3 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, runs$$serializer, null);
            Runs runs4 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            ThumbnailRenderer thumbnailRenderer3 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, null);
            MusicCardShelfRenderer.Header header2 = (MusicCardShelfRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, MusicCardShelfRenderer$Header$$serializer.INSTANCE, null);
            List list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            List list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            NavigationEndpoint navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, NavigationEndpoint$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), null);
            runs2 = runs4;
            navigationEndpoint = navigationEndpoint2;
            header = header2;
            thumbnailRenderer = thumbnailRenderer3;
            i = 255;
            list3 = list5;
            list2 = list4;
            runs = runs3;
        } else {
            boolean z = true;
            List list6 = null;
            List list7 = null;
            List list8 = null;
            Runs runs5 = null;
            NavigationEndpoint navigationEndpoint3 = null;
            MusicCardShelfRenderer.Header header3 = null;
            Runs runs6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 6;
                        i3 = 7;
                        break;
                    case 0:
                        runs6 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs6);
                        i4 |= 1;
                        i2 = 6;
                        c = 3;
                        i3 = 7;
                        break;
                    case 1:
                        runs5 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs5);
                        i4 |= 2;
                        i2 = 6;
                        c = 3;
                        break;
                    case 2:
                        thumbnailRenderer2 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer2);
                        i4 |= 4;
                        i2 = 6;
                        c = 3;
                        break;
                    case 3:
                        header3 = (MusicCardShelfRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, MusicCardShelfRenderer$Header$$serializer.INSTANCE, header3);
                        i4 |= 8;
                        c = 3;
                        i2 = 6;
                        break;
                    case 4:
                        list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list7);
                        i4 |= 16;
                        c = 3;
                        break;
                    case 5:
                        list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list8);
                        i4 |= 32;
                        c = 3;
                        break;
                    case 6:
                        navigationEndpoint3 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i2, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint3);
                        i4 |= 64;
                        c = 3;
                        break;
                    case 7:
                        list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, (DeserializationStrategy) lazyArr[i3].getValue(), list6);
                        i4 |= 128;
                        c = 3;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list6;
            runs = runs6;
            list2 = list7;
            list3 = list8;
            i = i4;
            thumbnailRenderer = thumbnailRenderer2;
            runs2 = runs5;
            navigationEndpoint = navigationEndpoint3;
            header = header3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicCardShelfRenderer(i, runs, runs2, thumbnailRenderer, header, list2, list3, navigationEndpoint, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicCardShelfRenderer musicCardShelfRenderer = (MusicCardShelfRenderer) obj;
        musicCardShelfRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicCardShelfRenderer.$childSerializers;
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, runs$$serializer, musicCardShelfRenderer.title);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, runs$$serializer, musicCardShelfRenderer.subtitle);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, musicCardShelfRenderer.thumbnail);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, MusicCardShelfRenderer$Header$$serializer.INSTANCE, musicCardShelfRenderer.header);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, (SerializationStrategy) lazyArr[4].getValue(), musicCardShelfRenderer.contents);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 5, (SerializationStrategy) lazyArr[5].getValue(), musicCardShelfRenderer.buttons);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 6, NavigationEndpoint$$serializer.INSTANCE, musicCardShelfRenderer.onTap);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, (SerializationStrategy) lazyArr[7].getValue(), musicCardShelfRenderer.subtitleBadges);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
