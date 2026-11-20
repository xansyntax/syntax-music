package io.ktor.client.plugins.cookies;

import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import io.ktor.http.Cookie;
import io.ktor.http.Url;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u0003*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/Function0;", "", "clock", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lio/ktor/http/Url;", "requestUrl", "", "Lio/ktor/http/Cookie;", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cookie", "", "addCookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "()V", "timestamp", "cleanup", "(J)V", "createdAt", "maxAgeOrExpires", "(Lio/ktor/http/Cookie;J)Ljava/lang/Long;", "Lkotlin/jvm/functions/Function0;", "", "Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "container", "Ljava/util/List;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "CookieWithTimestamp", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AcceptAllCookiesStorage implements CookiesStorage {
    private final Function0 clock;
    private final List<CookieWithTimestamp> container;
    private final Mutex mutex;
    private volatile /* synthetic */ long oldestCookie;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u00020\u0015HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "", "Lio/ktor/http/Cookie;", "cookie", "", "createdAt", "<init>", "(Lio/ktor/http/Cookie;J)V", "component1", "()Lio/ktor/http/Cookie;", "component2", "()J", "copy", "(Lio/ktor/http/Cookie;J)Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/ktor/http/Cookie;", "getCookie", "J", "getCreatedAt", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class CookieWithTimestamp {
        private final Cookie cookie;
        private final long createdAt;

        public CookieWithTimestamp(Cookie cookie, long j) {
            cookie.getClass();
            this.cookie = cookie;
            this.createdAt = j;
        }

        public static /* synthetic */ CookieWithTimestamp copy$default(CookieWithTimestamp cookieWithTimestamp, Cookie cookie, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                cookie = cookieWithTimestamp.cookie;
            }
            if ((i & 2) != 0) {
                j = cookieWithTimestamp.createdAt;
            }
            return cookieWithTimestamp.copy(cookie, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Cookie getCookie() {
            return this.cookie;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final CookieWithTimestamp copy(Cookie cookie, long createdAt) {
            cookie.getClass();
            return new CookieWithTimestamp(cookie, createdAt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CookieWithTimestamp)) {
                return false;
            }
            CookieWithTimestamp cookieWithTimestamp = (CookieWithTimestamp) other;
            return Intrinsics.areEqual(this.cookie, cookieWithTimestamp.cookie) && this.createdAt == cookieWithTimestamp.createdAt;
        }

        public final Cookie getCookie() {
            return this.cookie;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        public int hashCode() {
            return Long.hashCode(this.createdAt) + (this.cookie.hashCode() * 31);
        }

        public String toString() {
            return "CookieWithTimestamp(cookie=" + this.cookie + ", createdAt=" + this.createdAt + ')';
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", l = {78}, m = "addCookie", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AcceptAllCookiesStorage.this.addCookie(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", l = {78}, m = "get", v = 1)
    public static final class C02531 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02531(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AcceptAllCookiesStorage.this.get(null, this);
        }
    }

    public AcceptAllCookiesStorage(Function0 function0) {
        function0.getClass();
        this.clock = function0;
        this.container = new ArrayList();
        this.oldestCookie = 0L;
        this.mutex = new MutexImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addCookie$lambda$1$0(Cookie cookie, Url url, CookieWithTimestamp cookieWithTimestamp) {
        cookieWithTimestamp.getClass();
        Cookie cookie2 = cookieWithTimestamp.getCookie();
        return Intrinsics.areEqual(cookie2.getName(), cookie.getName()) && CookiesStorageKt.matches(cookie2, url);
    }

    private final void cleanup(final long timestamp) {
        CollectionsKt__MutableCollectionsKt.removeAll(this.container, new Function1() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AcceptAllCookiesStorage.cleanup$lambda$0(this.f$0, timestamp, (AcceptAllCookiesStorage.CookieWithTimestamp) obj));
            }
        });
        long jMin = Long.MAX_VALUE;
        for (CookieWithTimestamp cookieWithTimestamp : this.container) {
            Long lMaxAgeOrExpires = maxAgeOrExpires(cookieWithTimestamp.getCookie(), cookieWithTimestamp.getCreatedAt());
            if (lMaxAgeOrExpires != null) {
                jMin = Math.min(jMin, lMaxAgeOrExpires.longValue());
            }
        }
        this.oldestCookie = jMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanup$lambda$0(AcceptAllCookiesStorage acceptAllCookiesStorage, long j, CookieWithTimestamp cookieWithTimestamp) {
        cookieWithTimestamp.getClass();
        Long lMaxAgeOrExpires = acceptAllCookiesStorage.maxAgeOrExpires(cookieWithTimestamp.getCookie(), cookieWithTimestamp.getCreatedAt());
        return lMaxAgeOrExpires != null && lMaxAgeOrExpires.longValue() < j;
    }

    private final Long maxAgeOrExpires(Cookie cookie, long j) {
        long timestamp;
        Integer maxAgeInt = cookie.getMaxAgeInt();
        if (maxAgeInt != null) {
            timestamp = (((long) maxAgeInt.intValue()) * 1000) + j;
        } else {
            GMTDate expires = cookie.getExpires();
            if (expires == null) {
                return null;
            }
            timestamp = expires.getTimestamp();
        }
        return Long.valueOf(timestamp);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    public Object addCookie(final Url url, final Cookie cookie, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        Unit unit = Unit.INSTANCE;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (StringsKt.isBlank(cookie.getName())) {
                return unit;
            }
            mutex = this.mutex;
            anonymousClass1.L$0 = url;
            anonymousClass1.L$1 = cookie;
            anonymousClass1.L$2 = mutex;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            if (mutex.lock(anonymousClass1) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Mutex mutex2 = (Mutex) anonymousClass1.L$2;
            cookie = (Cookie) anonymousClass1.L$1;
            Url url2 = (Url) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            url = url2;
        }
        try {
            CollectionsKt__MutableCollectionsKt.removeAll(this.container, new Function1() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(AcceptAllCookiesStorage.addCookie$lambda$1$0(cookie, url, (AcceptAllCookiesStorage.CookieWithTimestamp) obj2));
                }
            });
            long jLongValue = ((Number) this.clock.invoke()).longValue();
            this.container.add(new CookieWithTimestamp(CookiesStorageKt.fillDefaults(cookie, url), jLongValue));
            Long lMaxAgeOrExpires = maxAgeOrExpires(cookie, jLongValue);
            if (lMaxAgeOrExpires != null) {
                long jLongValue2 = lMaxAgeOrExpires.longValue();
                if (this.oldestCookie > jLongValue2) {
                    this.oldestCookie = jLongValue2;
                }
            }
            return unit;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    public Object get(Url url, Continuation continuation) {
        C02531 c02531;
        Mutex mutex;
        if (continuation instanceof C02531) {
            c02531 = (C02531) continuation;
            int i = c02531.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02531.label = i - Integer.MIN_VALUE;
            } else {
                c02531 = new C02531(continuation);
            }
        } else {
            c02531 = new C02531(continuation);
        }
        Object obj = c02531.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c02531.label;
        int i3 = 0;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c02531.L$0 = url;
            c02531.L$1 = mutex;
            c02531.I$0 = 0;
            c02531.label = 1;
            if (mutex.lock(c02531) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Mutex mutex2 = (Mutex) c02531.L$1;
            Url url2 = (Url) c02531.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            url = url2;
        }
        try {
            long jLongValue = ((Number) this.clock.invoke()).longValue();
            if (jLongValue >= this.oldestCookie) {
                cleanup(jLongValue);
            }
            List<CookieWithTimestamp> list = this.container;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (CookiesStorageKt.matches(((CookieWithTimestamp) obj2).getCookie(), url)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            int size = arrayList.size();
            while (i3 < size) {
                Object obj3 = arrayList.get(i3);
                i3++;
                arrayList2.add(((CookieWithTimestamp) obj3).getCookie());
            }
            return arrayList2;
        } finally {
            mutex.unlock(null);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AcceptAllCookiesStorage() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ AcceptAllCookiesStorage(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Shazam$$ExternalSyntheticLambda0((byte) 28) : function0);
    }
}
