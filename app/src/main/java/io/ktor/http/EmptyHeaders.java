package io.ktor.http;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\f0\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0015"}, d2 = {"Lio/ktor/http/EmptyHeaders;", "Lio/ktor/http/Headers;", "<init>", "()V", "", ContentDisposition.Parameters.Name, "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "names", "()Ljava/util/Set;", "", "entries", "", "isEmpty", "()Z", "toString", "()Ljava/lang/String;", "getCaseInsensitiveName", "caseInsensitiveName", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class EmptyHeaders implements Headers {
    public static final EmptyHeaders INSTANCE = new EmptyHeaders();

    private EmptyHeaders() {
    }

    @Override // io.ktor.util.StringValues
    public /* bridge */ boolean contains(String str) {
        return super.contains(str);
    }

    @Override // io.ktor.util.StringValues
    public Set<Map.Entry<String, List<String>>> entries() {
        return EmptySet.INSTANCE;
    }

    @Override // io.ktor.util.StringValues
    public /* bridge */ void forEach(Function2 function2) {
        super.forEach(function2);
    }

    @Override // io.ktor.util.StringValues
    public /* bridge */ String get(String str) {
        return super.get(str);
    }

    @Override // io.ktor.util.StringValues
    public List<String> getAll(String name) {
        name.getClass();
        return null;
    }

    @Override // io.ktor.util.StringValues
    public boolean getCaseInsensitiveName() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public Set<String> names() {
        return EmptySet.INSTANCE;
    }

    public String toString() {
        return "Headers " + entries();
    }

    @Override // io.ktor.util.StringValues
    public /* bridge */ boolean contains(String str, String str2) {
        return super.contains(str, str2);
    }
}
