package com.metrolist.innertubex.models.body;

import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.Context$$serializer;
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
public final /* synthetic */ class AccountMenuBody$$serializer implements GeneratedSerializer {
    public static final AccountMenuBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AccountMenuBody$$serializer accountMenuBody$$serializer = new AccountMenuBody$$serializer();
        INSTANCE = accountMenuBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.AccountMenuBody", accountMenuBody$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("context", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Context$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Context context;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            context = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    context = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, context);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AccountMenuBody(i, context);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AccountMenuBody accountMenuBody = (AccountMenuBody) obj;
        accountMenuBody.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, accountMenuBody.context);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
