package coil3.network;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectivityCheckerApi23 implements ConnectivityChecker {
    public final ConnectivityManager connectivityManager;

    public ConnectivityCheckerApi23(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override // coil3.network.ConnectivityChecker
    public final boolean isOnline() {
        ConnectivityManager connectivityManager = this.connectivityManager;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }
}
