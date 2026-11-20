package io.ktor.client;

import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import io.ktor.client.engine.HttpClientEngineFactory;
import java.util.Iterator;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a'\u0010\u0005\u001a\u00020\u00042\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"%\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00078BX\u0082\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "", "block", "Lio/ktor/client/HttpClient;", "HttpClient", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "Lio/ktor/client/engine/HttpClientEngineFactory;", "FACTORY$delegate", "Lkotlin/Lazy;", "getFACTORY", "()Lio/ktor/client/engine/HttpClientEngineFactory;", "getFACTORY$annotations", "()V", "FACTORY", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpClientJvmKt {
    private static final Lazy FACTORY$delegate = new SynchronizedLazyImpl(new Shazam$$ExternalSyntheticLambda0(22));

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpClientEngineFactory FACTORY_delegate$lambda$0() {
        Iterator it = ServiceLoader.load(HttpClientEngineContainer.class, HttpClientEngineContainer.class.getClassLoader()).iterator();
        it.getClass();
        return HttpClientEngineContainerKt.selectDefaultHttpClientEngine(SequencesKt.toList(SequencesKt.asSequence(it)));
    }

    public static final HttpClient HttpClient(Function1 function1) {
        function1.getClass();
        return HttpClientKt.HttpClient(getFACTORY(), function1);
    }

    public static /* synthetic */ HttpClient HttpClient$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new HttpClient$$ExternalSyntheticLambda1((byte) 23);
        }
        return HttpClient(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpClient$lambda$0(HttpClientConfig httpClientConfig) {
        httpClientConfig.getClass();
        return Unit.INSTANCE;
    }

    private static final HttpClientEngineFactory<?> getFACTORY() {
        return (HttpClientEngineFactory) FACTORY$delegate.getValue();
    }

    private static /* synthetic */ void getFACTORY$annotations() {
    }
}
