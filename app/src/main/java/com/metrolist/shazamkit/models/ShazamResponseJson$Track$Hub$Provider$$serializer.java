package com.metrolist.shazamkit.models;

import io.ktor.http.ContentType;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"com/metrolist/shazamkit/models/ShazamResponseJson.Track.Hub.Provider.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "This synthesized declaration should not be used directly", "level", "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class ShazamResponseJson$Track$Hub$Provider$$serializer implements GeneratedSerializer {
    public static final int $stable = 0;
    public static final ShazamResponseJson$Track$Hub$Provider$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ShazamResponseJson$Track$Hub$Provider$$serializer shazamResponseJson$Track$Hub$Provider$$serializer = new ShazamResponseJson$Track$Hub$Provider$$serializer();
        INSTANCE = shazamResponseJson$Track$Hub$Provider$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.shazamkit.models.ShazamResponseJson.Track.Hub.Provider", shazamResponseJson$Track$Hub$Provider$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("caption", true);
        pluginGeneratedSerialDescriptor.addElement("images", true);
        pluginGeneratedSerialDescriptor.addElement("actions", true);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Type, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShazamResponseJson$Track$Hub$Provider$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = ShazamResponseJson.Track.Hub.Provider.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(ShazamResponseJson$Track$Hub$Provider$ProviderImages$$serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue()), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShazamResponseJson.Track.Hub.Provider deserialize(Decoder decoder) {
        List list;
        String str;
        int i;
        ShazamResponseJson.Track.Hub.Provider.ProviderImages providerImages;
        String str2;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ShazamResponseJson.Track.Hub.Provider.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            ShazamResponseJson.Track.Hub.Provider.ProviderImages providerImages2 = (ShazamResponseJson.Track.Hub.Provider.ProviderImages) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ShazamResponseJson$Track$Hub$Provider$ProviderImages$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            i = 15;
            providerImages = providerImages2;
            str2 = str3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            String str4 = null;
            ShazamResponseJson.Track.Hub.Provider.ProviderImages providerImages3 = null;
            String str5 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str5);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    providerImages3 = (ShazamResponseJson.Track.Hub.Provider.ProviderImages) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ShazamResponseJson$Track$Hub$Provider$ProviderImages$$serializer.INSTANCE, providerImages3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str4);
                    i2 |= 8;
                }
            }
            list = list2;
            str = str4;
            i = i2;
            providerImages = providerImages3;
            str2 = str5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ShazamResponseJson.Track.Hub.Provider(i, str2, providerImages, list, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShazamResponseJson.Track.Hub.Provider value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ShazamResponseJson.Track.Hub.Provider.write$Self$app(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
