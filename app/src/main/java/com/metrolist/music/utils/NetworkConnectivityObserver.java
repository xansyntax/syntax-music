package com.metrolist.music.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkConnectivityObserver {
    public final StateFlowImpl _networkStatus;
    public final ConnectivityManager connectivityManager;
    public final NetworkConnectivityObserver$networkCallback$1 networkCallback;
    public final ReadonlyStateFlow networkStatus;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.ConnectivityManager$NetworkCallback, com.metrolist.music.utils.NetworkConnectivityObserver$networkCallback$1] */
    public NetworkConnectivityObserver(Context context) {
        Object systemService = context.getSystemService("connectivity");
        systemService.getClass();
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        this.connectivityManager = connectivityManager;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.valueOf(isCurrentlyConnected()));
        this._networkStatus = stateFlowImplMutableStateFlow;
        this.networkStatus = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        ?? r1 = new ConnectivityManager.NetworkCallback() { // from class: com.metrolist.music.utils.NetworkConnectivityObserver$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                network.getClass();
                NetworkConnectivityObserver networkConnectivityObserver = this.this$0;
                StateFlowImpl stateFlowImpl = networkConnectivityObserver._networkStatus;
                Boolean boolValueOf = Boolean.valueOf(networkConnectivityObserver.isCurrentlyConnected());
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, boolValueOf);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                network.getClass();
                networkCapabilities.getClass();
                NetworkConnectivityObserver networkConnectivityObserver = this.this$0;
                StateFlowImpl stateFlowImpl = networkConnectivityObserver._networkStatus;
                Boolean boolValueOf = Boolean.valueOf(networkConnectivityObserver.isCurrentlyConnected());
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, boolValueOf);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                network.getClass();
                NetworkConnectivityObserver networkConnectivityObserver = this.this$0;
                StateFlowImpl stateFlowImpl = networkConnectivityObserver._networkStatus;
                Boolean boolValueOf = Boolean.valueOf(networkConnectivityObserver.isCurrentlyConnected());
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, boolValueOf);
            }
        };
        this.networkCallback = r1;
        try {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addCapability(13).build(), (ConnectivityManager.NetworkCallback) r1);
        } catch (Exception unused) {
            stateFlowImplMutableStateFlow.updateState(null, Boolean.TRUE);
        }
    }

    public final boolean isCurrentlyConnected() {
        ConnectivityManager connectivityManager = this.connectivityManager;
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return networkCapabilities != null && networkCapabilities.hasCapability(12);
        } catch (Exception unused) {
        }
    }
}
