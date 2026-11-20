package okhttp3.internal.ech;

import kotlin.text.Regex;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class EchRetryPlan {
    public static final Regex INVALID_PUBLIC_NAME = new Regex("(\\..*)|(.*\\.)|((.*\\.)?[0-9]+)|((.*\\.)?0[xX][0-9a-fA-F]*)");
    public final ByteString configList;
    public final String publicName;

    public EchRetryPlan(String str, ByteString byteString) {
        this.publicName = str;
        this.configList = byteString;
    }
}
