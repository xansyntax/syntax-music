package okhttp3.internal.dns;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt;
import okhttp3.Dns;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class InetAddressDns implements Dns {
    public static final InetAddressDns INSTANCE = new InetAddressDns();

    @Override // okhttp3.Dns
    public final List lookup(String str) throws UnknownHostException {
        str.getClass();
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            allByName.getClass();
            return ArraysKt.toList(allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(str));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
