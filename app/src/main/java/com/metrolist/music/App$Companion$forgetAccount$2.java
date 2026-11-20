package com.metrolist.music;

import android.view.Choreographer;
import android.webkit.CookieManager;
import androidx.compose.foundation.gestures.ScrollScope;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.recognition.MusicRecognitionService;
import com.metrolist.shazamkit.models.RecognitionStatus;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class App$Companion$forgetAccount$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ App$Companion$forgetAccount$2(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 0);
            case 1:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 1);
            case 2:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 2);
            case 3:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 3);
            case 4:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 4);
            case 5:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 5);
            case 6:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 6);
            case 7:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 7);
            case 8:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 8);
            case 9:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 9);
            case 10:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 10);
            case 11:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 11);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 12);
            case 13:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 13);
            case 14:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 14);
            case 15:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 15);
            case 16:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 16);
            case 17:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 17);
            case 18:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 18);
            case 19:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 19);
            default:
                return new App$Companion$forgetAccount$2(2, continuation, (byte) 20);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                ((App$Companion$forgetAccount$2) create((Flow) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 2:
                ((App$Companion$forgetAccount$2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 3:
                ((App$Companion$forgetAccount$2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 4:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 5:
                return ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 6:
                ((App$Companion$forgetAccount$2) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 7:
                ((App$Companion$forgetAccount$2) create((String) obj, (Continuation) obj2)).invokeSuspend(unit);
                return null;
            case 8:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 9:
                ((App$Companion$forgetAccount$2) create((List) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 10:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 11:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 13:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 14:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 15:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 16:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 17:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 18:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 19:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            default:
                ((App$Companion$forgetAccount$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.removeAllCookies(new App$Companion$forgetAccount$2$$ExternalSyntheticLambda0());
                cookieManager.flush();
                return cookieManager;
            case 1:
                ResultKt.throwOnFailure(obj);
                return unit;
            case 2:
                ResultKt.throwOnFailure(obj);
                return unit;
            case 3:
                ResultKt.throwOnFailure(obj);
                return unit;
            case 4:
                ResultKt.throwOnFailure(obj);
                return unit;
            case 5:
                ResultKt.throwOnFailure(obj);
                return Choreographer.getInstance();
            case 6:
                ResultKt.throwOnFailure(obj);
                return unit;
            case 7:
                ResultKt.throwOnFailure(obj);
                return null;
            case 8:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.disconnect();
                return unit;
            case 9:
                ResultKt.throwOnFailure(obj);
                return unit;
            case 10:
                ResultKt.throwOnFailure(obj);
                MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
                if (MusicRecognitionService.recognitionStatus.$$delegate_0.getValue() instanceof RecognitionStatus.Ready) {
                    MusicRecognitionService.reset();
                }
                return unit;
            case 11:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return unit;
            case 13:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return unit;
            case 14:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return unit;
            case 15:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return unit;
            case 16:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return unit;
            case 17:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return unit;
            case 18:
                ResultKt.throwOnFailure(obj);
                try {
                    DiscordRpcManager.INSTANCE.logout();
                    break;
                } catch (Exception unused) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                return unit;
            case 19:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return unit;
            default:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager.INSTANCE.notifySettingsChanged();
                return unit;
        }
    }
}
