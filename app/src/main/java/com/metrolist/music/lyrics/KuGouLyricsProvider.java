package com.metrolist.music.lyrics;

import android.content.Context;
import com.metrolist.kugou.KuGou;
import com.metrolist.lrclib.LrcLib;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.paxsenix.Paxsenix;
import java.io.Serializable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KuGouLyricsProvider implements LyricsProvider {
    public static final KuGouLyricsProvider INSTANCE = new KuGouLyricsProvider(0);
    public static final KuGouLyricsProvider INSTANCE$1 = new KuGouLyricsProvider(1);
    public static final KuGouLyricsProvider INSTANCE$2 = new KuGouLyricsProvider(2);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ KuGouLyricsProvider(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final Object getAllLyrics(Context context, String str, String str2, String str3, int i, String str4, Function1 function1, Continuation continuation) {
        PaxsenixLyricsProvider$getAllLyrics$1 paxsenixLyricsProvider$getAllLyrics$1;
        Function1 function2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                Object allPossibleLyricsOptions = KuGou.INSTANCE.getAllPossibleLyricsOptions(str2, str3, i, str4, function1, (ContinuationImpl) continuation);
                return allPossibleLyricsOptions == coroutineSingletons ? allPossibleLyricsOptions : unit;
            case 1:
                Object allLyrics = LrcLib.INSTANCE.getAllLyrics(str2, str3, i, str4, function1, (ContinuationImpl) continuation);
                return allLyrics == coroutineSingletons ? allLyrics : unit;
            default:
                if (continuation instanceof PaxsenixLyricsProvider$getAllLyrics$1) {
                    paxsenixLyricsProvider$getAllLyrics$1 = (PaxsenixLyricsProvider$getAllLyrics$1) continuation;
                    int i2 = paxsenixLyricsProvider$getAllLyrics$1.label;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        paxsenixLyricsProvider$getAllLyrics$1.label = i2 - Integer.MIN_VALUE;
                    } else {
                        paxsenixLyricsProvider$getAllLyrics$1 = new PaxsenixLyricsProvider$getAllLyrics$1(this, (ContinuationImpl) continuation);
                    }
                } else {
                    paxsenixLyricsProvider$getAllLyrics$1 = new PaxsenixLyricsProvider$getAllLyrics$1(this, (ContinuationImpl) continuation);
                }
                PaxsenixLyricsProvider$getAllLyrics$1 paxsenixLyricsProvider$getAllLyrics$2 = paxsenixLyricsProvider$getAllLyrics$1;
                Object obj = paxsenixLyricsProvider$getAllLyrics$2.result;
                int i3 = paxsenixLyricsProvider$getAllLyrics$2.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Timber.Forest.tag("PaxsenixProvider");
                    ConnectionPool.d(new Object[0]);
                    try {
                        Paxsenix paxsenix = Paxsenix.INSTANCE;
                        paxsenix.init(context);
                        paxsenixLyricsProvider$getAllLyrics$2.L$5 = function1;
                        paxsenixLyricsProvider$getAllLyrics$2.label = 1;
                        return paxsenix.getAllLyrics(str2, str3, i, function1, paxsenixLyricsProvider$getAllLyrics$2) == coroutineSingletons ? coroutineSingletons : unit;
                    } catch (Exception unused) {
                        function2 = function1;
                    }
                } else {
                    if (i3 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    function2 = paxsenixLyricsProvider$getAllLyrics$2.L$5;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    } catch (Exception unused2) {
                    }
                }
                Timber.Forest.tag("PaxsenixProvider");
                ConnectionPool.e$1(new Object[0]);
                function2.invoke("");
                return unit;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f0  */
    @Override // com.metrolist.music.lyrics.LyricsProvider
    /* JADX INFO: renamed from: getLyrics-bMdYcbs */
    public final Object mo1450getLyricsbMdYcbs(Context context, String str, String str2, String str3, int i, String str4, ContinuationImpl continuationImpl) {
        KuGouLyricsProvider$getLyrics$1 kuGouLyricsProvider$getLyrics$1;
        LrcLibLyricsProvider$getLyrics$1 lrcLibLyricsProvider$getLyrics$1;
        PaxsenixLyricsProvider$getLyrics$1 paxsenixLyricsProvider$getLyrics$1;
        Object objM1532getLyricsyxL6bBk;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                if (continuationImpl instanceof KuGouLyricsProvider$getLyrics$1) {
                    kuGouLyricsProvider$getLyrics$1 = (KuGouLyricsProvider$getLyrics$1) continuationImpl;
                    int i2 = kuGouLyricsProvider$getLyrics$1.label;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        kuGouLyricsProvider$getLyrics$1.label = i2 - Integer.MIN_VALUE;
                    } else {
                        kuGouLyricsProvider$getLyrics$1 = new KuGouLyricsProvider$getLyrics$1(this, continuationImpl);
                    }
                } else {
                    kuGouLyricsProvider$getLyrics$1 = new KuGouLyricsProvider$getLyrics$1(this, continuationImpl);
                }
                KuGouLyricsProvider$getLyrics$1 kuGouLyricsProvider$getLyrics$2 = kuGouLyricsProvider$getLyrics$1;
                Object obj = kuGouLyricsProvider$getLyrics$2.result;
                int i3 = kuGouLyricsProvider$getLyrics$2.label;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return ((Result) obj).value;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                KuGou kuGou = KuGou.INSTANCE;
                kuGouLyricsProvider$getLyrics$2.label = 1;
                Serializable serializableM1049getLyricsyxL6bBk = kuGou.m1049getLyricsyxL6bBk(i, str2, str3, str4, kuGouLyricsProvider$getLyrics$2);
                return serializableM1049getLyricsyxL6bBk == coroutineSingletons ? coroutineSingletons : serializableM1049getLyricsyxL6bBk;
            case 1:
                if (continuationImpl instanceof LrcLibLyricsProvider$getLyrics$1) {
                    lrcLibLyricsProvider$getLyrics$1 = (LrcLibLyricsProvider$getLyrics$1) continuationImpl;
                    int i4 = lrcLibLyricsProvider$getLyrics$1.label;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        lrcLibLyricsProvider$getLyrics$1.label = i4 - Integer.MIN_VALUE;
                    } else {
                        lrcLibLyricsProvider$getLyrics$1 = new LrcLibLyricsProvider$getLyrics$1(this, continuationImpl);
                    }
                } else {
                    lrcLibLyricsProvider$getLyrics$1 = new LrcLibLyricsProvider$getLyrics$1(this, continuationImpl);
                }
                LrcLibLyricsProvider$getLyrics$1 lrcLibLyricsProvider$getLyrics$2 = lrcLibLyricsProvider$getLyrics$1;
                Object obj2 = lrcLibLyricsProvider$getLyrics$2.result;
                int i5 = lrcLibLyricsProvider$getLyrics$2.label;
                if (i5 != 0) {
                    if (i5 == 1) {
                        ResultKt.throwOnFailure(obj2);
                        return ((Result) obj2).value;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj2);
                LrcLib lrcLib = LrcLib.INSTANCE;
                lrcLibLyricsProvider$getLyrics$2.label = 1;
                Serializable serializableM1054getLyricsyxL6bBk = lrcLib.m1054getLyricsyxL6bBk(i, str2, str3, str4, lrcLibLyricsProvider$getLyrics$2);
                return serializableM1054getLyricsyxL6bBk == coroutineSingletons ? coroutineSingletons : serializableM1054getLyricsyxL6bBk;
            default:
                if (continuationImpl instanceof PaxsenixLyricsProvider$getLyrics$1) {
                    paxsenixLyricsProvider$getLyrics$1 = (PaxsenixLyricsProvider$getLyrics$1) continuationImpl;
                    int i6 = paxsenixLyricsProvider$getLyrics$1.label;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        paxsenixLyricsProvider$getLyrics$1.label = i6 - Integer.MIN_VALUE;
                    } else {
                        paxsenixLyricsProvider$getLyrics$1 = new PaxsenixLyricsProvider$getLyrics$1(this, continuationImpl);
                    }
                } else {
                    paxsenixLyricsProvider$getLyrics$1 = new PaxsenixLyricsProvider$getLyrics$1(this, continuationImpl);
                }
                PaxsenixLyricsProvider$getLyrics$1 paxsenixLyricsProvider$getLyrics$2 = paxsenixLyricsProvider$getLyrics$1;
                Object obj3 = paxsenixLyricsProvider$getLyrics$2.result;
                int i7 = paxsenixLyricsProvider$getLyrics$2.label;
                try {
                    if (i7 == 0) {
                        ResultKt.throwOnFailure(obj3);
                        Timber.Forest.tag("PaxsenixProvider");
                        ConnectionPool.d(new Object[0]);
                        Paxsenix paxsenix = Paxsenix.INSTANCE;
                        paxsenix.init(context);
                        paxsenixLyricsProvider$getLyrics$2.label = 1;
                        objM1532getLyricsyxL6bBk = paxsenix.m1532getLyricsyxL6bBk(i, str2, str3, str4, paxsenixLyricsProvider$getLyrics$2);
                        if (objM1532getLyricsyxL6bBk == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i7 != 1) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj3);
                        objM1532getLyricsyxL6bBk = ((Result) obj3).value;
                    }
                    Object obj4 = objM1532getLyricsyxL6bBk;
                    if (!(obj4 instanceof Result.Failure)) {
                        Timber.Forest.tag("PaxsenixProvider");
                        ((String) obj4).getClass();
                        ConnectionPool.i(new Object[0]);
                    }
                    if (Result.m1866exceptionOrNullimpl(obj4) == null) {
                        return obj4;
                    }
                    Timber.Forest.tag("PaxsenixProvider");
                    ConnectionPool.e$1(new Object[0]);
                    return obj4;
                } catch (Exception e) {
                    Timber.Forest.tag("PaxsenixProvider");
                    ConnectionPool.e$1(new Object[0]);
                    return new Result.Failure(e);
                }
        }
    }

    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final String getName() {
        switch (this.$r8$classId) {
            case 0:
                return "Kugou";
            case 1:
                return "LrcLib";
            default:
                return "Paxsenix";
        }
    }

    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final boolean isEnabled(Context context) {
        switch (this.$r8$classId) {
            case 0:
                Boolean bool = (Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.EnableKugouKey);
                if (bool != null) {
                    return bool.booleanValue();
                }
                return true;
            case 1:
                Boolean bool2 = (Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.EnableLrcLibKey);
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
                return true;
            default:
                Boolean bool3 = (Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.EnablePaxsenixKey);
                if (bool3 != null) {
                    return bool3.booleanValue();
                }
                return true;
        }
    }
}
