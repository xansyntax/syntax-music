package com.metrolist.music.listentogether.proto;

import com.google.protobuf.GeneratedMessageLite;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/music/listentogether/proto/ReconnectedPayloadKt;", "", "<init>", "()V", "Dsl", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ReconnectedPayloadKt {
    public static final int $stable = 0;
    public static final ReconnectedPayloadKt INSTANCE = new ReconnectedPayloadKt();

    private ReconnectedPayloadKt() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010)\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRA\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016¢\u0006\f\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fRA\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u0004\u0018\u00010\u0018*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\"\u0010#RA\u0010$\u001a\u00020 2\u0006\u0010\t\u001a\u00020 8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(%\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b('¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(Ê\u0001\u0002\b,Ê\u0001\f\b-\u0012\b\b.\u0012\u0004\b\u0003\u0010\u0000¨\u0006+"}, d2 = {"Lcom/metrolist/music/listentogether/proto/ReconnectedPayloadKt$Dsl;", "", "_builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$ReconnectedPayload$Builder;", "<init>", "(Lcom/metrolist/music/listentogether/proto/Listentogether$ReconnectedPayload$Builder;)V", "_build", "Lcom/metrolist/music/listentogether/proto/Listentogether$ReconnectedPayload;", "Lkotlin/PublishedApi;", "value", "", "roomCode", "getRoomCode", "()Ljava/lang/String;", "setRoomCode", "(Ljava/lang/String;)V", "Lkotlin/jvm/JvmName;", ContentDisposition.Parameters.Name, "clearRoomCode", "", "userId", "getUserId", "setUserId", "clearUserId", "Lcom/metrolist/music/listentogether/proto/Listentogether$RoomState;", "state", "getState", "()Lcom/metrolist/music/listentogether/proto/Listentogether$RoomState;", "setState", "(Lcom/metrolist/music/listentogether/proto/Listentogether$RoomState;)V", "clearState", "hasState", "", "stateOrNull", "getStateOrNull", "(Lcom/metrolist/music/listentogether/proto/ReconnectedPayloadKt$Dsl;)Lcom/metrolist/music/listentogether/proto/Listentogether$RoomState;", "isHost", "getIsHost", "()Z", "setIsHost", "(Z)V", "clearIsHost", "Companion", "app", "Lcom/google/protobuf/kotlin/ProtoDslMarker;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Dsl {
        private final Listentogether.ReconnectedPayload.Builder _builder;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        private Dsl(Listentogether.ReconnectedPayload.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ Listentogether.ReconnectedPayload _build() {
            GeneratedMessageLite generatedMessageLiteM915build = this._builder.m915build();
            generatedMessageLiteM915build.getClass();
            return (Listentogether.ReconnectedPayload) generatedMessageLiteM915build;
        }

        public final void clearIsHost() {
            this._builder.clearIsHost();
        }

        public final void clearRoomCode() {
            this._builder.clearRoomCode();
        }

        public final void clearState() {
            this._builder.clearState();
        }

        public final void clearUserId() {
            this._builder.clearUserId();
        }

        public final boolean getIsHost() {
            return this._builder.getIsHost();
        }

        public final String getRoomCode() {
            String roomCode = this._builder.getRoomCode();
            roomCode.getClass();
            return roomCode;
        }

        public final Listentogether.RoomState getState() {
            Listentogether.RoomState state = this._builder.getState();
            state.getClass();
            return state;
        }

        public final Listentogether.RoomState getStateOrNull(Dsl dsl) {
            dsl.getClass();
            return ReconnectedPayloadKtKt.getStateOrNull(dsl._builder);
        }

        public final String getUserId() {
            String userId = this._builder.getUserId();
            userId.getClass();
            return userId;
        }

        public final boolean hasState() {
            return this._builder.hasState();
        }

        public final void setIsHost(boolean z) {
            this._builder.setIsHost(z);
        }

        public final void setRoomCode(String str) {
            str.getClass();
            this._builder.setRoomCode(str);
        }

        public final void setState(Listentogether.RoomState roomState) {
            roomState.getClass();
            this._builder.setState(roomState);
        }

        public final void setUserId(String str) {
            str.getClass();
            this._builder.setUserId(str);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/metrolist/music/listentogether/proto/ReconnectedPayloadKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Lcom/metrolist/music/listentogether/proto/ReconnectedPayloadKt$Dsl;", "builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$ReconnectedPayload$Builder;", "Lkotlin/PublishedApi;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dsl _create(Listentogether.ReconnectedPayload.Builder builder) {
                builder.getClass();
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Listentogether.ReconnectedPayload.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }
}
