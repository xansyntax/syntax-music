package timber.log;

import java.util.ArrayList;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Timber {
    public static final ConnectionPool Forest = new ConnectionPool((byte) 26);
    public static volatile ConnectionPool[] treeArray;

    static {
        new ArrayList();
        treeArray = new ConnectionPool[0];
    }
}
