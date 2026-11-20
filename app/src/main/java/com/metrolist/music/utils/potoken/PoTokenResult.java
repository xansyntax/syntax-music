package com.metrolist.music.utils.potoken;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/metrolist/music/utils/potoken/PoTokenResult;", "", "playerRequestPoToken", "", "streamingDataPoToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPlayerRequestPoToken", "()Ljava/lang/String;", "getStreamingDataPoToken", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PoTokenResult {
    public static final int $stable = 0;
    private final String playerRequestPoToken;
    private final String streamingDataPoToken;

    public PoTokenResult(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.playerRequestPoToken = str;
        this.streamingDataPoToken = str2;
    }

    public final String getPlayerRequestPoToken() {
        return this.playerRequestPoToken;
    }

    public final String getStreamingDataPoToken() {
        return this.streamingDataPoToken;
    }
}
