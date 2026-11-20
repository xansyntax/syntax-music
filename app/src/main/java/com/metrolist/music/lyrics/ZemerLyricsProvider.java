package com.metrolist.music.lyrics;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.music.constants.PreferenceKeysKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.LinesIterator;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.json.JsonObject;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ZemerLyricsProvider implements LyricsProvider {
    public static final ZemerLyricsProvider INSTANCE = new ZemerLyricsProvider();
    public static final JsonImpl json = UuidKt.Json$default(new LyricsPlusProvider$$ExternalSyntheticLambda6(12));
    public static final SynchronizedLazyImpl client$delegate = new SynchronizedLazyImpl(new LyricLine$$ExternalSyntheticLambda0((byte) 13));
    public static final Regex NUMERIC_ENTITY = new Regex("&#(\\d+);");
    public static final Regex TAG = new Regex("<[^>]+>");
    public static final Regex BR = new Regex("<br\\s*/?>", 0);
    public static final Regex SPACES = new Regex("[ \\t ]+");
    public static final Regex JYRICS_CUT = new Regex("<ul[^>]*class=\"[^\"]*related-list|<h\\d[^>]*>\\s*Other Songs from", 0);
    public static final Regex JYRICS_SCRIPT = new Regex("<script[\\s\\S]*?</script>|<style[\\s\\S]*?</style>|<!--[\\s\\S]*?-->");
    public static final Regex JYRICS_NAV = new Regex("^(Print|SHARE|Added by|admin)$", 0);
    public static final Regex LABEL = new Regex("^\\(?\\s*(verse|chorus|bridge|intro|outro|pre-?chorus|hook|refrain|interlude|פזמון|בית|גשר|מעבר|סיום|פתיחה)\\s*[\\d\\w]*\\s*:?\\s*\\)?$", 0);
    public static final Regex CREDIT = new Regex("^\\(?\\s*(composed|arranged|written|lyrics|words|music|produced|recorded|later recorded|originally|from the album|album)\\b[^\\n]*\\bby\\b|^\\(?\\s*(composed|arranged|recorded)\\b|^(מילים|לחן|עיבוד|הפקה)\\s*:", 0);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/lyrics/ZemerLyricsProvider$FeedLine", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class FeedLine {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final Double start;
        public final String text;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/ZemerLyricsProvider$FeedLine$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/ZemerLyricsProvider$FeedLine;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ZemerLyricsProvider$FeedLine$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ FeedLine(int i, Double d, String str) {
            if ((i & 1) == 0) {
                this.start = null;
            } else {
                this.start = d;
            }
            if ((i & 2) == 0) {
                this.text = null;
            } else {
                this.text = str;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FeedLine)) {
                return false;
            }
            FeedLine feedLine = (FeedLine) obj;
            return Intrinsics.areEqual(this.start, feedLine.start) && Intrinsics.areEqual(this.text, feedLine.text);
        }

        public final int hashCode() {
            Double d = this.start;
            int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
            String str = this.text;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final String toString() {
            return "FeedLine(start=" + this.start + ", text=" + this.text + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/lyrics/ZemerLyricsProvider$FeedPage", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class FeedPage {
        public final List data;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LyricLine$$ExternalSyntheticLambda0((byte) 7))};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/ZemerLyricsProvider$FeedPage$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/ZemerLyricsProvider$FeedPage;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ZemerLyricsProvider$FeedPage$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ FeedPage(int i, List list) {
            if ((i & 1) == 0) {
                this.data = EmptyList.INSTANCE;
            } else {
                this.data = list;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FeedPage) && Intrinsics.areEqual(this.data, ((FeedPage) obj).data);
        }

        public final int hashCode() {
            return this.data.hashCode();
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("FeedPage(data=", ")", this.data);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/lyrics/ZemerLyricsProvider$FeedSong", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class FeedSong {
        public final Integer duration;
        public final long id;
        public final List lyrics;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LyricLine$$ExternalSyntheticLambda0((byte) 8))};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/ZemerLyricsProvider$FeedSong$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/ZemerLyricsProvider$FeedSong;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ZemerLyricsProvider$FeedSong$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ FeedSong(int i, long j, Integer num, List list) {
            if (1 != (i & 1)) {
                EnumsKt.throwMissingFieldException(ZemerLyricsProvider$FeedSong$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.id = j;
            if ((i & 2) == 0) {
                this.duration = null;
            } else {
                this.duration = num;
            }
            if ((i & 4) == 0) {
                this.lyrics = EmptyList.INSTANCE;
            } else {
                this.lyrics = list;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FeedSong)) {
                return false;
            }
            FeedSong feedSong = (FeedSong) obj;
            return this.id == feedSong.id && Intrinsics.areEqual(this.duration, feedSong.duration) && Intrinsics.areEqual(this.lyrics, feedSong.lyrics);
        }

        public final int hashCode() {
            int iHashCode = Long.hashCode(this.id) * 31;
            Integer num = this.duration;
            return this.lyrics.hashCode() + ((iHashCode + (num == null ? 0 : num.hashCode())) * 31);
        }

        public final String toString() {
            return "FeedSong(id=" + this.id + ", duration=" + this.duration + ", lyrics=" + this.lyrics + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/lyrics/ZemerLyricsProvider$LrcLibTrack", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class LrcLibTrack {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final boolean instrumental;
        public final String plainLyrics;
        public final String syncedLyrics;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/ZemerLyricsProvider$LrcLibTrack$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/ZemerLyricsProvider$LrcLibTrack;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ZemerLyricsProvider$LrcLibTrack$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ LrcLibTrack(int i, String str, String str2, boolean z) {
            if ((i & 1) == 0) {
                this.syncedLyrics = null;
            } else {
                this.syncedLyrics = str;
            }
            if ((i & 2) == 0) {
                this.plainLyrics = null;
            } else {
                this.plainLyrics = str2;
            }
            if ((i & 4) == 0) {
                this.instrumental = false;
            } else {
                this.instrumental = z;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LrcLibTrack)) {
                return false;
            }
            LrcLibTrack lrcLibTrack = (LrcLibTrack) obj;
            return Intrinsics.areEqual(this.syncedLyrics, lrcLibTrack.syncedLyrics) && Intrinsics.areEqual(this.plainLyrics, lrcLibTrack.plainLyrics) && this.instrumental == lrcLibTrack.instrumental;
        }

        public final int hashCode() {
            String str = this.syncedLyrics;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.plainLyrics;
            return Boolean.hashCode(this.instrumental) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("LrcLibTrack(syncedLyrics=", this.syncedLyrics, ", plainLyrics=", this.plainLyrics, ", instrumental="), this.instrumental, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/lyrics/ZemerLyricsProvider$Resolved", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class Resolved {
        public final boolean hasSynced;
        public final String lang;
        public final List sources;
        public final boolean verified;
        public final String videoId;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {null, null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LyricLine$$ExternalSyntheticLambda0((byte) 9))};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/ZemerLyricsProvider$Resolved$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/ZemerLyricsProvider$Resolved;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ZemerLyricsProvider$Resolved$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Resolved(int i, String str, String str2, boolean z, boolean z2, List list) {
            if (1 != (i & 1)) {
                EnumsKt.throwMissingFieldException(ZemerLyricsProvider$Resolved$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.videoId = str;
            if ((i & 2) == 0) {
                this.lang = null;
            } else {
                this.lang = str2;
            }
            if ((i & 4) == 0) {
                this.verified = false;
            } else {
                this.verified = z;
            }
            if ((i & 8) == 0) {
                this.hasSynced = false;
            } else {
                this.hasSynced = z2;
            }
            if ((i & 16) == 0) {
                this.sources = EmptyList.INSTANCE;
            } else {
                this.sources = list;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resolved)) {
                return false;
            }
            Resolved resolved = (Resolved) obj;
            return Intrinsics.areEqual(this.videoId, resolved.videoId) && Intrinsics.areEqual(this.lang, resolved.lang) && this.verified == resolved.verified && this.hasSynced == resolved.hasSynced && Intrinsics.areEqual(this.sources, resolved.sources);
        }

        public final int hashCode() {
            int iHashCode = this.videoId.hashCode() * 31;
            String str = this.lang;
            return this.sources.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode + (str == null ? 0 : str.hashCode())) * 31, this.verified, 31), this.hasSynced, 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Resolved(videoId=", this.videoId, ", lang=", this.lang, ", verified=");
            Fragment$5$$ExternalSyntheticOutline0.m(sbM, this.verified, ", hasSynced=", this.hasSynced, ", sources=");
            sbM.append(this.sources);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/lyrics/ZemerLyricsProvider$Source", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class Source {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String feedUrl;
        public final String plain;
        public final Long songId;
        public final boolean synced;
        public final String syncedLrc;
        public final Long trackId;
        public final String type;
        public final String url;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/ZemerLyricsProvider$Source$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/ZemerLyricsProvider$Source;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ZemerLyricsProvider$Source$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Source(int i, String str, String str2, Long l, String str3, Long l2, String str4, String str5, boolean z) {
            if (1 != (i & 1)) {
                EnumsKt.throwMissingFieldException(ZemerLyricsProvider$Source$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.type = str;
            if ((i & 2) == 0) {
                this.url = null;
            } else {
                this.url = str2;
            }
            if ((i & 4) == 0) {
                this.songId = null;
            } else {
                this.songId = l;
            }
            if ((i & 8) == 0) {
                this.feedUrl = null;
            } else {
                this.feedUrl = str3;
            }
            if ((i & 16) == 0) {
                this.trackId = null;
            } else {
                this.trackId = l2;
            }
            if ((i & 32) == 0) {
                this.plain = null;
            } else {
                this.plain = str4;
            }
            if ((i & 64) == 0) {
                this.syncedLrc = null;
            } else {
                this.syncedLrc = str5;
            }
            if ((i & 128) == 0) {
                this.synced = false;
            } else {
                this.synced = z;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Source)) {
                return false;
            }
            Source source = (Source) obj;
            return Intrinsics.areEqual(this.type, source.type) && Intrinsics.areEqual(this.url, source.url) && Intrinsics.areEqual(this.songId, source.songId) && Intrinsics.areEqual(this.feedUrl, source.feedUrl) && Intrinsics.areEqual(this.trackId, source.trackId) && Intrinsics.areEqual(this.plain, source.plain) && Intrinsics.areEqual(this.syncedLrc, source.syncedLrc) && this.synced == source.synced;
        }

        public final int hashCode() {
            int iHashCode = this.type.hashCode() * 31;
            String str = this.url;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.songId;
            int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
            String str2 = this.feedUrl;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l2 = this.trackId;
            int iHashCode5 = (iHashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
            String str3 = this.plain;
            int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.syncedLrc;
            return Boolean.hashCode(this.synced) + ((iHashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Source(type=", this.type, ", url=", this.url, ", songId=");
            sbM.append(this.songId);
            sbM.append(", feedUrl=");
            sbM.append(this.feedUrl);
            sbM.append(", trackId=");
            sbM.append(this.trackId);
            sbM.append(", plain=");
            sbM.append(this.plain);
            sbM.append(", syncedLrc=");
            sbM.append(this.syncedLrc);
            sbM.append(", synced=");
            sbM.append(this.synced);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.ZemerLyricsProvider$fetchBody$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZemerLyricsProvider.this.fetchBody(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.ZemerLyricsProvider$fetchText$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01611 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01611(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZemerLyricsProvider.this.fetchText(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.ZemerLyricsProvider$resolve$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01621 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01621(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZemerLyricsProvider.this.resolve(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.ZemerLyricsProvider$zingLyricsHtml$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01631 extends ContinuationImpl {
        public long J$0;
        public JsonImpl L$2;
        public int label;
        public /* synthetic */ Object result;

        public C01631(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZemerLyricsProvider.this.zingLyricsHtml(0L, this);
        }
    }

    public static String tidy(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String string = StringsKt.trim(SPACES.replace((String) it.next(), ServerSentEventKt.SPACE)).toString();
            if (string.length() > 0 || (!arrayList.isEmpty() && ((CharSequence) CollectionsKt.last(arrayList)).length() > 0)) {
                arrayList.add(string);
            }
        }
        while (!arrayList.isEmpty() && ((CharSequence) CollectionsKt.last(arrayList)).length() == 0) {
            arrayList.remove(arrayList.size() - 1);
        }
        while (!arrayList.isEmpty() && ((CharSequence) CollectionsKt.first((List) arrayList)).length() == 0) {
            arrayList.remove(0);
        }
        return CollectionsKt.joinToString$default(arrayList, "\n", null, null, null, 62);
    }

    public static String unescape(String str) {
        return NUMERIC_ENTITY.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(str, "&#8217;", "'", false), "&rsquo;", "'", false), "&#8211;", "–", false), "&ndash;", "–", false), "&amp;", "&", false), "&quot;", "\"", false), "&#039;", "'", false), "&nbsp;", ServerSentEventKt.SPACE, false), new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 16));
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0296  */
    /* JADX WARN: Code duplicated, block: B:127:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:138:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:140:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:143:0x02fd A[LOOP:10: B:139:0x02d0->B:143:0x02fd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:146:0x0317  */
    /* JADX WARN: Code duplicated, block: B:278:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:281:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:284:0x05fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:287:0x0602  */
    /* JADX WARN: Code duplicated, block: B:345:0x02c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:367:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v44 java.lang.Object, still in use, count: 2, list:
          (r1v44 java.lang.Object) from 0x0292: PHI (r1 I:??) = (r1v32 java.lang.Object), (r1v44 java.lang.Object) binds: [B:121:0x0291, B:333:0x0292] A[DONT_GENERATE, DONT_INLINE]
          (r1v44 java.lang.Object) from 0x0288: CHECK_CAST (com.metrolist.music.lyrics.ZemerLyricsProvider$FeedSong) (r1v44 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public final java.lang.Object fetchBody(com.metrolist.music.lyrics.ZemerLyricsProvider.Source r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            Method dump skipped, instruction units count: 1612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.lyrics.ZemerLyricsProvider.fetchBody(com.metrolist.music.lyrics.ZemerLyricsProvider$Source, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
    
        if (r6 == r4) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchText(String str, ContinuationImpl continuationImpl) {
        C01611 c01611;
        if (continuationImpl instanceof C01611) {
            c01611 = (C01611) continuationImpl;
            int i = c01611.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01611.label = i - Integer.MIN_VALUE;
            } else {
                c01611 = new C01611(continuationImpl);
            }
        } else {
            c01611 = new C01611(continuationImpl);
        }
        Object objExecute = c01611.result;
        int i2 = c01611.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objExecute);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute);
            }
            return (String) objExecute;
        }
        ResultKt.throwOnFailure(objExecute);
        HttpClient httpClient = (HttpClient) client$delegate.getValue();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        UtilsKt.header(httpRequestBuilder, HttpHeaders.Accept, "text/html,application/json");
        HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
        c01611.label = 1;
        objExecute = httpStatementM.execute(c01611);
        if (objExecute != coroutineSingletons) {
        }
        return coroutineSingletons;
        HttpResponse httpResponse = (HttpResponse) objExecute;
        if (!Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getOK())) {
            return null;
        }
        c01611.label = 2;
        objExecute = HttpResponseKt.bodyAsText$default(httpResponse, null, c01611, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0088 A[Catch: all -> 0x0109, TRY_LEAVE, TryCatch #1 {all -> 0x0109, blocks: (B:38:0x00aa, B:40:0x00b0, B:41:0x00be, B:44:0x00c3, B:29:0x0082, B:31:0x0088, B:59:0x00ef, B:60:0x00f6, B:46:0x00c7, B:47:0x00d0, B:49:0x00d6, B:51:0x00e2, B:54:0x00e7, B:55:0x00ea, B:37:0x00a4, B:20:0x0046, B:26:0x005c, B:28:0x0060, B:61:0x00f7, B:62:0x0108, B:23:0x004d, B:13:0x0034, B:35:0x00a1, B:32:0x008e), top: B:68:0x0024, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b0 A[Catch: all -> 0x0109, TryCatch #1 {all -> 0x0109, blocks: (B:38:0x00aa, B:40:0x00b0, B:41:0x00be, B:44:0x00c3, B:29:0x0082, B:31:0x0088, B:59:0x00ef, B:60:0x00f6, B:46:0x00c7, B:47:0x00d0, B:49:0x00d6, B:51:0x00e2, B:54:0x00e7, B:55:0x00ea, B:37:0x00a4, B:20:0x0046, B:26:0x005c, B:28:0x0060, B:61:0x00f7, B:62:0x0108, B:23:0x004d, B:13:0x0034, B:35:0x00a1, B:32:0x008e), top: B:68:0x0024, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c7 A[Catch: all -> 0x0109, TryCatch #1 {all -> 0x0109, blocks: (B:38:0x00aa, B:40:0x00b0, B:41:0x00be, B:44:0x00c3, B:29:0x0082, B:31:0x0088, B:59:0x00ef, B:60:0x00f6, B:46:0x00c7, B:47:0x00d0, B:49:0x00d6, B:51:0x00e2, B:54:0x00e7, B:55:0x00ea, B:37:0x00a4, B:20:0x0046, B:26:0x005c, B:28:0x0060, B:61:0x00f7, B:62:0x0108, B:23:0x004d, B:13:0x0034, B:35:0x00a1, B:32:0x008e), top: B:68:0x0024, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00d6 A[Catch: all -> 0x0109, TryCatch #1 {all -> 0x0109, blocks: (B:38:0x00aa, B:40:0x00b0, B:41:0x00be, B:44:0x00c3, B:29:0x0082, B:31:0x0088, B:59:0x00ef, B:60:0x00f6, B:46:0x00c7, B:47:0x00d0, B:49:0x00d6, B:51:0x00e2, B:54:0x00e7, B:55:0x00ea, B:37:0x00a4, B:20:0x0046, B:26:0x005c, B:28:0x0060, B:61:0x00f7, B:62:0x0108, B:23:0x004d, B:13:0x0034, B:35:0x00a1, B:32:0x008e), top: B:68:0x0024, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ef A[Catch: all -> 0x0109, TryCatch #1 {all -> 0x0109, blocks: (B:38:0x00aa, B:40:0x00b0, B:41:0x00be, B:44:0x00c3, B:29:0x0082, B:31:0x0088, B:59:0x00ef, B:60:0x00f6, B:46:0x00c7, B:47:0x00d0, B:49:0x00d6, B:51:0x00e2, B:54:0x00e7, B:55:0x00ea, B:37:0x00a4, B:20:0x0046, B:26:0x005c, B:28:0x0060, B:61:0x00f7, B:62:0x0108, B:23:0x004d, B:13:0x0034, B:35:0x00a1, B:32:0x008e), top: B:68:0x0024, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009e, code lost:
    
        if (r8 == r3) goto L34;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x009e -> B:35:0x00a1). Please report as a decompilation issue!!! */
    @Override // com.metrolist.music.lyrics.LyricsProvider
    /* JADX INFO: renamed from: getLyrics-bMdYcbs */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo1450getLyricsbMdYcbs(Context context, String str, String str2, String str3, int i, String str4, ContinuationImpl continuationImpl) {
        ZemerLyricsProvider$getLyrics$1 zemerLyricsProvider$getLyrics$1;
        ZemerLyricsProvider zemerLyricsProvider;
        int i2;
        Iterator it;
        Source source;
        Object failure;
        String str5;
        LinesIterator linesIterator;
        int i3;
        if (continuationImpl instanceof ZemerLyricsProvider$getLyrics$1) {
            zemerLyricsProvider$getLyrics$1 = (ZemerLyricsProvider$getLyrics$1) continuationImpl;
            int i4 = zemerLyricsProvider$getLyrics$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                zemerLyricsProvider$getLyrics$1.label = i4 - Integer.MIN_VALUE;
            } else {
                zemerLyricsProvider$getLyrics$1 = new ZemerLyricsProvider$getLyrics$1(this, continuationImpl);
            }
        } else {
            zemerLyricsProvider$getLyrics$1 = new ZemerLyricsProvider$getLyrics$1(this, continuationImpl);
        }
        Object objResolve = zemerLyricsProvider$getLyrics$1.result;
        int i5 = zemerLyricsProvider$getLyrics$1.label;
        byte b = 1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(objResolve);
                zemerLyricsProvider$getLyrics$1.L$1 = str;
                zemerLyricsProvider$getLyrics$1.L$5 = this;
                zemerLyricsProvider$getLyrics$1.I$0 = i;
                zemerLyricsProvider$getLyrics$1.label = 1;
                objResolve = resolve(str, zemerLyricsProvider$getLyrics$1);
                if (objResolve == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i5 == 1) {
                i = zemerLyricsProvider$getLyrics$1.I$0;
                this = zemerLyricsProvider$getLyrics$1.L$5;
                str = zemerLyricsProvider$getLyrics$1.L$1;
                ResultKt.throwOnFailure(objResolve);
            } else {
                if (i5 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i2 = zemerLyricsProvider$getLyrics$1.I$0;
                source = (Source) zemerLyricsProvider$getLyrics$1.L$8;
                it = zemerLyricsProvider$getLyrics$1.L$6;
                zemerLyricsProvider = zemerLyricsProvider$getLyrics$1.L$5;
                try {
                    ResultKt.throwOnFailure(objResolve);
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                    if (Result.m1866exceptionOrNullimpl(failure) != null) {
                        Timber.Forest.tag("Zemer");
                        String str6 = source.type;
                        ConnectionPool.d$1(new Object[0]);
                    }
                    if (failure instanceof Result.Failure) {
                        failure = null;
                    }
                    str5 = (String) failure;
                    if (str5 != null) {
                        zemerLyricsProvider.getClass();
                        linesIterator = new LinesIterator(str5);
                        i3 = 0;
                        while (linesIterator.hasNext()) {
                            if (!StringsKt.isBlank((String) linesIterator.next())) {
                                CollectionsKt__IterablesKt.throwCountOverflow();
                                throw null;
                            }
                        }
                        if (i3 >= 4) {
                            return str5;
                        }
                    }
                    if (!it.hasNext()) {
                        throw new IllegalStateException("No Zemer source yielded a body");
                    }
                    source = (Source) it.next();
                    zemerLyricsProvider$getLyrics$1.L$1 = null;
                    zemerLyricsProvider$getLyrics$1.L$5 = zemerLyricsProvider;
                    zemerLyricsProvider$getLyrics$1.L$6 = it;
                    zemerLyricsProvider$getLyrics$1.L$8 = source;
                    zemerLyricsProvider$getLyrics$1.I$0 = i2;
                    zemerLyricsProvider$getLyrics$1.label = 2;
                    objResolve = zemerLyricsProvider.fetchBody(source, zemerLyricsProvider$getLyrics$1);
                }
                failure = (String) objResolve;
                if (Result.m1866exceptionOrNullimpl(failure) != null) {
                    Timber.Forest.tag("Zemer");
                    String str7 = source.type;
                    ConnectionPool.d$1(new Object[0]);
                }
                if (failure instanceof Result.Failure) {
                    failure = null;
                }
                str5 = (String) failure;
                if (str5 != null) {
                    zemerLyricsProvider.getClass();
                    linesIterator = new LinesIterator(str5);
                    i3 = 0;
                    while (linesIterator.hasNext()) {
                        if (!StringsKt.isBlank((String) linesIterator.next()) && (i3 = i3 + 1) < 0) {
                            CollectionsKt__IterablesKt.throwCountOverflow();
                            throw null;
                        }
                    }
                    if (i3 >= 4) {
                        return str5;
                    }
                }
                if (!it.hasNext()) {
                    throw new IllegalStateException("No Zemer source yielded a body");
                }
                source = (Source) it.next();
                zemerLyricsProvider$getLyrics$1.L$1 = null;
                zemerLyricsProvider$getLyrics$1.L$5 = zemerLyricsProvider;
                zemerLyricsProvider$getLyrics$1.L$6 = it;
                zemerLyricsProvider$getLyrics$1.L$8 = source;
                zemerLyricsProvider$getLyrics$1.I$0 = i2;
                zemerLyricsProvider$getLyrics$1.label = 2;
                objResolve = zemerLyricsProvider.fetchBody(source, zemerLyricsProvider$getLyrics$1);
            }
            Resolved resolved = (Resolved) objResolve;
            if (resolved == null) {
                throw new IllegalStateException("Zemer has no lyrics for " + str);
            }
            Iterator it2 = CollectionsKt.sortedWith(resolved.sources, RegexKt.compareBy(new LyricsPlusProvider$$ExternalSyntheticLambda6(b), new Function1() { // from class: com.metrolist.music.lyrics.ZemerLyricsProvider$$ExternalSyntheticLambda6
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code duplicated, block: B:27:0x005a  */
                /* JADX WARN: Code duplicated, block: B:37:0x0078  */
                /* JADX WARN: Code duplicated, block: B:40:0x0082  */
                /* JADX WARN: Code duplicated, block: B:41:0x0085  */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int i6;
                    ZemerLyricsProvider.Source source2 = (ZemerLyricsProvider.Source) obj;
                    source2.getClass();
                    this.f$0.getClass();
                    switch (source2.type) {
                        case "community":
                            i6 = 3;
                            break;
                        case "zingmusic":
                        case "jyrics":
                        case "lrclib":
                            i6 = 1;
                            break;
                        case "manual":
                            i6 = 2;
                            break;
                        case "jkaraoke":
                            i6 = 0;
                            break;
                        case "shironet":
                        case "zemirotdb":
                            i6 = 1;
                            break;
                        case "booklet":
                            i6 = 2;
                            break;
                        case "tab4u":
                            i6 = 1;
                            break;
                        case "canonical":
                            i6 = 3;
                            break;
                        default:
                            i6 = 9;
                            break;
                    }
                    return Integer.valueOf(i6);
                }
            })).iterator();
            int i6 = i;
            zemerLyricsProvider = this;
            i2 = i6;
            it = it2;
            if (!it.hasNext()) {
                throw new IllegalStateException("No Zemer source yielded a body");
            }
            source = (Source) it.next();
            zemerLyricsProvider$getLyrics$1.L$1 = null;
            zemerLyricsProvider$getLyrics$1.L$5 = zemerLyricsProvider;
            zemerLyricsProvider$getLyrics$1.L$6 = it;
            zemerLyricsProvider$getLyrics$1.L$8 = source;
            zemerLyricsProvider$getLyrics$1.I$0 = i2;
            zemerLyricsProvider$getLyrics$1.label = 2;
            objResolve = zemerLyricsProvider.fetchBody(source, zemerLyricsProvider$getLyrics$1);
        } catch (Throwable th2) {
            return new Result.Failure(th2);
        }
    }

    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final String getName() {
        return "Zemer";
    }

    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final boolean isEnabled(Context context) {
        Boolean bool = (Boolean) com.metrolist.music.utils.UtilsKt.get(com.metrolist.music.utils.UtilsKt.getDataStore(context), PreferenceKeysKt.EnableZemerKey);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0094, code lost:
    
        if (r6 == r4) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolve(String str, ContinuationImpl continuationImpl) {
        C01621 c01621;
        TypeReference typeReferenceTypeOf;
        if (continuationImpl instanceof C01621) {
            c01621 = (C01621) continuationImpl;
            int i = c01621.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01621.label = i - Integer.MIN_VALUE;
            } else {
                c01621 = new C01621(continuationImpl);
            }
        } else {
            c01621 = new C01621(continuationImpl);
        }
        Object objExecute = c01621.result;
        int i2 = c01621.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objExecute);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute);
            }
            if (objExecute != null) {
                return (Resolved) objExecute;
            }
            PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type com.metrolist.music.lyrics.ZemerLyricsProvider.Resolved");
            return null;
        }
        ResultKt.throwOnFailure(objExecute);
        HttpClient httpClient = (HttpClient) client$delegate.getValue();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, "https://search.zemer.io/lyrics/resolve");
        UtilsKt.parameter(httpRequestBuilder, "videoId", str);
        UtilsKt.header(httpRequestBuilder, HttpHeaders.Accept, "application/json");
        HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
        c01621.label = 1;
        objExecute = httpStatementM.execute(c01621);
        if (objExecute != coroutineSingletons) {
        }
        return coroutineSingletons;
        HttpResponse httpResponse = (HttpResponse) objExecute;
        if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getOK())) {
            HttpClientCall call = httpResponse.getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Resolved.class);
            try {
                typeReferenceTypeOf = Reflection.typeOf(Resolved.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            c01621.label = 2;
            objExecute = call.bodyNullable(typeInfo, c01621);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:55:0x010b  */
    /* JADX WARN: Code duplicated, block: B:58:0x010f  */
    /* JADX WARN: Code duplicated, block: B:61:0x011b  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zingLyricsHtml(long j, ContinuationImpl continuationImpl) {
        C01631 c01631;
        Object failure;
        JsonObject jsonObject;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        String contentOrNull;
        TypeReference typeReferenceTypeOf;
        JsonImpl jsonImpl;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        if (continuationImpl instanceof C01631) {
            c01631 = (C01631) continuationImpl;
            int i = c01631.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01631.label = i - Integer.MIN_VALUE;
            } else {
                c01631 = new C01631(continuationImpl);
            }
        } else {
            c01631 = new C01631(continuationImpl);
        }
        Object objExecute = c01631.result;
        int i2 = c01631.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient = (HttpClient) client$delegate.getValue();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                httpRequestBuilder.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder, "https://jewishmusic.fm:8443/graphql");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.ContentType, "application/json");
                httpRequestBuilder.setBody(IntIntPair$$ExternalSyntheticOutline0.m(j, "{\"query\":\"{ track(where:{id:", "}){ heLyrics enLyrics } }\"}"));
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(String.class);
                } catch (Throwable unused) {
                    typeReferenceTypeOf = null;
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf, httpRequestBuilder);
                HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
                c01631.L$2 = null;
                c01631.J$0 = j;
                c01631.label = 1;
                objExecute = httpStatementM.execute(c01631);
                if (objExecute != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                j = c01631.J$0;
                ResultKt.throwOnFailure(objExecute);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                jsonImpl = c01631.L$2;
                ResultKt.throwOnFailure(objExecute);
            }
            jsonElement3 = (JsonElement) JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement((String) objExecute)).get("data");
            if (jsonElement3 != null || (jsonElement4 = (JsonElement) JsonElementKt.getJsonObject(jsonElement3).get("track")) == null) {
                failure = null;
            } else {
                failure = JsonElementKt.getJsonObject(jsonElement4);
            }
            if (failure instanceof Result.Failure) {
                failure = null;
            }
            jsonObject = (JsonObject) failure;
            if (jsonObject != null) {
                jsonElement = (JsonElement) jsonObject.get("heLyrics");
                if (jsonElement != null && (contentOrNull = JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(jsonElement))) != null) {
                    if (StringsKt.isBlank(contentOrNull)) {
                        contentOrNull = null;
                    }
                    if (contentOrNull != null) {
                        return contentOrNull;
                    }
                }
                jsonElement2 = (JsonElement) jsonObject.get("enLyrics");
                if (jsonElement2 != null) {
                    return JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(jsonElement2));
                }
                return null;
            }
            return null;
            HttpResponse httpResponse = (HttpResponse) objExecute;
            if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getOK())) {
                JsonImpl jsonImpl2 = json;
                c01631.L$2 = jsonImpl2;
                c01631.J$0 = j;
                c01631.label = 2;
                objExecute = HttpResponseKt.bodyAsText$default(httpResponse, null, c01631, 1, null);
                if (objExecute != coroutineSingletons) {
                    jsonImpl = jsonImpl2;
                    jsonElement3 = (JsonElement) JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement((String) objExecute)).get("data");
                    if (jsonElement3 != null) {
                        failure = null;
                    } else {
                        failure = null;
                    }
                    if (failure instanceof Result.Failure) {
                        failure = null;
                    }
                    jsonObject = (JsonObject) failure;
                    if (jsonObject != null) {
                        jsonElement = (JsonElement) jsonObject.get("heLyrics");
                        if (jsonElement != null) {
                            if (StringsKt.isBlank(contentOrNull)) {
                                contentOrNull = null;
                            }
                            if (contentOrNull != null) {
                                return contentOrNull;
                            }
                        }
                        jsonElement2 = (JsonElement) jsonObject.get("enLyrics");
                        if (jsonElement2 != null) {
                            return JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(jsonElement2));
                        }
                        return null;
                    }
                }
                return coroutineSingletons;
            }
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        return null;
    }
}
