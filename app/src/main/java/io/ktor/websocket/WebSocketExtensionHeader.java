package io.ktor.websocket;

import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.TransformingSequence;
import kotlin.text.StringsKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionHeader;", "", "", ContentDisposition.Parameters.Name, "", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "parseParameters", "()Lkotlin/sequences/Sequence;", "toString", "()Ljava/lang/String;", "parametersToString", "Ljava/lang/String;", "getName", "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebSocketExtensionHeader {
    private final String name;
    private final List<String> parameters;

    public WebSocketExtensionHeader(String str, List<String> list) {
        str.getClass();
        list.getClass();
        this.name = str;
        this.parameters = list;
    }

    private final String parametersToString() {
        return this.parameters.isEmpty() ? "" : "; ".concat(CollectionsKt.joinToString$default(this.parameters, ";", null, null, null, 62));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair parseParameters$lambda$0(String str) {
        str.getClass();
        int iIndexOf$default = StringsKt.indexOf$default(str, '=', 0, 6);
        if (iIndexOf$default < 0) {
            return new Pair(str, "");
        }
        String strSubstring = StringsKt.substring(str, UuidKt.until(0, iIndexOf$default));
        int i = iIndexOf$default + 1;
        return new Pair(strSubstring, i < str.length() ? str.substring(i) : "");
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getParameters() {
        return this.parameters;
    }

    public final Sequence parseParameters() {
        return new TransformingSequence(CollectionsKt.asSequence(this.parameters), new InstantKt$$ExternalSyntheticLambda0((byte) 14));
    }

    public String toString() {
        return this.name + ' ' + parametersToString();
    }
}
