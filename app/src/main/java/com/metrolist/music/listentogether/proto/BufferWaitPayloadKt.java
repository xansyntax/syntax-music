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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/music/listentogether/proto/BufferWaitPayloadKt;", "", "<init>", "()V", "Dsl", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class BufferWaitPayloadKt {
    public static final int $stable = 0;
    public static final BufferWaitPayloadKt INSTANCE = new BufferWaitPayloadKt();

    private BufferWaitPayloadKt() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\bJ\u0006\u0010\u0012\u001a\u00020\u0013J3\u0010\u0019\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\t\u001a\u00020\nH\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a¢\u0006\u0002\b\u001aJ4\u0010\u001b\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\t\u001a\u00020\nH\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c¢\u0006\u0002\b\u001cJ9\u0010\u001d\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001fH\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b( ¢\u0006\u0002\b J:\u0010\u001b\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001fH\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(!¢\u0006\u0002\b!J<\u0010\"\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010#\u001a\u00020$2\u0006\u0010\t\u001a\u00020\nH\u0087\u0002b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(%¢\u0006\u0002\b%J+\u0010&\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(%¢\u0006\u0002\b%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\u0002\b*Ê\u0001\f\b+\u0012\b\b,\u0012\u0004\b\u0003\u0010\u0000¨\u0006)"}, d2 = {"Lcom/metrolist/music/listentogether/proto/BufferWaitPayloadKt$Dsl;", "", "_builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$BufferWaitPayload$Builder;", "<init>", "(Lcom/metrolist/music/listentogether/proto/Listentogether$BufferWaitPayload$Builder;)V", "_build", "Lcom/metrolist/music/listentogether/proto/Listentogether$BufferWaitPayload;", "Lkotlin/PublishedApi;", "value", "", "trackId", "getTrackId", "()Ljava/lang/String;", "setTrackId", "(Ljava/lang/String;)V", "Lkotlin/jvm/JvmName;", ContentDisposition.Parameters.Name, "clearTrackId", "", "waitingFor", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/metrolist/music/listentogether/proto/BufferWaitPayloadKt$Dsl$WaitingForProxy;", "getWaitingFor", "()Lcom/google/protobuf/kotlin/DslList;", "add", "addWaitingFor", "plusAssign", "plusAssignWaitingFor", "addAll", "values", "", "addAllWaitingFor", "plusAssignAllWaitingFor", "set", "index", "", "setWaitingFor", "clear", "Companion", "WaitingForProxy", "app", "Lcom/google/protobuf/kotlin/ProtoDslMarker;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Dsl {
        private final Listentogether.BufferWaitPayload.Builder _builder;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/listentogether/proto/BufferWaitPayloadKt$Dsl$WaitingForProxy;", "Lkotlin/text/CharsKt;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class WaitingForProxy extends CharsKt {
            public static final int $stable = 8;

            private WaitingForProxy() {
                throw null;
            }
        }

        private Dsl(Listentogether.BufferWaitPayload.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ Listentogether.BufferWaitPayload _build() {
            GeneratedMessageLite generatedMessageLiteM915build = this._builder.m915build();
            generatedMessageLiteM915build.getClass();
            return (Listentogether.BufferWaitPayload) generatedMessageLiteM915build;
        }

        public final /* synthetic */ void addAllWaitingFor(DslList dslList, Iterable iterable) {
            dslList.getClass();
            iterable.getClass();
            this._builder.addAllWaitingFor(iterable);
        }

        public final /* synthetic */ void addWaitingFor(DslList dslList, String str) {
            dslList.getClass();
            str.getClass();
            this._builder.addWaitingFor(str);
        }

        public final void clearTrackId() {
            this._builder.clearTrackId();
        }

        public final String getTrackId() {
            String trackId = this._builder.getTrackId();
            trackId.getClass();
            return trackId;
        }

        public final DslList getWaitingFor() {
            List<String> waitingForList = this._builder.getWaitingForList();
            waitingForList.getClass();
            return new DslList(waitingForList);
        }

        public final /* synthetic */ void plusAssignAllWaitingFor(DslList dslList, Iterable<String> iterable) {
            dslList.getClass();
            iterable.getClass();
            addAllWaitingFor(dslList, iterable);
        }

        public final /* synthetic */ void plusAssignWaitingFor(DslList dslList, String str) {
            dslList.getClass();
            str.getClass();
            addWaitingFor(dslList, str);
        }

        public final void setTrackId(String str) {
            str.getClass();
            this._builder.setTrackId(str);
        }

        public final /* synthetic */ void setWaitingFor(DslList dslList, int i, String str) {
            dslList.getClass();
            str.getClass();
            this._builder.setWaitingFor(i, str);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/metrolist/music/listentogether/proto/BufferWaitPayloadKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Lcom/metrolist/music/listentogether/proto/BufferWaitPayloadKt$Dsl;", "builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$BufferWaitPayload$Builder;", "Lkotlin/PublishedApi;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dsl _create(Listentogether.BufferWaitPayload.Builder builder) {
                builder.getClass();
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Listentogether.BufferWaitPayload.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        public final /* synthetic */ void setWaitingFor(DslList dslList) {
            dslList.getClass();
            this._builder.clearWaitingFor();
        }
    }
}
