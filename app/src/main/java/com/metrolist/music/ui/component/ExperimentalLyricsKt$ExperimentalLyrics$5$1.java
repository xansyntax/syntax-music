package com.metrolist.music.ui.component;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.yalantis.ucrop.R;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExperimentalLyricsKt$ExperimentalLyrics$5$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $aiProvider$delegate;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $aiSystemPrompt$delegate;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MutableState $currentSong$delegate;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $deeplApiKey$delegate;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $deeplFormality$delegate;
    public final /* synthetic */ MutableState $lines$delegate;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $openRouterApiKey$delegate;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $openRouterBaseUrl$delegate;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $openRouterModel$delegate;
    public final /* synthetic */ CoroutineScope $scope;
    public final /* synthetic */ boolean $showLyrics;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $translateLanguage$delegate;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $translateMode$delegate;
    public boolean label;

    /* JADX INFO: renamed from: com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$5$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $aiProvider$delegate;
        public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $aiSystemPrompt$delegate;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ MutableState $currentSong$delegate;
        public final /* synthetic */ MusicDatabase $database;
        public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $deeplApiKey$delegate;
        public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $deeplFormality$delegate;
        public final /* synthetic */ MutableState $lines$delegate;
        public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $openRouterApiKey$delegate;
        public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $openRouterBaseUrl$delegate;
        public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $openRouterModel$delegate;
        public final /* synthetic */ CoroutineScope $scope;
        public final /* synthetic */ boolean $showLyrics;
        public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $translateLanguage$delegate;
        public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $translateMode$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, CoroutineScope coroutineScope, Context context, MusicDatabase musicDatabase, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$3, MutableState mutableState, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$4, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$5, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$6, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$7, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$8, MutableState mutableState2, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$9, Continuation continuation) {
            super(2, continuation);
            this.$showLyrics = z;
            this.$scope = coroutineScope;
            this.$context = context;
            this.$database = musicDatabase;
            this.$aiProvider$delegate = dataStoreKt$rememberPreference$1$1;
            this.$deeplApiKey$delegate = dataStoreKt$rememberPreference$1$2;
            this.$openRouterApiKey$delegate = dataStoreKt$rememberPreference$1$3;
            this.$lines$delegate = mutableState;
            this.$translateLanguage$delegate = dataStoreKt$rememberPreference$1$4;
            this.$openRouterBaseUrl$delegate = dataStoreKt$rememberPreference$1$5;
            this.$openRouterModel$delegate = dataStoreKt$rememberPreference$1$6;
            this.$translateMode$delegate = dataStoreKt$rememberPreference$1$7;
            this.$deeplFormality$delegate = dataStoreKt$rememberPreference$1$8;
            this.$currentSong$delegate = mutableState2;
            this.$aiSystemPrompt$delegate = dataStoreKt$rememberPreference$1$9;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$showLyrics, this.$scope, this.$context, this.$database, this.$aiProvider$delegate, this.$deeplApiKey$delegate, this.$openRouterApiKey$delegate, this.$lines$delegate, this.$translateLanguage$delegate, this.$openRouterBaseUrl$delegate, this.$openRouterModel$delegate, this.$translateMode$delegate, this.$deeplFormality$delegate, this.$currentSong$delegate, this.$aiSystemPrompt$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = (AnonymousClass1) create((Unit) obj, (Continuation) obj2);
            Unit unit = Unit.INSTANCE;
            anonymousClass1.invokeSuspend(unit);
            return unit;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:22:0x00ce  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            State state = this.$openRouterApiKey$delegate.$state;
            State state2 = this.$deeplApiKey$delegate.$state;
            ResultKt.throwOnFailure(obj);
            State state3 = this.$aiProvider$delegate.$state;
            String str2 = Intrinsics.areEqual((String) state3.getValue(), "DeepL") ? (String) state2.getValue() : (String) state.getValue();
            if (this.$showLyrics) {
                MutableState mutableState = this.$lines$delegate;
                if (!((List) mutableState.getValue()).isEmpty() && !StringsKt.isBlank(str2)) {
                    StateFlowImpl stateFlowImpl = LyricsTranslationHelper._status;
                    List list = (List) mutableState.getValue();
                    String str3 = (String) this.$translateLanguage$delegate.$state.getValue();
                    String str4 = (String) state.getValue();
                    String str5 = (String) this.$openRouterBaseUrl$delegate.$state.getValue();
                    String str6 = (String) this.$openRouterModel$delegate.$state.getValue();
                    String str7 = (String) this.$translateMode$delegate.$state.getValue();
                    String str8 = (String) state3.getValue();
                    String str9 = (String) state2.getValue();
                    String str10 = (String) this.$deeplFormality$delegate.$state.getValue();
                    Song song = (Song) this.$currentSong$delegate.getValue();
                    if (song == null || (str = song.song.id) == null) {
                        str = "";
                    }
                    LyricsTranslationHelper.translateLyrics(list, str3, str4, str5, str6, str7, this.$scope, this.$context, str8, str9, str10, str, this.$database, (String) this.$aiSystemPrompt$delegate.$state.getValue());
                } else if (StringsKt.isBlank(str2)) {
                    Context context = this.$context;
                    Toast.makeText(context, context.getString(R.string.ai_api_key_required), 0).show();
                }
            } else if (StringsKt.isBlank(str2)) {
                Context context2 = this.$context;
                Toast.makeText(context2, context2.getString(R.string.ai_api_key_required), 0).show();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentalLyricsKt$ExperimentalLyrics$5$1(boolean z, CoroutineScope coroutineScope, Context context, MusicDatabase musicDatabase, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$3, MutableState mutableState, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$4, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$5, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$6, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$7, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$8, MutableState mutableState2, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$9, Continuation continuation) {
        super(2, continuation);
        this.$showLyrics = z;
        this.$scope = coroutineScope;
        this.$context = context;
        this.$database = musicDatabase;
        this.$aiProvider$delegate = dataStoreKt$rememberPreference$1$1;
        this.$deeplApiKey$delegate = dataStoreKt$rememberPreference$1$2;
        this.$openRouterApiKey$delegate = dataStoreKt$rememberPreference$1$3;
        this.$lines$delegate = mutableState;
        this.$translateLanguage$delegate = dataStoreKt$rememberPreference$1$4;
        this.$openRouterBaseUrl$delegate = dataStoreKt$rememberPreference$1$5;
        this.$openRouterModel$delegate = dataStoreKt$rememberPreference$1$6;
        this.$translateMode$delegate = dataStoreKt$rememberPreference$1$7;
        this.$deeplFormality$delegate = dataStoreKt$rememberPreference$1$8;
        this.$currentSong$delegate = mutableState2;
        this.$aiSystemPrompt$delegate = dataStoreKt$rememberPreference$1$9;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ExperimentalLyricsKt$ExperimentalLyrics$5$1(this.$showLyrics, this.$scope, this.$context, this.$database, this.$aiProvider$delegate, this.$deeplApiKey$delegate, this.$openRouterApiKey$delegate, this.$lines$delegate, this.$translateLanguage$delegate, this.$openRouterBaseUrl$delegate, this.$openRouterModel$delegate, this.$translateMode$delegate, this.$deeplFormality$delegate, this.$currentSong$delegate, this.$aiSystemPrompt$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((ExperimentalLyricsKt$ExperimentalLyrics$5$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            ReadonlySharedFlow readonlySharedFlow = LyricsTranslationHelper.manualTrigger;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$showLyrics, this.$scope, this.$context, this.$database, this.$aiProvider$delegate, this.$deeplApiKey$delegate, this.$openRouterApiKey$delegate, this.$lines$delegate, this.$translateLanguage$delegate, this.$openRouterBaseUrl$delegate, this.$openRouterModel$delegate, this.$translateMode$delegate, this.$deeplFormality$delegate, this.$currentSong$delegate, this.$aiSystemPrompt$delegate, null);
            readonlySharedFlow.getClass();
            this.label = true;
            Object objCollectLatest = StateFlowKt.collectLatest(readonlySharedFlow, anonymousClass1, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objCollectLatest == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("SharedFlow never completes, this call should never return.");
        return 0;
    }
}
