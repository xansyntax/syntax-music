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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/music/listentogether/proto/PlaybackActionPayloadKt;", "", "<init>", "()V", "Dsl", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PlaybackActionPayloadKt {
    public static final int $stable = 0;
    public static final PlaybackActionPayloadKt INSTANCE = new PlaybackActionPayloadKt();

    private PlaybackActionPayloadKt() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0002\\]B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020'J\u0006\u00100\u001a\u00020\u0013J3\u00106\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000203022\u0006\u0010\t\u001a\u00020\u001fH\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(7¢\u0006\u0002\b7J4\u00108\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000203022\u0006\u0010\t\u001a\u00020\u001fH\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(9¢\u0006\u0002\b9J9\u0010:\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000203022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001f0<H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(=¢\u0006\u0002\b=J:\u00108\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000203022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001f0<H\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(>¢\u0006\u0002\b>J<\u0010?\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000203022\u0006\u0010@\u001a\u00020A2\u0006\u0010\t\u001a\u00020\u001fH\u0087\u0002b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(B¢\u0006\u0002\bBJ+\u0010C\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020302H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(D¢\u0006\u0002\bDJ\u0006\u0010H\u001a\u00020\u0013J\u0006\u0010O\u001a\u00020\u0013J\u0006\u0010S\u001a\u00020\u0013J\u0006\u0010W\u001a\u00020\u0013J\u0006\u0010[\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRA\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016¢\u0006\f\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fRA\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dRA\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(!\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(#¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0017\u0010(\u001a\u0004\u0018\u00010\u001f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b)\u0010*RA\u0010+\u001a\u00020'2\u0006\u0010\t\u001a\u00020'8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(,\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(.¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001d\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000203028F¢\u0006\u0006\u001a\u0004\b4\u00105RA\u0010E\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(F\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(G¢\u0006\f\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fRA\u0010J\u001a\u00020I2\u0006\u0010\t\u001a\u00020I8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(K\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(M¢\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NRA\u0010P\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(Q\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(R¢\u0006\f\u001a\u0004\bQ\u0010\u001b\"\u0004\bR\u0010\u001dRA\u0010T\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(U\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(V¢\u0006\f\u001a\u0004\bU\u0010\u001b\"\u0004\bV\u0010\u001dRA\u0010X\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(Y\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(Z¢\u0006\f\u001a\u0004\bY\u0010\u001b\"\u0004\bZ\u0010\u001dÊ\u0001\u0002\b_Ê\u0001\f\b`\u0012\b\ba\u0012\u0004\b\u0003\u0010\u0000¨\u0006^"}, d2 = {"Lcom/metrolist/music/listentogether/proto/PlaybackActionPayloadKt$Dsl;", "", "_builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$PlaybackActionPayload$Builder;", "<init>", "(Lcom/metrolist/music/listentogether/proto/Listentogether$PlaybackActionPayload$Builder;)V", "_build", "Lcom/metrolist/music/listentogether/proto/Listentogether$PlaybackActionPayload;", "Lkotlin/PublishedApi;", "value", "", "action", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "Lkotlin/jvm/JvmName;", ContentDisposition.Parameters.Name, "clearAction", "", "trackId", "getTrackId", "setTrackId", "clearTrackId", "", "position", "getPosition", "()J", "setPosition", "(J)V", "clearPosition", "Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "trackInfo", "getTrackInfo", "()Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "setTrackInfo", "(Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;)V", "clearTrackInfo", "hasTrackInfo", "", "trackInfoOrNull", "getTrackInfoOrNull", "(Lcom/metrolist/music/listentogether/proto/PlaybackActionPayloadKt$Dsl;)Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "insertNext", "getInsertNext", "()Z", "setInsertNext", "(Z)V", "clearInsertNext", "queue", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/metrolist/music/listentogether/proto/PlaybackActionPayloadKt$Dsl$QueueProxy;", "getQueue", "()Lcom/google/protobuf/kotlin/DslList;", "add", "addQueue", "plusAssign", "plusAssignQueue", "addAll", "values", "", "addAllQueue", "plusAssignAllQueue", "set", "index", "", "setQueue", "clear", "clearQueue", "queueTitle", "getQueueTitle", "setQueueTitle", "clearQueueTitle", "", "volume", "getVolume", "()F", "setVolume", "(F)V", "clearVolume", "serverTime", "getServerTime", "setServerTime", "clearServerTime", "revision", "getRevision", "setRevision", "clearRevision", "capturedAtServerTime", "getCapturedAtServerTime", "setCapturedAtServerTime", "clearCapturedAtServerTime", "Companion", "QueueProxy", "app", "Lcom/google/protobuf/kotlin/ProtoDslMarker;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Dsl {
        private final Listentogether.PlaybackActionPayload.Builder _builder;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/listentogether/proto/PlaybackActionPayloadKt$Dsl$QueueProxy;", "Lkotlin/text/CharsKt;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class QueueProxy extends CharsKt {
            public static final int $stable = 8;

            private QueueProxy() {
                throw null;
            }
        }

        private Dsl(Listentogether.PlaybackActionPayload.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ Listentogether.PlaybackActionPayload _build() {
            GeneratedMessageLite generatedMessageLiteM915build = this._builder.m915build();
            generatedMessageLiteM915build.getClass();
            return (Listentogether.PlaybackActionPayload) generatedMessageLiteM915build;
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

        public final void clearAction() {
            this._builder.clearAction();
        }

        public final void clearCapturedAtServerTime() {
            this._builder.clearCapturedAtServerTime();
        }

        public final void clearInsertNext() {
            this._builder.clearInsertNext();
        }

        public final void clearPosition() {
            this._builder.clearPosition();
        }

        public final /* synthetic */ void clearQueue(DslList dslList) {
            dslList.getClass();
            this._builder.clearQueue();
        }

        public final void clearQueueTitle() {
            this._builder.clearQueueTitle();
        }

        public final void clearRevision() {
            this._builder.clearRevision();
        }

        public final void clearServerTime() {
            this._builder.clearServerTime();
        }

        public final void clearTrackId() {
            this._builder.clearTrackId();
        }

        public final void clearTrackInfo() {
            this._builder.clearTrackInfo();
        }

        public final void clearVolume() {
            this._builder.clearVolume();
        }

        public final String getAction() {
            String action = this._builder.getAction();
            action.getClass();
            return action;
        }

        public final long getCapturedAtServerTime() {
            return this._builder.getCapturedAtServerTime();
        }

        public final boolean getInsertNext() {
            return this._builder.getInsertNext();
        }

        public final long getPosition() {
            return this._builder.getPosition();
        }

        public final /* synthetic */ DslList getQueue() {
            List<Listentogether.TrackInfo> queueList = this._builder.getQueueList();
            queueList.getClass();
            return new DslList(queueList);
        }

        public final String getQueueTitle() {
            String queueTitle = this._builder.getQueueTitle();
            queueTitle.getClass();
            return queueTitle;
        }

        public final long getRevision() {
            return this._builder.getRevision();
        }

        public final long getServerTime() {
            return this._builder.getServerTime();
        }

        public final String getTrackId() {
            String trackId = this._builder.getTrackId();
            trackId.getClass();
            return trackId;
        }

        public final Listentogether.TrackInfo getTrackInfo() {
            Listentogether.TrackInfo trackInfo = this._builder.getTrackInfo();
            trackInfo.getClass();
            return trackInfo;
        }

        public final Listentogether.TrackInfo getTrackInfoOrNull(Dsl dsl) {
            dsl.getClass();
            return PlaybackActionPayloadKtKt.getTrackInfoOrNull(dsl._builder);
        }

        public final float getVolume() {
            return this._builder.getVolume();
        }

        public final boolean hasTrackInfo() {
            return this._builder.hasTrackInfo();
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

        public final void setAction(String str) {
            str.getClass();
            this._builder.setAction(str);
        }

        public final void setCapturedAtServerTime(long j) {
            this._builder.setCapturedAtServerTime(j);
        }

        public final void setInsertNext(boolean z) {
            this._builder.setInsertNext(z);
        }

        public final void setPosition(long j) {
            this._builder.setPosition(j);
        }

        public final /* synthetic */ void setQueue(DslList dslList, int i, Listentogether.TrackInfo trackInfo) {
            dslList.getClass();
            trackInfo.getClass();
            this._builder.setQueue(i, trackInfo);
        }

        public final void setQueueTitle(String str) {
            str.getClass();
            this._builder.setQueueTitle(str);
        }

        public final void setRevision(long j) {
            this._builder.setRevision(j);
        }

        public final void setServerTime(long j) {
            this._builder.setServerTime(j);
        }

        public final void setTrackId(String str) {
            str.getClass();
            this._builder.setTrackId(str);
        }

        public final void setTrackInfo(Listentogether.TrackInfo trackInfo) {
            trackInfo.getClass();
            this._builder.setTrackInfo(trackInfo);
        }

        public final void setVolume(float f) {
            this._builder.setVolume(f);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/metrolist/music/listentogether/proto/PlaybackActionPayloadKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Lcom/metrolist/music/listentogether/proto/PlaybackActionPayloadKt$Dsl;", "builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$PlaybackActionPayload$Builder;", "Lkotlin/PublishedApi;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dsl _create(Listentogether.PlaybackActionPayload.Builder builder) {
                builder.getClass();
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Listentogether.PlaybackActionPayload.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }
}
