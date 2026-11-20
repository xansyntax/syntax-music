package io.ktor.http.cio;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.http.cio.internals.AsciiCharTree;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/ktor/http/cio/ConnectionOptions;", "", "", "close", "keepAlive", "upgrade", "", "", "extraOptions", "<init>", "(ZZZLjava/util/List;)V", "toString", "()Ljava/lang/String;", "buildToString", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Z", "getClose", "()Z", "getKeepAlive", "getUpgrade", "Ljava/util/List;", "getExtraOptions", "()Ljava/util/List;", "Companion", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConnectionOptions {
    private static final ConnectionOptions Close;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConnectionOptions KeepAlive;
    private static final ConnectionOptions Upgrade;
    private static final AsciiCharTree<Pair> knownTypes;
    private final boolean close;
    private final List<String> extraOptions;
    private final boolean keepAlive;
    private final boolean upgrade;

    static {
        boolean z = false;
        ConnectionOptions connectionOptions = new ConnectionOptions(true, z, false, null, 14, null);
        Close = connectionOptions;
        boolean z2 = false;
        ConnectionOptions connectionOptions2 = new ConnectionOptions(z, true, z2, null, 13, null);
        KeepAlive = connectionOptions2;
        ConnectionOptions connectionOptions3 = new ConnectionOptions(false, z2, true, null, 11, null);
        Upgrade = connectionOptions3;
        knownTypes = AsciiCharTree.INSTANCE.build(CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair("close", connectionOptions), new Pair("keep-alive", connectionOptions2), new Pair("upgrade", connectionOptions3)}), new URLUtilsKt$$ExternalSyntheticLambda0((byte) 6), new HttpParserKt$$ExternalSyntheticLambda0((byte) 10));
    }

    public /* synthetic */ ConnectionOptions(boolean z, boolean z2, boolean z3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? EmptyList.INSTANCE : list);
    }

    private final String buildToString() throws IOException {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList(this.extraOptions.size() + 3);
        if (this.close) {
            arrayList.add("close");
        }
        if (this.keepAlive) {
            arrayList.add("keep-alive");
        }
        if (this.upgrade) {
            arrayList.add(HttpHeaders.Upgrade);
        }
        if (!this.extraOptions.isEmpty()) {
            arrayList.addAll(this.extraOptions);
        }
        CollectionsKt.joinTo$default(arrayList, sb, null, null, 126);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int knownTypes$lambda$0(Pair pair) {
        pair.getClass();
        return ((String) pair.first).length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final char knownTypes$lambda$1(Pair pair, int i) {
        pair.getClass();
        return ((String) pair.first).charAt(i);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || ConnectionOptions.class != other.getClass()) {
            return false;
        }
        ConnectionOptions connectionOptions = (ConnectionOptions) other;
        return this.close == connectionOptions.close && this.keepAlive == connectionOptions.keepAlive && this.upgrade == connectionOptions.upgrade && Intrinsics.areEqual(this.extraOptions, connectionOptions.extraOptions);
    }

    public final boolean getClose() {
        return this.close;
    }

    public final List<String> getExtraOptions() {
        return this.extraOptions;
    }

    public final boolean getKeepAlive() {
        return this.keepAlive;
    }

    public final boolean getUpgrade() {
        return this.upgrade;
    }

    public int hashCode() {
        return this.extraOptions.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Boolean.hashCode(this.close) * 31, this.keepAlive, 31), this.upgrade, 31);
    }

    public String toString() {
        if (!this.extraOptions.isEmpty()) {
            return buildToString();
        }
        boolean z = this.close;
        if (z && !this.keepAlive && !this.upgrade) {
            return "close";
        }
        if (z || !this.keepAlive || this.upgrade) {
            return (!z && this.keepAlive && this.upgrade) ? "keep-alive, Upgrade" : buildToString();
        }
        return "keep-alive";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bR\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR&\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/http/cio/ConnectionOptions$Companion;", "", "<init>", "()V", "", "connection", "Lio/ktor/http/cio/ConnectionOptions;", "parse", "(Ljava/lang/CharSequence;)Lio/ktor/http/cio/ConnectionOptions;", "parseSlow", "Close", "Lio/ktor/http/cio/ConnectionOptions;", "getClose", "()Lio/ktor/http/cio/ConnectionOptions;", "KeepAlive", "getKeepAlive", HttpHeaders.Upgrade, "getUpgrade", "Lio/ktor/http/cio/internals/AsciiCharTree;", "Lkotlin/Pair;", "", "knownTypes", "Lio/ktor/http/cio/internals/AsciiCharTree;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean parse$lambda$0(char c, int i) {
            return false;
        }

        private final ConnectionOptions parseSlow(CharSequence connection) {
            int length = connection.length();
            ConnectionOptions keepAlive = null;
            ArrayList arrayList = null;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                while (true) {
                    char cCharAt = connection.charAt(i);
                    if (cCharAt != ' ' && cCharAt != ',') {
                        i2 = i;
                        i = i2;
                        break;
                    }
                    i++;
                    if (i >= length) {
                        i = i;
                        break;
                    }
                }
                while (i < length) {
                    char cCharAt2 = connection.charAt(i);
                    if (cCharAt2 == ' ' || cCharAt2 == ',') {
                        break;
                    }
                    i++;
                }
                Pair pair = (Pair) CollectionsKt.singleOrNull(ConnectionOptions.knownTypes.search(connection, i2, i, true, new HttpParserKt$$ExternalSyntheticLambda0((byte) 11)));
                if (pair == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(connection.subSequence(i2, i).toString());
                } else {
                    Object obj = pair.second;
                    if (keepAlive == null) {
                        keepAlive = (ConnectionOptions) obj;
                    } else {
                        boolean z = true;
                        boolean z2 = keepAlive.getClose() || ((ConnectionOptions) obj).getClose();
                        boolean z3 = keepAlive.getKeepAlive() || ((ConnectionOptions) obj).getKeepAlive();
                        if (!keepAlive.getUpgrade() && !((ConnectionOptions) obj).getUpgrade()) {
                            z = false;
                        }
                        keepAlive = new ConnectionOptions(z2, z3, z, EmptyList.INSTANCE);
                    }
                }
            }
            if (keepAlive == null) {
                keepAlive = getKeepAlive();
            }
            return arrayList == null ? keepAlive : new ConnectionOptions(keepAlive.getClose(), keepAlive.getKeepAlive(), keepAlive.getUpgrade(), arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean parseSlow$lambda$0(char c, int i) {
            return false;
        }

        public final ConnectionOptions getClose() {
            return ConnectionOptions.Close;
        }

        public final ConnectionOptions getKeepAlive() {
            return ConnectionOptions.KeepAlive;
        }

        public final ConnectionOptions getUpgrade() {
            return ConnectionOptions.Upgrade;
        }

        public final ConnectionOptions parse(CharSequence connection) {
            if (connection == null) {
                return null;
            }
            List listSearch$default = AsciiCharTree.search$default(ConnectionOptions.knownTypes, connection, 0, 0, true, new HttpParserKt$$ExternalSyntheticLambda0((byte) 12), 6, null);
            return listSearch$default.size() == 1 ? (ConnectionOptions) ((Pair) listSearch$default.get(0)).second : parseSlow(connection);
        }

        private Companion() {
        }
    }

    public ConnectionOptions(boolean z, boolean z2, boolean z3, List<String> list) {
        list.getClass();
        this.close = z;
        this.keepAlive = z2;
        this.upgrade = z3;
        this.extraOptions = list;
    }

    public ConnectionOptions() {
        this(false, false, false, null, 15, null);
    }
}
