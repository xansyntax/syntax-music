package com.metrolist.music;

import androidx.media3.extractor.flv.TagPayloadReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity$WidgetTargetRoute$LikedSongs extends TagPayloadReader {
    public static final MainActivity$WidgetTargetRoute$LikedSongs INSTANCE = new MainActivity$WidgetTargetRoute$LikedSongs("auto_playlist/liked");

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof MainActivity$WidgetTargetRoute$LikedSongs);
    }

    public final int hashCode() {
        return 1196825892;
    }

    public final String toString() {
        return "LikedSongs";
    }
}
