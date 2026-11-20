package coil3.intercept;

import coil3.EventListener$Companion$NONE$1;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.NullRequestData;
import coil3.size.Size;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RealInterceptorChain {
    public final Object eventListener;
    public int index;
    public final Object initialRequest;
    public final List interceptors;
    public final boolean isPlaceholderCached;
    public final Object request;
    public final Object size;

    /* JADX INFO: renamed from: coil3.intercept.RealInterceptorChain$proceed$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public EngineInterceptor L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealInterceptorChain.this.proceed(this);
        }
    }

    public RealInterceptorChain(Address address, ConnectionPool connectionPool, RealCall realCall, boolean z) {
        List<Proxy> listSelect;
        List immutableList;
        connectionPool.getClass();
        this.initialRequest = address;
        this.request = connectionPool;
        this.size = realCall;
        this.isPlaceholderCached = z;
        this.interceptors = EmptyList.INSTANCE;
        this.eventListener = new ArrayList();
        HttpUrl httpUrl = address.url;
        Proxy proxy = address.proxy;
        realCall.eventListener.getClass();
        if (proxy != null) {
            immutableList = CollectionsKt__IterablesKt.listOf(proxy);
        } else {
            URI uri = httpUrl.uri();
            if (uri.getHost() == null) {
                immutableList = _UtilJvmKt.toImmutableList(new Proxy[]{Proxy.NO_PROXY});
            } else {
                try {
                    listSelect = address.proxySelector.select(uri);
                } catch (IllegalArgumentException unused) {
                    listSelect = null;
                }
                immutableList = (listSelect == null || listSelect.isEmpty()) ? _UtilJvmKt.toImmutableList(new Proxy[]{Proxy.NO_PROXY}) : _UtilJvmKt.toImmutableList(listSelect);
            }
        }
        this.interceptors = immutableList;
        this.index = 0;
        EventListener eventListener = ((RealCall) this.size).eventListener;
        List list = this.interceptors;
        eventListener.getClass();
        list.getClass();
    }

    public boolean hasNext() {
        return this.index < this.interceptors.size() || !((ArrayList) this.eventListener).isEmpty();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    public Object proceed(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        EngineInterceptor engineInterceptor;
        ImageRequest imageRequest = (ImageRequest) this.initialRequest;
        int i = this.index;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objIntercept = anonymousClass2.result;
        int i3 = anonymousClass2.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objIntercept);
            EngineInterceptor engineInterceptor2 = (EngineInterceptor) this.interceptors.get(i);
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(imageRequest, this.interceptors, i + 1, (ImageRequest) this.request, (Size) this.size, (EventListener$Companion$NONE$1) this.eventListener, this.isPlaceholderCached);
            anonymousClass2.L$0 = engineInterceptor2;
            anonymousClass2.label = 1;
            objIntercept = engineInterceptor2.intercept(realInterceptorChain, anonymousClass2);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objIntercept == coroutineSingletons) {
                return coroutineSingletons;
            }
            engineInterceptor = engineInterceptor2;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            engineInterceptor = anonymousClass2.L$0;
            ResultKt.throwOnFailure(objIntercept);
        }
        ImageResult imageResult = (ImageResult) objIntercept;
        ImageRequest request = imageResult.getRequest();
        if (request.context != imageRequest.context) {
            PathKt$$ExternalSyntheticBUOutline0.m("Interceptor '", engineInterceptor, "' cannot modify the request's context.");
            return null;
        }
        if (request.data == NullRequestData.INSTANCE) {
            PathKt$$ExternalSyntheticBUOutline0.m("Interceptor '", engineInterceptor, "' cannot set the request's data to null.");
            return null;
        }
        if (request.target != imageRequest.target) {
            PathKt$$ExternalSyntheticBUOutline0.m("Interceptor '", engineInterceptor, "' cannot modify the request's target.");
            return null;
        }
        if (request.sizeResolver == imageRequest.sizeResolver) {
            return imageResult;
        }
        PathKt$$ExternalSyntheticBUOutline0.m("Interceptor '", engineInterceptor, "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.");
        return null;
    }

    public RealInterceptorChain(ImageRequest imageRequest, List list, int i, ImageRequest imageRequest2, Size size, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1, boolean z) {
        this.initialRequest = imageRequest;
        this.interceptors = list;
        this.index = i;
        this.request = imageRequest2;
        this.size = size;
        this.eventListener = eventListener$Companion$NONE$1;
        this.isPlaceholderCached = z;
    }
}
