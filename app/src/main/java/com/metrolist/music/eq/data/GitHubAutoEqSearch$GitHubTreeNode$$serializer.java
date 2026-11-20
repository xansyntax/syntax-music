package com.metrolist.music.eq.data;

import io.ktor.http.ContentDisposition;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GitHubAutoEqSearch$GitHubTreeNode$$serializer implements GeneratedSerializer {
    public static final GitHubAutoEqSearch$GitHubTreeNode$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GitHubAutoEqSearch$GitHubTreeNode$$serializer gitHubAutoEqSearch$GitHubTreeNode$$serializer = new GitHubAutoEqSearch$GitHubTreeNode$$serializer();
        INSTANCE = gitHubAutoEqSearch$GitHubTreeNode$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.eq.data.GitHubAutoEqSearch.GitHubTreeNode", gitHubAutoEqSearch$GitHubTreeNode$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("path", false);
        pluginGeneratedSerialDescriptor.addElement("mode", true);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Type, false);
        pluginGeneratedSerialDescriptor.addElement("sha", true);
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Size, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, HexFormatKt.getNullable(stringSerializer), stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(LongSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String str;
        Long l;
        String str2;
        String str3;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            l = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, null);
            str2 = strDecodeStringElement2;
            str3 = str4;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            strDecodeStringElement = null;
            String str5 = null;
            Long l2 = null;
            String strDecodeStringElement3 = null;
            String str6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                obj = obj;
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str5);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                    }
                    l2 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l2);
                    i2 |= 16;
                }
            }
            str = str5;
            l = l2;
            str2 = strDecodeStringElement3;
            str3 = str6;
            i = i2;
        }
        String str7 = strDecodeStringElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GitHubAutoEqSearch$GitHubTreeNode(i, str7, str3, str2, str, l);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GitHubAutoEqSearch$GitHubTreeNode gitHubAutoEqSearch$GitHubTreeNode = (GitHubAutoEqSearch$GitHubTreeNode) obj;
        gitHubAutoEqSearch$GitHubTreeNode.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = gitHubAutoEqSearch$GitHubTreeNode.path;
        Long l = gitHubAutoEqSearch$GitHubTreeNode.size;
        String str2 = gitHubAutoEqSearch$GitHubTreeNode.sha;
        String str3 = gitHubAutoEqSearch$GitHubTreeNode.mode;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str3);
        }
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, gitHubAutoEqSearch$GitHubTreeNode.type);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || l != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
