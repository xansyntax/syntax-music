package androidx.compose.foundation.text.contextmenu.internal;

import android.R;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.textclassifier.TextClassification;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextToolbarHelperApi28 {
    public static void addMenuItem(Menu menu, int i, Context context, TextClassification textClassification, int i2, Drawable drawable) {
        if (i2 < 0) {
            MenuItem menuItemAdd = menu.add(R.id.textAssist, R.id.textAssist, i, textClassification.getLabel());
            menuItemAdd.setShowAsAction(2);
            menuItemAdd.setIcon(drawable);
            menuItemAdd.setOnMenuItemClickListener(new TextToolbarHelperApi28$$ExternalSyntheticLambda0(context, textClassification, (byte) 0));
            return;
        }
        boolean z = i2 == 0;
        final RemoteAction remoteAction = textClassification.getActions().get(i2);
        MenuItem menuItemAdd2 = menu.add(R.id.textAssist, z ? 16908353 : 0, i, remoteAction.getTitle());
        menuItemAdd2.setShowAsAction(z ? 2 : 0);
        if (drawable != null) {
            menuItemAdd2.setIcon(drawable);
        }
        menuItemAdd2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextToolbarHelperApi28$$ExternalSyntheticLambda1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) throws PendingIntent.CanceledException {
                PendingIntent actionIntent = remoteAction.getActionIntent();
                if (Build.VERSION.SDK_INT >= 34) {
                    TextClassificationHelper34.sendIntentAllowBackgroundActivityStart(actionIntent);
                    return true;
                }
                actionIntent.send();
                return true;
            }
        });
    }
}
