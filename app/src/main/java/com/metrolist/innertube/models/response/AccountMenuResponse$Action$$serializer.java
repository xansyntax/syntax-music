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
public final /* synthetic */ class AccountMenuResponse$Action$$serializer implements GeneratedSerializer {
    public static final AccountMenuResponse$Action$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AccountMenuResponse$Action$$serializer accountMenuResponse$Action$$serializer = new AccountMenuResponse$Action$$serializer();
        INSTANCE = accountMenuResponse$Action$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.AccountMenuResponse.Action", accountMenuResponse$Action$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("openPopupAction", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{AccountMenuResponse$Action$OpenPopupAction$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        AccountMenuResponse.Action.OpenPopupAction openPopupAction;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            openPopupAction = (AccountMenuResponse.Action.OpenPopupAction) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, AccountMenuResponse$Action$OpenPopupAction$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            openPopupAction = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    openPopupAction = (AccountMenuResponse.Action.OpenPopupAction) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, AccountMenuResponse$Action$OpenPopupAction$$serializer.INSTANCE, openPopupAction);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AccountMenuResponse.Action(i, openPopupAction);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AccountMenuResponse.Action action = (AccountMenuResponse.Action) obj;
        action.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, AccountMenuResponse$Action$OpenPopupAction$$serializer.INSTANCE, action.openPopupAction);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
