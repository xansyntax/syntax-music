package com.metrolist.music.discord;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.media3.decoder.DecoderException;
import kotlinx.coroutines.CompletableDeferredImpl;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordOAuthActivity extends Activity {
    public static volatile CompletableDeferredImpl deferred;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Uri data;
        super.onCreate(bundle);
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("DiscordSvc");
        Intent intent = getIntent();
        ConnectionPool.i(intent != null ? intent.getAction() : null);
        Intent intent2 = getIntent();
        if (intent2 == null || (data = intent2.getData()) == null) {
            connectionPool.tag("DiscordSvc");
            ConnectionPool.w(new Object[0]);
            finish();
            return;
        }
        String queryParameter = data.getQueryParameter("code");
        String queryParameter2 = data.getQueryParameter("state");
        String queryParameter3 = data.getQueryParameter("error");
        if (queryParameter3 != null) {
            connectionPool.tag("DiscordSvc");
            ConnectionPool.w(queryParameter3);
            CompletableDeferredImpl completableDeferredImpl = deferred;
            if (completableDeferredImpl != null) {
                completableDeferredImpl.completeExceptionally(new DecoderException("Authorization denied: ".concat(queryParameter3), null) { // from class: com.metrolist.music.discord.DiscordAuthException$UserCancelled
                    {
                        super("User cancelled authorization", null);
                    }
                });
            }
            finish();
            return;
        }
        if (queryParameter == null) {
            connectionPool.tag("DiscordSvc");
            ConnectionPool.w(new Object[0]);
            CompletableDeferredImpl completableDeferredImpl2 = deferred;
            if (completableDeferredImpl2 != null) {
                completableDeferredImpl2.completeExceptionally(new DiscordAuthException$InvalidGrant("Missing authorization code", null));
            }
            finish();
            return;
        }
        connectionPool.tag("DiscordSvc");
        ConnectionPool.i(Integer.valueOf(queryParameter.length()));
        CompletableDeferredImpl completableDeferredImpl3 = deferred;
        if (completableDeferredImpl3 != null) {
            if (queryParameter2 == null) {
                queryParameter2 = "";
            }
            completableDeferredImpl3.makeCompleting$kotlinx_coroutines_core(new AuthCodeResult(queryParameter, queryParameter2));
        }
        finish();
    }
}
