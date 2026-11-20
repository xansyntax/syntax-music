package io.ktor.util.cio;

import androidx.collection.internal.Lock;
import androidx.compose.runtime.Latch;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.SongEntity;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.plugins.compression.ContentEncodingConfig;
import io.ktor.client.plugins.compression.ContentEncodingKt;
import io.ktor.client.plugins.websocket.BuildersKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HeaderValueParam;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import io.ktor.http.auth.HeaderValueEncoding;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.network.sockets.CIOReaderKt;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FileChannelsKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ FileChannelsKt$$ExternalSyntheticLambda1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return FileChannelsKt.readChannel$lambda$1((SynchronizedLazyImpl) this.f$0, (File) this.f$1, (Throwable) obj);
            case 1:
                Dp dp = (Dp) this.f$0;
                Dp dp2 = (Dp) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.getClass();
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                layoutNodeDrawScope.drawContent();
                DrawScope.m549drawRectAsUm42w$default(layoutNodeDrawScope, Lock.m11verticalGradient8A3gB4$default(CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(0L), new Color(-72057594037927936L)}), CropImageView.DEFAULT_ASPECT_RATIO, layoutNodeDrawScope.mo81toPx0680j_4(dp.value), 8), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 6, 62);
                DrawScope.m549drawRectAsUm42w$default(layoutNodeDrawScope, Lock.m11verticalGradient8A3gB4$default(CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(-72057594037927936L), new Color(0L)}), Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) - layoutNodeDrawScope.mo81toPx0680j_4(dp2.value), Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)), 8), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 6, 62);
                return Unit.INSTANCE;
            case 2:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                SongEntity songEntityCopy$default = SongEntity.copy$default((SongEntity) this.f$0, null, 0, null, null, null, false, null, null, null, null, null, ((ParcelableSnapshotMutableIntState) this.f$1).getIntValue(), false, false, false, null, 133955583);
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.upsert(songEntityCopy$default);
                return Unit.INSTANCE;
            case 3:
                URLParserKt$$ExternalSyntheticLambda0 uRLParserKt$$ExternalSyntheticLambda0 = (URLParserKt$$ExternalSyntheticLambda0) this.f$0;
                GraphicsLayer graphicsLayer = (GraphicsLayer) this.f$1;
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                uRLParserKt$$ExternalSyntheticLambda0.invoke(drawScope, graphicsLayer);
                return Unit.INSTANCE;
            case 4:
                return ContentEncodingKt.ContentEncoding$lambda$0$decode$4((HttpResponse) this.f$0, (ArrayList) this.f$1, (HeadersBuilder) obj);
            case 5:
                return ContentEncodingKt.ContentEncoding$lambda$2((ContentEncodingConfig.Mode) this.f$0, (Function1) this.f$1, (ContentEncodingConfig) obj);
            case 6:
                return BuildersKt.wss$lambda$4((Integer) this.f$0, (Function1) this.f$1, (HttpRequestBuilder) obj);
            case 7:
                return HttpAuthHeader.Parameterized.render$lambda$0((HttpAuthHeader.Parameterized) this.f$0, (HeaderValueEncoding) this.f$1, (HeaderValueParam) obj);
            case 8:
                return CIOReaderKt.readFrom$lambda$0((Ref$IntRef) this.f$0, (ReadableByteChannel) this.f$1, (ByteBuffer) obj);
            case 9:
                HandlerContext handlerContext = (HandlerContext) this.f$0;
                handlerContext.handler.removeCallbacks((TransactionExecutor$$ExternalSyntheticLambda0) this.f$1);
                return Unit.INSTANCE;
            case 10:
                KSerializer kSerializer = (KSerializer) this.f$0;
                KSerializer kSerializer2 = (KSerializer) this.f$1;
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
                classSerialDescriptorBuilder.getClass();
                classSerialDescriptorBuilder.element("key", kSerializer.getDescriptor());
                classSerialDescriptorBuilder.element("value", kSerializer2.getDescriptor());
                return Unit.INSTANCE;
            default:
                DiskLruCache diskLruCache = (DiskLruCache) this.f$0;
                Latch latch = (Latch) this.f$1;
                ((IOException) obj).getClass();
                synchronized (diskLruCache) {
                    latch.detach$okhttp();
                }
                return Unit.INSTANCE;
        }
    }
}
