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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicDetailHeaderRenderer$$serializer implements GeneratedSerializer {
    public static final MusicDetailHeaderRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicDetailHeaderRenderer$$serializer musicDetailHeaderRenderer$$serializer = new MusicDetailHeaderRenderer$$serializer();
        INSTANCE = musicDetailHeaderRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicDetailHeaderRenderer", musicDetailHeaderRenderer$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", false);
        pluginGeneratedSerialDescriptor.addElement("secondSubtitle", false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("menu", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{runs$$serializer, runs$$serializer, runs$$serializer, HexFormatKt.getNullable(runs$$serializer), ThumbnailRenderer$$serializer.INSTANCE, Menu$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        Menu menu;
        ThumbnailRenderer thumbnailRenderer;
        int i;
        Runs runs2;
        Runs runs3;
        Runs runs4;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs5 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, runs$$serializer, null);
            Runs runs6 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            Runs runs7 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, runs$$serializer, null);
            runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, null);
            ThumbnailRenderer thumbnailRenderer2 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, ThumbnailRenderer$$serializer.INSTANCE, null);
            menu = (Menu) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, Menu$$serializer.INSTANCE, null);
            thumbnailRenderer = thumbnailRenderer2;
            i = 63;
            runs2 = runs7;
            runs3 = runs6;
            runs4 = runs5;
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            Menu menu2 = null;
            ThumbnailRenderer thumbnailRenderer3 = null;
            Runs runs8 = null;
            Runs runs9 = null;
            Runs runs10 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        runs10 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs10);
                        i2 |= 1;
                        break;
                    case 1:
                        runs9 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs9);
                        i2 |= 2;
                        break;
                    case 2:
                        runs8 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs8);
                        i2 |= 4;
                        break;
                    case 3:
                        runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, runs);
                        i2 |= 8;
                        break;
                    case 4:
                        thumbnailRenderer3 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer3);
                        i2 |= 16;
                        break;
                    case 5:
                        menu2 = (Menu) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, Menu$$serializer.INSTANCE, menu2);
                        i2 |= 32;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                }
                obj = null;
            }
            menu = menu2;
            thumbnailRenderer = thumbnailRenderer3;
            i = i2;
            runs2 = runs8;
            runs3 = runs9;
            runs4 = runs10;
        }
        Runs runs11 = runs;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicDetailHeaderRenderer(i, runs4, runs3, runs2, runs11, thumbnailRenderer, menu);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicDetailHeaderRenderer musicDetailHeaderRenderer = (MusicDetailHeaderRenderer) obj;
        musicDetailHeaderRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, runs$$serializer, musicDetailHeaderRenderer.title);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, runs$$serializer, musicDetailHeaderRenderer.subtitle);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, runs$$serializer, musicDetailHeaderRenderer.secondSubtitle);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, musicDetailHeaderRenderer.description);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 4, ThumbnailRenderer$$serializer.INSTANCE, musicDetailHeaderRenderer.thumbnail);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 5, Menu$$serializer.INSTANCE, musicDetailHeaderRenderer.menu);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
