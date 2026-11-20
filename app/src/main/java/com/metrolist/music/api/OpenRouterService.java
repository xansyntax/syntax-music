package com.metrolist.music.api;

import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.Regex;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OpenRouterService {
    public static final OpenRouterService INSTANCE = new OpenRouterService();
    public static final OkHttpClient client;
    public static final MediaType jsonMediaType;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(30L, timeUnit);
        builder.readTimeout(90L, timeUnit);
        builder.writeTimeout(30L, timeUnit);
        client = new OkHttpClient(builder);
        Regex regex = MediaType.TYPE_SUBTYPE;
        jsonMediaType = CollectionsKt__IterablesKt.get("application/json; charset=utf-8");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX INFO: renamed from: translate-tZkwj4A, reason: not valid java name */
    public final Object m1056translatetZkwj4A(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, ContinuationImpl continuationImpl) {
        OpenRouterService$translate$1 openRouterService$translate$1;
        if (continuationImpl instanceof OpenRouterService$translate$1) {
            openRouterService$translate$1 = (OpenRouterService$translate$1) continuationImpl;
            int i2 = openRouterService$translate$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                openRouterService$translate$1.label = i2 - Integer.MIN_VALUE;
            } else {
                openRouterService$translate$1 = new OpenRouterService$translate$1(this, continuationImpl);
            }
        } else {
            openRouterService$translate$1 = new OpenRouterService$translate$1(this, continuationImpl);
        }
        Object objWithContext = openRouterService$translate$1.result;
        int i3 = openRouterService$translate$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            OpenRouterService$translate$2 openRouterService$translate$2 = new OpenRouterService$translate$2(str, i, str2, str5, str6, str7, str4, str3, null);
            openRouterService$translate$1.label = 1;
            objWithContext = AwaitKt.withContext(defaultIoScheduler, openRouterService$translate$2, openRouterService$translate$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).value;
    }
}
