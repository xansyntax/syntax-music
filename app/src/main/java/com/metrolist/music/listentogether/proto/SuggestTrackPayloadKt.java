package com.metrolist.music.listentogether.proto;

import com.google.protobuf.GeneratedMessageLite;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/music/listentogether/proto/SuggestTrackPayloadKt;", "", "<init>", "()V", "Dsl", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SuggestTrackPayloadKt {
    public static final int $stable = 0;
    public static final SuggestTrackPayloadKt INSTANCE = new SuggestTrackPayloadKt();

    private SuggestTrackPayloadKt() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u0004\u0018\u00010\n*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\u0002\b\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001a"}, d2 = {"Lcom/metrolist/music/listentogether/proto/SuggestTrackPayloadKt$Dsl;", "", "_builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$SuggestTrackPayload$Builder;", "<init>", "(Lcom/metrolist/music/listentogether/proto/Listentogether$SuggestTrackPayload$Builder;)V", "_build", "Lcom/metrolist/music/listentogether/proto/Listentogether$SuggestTrackPayload;", "Lkotlin/PublishedApi;", "value", "Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "trackInfo", "getTrackInfo", "()Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "setTrackInfo", "(Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;)V", "Lkotlin/jvm/JvmName;", ContentDisposition.Parameters.Name, "clearTrackInfo", "", "hasTrackInfo", "", "trackInfoOrNull", "getTrackInfoOrNull", "(Lcom/metrolist/music/listentogether/proto/SuggestTrackPayloadKt$Dsl;)Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "Companion", "app", "Lcom/google/protobuf/kotlin/ProtoDslMarker;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Dsl {
        private final Listentogether.SuggestTrackPayload.Builder _builder;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        private Dsl(Listentogether.SuggestTrackPayload.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ Listentogether.SuggestTrackPayload _build() {
            GeneratedMessageLite generatedMessageLiteM915build = this._builder.m915build();
            generatedMessageLiteM915build.getClass();
            return (Listentogether.SuggestTrackPayload) generatedMessageLiteM915build;
        }

        public final void clearTrackInfo() {
            this._builder.clearTrackInfo();
        }

        public final Listentogether.TrackInfo getTrackInfo() {
            Listentogether.TrackInfo trackInfo = this._builder.getTrackInfo();
            trackInfo.getClass();
            return trackInfo;
        }

        public final Listentogether.TrackInfo getTrackInfoOrNull(Dsl dsl) {
            dsl.getClass();
            return SuggestTrackPayloadKtKt.getTrackInfoOrNull(dsl._builder);
        }

        public final boolean hasTrackInfo() {
            return this._builder.hasTrackInfo();
        }

        public final void setTrackInfo(Listentogether.TrackInfo trackInfo) {
            trackInfo.getClass();
            this._builder.setTrackInfo(trackInfo);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/metrolist/music/listentogether/proto/SuggestTrackPayloadKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Lcom/metrolist/music/listentogether/proto/SuggestTrackPayloadKt$Dsl;", "builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$SuggestTrackPayload$Builder;", "Lkotlin/PublishedApi;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dsl _create(Listentogether.SuggestTrackPayload.Builder builder) {
                builder.getClass();
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Listentogether.SuggestTrackPayload.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }
}
