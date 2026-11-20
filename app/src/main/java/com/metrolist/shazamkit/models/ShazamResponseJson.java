package com.metrolist.shazamkit.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0005@ABCDBW\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fB_\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J^\u00100\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00101J\u0014\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u00020\u0011HÖ\u0081\u0004J\n\u00106\u001a\u00020\nHÖ\u0081\u0004J)\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001b\u0002\b?¢\u0006\u0002\b>R4\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R,\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR.\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0007¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010 R,\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\t¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010$R,\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u000b¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010'R,\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\r¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010$Ê\u0001\u0002\bFÊ\u0001\f\bG\u0012\b\bH\u0012\u0004\b\u0003\u0010\u0002¨\u0006E"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson;", "", "matches", "", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Match;", "location", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Location;", "timestamp", "", "timezone", "", "track", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track;", "tagid", "<init>", "(Ljava/util/List;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Location;Ljava/lang/Long;Ljava/lang/String;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Location;Ljava/lang/Long;Ljava/lang/String;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMatches$annotations", "()V", "getMatches", "()Ljava/util/List;", "Lkotlinx/serialization/SerialName;", "value", "getLocation$annotations", "getLocation", "()Lcom/metrolist/shazamkit/models/ShazamResponseJson$Location;", "getTimestamp$annotations", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimezone$annotations", "getTimezone", "()Ljava/lang/String;", "getTrack$annotations", "getTrack", "()Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track;", "getTagid$annotations", "getTagid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Location;Ljava/lang/Long;Ljava/lang/String;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track;Ljava/lang/String;)Lcom/metrolist/shazamkit/models/ShazamResponseJson;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "Match", HttpHeaders.Location, "Track", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ShazamResponseJson {
    public static final int $stable = 0;
    private final Location location;
    private final List<Match> matches;
    private final String tagid;
    private final Long timestamp;
    private final String timezone;
    private final Track track;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Shazam$$ExternalSyntheticLambda0(6)), null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 l2\u00020\u0001:\befghijklBË\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aBÁ\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0019\u0010\u001fJ\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0013\u0010O\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u000fHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÍ\u0001\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010Z\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010[\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0001b\u0002\bd¢\u0006\u0002\bcR,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010!\u001a\u0004\b'\u0010#R,\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010!\u001a\u0004\b)\u0010#R,\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010!\u001a\u0004\b+\u0010#R,\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010#R,\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\b¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010!\u001a\u0004\b/\u00100R,\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\n¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010!\u001a\u0004\b2\u00103R,\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\f¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010!\u001a\u0004\b5\u00106R4\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010!\u001a\u0004\b8\u00109R,\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0011¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010!\u001a\u0004\b;\u0010#R4\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u000f8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0012¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010!\u001a\u0004\b=\u00109R,\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010!\u001a\u0004\b?\u0010#R,\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0015¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010!\u001a\u0004\bA\u0010BR,\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0017¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010!\u001a\u0004\bD\u0010#R,\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0018¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010!\u001a\u0004\bF\u0010#Ê\u0001\u0002\bnÊ\u0001\f\bo\u0012\b\bp\u0012\u0004\b\u0003\u0010\u0002¨\u0006m"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track;", "", "layout", "", LinkHeader.Parameters.Type, "key", LinkHeader.Parameters.Title, "subtitle", "images", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Images;", "share", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Share;", "hub", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub;", "sections", "", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section;", "url", "artists", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Artist;", "isrc", "genres", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Genres;", "relatedtracksurl", "albumadamid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Images;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Share;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Genres;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Images;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Share;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Genres;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLayout$annotations", "()V", "getLayout", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getType$annotations", "getType", "getKey$annotations", "getKey", "getTitle$annotations", "getTitle", "getSubtitle$annotations", "getSubtitle", "getImages$annotations", "getImages", "()Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Images;", "getShare$annotations", "getShare", "()Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Share;", "getHub$annotations", "getHub", "()Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub;", "getSections$annotations", "getSections", "()Ljava/util/List;", "getUrl$annotations", "getUrl", "getArtists$annotations", "getArtists", "getIsrc$annotations", "getIsrc", "getGenres$annotations", "getGenres", "()Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Genres;", "getRelatedtracksurl$annotations", "getRelatedtracksurl", "getAlbumadamid$annotations", "getAlbumadamid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "Images", "Share", "Hub", "Section", "Artist", "Genres", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Track {
        private static final Lazy[] $childSerializers;
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String albumadamid;
        private final List<Artist> artists;
        private final Genres genres;
        private final Hub hub;
        private final Images images;
        private final String isrc;
        private final String key;
        private final String layout;
        private final String relatedtracksurl;
        private final List<Section> sections;
        private final Share share;
        private final String subtitle;
        private final String title;
        private final String type;
        private final String url;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0005ABCDEBs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010By\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006HÆ\u0003J\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00062\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00103J\u0014\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u00020\u0012HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0003HÖ\u0081\u0004J)\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001b\u0002\b@¢\u0006\u0002\b?R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R4\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010 R4\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\b¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010 R4\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\n¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010 R.\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\f¢\u0006\u0010\n\u0002\u0010(\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010'R,\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019Ê\u0001\u0002\bGÊ\u0001\f\bH\u0012\b\bI\u0012\u0004\b\u0003\u0010\u0002¨\u0006F"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub;", "", LinkHeader.Parameters.Type, "", ContentType.Image.TYPE, "actions", "", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Action;", "options", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option;", "providers", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider;", "explicit", "", "displayname", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType$annotations", "()V", "getType", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getImage$annotations", "getImage", "getActions$annotations", "getActions", "()Ljava/util/List;", "getOptions$annotations", "getOptions", "getProviders$annotations", "getProviders", "getExplicit$annotations", "getExplicit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisplayname$annotations", "getDisplayname", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "Action", "Option", "Provider", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Hub {
            private static final Lazy[] $childSerializers;
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final List<Action> actions;
            private final String displayname;
            private final Boolean explicit;
            private final String image;
            private final List<Option> options;
            private final List<Provider> providers;
            private final String type;

            static {
                Shazam$$ExternalSyntheticLambda0 shazam$$ExternalSyntheticLambda0 = new Shazam$$ExternalSyntheticLambda0((byte) 9);
                LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
                $childSerializers = new Lazy[]{null, null, ResultKt.lazy(lazyThreadSafetyMode, shazam$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Shazam$$ExternalSyntheticLambda0((byte) 10)), ResultKt.lazy(lazyThreadSafetyMode, new Shazam$$ExternalSyntheticLambda0((byte) 11)), null, null};
            }

            public /* synthetic */ Hub(int i, String str, String str2, List list, List list2, List list3, Boolean bool, String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.type = null;
                } else {
                    this.type = str;
                }
                if ((i & 2) == 0) {
                    this.image = null;
                } else {
                    this.image = str2;
                }
                if ((i & 4) == 0) {
                    this.actions = null;
                } else {
                    this.actions = list;
                }
                if ((i & 8) == 0) {
                    this.options = null;
                } else {
                    this.options = list2;
                }
                if ((i & 16) == 0) {
                    this.providers = null;
                } else {
                    this.providers = list3;
                }
                if ((i & 32) == 0) {
                    this.explicit = null;
                } else {
                    this.explicit = bool;
                }
                if ((i & 64) == 0) {
                    this.displayname = null;
                } else {
                    this.displayname = str3;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Track$Hub$Action$$serializer.INSTANCE), (byte) 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Track$Hub$Option$$serializer.INSTANCE), (byte) 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Track$Hub$Provider$$serializer.INSTANCE), (byte) 1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Hub copy$default(Hub hub, String str, String str2, List list, List list2, List list3, Boolean bool, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = hub.type;
                }
                if ((i & 2) != 0) {
                    str2 = hub.image;
                }
                if ((i & 4) != 0) {
                    list = hub.actions;
                }
                if ((i & 8) != 0) {
                    list2 = hub.options;
                }
                if ((i & 16) != 0) {
                    list3 = hub.providers;
                }
                if ((i & 32) != 0) {
                    bool = hub.explicit;
                }
                if ((i & 64) != 0) {
                    str3 = hub.displayname;
                }
                Boolean bool2 = bool;
                String str4 = str3;
                List list4 = list3;
                List list5 = list;
                return hub.copy(str, str2, list5, list2, list4, bool2, str4);
            }

            public static final /* synthetic */ void write$Self$app(Hub self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.type);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.image != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.image);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.actions != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.actions);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.options != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.options);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.providers != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.providers);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.explicit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.explicit);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.displayname == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.displayname);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getType() {
                return this.type;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getImage() {
                return this.image;
            }

            public final List<Action> component3() {
                return this.actions;
            }

            public final List<Option> component4() {
                return this.options;
            }

            public final List<Provider> component5() {
                return this.providers;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final Boolean getExplicit() {
                return this.explicit;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getDisplayname() {
                return this.displayname;
            }

            public final Hub copy(String type, String image, List<Action> actions, List<Option> options, List<Provider> providers, Boolean explicit, String displayname) {
                return new Hub(type, image, actions, options, providers, explicit, displayname);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Hub)) {
                    return false;
                }
                Hub hub = (Hub) other;
                return Intrinsics.areEqual(this.type, hub.type) && Intrinsics.areEqual(this.image, hub.image) && Intrinsics.areEqual(this.actions, hub.actions) && Intrinsics.areEqual(this.options, hub.options) && Intrinsics.areEqual(this.providers, hub.providers) && Intrinsics.areEqual(this.explicit, hub.explicit) && Intrinsics.areEqual(this.displayname, hub.displayname);
            }

            public final List<Action> getActions() {
                return this.actions;
            }

            public final String getDisplayname() {
                return this.displayname;
            }

            public final Boolean getExplicit() {
                return this.explicit;
            }

            public final String getImage() {
                return this.image;
            }

            public final List<Option> getOptions() {
                return this.options;
            }

            public final List<Provider> getProviders() {
                return this.providers;
            }

            public final String getType() {
                return this.type;
            }

            public int hashCode() {
                String str = this.type;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.image;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                List<Action> list = this.actions;
                int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
                List<Option> list2 = this.options;
                int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
                List<Provider> list3 = this.providers;
                int iHashCode5 = (iHashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
                Boolean bool = this.explicit;
                int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
                String str3 = this.displayname;
                return iHashCode6 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                String str = this.type;
                String str2 = this.image;
                List<Action> list = this.actions;
                List<Option> list2 = this.options;
                List<Provider> list3 = this.providers;
                Boolean bool = this.explicit;
                String str3 = this.displayname;
                StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Hub(type=", str, ", image=", str2, ", actions=");
                sbM.append(list);
                sbM.append(", options=");
                sbM.append(list2);
                sbM.append(", providers=");
                sbM.append(list3);
                sbM.append(", explicit=");
                sbM.append(bool);
                sbM.append(", displayname=");
                return IntIntPair$$ExternalSyntheticOutline0.m(sbM, str3, ")");
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0004IJKLB{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011B}\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0082\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010;J\u0014\u0010<\u001a\u00020\u000e2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010>\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010?\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0001b\u0002\bH¢\u0006\u0002\bGR,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR4\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR,\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"R,\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\t¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR,\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\n¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001aR,\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000b¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001aR,\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\f¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010\u001aR.\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\r¢\u0006\u0010\n\u0002\u0010.\u0012\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010-R,\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000f¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u001aÊ\u0001\u0002\bNÊ\u0001\f\bO\u0012\b\bP\u0012\u0004\b\u0003\u0010\u0000¨\u0006M"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option;", "", "caption", "", "actions", "", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$OptionAction;", "beacondata", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$Beacondata;", ContentType.Image.TYPE, LinkHeader.Parameters.Type, "listcaption", "overflowimage", "colouroverflowimage", "", "providername", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$Beacondata;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$Beacondata;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCaption$annotations", "()V", "getCaption", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getActions$annotations", "getActions", "()Ljava/util/List;", "getBeacondata$annotations", "getBeacondata", "()Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$Beacondata;", "getImage$annotations", "getImage", "getType$annotations", "getType", "getListcaption$annotations", "getListcaption", "getOverflowimage$annotations", "getOverflowimage", "getColouroverflowimage$annotations", "getColouroverflowimage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProvidername$annotations", "getProvidername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$Beacondata;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "OptionAction", "Beacondata", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Option {
                private final List<OptionAction> actions;
                private final Beacondata beacondata;
                private final String caption;
                private final Boolean colouroverflowimage;
                private final String image;
                private final String listcaption;
                private final String overflowimage;
                private final String providername;
                private final String type;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Shazam$$ExternalSyntheticLambda0(12)), null, null, null, null, null, null, null};

                public /* synthetic */ Option(int i, String str, List list, Beacondata beacondata, String str2, String str3, String str4, String str5, Boolean bool, String str6, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((i & 1) == 0) {
                        this.caption = null;
                    } else {
                        this.caption = str;
                    }
                    if ((i & 2) == 0) {
                        this.actions = null;
                    } else {
                        this.actions = list;
                    }
                    if ((i & 4) == 0) {
                        this.beacondata = null;
                    } else {
                        this.beacondata = beacondata;
                    }
                    if ((i & 8) == 0) {
                        this.image = null;
                    } else {
                        this.image = str2;
                    }
                    if ((i & 16) == 0) {
                        this.type = null;
                    } else {
                        this.type = str3;
                    }
                    if ((i & 32) == 0) {
                        this.listcaption = null;
                    } else {
                        this.listcaption = str4;
                    }
                    if ((i & 64) == 0) {
                        this.overflowimage = null;
                    } else {
                        this.overflowimage = str5;
                    }
                    if ((i & 128) == 0) {
                        this.colouroverflowimage = null;
                    } else {
                        this.colouroverflowimage = bool;
                    }
                    if ((i & 256) == 0) {
                        this.providername = null;
                    } else {
                        this.providername = str6;
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Track$Hub$Option$OptionAction$$serializer.INSTANCE), (byte) 1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Option copy$default(Option option, String str, List list, Beacondata beacondata, String str2, String str3, String str4, String str5, Boolean bool, String str6, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = option.caption;
                    }
                    if ((i & 2) != 0) {
                        list = option.actions;
                    }
                    if ((i & 4) != 0) {
                        beacondata = option.beacondata;
                    }
                    if ((i & 8) != 0) {
                        str2 = option.image;
                    }
                    if ((i & 16) != 0) {
                        str3 = option.type;
                    }
                    if ((i & 32) != 0) {
                        str4 = option.listcaption;
                    }
                    if ((i & 64) != 0) {
                        str5 = option.overflowimage;
                    }
                    if ((i & 128) != 0) {
                        bool = option.colouroverflowimage;
                    }
                    if ((i & 256) != 0) {
                        str6 = option.providername;
                    }
                    Boolean bool2 = bool;
                    String str7 = str6;
                    String str8 = str4;
                    String str9 = str5;
                    String str10 = str3;
                    Beacondata beacondata2 = beacondata;
                    return option.copy(str, list, beacondata2, str2, str10, str8, str9, bool2, str7);
                }

                public static final /* synthetic */ void write$Self$app(Option self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.caption != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.caption);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.actions != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.actions);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.beacondata != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, ShazamResponseJson$Track$Hub$Option$Beacondata$$serializer.INSTANCE, self.beacondata);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.image != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.image);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.type != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.type);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.listcaption != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.listcaption);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.overflowimage != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.overflowimage);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.colouroverflowimage != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.colouroverflowimage);
                    }
                    if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.providername == null) {
                        return;
                    }
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.providername);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getCaption() {
                    return this.caption;
                }

                public final List<OptionAction> component2() {
                    return this.actions;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final Beacondata getBeacondata() {
                    return this.beacondata;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final String getImage() {
                    return this.image;
                }

                /* JADX INFO: renamed from: component5, reason: from getter */
                public final String getType() {
                    return this.type;
                }

                /* JADX INFO: renamed from: component6, reason: from getter */
                public final String getListcaption() {
                    return this.listcaption;
                }

                /* JADX INFO: renamed from: component7, reason: from getter */
                public final String getOverflowimage() {
                    return this.overflowimage;
                }

                /* JADX INFO: renamed from: component8, reason: from getter */
                public final Boolean getColouroverflowimage() {
                    return this.colouroverflowimage;
                }

                /* JADX INFO: renamed from: component9, reason: from getter */
                public final String getProvidername() {
                    return this.providername;
                }

                public final Option copy(String caption, List<OptionAction> actions, Beacondata beacondata, String image, String type, String listcaption, String overflowimage, Boolean colouroverflowimage, String providername) {
                    return new Option(caption, actions, beacondata, image, type, listcaption, overflowimage, colouroverflowimage, providername);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Option)) {
                        return false;
                    }
                    Option option = (Option) other;
                    return Intrinsics.areEqual(this.caption, option.caption) && Intrinsics.areEqual(this.actions, option.actions) && Intrinsics.areEqual(this.beacondata, option.beacondata) && Intrinsics.areEqual(this.image, option.image) && Intrinsics.areEqual(this.type, option.type) && Intrinsics.areEqual(this.listcaption, option.listcaption) && Intrinsics.areEqual(this.overflowimage, option.overflowimage) && Intrinsics.areEqual(this.colouroverflowimage, option.colouroverflowimage) && Intrinsics.areEqual(this.providername, option.providername);
                }

                public final List<OptionAction> getActions() {
                    return this.actions;
                }

                public final Beacondata getBeacondata() {
                    return this.beacondata;
                }

                public final String getCaption() {
                    return this.caption;
                }

                public final Boolean getColouroverflowimage() {
                    return this.colouroverflowimage;
                }

                public final String getImage() {
                    return this.image;
                }

                public final String getListcaption() {
                    return this.listcaption;
                }

                public final String getOverflowimage() {
                    return this.overflowimage;
                }

                public final String getProvidername() {
                    return this.providername;
                }

                public final String getType() {
                    return this.type;
                }

                public int hashCode() {
                    String str = this.caption;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    List<OptionAction> list = this.actions;
                    int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
                    Beacondata beacondata = this.beacondata;
                    int iHashCode3 = (iHashCode2 + (beacondata == null ? 0 : beacondata.hashCode())) * 31;
                    String str2 = this.image;
                    int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.type;
                    int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
                    String str4 = this.listcaption;
                    int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
                    String str5 = this.overflowimage;
                    int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
                    Boolean bool = this.colouroverflowimage;
                    int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
                    String str6 = this.providername;
                    return iHashCode8 + (str6 != null ? str6.hashCode() : 0);
                }

                public String toString() {
                    String str = this.caption;
                    List<OptionAction> list = this.actions;
                    Beacondata beacondata = this.beacondata;
                    String str2 = this.image;
                    String str3 = this.type;
                    String str4 = this.listcaption;
                    String str5 = this.overflowimage;
                    Boolean bool = this.colouroverflowimage;
                    String str6 = this.providername;
                    StringBuilder sb = new StringBuilder("Option(caption=");
                    sb.append(str);
                    sb.append(", actions=");
                    sb.append(list);
                    sb.append(", beacondata=");
                    sb.append(beacondata);
                    sb.append(", image=");
                    sb.append(str2);
                    sb.append(", type=");
                    IntIntPair$$ExternalSyntheticOutline0.m6m(sb, str3, ", listcaption=", str4, ", overflowimage=");
                    sb.append(str5);
                    sb.append(", colouroverflowimage=");
                    sb.append(bool);
                    sb.append(", providername=");
                    return IntIntPair$$ExternalSyntheticOutline0.m(sb, str6, ")");
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001b\u0002\b$¢\u0006\u0002\b#R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fÊ\u0001\u0002\b(Ê\u0001\f\b)\u0012\b\b*\u0012\u0004\b\u0003\u0010\u0002¨\u0006'"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$Beacondata;", "", LinkHeader.Parameters.Type, "", "providername", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType$annotations", "()V", "getType", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getProvidername$annotations", "getProvidername", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class Beacondata {
                    public static final int $stable = 0;

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion(null);
                    private final String providername;
                    private final String type;

                    public /* synthetic */ Beacondata(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((i & 1) == 0) {
                            this.type = null;
                        } else {
                            this.type = str;
                        }
                        if ((i & 2) == 0) {
                            this.providername = null;
                        } else {
                            this.providername = str2;
                        }
                    }

                    public static /* synthetic */ Beacondata copy$default(Beacondata beacondata, String str, String str2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = beacondata.type;
                        }
                        if ((i & 2) != 0) {
                            str2 = beacondata.providername;
                        }
                        return beacondata.copy(str, str2);
                    }

                    public static final /* synthetic */ void write$Self$app(Beacondata self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.type);
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.providername == null) {
                            return;
                        }
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.providername);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final String getType() {
                        return this.type;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final String getProvidername() {
                        return this.providername;
                    }

                    public final Beacondata copy(String type, String providername) {
                        return new Beacondata(type, providername);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Beacondata)) {
                            return false;
                        }
                        Beacondata beacondata = (Beacondata) other;
                        return Intrinsics.areEqual(this.type, beacondata.type) && Intrinsics.areEqual(this.providername, beacondata.providername);
                    }

                    public final String getProvidername() {
                        return this.providername;
                    }

                    public final String getType() {
                        return this.type;
                    }

                    public int hashCode() {
                        String str = this.type;
                        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.providername;
                        return iHashCode + (str2 != null ? str2.hashCode() : 0);
                    }

                    public String toString() {
                        return Fragment$5$$ExternalSyntheticOutline0.m("Beacondata(type=", this.type, ", providername=", this.providername, ")");
                    }

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$Beacondata$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$Beacondata;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        public final KSerializer serializer() {
                            return ShazamResponseJson$Track$Hub$Option$Beacondata$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    public static /* synthetic */ void getProvidername$annotations() {
                    }

                    public static /* synthetic */ void getType$annotations() {
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Beacondata() {
                        this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
                    }

                    public Beacondata(String str, String str2) {
                        this.type = str;
                        this.providername = str2;
                    }

                    public /* synthetic */ Beacondata(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\nHÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001b\u0002\b,¢\u0006\u0002\b+R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R,\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R,\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011Ê\u0001\u0002\b0Ê\u0001\f\b1\u0012\b\b2\u0012\u0004\b\u0003\u0010\u0002¨\u0006/"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$OptionAction;", "", ContentDisposition.Parameters.Name, "", LinkHeader.Parameters.Type, "uri", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getType$annotations", "getType", "getUri$annotations", "getUri", "getId$annotations", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class OptionAction {
                    public static final int $stable = 0;

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion(null);
                    private final String id;
                    private final String name;
                    private final String type;
                    private final String uri;

                    public /* synthetic */ OptionAction(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((i & 1) == 0) {
                            this.name = null;
                        } else {
                            this.name = str;
                        }
                        if ((i & 2) == 0) {
                            this.type = null;
                        } else {
                            this.type = str2;
                        }
                        if ((i & 4) == 0) {
                            this.uri = null;
                        } else {
                            this.uri = str3;
                        }
                        if ((i & 8) == 0) {
                            this.id = null;
                        } else {
                            this.id = str4;
                        }
                    }

                    public static /* synthetic */ OptionAction copy$default(OptionAction optionAction, String str, String str2, String str3, String str4, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = optionAction.name;
                        }
                        if ((i & 2) != 0) {
                            str2 = optionAction.type;
                        }
                        if ((i & 4) != 0) {
                            str3 = optionAction.uri;
                        }
                        if ((i & 8) != 0) {
                            str4 = optionAction.id;
                        }
                        return optionAction.copy(str, str2, str3, str4);
                    }

                    public static final /* synthetic */ void write$Self$app(OptionAction self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.type);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.uri != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.uri);
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.id == null) {
                            return;
                        }
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.id);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final String getName() {
                        return this.name;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final String getType() {
                        return this.type;
                    }

                    /* JADX INFO: renamed from: component3, reason: from getter */
                    public final String getUri() {
                        return this.uri;
                    }

                    /* JADX INFO: renamed from: component4, reason: from getter */
                    public final String getId() {
                        return this.id;
                    }

                    public final OptionAction copy(String name, String type, String uri, String id) {
                        return new OptionAction(name, type, uri, id);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof OptionAction)) {
                            return false;
                        }
                        OptionAction optionAction = (OptionAction) other;
                        return Intrinsics.areEqual(this.name, optionAction.name) && Intrinsics.areEqual(this.type, optionAction.type) && Intrinsics.areEqual(this.uri, optionAction.uri) && Intrinsics.areEqual(this.id, optionAction.id);
                    }

                    public final String getId() {
                        return this.id;
                    }

                    public final String getName() {
                        return this.name;
                    }

                    public final String getType() {
                        return this.type;
                    }

                    public final String getUri() {
                        return this.uri;
                    }

                    public int hashCode() {
                        String str = this.name;
                        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.type;
                        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.uri;
                        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                        String str4 = this.id;
                        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.name;
                        String str2 = this.type;
                        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("OptionAction(name=", str, ", type=", str2, ", uri="), this.uri, ", id=", this.id, ")");
                    }

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$OptionAction$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$OptionAction;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        public final KSerializer serializer() {
                            return ShazamResponseJson$Track$Hub$Option$OptionAction$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    public static /* synthetic */ void getId$annotations() {
                    }

                    public static /* synthetic */ void getName$annotations() {
                    }

                    public static /* synthetic */ void getType$annotations() {
                    }

                    public static /* synthetic */ void getUri$annotations() {
                    }

                    public OptionAction() {
                        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
                    }

                    public OptionAction(String str, String str2, String str3, String str4) {
                        this.name = str;
                        this.type = str2;
                        this.uri = str3;
                        this.id = str4;
                    }

                    public /* synthetic */ OptionAction(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer serializer() {
                        return ShazamResponseJson$Track$Hub$Option$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                public static /* synthetic */ void getActions$annotations() {
                }

                public static /* synthetic */ void getBeacondata$annotations() {
                }

                public static /* synthetic */ void getCaption$annotations() {
                }

                public static /* synthetic */ void getColouroverflowimage$annotations() {
                }

                public static /* synthetic */ void getImage$annotations() {
                }

                public static /* synthetic */ void getListcaption$annotations() {
                }

                public static /* synthetic */ void getOverflowimage$annotations() {
                }

                public static /* synthetic */ void getProvidername$annotations() {
                }

                public static /* synthetic */ void getType$annotations() {
                }

                public Option() {
                    this((String) null, (List) null, (Beacondata) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, 511, (DefaultConstructorMarker) null);
                }

                public Option(String str, List<OptionAction> list, Beacondata beacondata, String str2, String str3, String str4, String str5, Boolean bool, String str6) {
                    this.caption = str;
                    this.actions = list;
                    this.beacondata = beacondata;
                    this.image = str2;
                    this.type = str3;
                    this.listcaption = str4;
                    this.overflowimage = str5;
                    this.colouroverflowimage = bool;
                    this.providername = str6;
                }

                public /* synthetic */ Option(String str, List list, Beacondata beacondata, String str2, String str3, String str4, String str5, Boolean bool, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : beacondata, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : str6);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 52\u00020\u0001:\u00042345B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bBK\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020\rHÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001b\u0002\b1¢\u0006\u0002\b0R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R,\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R4\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR,\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014Ê\u0001\u0002\b7Ê\u0001\f\b8\u0012\b\b9\u0012\u0004\b\u0003\u0010\u0000¨\u00066"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider;", "", "caption", "", "images", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderImages;", "actions", "", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderAction;", LinkHeader.Parameters.Type, "<init>", "(Ljava/lang/String;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderImages;Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderImages;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCaption$annotations", "()V", "getCaption", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getImages$annotations", "getImages", "()Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderImages;", "getActions$annotations", "getActions", "()Ljava/util/List;", "getType$annotations", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "ProviderImages", "ProviderAction", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Provider {
                private final List<ProviderAction> actions;
                private final String caption;
                private final ProviderImages images;
                private final String type;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy[] $childSerializers = {null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Shazam$$ExternalSyntheticLambda0(13)), null};

                public /* synthetic */ Provider(int i, String str, ProviderImages providerImages, List list, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((i & 1) == 0) {
                        this.caption = null;
                    } else {
                        this.caption = str;
                    }
                    if ((i & 2) == 0) {
                        this.images = null;
                    } else {
                        this.images = providerImages;
                    }
                    if ((i & 4) == 0) {
                        this.actions = null;
                    } else {
                        this.actions = list;
                    }
                    if ((i & 8) == 0) {
                        this.type = null;
                    } else {
                        this.type = str2;
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Track$Hub$Provider$ProviderAction$$serializer.INSTANCE), (byte) 1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Provider copy$default(Provider provider, String str, ProviderImages providerImages, List list, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = provider.caption;
                    }
                    if ((i & 2) != 0) {
                        providerImages = provider.images;
                    }
                    if ((i & 4) != 0) {
                        list = provider.actions;
                    }
                    if ((i & 8) != 0) {
                        str2 = provider.type;
                    }
                    return provider.copy(str, providerImages, list, str2);
                }

                public static final /* synthetic */ void write$Self$app(Provider self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.caption != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.caption);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.images != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, ShazamResponseJson$Track$Hub$Provider$ProviderImages$$serializer.INSTANCE, self.images);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.actions != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.actions);
                    }
                    if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.type == null) {
                        return;
                    }
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.type);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getCaption() {
                    return this.caption;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final ProviderImages getImages() {
                    return this.images;
                }

                public final List<ProviderAction> component3() {
                    return this.actions;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final String getType() {
                    return this.type;
                }

                public final Provider copy(String caption, ProviderImages images, List<ProviderAction> actions, String type) {
                    return new Provider(caption, images, actions, type);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Provider)) {
                        return false;
                    }
                    Provider provider = (Provider) other;
                    return Intrinsics.areEqual(this.caption, provider.caption) && Intrinsics.areEqual(this.images, provider.images) && Intrinsics.areEqual(this.actions, provider.actions) && Intrinsics.areEqual(this.type, provider.type);
                }

                public final List<ProviderAction> getActions() {
                    return this.actions;
                }

                public final String getCaption() {
                    return this.caption;
                }

                public final ProviderImages getImages() {
                    return this.images;
                }

                public final String getType() {
                    return this.type;
                }

                public int hashCode() {
                    String str = this.caption;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    ProviderImages providerImages = this.images;
                    int iHashCode2 = (iHashCode + (providerImages == null ? 0 : providerImages.hashCode())) * 31;
                    List<ProviderAction> list = this.actions;
                    int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
                    String str2 = this.type;
                    return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
                }

                public String toString() {
                    return "Provider(caption=" + this.caption + ", images=" + this.images + ", actions=" + this.actions + ", type=" + this.type + ")";
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001b\u0002\b(¢\u0006\u0002\b'R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R,\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010Ê\u0001\u0002\b,Ê\u0001\f\b-\u0012\b\b.\u0012\u0004\b\u0003\u0010\u0002¨\u0006+"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderAction;", "", ContentDisposition.Parameters.Name, "", LinkHeader.Parameters.Type, "uri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getType$annotations", "getType", "getUri$annotations", "getUri", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class ProviderAction {
                    public static final int $stable = 0;

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion(null);
                    private final String name;
                    private final String type;
                    private final String uri;

                    public /* synthetic */ ProviderAction(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((i & 1) == 0) {
                            this.name = null;
                        } else {
                            this.name = str;
                        }
                        if ((i & 2) == 0) {
                            this.type = null;
                        } else {
                            this.type = str2;
                        }
                        if ((i & 4) == 0) {
                            this.uri = null;
                        } else {
                            this.uri = str3;
                        }
                    }

                    public static /* synthetic */ ProviderAction copy$default(ProviderAction providerAction, String str, String str2, String str3, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = providerAction.name;
                        }
                        if ((i & 2) != 0) {
                            str2 = providerAction.type;
                        }
                        if ((i & 4) != 0) {
                            str3 = providerAction.uri;
                        }
                        return providerAction.copy(str, str2, str3);
                    }

                    public static final /* synthetic */ void write$Self$app(ProviderAction self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.type);
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.uri == null) {
                            return;
                        }
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.uri);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final String getName() {
                        return this.name;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final String getType() {
                        return this.type;
                    }

                    /* JADX INFO: renamed from: component3, reason: from getter */
                    public final String getUri() {
                        return this.uri;
                    }

                    public final ProviderAction copy(String name, String type, String uri) {
                        return new ProviderAction(name, type, uri);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof ProviderAction)) {
                            return false;
                        }
                        ProviderAction providerAction = (ProviderAction) other;
                        return Intrinsics.areEqual(this.name, providerAction.name) && Intrinsics.areEqual(this.type, providerAction.type) && Intrinsics.areEqual(this.uri, providerAction.uri);
                    }

                    public final String getName() {
                        return this.name;
                    }

                    public final String getType() {
                        return this.type;
                    }

                    public final String getUri() {
                        return this.uri;
                    }

                    public int hashCode() {
                        String str = this.name;
                        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.type;
                        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.uri;
                        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
                    }

                    public String toString() {
                        String str = this.name;
                        String str2 = this.type;
                        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("ProviderAction(name=", str, ", type=", str2, ", uri="), this.uri, ")");
                    }

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderAction$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderAction;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        public final KSerializer serializer() {
                            return ShazamResponseJson$Track$Hub$Provider$ProviderAction$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    public static /* synthetic */ void getName$annotations() {
                    }

                    public static /* synthetic */ void getType$annotations() {
                    }

                    public static /* synthetic */ void getUri$annotations() {
                    }

                    public ProviderAction() {
                        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
                    }

                    public ProviderAction(String str, String str2, String str3) {
                        this.name = str;
                        this.type = str2;
                        this.uri = str3;
                    }

                    public /* synthetic */ ProviderAction(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001b\u0002\b$¢\u0006\u0002\b#R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fÊ\u0001\u0002\b(Ê\u0001\f\b)\u0012\b\b*\u0012\u0004\b\u0003\u0010\u0002¨\u0006'"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderImages;", "", "overflow", "", "default", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOverflow$annotations", "()V", "getOverflow", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getDefault$annotations", "getDefault", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class ProviderImages {
                    public static final int $stable = 0;

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion(null);
                    private final String default;
                    private final String overflow;

                    public /* synthetic */ ProviderImages(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((i & 1) == 0) {
                            this.overflow = null;
                        } else {
                            this.overflow = str;
                        }
                        if ((i & 2) == 0) {
                            this.default = null;
                        } else {
                            this.default = str2;
                        }
                    }

                    public static /* synthetic */ ProviderImages copy$default(ProviderImages providerImages, String str, String str2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = providerImages.overflow;
                        }
                        if ((i & 2) != 0) {
                            str2 = providerImages.default;
                        }
                        return providerImages.copy(str, str2);
                    }

                    public static final /* synthetic */ void write$Self$app(ProviderImages self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.overflow != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.overflow);
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.default == null) {
                            return;
                        }
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.default);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final String getOverflow() {
                        return this.overflow;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final String getDefault() {
                        return this.default;
                    }

                    public final ProviderImages copy(String overflow, String str) {
                        return new ProviderImages(overflow, str);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof ProviderImages)) {
                            return false;
                        }
                        ProviderImages providerImages = (ProviderImages) other;
                        return Intrinsics.areEqual(this.overflow, providerImages.overflow) && Intrinsics.areEqual(this.default, providerImages.default);
                    }

                    public final String getDefault() {
                        return this.default;
                    }

                    public final String getOverflow() {
                        return this.overflow;
                    }

                    public int hashCode() {
                        String str = this.overflow;
                        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.default;
                        return iHashCode + (str2 != null ? str2.hashCode() : 0);
                    }

                    public String toString() {
                        return Fragment$5$$ExternalSyntheticOutline0.m("ProviderImages(overflow=", this.overflow, ", default=", this.default, ")");
                    }

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderImages$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$ProviderImages;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        public final KSerializer serializer() {
                            return ShazamResponseJson$Track$Hub$Provider$ProviderImages$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    public static /* synthetic */ void getDefault$annotations() {
                    }

                    public static /* synthetic */ void getOverflow$annotations() {
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public ProviderImages() {
                        this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
                    }

                    public ProviderImages(String str, String str2) {
                        this.overflow = str;
                        this.default = str2;
                    }

                    public /* synthetic */ ProviderImages(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Provider;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer serializer() {
                        return ShazamResponseJson$Track$Hub$Provider$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                public static /* synthetic */ void getActions$annotations() {
                }

                public static /* synthetic */ void getCaption$annotations() {
                }

                public static /* synthetic */ void getImages$annotations() {
                }

                public static /* synthetic */ void getType$annotations() {
                }

                public Provider() {
                    this((String) null, (ProviderImages) null, (List) null, (String) null, 15, (DefaultConstructorMarker) null);
                }

                public Provider(String str, ProviderImages providerImages, List<ProviderAction> list, String str2) {
                    this.caption = str;
                    this.images = providerImages;
                    this.actions = list;
                    this.type = str2;
                }

                public /* synthetic */ Provider(String str, ProviderImages providerImages, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : providerImages, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str2);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\nHÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001b\u0002\b,¢\u0006\u0002\b+R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R,\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R,\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011Ê\u0001\u0002\b0Ê\u0001\f\b1\u0012\b\b2\u0012\u0004\b\u0003\u0010\u0002¨\u0006/"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Action;", "", ContentDisposition.Parameters.Name, "", LinkHeader.Parameters.Type, "id", "uri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getType$annotations", "getType", "getId$annotations", "getId", "getUri$annotations", "getUri", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Action {
                public static final int $stable = 0;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private final String id;
                private final String name;
                private final String type;
                private final String uri;

                public /* synthetic */ Action(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((i & 1) == 0) {
                        this.name = null;
                    } else {
                        this.name = str;
                    }
                    if ((i & 2) == 0) {
                        this.type = null;
                    } else {
                        this.type = str2;
                    }
                    if ((i & 4) == 0) {
                        this.id = null;
                    } else {
                        this.id = str3;
                    }
                    if ((i & 8) == 0) {
                        this.uri = null;
                    } else {
                        this.uri = str4;
                    }
                }

                public static /* synthetic */ Action copy$default(Action action, String str, String str2, String str3, String str4, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = action.name;
                    }
                    if ((i & 2) != 0) {
                        str2 = action.type;
                    }
                    if ((i & 4) != 0) {
                        str3 = action.id;
                    }
                    if ((i & 8) != 0) {
                        str4 = action.uri;
                    }
                    return action.copy(str, str2, str3, str4);
                }

                public static final /* synthetic */ void write$Self$app(Action self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.type);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.id != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.id);
                    }
                    if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.uri == null) {
                        return;
                    }
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.uri);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getName() {
                    return this.name;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getType() {
                    return this.type;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final String getId() {
                    return this.id;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final String getUri() {
                    return this.uri;
                }

                public final Action copy(String name, String type, String id, String uri) {
                    return new Action(name, type, id, uri);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Action)) {
                        return false;
                    }
                    Action action = (Action) other;
                    return Intrinsics.areEqual(this.name, action.name) && Intrinsics.areEqual(this.type, action.type) && Intrinsics.areEqual(this.id, action.id) && Intrinsics.areEqual(this.uri, action.uri);
                }

                public final String getId() {
                    return this.id;
                }

                public final String getName() {
                    return this.name;
                }

                public final String getType() {
                    return this.type;
                }

                public final String getUri() {
                    return this.uri;
                }

                public int hashCode() {
                    String str = this.name;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.type;
                    int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.id;
                    int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                    String str4 = this.uri;
                    return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
                }

                public String toString() {
                    String str = this.name;
                    String str2 = this.type;
                    return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Action(name=", str, ", type=", str2, ", id="), this.id, ", uri=", this.uri, ")");
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Action$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Action;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer serializer() {
                        return ShazamResponseJson$Track$Hub$Action$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                public static /* synthetic */ void getId$annotations() {
                }

                public static /* synthetic */ void getName$annotations() {
                }

                public static /* synthetic */ void getType$annotations() {
                }

                public static /* synthetic */ void getUri$annotations() {
                }

                public Action() {
                    this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
                }

                public Action(String str, String str2, String str3, String str4) {
                    this.name = str;
                    this.type = str2;
                    this.id = str3;
                    this.uri = str4;
                }

                public /* synthetic */ Action(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer serializer() {
                    return ShazamResponseJson$Track$Hub$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public static /* synthetic */ void getActions$annotations() {
            }

            public static /* synthetic */ void getDisplayname$annotations() {
            }

            public static /* synthetic */ void getExplicit$annotations() {
            }

            public static /* synthetic */ void getImage$annotations() {
            }

            public static /* synthetic */ void getOptions$annotations() {
            }

            public static /* synthetic */ void getProviders$annotations() {
            }

            public static /* synthetic */ void getType$annotations() {
            }

            public Hub() {
                this((String) null, (String) null, (List) null, (List) null, (List) null, (Boolean) null, (String) null, 127, (DefaultConstructorMarker) null);
            }

            public Hub(String str, String str2, List<Action> list, List<Option> list2, List<Provider> list3, Boolean bool, String str3) {
                this.type = str;
                this.image = str2;
                this.actions = list;
                this.options = list2;
                this.providers = list3;
                this.explicit = bool;
                this.displayname = str3;
            }

            public /* synthetic */ Hub(String str, String str2, List list, List list2, List list3, Boolean bool, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : list3, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str3);
            }
        }

        static {
            Shazam$$ExternalSyntheticLambda0 shazam$$ExternalSyntheticLambda0 = new Shazam$$ExternalSyntheticLambda0((byte) 7);
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, ResultKt.lazy(lazyThreadSafetyMode, shazam$$ExternalSyntheticLambda0), null, ResultKt.lazy(lazyThreadSafetyMode, new Shazam$$ExternalSyntheticLambda0((byte) 8)), null, null, null, null};
        }

        public /* synthetic */ Track(String str, String str2, String str3, String str4, String str5, Images images, Share share, Hub hub, List list, String str6, List list2, String str7, Genres genres, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : images, (i & 64) != 0 ? null : share, (i & 128) != 0 ? null : hub, (i & 256) != 0 ? null : list, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : list2, (i & 2048) != 0 ? null : str7, (i & 4096) != 0 ? null : genres, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : str9);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Track$Section$$serializer.INSTANCE), (byte) 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Track$Artist$$serializer.INSTANCE), (byte) 1);
        }

        public static final /* synthetic */ void write$Self$app(Track self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.layout != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.layout);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.key != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.key);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.subtitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.subtitle);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.images != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, ShazamResponseJson$Track$Images$$serializer.INSTANCE, self.images);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.share != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, ShazamResponseJson$Track$Share$$serializer.INSTANCE, self.share);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.hub != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, ShazamResponseJson$Track$Hub$$serializer.INSTANCE, self.hub);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.sections != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) lazyArr[8].getValue(), self.sections);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.url != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.url);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.artists != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy) lazyArr[10].getValue(), self.artists);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.isrc != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.isrc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.genres != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, ShazamResponseJson$Track$Genres$$serializer.INSTANCE, self.genres);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.relatedtracksurl != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.relatedtracksurl);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 14) && self.albumadamid == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.albumadamid);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLayout() {
            return this.layout;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final List<Artist> component11() {
            return this.artists;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getIsrc() {
            return this.isrc;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Genres getGenres() {
            return this.genres;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getRelatedtracksurl() {
            return this.relatedtracksurl;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getAlbumadamid() {
            return this.albumadamid;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSubtitle() {
            return this.subtitle;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Images getImages() {
            return this.images;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Share getShare() {
            return this.share;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Hub getHub() {
            return this.hub;
        }

        public final List<Section> component9() {
            return this.sections;
        }

        public final Track copy(String layout, String type, String key, String title, String subtitle, Images images, Share share, Hub hub, List<Section> sections, String url, List<Artist> artists, String isrc, Genres genres, String relatedtracksurl, String albumadamid) {
            return new Track(layout, type, key, title, subtitle, images, share, hub, sections, url, artists, isrc, genres, relatedtracksurl, albumadamid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.layout, track.layout) && Intrinsics.areEqual(this.type, track.type) && Intrinsics.areEqual(this.key, track.key) && Intrinsics.areEqual(this.title, track.title) && Intrinsics.areEqual(this.subtitle, track.subtitle) && Intrinsics.areEqual(this.images, track.images) && Intrinsics.areEqual(this.share, track.share) && Intrinsics.areEqual(this.hub, track.hub) && Intrinsics.areEqual(this.sections, track.sections) && Intrinsics.areEqual(this.url, track.url) && Intrinsics.areEqual(this.artists, track.artists) && Intrinsics.areEqual(this.isrc, track.isrc) && Intrinsics.areEqual(this.genres, track.genres) && Intrinsics.areEqual(this.relatedtracksurl, track.relatedtracksurl) && Intrinsics.areEqual(this.albumadamid, track.albumadamid);
        }

        public final String getAlbumadamid() {
            return this.albumadamid;
        }

        public final List<Artist> getArtists() {
            return this.artists;
        }

        public final Genres getGenres() {
            return this.genres;
        }

        public final Hub getHub() {
            return this.hub;
        }

        public final Images getImages() {
            return this.images;
        }

        public final String getIsrc() {
            return this.isrc;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getLayout() {
            return this.layout;
        }

        public final String getRelatedtracksurl() {
            return this.relatedtracksurl;
        }

        public final List<Section> getSections() {
            return this.sections;
        }

        public final Share getShare() {
            return this.share;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.layout;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.type;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.key;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.title;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.subtitle;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Images images = this.images;
            int iHashCode6 = (iHashCode5 + (images == null ? 0 : images.hashCode())) * 31;
            Share share = this.share;
            int iHashCode7 = (iHashCode6 + (share == null ? 0 : share.hashCode())) * 31;
            Hub hub = this.hub;
            int iHashCode8 = (iHashCode7 + (hub == null ? 0 : hub.hashCode())) * 31;
            List<Section> list = this.sections;
            int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
            String str6 = this.url;
            int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
            List<Artist> list2 = this.artists;
            int iHashCode11 = (iHashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
            String str7 = this.isrc;
            int iHashCode12 = (iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Genres genres = this.genres;
            int iHashCode13 = (iHashCode12 + (genres == null ? 0 : genres.hashCode())) * 31;
            String str8 = this.relatedtracksurl;
            int iHashCode14 = (iHashCode13 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.albumadamid;
            return iHashCode14 + (str9 != null ? str9.hashCode() : 0);
        }

        public String toString() {
            String str = this.layout;
            String str2 = this.type;
            String str3 = this.key;
            String str4 = this.title;
            String str5 = this.subtitle;
            Images images = this.images;
            Share share = this.share;
            Hub hub = this.hub;
            List<Section> list = this.sections;
            String str6 = this.url;
            List<Artist> list2 = this.artists;
            String str7 = this.isrc;
            Genres genres = this.genres;
            String str8 = this.relatedtracksurl;
            String str9 = this.albumadamid;
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Track(layout=", str, ", type=", str2, ", key=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str3, ", title=", str4, ", subtitle=");
            sbM.append(str5);
            sbM.append(", images=");
            sbM.append(images);
            sbM.append(", share=");
            sbM.append(share);
            sbM.append(", hub=");
            sbM.append(hub);
            sbM.append(", sections=");
            sbM.append(list);
            sbM.append(", url=");
            sbM.append(str6);
            sbM.append(", artists=");
            sbM.append(list2);
            sbM.append(", isrc=");
            sbM.append(str7);
            sbM.append(", genres=");
            sbM.append(genres);
            sbM.append(", relatedtracksurl=");
            sbM.append(str8);
            sbM.append(", albumadamid=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sbM, str9, ")");
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @kotlin.Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u00049:;<Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rBm\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003Jg\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004J)\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001b\u0002\b8¢\u0006\u0002\b7R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R4\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR,\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R4\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u001bR,\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\n¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0016R2\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u000b¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u001bÊ\u0001\u0002\b>Ê\u0001\f\b?\u0012\b\b@\u0012\u0004\b\u0003\u0010\u0002¨\u0006="}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section;", "", LinkHeader.Parameters.Type, "", "metapages", "", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section$Metapage;", "tabname", "metadata", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section$Metadata;", "url", ContentType.Text.TYPE, "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType$annotations", "()V", "getType", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getMetapages$annotations", "getMetapages", "()Ljava/util/List;", "getTabname$annotations", "getTabname", "getMetadata$annotations", "getMetadata", "getUrl$annotations", "getUrl", "getText$annotations", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "Metapage", "Metadata", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Section {
            private static final Lazy[] $childSerializers;
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final List<Metadata> metadata;
            private final List<Metapage> metapages;
            private final String tabname;
            private final List<String> text;
            private final String type;
            private final String url;

            static {
                Shazam$$ExternalSyntheticLambda0 shazam$$ExternalSyntheticLambda0 = new Shazam$$ExternalSyntheticLambda0((byte) 14);
                LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
                $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, shazam$$ExternalSyntheticLambda0), null, ResultKt.lazy(lazyThreadSafetyMode, new Shazam$$ExternalSyntheticLambda0((byte) 15)), null, ResultKt.lazy(lazyThreadSafetyMode, new Shazam$$ExternalSyntheticLambda0((byte) 16))};
            }

            public /* synthetic */ Section(int i, String str, List list, String str2, List list2, String str3, List list3, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.type = null;
                } else {
                    this.type = str;
                }
                if ((i & 2) == 0) {
                    this.metapages = null;
                } else {
                    this.metapages = list;
                }
                if ((i & 4) == 0) {
                    this.tabname = null;
                } else {
                    this.tabname = str2;
                }
                if ((i & 8) == 0) {
                    this.metadata = null;
                } else {
                    this.metadata = list2;
                }
                if ((i & 16) == 0) {
                    this.url = null;
                } else {
                    this.url = str3;
                }
                if ((i & 32) == 0) {
                    this.text = null;
                } else {
                    this.text = list3;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Track$Section$Metapage$$serializer.INSTANCE), (byte) 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Track$Section$Metadata$$serializer.INSTANCE), (byte) 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Section copy$default(Section section, String str, List list, String str2, List list2, String str3, List list3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = section.type;
                }
                if ((i & 2) != 0) {
                    list = section.metapages;
                }
                if ((i & 4) != 0) {
                    str2 = section.tabname;
                }
                if ((i & 8) != 0) {
                    list2 = section.metadata;
                }
                if ((i & 16) != 0) {
                    str3 = section.url;
                }
                if ((i & 32) != 0) {
                    list3 = section.text;
                }
                String str4 = str3;
                List list4 = list3;
                return section.copy(str, list, str2, list2, str4, list4);
            }

            public static final /* synthetic */ void write$Self$app(Section self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.type);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.metapages != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.metapages);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.tabname != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.tabname);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.metadata != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.metadata);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.url != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.url);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.text == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.text);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getType() {
                return this.type;
            }

            public final List<Metapage> component2() {
                return this.metapages;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getTabname() {
                return this.tabname;
            }

            public final List<Metadata> component4() {
                return this.metadata;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final List<String> component6() {
                return this.text;
            }

            public final Section copy(String type, List<Metapage> metapages, String tabname, List<Metadata> metadata, String url, List<String> text) {
                return new Section(type, metapages, tabname, metadata, url, text);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Section)) {
                    return false;
                }
                Section section = (Section) other;
                return Intrinsics.areEqual(this.type, section.type) && Intrinsics.areEqual(this.metapages, section.metapages) && Intrinsics.areEqual(this.tabname, section.tabname) && Intrinsics.areEqual(this.metadata, section.metadata) && Intrinsics.areEqual(this.url, section.url) && Intrinsics.areEqual(this.text, section.text);
            }

            public final List<Metadata> getMetadata() {
                return this.metadata;
            }

            public final List<Metapage> getMetapages() {
                return this.metapages;
            }

            public final String getTabname() {
                return this.tabname;
            }

            public final List<String> getText() {
                return this.text;
            }

            public final String getType() {
                return this.type;
            }

            public final String getUrl() {
                return this.url;
            }

            public int hashCode() {
                String str = this.type;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                List<Metapage> list = this.metapages;
                int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
                String str2 = this.tabname;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                List<Metadata> list2 = this.metadata;
                int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
                String str3 = this.url;
                int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
                List<String> list3 = this.text;
                return iHashCode5 + (list3 != null ? list3.hashCode() : 0);
            }

            public String toString() {
                return "Section(type=" + this.type + ", metapages=" + this.metapages + ", tabname=" + this.tabname + ", metadata=" + this.metadata + ", url=" + this.url + ", text=" + this.text + ")";
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @kotlin.Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001b\u0002\b$¢\u0006\u0002\b#R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fÊ\u0001\u0002\b(Ê\u0001\f\b)\u0012\b\b*\u0012\u0004\b\u0003\u0010\u0002¨\u0006'"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section$Metadata;", "", LinkHeader.Parameters.Title, "", ContentType.Text.TYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getText$annotations", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Metadata {
                public static final int $stable = 0;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private final String text;
                private final String title;

                public /* synthetic */ Metadata(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((i & 1) == 0) {
                        this.title = null;
                    } else {
                        this.title = str;
                    }
                    if ((i & 2) == 0) {
                        this.text = null;
                    } else {
                        this.text = str2;
                    }
                }

                public static /* synthetic */ Metadata copy$default(Metadata metadata, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = metadata.title;
                    }
                    if ((i & 2) != 0) {
                        str2 = metadata.text;
                    }
                    return metadata.copy(str, str2);
                }

                public static final /* synthetic */ void write$Self$app(Metadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.title != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
                    }
                    if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.text == null) {
                        return;
                    }
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.text);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getTitle() {
                    return this.title;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getText() {
                    return this.text;
                }

                public final Metadata copy(String title, String text) {
                    return new Metadata(title, text);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Metadata)) {
                        return false;
                    }
                    Metadata metadata = (Metadata) other;
                    return Intrinsics.areEqual(this.title, metadata.title) && Intrinsics.areEqual(this.text, metadata.text);
                }

                public final String getText() {
                    return this.text;
                }

                public final String getTitle() {
                    return this.title;
                }

                public int hashCode() {
                    String str = this.title;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.text;
                    return iHashCode + (str2 != null ? str2.hashCode() : 0);
                }

                public String toString() {
                    return Fragment$5$$ExternalSyntheticOutline0.m("Metadata(title=", this.title, ", text=", this.text, ")");
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section$Metadata$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section$Metadata;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer serializer() {
                        return ShazamResponseJson$Track$Section$Metadata$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                public static /* synthetic */ void getText$annotations() {
                }

                public static /* synthetic */ void getTitle$annotations() {
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Metadata() {
                    this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
                }

                public Metadata(String str, String str2) {
                    this.title = str;
                    this.text = str2;
                }

                public /* synthetic */ Metadata(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @kotlin.Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001b\u0002\b$¢\u0006\u0002\b#R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fÊ\u0001\u0002\b(Ê\u0001\f\b)\u0012\b\b*\u0012\u0004\b\u0003\u0010\u0002¨\u0006'"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section$Metapage;", "", ContentType.Image.TYPE, "", "caption", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImage$annotations", "()V", "getImage", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getCaption$annotations", "getCaption", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Metapage {
                public static final int $stable = 0;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private final String caption;
                private final String image;

                public /* synthetic */ Metapage(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((i & 1) == 0) {
                        this.image = null;
                    } else {
                        this.image = str;
                    }
                    if ((i & 2) == 0) {
                        this.caption = null;
                    } else {
                        this.caption = str2;
                    }
                }

                public static /* synthetic */ Metapage copy$default(Metapage metapage, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = metapage.image;
                    }
                    if ((i & 2) != 0) {
                        str2 = metapage.caption;
                    }
                    return metapage.copy(str, str2);
                }

                public static final /* synthetic */ void write$Self$app(Metapage self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.image != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.image);
                    }
                    if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.caption == null) {
                        return;
                    }
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.caption);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getImage() {
                    return this.image;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getCaption() {
                    return this.caption;
                }

                public final Metapage copy(String image, String caption) {
                    return new Metapage(image, caption);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Metapage)) {
                        return false;
                    }
                    Metapage metapage = (Metapage) other;
                    return Intrinsics.areEqual(this.image, metapage.image) && Intrinsics.areEqual(this.caption, metapage.caption);
                }

                public final String getCaption() {
                    return this.caption;
                }

                public final String getImage() {
                    return this.image;
                }

                public int hashCode() {
                    String str = this.image;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.caption;
                    return iHashCode + (str2 != null ? str2.hashCode() : 0);
                }

                public String toString() {
                    return Fragment$5$$ExternalSyntheticOutline0.m("Metapage(image=", this.image, ", caption=", this.caption, ")");
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section$Metapage$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section$Metapage;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer serializer() {
                        return ShazamResponseJson$Track$Section$Metapage$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                public static /* synthetic */ void getCaption$annotations() {
                }

                public static /* synthetic */ void getImage$annotations() {
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Metapage() {
                    this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
                }

                public Metapage(String str, String str2) {
                    this.image = str;
                    this.caption = str2;
                }

                public /* synthetic */ Metapage(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Section;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer serializer() {
                    return ShazamResponseJson$Track$Section$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public static /* synthetic */ void getMetadata$annotations() {
            }

            public static /* synthetic */ void getMetapages$annotations() {
            }

            public static /* synthetic */ void getTabname$annotations() {
            }

            public static /* synthetic */ void getText$annotations() {
            }

            public static /* synthetic */ void getType$annotations() {
            }

            public static /* synthetic */ void getUrl$annotations() {
            }

            public Section() {
                this((String) null, (List) null, (String) null, (List) null, (String) null, (List) null, 63, (DefaultConstructorMarker) null);
            }

            public Section(String str, List<Metapage> list, String str2, List<Metadata> list2, String str3, List<String> list3) {
                this.type = str;
                this.metapages = list;
                this.tabname = str2;
                this.metadata = list2;
                this.url = str3;
                this.text = list3;
            }

            public /* synthetic */ Section(String str, List list, String str2, List list2, String str3, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : list3);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001b\u0002\b$¢\u0006\u0002\b#R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fÊ\u0001\u0002\b(Ê\u0001\f\b)\u0012\b\b*\u0012\u0004\b\u0003\u0010\u0002¨\u0006'"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Artist;", "", "id", "", "adamid", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getAdamid$annotations", "getAdamid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Artist {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String adamid;
            private final String id;

            public /* synthetic */ Artist(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.id = null;
                } else {
                    this.id = str;
                }
                if ((i & 2) == 0) {
                    this.adamid = null;
                } else {
                    this.adamid = str2;
                }
            }

            public static /* synthetic */ Artist copy$default(Artist artist, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = artist.id;
                }
                if ((i & 2) != 0) {
                    str2 = artist.adamid;
                }
                return artist.copy(str, str2);
            }

            public static final /* synthetic */ void write$Self$app(Artist self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.adamid == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.adamid);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getAdamid() {
                return this.adamid;
            }

            public final Artist copy(String id, String adamid) {
                return new Artist(id, adamid);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Artist)) {
                    return false;
                }
                Artist artist = (Artist) other;
                return Intrinsics.areEqual(this.id, artist.id) && Intrinsics.areEqual(this.adamid, artist.adamid);
            }

            public final String getAdamid() {
                return this.adamid;
            }

            public final String getId() {
                return this.id;
            }

            public int hashCode() {
                String str = this.id;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.adamid;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return Fragment$5$$ExternalSyntheticOutline0.m("Artist(id=", this.id, ", adamid=", this.adamid, ")");
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Artist$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Artist;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer serializer() {
                    return ShazamResponseJson$Track$Artist$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public static /* synthetic */ void getAdamid$annotations() {
            }

            public static /* synthetic */ void getId$annotations() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Artist() {
                this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }

            public Artist(String str, String str2) {
                this.id = str;
                this.adamid = str2;
            }

            public /* synthetic */ Artist(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001b\u0002\b ¢\u0006\u0002\b\u001fR,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eÊ\u0001\u0002\b$Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0002¨\u0006#"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Genres;", "", "primary", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPrimary$annotations", "()V", "getPrimary", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Genres {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String primary;

            public /* synthetic */ Genres(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.primary = null;
                } else {
                    this.primary = str;
                }
            }

            public static /* synthetic */ Genres copy$default(Genres genres, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = genres.primary;
                }
                return genres.copy(str);
            }

            public static final /* synthetic */ void write$Self$app(Genres self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.primary == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.primary);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPrimary() {
                return this.primary;
            }

            public final Genres copy(String primary) {
                return new Genres(primary);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Genres) && Intrinsics.areEqual(this.primary, ((Genres) other).primary);
            }

            public final String getPrimary() {
                return this.primary;
            }

            public int hashCode() {
                String str = this.primary;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("Genres(primary=", this.primary, ")");
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Genres$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Genres;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer serializer() {
                    return ShazamResponseJson$Track$Genres$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Genres() {
                this((String) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }

            public Genres(String str) {
                this.primary = str;
            }

            public /* synthetic */ Genres(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public static /* synthetic */ void getPrimary$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\nHÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001b\u0002\b,¢\u0006\u0002\b+R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R,\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R,\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011Ê\u0001\u0002\b0Ê\u0001\f\b1\u0012\b\b2\u0012\u0004\b\u0003\u0010\u0002¨\u0006/"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Images;", "", "background", "", "coverart", "coverarthq", "joecolor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBackground$annotations", "()V", "getBackground", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getCoverart$annotations", "getCoverart", "getCoverarthq$annotations", "getCoverarthq", "getJoecolor$annotations", "getJoecolor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Images {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String background;
            private final String coverart;
            private final String coverarthq;
            private final String joecolor;

            public /* synthetic */ Images(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.background = null;
                } else {
                    this.background = str;
                }
                if ((i & 2) == 0) {
                    this.coverart = null;
                } else {
                    this.coverart = str2;
                }
                if ((i & 4) == 0) {
                    this.coverarthq = null;
                } else {
                    this.coverarthq = str3;
                }
                if ((i & 8) == 0) {
                    this.joecolor = null;
                } else {
                    this.joecolor = str4;
                }
            }

            public static /* synthetic */ Images copy$default(Images images, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = images.background;
                }
                if ((i & 2) != 0) {
                    str2 = images.coverart;
                }
                if ((i & 4) != 0) {
                    str3 = images.coverarthq;
                }
                if ((i & 8) != 0) {
                    str4 = images.joecolor;
                }
                return images.copy(str, str2, str3, str4);
            }

            public static final /* synthetic */ void write$Self$app(Images self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.background != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.background);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.coverart != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.coverart);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.coverarthq != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.coverarthq);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.joecolor == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.joecolor);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getBackground() {
                return this.background;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getCoverart() {
                return this.coverart;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getCoverarthq() {
                return this.coverarthq;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getJoecolor() {
                return this.joecolor;
            }

            public final Images copy(String background, String coverart, String coverarthq, String joecolor) {
                return new Images(background, coverart, coverarthq, joecolor);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Images)) {
                    return false;
                }
                Images images = (Images) other;
                return Intrinsics.areEqual(this.background, images.background) && Intrinsics.areEqual(this.coverart, images.coverart) && Intrinsics.areEqual(this.coverarthq, images.coverarthq) && Intrinsics.areEqual(this.joecolor, images.joecolor);
            }

            public final String getBackground() {
                return this.background;
            }

            public final String getCoverart() {
                return this.coverart;
            }

            public final String getCoverarthq() {
                return this.coverarthq;
            }

            public final String getJoecolor() {
                return this.joecolor;
            }

            public int hashCode() {
                String str = this.background;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.coverart;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.coverarthq;
                int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.joecolor;
                return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
            }

            public String toString() {
                String str = this.background;
                String str2 = this.coverart;
                return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Images(background=", str, ", coverart=", str2, ", coverarthq="), this.coverarthq, ", joecolor=", this.joecolor, ")");
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Images$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Images;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer serializer() {
                    return ShazamResponseJson$Track$Images$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public static /* synthetic */ void getBackground$annotations() {
            }

            public static /* synthetic */ void getCoverart$annotations() {
            }

            public static /* synthetic */ void getCoverarthq$annotations() {
            }

            public static /* synthetic */ void getJoecolor$annotations() {
            }

            public Images() {
                this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
            }

            public Images(String str, String str2, String str3, String str4) {
                this.background = str;
                this.coverart = str2;
                this.coverarthq = str3;
                this.joecolor = str4;
            }

            public /* synthetic */ Images(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fBk\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\u000eHÖ\u0081\u0004J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004J)\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0001b\u0002\b<¢\u0006\u0002\b;R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R,\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R,\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R,\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R,\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\b¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015R,\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\t¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015R,\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\n¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u0015Ê\u0001\u0002\b@Ê\u0001\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0002¨\u0006?"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Share;", "", "subject", "", ContentType.Text.TYPE, "href", ContentType.Image.TYPE, "twitter", "html", "avatar", "snapchat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSubject$annotations", "()V", "getSubject", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getText$annotations", "getText", "getHref$annotations", "getHref", "getImage$annotations", "getImage", "getTwitter$annotations", "getTwitter", "getHtml$annotations", "getHtml", "getAvatar$annotations", "getAvatar", "getSnapchat$annotations", "getSnapchat", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Share {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String avatar;
            private final String href;
            private final String html;
            private final String image;
            private final String snapchat;
            private final String subject;
            private final String text;
            private final String twitter;

            public /* synthetic */ Share(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.subject = null;
                } else {
                    this.subject = str;
                }
                if ((i & 2) == 0) {
                    this.text = null;
                } else {
                    this.text = str2;
                }
                if ((i & 4) == 0) {
                    this.href = null;
                } else {
                    this.href = str3;
                }
                if ((i & 8) == 0) {
                    this.image = null;
                } else {
                    this.image = str4;
                }
                if ((i & 16) == 0) {
                    this.twitter = null;
                } else {
                    this.twitter = str5;
                }
                if ((i & 32) == 0) {
                    this.html = null;
                } else {
                    this.html = str6;
                }
                if ((i & 64) == 0) {
                    this.avatar = null;
                } else {
                    this.avatar = str7;
                }
                if ((i & 128) == 0) {
                    this.snapchat = null;
                } else {
                    this.snapchat = str8;
                }
            }

            public static /* synthetic */ Share copy$default(Share share, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = share.subject;
                }
                if ((i & 2) != 0) {
                    str2 = share.text;
                }
                if ((i & 4) != 0) {
                    str3 = share.href;
                }
                if ((i & 8) != 0) {
                    str4 = share.image;
                }
                if ((i & 16) != 0) {
                    str5 = share.twitter;
                }
                if ((i & 32) != 0) {
                    str6 = share.html;
                }
                if ((i & 64) != 0) {
                    str7 = share.avatar;
                }
                if ((i & 128) != 0) {
                    str8 = share.snapchat;
                }
                String str9 = str7;
                String str10 = str8;
                String str11 = str5;
                String str12 = str6;
                return share.copy(str, str2, str3, str4, str11, str12, str9, str10);
            }

            public static final /* synthetic */ void write$Self$app(Share self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.subject != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.subject);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.text != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.text);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.href != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.href);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.image != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.image);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.twitter != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.twitter);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.html != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.html);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.avatar != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.avatar);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.snapchat == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.snapchat);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSubject() {
                return this.subject;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getText() {
                return this.text;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getHref() {
                return this.href;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getImage() {
                return this.image;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getTwitter() {
                return this.twitter;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getHtml() {
                return this.html;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getAvatar() {
                return this.avatar;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final String getSnapchat() {
                return this.snapchat;
            }

            public final Share copy(String subject, String text, String href, String image, String twitter, String html, String avatar, String snapchat) {
                return new Share(subject, text, href, image, twitter, html, avatar, snapchat);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Share)) {
                    return false;
                }
                Share share = (Share) other;
                return Intrinsics.areEqual(this.subject, share.subject) && Intrinsics.areEqual(this.text, share.text) && Intrinsics.areEqual(this.href, share.href) && Intrinsics.areEqual(this.image, share.image) && Intrinsics.areEqual(this.twitter, share.twitter) && Intrinsics.areEqual(this.html, share.html) && Intrinsics.areEqual(this.avatar, share.avatar) && Intrinsics.areEqual(this.snapchat, share.snapchat);
            }

            public final String getAvatar() {
                return this.avatar;
            }

            public final String getHref() {
                return this.href;
            }

            public final String getHtml() {
                return this.html;
            }

            public final String getImage() {
                return this.image;
            }

            public final String getSnapchat() {
                return this.snapchat;
            }

            public final String getSubject() {
                return this.subject;
            }

            public final String getText() {
                return this.text;
            }

            public final String getTwitter() {
                return this.twitter;
            }

            public int hashCode() {
                String str = this.subject;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.text;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.href;
                int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.image;
                int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.twitter;
                int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.html;
                int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.avatar;
                int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
                String str8 = this.snapchat;
                return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
            }

            public String toString() {
                String str = this.subject;
                String str2 = this.text;
                String str3 = this.href;
                String str4 = this.image;
                String str5 = this.twitter;
                String str6 = this.html;
                String str7 = this.avatar;
                String str8 = this.snapchat;
                StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Share(subject=", str, ", text=", str2, ", href=");
                IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str3, ", image=", str4, ", twitter=");
                IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str5, ", html=", str6, ", avatar=");
                return IntIntPair$$ExternalSyntheticOutline0.m(sbM, str7, ", snapchat=", str8, ")");
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Share$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Share;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer serializer() {
                    return ShazamResponseJson$Track$Share$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public static /* synthetic */ void getAvatar$annotations() {
            }

            public static /* synthetic */ void getHref$annotations() {
            }

            public static /* synthetic */ void getHtml$annotations() {
            }

            public static /* synthetic */ void getImage$annotations() {
            }

            public static /* synthetic */ void getSnapchat$annotations() {
            }

            public static /* synthetic */ void getSubject$annotations() {
            }

            public static /* synthetic */ void getText$annotations() {
            }

            public static /* synthetic */ void getTwitter$annotations() {
            }

            public Share() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
            }

            public Share(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                this.subject = str;
                this.text = str2;
                this.href = str3;
                this.image = str4;
                this.twitter = str5;
                this.html = str6;
                this.avatar = str7;
                this.snapchat = str8;
            }

            public /* synthetic */ Share(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer serializer() {
                return ShazamResponseJson$Track$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public static /* synthetic */ void getAlbumadamid$annotations() {
        }

        public static /* synthetic */ void getArtists$annotations() {
        }

        public static /* synthetic */ void getGenres$annotations() {
        }

        public static /* synthetic */ void getHub$annotations() {
        }

        public static /* synthetic */ void getImages$annotations() {
        }

        public static /* synthetic */ void getIsrc$annotations() {
        }

        public static /* synthetic */ void getKey$annotations() {
        }

        public static /* synthetic */ void getLayout$annotations() {
        }

        public static /* synthetic */ void getRelatedtracksurl$annotations() {
        }

        public static /* synthetic */ void getSections$annotations() {
        }

        public static /* synthetic */ void getShare$annotations() {
        }

        public static /* synthetic */ void getSubtitle$annotations() {
        }

        public static /* synthetic */ void getTitle$annotations() {
        }

        public static /* synthetic */ void getType$annotations() {
        }

        public static /* synthetic */ void getUrl$annotations() {
        }

        public /* synthetic */ Track(int i, String str, String str2, String str3, String str4, String str5, Images images, Share share, Hub hub, List list, String str6, List list2, String str7, Genres genres, String str8, String str9, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.layout = null;
            } else {
                this.layout = str;
            }
            if ((i & 2) == 0) {
                this.type = null;
            } else {
                this.type = str2;
            }
            if ((i & 4) == 0) {
                this.key = null;
            } else {
                this.key = str3;
            }
            if ((i & 8) == 0) {
                this.title = null;
            } else {
                this.title = str4;
            }
            if ((i & 16) == 0) {
                this.subtitle = null;
            } else {
                this.subtitle = str5;
            }
            if ((i & 32) == 0) {
                this.images = null;
            } else {
                this.images = images;
            }
            if ((i & 64) == 0) {
                this.share = null;
            } else {
                this.share = share;
            }
            if ((i & 128) == 0) {
                this.hub = null;
            } else {
                this.hub = hub;
            }
            if ((i & 256) == 0) {
                this.sections = null;
            } else {
                this.sections = list;
            }
            if ((i & 512) == 0) {
                this.url = null;
            } else {
                this.url = str6;
            }
            if ((i & 1024) == 0) {
                this.artists = null;
            } else {
                this.artists = list2;
            }
            if ((i & 2048) == 0) {
                this.isrc = null;
            } else {
                this.isrc = str7;
            }
            if ((i & 4096) == 0) {
                this.genres = null;
            } else {
                this.genres = genres;
            }
            if ((i & 8192) == 0) {
                this.relatedtracksurl = null;
            } else {
                this.relatedtracksurl = str8;
            }
            if ((i & 16384) == 0) {
                this.albumadamid = null;
            } else {
                this.albumadamid = str9;
            }
        }

        public Track(String str, String str2, String str3, String str4, String str5, Images images, Share share, Hub hub, List<Section> list, String str6, List<Artist> list2, String str7, Genres genres, String str8, String str9) {
            this.layout = str;
            this.type = str2;
            this.key = str3;
            this.title = str4;
            this.subtitle = str5;
            this.images = images;
            this.share = share;
            this.hub = hub;
            this.sections = list;
            this.url = str6;
            this.artists = list2;
            this.isrc = str7;
            this.genres = genres;
            this.relatedtracksurl = str8;
            this.albumadamid = str9;
        }

        public Track() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (Images) null, (Share) null, (Hub) null, (List) null, (String) null, (List) null, (String) null, (Genres) null, (String) null, (String) null, 32767, (DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ ShazamResponseJson(int i, List list, Location location, Long l, String str, Track track, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.matches = null;
        } else {
            this.matches = list;
        }
        if ((i & 2) == 0) {
            this.location = null;
        } else {
            this.location = location;
        }
        if ((i & 4) == 0) {
            this.timestamp = null;
        } else {
            this.timestamp = l;
        }
        if ((i & 8) == 0) {
            this.timezone = null;
        } else {
            this.timezone = str;
        }
        if ((i & 16) == 0) {
            this.track = null;
        } else {
            this.track = track;
        }
        if ((i & 32) == 0) {
            this.tagid = null;
        } else {
            this.tagid = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashSetSerializer(HexFormatKt.getNullable(ShazamResponseJson$Match$$serializer.INSTANCE), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShazamResponseJson copy$default(ShazamResponseJson shazamResponseJson, List list, Location location, Long l, String str, Track track, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shazamResponseJson.matches;
        }
        if ((i & 2) != 0) {
            location = shazamResponseJson.location;
        }
        if ((i & 4) != 0) {
            l = shazamResponseJson.timestamp;
        }
        if ((i & 8) != 0) {
            str = shazamResponseJson.timezone;
        }
        if ((i & 16) != 0) {
            track = shazamResponseJson.track;
        }
        if ((i & 32) != 0) {
            str2 = shazamResponseJson.tagid;
        }
        Track track2 = track;
        String str3 = str2;
        return shazamResponseJson.copy(list, location, l, str, track2, str3);
    }

    public static final /* synthetic */ void write$Self$app(ShazamResponseJson self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.matches != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.matches);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.location != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ShazamResponseJson$Location$$serializer.INSTANCE, self.location);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.timestamp != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.timestamp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.timezone != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.timezone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.track != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, ShazamResponseJson$Track$$serializer.INSTANCE, self.track);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.tagid == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.tagid);
    }

    public final List<Match> component1() {
        return this.matches;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTimezone() {
        return this.timezone;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Track getTrack() {
        return this.track;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTagid() {
        return this.tagid;
    }

    public final ShazamResponseJson copy(List<Match> matches, Location location, Long timestamp, String timezone, Track track, String tagid) {
        return new ShazamResponseJson(matches, location, timestamp, timezone, track, tagid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShazamResponseJson)) {
            return false;
        }
        ShazamResponseJson shazamResponseJson = (ShazamResponseJson) other;
        return Intrinsics.areEqual(this.matches, shazamResponseJson.matches) && Intrinsics.areEqual(this.location, shazamResponseJson.location) && Intrinsics.areEqual(this.timestamp, shazamResponseJson.timestamp) && Intrinsics.areEqual(this.timezone, shazamResponseJson.timezone) && Intrinsics.areEqual(this.track, shazamResponseJson.track) && Intrinsics.areEqual(this.tagid, shazamResponseJson.tagid);
    }

    public final Location getLocation() {
        return this.location;
    }

    public final List<Match> getMatches() {
        return this.matches;
    }

    public final String getTagid() {
        return this.tagid;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final Track getTrack() {
        return this.track;
    }

    public int hashCode() {
        List<Match> list = this.matches;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Location location = this.location;
        int iHashCode2 = (iHashCode + (location == null ? 0 : location.hashCode())) * 31;
        Long l = this.timestamp;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.timezone;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Track track = this.track;
        int iHashCode5 = (iHashCode4 + (track == null ? 0 : track.hashCode())) * 31;
        String str2 = this.tagid;
        return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ShazamResponseJson(matches=" + this.matches + ", location=" + this.location + ", timestamp=" + this.timestamp + ", timezone=" + this.timezone + ", track=" + this.track + ", tagid=" + this.tagid + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\nHÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004J)\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001b\u0002\b/¢\u0006\u0002\b.R.\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0002¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R.\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0005¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R.\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011Ê\u0001\u0002\b3Ê\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0003\u0010\u0002¨\u00062"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Location;", "", "latitude", "", "longitude", "altitude", "accuracy", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLatitude$annotations", "()V", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "Lkotlinx/serialization/SerialName;", "value", "getLongitude$annotations", "getLongitude", "getAltitude$annotations", "getAltitude", "getAccuracy$annotations", "getAccuracy", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/metrolist/shazamkit/models/ShazamResponseJson$Location;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Location {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Double accuracy;
        private final Double altitude;
        private final Double latitude;
        private final Double longitude;

        public /* synthetic */ Location(int i, Double d, Double d2, Double d3, Double d4, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.latitude = null;
            } else {
                this.latitude = d;
            }
            if ((i & 2) == 0) {
                this.longitude = null;
            } else {
                this.longitude = d2;
            }
            if ((i & 4) == 0) {
                this.altitude = null;
            } else {
                this.altitude = d3;
            }
            if ((i & 8) == 0) {
                this.accuracy = null;
            } else {
                this.accuracy = d4;
            }
        }

        public static /* synthetic */ Location copy$default(Location location, Double d, Double d2, Double d3, Double d4, int i, Object obj) {
            if ((i & 1) != 0) {
                d = location.latitude;
            }
            if ((i & 2) != 0) {
                d2 = location.longitude;
            }
            if ((i & 4) != 0) {
                d3 = location.altitude;
            }
            if ((i & 8) != 0) {
                d4 = location.accuracy;
            }
            return location.copy(d, d2, d3, d4);
        }

        public static final /* synthetic */ void write$Self$app(Location self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.latitude != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, DoubleSerializer.INSTANCE, self.latitude);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.longitude != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.longitude);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.altitude != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, DoubleSerializer.INSTANCE, self.altitude);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.accuracy == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.accuracy);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Double getLatitude() {
            return this.latitude;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Double getLongitude() {
            return this.longitude;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Double getAltitude() {
            return this.altitude;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Double getAccuracy() {
            return this.accuracy;
        }

        public final Location copy(Double latitude, Double longitude, Double altitude, Double accuracy) {
            return new Location(latitude, longitude, altitude, accuracy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Location)) {
                return false;
            }
            Location location = (Location) other;
            return Intrinsics.areEqual(this.latitude, location.latitude) && Intrinsics.areEqual(this.longitude, location.longitude) && Intrinsics.areEqual(this.altitude, location.altitude) && Intrinsics.areEqual(this.accuracy, location.accuracy);
        }

        public final Double getAccuracy() {
            return this.accuracy;
        }

        public final Double getAltitude() {
            return this.altitude;
        }

        public final Double getLatitude() {
            return this.latitude;
        }

        public final Double getLongitude() {
            return this.longitude;
        }

        public int hashCode() {
            Double d = this.latitude;
            int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
            Double d2 = this.longitude;
            int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
            Double d3 = this.altitude;
            int iHashCode3 = (iHashCode2 + (d3 == null ? 0 : d3.hashCode())) * 31;
            Double d4 = this.accuracy;
            return iHashCode3 + (d4 != null ? d4.hashCode() : 0);
        }

        public String toString() {
            return "Location(latitude=" + this.latitude + ", longitude=" + this.longitude + ", altitude=" + this.altitude + ", accuracy=" + this.accuracy + ")";
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Location$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Location;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer serializer() {
                return ShazamResponseJson$Location$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public static /* synthetic */ void getAccuracy$annotations() {
        }

        public static /* synthetic */ void getAltitude$annotations() {
        }

        public static /* synthetic */ void getLatitude$annotations() {
        }

        public static /* synthetic */ void getLongitude$annotations() {
        }

        public Location() {
            this((Double) null, (Double) null, (Double) null, (Double) null, 15, (DefaultConstructorMarker) null);
        }

        public Location(Double d, Double d2, Double d3, Double d4) {
            this.latitude = d;
            this.longitude = d2;
            this.altitude = d3;
            this.accuracy = d4;
        }

        public /* synthetic */ Location(Double d, Double d2, Double d3, Double d4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? null : d3, (i & 8) != 0 ? null : d4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J>\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001b\u0002\b0¢\u0006\u0002\b/R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R.\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R.\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0017R.\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0007¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0017Ê\u0001\u0002\b4Ê\u0001\f\b5\u0012\b\b6\u0012\u0004\b\u0003\u0010\u0002¨\u00063"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Match;", "", "id", "", "offset", "", "timeskew", "frequencyskew", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getOffset$annotations", "getOffset", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTimeskew$annotations", "getTimeskew", "getFrequencyskew$annotations", "getFrequencyskew", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/metrolist/shazamkit/models/ShazamResponseJson$Match;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Match {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Double frequencyskew;
        private final String id;
        private final Double offset;
        private final Double timeskew;

        public /* synthetic */ Match(int i, String str, Double d, Double d2, Double d3, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.id = null;
            } else {
                this.id = str;
            }
            if ((i & 2) == 0) {
                this.offset = null;
            } else {
                this.offset = d;
            }
            if ((i & 4) == 0) {
                this.timeskew = null;
            } else {
                this.timeskew = d2;
            }
            if ((i & 8) == 0) {
                this.frequencyskew = null;
            } else {
                this.frequencyskew = d3;
            }
        }

        public static /* synthetic */ Match copy$default(Match match, String str, Double d, Double d2, Double d3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = match.id;
            }
            if ((i & 2) != 0) {
                d = match.offset;
            }
            if ((i & 4) != 0) {
                d2 = match.timeskew;
            }
            if ((i & 8) != 0) {
                d3 = match.frequencyskew;
            }
            return match.copy(str, d, d2, d3);
        }

        public static final /* synthetic */ void write$Self$app(Match self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.offset != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.offset);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.timeskew != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, DoubleSerializer.INSTANCE, self.timeskew);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.frequencyskew == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.frequencyskew);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Double getOffset() {
            return this.offset;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Double getTimeskew() {
            return this.timeskew;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Double getFrequencyskew() {
            return this.frequencyskew;
        }

        public final Match copy(String id, Double offset, Double timeskew, Double frequencyskew) {
            return new Match(id, offset, timeskew, frequencyskew);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Match)) {
                return false;
            }
            Match match = (Match) other;
            return Intrinsics.areEqual(this.id, match.id) && Intrinsics.areEqual(this.offset, match.offset) && Intrinsics.areEqual(this.timeskew, match.timeskew) && Intrinsics.areEqual(this.frequencyskew, match.frequencyskew);
        }

        public final Double getFrequencyskew() {
            return this.frequencyskew;
        }

        public final String getId() {
            return this.id;
        }

        public final Double getOffset() {
            return this.offset;
        }

        public final Double getTimeskew() {
            return this.timeskew;
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Double d = this.offset;
            int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.timeskew;
            int iHashCode3 = (iHashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
            Double d3 = this.frequencyskew;
            return iHashCode3 + (d3 != null ? d3.hashCode() : 0);
        }

        public String toString() {
            return "Match(id=" + this.id + ", offset=" + this.offset + ", timeskew=" + this.timeskew + ", frequencyskew=" + this.frequencyskew + ")";
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Match$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Match;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer serializer() {
                return ShazamResponseJson$Match$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public static /* synthetic */ void getFrequencyskew$annotations() {
        }

        public static /* synthetic */ void getId$annotations() {
        }

        public static /* synthetic */ void getOffset$annotations() {
        }

        public static /* synthetic */ void getTimeskew$annotations() {
        }

        public Match() {
            this((String) null, (Double) null, (Double) null, (Double) null, 15, (DefaultConstructorMarker) null);
        }

        public Match(String str, Double d, Double d2, Double d3) {
            this.id = str;
            this.offset = d;
            this.timeskew = d2;
            this.frequencyskew = d3;
        }

        public /* synthetic */ Match(String str, Double d, Double d2, Double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2, (i & 8) != 0 ? null : d3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/metrolist/shazamkit/models/ShazamResponseJson$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return ShazamResponseJson$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void getLocation$annotations() {
    }

    public static /* synthetic */ void getMatches$annotations() {
    }

    public static /* synthetic */ void getTagid$annotations() {
    }

    public static /* synthetic */ void getTimestamp$annotations() {
    }

    public static /* synthetic */ void getTimezone$annotations() {
    }

    public static /* synthetic */ void getTrack$annotations() {
    }

    public ShazamResponseJson() {
        this((List) null, (Location) null, (Long) null, (String) null, (Track) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public ShazamResponseJson(List<Match> list, Location location, Long l, String str, Track track, String str2) {
        this.matches = list;
        this.location = location;
        this.timestamp = l;
        this.timezone = str;
        this.track = track;
        this.tagid = str2;
    }

    public /* synthetic */ ShazamResponseJson(List list, Location location, Long l, String str, Track track, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : location, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : track, (i & 32) != 0 ? null : str2);
    }
}
