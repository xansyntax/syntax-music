package io.ktor.client.plugins.api;

import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"", "PluginConfigT", "", ContentDisposition.Parameters.Name, "Lkotlin/Function0;", "createConfiguration", "Lkotlin/Function1;", "Lio/ktor/client/plugins/api/ClientPluginBuilder;", "", "body", "Lio/ktor/client/plugins/api/ClientPlugin;", "createClientPlugin", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/api/ClientPlugin;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CreatePluginUtilsKt {
    public static final ClientPlugin<Unit> createClientPlugin(String str, Function1 function1) {
        str.getClass();
        function1.getClass();
        return createClientPlugin(str, new Shazam$$ExternalSyntheticLambda0((byte) 26), function1);
    }

    public static final <PluginConfigT> ClientPlugin<PluginConfigT> createClientPlugin(String str, Function0 function0, Function1 function1) {
        str.getClass();
        function0.getClass();
        function1.getClass();
        return new ClientPluginImpl(str, function0, function1);
    }
}
