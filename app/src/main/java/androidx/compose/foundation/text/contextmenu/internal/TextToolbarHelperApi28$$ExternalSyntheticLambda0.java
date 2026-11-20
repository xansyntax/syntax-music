package androidx.compose.foundation.text.contextmenu.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.view.MenuItem;
import android.view.textclassifier.TextClassification;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextToolbarHelperApi28$$ExternalSyntheticLambda0 implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ TextToolbarHelperApi28$$ExternalSyntheticLambda0(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) throws PendingIntent.CanceledException {
        byte b = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                Context context = (Context) obj2;
                TextClassification textClassification = (TextClassification) obj;
                String text = textClassification.getText();
                PendingIntent activity = PendingIntent.getActivity(context, text != null ? text.hashCode() : 0, textClassification.getIntent(), 201326592);
                if (Build.VERSION.SDK_INT < 34) {
                    activity.send();
                } else {
                    TextClassificationHelper34.sendIntentAllowBackgroundActivityStart(activity);
                }
                break;
            default:
                ((TextContextMenuItem) obj2).onClick.invoke(((AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl) obj).session);
                break;
        }
        return true;
    }
}
