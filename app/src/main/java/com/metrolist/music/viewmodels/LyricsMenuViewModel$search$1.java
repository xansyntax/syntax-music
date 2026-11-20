package com.metrolist.music.viewmodels;

import android.util.LruCache;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.ImageLoader$Builder;
import com.metrolist.music.lyrics.LyricsHelper$getAllLyrics$3;
import com.metrolist.music.lyrics.LyricsResult;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsMenuViewModel$search$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $album;
    public final /* synthetic */ String $artist;
    public final /* synthetic */ int $duration;
    public final /* synthetic */ String $mediaId;
    public final /* synthetic */ String $title;
    public boolean label;
    public final /* synthetic */ LyricsMenuViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsMenuViewModel$search$1(LyricsMenuViewModel lyricsMenuViewModel, String str, String str2, String str3, int i, String str4, Continuation continuation) {
        super(2, continuation);
        this.this$0 = lyricsMenuViewModel;
        this.$mediaId = str;
        this.$title = str2;
        this.$artist = str3;
        this.$duration = i;
        this.$album = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LyricsMenuViewModel$search$1(this.this$0, this.$mediaId, this.$title, this.$artist, this.$duration, this.$album, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((LyricsMenuViewModel$search$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a9 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objJoin;
        CoroutineSingletons coroutineSingletons;
        boolean z = this.label;
        Unit unit = Unit.INSTANCE;
        LyricsMenuViewModel lyricsMenuViewModel = this.this$0;
        boolean zIsCurrentlyConnected = true;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            ImageLoader$Builder imageLoader$Builder = lyricsMenuViewModel.lyricsHelper;
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = new MimesKt$$ExternalSyntheticLambda0((byte) 20, lyricsMenuViewModel);
            this.label = true;
            StandaloneCoroutine standaloneCoroutine = (StandaloneCoroutine) imageLoader$Builder.extras;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel(null);
            }
            String str = this.$artist;
            String str2 = this.$title;
            String strReplace = StringsKt__StringsJVMKt.replace(Fragment$5$$ExternalSyntheticOutline0.m(str, "-", str2), ServerSentEventKt.SPACE, "", false);
            List list = (List) ((LruCache) imageLoader$Builder.diskCacheLazy).get(strReplace);
            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    mimesKt$$ExternalSyntheticLambda0.invoke((LyricsResult) it.next());
                }
            } else {
                try {
                    zIsCurrentlyConnected = ((NetworkConnectivityObserver) imageLoader$Builder.defaults).isCurrentlyConnected();
                } catch (Exception unused) {
                }
                if (zIsCurrentlyConnected) {
                    StandaloneCoroutine standaloneCoroutineLaunch$default = AwaitKt.launch$default(AwaitKt.CoroutineScope(AwaitKt.SupervisorJob$default()), null, null, new LyricsHelper$getAllLyrics$3(str2, imageLoader$Builder, new ArrayList(), strReplace, this.$mediaId, str, this.$duration, this.$album, mimesKt$$ExternalSyntheticLambda0, null), 3);
                    imageLoader$Builder.extras = standaloneCoroutineLaunch$default;
                    objJoin = standaloneCoroutineLaunch$default.join(this);
                    coroutineSingletons = coroutineSingletons2;
                    if (objJoin != coroutineSingletons) {
                        objJoin = unit;
                    }
                }
                if (objJoin == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            objJoin = unit;
            coroutineSingletons = coroutineSingletons2;
            if (objJoin == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        StateFlowImpl stateFlowImpl = lyricsMenuViewModel.isLoading;
        Boolean bool = Boolean.FALSE;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, bool);
        return unit;
    }
}
