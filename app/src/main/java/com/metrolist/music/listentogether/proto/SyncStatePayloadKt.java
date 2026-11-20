package com.metrolist.music.listentogether.proto;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.kotlin.DslList;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/music/listentogether/proto/SyncStatePayloadKt;", "", "<init>", "()V", "Dsl", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SyncStatePayloadKt {
    public static final int $stable = 0;
    public static final SyncStatePayloadKt INSTANCE = new SyncStatePayloadKt();

    private SyncStatePayloadKt() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0013J3\u0010/\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+2\u0006\u0010\t\u001a\u00020\nH\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(0¢\u0006\u0002\b0J4\u00101\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+2\u0006\u0010\t\u001a\u00020\nH\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(2¢\u0006\u0002\b2J9\u00103\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\n05H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(6¢\u0006\u0002\b6J:\u00101\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\n05H\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(7¢\u0006\u0002\b7J<\u00108\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+2\u0006\u00109\u001a\u00020:2\u0006\u0010\t\u001a\u00020\nH\u0087\u0002b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(;¢\u0006\u0002\b;J+\u0010<\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(=¢\u0006\u0002\b=J\u0006\u0010D\u001a\u00020\u0013J\u0006\u0010H\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u0004\u0018\u00010\n*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018RA\u0010\u0019\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00158G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dRA\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(!\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(#¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$RA\u0010&\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b('\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b((¢\u0006\f\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+8F¢\u0006\u0006\u001a\u0004\b-\u0010.RA\u0010?\u001a\u00020>2\u0006\u0010\t\u001a\u00020>8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(@\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(B¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CRA\u0010E\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(F\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(G¢\u0006\f\u001a\u0004\bF\u0010\"\"\u0004\bG\u0010$Ê\u0001\u0002\bLÊ\u0001\f\bM\u0012\b\bN\u0012\u0004\b\u0003\u0010\u0000¨\u0006K"}, d2 = {"Lcom/metrolist/music/listentogether/proto/SyncStatePayloadKt$Dsl;", "", "_builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$SyncStatePayload$Builder;", "<init>", "(Lcom/metrolist/music/listentogether/proto/Listentogether$SyncStatePayload$Builder;)V", "_build", "Lcom/metrolist/music/listentogether/proto/Listentogether$SyncStatePayload;", "Lkotlin/PublishedApi;", "value", "Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "currentTrack", "getCurrentTrack", "()Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "setCurrentTrack", "(Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;)V", "Lkotlin/jvm/JvmName;", ContentDisposition.Parameters.Name, "clearCurrentTrack", "", "hasCurrentTrack", "", "currentTrackOrNull", "getCurrentTrackOrNull", "(Lcom/metrolist/music/listentogether/proto/SyncStatePayloadKt$Dsl;)Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "isPlaying", "getIsPlaying", "()Z", "setIsPlaying", "(Z)V", "clearIsPlaying", "", "position", "getPosition", "()J", "setPosition", "(J)V", "clearPosition", "lastUpdate", "getLastUpdate", "setLastUpdate", "clearLastUpdate", "queue", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/metrolist/music/listentogether/proto/SyncStatePayloadKt$Dsl$QueueProxy;", "getQueue", "()Lcom/google/protobuf/kotlin/DslList;", "add", "addQueue", "plusAssign", "plusAssignQueue", "addAll", "values", "", "addAllQueue", "plusAssignAllQueue", "set", "index", "", "setQueue", "clear", "clearQueue", "", "volume", "getVolume", "()F", "setVolume", "(F)V", "clearVolume", "revision", "getRevision", "setRevision", "clearRevision", "Companion", "QueueProxy", "app", "Lcom/google/protobuf/kotlin/ProtoDslMarker;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Dsl {
        private final Listentogether.SyncStatePayload.Builder _builder;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/listentogether/proto/SyncStatePayloadKt$Dsl$QueueProxy;", "Lkotlin/text/CharsKt;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class QueueProxy extends CharsKt {
            public static final int $stable = 8;

            private QueueProxy() {
                throw null;
            }
        }

        private Dsl(Listentogether.SyncStatePayload.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ Listentogether.SyncStatePayload _build() {
            GeneratedMessageLite generatedMessageLiteM915build = this._builder.m915build();
            generatedMessageLiteM915build.getClass();
            return (Listentogether.SyncStatePayload) generatedMessageLiteM915build;
        }

        public final /* synthetic */ void addAllQueue(DslList dslList, Iterable iterable) {
            dslList.getClass();
            iterable.getClass();
            this._builder.addAllQueue(iterable);
        }

        public final /* synthetic */ void addQueue(DslList dslList, Listentogether.TrackInfo trackInfo) {
            dslList.getClass();
            trackInfo.getClass();
            this._builder.addQueue(trackInfo);
        }

        public final void clearCurrentTrack() {
            this._builder.clearCurrentTrack();
        }

        public final void clearIsPlaying() {
            this._builder.clearIsPlaying();
        }

        public final void clearLastUpdate() {
            this._builder.clearLastUpdate();
        }

        public final void clearPosition() {
            this._builder.clearPosition();
        }

        public final /* synthetic */ void clearQueue(DslList dslList) {
            dslList.getClass();
            this._builder.clearQueue();
        }

        public final void clearRevision() {
            this._builder.clearRevision();
        }

        public final void clearVolume() {
            this._builder.clearVolume();
        }

        public final Listentogether.TrackInfo getCurrentTrack() {
            Listentogether.TrackInfo currentTrack = this._builder.getCurrentTrack();
            currentTrack.getClass();
            return currentTrack;
        }

        public final Listentogether.TrackInfo getCurrentTrackOrNull(Dsl dsl) {
            dsl.getClass();
            return SyncStatePayloadKtKt.getCurrentTrackOrNull(dsl._builder);
        }

        public final boolean getIsPlaying() {
            return this._builder.getIsPlaying();
        }

        public final long getLastUpdate() {
            return this._builder.getLastUpdate();
        }

        public final long getPosition() {
            return this._builder.getPosition();
        }

        public final /* synthetic */ DslList getQueue() {
            List<Listentogether.TrackInfo> queueList = this._builder.getQueueList();
            queueList.getClass();
            return new DslList(queueList);
        }

        public final long getRevision() {
            return this._builder.getRevision();
        }

        public final float getVolume() {
            return this._builder.getVolume();
        }

        public final boolean hasCurrentTrack() {
            return this._builder.hasCurrentTrack();
        }

        public final /* synthetic */ void plusAssignAllQueue(DslList dslList, Iterable<Listentogether.TrackInfo> iterable) {
            dslList.getClass();
            iterable.getClass();
            addAllQueue(dslList, iterable);
        }

        public final /* synthetic */ void plusAssignQueue(DslList dslList, Listentogether.TrackInfo trackInfo) {
            dslList.getClass();
            trackInfo.getClass();
            addQueue(dslList, trackInfo);
        }

        public final void setCurrentTrack(Listentogether.TrackInfo trackInfo) {
            trackInfo.getClass();
            this._builder.setCurrentTrack(trackInfo);
        }

        public final void setIsPlaying(boolean z) {
            this._builder.setIsPlaying(z);
        }

        public final void setLastUpdate(long j) {
            this._builder.setLastUpdate(j);
        }

        public final void setPosition(long j) {
            this._builder.setPosition(j);
        }

        public final /* synthetic */ void setQueue(DslList dslList, int i, Listentogether.TrackInfo trackInfo) {
            dslList.getClass();
            trackInfo.getClass();
            this._builder.setQueue(i, trackInfo);
        }

        public final void setRevision(long j) {
            this._builder.setRevision(j);
        }

        public final void setVolume(float f) {
            this._builder.setVolume(f);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/metrolist/music/listentogether/proto/SyncStatePayloadKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Lcom/metrolist/music/listentogether/proto/SyncStatePayloadKt$Dsl;", "builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$SyncStatePayload$Builder;", "Lkotlin/PublishedApi;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dsl _create(Listentogether.SyncStatePayload.Builder builder) {
                builder.getClass();
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Listentogether.SyncStatePayload.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }
}
