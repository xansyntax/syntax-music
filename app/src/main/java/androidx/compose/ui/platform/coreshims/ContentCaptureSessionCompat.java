package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentCaptureSessionCompat implements ContentCaptureSessionWrapper {
    public final View mView;
    public final Object mWrappedObj;

    public ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    public final void flush() {
        if (Build.VERSION.SDK_INT >= 29) {
            ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0.m(this.mWrappedObj).notifyViewsDisappeared(this.mView.getAutofillId(), new long[]{Long.MIN_VALUE});
        }
    }

    public final AutofillId newAutofillId(long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0.m(this.mWrappedObj).newAutofillId(this.mView.getAutofillId(), j);
        }
        return null;
    }

    public final DrawResult newVirtualViewStructure(AutofillId autofillId, long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new DrawResult((byte) 27, ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0.m(this.mWrappedObj).newVirtualViewStructure(autofillId, j));
        }
        return null;
    }

    public final void notifyViewAppeared(ViewStructure viewStructure) {
        if (Build.VERSION.SDK_INT >= 29) {
            ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0.m(this.mWrappedObj).notifyViewAppeared(viewStructure);
        }
    }

    public final void notifyViewDisappeared(AutofillId autofillId) {
        if (Build.VERSION.SDK_INT >= 29) {
            ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0.m(this.mWrappedObj).notifyViewDisappeared(autofillId);
        }
    }

    public final void notifyViewTextChanged(AutofillId autofillId, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            ((ContentCaptureSession) this.mWrappedObj).notifyViewTextChanged(autofillId, str);
        }
    }
}
