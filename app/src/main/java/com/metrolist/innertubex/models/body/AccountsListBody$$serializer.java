package com.metrolist.innertubex.models.body;

import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.Context$$serializer;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.internal.Intrinsics;
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
public final /* synthetic */ class AccountsListBody$$serializer implements GeneratedSerializer {
    public static final AccountsListBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AccountsListBody$$serializer accountsListBody$$serializer = new AccountsListBody$$serializer();
        INSTANCE = accountsListBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.AccountsListBody", accountsListBody$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("context", false);
        pluginGeneratedSerialDescriptor.addElement("requestType", true);
        pluginGeneratedSerialDescriptor.addElement("callCircumstance", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{Context$$serializer.INSTANCE, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Context context;
        String strDecodeStringElement;
        String strDecodeStringElement2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, null);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            context = null;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, context);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                    i2 |= 4;
                }
            }
            strDecodeStringElement = strDecodeStringElement3;
            strDecodeStringElement2 = strDecodeStringElement4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AccountsListBody(i, context, strDecodeStringElement2, strDecodeStringElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AccountsListBody accountsListBody = (AccountsListBody) obj;
        accountsListBody.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Context$$serializer context$$serializer = Context$$serializer.INSTANCE;
        Context context = accountsListBody.context;
        String str = accountsListBody.callCircumstance;
        String str2 = accountsListBody.requestType;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, context$$serializer, context);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual(str2, "ACCOUNTS_LIST_REQUEST_TYPE_CHANNEL_SWITCHER")) {
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(str, "SWITCHING_USERS_FULL")) {
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, str);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
