package com.metrolist.innertubex.cipher;

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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GitHubPlayerConfigClient$NTransformConfig$$serializer implements GeneratedSerializer {
    public static final GitHubPlayerConfigClient$NTransformConfig$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GitHubPlayerConfigClient$NTransformConfig$$serializer gitHubPlayerConfigClient$NTransformConfig$$serializer = new GitHubPlayerConfigClient$NTransformConfig$$serializer();
        INSTANCE = gitHubPlayerConfigClient$NTransformConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.cipher.GitHubPlayerConfigClient.NTransformConfig", gitHubPlayerConfigClient$NTransformConfig$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Type, false);
        pluginGeneratedSerialDescriptor.addElement("preprocessedPlayerEncoding", true);
        pluginGeneratedSerialDescriptor.addElement("preprocessedPlayer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, HexFormatKt.getNullable(stringSerializer), stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        String str;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            strDecodeStringElement = null;
            String strDecodeStringElement3 = null;
            String str2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str2);
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
            strDecodeStringElement2 = strDecodeStringElement3;
            str = str2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GitHubPlayerConfigClient.NTransformConfig(i, strDecodeStringElement, str, strDecodeStringElement2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GitHubPlayerConfigClient.NTransformConfig nTransformConfig = (GitHubPlayerConfigClient.NTransformConfig) obj;
        nTransformConfig.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = nTransformConfig.type;
        String str2 = nTransformConfig.preprocessedPlayerEncoding;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str2);
        }
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, nTransformConfig.preprocessedPlayer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
