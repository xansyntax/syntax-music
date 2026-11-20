package com.metrolist.music.eq.data;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GitHubAutoEqSearch$GitHubTreeResponse$$serializer implements GeneratedSerializer {
    public static final GitHubAutoEqSearch$GitHubTreeResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GitHubAutoEqSearch$GitHubTreeResponse$$serializer gitHubAutoEqSearch$GitHubTreeResponse$$serializer = new GitHubAutoEqSearch$GitHubTreeResponse$$serializer();
        INSTANCE = gitHubAutoEqSearch$GitHubTreeResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.eq.data.GitHubAutoEqSearch.GitHubTreeResponse", gitHubAutoEqSearch$GitHubTreeResponse$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("sha", false);
        pluginGeneratedSerialDescriptor.addElement("tree", false);
        pluginGeneratedSerialDescriptor.addElement("truncated", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, GitHubAutoEqSearch$GitHubTreeResponse.$childSerializers[1].getValue(), BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        String strDecodeStringElement;
        boolean zDecodeBooleanElement;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = GitHubAutoEqSearch$GitHubTreeResponse.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
            i = 7;
        } else {
            boolean z = true;
            boolean zDecodeBooleanElement2 = false;
            int i2 = 0;
            List list2 = null;
            String strDecodeStringElement2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
                    i2 |= 4;
                }
            }
            list = list2;
            strDecodeStringElement = strDecodeStringElement2;
            zDecodeBooleanElement = zDecodeBooleanElement2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GitHubAutoEqSearch$GitHubTreeResponse(i, strDecodeStringElement, list, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GitHubAutoEqSearch$GitHubTreeResponse gitHubAutoEqSearch$GitHubTreeResponse = (GitHubAutoEqSearch$GitHubTreeResponse) obj;
        gitHubAutoEqSearch$GitHubTreeResponse.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = GitHubAutoEqSearch$GitHubTreeResponse.$childSerializers;
        String str = gitHubAutoEqSearch$GitHubTreeResponse.sha;
        boolean z = gitHubAutoEqSearch$GitHubTreeResponse.truncated;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), gitHubAutoEqSearch$GitHubTreeResponse.tree);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 2, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
