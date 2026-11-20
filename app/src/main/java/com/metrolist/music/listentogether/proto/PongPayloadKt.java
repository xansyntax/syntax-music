package com.metrolist.music.listentogether.proto;

import com.google.protobuf.GeneratedMessageLite;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/music/listentogether/proto/PongPayloadKt;", "", "<init>", "()V", "Dsl", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PongPayloadKt {
    public static final int $stable = 0;
    public static final PongPayloadKt INSTANCE = new PongPayloadKt();

    private PongPayloadKt() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRA\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016¢\u0006\f\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fRA\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a¢\u0006\f\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fRA\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e¢\u0006\f\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fÊ\u0001\u0002\b\"Ê\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0003\u0010\u0000¨\u0006!"}, d2 = {"Lcom/metrolist/music/listentogether/proto/PongPayloadKt$Dsl;", "", "_builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$PongPayload$Builder;", "<init>", "(Lcom/metrolist/music/listentogether/proto/Listentogether$PongPayload$Builder;)V", "_build", "Lcom/metrolist/music/listentogether/proto/Listentogether$PongPayload;", "Lkotlin/PublishedApi;", "value", "", "clientTime", "getClientTime", "()J", "setClientTime", "(J)V", "Lkotlin/jvm/JvmName;", ContentDisposition.Parameters.Name, "clearClientTime", "", "serverReceiveTime", "getServerReceiveTime", "setServerReceiveTime", "clearServerReceiveTime", "serverSendTime", "getServerSendTime", "setServerSendTime", "clearServerSendTime", "sequence", "getSequence", "setSequence", "clearSequence", "Companion", "app", "Lcom/google/protobuf/kotlin/ProtoDslMarker;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Dsl {
        private final Listentogether.PongPayload.Builder _builder;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        private Dsl(Listentogether.PongPayload.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ Listentogether.PongPayload _build() {
            GeneratedMessageLite generatedMessageLiteM915build = this._builder.m915build();
            generatedMessageLiteM915build.getClass();
            return (Listentogether.PongPayload) generatedMessageLiteM915build;
        }

        public final void clearClientTime() {
            this._builder.clearClientTime();
        }

        public final void clearSequence() {
            this._builder.clearSequence();
        }

        public final void clearServerReceiveTime() {
            this._builder.clearServerReceiveTime();
        }

        public final void clearServerSendTime() {
            this._builder.clearServerSendTime();
        }

        public final long getClientTime() {
            return this._builder.getClientTime();
        }

        public final long getSequence() {
            return this._builder.getSequence();
        }

        public final long getServerReceiveTime() {
            return this._builder.getServerReceiveTime();
        }

        public final long getServerSendTime() {
            return this._builder.getServerSendTime();
        }

        public final void setClientTime(long j) {
            this._builder.setClientTime(j);
        }

        public final void setSequence(long j) {
            this._builder.setSequence(j);
        }

        public final void setServerReceiveTime(long j) {
            this._builder.setServerReceiveTime(j);
        }

        public final void setServerSendTime(long j) {
            this._builder.setServerSendTime(j);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/metrolist/music/listentogether/proto/PongPayloadKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Lcom/metrolist/music/listentogether/proto/PongPayloadKt$Dsl;", "builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$PongPayload$Builder;", "Lkotlin/PublishedApi;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dsl _create(Listentogether.PongPayload.Builder builder) {
                builder.getClass();
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Listentogether.PongPayload.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }
}
