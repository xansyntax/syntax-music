package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.http.ContentDisposition;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a!\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0018\u0010\u000b\u001a\u00020\u0006*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"", "Lio/ktor/client/HttpClientEngineContainer;", "engineContainers", "Lio/ktor/client/engine/HttpClientEngineFactory;", "selectDefaultHttpClientEngine", "(Ljava/util/List;)Lio/ktor/client/engine/HttpClientEngineFactory;", "", "NO_ENGINE_MESSAGE", "Ljava/lang/String;", "getName", "(Lio/ktor/client/HttpClientEngineContainer;)Ljava/lang/String;", ContentDisposition.Parameters.Name, "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpClientEngineContainerKt {
    private static final String NO_ENGINE_MESSAGE = "Failed to find HTTP client engine implementation: consider adding client engine dependency. See https://ktor.io/docs/http-client-engines.html";

    private static final String getName(HttpClientEngineContainer httpClientEngineContainer) {
        String simpleName = Reflection.getOrCreateKotlinClass(httpClientEngineContainer.getFactory().getClass()).getSimpleName();
        return simpleName == null ? httpClientEngineContainer.getFactory().toString() : simpleName;
    }

    public static final HttpClientEngineFactory<?> selectDefaultHttpClientEngine(List<? extends HttpClientEngineContainer> list) {
        list.getClass();
        int size = list.size();
        if (size == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(NO_ENGINE_MESSAGE);
            return null;
        }
        if (size == 1) {
            return ((HttpClientEngineContainer) CollectionsKt.single((List) list)).getFactory();
        }
        List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: io.ktor.client.HttpClientEngineContainerKt$selectDefaultHttpClientEngine$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return Double.valueOf(((HttpClientEngineContainer) t2).getPriority()).compareTo(Double.valueOf(((HttpClientEngineContainer) t).getPriority()));
            }
        });
        double priority = ((HttpClientEngineContainer) CollectionsKt.first(listSortedWith)).getPriority();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSortedWith) {
            if (Double.compare(((HttpClientEngineContainer) obj).getPriority(), priority) != 0) {
                break;
            }
            arrayList.add(obj);
        }
        HttpClientEngineContainer httpClientEngineContainer = (HttpClientEngineContainer) CollectionsKt.first((List) arrayList);
        Logger loggerKtorSimpleLogger = KtorSimpleLoggerJvmKt.KtorSimpleLogger("HttpClient");
        if (arrayList.size() > 1) {
            StringBuilder sb = new StringBuilder("Multiple engines found: ");
            sb.append(CollectionsKt.joinToString$default(arrayList, null, null, null, new HttpClient$$ExternalSyntheticLambda1((byte) 21), 31));
            sb.append('\n');
            sb.append("\tUsing the first: " + getName(httpClientEngineContainer));
            sb.append('\n');
            loggerKtorSimpleLogger.warn(sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder("Multiple engines found: ");
            sb2.append(CollectionsKt.joinToString$default(list, null, null, null, new HttpClient$$ExternalSyntheticLambda1((byte) 22), 31));
            sb2.append('\n');
            sb2.append("\tUsing the engine with the highest priority: " + getName(httpClientEngineContainer) + " (priority: " + priority + ')');
            sb2.append('\n');
            loggerKtorSimpleLogger.info(sb2.toString());
        }
        return httpClientEngineContainer.getFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence selectDefaultHttpClientEngine$lambda$2$0(HttpClientEngineContainer httpClientEngineContainer) {
        httpClientEngineContainer.getClass();
        return getName(httpClientEngineContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence selectDefaultHttpClientEngine$lambda$3$0(HttpClientEngineContainer httpClientEngineContainer) {
        httpClientEngineContainer.getClass();
        return getName(httpClientEngineContainer);
    }
}
