package androidx.compose.ui.text.platform;

import android.text.style.ClickableSpan;
import android.view.View;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.ui.text.LinkAnnotation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeClickableSpan extends ClickableSpan {
    public final LinkAnnotation link;

    public ComposeClickableSpan(LinkAnnotation linkAnnotation) {
        this.link = linkAnnotation;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        LinkAnnotation linkAnnotation = this.link;
        TextLinkScope$$ExternalSyntheticLambda10 linkInteractionListener = linkAnnotation.getLinkInteractionListener();
        if (linkInteractionListener != null) {
            linkInteractionListener.onClick(linkAnnotation);
        }
    }
}
