package io.ktor.http;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.GestureNode;
import androidx.compose.foundation.lazy.grid.LazyGridPrefetchResultScopeImpl;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.dynamiccolor.DynamicColor;
import com.materialkolor.scheme.DynamicScheme;
import com.metrolist.music.discord.DiscordRpcManager;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.api.MonitoringEvent;
import io.ktor.client.plugins.sse.BuildersKt;
import io.ktor.client.plugins.sse.SSEConfig;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.RegexKt;
import kotlinx.io.Buffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CodecsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ CodecsKt$$ExternalSyntheticLambda0(Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DynamicColor dynamicColor;
        switch (this.$r8$classId) {
            case 0:
                return Boolean.valueOf(CodecsKt.forEach$lambda$0(this.f$0, (Buffer) obj));
            case 1:
                return new IntOffset(((long) ((Number) this.f$0.invoke(Integer.valueOf((int) (((IntSize) obj).packedValue & 4294967295L)))).intValue()) & 4294967295L);
            case 2:
                return new IntOffset(((long) ((Number) this.f$0.invoke(Integer.valueOf((int) (((IntSize) obj).packedValue >> 32)))).intValue()) << 32);
            case 3:
                return new IntOffset(((long) ((Number) this.f$0.invoke(Integer.valueOf((int) (((IntSize) obj).packedValue >> 32)))).intValue()) << 32);
            case 4:
                return new IntOffset(((long) ((Number) this.f$0.invoke(Integer.valueOf((int) (((IntSize) obj).packedValue & 4294967295L)))).intValue()) & 4294967295L);
            case 5:
                Function1 function1 = this.f$0;
                Long l = (Long) obj;
                l.getClass();
                return function1.invoke(l);
            case 6:
                Function1 function2 = this.f$0;
                TraversableNode traversableNode = (TraversableNode) obj;
                if (traversableNode instanceof GestureNode) {
                    return Boolean.valueOf(((Boolean) function2.invoke(((GestureNode) traversableNode).gestureConnection)).booleanValue());
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Node is not a GestureNode instance");
                return null;
            case 7:
                throw IntIntPair$$ExternalSyntheticOutline0.m(obj);
            case 8:
                Function1 function3 = this.f$0;
                LazyGridPrefetchResultScopeImpl lazyGridPrefetchResultScopeImpl = (LazyGridPrefetchResultScopeImpl) obj;
                int size = lazyGridPrefetchResultScopeImpl.mainAxisSizes.size();
                int iMaxOf = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    iMaxOf = RegexKt.maxOf(((Number) lazyGridPrefetchResultScopeImpl.mainAxisSizes.get(i)).intValue(), new int[0]);
                }
                if (iMaxOf != Integer.MIN_VALUE) {
                    function3.invoke(Integer.valueOf(iMaxOf));
                }
                return Unit.INSTANCE;
            case 9:
                return new SwipeToDismissBoxState((SwipeToDismissBoxValue) obj, this.f$0);
            case 10:
                Snapshot snapshot = (Snapshot) this.f$0.invoke((SnapshotIdSet) obj);
                synchronized (SnapshotKt.lock) {
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(snapshot.getSnapshotId());
                }
                return snapshot;
            case 11:
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                this.f$0.invoke(layoutNodeDrawScope);
                layoutNodeDrawScope.drawContent();
                return Unit.INSTANCE;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Function1 function4 = this.f$0;
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                double tone = 50.0d;
                if (dynamicScheme != null && (dynamicColor = (DynamicColor) function4.invoke(dynamicScheme)) != null) {
                    tone = dynamicColor.getTone(dynamicScheme);
                }
                return Double.valueOf(tone);
            case 13:
                Function1 function5 = this.f$0;
                float fFloatValue = ((Float) obj).floatValue();
                if (function5 != null) {
                    function5.invoke(Float.valueOf((fFloatValue * 0.95f) + 0.05f));
                }
                return Unit.INSTANCE;
            case 14:
                this.f$0.invoke(Integer.valueOf((int) (((IntSize) obj).packedValue & 4294967295L)));
                return Unit.INSTANCE;
            case 15:
                Function1 function6 = this.f$0;
                String str = (String) obj;
                str.getClass();
                if (str.length() <= 8) {
                    String upperCase = str.toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                    function6.invoke(upperCase);
                }
                return Unit.INSTANCE;
            case 16:
                Function1 function7 = this.f$0;
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                function7.invoke(bool);
                return Unit.INSTANCE;
            case 17:
                Function1 function8 = this.f$0;
                Boolean bool2 = (Boolean) obj;
                bool2.booleanValue();
                function8.invoke(bool2);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return Unit.INSTANCE;
            case 18:
                Function1 function9 = this.f$0;
                Boolean bool3 = (Boolean) obj;
                bool3.booleanValue();
                function9.invoke(bool3);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return Unit.INSTANCE;
            case 19:
                Function1 function10 = this.f$0;
                Boolean bool4 = (Boolean) obj;
                bool4.booleanValue();
                function10.invoke(bool4);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return Unit.INSTANCE;
            case 20:
                return (CharSequence) this.f$0.invoke(obj);
            case 21:
                return HttpClientConfig.installOrReplace$lambda$1(this.f$0, obj);
            case 22:
                return MonitoringEvent.install$lambda$0(this.f$0, obj);
            case 23:
                return BuildersKt.SSE$lambda$0(this.f$0, (SSEConfig) obj);
            case 24:
                return io.ktor.client.plugins.websocket.BuildersKt.WebSockets$lambda$0(this.f$0, (WebSockets.Config) obj);
            default:
                return io.ktor.client.plugins.websocket.BuildersKt.wss$lambda$0(this.f$0, (HttpRequestBuilder) obj);
        }
    }
}
