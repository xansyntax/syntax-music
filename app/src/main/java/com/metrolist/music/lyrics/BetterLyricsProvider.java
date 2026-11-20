package com.metrolist.music.lyrics;

import android.content.Context;
import com.metrolist.innertube.YouTube;
import com.metrolist.music.betterlyrics.BetterLyrics;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.utils.UtilsKt;
import java.io.Serializable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BetterLyricsProvider implements LyricsProvider {
    public static final BetterLyricsProvider INSTANCE = new BetterLyricsProvider(0);
    public static final BetterLyricsProvider INSTANCE$1 = new BetterLyricsProvider(1);
    public static final BetterLyricsProvider INSTANCE$2 = new BetterLyricsProvider(2);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BetterLyricsProvider(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    @Override // com.metrolist.music.lyrics.LyricsProvider
    /* JADX INFO: renamed from: getLyrics-bMdYcbs, reason: not valid java name */
    public final Object mo1450getLyricsbMdYcbs(Context context, String str, String str2, String str3, int i, String str4, ContinuationImpl continuationImpl) {
        BetterLyricsProvider$getLyrics$1 betterLyricsProvider$getLyrics$1;
        YouTubeLyricsProvider$getLyrics$1 youTubeLyricsProvider$getLyrics$1;
        YouTubeSubtitleLyricsProvider$getLyrics$1 youTubeSubtitleLyricsProvider$getLyrics$1;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                if (continuationImpl instanceof BetterLyricsProvider$getLyrics$1) {
                    betterLyricsProvider$getLyrics$1 = (BetterLyricsProvider$getLyrics$1) continuationImpl;
                    int i2 = betterLyricsProvider$getLyrics$1.label;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        betterLyricsProvider$getLyrics$1.label = i2 - Integer.MIN_VALUE;
                    } else {
                        betterLyricsProvider$getLyrics$1 = new BetterLyricsProvider$getLyrics$1(this, continuationImpl);
                    }
                } else {
                    betterLyricsProvider$getLyrics$1 = new BetterLyricsProvider$getLyrics$1(this, continuationImpl);
                }
                BetterLyricsProvider$getLyrics$1 betterLyricsProvider$getLyrics$2 = betterLyricsProvider$getLyrics$1;
                Object obj = betterLyricsProvider$getLyrics$2.result;
                int i3 = betterLyricsProvider$getLyrics$2.label;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return ((Result) obj).value;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                BetterLyrics betterLyrics = BetterLyrics.INSTANCE;
                betterLyricsProvider$getLyrics$2.label = 1;
                Serializable serializableM1057getLyricsyxL6bBk = betterLyrics.m1057getLyricsyxL6bBk(i, str2, str3, str4, betterLyricsProvider$getLyrics$2);
                return serializableM1057getLyricsyxL6bBk == coroutineSingletons ? coroutineSingletons : serializableM1057getLyricsyxL6bBk;
            case 1:
                if (continuationImpl instanceof YouTubeLyricsProvider$getLyrics$1) {
                    youTubeLyricsProvider$getLyrics$1 = (YouTubeLyricsProvider$getLyrics$1) continuationImpl;
                    int i4 = youTubeLyricsProvider$getLyrics$1.label;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        youTubeLyricsProvider$getLyrics$1.label = i4 - Integer.MIN_VALUE;
                    } else {
                        youTubeLyricsProvider$getLyrics$1 = new YouTubeLyricsProvider$getLyrics$1(this, continuationImpl);
                    }
                } else {
                    youTubeLyricsProvider$getLyrics$1 = new YouTubeLyricsProvider$getLyrics$1(this, continuationImpl);
                }
                Object objWithContext = youTubeLyricsProvider$getLyrics$1.result;
                int i5 = youTubeLyricsProvider$getLyrics$1.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(objWithContext);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    YouTubeLyricsProvider$getLyrics$2 youTubeLyricsProvider$getLyrics$2 = new YouTubeLyricsProvider$getLyrics$2(str, null);
                    youTubeLyricsProvider$getLyrics$1.label = 1;
                    objWithContext = AwaitKt.withContext(defaultIoScheduler, youTubeLyricsProvider$getLyrics$2, youTubeLyricsProvider$getLyrics$1);
                    if (objWithContext == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i5 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objWithContext);
                }
                return ((Result) objWithContext).value;
            default:
                if (continuationImpl instanceof YouTubeSubtitleLyricsProvider$getLyrics$1) {
                    youTubeSubtitleLyricsProvider$getLyrics$1 = (YouTubeSubtitleLyricsProvider$getLyrics$1) continuationImpl;
                    int i6 = youTubeSubtitleLyricsProvider$getLyrics$1.label;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        youTubeSubtitleLyricsProvider$getLyrics$1.label = i6 - Integer.MIN_VALUE;
                    } else {
                        youTubeSubtitleLyricsProvider$getLyrics$1 = new YouTubeSubtitleLyricsProvider$getLyrics$1(this, continuationImpl);
                    }
                } else {
                    youTubeSubtitleLyricsProvider$getLyrics$1 = new YouTubeSubtitleLyricsProvider$getLyrics$1(this, continuationImpl);
                }
                Object obj2 = youTubeSubtitleLyricsProvider$getLyrics$1.result;
                int i7 = youTubeSubtitleLyricsProvider$getLyrics$1.label;
                if (i7 != 0) {
                    if (i7 == 1) {
                        ResultKt.throwOnFailure(obj2);
                        return ((Result) obj2).value;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj2);
                YouTube youTube = YouTube.INSTANCE;
                youTubeSubtitleLyricsProvider$getLyrics$1.label = 1;
                Serializable serializableM1045transcriptgIAlus = youTube.m1045transcriptgIAlus(str, youTubeSubtitleLyricsProvider$getLyrics$1);
                return serializableM1045transcriptgIAlus == coroutineSingletons ? coroutineSingletons : serializableM1045transcriptgIAlus;
        }
    }

    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final String getName() {
        switch (this.$r8$classId) {
            case 0:
                return "BetterLyrics";
            case 1:
                return "YouTube Music";
            default:
                return "YouTube Subtitle";
        }
    }

    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final boolean isEnabled(Context context) {
        switch (this.$r8$classId) {
            case 0:
                Boolean bool = (Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.EnableBetterLyricsKey);
                if (bool != null) {
                    return bool.booleanValue();
                }
                return true;
            case 1:
            default:
                return true;
        }
    }
}
