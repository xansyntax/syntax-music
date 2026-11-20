package com.metrolist.music.discord;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.JsonBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DiscordAuth$Companion$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ DiscordAuth$Companion$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        byte b2 = 1;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                HttpClientConfig httpClientConfig = (HttpClientConfig) obj;
                httpClientConfig.getClass();
                httpClientConfig.install(HttpTimeoutKt.getHttpTimeout(), new DiscordAuth$Companion$$ExternalSyntheticLambda0(b2));
                httpClientConfig.setExpectSuccess(false);
                break;
            case 1:
                HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) obj;
                httpTimeoutConfig.getClass();
                httpTimeoutConfig.setRequestTimeoutMillis(15000L);
                httpTimeoutConfig.setConnectTimeoutMillis(10000L);
                httpTimeoutConfig.setSocketTimeoutMillis(15000L);
                break;
            case 2:
                JsonBuilder jsonBuilder = (JsonBuilder) obj;
                jsonBuilder.getClass();
                jsonBuilder.ignoreUnknownKeys = true;
                break;
            case 3:
                HttpClientConfig httpClientConfig2 = (HttpClientConfig) obj;
                httpClientConfig2.getClass();
                httpClientConfig2.install(HttpTimeoutKt.getHttpTimeout(), new DiscordAuth$Companion$$ExternalSyntheticLambda0((byte) 4));
                httpClientConfig2.setExpectSuccess(false);
                break;
            default:
                HttpTimeoutConfig httpTimeoutConfig2 = (HttpTimeoutConfig) obj;
                httpTimeoutConfig2.getClass();
                httpTimeoutConfig2.setRequestTimeoutMillis(10000L);
                httpTimeoutConfig2.setConnectTimeoutMillis(5000L);
                httpTimeoutConfig2.setSocketTimeoutMillis(10000L);
                break;
        }
        return unit;
    }
}
