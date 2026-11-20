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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlaylistPanelRenderer$$serializer implements GeneratedSerializer {
    public static final PlaylistPanelRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlaylistPanelRenderer$$serializer playlistPanelRenderer$$serializer = new PlaylistPanelRenderer$$serializer();
        INSTANCE = playlistPanelRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.PlaylistPanelRenderer", playlistPanelRenderer$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("titleText", false);
        pluginGeneratedSerialDescriptor.addElement("shortBylineText", false);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("isInfinite", false);
        pluginGeneratedSerialDescriptor.addElement("numItemsToShow", false);
        pluginGeneratedSerialDescriptor.addElement("playlistId", false);
        pluginGeneratedSerialDescriptor.addElement("continuations", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = PlaylistPanelRenderer.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), lazyArr[3].getValue(), HexFormatKt.getNullable(BooleanSerializer.INSTANCE), HexFormatKt.getNullable(IntSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable((KSerializer) lazyArr[7].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Runs runs;
        String str;
        List list2;
        Runs runs2;
        Boolean bool;
        String str2;
        int i;
        Integer num;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = PlaylistPanelRenderer.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        int i4 = 4;
        char c = 2;
        Boolean bool2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs3 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            Runs runs4 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BooleanSerializer.INSTANCE, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, null);
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), null);
            str2 = str4;
            i = 255;
            num = num2;
            bool = bool3;
            runs2 = runs4;
            list2 = list3;
            runs = runs3;
            str = str3;
        } else {
            boolean z = true;
            int i5 = 0;
            List list4 = null;
            List list5 = null;
            Runs runs5 = null;
            String str5 = null;
            Integer num3 = null;
            Runs runs6 = null;
            String str6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 6;
                        i3 = 5;
                        i4 = 4;
                        continue;
                    case 0:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str6);
                        i5 |= 1;
                        i2 = 6;
                        i3 = 5;
                        i4 = 4;
                        break;
                    case 1:
                        runs6 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs6);
                        i5 |= 2;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 2:
                        runs5 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs5);
                        i5 |= 4;
                        c = 2;
                        i2 = 6;
                        continue;
                    case 3:
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list5);
                        i5 |= 8;
                        break;
                    case 4:
                        bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, BooleanSerializer.INSTANCE, bool2);
                        i5 |= 16;
                        break;
                    case 5:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, IntSerializer.INSTANCE, num3);
                        i5 |= 32;
                        break;
                    case 6:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str5);
                        i5 |= 64;
                        break;
                    case 7:
                        list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), list4);
                        i5 |= 128;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                c = 2;
            }
            list = list4;
            runs = runs6;
            str = str6;
            list2 = list5;
            runs2 = runs5;
            bool = bool2;
            str2 = str5;
            i = i5;
            num = num3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlaylistPanelRenderer(i, str, runs, runs2, list2, bool, num, str2, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlaylistPanelRenderer playlistPanelRenderer = (PlaylistPanelRenderer) obj;
        playlistPanelRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = PlaylistPanelRenderer.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, playlistPanelRenderer.title);
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, playlistPanelRenderer.titleText);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, playlistPanelRenderer.shortBylineText);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, (SerializationStrategy) lazyArr[3].getValue(), playlistPanelRenderer.contents);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, BooleanSerializer.INSTANCE, playlistPanelRenderer.isInfinite);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, playlistPanelRenderer.numItemsToShow);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, playlistPanelRenderer.playlistId);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, (SerializationStrategy) lazyArr[7].getValue(), playlistPanelRenderer.continuations);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
