package com.metrolist.shazamkit.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"com/metrolist/shazamkit/models/ShazamResponseJson.Track.Hub.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "This synthesized declaration should not be used directly", "level", "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class ShazamResponseJson$Track$Hub$$serializer implements GeneratedSerializer {
    public static final int $stable = 0;
    public static final ShazamResponseJson$Track$Hub$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ShazamResponseJson$Track$Hub$$serializer shazamResponseJson$Track$Hub$$serializer = new ShazamResponseJson$Track$Hub$$serializer();
        INSTANCE = shazamResponseJson$Track$Hub$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.shazamkit.models.ShazamResponseJson.Track.Hub", shazamResponseJson$Track$Hub$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Type, true);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Image.TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("actions", true);
        pluginGeneratedSerialDescriptor.addElement("options", true);
        pluginGeneratedSerialDescriptor.addElement("providers", true);
        pluginGeneratedSerialDescriptor.addElement("explicit", true);
        pluginGeneratedSerialDescriptor.addElement("displayname", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShazamResponseJson$Track$Hub$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = ShazamResponseJson.Track.Hub.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[3].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[4].getValue()), HexFormatKt.getNullable(BooleanSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShazamResponseJson.Track.Hub deserialize(Decoder decoder) {
        List list;
        String str;
        String str2;
        List list2;
        String str3;
        int i;
        Boolean bool;
        List list3;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ShazamResponseJson.Track.Hub.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        boolean z = true;
        List list4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            List list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            List list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, BooleanSerializer.INSTANCE, null);
            list = list7;
            str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            i = 127;
            bool = bool2;
            list3 = list6;
            list2 = list5;
            str2 = str5;
            str = str4;
        } else {
            boolean z2 = true;
            int i4 = 0;
            List list8 = null;
            String str6 = null;
            String str7 = null;
            Boolean bool3 = null;
            List list9 = null;
            String str8 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        i2 = 6;
                        i3 = 5;
                        continue;
                    case 0:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str8);
                        i4 |= 1;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 1:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
                        i4 |= 2;
                        z = true;
                        i2 = 6;
                        continue;
                    case 2:
                        list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list4);
                        i4 |= 4;
                        break;
                    case 3:
                        list9 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list9);
                        i4 |= 8;
                        break;
                    case 4:
                        list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list8);
                        i4 |= 16;
                        break;
                    case 5:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, BooleanSerializer.INSTANCE, bool3);
                        i4 |= 32;
                        break;
                    case 6:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str7);
                        i4 |= 64;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                z = true;
            }
            list = list8;
            str = str8;
            str2 = str6;
            list2 = list4;
            str3 = str7;
            i = i4;
            bool = bool3;
            list3 = list9;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ShazamResponseJson.Track.Hub(i, str, str2, list2, list3, list, bool, str3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShazamResponseJson.Track.Hub value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ShazamResponseJson.Track.Hub.write$Self$app(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
