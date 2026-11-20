package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppCompatButton$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TextView f$0;

    public /* synthetic */ AppCompatButton$$ExternalSyntheticLambda0(TextView textView, byte b) {
        this.$r8$classId = b;
        this.f$0 = textView;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        byte b = this.$r8$classId;
        TextView textView = this.f$0;
        switch (b) {
            case 0:
                super/*android.widget.TextView*/.setTypeface((Typeface) obj);
                break;
            case 1:
                super/*android.widget.TextView*/.setTypeface((Typeface) obj);
                break;
            default:
                super/*android.widget.TextView*/.setTypeface((Typeface) obj);
                break;
        }
    }
}
