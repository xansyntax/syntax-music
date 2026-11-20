package coil3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Uri {
    public final String authority;
    public final String data;
    public final String path;
    public final String scheme;
    public final String separator;

    public Uri(String str, String str2, String str3, String str4, String str5) {
        this.data = str;
        this.separator = str2;
        this.scheme = str3;
        this.authority = str4;
        this.path = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Uri) && ((Uri) obj).data.equals(this.data);
    }

    public final int hashCode() {
        return this.data.hashCode();
    }

    public final String toString() {
        return this.data;
    }
}
