package com.metrolist.innertubex;

import io.ktor.http.HttpStatusCode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTubeHttpException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTubeHttpException(String str, HttpStatusCode httpStatusCode) {
        super(str + " failed with HTTP " + httpStatusCode.getValue());
        str.getClass();
        httpStatusCode.getClass();
    }
}
