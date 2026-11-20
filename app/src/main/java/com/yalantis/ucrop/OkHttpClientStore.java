package com.yalantis.ucrop;

import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class OkHttpClientStore {
    public static final OkHttpClientStore INSTANCE = new OkHttpClientStore();
    private OkHttpClient client;

    private OkHttpClientStore() {
    }

    public OkHttpClient getClient() {
        OkHttpClient okHttpClient = this.client;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        OkHttpClient okHttpClient2 = new OkHttpClient();
        this.client = okHttpClient2;
        return okHttpClient2;
    }

    public void setClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }
}
