package com.metrolist.innertubex.models.body;

import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.Context$$serializer;
import com.yalantis.ucrop.util.ImageHeaderParser;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerBody$$serializer implements GeneratedSerializer {
    public static final PlayerBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerBody$$serializer playerBody$$serializer = new PlayerBody$$serializer();
        INSTANCE = playerBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.PlayerBody", playerBody$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("context", false);
        pluginGeneratedSerialDescriptor.addElement("videoId", false);
        pluginGeneratedSerialDescriptor.addElement("playlistId", true);
        pluginGeneratedSerialDescriptor.addElement("playbackContext", true);
        pluginGeneratedSerialDescriptor.addElement("thirdParty", true);
        pluginGeneratedSerialDescriptor.addElement("serviceIntegrityDimensions", true);
        pluginGeneratedSerialDescriptor.addElement("contentCheckOk", false);
        pluginGeneratedSerialDescriptor.addElement("racyCheckOk", false);
        pluginGeneratedSerialDescriptor.addElement("videoCheckOk", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer nullable = HexFormatKt.getNullable(stringSerializer);
        KSerializer nullable2 = HexFormatKt.getNullable(PlayerBody$PlaybackContext$$serializer.INSTANCE);
        KSerializer nullable3 = HexFormatKt.getNullable(PlayerBody$ThirdParty$$serializer.INSTANCE);
        KSerializer nullable4 = HexFormatKt.getNullable(PlayerBody$ServiceIntegrityDimensions$$serializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{Context$$serializer.INSTANCE, stringSerializer, nullable, nullable2, nullable3, nullable4, booleanSerializer, booleanSerializer, HexFormatKt.getNullable(booleanSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Context context;
        String str;
        int i;
        PlayerBody.ThirdParty thirdParty;
        Boolean bool;
        PlayerBody.PlaybackContext playbackContext;
        boolean zDecodeBooleanElement;
        boolean z;
        PlayerBody.ServiceIntegrityDimensions serviceIntegrityDimensions;
        String str2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        char c = 3;
        PlayerBody.PlaybackContext playbackContext2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            PlayerBody.PlaybackContext playbackContext3 = (PlayerBody.PlaybackContext) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, PlayerBody$PlaybackContext$$serializer.INSTANCE, null);
            PlayerBody.ThirdParty thirdParty2 = (PlayerBody.ThirdParty) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, PlayerBody$ThirdParty$$serializer.INSTANCE, null);
            PlayerBody.ServiceIntegrityDimensions serviceIntegrityDimensions2 = (PlayerBody.ServiceIntegrityDimensions) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, PlayerBody$ServiceIntegrityDimensions$$serializer.INSTANCE, null);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 6);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 7);
            z = zDecodeBooleanElement2;
            serviceIntegrityDimensions = serviceIntegrityDimensions2;
            playbackContext = playbackContext3;
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, null);
            thirdParty = thirdParty2;
            str = str3;
            str2 = strDecodeStringElement;
            i = 511;
        } else {
            boolean z2 = true;
            int i5 = 0;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            context = null;
            PlayerBody.ThirdParty thirdParty3 = null;
            Boolean bool2 = null;
            PlayerBody.ServiceIntegrityDimensions serviceIntegrityDimensions3 = null;
            String str4 = null;
            String strDecodeStringElement2 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        i2 = 7;
                        i4 = 5;
                        c = 3;
                        break;
                    case 0:
                        context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, context);
                        i5 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        c = 3;
                        break;
                    case 1:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i5 |= 2;
                        i2 = 7;
                        i3 = 6;
                        c = 3;
                        break;
                    case 2:
                        i5 |= 4;
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str4);
                        i2 = 7;
                        i3 = 6;
                        c = 3;
                        break;
                    case 3:
                        playbackContext2 = (PlayerBody.PlaybackContext) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, PlayerBody$PlaybackContext$$serializer.INSTANCE, playbackContext2);
                        i5 |= 8;
                        c = 3;
                        i2 = 7;
                        break;
                    case 4:
                        thirdParty3 = (PlayerBody.ThirdParty) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, PlayerBody$ThirdParty$$serializer.INSTANCE, thirdParty3);
                        i5 |= 16;
                        c = 3;
                        break;
                    case 5:
                        serviceIntegrityDimensions3 = (PlayerBody.ServiceIntegrityDimensions) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, PlayerBody$ServiceIntegrityDimensions$$serializer.INSTANCE, serviceIntegrityDimensions3);
                        i5 |= 32;
                        c = 3;
                        break;
                    case 6:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i3);
                        i5 |= 64;
                        c = 3;
                        break;
                    case 7:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i2);
                        i5 |= 128;
                        c = 3;
                        break;
                    case 8:
                        bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, bool2);
                        i5 |= 256;
                        c = 3;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str4;
            i = i5;
            thirdParty = thirdParty3;
            bool = bool2;
            playbackContext = playbackContext2;
            zDecodeBooleanElement = zDecodeBooleanElement3;
            z = zDecodeBooleanElement4;
            serviceIntegrityDimensions = serviceIntegrityDimensions3;
            str2 = strDecodeStringElement2;
        }
        Context context2 = context;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerBody(i, context2, str2, str, playbackContext, thirdParty, serviceIntegrityDimensions, z, zDecodeBooleanElement, bool);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerBody playerBody = (PlayerBody) obj;
        playerBody.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Context$$serializer context$$serializer = Context$$serializer.INSTANCE;
        Context context = playerBody.context;
        Boolean bool = playerBody.videoCheckOk;
        PlayerBody.ServiceIntegrityDimensions serviceIntegrityDimensions = playerBody.serviceIntegrityDimensions;
        PlayerBody.ThirdParty thirdParty = playerBody.thirdParty;
        PlayerBody.PlaybackContext playbackContext = playerBody.playbackContext;
        String str = playerBody.playlistId;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, context$$serializer, context);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, playerBody.videoId);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || playbackContext != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, PlayerBody$PlaybackContext$$serializer.INSTANCE, playbackContext);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || thirdParty != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, PlayerBody$ThirdParty$$serializer.INSTANCE, thirdParty);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || serviceIntegrityDimensions != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, PlayerBody$ServiceIntegrityDimensions$$serializer.INSTANCE, serviceIntegrityDimensions);
        }
        compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 6, playerBody.contentCheckOk);
        compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 7, playerBody.racyCheckOk);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 8) || bool != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, bool);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
