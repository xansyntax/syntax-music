package androidx.compose.ui.autofill;

import android.view.autofill.AutofillId;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAutofill implements Autofill {
    public final AutofillTree autofillTree;
    public final AutofillId rootAutofillId;
    public final AndroidComposeView view;

    public AndroidAutofill(AndroidComposeView androidComposeView, AutofillTree autofillTree) {
        this.view = androidComposeView;
        this.autofillTree = autofillTree;
        androidComposeView.setImportantForAutofill(1);
        AutofillId autofillId = androidComposeView.getAutofillId();
        if (autofillId == null) {
            throw Fragment$5$$ExternalSyntheticOutline0.m$2("Required value was null.");
        }
        this.rootAutofillId = autofillId;
    }
}
