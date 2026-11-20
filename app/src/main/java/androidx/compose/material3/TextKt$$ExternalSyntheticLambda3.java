package androidx.compose.material3;

import android.graphics.PathMeasure;
import android.os.Looper;
import android.view.Choreographer;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.material3.tokens.TypographyTokensKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.retain.ForgetfulRetainedValuesStore;
import androidx.compose.runtime.retain.LocalRetainedValuesStoreKt;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.AndroidUiDispatcher;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.NoSoundEffect;
import androidx.compose.ui.unit.Dp;
import androidx.sqlite.SQLite;
import coil3.network.HttpException;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.App$Companion$forgetAccount$2;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.network.sockets.DatagramKt;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextKt$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ TextKt$$ExternalSyntheticLambda3(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Choreographer choreographer;
        int i = 2;
        Continuation continuation = null;
        switch (this.$r8$classId) {
            case 0:
                return TypographyTokensKt.DefaultTextStyle;
            case 1:
                return new TopAppBarState(-3.4028235E38f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            case 2:
                return Float.valueOf(1.0f);
            case 3:
                return new Dp(48.0f);
            case 4:
                return Boolean.FALSE;
            case 5:
                return new MaterialTheme$Values(ColorSchemeKt.m285lightColorScheme_VG5OTI$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, DatagramKt.MAX_DATAGRAM_SIZE), new Typography(), new Shapes(), MotionScheme.StandardMotionSchemeImpl.INSTANCE);
            case 6:
                return UUID.randomUUID();
            case 7:
                return CardKt.ThemeConfiguration;
            case 8:
                return new Shapes();
            case 9:
                return new Dp(CropImageView.DEFAULT_ASPECT_RATIO);
            case 10:
                return new PullToRefreshStateImpl(new Animatable(Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO), ArcSplineKt.FloatToVector, continuation, 12));
            case 11:
                ComposerKt.composeRuntimeError("Unexpected call to default provider");
                throw new HttpException();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                throw new IllegalStateException("CompositionLocal LocalHostDefaultProvider not present");
            case 13:
                ComposerKt.composeRuntimeError("Unexpected call to default provider");
                throw new HttpException();
            case 14:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = LocalRetainedValuesStoreKt.LocalRetainedValuesStore;
                return ForgetfulRetainedValuesStore.INSTANCE;
            case 15:
                return new SaveableStateHolderImpl(new LinkedHashMap());
            case 16:
            case 17:
            case 18:
                return null;
            case 19:
                return new AndroidPathMeasure(new PathMeasure());
            case 20:
                return Unit.INSTANCE;
            case 21:
                return NestedScrollNodeKt.CancelledScope;
            case 22:
            case 23:
                return null;
            case 24:
                return new LayoutNode(2);
            case 25:
                return new LayoutNode(3);
            case 26:
                AndroidCompositionLocals_androidKt.noLocalProvidedFor("LocalConfiguration");
                throw null;
            case 27:
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    choreographer = Choreographer.getInstance();
                } else {
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    choreographer = (Choreographer) AwaitKt.runBlockingK(MainDispatcherLoader.dispatcher, new App$Companion$forgetAccount$2(i, continuation, (byte) 5));
                }
                AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, SQLite.createAsync(Looper.getMainLooper()));
                return androidUiDispatcher.plus(androidUiDispatcher.frameClock);
            case 28:
                CompositionLocalsKt.noLocalProvidedFor("LocalOwner");
                throw null;
            default:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = CompositionLocalsKt.LocalOwner;
                return NoSoundEffect.INSTANCE;
        }
    }
}
