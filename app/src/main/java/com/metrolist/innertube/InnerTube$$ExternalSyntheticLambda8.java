package com.metrolist.innertube;

import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionStub;
import io.ktor.http.HttpHeaders;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InnerTube$$ExternalSyntheticLambda8 implements MediaSessionStub.SessionTask, Authenticator {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ InnerTube$$ExternalSyntheticLambda8(String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        Request.Builder builderNewBuilder = response.request.newBuilder();
        builderNewBuilder.header(HttpHeaders.ProxyAuthorization, this.f$0);
        return new Request(builderNewBuilder);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        byte b = this.$r8$classId;
        String str = this.f$0;
        switch (b) {
            case 1:
                return mediaLibrarySessionImpl.onUnsubscribeOnHandler(mediaSession$ControllerInfo, str);
            default:
                return mediaLibrarySessionImpl.onGetItemOnHandler(mediaSession$ControllerInfo, str);
        }
    }
}
