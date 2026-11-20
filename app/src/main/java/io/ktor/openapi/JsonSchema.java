package io.ktor.openapi;

import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\bb\b\u0087\b\u0018\u0000 À\u00012\u00020\u0001:JÁ\u0001Â\u0001Ã\u0001Ä\u0001Å\u0001Æ\u0001Ç\u0001È\u0001É\u0001Ê\u0001Ë\u0001Ì\u0001Í\u0001Î\u0001Ï\u0001Ð\u0001Ñ\u0001Ò\u0001Ó\u0001Ô\u0001Õ\u0001Ö\u0001×\u0001Ø\u0001Ù\u0001Ú\u0001Û\u0001Ü\u0001Ý\u0001Þ\u0001ß\u0001à\u0001á\u0001â\u0001ã\u0001ä\u0001À\u0001BØ\u0004\u0012\u0019\b\u0002\u0010\u0006\u001a\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\t0\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0017\u0012\u0012\b\u0002\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\n\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b:\u0010;B\u0095\u0004\b\u0010\u0012\u0006\u0010<\u001a\u00020\"\u0012\u0006\u0010=\u001a\u00020\"\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n\u0012\u0014\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f\u0012\u0014\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n\u0012\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010$\u001a\u0004\u0018\u00010\"\u0012\b\u0010%\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f\u0012\u0014\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\b\u0010+\u001a\u0004\u0018\u00010)\u0012\b\u0010,\u001a\u0004\u0018\u00010)\u0012\b\u0010-\u001a\u0004\u0018\u00010)\u0012\b\u0010.\u001a\u0004\u0018\u00010\"\u0012\b\u0010/\u001a\u0004\u0018\u00010\"\u0012\b\u00100\u001a\u0004\u0018\u00010\u0007\u0012\b\u00101\u001a\u0004\u0018\u00010\"\u0012\b\u00102\u001a\u0004\u0018\u00010\"\u0012\b\u00103\u001a\u0004\u0018\u00010\u0017\u0012\u0010\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\n\u0012\b\u00105\u001a\u0004\u0018\u00010\u001e\u0012\b\u00106\u001a\u0004\u0018\u00010)\u0012\b\u00107\u001a\u0004\u0018\u00010\u0007\u0012\b\u00108\u001a\u0004\u0018\u00010\u0007\u0012\b\u00109\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b:\u0010@J!\u0010A\u001a\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\t0\u0005HÆ\u0003¢\u0006\u0004\bA\u0010BJ\u0012\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bC\u0010DJ\u0012\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bE\u0010DJ\u0018\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nHÆ\u0003¢\u0006\u0004\bF\u0010GJ\u001e\u0010H\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\nHÆ\u0003¢\u0006\u0004\bH\u0010GJ\u001e\u0010I\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\nHÆ\u0003¢\u0006\u0004\bI\u0010GJ\u0018\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\fHÆ\u0003¢\u0006\u0004\bJ\u0010KJ\u001e\u0010L\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\nHÆ\u0003¢\u0006\u0004\bL\u0010GJ$\u0010M\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\bM\u0010NJ\u0012\u0010O\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bO\u0010PJ\u0012\u0010Q\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\bQ\u0010RJ\u0012\u0010S\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\bS\u0010TJ\u0012\u0010U\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\bU\u0010TJ\u0012\u0010V\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\bV\u0010WJ\u0012\u0010X\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\bX\u0010YJ\u0012\u0010Z\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\bZ\u0010[J\u0018\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\\\u0010GJ\u0012\u0010]\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b]\u0010TJ\u0012\u0010^\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b^\u0010_J\u0012\u0010`\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b`\u0010_J\u0012\u0010a\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\ba\u0010[J\u0012\u0010b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bb\u0010DJ\u0018\u0010c\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\fHÆ\u0003¢\u0006\u0004\bc\u0010KJ\u001e\u0010d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\nHÆ\u0003¢\u0006\u0004\bd\u0010GJ\u0012\u0010e\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\be\u0010fJ\u0012\u0010g\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\bg\u0010fJ\u0012\u0010h\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\bh\u0010fJ\u0012\u0010i\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\bi\u0010fJ\u0012\u0010j\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\bj\u0010_J\u0012\u0010k\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\bk\u0010_J\u0012\u0010l\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bl\u0010DJ\u0012\u0010m\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\bm\u0010_J\u0012\u0010n\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\bn\u0010_J\u0012\u0010o\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\bo\u0010TJ\u001a\u0010p\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\nHÆ\u0003¢\u0006\u0004\bp\u0010GJ\u0012\u0010q\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\bq\u0010[J\u0012\u0010r\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\br\u0010fJ\u0012\u0010s\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bs\u0010DJ\u0012\u0010t\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bt\u0010DJ\u0012\u0010u\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\bu\u0010TJá\u0004\u0010v\u001a\u00020\u00002\u0019\b\u0002\u0010\u0006\u001a\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\t0\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n2\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f2\u0016\b\u0002\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\"2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00101\u001a\u0004\u0018\u00010\"2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\"2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00172\u0012\b\u0002\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\n2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010)2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0004\bv\u0010wJ\u001b\u0010y\u001a\u00020\u00172\b\u0010x\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\by\u0010zJ\u0011\u0010{\u001a\u00020\"HÖ\u0081\u0004¢\u0006\u0004\b{\u0010|J\u0011\u0010}\u001a\u00020\u0007HÖ\u0081\u0004¢\u0006\u0004\b}\u0010DJ.\u0010\u0086\u0001\u001a\u00030\u0083\u00012\u0006\u0010~\u001a\u00020\u00002\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001H\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001R*\u0010\u0006\u001a\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\t0\u00058\u0006¢\u0006\u000e\n\u0005\b\u0006\u0010\u0087\u0001\u001a\u0005\b\u0088\u0001\u0010BR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\u000e\n\u0005\b\b\u0010\u0089\u0001\u001a\u0005\b\u008a\u0001\u0010DR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\u000e\n\u0005\b\t\u0010\u0089\u0001\u001a\u0005\b\u008b\u0001\u0010DR!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0006¢\u0006\u000e\n\u0005\b\u000b\u0010\u008c\u0001\u001a\u0005\b\u008d\u0001\u0010GR'\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n8\u0006¢\u0006\u000e\n\u0005\b\r\u0010\u008c\u0001\u001a\u0005\b\u008e\u0001\u0010GR'\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n8\u0006¢\u0006\u000e\n\u0005\b\u000e\u0010\u008c\u0001\u001a\u0005\b\u008f\u0001\u0010GR!\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f8\u0006¢\u0006\u000e\n\u0005\b\u000f\u0010\u0090\u0001\u001a\u0005\b\u0091\u0001\u0010KR'\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n8\u0006¢\u0006\u000e\n\u0005\b\u0010\u0010\u008c\u0001\u001a\u0005\b\u0092\u0001\u0010GR-\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\u00118\u0006¢\u0006\u000e\n\u0005\b\u0012\u0010\u0093\u0001\u001a\u0005\b\u0094\u0001\u0010NR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\u000e\n\u0005\b\u0014\u0010\u0095\u0001\u001a\u0005\b\u0096\u0001\u0010PR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\u000e\n\u0005\b\u0016\u0010\u0097\u0001\u001a\u0005\b\u0098\u0001\u0010RR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\u000e\n\u0005\b\u0018\u0010\u0099\u0001\u001a\u0005\b\u009a\u0001\u0010TR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\u000e\n\u0005\b\u0019\u0010\u0099\u0001\u001a\u0005\b\u009b\u0001\u0010TR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\u000e\n\u0005\b\u001b\u0010\u009c\u0001\u001a\u0005\b\u009d\u0001\u0010WR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\u000e\n\u0005\b\u001d\u0010\u009e\u0001\u001a\u0005\b\u009f\u0001\u0010YR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\u000e\n\u0005\b\u001f\u0010 \u0001\u001a\u0005\b¡\u0001\u0010[R!\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n8\u0006¢\u0006\u000e\n\u0005\b \u0010\u008c\u0001\u001a\u0005\b¢\u0001\u0010GR\u001b\u0010!\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\u000e\n\u0005\b!\u0010\u0099\u0001\u001a\u0005\b£\u0001\u0010TR\u001b\u0010#\u001a\u0004\u0018\u00010\"8\u0006¢\u0006\u000e\n\u0005\b#\u0010¤\u0001\u001a\u0005\b¥\u0001\u0010_R\u001b\u0010$\u001a\u0004\u0018\u00010\"8\u0006¢\u0006\u000e\n\u0005\b$\u0010¤\u0001\u001a\u0005\b¦\u0001\u0010_R\u001b\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\u000e\n\u0005\b%\u0010 \u0001\u001a\u0005\b§\u0001\u0010[R\u001b\u0010&\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\u000e\n\u0005\b&\u0010\u0089\u0001\u001a\u0005\b¨\u0001\u0010DR!\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f8\u0006¢\u0006\u000e\n\u0005\b'\u0010\u0090\u0001\u001a\u0005\b©\u0001\u0010KR'\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f\u0018\u00010\n8\u0006¢\u0006\u000e\n\u0005\b(\u0010\u008c\u0001\u001a\u0005\bª\u0001\u0010GR\u001b\u0010*\u001a\u0004\u0018\u00010)8\u0006¢\u0006\u000e\n\u0005\b*\u0010«\u0001\u001a\u0005\b¬\u0001\u0010fR\u001b\u0010+\u001a\u0004\u0018\u00010)8\u0006¢\u0006\u000e\n\u0005\b+\u0010«\u0001\u001a\u0005\b\u00ad\u0001\u0010fR\u001b\u0010,\u001a\u0004\u0018\u00010)8\u0006¢\u0006\u000e\n\u0005\b,\u0010«\u0001\u001a\u0005\b®\u0001\u0010fR\u001b\u0010-\u001a\u0004\u0018\u00010)8\u0006¢\u0006\u000e\n\u0005\b-\u0010«\u0001\u001a\u0005\b¯\u0001\u0010fR\u001b\u0010.\u001a\u0004\u0018\u00010\"8\u0006¢\u0006\u000e\n\u0005\b.\u0010¤\u0001\u001a\u0005\b°\u0001\u0010_R\u001b\u0010/\u001a\u0004\u0018\u00010\"8\u0006¢\u0006\u000e\n\u0005\b/\u0010¤\u0001\u001a\u0005\b±\u0001\u0010_R\u001b\u00100\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\u000e\n\u0005\b0\u0010\u0089\u0001\u001a\u0005\b²\u0001\u0010DR\u001b\u00101\u001a\u0004\u0018\u00010\"8\u0006¢\u0006\u000e\n\u0005\b1\u0010¤\u0001\u001a\u0005\b³\u0001\u0010_R\u001b\u00102\u001a\u0004\u0018\u00010\"8\u0006¢\u0006\u000e\n\u0005\b2\u0010¤\u0001\u001a\u0005\b´\u0001\u0010_R\u001b\u00103\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\u000e\n\u0005\b3\u0010\u0099\u0001\u001a\u0005\bµ\u0001\u0010TR#\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\n8\u0006¢\u0006\u000e\n\u0005\b4\u0010\u008c\u0001\u001a\u0005\b¶\u0001\u0010GR\u001b\u00105\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\u000e\n\u0005\b5\u0010 \u0001\u001a\u0005\b·\u0001\u0010[R\u001b\u00106\u001a\u0004\u0018\u00010)8\u0006¢\u0006\u000e\n\u0005\b6\u0010«\u0001\u001a\u0005\b¸\u0001\u0010fR&\u00107\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0016\n\u0005\b7\u0010\u0089\u0001\u0012\u0006\bº\u0001\u0010»\u0001\u001a\u0005\b¹\u0001\u0010DR&\u00108\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0016\n\u0005\b8\u0010\u0089\u0001\u0012\u0006\b½\u0001\u0010»\u0001\u001a\u0005\b¼\u0001\u0010DR&\u00109\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0016\n\u0005\b9\u0010\u0099\u0001\u0012\u0006\b¿\u0001\u0010»\u0001\u001a\u0005\b¾\u0001\u0010T¨\u0006å\u0001"}, d2 = {"Lio/ktor/openapi/JsonSchema;", "", "Lio/ktor/openapi/JsonSchema$SchemaType;", "Lkotlinx/serialization/Serializable;", "with", "Lio/ktor/openapi/JsonSchema$SchemaType$Serializer;", LinkHeader.Parameters.Type, "", LinkHeader.Parameters.Title, "description", "", "required", "Lio/ktor/openapi/ReferenceOr;", "allOf", "oneOf", "not", "anyOf", "", "properties", "Lio/ktor/openapi/AdditionalProperties;", "additionalProperties", "Lio/ktor/openapi/JsonSchemaDiscriminator;", "discriminator", "", "readOnly", "writeOnly", "Lio/ktor/openapi/Xml;", "xml", "Lio/ktor/openapi/ExternalDocs;", "externalDocs", "Lio/ktor/openapi/GenericElement;", "example", "examples", "deprecated", "", "maxProperties", "minProperties", "default", "format", "items", "prefixItems", "", "maximum", "exclusiveMaximum", "minimum", "exclusiveMinimum", "maxLength", "minLength", "pattern", "maxItems", "minItems", "uniqueItems", "enum", "const", "multipleOf", "id", LinkHeader.Parameters.Anchor, "dynamicAnchor", "<init>", "(Lio/ktor/openapi/JsonSchema$SchemaType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lio/ktor/openapi/ReferenceOr;Ljava/util/List;Ljava/util/Map;Lio/ktor/openapi/AdditionalProperties;Lio/ktor/openapi/JsonSchemaDiscriminator;Ljava/lang/Boolean;Ljava/lang/Boolean;Lio/ktor/openapi/Xml;Lio/ktor/openapi/ExternalDocs;Lio/ktor/openapi/GenericElement;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Lio/ktor/openapi/ReferenceOr;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Lio/ktor/openapi/GenericElement;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILio/ktor/openapi/JsonSchema$SchemaType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lio/ktor/openapi/ReferenceOr;Ljava/util/List;Ljava/util/Map;Lio/ktor/openapi/AdditionalProperties;Lio/ktor/openapi/JsonSchemaDiscriminator;Ljava/lang/Boolean;Ljava/lang/Boolean;Lio/ktor/openapi/Xml;Lio/ktor/openapi/ExternalDocs;Lio/ktor/openapi/GenericElement;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Lio/ktor/openapi/ReferenceOr;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Lio/ktor/openapi/GenericElement;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Lio/ktor/openapi/JsonSchema$SchemaType;", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/util/List;", "component5", "component6", "component7", "()Lio/ktor/openapi/ReferenceOr;", "component8", "component9", "()Ljava/util/Map;", "component10", "()Lio/ktor/openapi/AdditionalProperties;", "component11", "()Lio/ktor/openapi/JsonSchemaDiscriminator;", "component12", "()Ljava/lang/Boolean;", "component13", "component14", "()Lio/ktor/openapi/Xml;", "component15", "()Lio/ktor/openapi/ExternalDocs;", "component16", "()Lio/ktor/openapi/GenericElement;", "component17", "component18", "component19", "()Ljava/lang/Integer;", "component20", "component21", "component22", "component23", "component24", "component25", "()Ljava/lang/Double;", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "copy", "(Lio/ktor/openapi/JsonSchema$SchemaType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lio/ktor/openapi/ReferenceOr;Ljava/util/List;Ljava/util/Map;Lio/ktor/openapi/AdditionalProperties;Lio/ktor/openapi/JsonSchemaDiscriminator;Ljava/lang/Boolean;Ljava/lang/Boolean;Lio/ktor/openapi/Xml;Lio/ktor/openapi/ExternalDocs;Lio/ktor/openapi/GenericElement;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Lio/ktor/openapi/ReferenceOr;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Lio/ktor/openapi/GenericElement;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lio/ktor/openapi/JsonSchema;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/JsonSchema;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Lio/ktor/openapi/JsonSchema$SchemaType;", "getType", "Ljava/lang/String;", "getTitle", "getDescription", "Ljava/util/List;", "getRequired", "getAllOf", "getOneOf", "Lio/ktor/openapi/ReferenceOr;", "getNot", "getAnyOf", "Ljava/util/Map;", "getProperties", "Lio/ktor/openapi/AdditionalProperties;", "getAdditionalProperties", "Lio/ktor/openapi/JsonSchemaDiscriminator;", "getDiscriminator", "Ljava/lang/Boolean;", "getReadOnly", "getWriteOnly", "Lio/ktor/openapi/Xml;", "getXml", "Lio/ktor/openapi/ExternalDocs;", "getExternalDocs", "Lio/ktor/openapi/GenericElement;", "getExample", "getExamples", "getDeprecated", "Ljava/lang/Integer;", "getMaxProperties", "getMinProperties", "getDefault", "getFormat", "getItems", "getPrefixItems", "Ljava/lang/Double;", "getMaximum", "getExclusiveMaximum", "getMinimum", "getExclusiveMinimum", "getMaxLength", "getMinLength", "getPattern", "getMaxItems", "getMinItems", "getUniqueItems", "getEnum", "getConst", "getMultipleOf", "getId", "getId$annotations", "()V", "getAnchor", "getAnchor$annotations", "getDynamicAnchor", "getDynamicAnchor$annotations", "Companion", "SchemaType", "Ignore", "Id", "Anchor", "Title", "Description", "Type", "Format", "DeprecatedSchema", "ReadOnly", "WriteOnly", "Default", "Example", "Enum", "Const", "MinLength", "MaxLength", "Pattern", "Minimum", "Maximum", "MultipleOf", "MinItems", "MaxItems", "UniqueItems", "MinProperties", "MaxProperties", "Required", "AdditionalPropertiesAllowed", "AdditionalPropertiesRef", "AnyOfRefs", "OneOf", "Not", "ItemsRef", "PrefixItemsRef", "Discriminator", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class JsonSchema {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AdditionalProperties additionalProperties;
    private final List<ReferenceOr<JsonSchema>> allOf;
    private final String anchor;
    private final List<ReferenceOr<JsonSchema>> anyOf;
    private final GenericElement const;
    private final GenericElement default;
    private final Boolean deprecated;
    private final String description;
    private final JsonSchemaDiscriminator discriminator;
    private final Boolean dynamicAnchor;
    private final List<GenericElement> enum;
    private final GenericElement example;
    private final List<GenericElement> examples;
    private final Double exclusiveMaximum;
    private final Double exclusiveMinimum;
    private final ExternalDocs externalDocs;
    private final String format;
    private final String id;
    private final ReferenceOr<JsonSchema> items;
    private final Integer maxItems;
    private final Integer maxLength;
    private final Integer maxProperties;
    private final Double maximum;
    private final Integer minItems;
    private final Integer minLength;
    private final Integer minProperties;
    private final Double minimum;
    private final Double multipleOf;
    private final ReferenceOr<JsonSchema> not;
    private final List<ReferenceOr<JsonSchema>> oneOf;
    private final String pattern;
    private final List<ReferenceOr<JsonSchema>> prefixItems;
    private final Map<String, ReferenceOr<JsonSchema>> properties;
    private final Boolean readOnly;
    private final List<String> required;
    private final String title;
    private final SchemaType type;
    private final Boolean uniqueItems;
    private final Boolean writeOnly;
    private final Xml xml;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/openapi/JsonSchema$AdditionalPropertiesAllowed;", "", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AdditionalPropertiesAllowed {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements AdditionalPropertiesAllowed {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$AdditionalPropertiesRef;", "", "Lkotlin/reflect/KClass;", "value", "<init>", "(Lkotlin/reflect/KClass;)V", "()Ljava/lang/Class;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AdditionalPropertiesRef {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements AdditionalPropertiesRef {
            private final /* synthetic */ Class value;

            public Impl(KClass<?> kClass) {
                kClass.getClass();
                this.value = Okio__OkioKt.getJavaClass(kClass);
            }

            @Override // io.ktor.openapi.JsonSchema.AdditionalPropertiesRef
            public final /* synthetic */ Class value() {
                return this.value;
            }
        }

        Class<?> value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchema$AnyOfRefs;", "", "", "", "value", "<init>", "(Lkotlin/Array;)V", "()[Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnyOfRefs {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements AnyOfRefs {
            private final /* synthetic */ String[] value;

            public Impl(String[] strArr) {
                strArr.getClass();
                this.value = strArr;
            }

            @Override // io.ktor.openapi.JsonSchema.AnyOfRefs
            public final /* synthetic */ String[] value() {
                return this.value;
            }
        }

        String[] value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$Const;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Const {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Const {
            private final /* synthetic */ String value;

            public Impl(String str) {
                str.getClass();
                this.value = str;
            }

            @Override // io.ktor.openapi.JsonSchema.Const
            public final /* synthetic */ String value() {
                return this.value;
            }
        }

        String value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$Default;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Default {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Default {
            private final /* synthetic */ String value;

            public Impl(String str) {
                str.getClass();
                this.value = str;
            }

            @Override // io.ktor.openapi.JsonSchema.Default
            public final /* synthetic */ String value() {
                return this.value;
            }
        }

        String value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/openapi/JsonSchema$DeprecatedSchema;", "", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DeprecatedSchema {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements DeprecatedSchema {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$Description;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Description {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Description {
            private final /* synthetic */ String value;

            public Impl(String str) {
                str.getClass();
                this.value = str;
            }

            @Override // io.ktor.openapi.JsonSchema.Description
            public final /* synthetic */ String value() {
                return this.value;
            }
        }

        String value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\tR\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\f"}, d2 = {"Lio/ktor/openapi/JsonSchema$Discriminator;", "", "", "property", "", "Lio/ktor/openapi/JsonSchema$Discriminator$Mapping;", "mapping", "<init>", "(Ljava/lang/String;Lkotlin/Array;)V", "()Ljava/lang/String;", "()[Lio/ktor/openapi/JsonSchema$Discriminator$Mapping;", "Mapping", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Discriminator {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Discriminator {
            private final /* synthetic */ Mapping[] mapping;
            private final /* synthetic */ String property;

            public Impl(String str, Mapping[] mappingArr) {
                str.getClass();
                mappingArr.getClass();
                this.property = str;
                this.mapping = mappingArr;
            }

            @Override // io.ktor.openapi.JsonSchema.Discriminator
            public final /* synthetic */ Mapping[] mapping() {
                return this.mapping;
            }

            @Override // io.ktor.openapi.JsonSchema.Discriminator
            public final /* synthetic */ String property() {
                return this.property;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Retention(RetentionPolicy.RUNTIME)
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\bR\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/openapi/JsonSchema$Discriminator$Mapping;", "", "", "key", "Lkotlin/reflect/KClass;", "ref", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KClass;)V", "()Ljava/lang/String;", "()Ljava/lang/Class;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public @interface Mapping {
            String key();

            Class<?> ref();
        }

        Mapping[] mapping();

        String property();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchema$Enum;", "", "", "", "value", "<init>", "(Lkotlin/Array;)V", "()[Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enum {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Enum {
            private final /* synthetic */ String[] value;

            public Impl(String[] strArr) {
                strArr.getClass();
                this.value = strArr;
            }

            @Override // io.ktor.openapi.JsonSchema.Enum
            public final /* synthetic */ String[] value() {
                return this.value;
            }
        }

        String[] value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchema$Example;", "", "", "", "value", "<init>", "(Lkotlin/Array;)V", "()[Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Example {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Example {
            private final /* synthetic */ String[] value;

            public Impl(String[] strArr) {
                strArr.getClass();
                this.value = strArr;
            }

            @Override // io.ktor.openapi.JsonSchema.Example
            public final /* synthetic */ String[] value() {
                return this.value;
            }
        }

        String[] value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$Format;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Format {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Format {
            private final /* synthetic */ String value;

            public Impl(String str) {
                str.getClass();
                this.value = str;
            }

            @Override // io.ktor.openapi.JsonSchema.Format
            public final /* synthetic */ String value() {
                return this.value;
            }
        }

        String value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$Id;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Id {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Id {
            private final /* synthetic */ String value;

            public Impl(String str) {
                str.getClass();
                this.value = str;
            }

            @Override // io.ktor.openapi.JsonSchema.Id
            public final /* synthetic */ String value() {
                return this.value;
            }
        }

        String value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/openapi/JsonSchema$Ignore;", "", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ignore {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Ignore {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$ItemsRef;", "", "Lkotlin/reflect/KClass;", "value", "<init>", "(Lkotlin/reflect/KClass;)V", "()Ljava/lang/Class;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ItemsRef {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements ItemsRef {
            private final /* synthetic */ Class value;

            public Impl(KClass<?> kClass) {
                kClass.getClass();
                this.value = Okio__OkioKt.getJavaClass(kClass);
            }

            @Override // io.ktor.openapi.JsonSchema.ItemsRef
            public final /* synthetic */ Class value() {
                return this.value;
            }
        }

        Class<?> value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$MaxItems;", "", "", "value", "<init>", "(I)V", "()I", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MaxItems {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements MaxItems {
            private final /* synthetic */ int value;

            public Impl(int i) {
                this.value = i;
            }

            @Override // io.ktor.openapi.JsonSchema.MaxItems
            public final /* synthetic */ int value() {
                return this.value;
            }
        }

        int value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$MaxLength;", "", "", "value", "<init>", "(I)V", "()I", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MaxLength {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements MaxLength {
            private final /* synthetic */ int value;

            public Impl(int i) {
                this.value = i;
            }

            @Override // io.ktor.openapi.JsonSchema.MaxLength
            public final /* synthetic */ int value() {
                return this.value;
            }
        }

        int value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$MaxProperties;", "", "", "value", "<init>", "(I)V", "()I", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MaxProperties {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements MaxProperties {
            private final /* synthetic */ int value;

            public Impl(int i) {
                this.value = i;
            }

            @Override // io.ktor.openapi.JsonSchema.MaxProperties
            public final /* synthetic */ int value() {
                return this.value;
            }
        }

        int value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$MinItems;", "", "", "value", "<init>", "(I)V", "()I", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MinItems {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements MinItems {
            private final /* synthetic */ int value;

            public Impl(int i) {
                this.value = i;
            }

            @Override // io.ktor.openapi.JsonSchema.MinItems
            public final /* synthetic */ int value() {
                return this.value;
            }
        }

        int value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$MinLength;", "", "", "value", "<init>", "(I)V", "()I", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MinLength {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements MinLength {
            private final /* synthetic */ int value;

            public Impl(int i) {
                this.value = i;
            }

            @Override // io.ktor.openapi.JsonSchema.MinLength
            public final /* synthetic */ int value() {
                return this.value;
            }
        }

        int value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$MinProperties;", "", "", "value", "<init>", "(I)V", "()I", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MinProperties {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements MinProperties {
            private final /* synthetic */ int value;

            public Impl(int i) {
                this.value = i;
            }

            @Override // io.ktor.openapi.JsonSchema.MinProperties
            public final /* synthetic */ int value() {
                return this.value;
            }
        }

        int value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$MultipleOf;", "", "", "value", "<init>", "(D)V", "()D", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MultipleOf {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements MultipleOf {
            private final /* synthetic */ double value;

            public Impl(double d) {
                this.value = d;
            }

            @Override // io.ktor.openapi.JsonSchema.MultipleOf
            public final /* synthetic */ double value() {
                return this.value;
            }
        }

        double value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$Not;", "", "Lkotlin/reflect/KClass;", "value", "<init>", "(Lkotlin/reflect/KClass;)V", "()Ljava/lang/Class;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Not {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Not {
            private final /* synthetic */ Class value;

            public Impl(KClass<?> kClass) {
                kClass.getClass();
                this.value = Okio__OkioKt.getJavaClass(kClass);
            }

            @Override // io.ktor.openapi.JsonSchema.Not
            public final /* synthetic */ Class value() {
                return this.value;
            }
        }

        Class<?> value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\"\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchema$OneOf;", "", "", "Lkotlin/reflect/KClass;", "value", "<init>", "(Lkotlin/Array;)V", "()[Ljava/lang/Class;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OneOf {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements OneOf {
            private final /* synthetic */ Class[] value;

            public Impl(KClass<?>[] kClassArr) {
                kClassArr.getClass();
                int length = kClassArr.length;
                Class[] clsArr = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr[i] = Okio__OkioKt.getJavaClass(kClassArr[i]);
                }
                this.value = clsArr;
            }

            @Override // io.ktor.openapi.JsonSchema.OneOf
            public final /* synthetic */ Class[] value() {
                return this.value;
            }
        }

        Class<?>[] value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$Pattern;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Pattern {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Pattern {
            private final /* synthetic */ String value;

            public Impl(String str) {
                str.getClass();
                this.value = str;
            }

            @Override // io.ktor.openapi.JsonSchema.Pattern
            public final /* synthetic */ String value() {
                return this.value;
            }
        }

        String value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\"\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchema$PrefixItemsRef;", "", "", "Lkotlin/reflect/KClass;", "value", "<init>", "(Lkotlin/Array;)V", "()[Ljava/lang/Class;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PrefixItemsRef {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements PrefixItemsRef {
            private final /* synthetic */ Class[] value;

            public Impl(KClass<?>[] kClassArr) {
                kClassArr.getClass();
                int length = kClassArr.length;
                Class[] clsArr = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr[i] = Okio__OkioKt.getJavaClass(kClassArr[i]);
                }
                this.value = clsArr;
            }

            @Override // io.ktor.openapi.JsonSchema.PrefixItemsRef
            public final /* synthetic */ Class[] value() {
                return this.value;
            }
        }

        Class<?>[] value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/openapi/JsonSchema$ReadOnly;", "", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ReadOnly {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements ReadOnly {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchema$Required;", "", "", "", "value", "<init>", "(Lkotlin/Array;)V", "()[Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Required {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Required {
            private final /* synthetic */ String[] value;

            public Impl(String[] strArr) {
                strArr.getClass();
                this.value = strArr;
            }

            @Override // io.ktor.openapi.JsonSchema.Required
            public final /* synthetic */ String[] value() {
                return this.value;
            }
        }

        String[] value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$Title;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Title {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Title {
            private final /* synthetic */ String value;

            public Impl(String str) {
                str.getClass();
                this.value = str;
            }

            @Override // io.ktor.openapi.JsonSchema.Title
            public final /* synthetic */ String value() {
                return this.value;
            }
        }

        String value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/openapi/JsonSchema$Type;", "", "Lio/ktor/openapi/JsonType;", "value", "<init>", "(Lio/ktor/openapi/JsonType;)V", "()Lio/ktor/openapi/JsonType;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Type {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Type {
            private final /* synthetic */ JsonType value;

            public Impl(JsonType jsonType) {
                jsonType.getClass();
                this.value = jsonType;
            }

            @Override // io.ktor.openapi.JsonSchema.Type
            public final /* synthetic */ JsonType value() {
                return this.value;
            }
        }

        JsonType value();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/openapi/JsonSchema$UniqueItems;", "", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UniqueItems {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements UniqueItems {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/openapi/JsonSchema$WriteOnly;", "", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface WriteOnly {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements WriteOnly {
        }
    }

    static {
        Header$$ExternalSyntheticLambda0 header$$ExternalSyntheticLambda0 = new Header$$ExternalSyntheticLambda0((byte) 19);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, ResultKt.lazy(lazyThreadSafetyMode, header$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 26)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 27)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 28)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 29)), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 1)), null, null, null, null, null, null, ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 2)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 20)), null, null, null, ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 21)), null, ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 22)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 23)), null, null, null, null, null, null, null, null, null, null, ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 24)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 25)), null, null, null, null};
    }

    public /* synthetic */ JsonSchema(SchemaType schemaType, String str, String str2, List list, List list2, List list3, ReferenceOr referenceOr, List list4, Map map, AdditionalProperties additionalProperties, JsonSchemaDiscriminator jsonSchemaDiscriminator, Boolean bool, Boolean bool2, Xml xml, ExternalDocs externalDocs, GenericElement genericElement, List list5, Boolean bool3, Integer num, Integer num2, GenericElement genericElement2, String str3, ReferenceOr referenceOr2, List list6, Double d, Double d2, Double d3, Double d4, Integer num3, Integer num4, String str4, Integer num5, Integer num6, Boolean bool4, List list7, GenericElement genericElement3, Double d5, String str5, String str6, Boolean bool5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : schemaType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : referenceOr, (i & 128) != 0 ? null : list4, (i & 256) != 0 ? null : map, (i & 512) != 0 ? null : additionalProperties, (i & 1024) != 0 ? null : jsonSchemaDiscriminator, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : bool2, (i & 8192) != 0 ? null : xml, (i & 16384) != 0 ? null : externalDocs, (i & 32768) != 0 ? null : genericElement, (i & 65536) != 0 ? null : list5, (i & 131072) != 0 ? null : bool3, (i & 262144) != 0 ? null : num, (i & 524288) != 0 ? null : num2, (i & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? null : genericElement2, (i & 2097152) != 0 ? null : str3, (i & 4194304) != 0 ? null : referenceOr2, (i & 8388608) != 0 ? null : list6, (i & 16777216) != 0 ? null : d, (i & 33554432) != 0 ? null : d2, (i & 67108864) != 0 ? null : d3, (i & 134217728) != 0 ? null : d4, (i & WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE) != 0 ? null : num3, (i & 536870912) != 0 ? null : num4, (i & 1073741824) != 0 ? null : str4, (i & Integer.MIN_VALUE) != 0 ? null : num5, (i2 & 1) != 0 ? null : num6, (i2 & 2) != 0 ? null : bool4, (i2 & 4) != 0 ? null : list7, (i2 & 8) != 0 ? null : genericElement3, (i2 & 16) != 0 ? null : d5, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : bool5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashSetSerializer(new ReferenceOr.Companion.Serializer(JsonSchema$$serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashSetSerializer(new ReferenceOr.Companion.Serializer(JsonSchema$$serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$10() {
        return new HashSetSerializer(HexFormatKt.getNullable(new GenericElementSerializer()), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$11() {
        return new GenericElementSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ReferenceOr.Companion.Serializer(JsonSchema$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new HashSetSerializer(new ReferenceOr.Companion.Serializer(JsonSchema$$serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(JsonSchema$$serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
        return new GenericElementSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$6() {
        return new HashSetSerializer(new GenericElementSerializer(), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$7() {
        return new GenericElementSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$8() {
        return new ReferenceOr.Companion.Serializer(JsonSchema$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$9() {
        return new HashSetSerializer(new ReferenceOr.Companion.Serializer(JsonSchema$$serializer.INSTANCE), (byte) 1);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(JsonSchema self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, SchemaType.Serializer.INSTANCE, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.required != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.required);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.allOf != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.allOf);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.oneOf != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.oneOf);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.not != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.not);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.anyOf != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.anyOf);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.properties != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) lazyArr[8].getValue(), self.properties);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.additionalProperties != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, AdditionalProperties.Companion.Serializer.INSTANCE, self.additionalProperties);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.discriminator != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, JsonSchemaDiscriminator$$serializer.INSTANCE, self.discriminator);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.readOnly != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, BooleanSerializer.INSTANCE, self.readOnly);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.writeOnly != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, BooleanSerializer.INSTANCE, self.writeOnly);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.xml != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, Xml.Companion.Serializer.INSTANCE, self.xml);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.externalDocs != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, ExternalDocs$$serializer.INSTANCE, self.externalDocs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.example != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, (SerializationStrategy) lazyArr[15].getValue(), self.example);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.examples != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, (SerializationStrategy) lazyArr[16].getValue(), self.examples);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.deprecated != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, BooleanSerializer.INSTANCE, self.deprecated);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.maxProperties != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, IntSerializer.INSTANCE, self.maxProperties);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.minProperties != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, IntSerializer.INSTANCE, self.minProperties);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.default != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, (SerializationStrategy) lazyArr[20].getValue(), self.default);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.format != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.format);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.items != null) {
            output.encodeNullableSerializableElement(serialDesc, 22, (SerializationStrategy) lazyArr[22].getValue(), self.items);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.prefixItems != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, (SerializationStrategy) lazyArr[23].getValue(), self.prefixItems);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.maximum != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, DoubleSerializer.INSTANCE, self.maximum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.exclusiveMaximum != null) {
            output.encodeNullableSerializableElement(serialDesc, 25, DoubleSerializer.INSTANCE, self.exclusiveMaximum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.minimum != null) {
            output.encodeNullableSerializableElement(serialDesc, 26, DoubleSerializer.INSTANCE, self.minimum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.exclusiveMinimum != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, DoubleSerializer.INSTANCE, self.exclusiveMinimum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.maxLength != null) {
            output.encodeNullableSerializableElement(serialDesc, 28, IntSerializer.INSTANCE, self.maxLength);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.minLength != null) {
            output.encodeNullableSerializableElement(serialDesc, 29, IntSerializer.INSTANCE, self.minLength);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.pattern != null) {
            output.encodeNullableSerializableElement(serialDesc, 30, StringSerializer.INSTANCE, self.pattern);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.maxItems != null) {
            output.encodeNullableSerializableElement(serialDesc, 31, IntSerializer.INSTANCE, self.maxItems);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.minItems != null) {
            output.encodeNullableSerializableElement(serialDesc, 32, IntSerializer.INSTANCE, self.minItems);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 33) || self.uniqueItems != null) {
            output.encodeNullableSerializableElement(serialDesc, 33, BooleanSerializer.INSTANCE, self.uniqueItems);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.enum != null) {
            output.encodeNullableSerializableElement(serialDesc, 34, (SerializationStrategy) lazyArr[34].getValue(), self.enum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.const != null) {
            output.encodeNullableSerializableElement(serialDesc, 35, (SerializationStrategy) lazyArr[35].getValue(), self.const);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.multipleOf != null) {
            output.encodeNullableSerializableElement(serialDesc, 36, DoubleSerializer.INSTANCE, self.multipleOf);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 37, StringSerializer.INSTANCE, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.anchor != null) {
            output.encodeNullableSerializableElement(serialDesc, 38, StringSerializer.INSTANCE, self.anchor);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 39) && self.dynamicAnchor == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 39, BooleanSerializer.INSTANCE, self.dynamicAnchor);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SchemaType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final AdditionalProperties getAdditionalProperties() {
        return this.additionalProperties;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final JsonSchemaDiscriminator getDiscriminator() {
        return this.discriminator;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getReadOnly() {
        return this.readOnly;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getWriteOnly() {
        return this.writeOnly;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Xml getXml() {
        return this.xml;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ExternalDocs getExternalDocs() {
        return this.externalDocs;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final GenericElement getExample() {
        return this.example;
    }

    public final List<GenericElement> component17() {
        return this.examples;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Boolean getDeprecated() {
        return this.deprecated;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Integer getMaxProperties() {
        return this.maxProperties;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Integer getMinProperties() {
        return this.minProperties;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final GenericElement getDefault() {
        return this.default;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    public final ReferenceOr<JsonSchema> component23() {
        return this.items;
    }

    public final List<ReferenceOr<JsonSchema>> component24() {
        return this.prefixItems;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Double getMaximum() {
        return this.maximum;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Double getExclusiveMaximum() {
        return this.exclusiveMaximum;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Double getMinimum() {
        return this.minimum;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final Double getExclusiveMinimum() {
        return this.exclusiveMinimum;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Integer getMaxLength() {
        return this.maxLength;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Integer getMinLength() {
        return this.minLength;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getPattern() {
        return this.pattern;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final Integer getMaxItems() {
        return this.maxItems;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final Integer getMinItems() {
        return this.minItems;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final Boolean getUniqueItems() {
        return this.uniqueItems;
    }

    public final List<GenericElement> component35() {
        return this.enum;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final GenericElement getConst() {
        return this.const;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final Double getMultipleOf() {
        return this.multipleOf;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final String getAnchor() {
        return this.anchor;
    }

    public final List<String> component4() {
        return this.required;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final Boolean getDynamicAnchor() {
        return this.dynamicAnchor;
    }

    public final List<ReferenceOr<JsonSchema>> component5() {
        return this.allOf;
    }

    public final List<ReferenceOr<JsonSchema>> component6() {
        return this.oneOf;
    }

    public final ReferenceOr<JsonSchema> component7() {
        return this.not;
    }

    public final List<ReferenceOr<JsonSchema>> component8() {
        return this.anyOf;
    }

    public final Map<String, ReferenceOr<JsonSchema>> component9() {
        return this.properties;
    }

    public final JsonSchema copy(SchemaType type, String title, String description, List<String> required, List<? extends ReferenceOr<JsonSchema>> allOf, List<? extends ReferenceOr<JsonSchema>> oneOf, ReferenceOr<JsonSchema> not, List<? extends ReferenceOr<JsonSchema>> anyOf, Map<String, ? extends ReferenceOr<JsonSchema>> properties, AdditionalProperties additionalProperties, JsonSchemaDiscriminator discriminator, Boolean readOnly, Boolean writeOnly, Xml xml, ExternalDocs externalDocs, GenericElement example, List<? extends GenericElement> examples, Boolean deprecated, Integer maxProperties, Integer minProperties, GenericElement genericElement, String format, ReferenceOr<JsonSchema> items, List<? extends ReferenceOr<JsonSchema>> prefixItems, Double maximum, Double exclusiveMaximum, Double minimum, Double exclusiveMinimum, Integer maxLength, Integer minLength, String pattern, Integer maxItems, Integer minItems, Boolean uniqueItems, List<? extends GenericElement> list, GenericElement genericElement2, Double multipleOf, String id, String anchor, Boolean dynamicAnchor) {
        return new JsonSchema(type, title, description, required, allOf, oneOf, not, anyOf, properties, additionalProperties, discriminator, readOnly, writeOnly, xml, externalDocs, example, examples, deprecated, maxProperties, minProperties, genericElement, format, items, prefixItems, maximum, exclusiveMaximum, minimum, exclusiveMinimum, maxLength, minLength, pattern, maxItems, minItems, uniqueItems, list, genericElement2, multipleOf, id, anchor, dynamicAnchor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JsonSchema)) {
            return false;
        }
        JsonSchema jsonSchema = (JsonSchema) other;
        return Intrinsics.areEqual(this.type, jsonSchema.type) && Intrinsics.areEqual(this.title, jsonSchema.title) && Intrinsics.areEqual(this.description, jsonSchema.description) && Intrinsics.areEqual(this.required, jsonSchema.required) && Intrinsics.areEqual(this.allOf, jsonSchema.allOf) && Intrinsics.areEqual(this.oneOf, jsonSchema.oneOf) && Intrinsics.areEqual(this.not, jsonSchema.not) && Intrinsics.areEqual(this.anyOf, jsonSchema.anyOf) && Intrinsics.areEqual(this.properties, jsonSchema.properties) && Intrinsics.areEqual(this.additionalProperties, jsonSchema.additionalProperties) && Intrinsics.areEqual(this.discriminator, jsonSchema.discriminator) && Intrinsics.areEqual(this.readOnly, jsonSchema.readOnly) && Intrinsics.areEqual(this.writeOnly, jsonSchema.writeOnly) && Intrinsics.areEqual(this.xml, jsonSchema.xml) && Intrinsics.areEqual(this.externalDocs, jsonSchema.externalDocs) && Intrinsics.areEqual(this.example, jsonSchema.example) && Intrinsics.areEqual(this.examples, jsonSchema.examples) && Intrinsics.areEqual(this.deprecated, jsonSchema.deprecated) && Intrinsics.areEqual(this.maxProperties, jsonSchema.maxProperties) && Intrinsics.areEqual(this.minProperties, jsonSchema.minProperties) && Intrinsics.areEqual(this.default, jsonSchema.default) && Intrinsics.areEqual(this.format, jsonSchema.format) && Intrinsics.areEqual(this.items, jsonSchema.items) && Intrinsics.areEqual(this.prefixItems, jsonSchema.prefixItems) && Intrinsics.areEqual(this.maximum, jsonSchema.maximum) && Intrinsics.areEqual(this.exclusiveMaximum, jsonSchema.exclusiveMaximum) && Intrinsics.areEqual(this.minimum, jsonSchema.minimum) && Intrinsics.areEqual(this.exclusiveMinimum, jsonSchema.exclusiveMinimum) && Intrinsics.areEqual(this.maxLength, jsonSchema.maxLength) && Intrinsics.areEqual(this.minLength, jsonSchema.minLength) && Intrinsics.areEqual(this.pattern, jsonSchema.pattern) && Intrinsics.areEqual(this.maxItems, jsonSchema.maxItems) && Intrinsics.areEqual(this.minItems, jsonSchema.minItems) && Intrinsics.areEqual(this.uniqueItems, jsonSchema.uniqueItems) && Intrinsics.areEqual(this.enum, jsonSchema.enum) && Intrinsics.areEqual(this.const, jsonSchema.const) && Intrinsics.areEqual(this.multipleOf, jsonSchema.multipleOf) && Intrinsics.areEqual(this.id, jsonSchema.id) && Intrinsics.areEqual(this.anchor, jsonSchema.anchor) && Intrinsics.areEqual(this.dynamicAnchor, jsonSchema.dynamicAnchor);
    }

    public final AdditionalProperties getAdditionalProperties() {
        return this.additionalProperties;
    }

    public final List<ReferenceOr<JsonSchema>> getAllOf() {
        return this.allOf;
    }

    public final String getAnchor() {
        return this.anchor;
    }

    public final List<ReferenceOr<JsonSchema>> getAnyOf() {
        return this.anyOf;
    }

    public final GenericElement getConst() {
        return this.const;
    }

    public final GenericElement getDefault() {
        return this.default;
    }

    public final Boolean getDeprecated() {
        return this.deprecated;
    }

    public final String getDescription() {
        return this.description;
    }

    public final JsonSchemaDiscriminator getDiscriminator() {
        return this.discriminator;
    }

    public final Boolean getDynamicAnchor() {
        return this.dynamicAnchor;
    }

    public final List<GenericElement> getEnum() {
        return this.enum;
    }

    public final GenericElement getExample() {
        return this.example;
    }

    public final List<GenericElement> getExamples() {
        return this.examples;
    }

    public final Double getExclusiveMaximum() {
        return this.exclusiveMaximum;
    }

    public final Double getExclusiveMinimum() {
        return this.exclusiveMinimum;
    }

    public final ExternalDocs getExternalDocs() {
        return this.externalDocs;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getId() {
        return this.id;
    }

    public final ReferenceOr<JsonSchema> getItems() {
        return this.items;
    }

    public final Integer getMaxItems() {
        return this.maxItems;
    }

    public final Integer getMaxLength() {
        return this.maxLength;
    }

    public final Integer getMaxProperties() {
        return this.maxProperties;
    }

    public final Double getMaximum() {
        return this.maximum;
    }

    public final Integer getMinItems() {
        return this.minItems;
    }

    public final Integer getMinLength() {
        return this.minLength;
    }

    public final Integer getMinProperties() {
        return this.minProperties;
    }

    public final Double getMinimum() {
        return this.minimum;
    }

    public final Double getMultipleOf() {
        return this.multipleOf;
    }

    public final ReferenceOr<JsonSchema> getNot() {
        return this.not;
    }

    public final List<ReferenceOr<JsonSchema>> getOneOf() {
        return this.oneOf;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final List<ReferenceOr<JsonSchema>> getPrefixItems() {
        return this.prefixItems;
    }

    public final Map<String, ReferenceOr<JsonSchema>> getProperties() {
        return this.properties;
    }

    public final Boolean getReadOnly() {
        return this.readOnly;
    }

    public final List<String> getRequired() {
        return this.required;
    }

    public final String getTitle() {
        return this.title;
    }

    public final SchemaType getType() {
        return this.type;
    }

    public final Boolean getUniqueItems() {
        return this.uniqueItems;
    }

    public final Boolean getWriteOnly() {
        return this.writeOnly;
    }

    public final Xml getXml() {
        return this.xml;
    }

    public int hashCode() {
        SchemaType schemaType = this.type;
        int iHashCode = (schemaType == null ? 0 : schemaType.hashCode()) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.required;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<ReferenceOr<JsonSchema>> list2 = this.allOf;
        int iHashCode5 = (iHashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<ReferenceOr<JsonSchema>> list3 = this.oneOf;
        int iHashCode6 = (iHashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        ReferenceOr<JsonSchema> referenceOr = this.not;
        int iHashCode7 = (iHashCode6 + (referenceOr == null ? 0 : referenceOr.hashCode())) * 31;
        List<ReferenceOr<JsonSchema>> list4 = this.anyOf;
        int iHashCode8 = (iHashCode7 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Map<String, ReferenceOr<JsonSchema>> map = this.properties;
        int iHashCode9 = (iHashCode8 + (map == null ? 0 : map.hashCode())) * 31;
        AdditionalProperties additionalProperties = this.additionalProperties;
        int iHashCode10 = (iHashCode9 + (additionalProperties == null ? 0 : additionalProperties.hashCode())) * 31;
        JsonSchemaDiscriminator jsonSchemaDiscriminator = this.discriminator;
        int iHashCode11 = (iHashCode10 + (jsonSchemaDiscriminator == null ? 0 : jsonSchemaDiscriminator.hashCode())) * 31;
        Boolean bool = this.readOnly;
        int iHashCode12 = (iHashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.writeOnly;
        int iHashCode13 = (iHashCode12 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Xml xml = this.xml;
        int iHashCode14 = (iHashCode13 + (xml == null ? 0 : xml.hashCode())) * 31;
        ExternalDocs externalDocs = this.externalDocs;
        int iHashCode15 = (iHashCode14 + (externalDocs == null ? 0 : externalDocs.hashCode())) * 31;
        GenericElement genericElement = this.example;
        int iHashCode16 = (iHashCode15 + (genericElement == null ? 0 : genericElement.hashCode())) * 31;
        List<GenericElement> list5 = this.examples;
        int iHashCode17 = (iHashCode16 + (list5 == null ? 0 : list5.hashCode())) * 31;
        Boolean bool3 = this.deprecated;
        int iHashCode18 = (iHashCode17 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num = this.maxProperties;
        int iHashCode19 = (iHashCode18 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.minProperties;
        int iHashCode20 = (iHashCode19 + (num2 == null ? 0 : num2.hashCode())) * 31;
        GenericElement genericElement2 = this.default;
        int iHashCode21 = (iHashCode20 + (genericElement2 == null ? 0 : genericElement2.hashCode())) * 31;
        String str3 = this.format;
        int iHashCode22 = (iHashCode21 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ReferenceOr<JsonSchema> referenceOr2 = this.items;
        int iHashCode23 = (iHashCode22 + (referenceOr2 == null ? 0 : referenceOr2.hashCode())) * 31;
        List<ReferenceOr<JsonSchema>> list6 = this.prefixItems;
        int iHashCode24 = (iHashCode23 + (list6 == null ? 0 : list6.hashCode())) * 31;
        Double d = this.maximum;
        int iHashCode25 = (iHashCode24 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.exclusiveMaximum;
        int iHashCode26 = (iHashCode25 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.minimum;
        int iHashCode27 = (iHashCode26 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.exclusiveMinimum;
        int iHashCode28 = (iHashCode27 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Integer num3 = this.maxLength;
        int iHashCode29 = (iHashCode28 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.minLength;
        int iHashCode30 = (iHashCode29 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str4 = this.pattern;
        int iHashCode31 = (iHashCode30 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num5 = this.maxItems;
        int iHashCode32 = (iHashCode31 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.minItems;
        int iHashCode33 = (iHashCode32 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Boolean bool4 = this.uniqueItems;
        int iHashCode34 = (iHashCode33 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        List<GenericElement> list7 = this.enum;
        int iHashCode35 = (iHashCode34 + (list7 == null ? 0 : list7.hashCode())) * 31;
        GenericElement genericElement3 = this.const;
        int iHashCode36 = (iHashCode35 + (genericElement3 == null ? 0 : genericElement3.hashCode())) * 31;
        Double d5 = this.multipleOf;
        int iHashCode37 = (iHashCode36 + (d5 == null ? 0 : d5.hashCode())) * 31;
        String str5 = this.id;
        int iHashCode38 = (iHashCode37 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.anchor;
        int iHashCode39 = (iHashCode38 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool5 = this.dynamicAnchor;
        return iHashCode39 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public String toString() {
        return "JsonSchema(type=" + this.type + ", title=" + this.title + ", description=" + this.description + ", required=" + this.required + ", allOf=" + this.allOf + ", oneOf=" + this.oneOf + ", not=" + this.not + ", anyOf=" + this.anyOf + ", properties=" + this.properties + ", additionalProperties=" + this.additionalProperties + ", discriminator=" + this.discriminator + ", readOnly=" + this.readOnly + ", writeOnly=" + this.writeOnly + ", xml=" + this.xml + ", externalDocs=" + this.externalDocs + ", example=" + this.example + ", examples=" + this.examples + ", deprecated=" + this.deprecated + ", maxProperties=" + this.maxProperties + ", minProperties=" + this.minProperties + ", default=" + this.default + ", format=" + this.format + ", items=" + this.items + ", prefixItems=" + this.prefixItems + ", maximum=" + this.maximum + ", exclusiveMaximum=" + this.exclusiveMaximum + ", minimum=" + this.minimum + ", exclusiveMinimum=" + this.exclusiveMinimum + ", maxLength=" + this.maxLength + ", minLength=" + this.minLength + ", pattern=" + this.pattern + ", maxItems=" + this.maxItems + ", minItems=" + this.minItems + ", uniqueItems=" + this.uniqueItems + ", enum=" + this.enum + ", const=" + this.const + ", multipleOf=" + this.multipleOf + ", id=" + this.id + ", anchor=" + this.anchor + ", dynamicAnchor=" + this.dynamicAnchor + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002\u0082\u0001\u0002\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lio/ktor/openapi/JsonSchema$SchemaType;", "", "Companion", "AnyOf", "Serializer", "JsonTypeSerializer", "Lio/ktor/openapi/JsonSchema$SchemaType$AnyOf;", "Lio/ktor/openapi/JsonType;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    public interface SchemaType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchema$SchemaType$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/JsonSchema$SchemaType;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer serializer() {
                return Serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/openapi/JsonSchema$SchemaType$JsonTypeSerializer;", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/JsonType;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/JsonType;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/JsonType;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class JsonTypeSerializer implements KSerializer {
            public static final JsonTypeSerializer INSTANCE = new JsonTypeSerializer();
            private static final SerialDescriptor descriptor = StringsKt__IndentKt.PrimitiveSerialDescriptor("JsonType");

            private JsonTypeSerializer() {
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public JsonType deserialize(Decoder decoder) {
                decoder.getClass();
                String upperCase = decoder.decodeString().toUpperCase(Locale.ROOT);
                upperCase.getClass();
                return JsonType.valueOf(upperCase);
            }

            @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public void serialize(Encoder encoder, JsonType value) {
                encoder.getClass();
                value.getClass();
                String lowerCase = value.name().toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                encoder.encodeString(lowerCase);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&%B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0007HÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u00020\u0017HÖ\u0081\u0004¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010\r¨\u0006'"}, d2 = {"Lio/ktor/openapi/JsonSchema$SchemaType$AnyOf;", "Lio/ktor/openapi/JsonSchema$SchemaType;", "", "Lio/ktor/openapi/JsonType;", "types", "<init>", "(Ljava/util/List;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Lio/ktor/openapi/JsonSchema$SchemaType$AnyOf;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/JsonSchema$SchemaType$AnyOf;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/List;", "getTypes", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final /* data */ class AnyOf implements SchemaType {
            private final List<JsonType> types;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Link$$ExternalSyntheticLambda0(3))};

            public /* synthetic */ AnyOf(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 == (i & 1)) {
                    this.types = list;
                } else {
                    EnumsKt.throwMissingFieldException(JsonSchema$SchemaType$AnyOf$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new HashSetSerializer(JsonTypeSerializer.INSTANCE, (byte) 1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ AnyOf copy$default(AnyOf anyOf, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = anyOf.types;
                }
                return anyOf.copy(list);
            }

            public final List<JsonType> component1() {
                return this.types;
            }

            public final AnyOf copy(List<? extends JsonType> types) {
                types.getClass();
                return new AnyOf(types);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AnyOf) && Intrinsics.areEqual(this.types, ((AnyOf) other).types);
            }

            public final List<JsonType> getTypes() {
                return this.types;
            }

            public int hashCode() {
                return this.types.hashCode();
            }

            public String toString() {
                return "AnyOf(types=" + this.types + ')';
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchema$SchemaType$AnyOf$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/JsonSchema$SchemaType$AnyOf;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer serializer() {
                    return JsonSchema$SchemaType$AnyOf$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnyOf(List<? extends JsonType> list) {
                list.getClass();
                this.types = list;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0084\b¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/openapi/JsonSchema$SchemaType$Serializer;", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/JsonSchema$SchemaType;", "<init>", "()V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/JsonSchema$SchemaType;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/JsonSchema$SchemaType;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer implements KSerializer {
            public static final Serializer INSTANCE = new Serializer();
            private static final SerialDescriptor descriptor = StringsKt__IndentKt.buildSerialDescriptor$default("io.ktor.openapi.Schema.SchemaType", SerialKind$CONTEXTUAL.INSTANCE, new SerialDescriptor[0]);

            private Serializer() {
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public SchemaType deserialize(Decoder decoder) {
                decoder.getClass();
                decoder.getSerializersModule();
                GenericElement genericElement = (GenericElement) decoder.decodeSerializableValue(GenericElement.INSTANCE.serializer());
                if (!genericElement.isArray()) {
                    return (SchemaType) genericElement.deserialize(JsonTypeSerializer.INSTANCE);
                }
                JsonTypeSerializer jsonTypeSerializer = JsonTypeSerializer.INSTANCE;
                jsonTypeSerializer.getClass();
                return new AnyOf((List) genericElement.deserialize(new HashSetSerializer(jsonTypeSerializer, (byte) 1)));
            }

            @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public void serialize(Encoder encoder, SchemaType value) {
                encoder.getClass();
                value.getClass();
                if (!(value instanceof AnyOf)) {
                    if (!(value instanceof JsonType)) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return;
                    }
                    String lowerCase = ((JsonType) value).name().toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    encoder.encodeString(lowerCase);
                    return;
                }
                SerializationStrategy hashSetSerializer = new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
                List<JsonType> types = ((AnyOf) value).getTypes();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(types, 10));
                Iterator<T> it = types.iterator();
                while (it.hasNext()) {
                    String lowerCase2 = ((JsonType) it.next()).name().toLowerCase(Locale.ROOT);
                    lowerCase2.getClass();
                    arrayList.add(lowerCase2);
                }
                encoder.encodeSerializableValue(hashSetSerializer, arrayList);
            }

            public static /* synthetic */ void getDescriptor$annotations() {
            }
        }
    }

    public JsonSchema(int i, int i2, SchemaType schemaType, String str, String str2, List list, List list2, List list3, ReferenceOr referenceOr, List list4, Map map, AdditionalProperties additionalProperties, JsonSchemaDiscriminator jsonSchemaDiscriminator, Boolean bool, Boolean bool2, Xml xml, ExternalDocs externalDocs, GenericElement genericElement, List list5, Boolean bool3, Integer num, Integer num2, GenericElement genericElement2, String str3, ReferenceOr referenceOr2, List list6, Double d, Double d2, Double d3, Double d4, Integer num3, Integer num4, String str4, Integer num5, Integer num6, Boolean bool4, List list7, GenericElement genericElement3, Double d5, String str5, String str6, Boolean bool5, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.type = null;
        } else {
            this.type = schemaType;
        }
        if ((i & 2) == 0) {
            this.title = null;
        } else {
            this.title = str;
        }
        if ((i & 4) == 0) {
            this.description = null;
        } else {
            this.description = str2;
        }
        if ((i & 8) == 0) {
            this.required = null;
        } else {
            this.required = list;
        }
        if ((i & 16) == 0) {
            this.allOf = null;
        } else {
            this.allOf = list2;
        }
        if ((i & 32) == 0) {
            this.oneOf = null;
        } else {
            this.oneOf = list3;
        }
        if ((i & 64) == 0) {
            this.not = null;
        } else {
            this.not = referenceOr;
        }
        if ((i & 128) == 0) {
            this.anyOf = null;
        } else {
            this.anyOf = list4;
        }
        if ((i & 256) == 0) {
            this.properties = null;
        } else {
            this.properties = map;
        }
        if ((i & 512) == 0) {
            this.additionalProperties = null;
        } else {
            this.additionalProperties = additionalProperties;
        }
        if ((i & 1024) == 0) {
            this.discriminator = null;
        } else {
            this.discriminator = jsonSchemaDiscriminator;
        }
        if ((i & 2048) == 0) {
            this.readOnly = null;
        } else {
            this.readOnly = bool;
        }
        if ((i & 4096) == 0) {
            this.writeOnly = null;
        } else {
            this.writeOnly = bool2;
        }
        if ((i & 8192) == 0) {
            this.xml = null;
        } else {
            this.xml = xml;
        }
        if ((i & 16384) == 0) {
            this.externalDocs = null;
        } else {
            this.externalDocs = externalDocs;
        }
        if ((32768 & i) == 0) {
            this.example = null;
        } else {
            this.example = genericElement;
        }
        if ((65536 & i) == 0) {
            this.examples = null;
        } else {
            this.examples = list5;
        }
        if ((131072 & i) == 0) {
            this.deprecated = null;
        } else {
            this.deprecated = bool3;
        }
        if ((262144 & i) == 0) {
            this.maxProperties = null;
        } else {
            this.maxProperties = num;
        }
        if ((524288 & i) == 0) {
            this.minProperties = null;
        } else {
            this.minProperties = num2;
        }
        if ((1048576 & i) == 0) {
            this.default = null;
        } else {
            this.default = genericElement2;
        }
        if ((2097152 & i) == 0) {
            this.format = null;
        } else {
            this.format = str3;
        }
        if ((4194304 & i) == 0) {
            this.items = null;
        } else {
            this.items = referenceOr2;
        }
        if ((8388608 & i) == 0) {
            this.prefixItems = null;
        } else {
            this.prefixItems = list6;
        }
        if ((16777216 & i) == 0) {
            this.maximum = null;
        } else {
            this.maximum = d;
        }
        if ((33554432 & i) == 0) {
            this.exclusiveMaximum = null;
        } else {
            this.exclusiveMaximum = d2;
        }
        if ((67108864 & i) == 0) {
            this.minimum = null;
        } else {
            this.minimum = d3;
        }
        if ((134217728 & i) == 0) {
            this.exclusiveMinimum = null;
        } else {
            this.exclusiveMinimum = d4;
        }
        if ((268435456 & i) == 0) {
            this.maxLength = null;
        } else {
            this.maxLength = num3;
        }
        if ((536870912 & i) == 0) {
            this.minLength = null;
        } else {
            this.minLength = num4;
        }
        if ((1073741824 & i) == 0) {
            this.pattern = null;
        } else {
            this.pattern = str4;
        }
        if ((i & Integer.MIN_VALUE) == 0) {
            this.maxItems = null;
        } else {
            this.maxItems = num5;
        }
        if ((i2 & 1) == 0) {
            this.minItems = null;
        } else {
            this.minItems = num6;
        }
        if ((i2 & 2) == 0) {
            this.uniqueItems = null;
        } else {
            this.uniqueItems = bool4;
        }
        if ((i2 & 4) == 0) {
            this.enum = null;
        } else {
            this.enum = list7;
        }
        if ((i2 & 8) == 0) {
            this.const = null;
        } else {
            this.const = genericElement3;
        }
        if ((i2 & 16) == 0) {
            this.multipleOf = null;
        } else {
            this.multipleOf = d5;
        }
        if ((i2 & 32) == 0) {
            this.id = null;
        } else {
            this.id = str5;
        }
        if ((i2 & 64) == 0) {
            this.anchor = null;
        } else {
            this.anchor = str6;
        }
        if ((i2 & 128) == 0) {
            this.dynamicAnchor = null;
        } else {
            this.dynamicAnchor = bool5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonSchema(SchemaType schemaType, String str, String str2, List<String> list, List<? extends ReferenceOr<JsonSchema>> list2, List<? extends ReferenceOr<JsonSchema>> list3, ReferenceOr<JsonSchema> referenceOr, List<? extends ReferenceOr<JsonSchema>> list4, Map<String, ? extends ReferenceOr<JsonSchema>> map, AdditionalProperties additionalProperties, JsonSchemaDiscriminator jsonSchemaDiscriminator, Boolean bool, Boolean bool2, Xml xml, ExternalDocs externalDocs, GenericElement genericElement, List<? extends GenericElement> list5, Boolean bool3, Integer num, Integer num2, GenericElement genericElement2, String str3, ReferenceOr<JsonSchema> referenceOr2, List<? extends ReferenceOr<JsonSchema>> list6, Double d, Double d2, Double d3, Double d4, Integer num3, Integer num4, String str4, Integer num5, Integer num6, Boolean bool4, List<? extends GenericElement> list7, GenericElement genericElement3, Double d5, String str5, String str6, Boolean bool5) {
        this.type = schemaType;
        this.title = str;
        this.description = str2;
        this.required = list;
        this.allOf = list2;
        this.oneOf = list3;
        this.not = referenceOr;
        this.anyOf = list4;
        this.properties = map;
        this.additionalProperties = additionalProperties;
        this.discriminator = jsonSchemaDiscriminator;
        this.readOnly = bool;
        this.writeOnly = bool2;
        this.xml = xml;
        this.externalDocs = externalDocs;
        this.example = genericElement;
        this.examples = list5;
        this.deprecated = bool3;
        this.maxProperties = num;
        this.minProperties = num2;
        this.default = genericElement2;
        this.format = str3;
        this.items = referenceOr2;
        this.prefixItems = list6;
        this.maximum = d;
        this.exclusiveMaximum = d2;
        this.minimum = d3;
        this.exclusiveMinimum = d4;
        this.maxLength = num3;
        this.minLength = num4;
        this.pattern = str4;
        this.maxItems = num5;
        this.minItems = num6;
        this.uniqueItems = bool4;
        this.enum = list7;
        this.const = genericElement3;
        this.multipleOf = d5;
        this.id = str5;
        this.anchor = str6;
        this.dynamicAnchor = bool5;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchema$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/JsonSchema;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return JsonSchema$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\u00020\u0004B\u0004\b\u0007\u0010\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\bR\u0011\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/openapi/JsonSchema$Maximum;", "", "", "value", "", "exclusive", "<init>", "(DZ)V", "()D", "()Z", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Maximum {
        boolean exclusive() default false;

        double value();

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Maximum {
            private final /* synthetic */ boolean exclusive;
            private final /* synthetic */ double value;

            public /* synthetic */ Impl(double d, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(d, (i & 2) != 0 ? false : z);
            }

            @Override // io.ktor.openapi.JsonSchema.Maximum
            public final /* synthetic */ boolean exclusive() {
                return this.exclusive;
            }

            @Override // io.ktor.openapi.JsonSchema.Maximum
            public final /* synthetic */ double value() {
                return this.value;
            }

            public Impl(double d, boolean z) {
                this.value = d;
                this.exclusive = z;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\u00020\u0004B\u0004\b\u0007\u0010\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\bR\u0011\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/openapi/JsonSchema$Minimum;", "", "", "value", "", "exclusive", "<init>", "(DZ)V", "()D", "()Z", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Minimum {
        boolean exclusive() default false;

        double value();

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Minimum {
            private final /* synthetic */ boolean exclusive;
            private final /* synthetic */ double value;

            public /* synthetic */ Impl(double d, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(d, (i & 2) != 0 ? false : z);
            }

            @Override // io.ktor.openapi.JsonSchema.Minimum
            public final /* synthetic */ boolean exclusive() {
                return this.exclusive;
            }

            @Override // io.ktor.openapi.JsonSchema.Minimum
            public final /* synthetic */ double value() {
                return this.value;
            }

            public Impl(double d, boolean z) {
                this.value = d;
                this.exclusive = z;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\u00020\u0004B\u0004\b\u0007\u0010\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\bR\u0011\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/openapi/JsonSchema$Anchor;", "", "", "value", "", "dynamic", "<init>", "(Ljava/lang/String;Z)V", "()Ljava/lang/String;", "()Z", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Anchor {
        boolean dynamic() default false;

        String value();

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class Impl implements Anchor {
            private final /* synthetic */ boolean dynamic;
            private final /* synthetic */ String value;

            public Impl(String str, boolean z) {
                str.getClass();
                this.value = str;
                this.dynamic = z;
            }

            @Override // io.ktor.openapi.JsonSchema.Anchor
            public final /* synthetic */ boolean dynamic() {
                return this.dynamic;
            }

            @Override // io.ktor.openapi.JsonSchema.Anchor
            public final /* synthetic */ String value() {
                return this.value;
            }

            public /* synthetic */ Impl(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? false : z);
            }
        }
    }

    public static /* synthetic */ void getAnchor$annotations() {
    }

    public static /* synthetic */ void getDynamicAnchor$annotations() {
    }

    public static /* synthetic */ void getId$annotations() {
    }

    public JsonSchema() {
        this((SchemaType) null, (String) null, (String) null, (List) null, (List) null, (List) null, (ReferenceOr) null, (List) null, (Map) null, (AdditionalProperties) null, (JsonSchemaDiscriminator) null, (Boolean) null, (Boolean) null, (Xml) null, (ExternalDocs) null, (GenericElement) null, (List) null, (Boolean) null, (Integer) null, (Integer) null, (GenericElement) null, (String) null, (ReferenceOr) null, (List) null, (Double) null, (Double) null, (Double) null, (Double) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Boolean) null, (List) null, (GenericElement) null, (Double) null, (String) null, (String) null, (Boolean) null, -1, 255, (DefaultConstructorMarker) null);
    }
}
