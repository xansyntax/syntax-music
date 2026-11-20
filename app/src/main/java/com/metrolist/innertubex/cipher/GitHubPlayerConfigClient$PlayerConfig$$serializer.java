package com.metrolist.innertubex.cipher;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GitHubPlayerConfigClient$PlayerConfig$$serializer implements GeneratedSerializer {
    public static final GitHubPlayerConfigClient$PlayerConfig$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GitHubPlayerConfigClient$PlayerConfig$$serializer gitHubPlayerConfigClient$PlayerConfig$$serializer = new GitHubPlayerConfigClient$PlayerConfig$$serializer();
        INSTANCE = gitHubPlayerConfigClient$PlayerConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.cipher.GitHubPlayerConfigClient.PlayerConfig", gitHubPlayerConfigClient$PlayerConfig$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("schemaVersion", true);
        pluginGeneratedSerialDescriptor.addElement("playerHash", false);
        pluginGeneratedSerialDescriptor.addElement("nTransform", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, StringSerializer.INSTANCE, HexFormatKt.getNullable(GitHubPlayerConfigClient$NTransformConfig$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int iDecodeIntElement;
        GitHubPlayerConfigClient.NTransformConfig nTransformConfig;
        String strDecodeStringElement;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            nTransformConfig = (GitHubPlayerConfigClient.NTransformConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, GitHubPlayerConfigClient$NTransformConfig$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            iDecodeIntElement = 0;
            int i2 = 0;
            GitHubPlayerConfigClient.NTransformConfig nTransformConfig2 = null;
            String strDecodeStringElement2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    nTransformConfig2 = (GitHubPlayerConfigClient.NTransformConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, GitHubPlayerConfigClient$NTransformConfig$$serializer.INSTANCE, nTransformConfig2);
                    i2 |= 4;
                }
            }
            nTransformConfig = nTransformConfig2;
            strDecodeStringElement = strDecodeStringElement2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GitHubPlayerConfigClient.PlayerConfig(i, iDecodeIntElement, strDecodeStringElement, nTransformConfig);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GitHubPlayerConfigClient.PlayerConfig playerConfig = (GitHubPlayerConfigClient.PlayerConfig) obj;
        playerConfig.getClass();
        int i = playerConfig.schemaVersion;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || i != 0) {
            compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, i);
        }
        String str = playerConfig.playerHash;
        GitHubPlayerConfigClient.NTransformConfig nTransformConfig = playerConfig.nTransform;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, str);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || nTransformConfig != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, GitHubPlayerConfigClient$NTransformConfig$$serializer.INSTANCE, nTransformConfig);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
