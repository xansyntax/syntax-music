package io.ktor.websocket;

import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.http.LinkHeader;
import io.ktor.network.sockets.SocketBase;
import io.ktor.utils.io.ByteChannelUtilsKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.RawSourceChannel;
import java.io.IOException;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.internal.JsonTreeEncoder;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PingPongKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ PingPongKt$$ExternalSyntheticLambda0(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        this.$r8$classId = (byte) 8;
        this.f$0 = mutexImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                return PingPongKt.pinger$lambda$0((JobImpl) obj2, (Throwable) obj);
            case 1:
                return SocketBase.channelCompletionHandler$lambda$0((SocketBase) obj2, (Throwable) obj);
            case 2:
                return ByteChannelUtilsKt.attachWriterJob$lambda$0((ByteReadChannel) obj2, (Throwable) obj);
            case 3:
                return RawSourceChannel._init_$lambda$0((RawSourceChannel) obj2, (Throwable) obj);
            case 4:
                return obj == ((AbstractCollection) obj2) ? "(this Collection)" : String.valueOf(obj);
            case 5:
                PersistentHashMap persistentHashMap = (PersistentHashMap) obj2;
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                Object key = entry.getKey();
                StringBuilder sb = new StringBuilder(key == persistentHashMap ? "(this Map)" : String.valueOf(key));
                sb.append('=');
                Object value = entry.getValue();
                sb.append(value != persistentHashMap ? String.valueOf(value) : "(this Map)");
                return sb.toString();
            case 6:
                obj.getClass();
                return ((ScrollKt$$ExternalSyntheticLambda0) obj2).invoke();
            case 7:
                return ((MatcherMatchResult$groups$1) obj2).get(((Integer) obj).intValue());
            case 8:
                ((MutexImpl) obj2).unlock(null);
                return unit;
            case 9:
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
                classSerialDescriptorBuilder.getClass();
                classSerialDescriptorBuilder.element(LinkHeader.Parameters.Type, StringSerializer.descriptor);
                classSerialDescriptorBuilder.element("value", StringsKt__IndentKt.buildSerialDescriptor$default("kotlinx.serialization.Polymorphic<" + ((PolymorphicSerializer) obj2).baseClass.getSimpleName() + '>', SerialKind$CONTEXTUAL.INSTANCE, new SerialDescriptor[0]));
                classSerialDescriptorBuilder.annotations = EmptyList.INSTANCE;
                return unit;
            case 10:
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj2;
                int iIntValue = ((Integer) obj).intValue();
                return serialDescriptor.getElementName(iIntValue) + ": " + serialDescriptor.getElementDescriptor(iIntValue).getSerialName();
            case 11:
                TripleSerializer tripleSerializer = (TripleSerializer) obj2;
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder2 = (ClassSerialDescriptorBuilder) obj;
                classSerialDescriptorBuilder2.getClass();
                classSerialDescriptorBuilder2.element("first", tripleSerializer.aSerializer.getDescriptor());
                classSerialDescriptorBuilder2.element("second", tripleSerializer.bSerializer.getDescriptor());
                classSerialDescriptorBuilder2.element("third", tripleSerializer.cSerializer.getDescriptor());
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                JsonTreeEncoder jsonTreeEncoder = (JsonTreeEncoder) obj2;
                JsonElement jsonElement = (JsonElement) obj;
                jsonElement.getClass();
                jsonTreeEncoder.putElement((String) CollectionsKt.last(jsonTreeEncoder.tagStack), jsonElement);
                return unit;
            default:
                ((IOException) obj).getClass();
                TimeZone timeZone = _UtilJvmKt.UTC;
                ((DiskLruCache) obj2).hasJournalErrors = true;
                return unit;
        }
    }

    public /* synthetic */ PingPongKt$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }
}
