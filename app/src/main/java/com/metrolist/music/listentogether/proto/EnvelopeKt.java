package com.metrolist.music.listentogether.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/music/listentogether/proto/EnvelopeKt;", "", "<init>", "()V", "Dsl", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class EnvelopeKt {
    public static final int $stable = 0;
    public static final EnvelopeKt INSTANCE = new EnvelopeKt();

    private EnvelopeKt() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRA\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00148G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019RA\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\u001b8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 Ê\u0001\u0002\b$Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0000¨\u0006#"}, d2 = {"Lcom/metrolist/music/listentogether/proto/EnvelopeKt$Dsl;", "", "_builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$Envelope$Builder;", "<init>", "(Lcom/metrolist/music/listentogether/proto/Listentogether$Envelope$Builder;)V", "_build", "Lcom/metrolist/music/listentogether/proto/Listentogether$Envelope;", "Lkotlin/PublishedApi;", "value", "", LinkHeader.Parameters.Type, "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "Lkotlin/jvm/JvmName;", ContentDisposition.Parameters.Name, "clearType", "", "Lcom/google/protobuf/ByteString;", "payload", "getPayload", "()Lcom/google/protobuf/ByteString;", "setPayload", "(Lcom/google/protobuf/ByteString;)V", "clearPayload", "", "compressed", "getCompressed", "()Z", "setCompressed", "(Z)V", "clearCompressed", "Companion", "app", "Lcom/google/protobuf/kotlin/ProtoDslMarker;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Dsl {
        private final Listentogether.Envelope.Builder _builder;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        private Dsl(Listentogether.Envelope.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ Listentogether.Envelope _build() {
            GeneratedMessageLite generatedMessageLiteM915build = this._builder.m915build();
            generatedMessageLiteM915build.getClass();
            return (Listentogether.Envelope) generatedMessageLiteM915build;
        }

        public final void clearCompressed() {
            this._builder.clearCompressed();
        }

        public final void clearPayload() {
            this._builder.clearPayload();
        }

        public final void clearType() {
            this._builder.clearType();
        }

        public final boolean getCompressed() {
            return this._builder.getCompressed();
        }

        public final ByteString getPayload() {
            ByteString payload = this._builder.getPayload();
            payload.getClass();
            return payload;
        }

        public final String getType() {
            String type = this._builder.getType();
            type.getClass();
            return type;
        }

        public final void setCompressed(boolean z) {
            this._builder.setCompressed(z);
        }

        public final void setPayload(ByteString byteString) {
            byteString.getClass();
            this._builder.setPayload(byteString);
        }

        public final void setType(String str) {
            str.getClass();
            this._builder.setType(str);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/metrolist/music/listentogether/proto/EnvelopeKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Lcom/metrolist/music/listentogether/proto/EnvelopeKt$Dsl;", "builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$Envelope$Builder;", "Lkotlin/PublishedApi;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dsl _create(Listentogether.Envelope.Builder builder) {
                builder.getClass();
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Listentogether.Envelope.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }
}
