package com.metrolist.innertube.models.response;

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
public final /* synthetic */ class AccountMenuResponse$Action$OpenPopupAction$Popup$$serializer implements GeneratedSerializer {
    public static final AccountMenuResponse$Action$OpenPopupAction$Popup$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AccountMenuResponse$Action$OpenPopupAction$Popup$$serializer accountMenuResponse$Action$OpenPopupAction$Popup$$serializer = new AccountMenuResponse$Action$OpenPopupAction$Popup$$serializer();
        INSTANCE = accountMenuResponse$Action$OpenPopupAction$Popup$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.AccountMenuResponse.Action.OpenPopupAction.Popup", accountMenuResponse$Action$OpenPopupAction$Popup$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("multiPageMenuRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        AccountMenuResponse.Action.OpenPopupAction.Popup.MultiPageMenuRenderer multiPageMenuRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            multiPageMenuRenderer = (AccountMenuResponse.Action.OpenPopupAction.Popup.MultiPageMenuRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            multiPageMenuRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    multiPageMenuRenderer = (AccountMenuResponse.Action.OpenPopupAction.Popup.MultiPageMenuRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$$serializer.INSTANCE, multiPageMenuRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AccountMenuResponse.Action.OpenPopupAction.Popup(i, multiPageMenuRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AccountMenuResponse.Action.OpenPopupAction.Popup popup = (AccountMenuResponse.Action.OpenPopupAction.Popup) obj;
        popup.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$$serializer.INSTANCE, popup.multiPageMenuRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
