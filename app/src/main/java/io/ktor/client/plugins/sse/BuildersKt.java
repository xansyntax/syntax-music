package io.ktor.client.plugins.sse;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.call.SavedHttpResponse;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.http.URLParserKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.time.Duration;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a)\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001aL\u0010\u0012\u001a\u00020\u000f*\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a~\u0010\u0012\u001a\u00020\u000f*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u0019\u0010\u001a\u001aV\u0010\u0012\u001a\u00020\u000f*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u001c\u0010\u001d\u001ap\u0010$\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b\"\u0010#\u001a¢\u0001\u0010$\u001a\u00020\u0003*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b%\u0010&\u001az\u0010$\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b'\u0010(\u001aL\u0010*\u001a\u00020\u000f*\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b)\u0010\u0011\u001a~\u0010*\u001a\u00020\u000f*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b+\u0010\u001a\u001aV\u0010*\u001a\u00020\u000f*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b,\u0010\u001d\u001ap\u0010.\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b-\u0010#\u001a¢\u0001\u0010.\u001a\u00020\u0003*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b/\u00100\u001az\u0010.\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b1\u00102\u001ah\u0010\u0012\u001a\u000205*\u00020\u00072\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u001c\u00106\u001a\u009a\u0001\u0010\u0012\u001a\u000205*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b7\u00108\u001ar\u0010\u0012\u001a\u000205*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b9\u0010:\u001a\u008c\u0001\u0010$\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b;\u0010<\u001a¾\u0001\u0010$\u001a\u00020\u0003*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b=\u0010>\u001a\u0096\u0001\u0010$\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b?\u0010@\u001ah\u0010*\u001a\u000205*\u00020\u00072\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b,\u00106\u001a\u009a\u0001\u0010*\u001a\u000205*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\bA\u00108\u001ar\u0010*\u001a\u000205*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\bB\u0010:\u001a\u008c\u0001\u0010.\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b1\u0010<\u001a¾\u0001\u0010.\u001a\u00020\u0003*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\bC\u0010D\u001a\u0096\u0001\u0010.\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\bE\u0010F\u001ab\u0010K\u001a\u00028\u0000\"\u0006\b\u0000\u0010G\u0018\u0001*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0082H¢\u0006\u0004\bI\u0010J\u001a5\u0010O\u001a\u00020\u0003\"\b\b\u0000\u0010G*\u00020!*\u00020\r2\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000L2\b\u0010N\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\bO\u0010P\u001a/\u0010W\u001a\u00020U*\u00020\u00072\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010T\u001a\u0004\u0018\u00010S2\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0019\u0010[\u001a\u00020\u0003*\u00020\r2\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010\\\" \u0010]\u001a\b\u0012\u0004\u0012\u00020\n0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\" \u0010a\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\ba\u0010^\u001a\u0004\bb\u0010`\" \u0010c\u001a\b\u0012\u0004\u0012\u00020\n0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bc\u0010^\u001a\u0004\bd\u0010`\" \u0010e\u001a\b\u0012\u0004\u0012\u00020\n0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\be\u0010^\u001a\u0004\bf\u0010`\"4\u0010g\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bg\u0010^\u001a\u0004\bh\u0010`\" \u0010i\u001a\b\u0012\u0004\u0012\u00020Y0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bi\u0010^\u001a\u0004\bj\u0010`¨\u0006k"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/sse/SSEConfig;", "", "config", "SSE", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/HttpClient;", "Lkotlin/time/Duration;", "reconnectionTime", "", "showCommentEvents", "showRetryEvents", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lio/ktor/client/plugins/sse/ClientSSESession;", "serverSentEventsSession-i8z2VEo", "(Lio/ktor/client/HttpClient;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession", "", "scheme", "host", "", "port", "path", "serverSentEventsSession-xEWcMm4", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "serverSentEventsSession-mY9Nd3A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "serverSentEvents-mY9Nd3A", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents", "serverSentEvents-1wIb-0I", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-3bFjkrY", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sseSession-i8z2VEo", "sseSession", "sseSession-xEWcMm4", "sseSession-mY9Nd3A", "sse-mY9Nd3A", "sse", "sse-tL6_L-A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sse-Mswn-_c", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "deserialize", "Lio/ktor/client/plugins/sse/ClientSSESessionWithDeserialization;", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession-tL6_L-A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession-Mswn-_c", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-Mswn-_c", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-BqdlHlk", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-pTj2aPc", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sseSession-tL6_L-A", "sseSession-Mswn-_c", "sse-BAHpl2s", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sse-Q9yt8Vw", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "additionalAttributes", "processSession-rp2poPw", "(Lio/ktor/client/HttpClient;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processSession", "Lio/ktor/util/AttributeKey;", "attributeKey", "value", "addAttribute", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/client/call/HttpClientCall;", "call", "", "body", "", "cause", "mapToSSEException", "(Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;[BLjava/lang/Throwable;)Ljava/lang/Throwable;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "policy", "bufferPolicy", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/plugins/sse/SSEBufferPolicy;)V", "sseRequestAttr", "Lio/ktor/util/AttributeKey;", "getSseRequestAttr", "()Lio/ktor/util/AttributeKey;", "reconnectionTimeAttr", "getReconnectionTimeAttr", "showCommentEventsAttr", "getShowCommentEventsAttr", "showRetryEventsAttr", "getShowRetryEventsAttr", "deserializerAttr", "getDeserializerAttr", "sseBufferPolicyAttr", "getSseBufferPolicyAttr", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuildersKt {
    private static final AttributeKey<Function2> deserializerAttr;
    private static final AttributeKey<Duration> reconnectionTimeAttr;
    private static final AttributeKey<Boolean> showCommentEventsAttr;
    private static final AttributeKey<Boolean> showRetryEventsAttr;
    private static final AttributeKey<SSEBufferPolicy> sseBufferPolicyAttr;
    private static final AttributeKey<Boolean> sseRequestAttr;

    static {
        TypeReference typeReferenceTypeOf;
        TypeReference typeReferenceTypeOf2;
        TypeReference typeReferenceTypeOf3;
        TypeReference typeReferenceTypeOf4;
        TypeReference typeReferenceTypeOf5;
        Class cls = Boolean.TYPE;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
        TypeReference typeReferenceTypeOf6 = null;
        try {
            typeReferenceTypeOf = Reflection.typeOf(cls);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        sseRequestAttr = new AttributeKey<>("SSERequestFlag", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Duration.class);
        try {
            typeReferenceTypeOf2 = Reflection.typeOf(Duration.class);
        } catch (Throwable unused2) {
            typeReferenceTypeOf2 = null;
        }
        reconnectionTimeAttr = new AttributeKey<>("SSEReconnectionTime", new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf2));
        ClassReference orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            typeReferenceTypeOf3 = Reflection.typeOf(cls);
        } catch (Throwable unused3) {
            typeReferenceTypeOf3 = null;
        }
        showCommentEventsAttr = new AttributeKey<>("SSEShowCommentEvents", new TypeInfo((KClass<?>) orCreateKotlinClass3, false, (KType) typeReferenceTypeOf3));
        ClassReference orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            typeReferenceTypeOf4 = Reflection.typeOf(cls);
        } catch (Throwable unused4) {
            typeReferenceTypeOf4 = null;
        }
        showRetryEventsAttr = new AttributeKey<>("SSEShowRetryEvents", new TypeInfo((KClass<?>) orCreateKotlinClass4, false, (KType) typeReferenceTypeOf4));
        ClassReference orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Function2.class);
        boolean zIsFunctionOfArity = TypeIntrinsics.isFunctionOfArity(2, null);
        try {
            KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
            typeReferenceTypeOf5 = Reflection.typeOf(Function2.class, companion.invariant(Reflection.typeOf(TypeInfo.class)), companion.invariant(Reflection.typeOf(String.class)), companion.invariant(Reflection.nullableTypeOf(Object.class)));
        } catch (Throwable unused5) {
            typeReferenceTypeOf5 = null;
        }
        deserializerAttr = new AttributeKey<>("SSEDeserializer", new TypeInfo(orCreateKotlinClass5, zIsFunctionOfArity, typeReferenceTypeOf5));
        ClassReference orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(SSEBufferPolicy.class);
        try {
            typeReferenceTypeOf6 = Reflection.typeOf(SSEBufferPolicy.class);
        } catch (Throwable unused6) {
        }
        sseBufferPolicyAttr = new AttributeKey<>("bufferPolicy", new TypeInfo((KClass<?>) orCreateKotlinClass6, false, (KType) typeReferenceTypeOf6));
    }

    public static final void SSE(HttpClientConfig<?> httpClientConfig, Function1 function1) {
        httpClientConfig.getClass();
        function1.getClass();
        httpClientConfig.install(SSEKt.getSSE(), new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 23));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SSE$lambda$0(Function1 function1, SSEConfig sSEConfig) {
        sSEConfig.getClass();
        function1.invoke(sSEConfig);
        return Unit.INSTANCE;
    }

    private static final <T> void addAttribute(HttpRequestBuilder httpRequestBuilder, AttributeKey<T> attributeKey, T t) {
        if (t != null) {
            httpRequestBuilder.getAttributes().put(attributeKey, t);
        }
    }

    public static final void bufferPolicy(HttpRequestBuilder httpRequestBuilder, SSEBufferPolicy sSEBufferPolicy) {
        httpRequestBuilder.getClass();
        sSEBufferPolicy.getClass();
        httpRequestBuilder.getAttributes().put(sseBufferPolicyAttr, sSEBufferPolicy);
    }

    public static final AttributeKey<Function2> getDeserializerAttr() {
        return deserializerAttr;
    }

    public static final AttributeKey<Duration> getReconnectionTimeAttr() {
        return reconnectionTimeAttr;
    }

    public static final AttributeKey<Boolean> getShowCommentEventsAttr() {
        return showCommentEventsAttr;
    }

    public static final AttributeKey<Boolean> getShowRetryEventsAttr() {
        return showRetryEventsAttr;
    }

    public static final AttributeKey<SSEBufferPolicy> getSseBufferPolicyAttr() {
        return sseBufferPolicyAttr;
    }

    public static final AttributeKey<Boolean> getSseRequestAttr() {
        return sseRequestAttr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapToSSEException(HttpClient httpClient, HttpClientCall httpClientCall, byte[] bArr, Throwable th) {
        SavedHttpResponse savedHttpResponse;
        if (httpClientCall == null) {
            savedHttpResponse = null;
        } else {
            if (bArr == null) {
                bArr = new byte[0];
            }
            SavedHttpCall savedHttpCall = new SavedHttpCall(httpClient, httpClientCall.getRequest(), httpClientCall.getResponse(), bArr);
            savedHttpCall.getAttributes().remove(HttpClientCall.INSTANCE.getCustomResponse$ktor_client_core());
            savedHttpCall.getAttributes().remove(sseRequestAttr);
            savedHttpResponse = new SavedHttpResponse(savedHttpCall, bArr, httpClientCall.getResponse());
            savedHttpCall.setResponse$ktor_client_core(savedHttpResponse);
        }
        return (!(th instanceof SSEClientException) || ((SSEClientException) th).getResponse() == null) ? new SSEClientException(savedHttpResponse, th, th.getMessage()) : th;
    }

    /* JADX INFO: renamed from: processSession-rp2poPw, reason: not valid java name */
    private static final <T> Object m1601processSessionrp2poPw(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function1 function2, Continuation continuation) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        AwaitKt.CompletableDeferred$default();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, Boolean.TRUE);
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, duration);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        function2.invoke(httpRequestBuilder);
        new HttpStatement(httpRequestBuilder, httpClient);
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    /* JADX INFO: renamed from: serverSentEvents-1wIb-0I, reason: not valid java name */
    public static final Object m1602serverSentEvents1wIb0I(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function2, Continuation continuation) {
        Object objM1610serverSentEventsmY9Nd3A = m1610serverSentEventsmY9Nd3A(httpClient, new BuildersKt$$ExternalSyntheticLambda0(str, str2, num, str3, function1, (byte) 0), duration, bool, bool2, function2, continuation);
        return objM1610serverSentEventsmY9Nd3A == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1610serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-1wIb-0I$default, reason: not valid java name */
    public static /* synthetic */ Object m1603serverSentEvents1wIb0I$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            duration = null;
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        if ((i & 64) != 0) {
            bool2 = null;
        }
        if ((i & 128) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 10);
        }
        return m1602serverSentEvents1wIb0I(httpClient, str, str2, num, str3, duration, bool, bool2, function1, function2, continuation);
    }

    /* JADX INFO: renamed from: serverSentEvents-3bFjkrY, reason: not valid java name */
    public static final Object m1604serverSentEvents3bFjkrY(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function2, Continuation continuation) {
        Object objM1610serverSentEventsmY9Nd3A = m1610serverSentEventsmY9Nd3A(httpClient, new BuildersKt$$ExternalSyntheticLambda1((byte) 2, str, function1), duration, bool, bool2, function2, continuation);
        return objM1610serverSentEventsmY9Nd3A == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1610serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-3bFjkrY$default, reason: not valid java name */
    public static /* synthetic */ Object m1605serverSentEvents3bFjkrY$default(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 9);
        }
        return m1604serverSentEvents3bFjkrY(httpClient, str, duration, bool, bool2, function1, function2, continuation);
    }

    /* JADX INFO: renamed from: serverSentEvents-BqdlHlk, reason: not valid java name */
    public static final Object m1606serverSentEventsBqdlHlk(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function3, Continuation continuation) {
        Object objM1608serverSentEventsMswn_c = m1608serverSentEventsMswn_c(httpClient, new BuildersKt$$ExternalSyntheticLambda0(str, str2, num, str3, function1, (byte) 3), function2, duration, bool, bool2, function3, continuation);
        return objM1608serverSentEventsMswn_c == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1608serverSentEventsMswn_c : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-BqdlHlk$default, reason: not valid java name */
    public static /* synthetic */ Object m1607serverSentEventsBqdlHlk$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            duration = null;
        }
        if ((i & 64) != 0) {
            bool = null;
        }
        if ((i & 128) != 0) {
            bool2 = null;
        }
        if ((i & 256) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 7);
        }
        return m1606serverSentEventsBqdlHlk(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, function3, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX WARN: Type inference failed for: r1v3, types: [int, kotlinx.coroutines.CoroutineScope] */
    /* JADX INFO: renamed from: serverSentEvents-Mswn-_c, reason: not valid java name */
    public static final Object m1608serverSentEventsMswn_c(HttpClient httpClient, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation) {
        BuildersKt$serverSentEvents$8 buildersKt$serverSentEvents$8;
        Function2 function4;
        HttpClient httpClient2;
        ClientSSESessionWithDeserialization clientSSESessionWithDeserialization;
        ClientSSESessionWithDeserialization clientSSESessionWithDeserialization2;
        if (continuation instanceof BuildersKt$serverSentEvents$8) {
            buildersKt$serverSentEvents$8 = (BuildersKt$serverSentEvents$8) continuation;
            int i = buildersKt$serverSentEvents$8.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                buildersKt$serverSentEvents$8.label = i - Integer.MIN_VALUE;
            } else {
                buildersKt$serverSentEvents$8 = new BuildersKt$serverSentEvents$8(continuation);
            }
        } else {
            buildersKt$serverSentEvents$8 = new BuildersKt$serverSentEvents$8(continuation);
        }
        BuildersKt$serverSentEvents$8 buildersKt$serverSentEvents$9 = buildersKt$serverSentEvents$8;
        Object objM1619serverSentEventsSessionmY9Nd3A = buildersKt$serverSentEvents$9.result;
        ?? r1 = buildersKt$serverSentEvents$9.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (r1 == 0) {
                    ResultKt.throwOnFailure(objM1619serverSentEventsSessionmY9Nd3A);
                    buildersKt$serverSentEvents$9.L$0 = httpClient;
                    buildersKt$serverSentEvents$9.L$1 = null;
                    buildersKt$serverSentEvents$9.L$2 = null;
                    buildersKt$serverSentEvents$9.L$3 = null;
                    buildersKt$serverSentEvents$9.L$4 = null;
                    buildersKt$serverSentEvents$9.L$5 = null;
                    function4 = function3;
                    buildersKt$serverSentEvents$9.L$6 = function4;
                    buildersKt$serverSentEvents$9.label = 1;
                    objM1619serverSentEventsSessionmY9Nd3A = m1619serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, function1, buildersKt$serverSentEvents$9);
                    if (objM1619serverSentEventsSessionmY9Nd3A != coroutineSingletons) {
                        httpClient2 = httpClient;
                    }
                    return coroutineSingletons;
                }
                if (r1 != 1) {
                    if (r1 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    clientSSESessionWithDeserialization2 = (ClientSSESessionWithDeserialization) buildersKt$serverSentEvents$9.L$7;
                    httpClient2 = (HttpClient) buildersKt$serverSentEvents$9.L$0;
                    try {
                        ResultKt.throwOnFailure(objM1619serverSentEventsSessionmY9Nd3A);
                        AwaitKt.cancel(clientSSESessionWithDeserialization2, (CancellationException) null);
                        return Unit.INSTANCE;
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        throw mapToSSEException(httpClient2, clientSSESessionWithDeserialization2.getCall(), clientSSESessionWithDeserialization2.bodyBuffer(), th);
                    }
                }
                function4 = (Function2) buildersKt$serverSentEvents$9.L$6;
                httpClient2 = (HttpClient) buildersKt$serverSentEvents$9.L$0;
                ResultKt.throwOnFailure(objM1619serverSentEventsSessionmY9Nd3A);
                buildersKt$serverSentEvents$9.L$0 = httpClient2;
                buildersKt$serverSentEvents$9.L$1 = null;
                buildersKt$serverSentEvents$9.L$2 = null;
                buildersKt$serverSentEvents$9.L$3 = null;
                buildersKt$serverSentEvents$9.L$4 = null;
                buildersKt$serverSentEvents$9.L$5 = null;
                buildersKt$serverSentEvents$9.L$6 = null;
                buildersKt$serverSentEvents$9.L$7 = clientSSESessionWithDeserialization;
                buildersKt$serverSentEvents$9.label = 2;
                if (function4.invoke(clientSSESessionWithDeserialization, buildersKt$serverSentEvents$9) != coroutineSingletons) {
                    clientSSESessionWithDeserialization2 = clientSSESessionWithDeserialization;
                    AwaitKt.cancel(clientSSESessionWithDeserialization2, (CancellationException) null);
                    return Unit.INSTANCE;
                }
                return coroutineSingletons;
            } catch (CancellationException e2) {
                throw e2;
            } catch (Throwable th2) {
                th = th2;
                clientSSESessionWithDeserialization2 = clientSSESessionWithDeserialization;
                throw mapToSSEException(httpClient2, clientSSESessionWithDeserialization2.getCall(), clientSSESessionWithDeserialization2.bodyBuffer(), th);
            }
            clientSSESessionWithDeserialization = (ClientSSESessionWithDeserialization) objM1619serverSentEventsSessionmY9Nd3A;
        } catch (Throwable th3) {
            AwaitKt.cancel((CoroutineScope) r1, (CancellationException) null);
            throw th3;
        }
    }

    /* JADX INFO: renamed from: serverSentEvents-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m1609serverSentEventsMswn_c$default(HttpClient httpClient, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        return m1608serverSentEventsMswn_c(httpClient, function1, function2, duration, bool, bool2, function3, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX WARN: Type inference failed for: r1v3, types: [int, kotlinx.coroutines.CoroutineScope] */
    /* JADX INFO: renamed from: serverSentEvents-mY9Nd3A, reason: not valid java name */
    public static final Object m1610serverSentEventsmY9Nd3A(HttpClient httpClient, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation) {
        BuildersKt$serverSentEvents$1 buildersKt$serverSentEvents$1;
        Function2 function3;
        HttpClient httpClient2;
        ClientSSESession clientSSESession;
        ClientSSESession clientSSESession2;
        if (continuation instanceof BuildersKt$serverSentEvents$1) {
            buildersKt$serverSentEvents$1 = (BuildersKt$serverSentEvents$1) continuation;
            int i = buildersKt$serverSentEvents$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                buildersKt$serverSentEvents$1.label = i - Integer.MIN_VALUE;
            } else {
                buildersKt$serverSentEvents$1 = new BuildersKt$serverSentEvents$1(continuation);
            }
        } else {
            buildersKt$serverSentEvents$1 = new BuildersKt$serverSentEvents$1(continuation);
        }
        BuildersKt$serverSentEvents$1 buildersKt$serverSentEvents$2 = buildersKt$serverSentEvents$1;
        Object objM1616serverSentEventsSessioni8z2VEo = buildersKt$serverSentEvents$2.result;
        ?? r1 = buildersKt$serverSentEvents$2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (r1 == 0) {
                    ResultKt.throwOnFailure(objM1616serverSentEventsSessioni8z2VEo);
                    buildersKt$serverSentEvents$2.L$0 = httpClient;
                    buildersKt$serverSentEvents$2.L$1 = null;
                    buildersKt$serverSentEvents$2.L$2 = null;
                    buildersKt$serverSentEvents$2.L$3 = null;
                    buildersKt$serverSentEvents$2.L$4 = null;
                    function3 = function2;
                    buildersKt$serverSentEvents$2.L$5 = function3;
                    buildersKt$serverSentEvents$2.label = 1;
                    objM1616serverSentEventsSessioni8z2VEo = m1616serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, function1, buildersKt$serverSentEvents$2);
                    if (objM1616serverSentEventsSessioni8z2VEo != coroutineSingletons) {
                        httpClient2 = httpClient;
                    }
                    return coroutineSingletons;
                }
                if (r1 != 1) {
                    if (r1 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    clientSSESession2 = (ClientSSESession) buildersKt$serverSentEvents$2.L$6;
                    httpClient2 = (HttpClient) buildersKt$serverSentEvents$2.L$0;
                    try {
                        ResultKt.throwOnFailure(objM1616serverSentEventsSessioni8z2VEo);
                        AwaitKt.cancel(clientSSESession2, (CancellationException) null);
                        return Unit.INSTANCE;
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        throw mapToSSEException(httpClient2, clientSSESession2.getCall(), clientSSESession2.bodyBuffer(), th);
                    }
                }
                function3 = (Function2) buildersKt$serverSentEvents$2.L$5;
                httpClient2 = (HttpClient) buildersKt$serverSentEvents$2.L$0;
                ResultKt.throwOnFailure(objM1616serverSentEventsSessioni8z2VEo);
                buildersKt$serverSentEvents$2.L$0 = httpClient2;
                buildersKt$serverSentEvents$2.L$1 = null;
                buildersKt$serverSentEvents$2.L$2 = null;
                buildersKt$serverSentEvents$2.L$3 = null;
                buildersKt$serverSentEvents$2.L$4 = null;
                buildersKt$serverSentEvents$2.L$5 = null;
                buildersKt$serverSentEvents$2.L$6 = clientSSESession;
                buildersKt$serverSentEvents$2.label = 2;
                if (function3.invoke(clientSSESession, buildersKt$serverSentEvents$2) != coroutineSingletons) {
                    clientSSESession2 = clientSSESession;
                    AwaitKt.cancel(clientSSESession2, (CancellationException) null);
                    return Unit.INSTANCE;
                }
                return coroutineSingletons;
            } catch (CancellationException e2) {
                throw e2;
            } catch (Throwable th2) {
                th = th2;
                clientSSESession2 = clientSSESession;
                throw mapToSSEException(httpClient2, clientSSESession2.getCall(), clientSSESession2.bodyBuffer(), th);
            }
            clientSSESession = (ClientSSESession) objM1616serverSentEventsSessioni8z2VEo;
        } catch (Throwable th3) {
            AwaitKt.cancel((CoroutineScope) r1, (CancellationException) null);
            throw th3;
        }
    }

    /* JADX INFO: renamed from: serverSentEvents-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m1611serverSentEventsmY9Nd3A$default(HttpClient httpClient, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        return m1610serverSentEventsmY9Nd3A(httpClient, function1, duration, bool, bool2, function2, continuation);
    }

    /* JADX INFO: renamed from: serverSentEvents-pTj2aPc, reason: not valid java name */
    public static final Object m1612serverSentEventspTj2aPc(HttpClient httpClient, String str, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function3, Continuation continuation) {
        Object objM1608serverSentEventsMswn_c = m1608serverSentEventsMswn_c(httpClient, new BuildersKt$$ExternalSyntheticLambda1((byte) 0, str, function1), function2, duration, bool, bool2, function3, continuation);
        return objM1608serverSentEventsMswn_c == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1608serverSentEventsMswn_c : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-pTj2aPc$default, reason: not valid java name */
    public static /* synthetic */ Object m1613serverSentEventspTj2aPc$default(HttpClient httpClient, String str, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        if ((i & 32) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 12);
        }
        return m1612serverSentEventspTj2aPc(httpClient, str, function2, duration, bool, bool2, function1, function3, continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-Mswn-_c, reason: not valid java name */
    public static final Object m1614serverSentEventsSessionMswn_c(HttpClient httpClient, String str, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1619serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, new BuildersKt$$ExternalSyntheticLambda1((byte) 1, str, function1), continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m1615serverSentEventsSessionMswn_c$default(HttpClient httpClient, String str, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        if ((i & 32) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 8);
        }
        return m1614serverSentEventsSessionMswn_c(httpClient, str, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-i8z2VEo, reason: not valid java name */
    public static final Object m1616serverSentEventsSessioni8z2VEo(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, Boolean.TRUE);
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, duration);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        AwaitKt.launch$default(httpClient, null, null, new BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredImplCompletableDeferred$default, httpClient, null), 3);
        return completableDeferredImplCompletableDeferred$default.awaitInternal(continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-i8z2VEo$default, reason: not valid java name */
    public static /* synthetic */ Object m1617serverSentEventsSessioni8z2VEo$default(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            duration = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            bool2 = null;
        }
        return m1616serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A, reason: not valid java name */
    public static final Object m1619serverSentEventsSessionmY9Nd3A(HttpClient httpClient, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, Boolean.TRUE);
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, duration);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        addAttribute(httpRequestBuilder, deserializerAttr, function2);
        AwaitKt.launch$default(httpClient, null, null, new BuildersKt$serverSentEventsSessionmY9Nd3A$$inlined$processSessionrp2poPw$1(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredImplCompletableDeferred$default, httpClient, null), 3);
        return completableDeferredImplCompletableDeferred$default.awaitInternal(continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m1620serverSentEventsSessionmY9Nd3A$default(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 22);
        }
        return m1618serverSentEventsSessionmY9Nd3A(httpClient, str, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-tL6_L-A, reason: not valid java name */
    public static final Object m1622serverSentEventsSessiontL6_LA(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1619serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, new BuildersKt$$ExternalSyntheticLambda0(str, str2, num, str3, function1, (byte) 2), continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-tL6_L-A$default, reason: not valid java name */
    public static /* synthetic */ Object m1623serverSentEventsSessiontL6_LA$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            duration = null;
        }
        if ((i & 64) != 0) {
            bool = null;
        }
        if ((i & 128) != 0) {
            bool2 = null;
        }
        if ((i & 256) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 14);
        }
        return m1622serverSentEventsSessiontL6_LA(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-xEWcMm4, reason: not valid java name */
    public static final Object m1624serverSentEventsSessionxEWcMm4(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1616serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, new BuildersKt$$ExternalSyntheticLambda0(str, str2, num, str3, function1, (byte) 1), continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-xEWcMm4$default, reason: not valid java name */
    public static /* synthetic */ Object m1625serverSentEventsSessionxEWcMm4$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            duration = null;
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        if ((i & 64) != 0) {
            bool2 = null;
        }
        if ((i & 128) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 17);
        }
        return m1624serverSentEventsSessionxEWcMm4(httpClient, str, str2, num, str3, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_Mswn__c$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_Mswn__c$lambda$1(String str, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_mY9Nd3A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_mY9Nd3A$lambda$1(String str, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_tL6_L_A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_tL6_L_A$lambda$1(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        HttpRequestKt.url$default(httpRequestBuilder, str, str2, num, str3, null, 16, null);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_xEWcMm4$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_xEWcMm4$lambda$1(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        HttpRequestKt.url$default(httpRequestBuilder, str, str2, num, str3, null, 16, null);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_1wIb_0I$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_1wIb_0I$lambda$1(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        HttpRequestKt.url$default(httpRequestBuilder, str, str2, num, str3, null, 16, null);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_3bFjkrY$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_3bFjkrY$lambda$1(String str, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_BqdlHlk$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_BqdlHlk$lambda$1(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        HttpRequestKt.url$default(httpRequestBuilder, str, str2, num, str3, null, 16, null);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_pTj2aPc$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_pTj2aPc$lambda$1(String str, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-BAHpl2s, reason: not valid java name */
    public static final Object m1626sseBAHpl2s(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation) {
        Object objM1606serverSentEventsBqdlHlk = m1606serverSentEventsBqdlHlk(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, function3, continuation);
        return objM1606serverSentEventsBqdlHlk == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1606serverSentEventsBqdlHlk : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-BAHpl2s$default, reason: not valid java name */
    public static /* synthetic */ Object m1627sseBAHpl2s$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 16);
        }
        if ((i & 64) != 0) {
            duration = null;
        }
        if ((i & 128) != 0) {
            bool = null;
        }
        if ((i & 256) != 0) {
            bool2 = null;
        }
        return m1626sseBAHpl2s(httpClient, str, str2, num, str3, function1, function2, duration, bool, bool2, function3, continuation);
    }

    /* JADX INFO: renamed from: sse-Mswn-_c, reason: not valid java name */
    public static final Object m1628sseMswn_c(HttpClient httpClient, String str, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation) {
        Object objM1604serverSentEvents3bFjkrY = m1604serverSentEvents3bFjkrY(httpClient, str, duration, bool, bool2, function1, function2, continuation);
        return objM1604serverSentEvents3bFjkrY == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1604serverSentEvents3bFjkrY : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m1630sseMswn_c$default(HttpClient httpClient, String str, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 20);
        }
        return m1628sseMswn_c(httpClient, str, function1, (i & 4) != 0 ? null : duration, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, function2, continuation);
    }

    /* JADX INFO: renamed from: sse-Q9yt8Vw, reason: not valid java name */
    public static final Object m1632sseQ9yt8Vw(HttpClient httpClient, String str, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation) {
        Object objM1612serverSentEventspTj2aPc = m1612serverSentEventspTj2aPc(httpClient, str, function2, duration, bool, bool2, function1, function3, continuation);
        return objM1612serverSentEventspTj2aPc == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1612serverSentEventspTj2aPc : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-Q9yt8Vw$default, reason: not valid java name */
    public static /* synthetic */ Object m1633sseQ9yt8Vw$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 15);
        }
        return m1632sseQ9yt8Vw(httpClient, str, function1, function2, (i & 8) != 0 ? null : duration, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2, function3, continuation);
    }

    /* JADX INFO: renamed from: sse-mY9Nd3A, reason: not valid java name */
    public static final Object m1634ssemY9Nd3A(HttpClient httpClient, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation) {
        Object objM1610serverSentEventsmY9Nd3A = m1610serverSentEventsmY9Nd3A(httpClient, function1, duration, bool, bool2, function2, continuation);
        return objM1610serverSentEventsmY9Nd3A == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1610serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m1635ssemY9Nd3A$default(HttpClient httpClient, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        return m1634ssemY9Nd3A(httpClient, function1, duration, bool, bool2, function2, continuation);
    }

    /* JADX INFO: renamed from: sse-tL6_L-A, reason: not valid java name */
    public static final Object m1636ssetL6_LA(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation) {
        Object objM1602serverSentEvents1wIb0I = m1602serverSentEvents1wIb0I(httpClient, str, str2, num, str3, duration, bool, bool2, function1, function2, continuation);
        return objM1602serverSentEvents1wIb0I == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1602serverSentEvents1wIb0I : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-tL6_L-A$default, reason: not valid java name */
    public static /* synthetic */ Object m1637ssetL6_LA$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 11);
        }
        if ((i & 32) != 0) {
            duration = null;
        }
        if ((i & 64) != 0) {
            bool = null;
        }
        if ((i & 128) != 0) {
            bool2 = null;
        }
        return m1636ssetL6_LA(httpClient, str, str2, num, str3, function1, duration, bool, bool2, function2, continuation);
    }

    /* JADX INFO: renamed from: sseSession-Mswn-_c, reason: not valid java name */
    public static final Object m1638sseSessionMswn_c(HttpClient httpClient, String str, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1614serverSentEventsSessionMswn_c(httpClient, str, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m1639sseSessionMswn_c$default(HttpClient httpClient, String str, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        if ((i & 32) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 13);
        }
        return m1638sseSessionMswn_c(httpClient, str, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-i8z2VEo, reason: not valid java name */
    public static final Object m1640sseSessioni8z2VEo(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1616serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-i8z2VEo$default, reason: not valid java name */
    public static /* synthetic */ Object m1641sseSessioni8z2VEo$default(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            duration = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            bool2 = null;
        }
        return m1640sseSessioni8z2VEo(httpClient, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A, reason: not valid java name */
    public static final Object m1642sseSessionmY9Nd3A(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1618serverSentEventsSessionmY9Nd3A(httpClient, str, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m1644sseSessionmY9Nd3A$default(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 21);
        }
        return m1642sseSessionmY9Nd3A(httpClient, str, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-tL6_L-A, reason: not valid java name */
    public static final Object m1646sseSessiontL6_LA(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1622serverSentEventsSessiontL6_LA(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-tL6_L-A$default, reason: not valid java name */
    public static /* synthetic */ Object m1647sseSessiontL6_LA$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            duration = null;
        }
        if ((i & 64) != 0) {
            bool = null;
        }
        if ((i & 128) != 0) {
            bool2 = null;
        }
        if ((i & 256) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 19);
        }
        return m1646sseSessiontL6_LA(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-xEWcMm4, reason: not valid java name */
    public static final Object m1648sseSessionxEWcMm4(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1624serverSentEventsSessionxEWcMm4(httpClient, str, str2, num, str3, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-xEWcMm4$default, reason: not valid java name */
    public static /* synthetic */ Object m1649sseSessionxEWcMm4$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            duration = null;
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        if ((i & 64) != 0) {
            bool2 = null;
        }
        if ((i & 128) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 18);
        }
        return m1648sseSessionxEWcMm4(httpClient, str, str2, num, str3, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_Mswn__c$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_mY9Nd3A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_tL6_L_A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_xEWcMm4$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_BAHpl2s$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_Mswn__c$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_Q9yt8Vw$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_tL6_L_A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A, reason: not valid java name */
    public static final Object m1643sseSessionmY9Nd3A(HttpClient httpClient, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1619serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sse-Mswn-_c, reason: not valid java name */
    public static final Object m1629sseMswn_c(HttpClient httpClient, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation) {
        Object objM1608serverSentEventsMswn_c = m1608serverSentEventsMswn_c(httpClient, function1, function2, duration, bool, bool2, function3, continuation);
        return objM1608serverSentEventsMswn_c == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1608serverSentEventsMswn_c : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m1621serverSentEventsSessionmY9Nd3A$default(HttpClient httpClient, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        return m1619serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m1645sseSessionmY9Nd3A$default(HttpClient httpClient, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        return m1643sseSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sse-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m1631sseMswn_c$default(HttpClient httpClient, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        return m1629sseMswn_c(httpClient, function1, function2, duration, bool, bool2, function3, continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A, reason: not valid java name */
    public static final Object m1618serverSentEventsSessionmY9Nd3A(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation) {
        return m1616serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, new BuildersKt$$ExternalSyntheticLambda1((byte) 3, str, function1), continuation);
    }
}
