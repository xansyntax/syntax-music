package androidx.compose.ui.platform;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidUriHandler implements UriHandler {
    public final Context context;

    public AndroidUriHandler(Context context) {
        this.context = context;
    }

    public final void openUri(String str) {
        try {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException e) {
            throw new IllegalArgumentException(IntIntPair$$ExternalSyntheticOutline0.m("Can't open ", str, "."), e);
        }
    }
}
