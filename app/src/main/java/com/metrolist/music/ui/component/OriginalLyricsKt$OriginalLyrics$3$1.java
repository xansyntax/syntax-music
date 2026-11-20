package com.metrolist.music.ui.component;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OriginalLyricsKt$OriginalLyrics$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $aiApiKeyRequiredStr;
    public final /* synthetic */ MutableState $aiProvider$delegate;
    public final /* synthetic */ MutableState $aiSystemPrompt$delegate;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ State $currentSong$delegate;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ MutableState $deeplApiKey$delegate;
    public final /* synthetic */ MutableState $deeplFormality$delegate;
    public final /* synthetic */ List $lines;
    public final /* synthetic */ MutableState $openRouterApiKey$delegate;
    public final /* synthetic */ MutableState $openRouterBaseUrl$delegate;
    public final /* synthetic */ MutableState $openRouterModel$delegate;
    public final /* synthetic */ CoroutineScope $scope;
    public final /* synthetic */ boolean $showLyrics;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $translateLanguage$delegate;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $translateMode$delegate;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalLyricsKt$OriginalLyrics$3$1(boolean z, List list, CoroutineScope coroutineScope, Context context, MusicDatabase musicDatabase, String str, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MutableState mutableState4, MutableState mutableState5, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2, MutableState mutableState6, State state, MutableState mutableState7, Continuation continuation) {
        super(2, continuation);
        this.$showLyrics = z;
        this.$lines = list;
        this.$scope = coroutineScope;
        this.$context = context;
        this.$database = musicDatabase;
        this.$aiApiKeyRequiredStr = str;
        this.$aiProvider$delegate = mutableState;
        this.$deeplApiKey$delegate = mutableState2;
        this.$openRouterApiKey$delegate = mutableState3;
        this.$translateLanguage$delegate = dataStoreKt$rememberPreference$1$1;
        this.$openRouterBaseUrl$delegate = mutableState4;
        this.$openRouterModel$delegate = mutableState5;
        this.$translateMode$delegate = dataStoreKt$rememberPreference$1$2;
        this.$deeplFormality$delegate = mutableState6;
        this.$currentSong$delegate = state;
        this.$aiSystemPrompt$delegate = mutableState7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OriginalLyricsKt$OriginalLyrics$3$1(this.$showLyrics, this.$lines, this.$scope, this.$context, this.$database, this.$aiApiKeyRequiredStr, this.$aiProvider$delegate, this.$deeplApiKey$delegate, this.$openRouterApiKey$delegate, this.$translateLanguage$delegate, this.$openRouterBaseUrl$delegate, this.$openRouterModel$delegate, this.$translateMode$delegate, this.$deeplFormality$delegate, this.$currentSong$delegate, this.$aiSystemPrompt$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((OriginalLyricsKt$OriginalLyrics$3$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            ReadonlySharedFlow readonlySharedFlow = LyricsTranslationHelper.manualTrigger;
            final State state = this.$currentSong$delegate;
            final MutableState mutableState = this.$aiSystemPrompt$delegate;
            final boolean z2 = this.$showLyrics;
            final List list = this.$lines;
            final CoroutineScope coroutineScope = this.$scope;
            final Context context = this.$context;
            final MusicDatabase musicDatabase = this.$database;
            final String str = this.$aiApiKeyRequiredStr;
            final MutableState mutableState2 = this.$aiProvider$delegate;
            final MutableState mutableState3 = this.$deeplApiKey$delegate;
            final MutableState mutableState4 = this.$openRouterApiKey$delegate;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = this.$translateLanguage$delegate;
            final MutableState mutableState5 = this.$openRouterBaseUrl$delegate;
            final MutableState mutableState6 = this.$openRouterModel$delegate;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2 = this.$translateMode$delegate;
            final MutableState mutableState7 = this.$deeplFormality$delegate;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$3$1.1
                /* JADX WARN: Code duplicated, block: B:20:0x00b1  */
                /* JADX WARN: Code duplicated, block: B:22:0x00b7  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj2, Continuation continuation) {
                    String str2;
                    int i = OriginalLyricsKt.$r8$clinit;
                    MutableState mutableState8 = mutableState2;
                    boolean zAreEqual = Intrinsics.areEqual((String) mutableState8.getValue(), "DeepL");
                    MutableState mutableState9 = mutableState4;
                    MutableState mutableState10 = mutableState3;
                    String str3 = zAreEqual ? (String) mutableState10.getValue() : (String) mutableState9.getValue();
                    if (z2) {
                        List list2 = list;
                        if (!list2.isEmpty() && !StringsKt.isBlank(str3)) {
                            StateFlowImpl stateFlowImpl = LyricsTranslationHelper._status;
                            String str4 = (String) dataStoreKt$rememberPreference$1$1.$state.getValue();
                            String str5 = (String) mutableState9.getValue();
                            String str6 = (String) mutableState5.getValue();
                            String str7 = (String) mutableState6.getValue();
                            String str8 = (String) dataStoreKt$rememberPreference$1$2.$state.getValue();
                            String str9 = (String) mutableState8.getValue();
                            String str10 = (String) mutableState10.getValue();
                            String str11 = (String) mutableState7.getValue();
                            Song song = (Song) state.getValue();
                            if (song == null || (str2 = song.song.id) == null) {
                                str2 = "";
                            }
                            LyricsTranslationHelper.translateLyrics(list2, str4, str5, str6, str7, str8, coroutineScope, context, str9, str10, str11, str2, musicDatabase, (String) mutableState.getValue());
                        } else if (StringsKt.isBlank(str3)) {
                            Toast.makeText(context, str, 0).show();
                        }
                    } else if (StringsKt.isBlank(str3)) {
                        Toast.makeText(context, str, 0).show();
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = true;
            Object objCollect = readonlySharedFlow.$$delegate_0.collect(flowCollector, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objCollect == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return 0;
    }
}
