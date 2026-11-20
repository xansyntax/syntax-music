package okhttp3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface Authenticator {
    public static final Protocol.Companion NONE = new Protocol.Companion();

    Request authenticate(Route route, Response response);
}
