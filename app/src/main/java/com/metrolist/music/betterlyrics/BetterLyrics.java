package com.metrolist.music.betterlyrics;

import com.metrolist.music.betterlyrics.models.TTMLResponse;
import com.metrolist.music.db.entities.CachedItem$$ExternalSyntheticLambda0;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.reflect.TypeInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BetterLyrics {
    public static final BetterLyrics INSTANCE = new BetterLyrics();
    public static final SynchronizedLazyImpl client$delegate = new SynchronizedLazyImpl(new CachedItem$$ExternalSyntheticLambda0(1));

    /* JADX INFO: renamed from: com.metrolist.music.betterlyrics.BetterLyrics$fetchTTML$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BetterLyrics.this.fetchTTML(0, null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0109  */
    /* JADX WARN: Code duplicated, block: B:59:0x010b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c5, code lost:
    
        if (r8 == r6) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable fetchTTML(int i, String str, String str2, String str3, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Serializable failure;
        TypeReference typeReferenceTypeOf;
        String string;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objExecute = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    i = anonymousClass1.I$0;
                    ResultKt.throwOnFailure(objExecute);
                } else {
                    if (i3 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                }
                if (objExecute == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.betterlyrics.models.TTMLResponse");
                }
                String str4 = ((TTMLResponse) objExecute).ttml;
                failure = (str4 == null || (string = StringsKt.trim(str4).toString()) == null || string.length() <= 0) ? null : string;
                if (Result.m1866exceptionOrNullimpl(failure) == null) {
                    return failure;
                }
                Timber.Forest.tag("BetterLyrics");
                ConnectionPool.e$1(new Object[0]);
                return null;
            }
            ResultKt.throwOnFailure(objExecute);
            Timber.Forest.tag("BetterLyrics");
            ConnectionPool.d(new Object[0]);
            HttpClient httpClient = (HttpClient) client$delegate.getValue();
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, "/getLyrics");
            UtilsKt.parameter(httpRequestBuilder, "s", str2);
            UtilsKt.parameter(httpRequestBuilder, "a", str);
            if (i > 0) {
                UtilsKt.parameter(httpRequestBuilder, "d", new Integer(i));
            }
            if (str3 != null && !StringsKt.isBlank(str3)) {
                UtilsKt.parameter(httpRequestBuilder, "al", str3);
            }
            httpRequestBuilder.setMethod(HttpMethod.Get);
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            objExecute = httpStatement.execute(anonymousClass1);
            if (objExecute == coroutineSingletons) {
            }
            return coroutineSingletons;
            HttpResponse httpResponse = (HttpResponse) objExecute;
            if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getOK())) {
                HttpClientCall call = httpResponse.getCall();
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TTMLResponse.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(TTMLResponse.class);
                } catch (Throwable unused) {
                    typeReferenceTypeOf = null;
                }
                TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
                anonymousClass1.I$0 = i;
                anonymousClass1.label = 2;
                objExecute = call.bodyNullable(typeInfo, anonymousClass1);
            } else {
                Timber.Forest.tag("BetterLyrics");
                Objects.toString(httpResponse.getStatus());
                ConnectionPool.w(new Object[0]);
            }
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) == null) {
            return failure;
        }
        Timber.Forest.tag("BetterLyrics");
        ConnectionPool.e$1(new Object[0]);
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: getLyrics-yxL6bBk, reason: not valid java name */
    public final Serializable m1057getLyricsyxL6bBk(int i, String str, String str2, String str3, ContinuationImpl continuationImpl) {
        BetterLyrics$getLyrics$1 betterLyrics$getLyrics$1;
        if (continuationImpl instanceof BetterLyrics$getLyrics$1) {
            betterLyrics$getLyrics$1 = (BetterLyrics$getLyrics$1) continuationImpl;
            int i2 = betterLyrics$getLyrics$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                betterLyrics$getLyrics$1.label = i2 - Integer.MIN_VALUE;
            } else {
                betterLyrics$getLyrics$1 = new BetterLyrics$getLyrics$1(this, continuationImpl);
            }
        } else {
            betterLyrics$getLyrics$1 = new BetterLyrics$getLyrics$1(this, continuationImpl);
        }
        BetterLyrics$getLyrics$1 betterLyrics$getLyrics$2 = betterLyrics$getLyrics$1;
        Object objFetchTTML = betterLyrics$getLyrics$2.result;
        int i3 = betterLyrics$getLyrics$2.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objFetchTTML);
                betterLyrics$getLyrics$2.label = 1;
                objFetchTTML = fetchTTML(i, str2, str, str3, betterLyrics$getLyrics$2);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objFetchTTML == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i3 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objFetchTTML);
            }
            String str4 = (String) objFetchTTML;
            if (str4 == null) {
                throw new IllegalStateException("Lyrics unavailable");
            }
            List ttml = StringsKt__IndentKt.parseTTML(str4);
            if (ttml.isEmpty()) {
                throw new IllegalStateException("Failed to parse lyrics");
            }
            return StringsKt__IndentKt.toLRC(ttml);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }
}
