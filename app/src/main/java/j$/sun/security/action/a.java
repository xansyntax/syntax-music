package j$.sun.security.action;

import java.security.PrivilegedAction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements PrivilegedAction {
    @Override // java.security.PrivilegedAction
    public final Object run() {
        String property = System.getProperty("file.encoding");
        if (property == null) {
            return null;
        }
        return property;
    }
}
