package com.metrolist.music;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Color;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.audio.VolumeNormalizationAudioProcessor;
import java.util.Collection;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity$MetrolistApp$4$1 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object $enableDynamicTheme$delegate;
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ long $selectedThemeColor;
    public final /* synthetic */ Object $themeColor$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$MetrolistApp$4$1(long j, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$selectedThemeColor = j;
        this.$enableDynamicTheme$delegate = mutableState;
        this.$themeColor$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$themeColor$delegate;
        switch (b) {
            case 0:
                return new MainActivity$MetrolistApp$4$1(this.$selectedThemeColor, (MutableState) this.$enableDynamicTheme$delegate, (MutableState) obj2, continuation);
            case 1:
                return new MainActivity$MetrolistApp$4$1((MusicService) this.$enableDynamicTheme$delegate, (String) obj2, this.$selectedThemeColor, continuation);
            default:
                MainActivity$MetrolistApp$4$1 mainActivity$MetrolistApp$4$1 = new MainActivity$MetrolistApp$4$1(this.$selectedThemeColor, (MusicService) obj2, continuation);
                mainActivity$MetrolistApp$4$1.$enableDynamicTheme$delegate = obj;
                return mainActivity$MetrolistApp$4$1;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((MainActivity$MetrolistApp$4$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 1:
                ((MainActivity$MetrolistApp$4$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((MainActivity$MetrolistApp$4$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.$themeColor$delegate;
        long j = this.$selectedThemeColor;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                MutableState mutableState = (MutableState) this.$enableDynamicTheme$delegate;
                int i = MainActivity.$r8$clinit;
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    ((MutableState) obj2).setValue(new Color(j));
                }
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                ((MusicService) this.$enableDynamicTheme$delegate).getDatabase().updatePlaybackPosition((String) obj2, new Long(j));
                Timber.Forest.tag("MusicService");
                ConnectionPool.d(new Object[0]);
                break;
            default:
                CoroutineScope coroutineScope = (CoroutineScope) this.$enableDynamicTheme$delegate;
                ResultKt.throwOnFailure(obj);
                if (AwaitKt.isActive(coroutineScope)) {
                    MusicService musicService = (MusicService) obj2;
                    if (j == musicService.loudnessSetupGeneration) {
                        musicService.cachedNormalizationMediaId = null;
                        musicService.cachedNormalizationGainMb = null;
                        musicService.cachedNormalizationEnabled = false;
                        Collection collectionValues = musicService.playerNormalizationProcessors.values();
                        collectionValues.getClass();
                        Iterator it = collectionValues.iterator();
                        while (it.hasNext()) {
                            ((VolumeNormalizationAudioProcessor) it.next()).setEnabled(false);
                        }
                    }
                }
                break;
        }
        return unit;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$MetrolistApp$4$1(long j, MusicService musicService, Continuation continuation) {
        super(2, continuation);
        this.$selectedThemeColor = j;
        this.$themeColor$delegate = musicService;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$MetrolistApp$4$1(MusicService musicService, String str, long j, Continuation continuation) {
        super(2, continuation);
        this.$enableDynamicTheme$delegate = musicService;
        this.$themeColor$delegate = str;
        this.$selectedThemeColor = j;
    }
}
