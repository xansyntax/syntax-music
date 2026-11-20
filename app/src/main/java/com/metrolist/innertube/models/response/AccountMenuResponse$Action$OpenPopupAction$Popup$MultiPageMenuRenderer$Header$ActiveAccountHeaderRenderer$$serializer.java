package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.Runs$$serializer;
import com.metrolist.innertube.models.Thumbnails;
import com.metrolist.innertube.models.Thumbnails$$serializer;
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
public final /* synthetic */ class AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$$serializer implements GeneratedSerializer {
    public static final AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$$serializer accountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$$serializer = new AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$$serializer();
        INSTANCE = accountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.AccountMenuResponse.Action.OpenPopupAction.Popup.MultiPageMenuRenderer.Header.ActiveAccountHeaderRenderer", accountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("accountName", false);
        pluginGeneratedSerialDescriptor.addElement("email", false);
        pluginGeneratedSerialDescriptor.addElement("channelHandle", false);
        pluginGeneratedSerialDescriptor.addElement("accountPhoto", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{runs$$serializer, HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), Thumbnails$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        Thumbnails thumbnails;
        int i;
        Runs runs2;
        Runs runs3;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs4 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, runs$$serializer, null);
            Runs runs5 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, null);
            thumbnails = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, Thumbnails$$serializer.INSTANCE, null);
            i = 15;
            runs2 = runs5;
            runs3 = runs4;
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            Thumbnails thumbnails2 = null;
            Runs runs6 = null;
            Runs runs7 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    runs7 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs7);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    runs6 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs6);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    thumbnails2 = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, Thumbnails$$serializer.INSTANCE, thumbnails2);
                    i2 |= 8;
                }
            }
            thumbnails = thumbnails2;
            i = i2;
            runs2 = runs6;
            runs3 = runs7;
        }
        Runs runs8 = runs;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AccountMenuResponse.Action.OpenPopupAction.Popup.MultiPageMenuRenderer.Header.ActiveAccountHeaderRenderer(i, runs3, runs2, runs8, thumbnails);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AccountMenuResponse.Action.OpenPopupAction.Popup.MultiPageMenuRenderer.Header.ActiveAccountHeaderRenderer activeAccountHeaderRenderer = (AccountMenuResponse.Action.OpenPopupAction.Popup.MultiPageMenuRenderer.Header.ActiveAccountHeaderRenderer) obj;
        activeAccountHeaderRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, runs$$serializer, activeAccountHeaderRenderer.accountName);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, activeAccountHeaderRenderer.email);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, activeAccountHeaderRenderer.channelHandle);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, Thumbnails$$serializer.INSTANCE, activeAccountHeaderRenderer.accountPhoto);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
