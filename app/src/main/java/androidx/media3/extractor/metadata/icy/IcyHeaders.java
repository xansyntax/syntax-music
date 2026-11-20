package androidx.media3.extractor.metadata.icy;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Log;
import coil3.util.UtilsKt;
import io.ktor.client.utils.CIOKt;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IcyHeaders implements Metadata.Entry {
    public final int bitrate;
    public final String genre;
    public final boolean isPublic;
    public final int metadataInterval;
    public final String name;
    public final String url;

    public IcyHeaders(int i, int i2, String str, String str2, String str3, boolean z) {
        UtilsKt.checkArgument(i2 == -1 || i2 > 0);
        this.bitrate = i;
        this.genre = str;
        this.name = str2;
        this.url = str3;
        this.isPublic = z;
        this.metadataInterval = i2;
    }

    public static IcyHeaders parse(Map map) {
        boolean z;
        int i;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i2;
        List list = (List) map.get("icy-br");
        boolean z2 = true;
        int i3 = -1;
        if (list != null) {
            String str4 = (String) list.get(0);
            try {
                i2 = Integer.parseInt(str4) * CIOKt.DEFAULT_HTTP_POOL_SIZE;
                if (i2 > 0) {
                    z = true;
                } else {
                    try {
                        Log.w("IcyHeaders", "Invalid bitrate: " + str4);
                        z = false;
                        i2 = -1;
                    } catch (NumberFormatException unused) {
                        Format$$ExternalSyntheticOutline0.m("Invalid bitrate header: ", str4, "IcyHeaders");
                        z = false;
                    }
                }
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
            i = i2;
        } else {
            z = false;
            i = -1;
        }
        List list2 = (List) map.get("icy-genre");
        if (list2 != null) {
            str = (String) list2.get(0);
            z = true;
        } else {
            str = null;
        }
        List list3 = (List) map.get("icy-name");
        if (list3 != null) {
            str2 = (String) list3.get(0);
            z = true;
        } else {
            str2 = null;
        }
        List list4 = (List) map.get("icy-url");
        if (list4 != null) {
            str3 = (String) list4.get(0);
            z = true;
        } else {
            str3 = null;
        }
        List list5 = (List) map.get("icy-pub");
        if (list5 != null) {
            zEquals = ((String) list5.get(0)).equals("1");
            z = true;
        } else {
            zEquals = false;
        }
        List list6 = (List) map.get("icy-metaint");
        if (list6 != null) {
            String str5 = (String) list6.get(0);
            try {
                int i4 = Integer.parseInt(str5);
                if (i4 > 0) {
                    i3 = i4;
                } else {
                    try {
                        Log.w("IcyHeaders", "Invalid metadata interval: " + str5);
                        z2 = z;
                    } catch (NumberFormatException unused3) {
                        i3 = i4;
                        Format$$ExternalSyntheticOutline0.m("Invalid metadata interval: ", str5, "IcyHeaders");
                    }
                }
                z = z2;
            } catch (NumberFormatException unused4) {
            }
        }
        int i5 = i3;
        if (z) {
            return new IcyHeaders(i, i5, str, str2, str3, zEquals);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && IcyHeaders.class == obj.getClass()) {
            IcyHeaders icyHeaders = (IcyHeaders) obj;
            if (this.bitrate == icyHeaders.bitrate && Objects.equals(this.genre, icyHeaders.genre) && Objects.equals(this.name, icyHeaders.name) && Objects.equals(this.url, icyHeaders.url) && this.isPublic == icyHeaders.isPublic && this.metadataInterval == icyHeaders.metadataInterval) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (527 + this.bitrate) * 31;
        String str = this.genre;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.isPublic ? 1 : 0)) * 31) + this.metadataInterval;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.name;
        if (str != null) {
            builder.station = str;
        }
        String str2 = this.genre;
        if (str2 != null) {
            builder.genre = str2;
        }
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.name + "\", genre=\"" + this.genre + "\", bitrate=" + this.bitrate + ", metadataInterval=" + this.metadataInterval;
    }
}
