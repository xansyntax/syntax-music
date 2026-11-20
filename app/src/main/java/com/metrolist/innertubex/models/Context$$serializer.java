package com.metrolist.innertubex.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.internal.Intrinsics;
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
public final /* synthetic */ class Context$$serializer implements GeneratedSerializer {
    public static final Context$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Context$$serializer context$$serializer = new Context$$serializer();
        INSTANCE = context$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.Context", context$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("client", false);
        pluginGeneratedSerialDescriptor.addElement("thirdParty", true);
        pluginGeneratedSerialDescriptor.addElement("request", true);
        pluginGeneratedSerialDescriptor.addElement("user", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Context$Client$$serializer.INSTANCE, HexFormatKt.getNullable(Context$ThirdParty$$serializer.INSTANCE), Context$Request$$serializer.INSTANCE, Context$User$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Context.Client client;
        Context.User user;
        Context.Request request;
        Context.ThirdParty thirdParty;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            client = (Context.Client) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$Client$$serializer.INSTANCE, null);
            Context.ThirdParty thirdParty2 = (Context.ThirdParty) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Context$ThirdParty$$serializer.INSTANCE, null);
            Context.Request request2 = (Context.Request) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, Context$Request$$serializer.INSTANCE, null);
            user = (Context.User) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, Context$User$$serializer.INSTANCE, null);
            request = request2;
            thirdParty = thirdParty2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            client = null;
            Context.User user2 = null;
            Context.Request request3 = null;
            Context.ThirdParty thirdParty3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    client = (Context.Client) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$Client$$serializer.INSTANCE, client);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    thirdParty3 = (Context.ThirdParty) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Context$ThirdParty$$serializer.INSTANCE, thirdParty3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    request3 = (Context.Request) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, Context$Request$$serializer.INSTANCE, request3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    user2 = (Context.User) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, Context$User$$serializer.INSTANCE, user2);
                    i2 |= 8;
                }
            }
            user = user2;
            request = request3;
            thirdParty = thirdParty3;
            i = i2;
        }
        Context.Client client2 = client;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Context(i, client2, thirdParty, request, user);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Context context = (Context) obj;
        context.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Context$Client$$serializer context$Client$$serializer = Context$Client$$serializer.INSTANCE;
        Context.Client client = context.client;
        Context.User user = context.user;
        Context.Request request = context.request;
        Context.ThirdParty thirdParty = context.thirdParty;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, context$Client$$serializer, client);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || thirdParty != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, Context$ThirdParty$$serializer.INSTANCE, thirdParty);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(request, new Context.Request())) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, Context$Request$$serializer.INSTANCE, request);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || !Intrinsics.areEqual(user, new Context.User(null, 3))) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, Context$User$$serializer.INSTANCE, user);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
