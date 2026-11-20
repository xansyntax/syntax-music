package com.metrolist.music.utils;

import androidx.compose.material3.SheetState;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.MusicService;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentDisposition;
import io.ktor.http.HttpMethod;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Updater$getLatestRelease$2 extends SuspendLambda implements Function2 {
    public boolean $forceRefresh;
    public final /* synthetic */ byte $r8$classId = 1;
    public /* synthetic */ Object L$0;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Updater$getLatestRelease$2(boolean z, SheetState sheetState, Continuation continuation) {
        super(2, continuation);
        this.$forceRefresh = z;
        this.L$0 = sheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                Updater$getLatestRelease$2 updater$getLatestRelease$2 = new Updater$getLatestRelease$2(this.$forceRefresh, continuation);
                updater$getLatestRelease$2.L$0 = obj;
                return updater$getLatestRelease$2;
            case 1:
                return new Updater$getLatestRelease$2((MusicService) this.L$0, continuation);
            default:
                return new Updater$getLatestRelease$2(this.$forceRefresh, (SheetState) this.L$0, continuation);
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
                break;
            case 1:
                break;
        }
        return ((Updater$getLatestRelease$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r1.show(r10) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (r1.hide(r10) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b4, code lost:
    
        if (r5.updateDiscordRPC(r11, r1, r10) == r6) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x010b, code lost:
    
        if (r11 == r0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object failure;
        boolean z;
        Song song;
        Continuation continuation = null;
        switch (this.$r8$classId) {
            case 0:
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b = this.label;
                try {
                    if (b == 0) {
                        ResultKt.throwOnFailure(obj);
                        boolean z2 = this.$forceRefresh;
                        failure = Updater.cachedReleaseInfo;
                        if (failure == null || z2) {
                            HttpClient httpClient = Updater.client;
                            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                            HttpRequestKt.url(httpRequestBuilder, "https://api.github.com/repos/MetrolistGroup/Metrolist/releases/latest");
                            httpRequestBuilder.setMethod(HttpMethod.Get);
                            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                            this.L$0 = null;
                            this.label = (byte) 1;
                            obj = httpStatement.execute(this);
                            if (obj == coroutineSingletons) {
                            }
                            return coroutineSingletons;
                        }
                        return new Result(failure);
                    }
                    if (b == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    JSONObject jSONObject = new JSONObject((String) obj);
                    String string = jSONObject.getString("tag_name");
                    string.getClass();
                    String string2 = jSONObject.getString(ContentDisposition.Parameters.Name);
                    string2.getClass();
                    String string3 = jSONObject.getString("body");
                    string3.getClass();
                    String string4 = jSONObject.getString("published_at");
                    string4.getClass();
                    Updater updater = Updater.INSTANCE;
                    JSONArray jSONArray = jSONObject.getJSONArray("assets");
                    jSONArray.getClass();
                    ReleaseInfo releaseInfo = new ReleaseInfo(string, string2, string3, string4, Updater.parseAssets(jSONArray));
                    Updater.cachedReleaseInfo = releaseInfo;
                    Updater.lastCheckTime = System.currentTimeMillis();
                    failure = releaseInfo;
                    return new Result(failure);
                    this.L$0 = null;
                    this.label = (byte) 2;
                    obj = HttpResponseKt.bodyAsText$default((HttpResponse) obj, null, this, 1, null);
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                break;
            case 1:
                Unit unit = Unit.INSTANCE;
                MusicService musicService = (MusicService) this.L$0;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    HandlerContext handlerContext = MainDispatcherLoader.dispatcher.immediate;
                    MusicService.AnonymousClass15 anonymousClass15 = new MusicService.AnonymousClass15((byte) 5, musicService, continuation);
                    this.label = (byte) 1;
                    obj = AwaitKt.withContext(handlerContext, anonymousClass15, this);
                    if (obj != coroutineSingletons2) {
                    }
                    return coroutineSingletons2;
                }
                if (b2 != 1) {
                    if (b2 == 2) {
                        z = this.$forceRefresh;
                        ResultKt.throwOnFailure(obj);
                        song = (Song) obj;
                        if (song != null) {
                            this.$forceRefresh = z;
                            this.label = (byte) 3;
                            boolean z3 = MusicService.isRunning;
                        }
                    } else {
                        if (b2 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    break;
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
                Pair pair = (Pair) obj;
                String str = (String) pair.first;
                boolean zBooleanValue = ((Boolean) pair.second).booleanValue();
                if (str != null) {
                    Flow flowSong = musicService.getDatabase().$$delegate_0.song(str);
                    this.$forceRefresh = zBooleanValue;
                    this.label = (byte) 2;
                    Object objFirst = StateFlowKt.first(flowSong, this);
                    if (objFirst != coroutineSingletons2) {
                        z = zBooleanValue;
                        obj = objFirst;
                        song = (Song) obj;
                        if (song != null) {
                            this.$forceRefresh = z;
                            this.label = (byte) 3;
                            boolean z4 = MusicService.isRunning;
                        }
                        break;
                    }
                    return coroutineSingletons2;
                }
                return unit;
            default:
                CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean z5 = this.$forceRefresh;
                    SheetState sheetState = (SheetState) this.L$0;
                    if (!z5) {
                        this.label = (byte) 2;
                    } else {
                        this.label = (byte) 1;
                    }
                    break;
                } else {
                    if (b3 != 1 && b3 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Updater$getLatestRelease$2(MusicService musicService, Continuation continuation) {
        super(2, continuation);
        this.L$0 = musicService;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Updater$getLatestRelease$2(boolean z, Continuation continuation) {
        super(2, continuation);
        this.$forceRefresh = z;
    }
}
