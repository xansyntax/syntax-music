package com.metrolist.music.discord;

import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DiscordExternalAssets$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return HttpClientKt.HttpClient(OkHttp.INSTANCE, new DiscordAuth$Companion$$ExternalSyntheticLambda0((byte) 3));
            default:
                DiscordExternalAssets.ExternalAssetRequest.Companion companion = DiscordExternalAssets.ExternalAssetRequest.Companion;
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
        }
    }
}
