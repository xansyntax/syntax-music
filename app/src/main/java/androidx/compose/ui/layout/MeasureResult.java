package androidx.compose.ui.layout;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MeasureResult {
    Map getAlignmentLines();

    int getHeight();

    default Function2 getRulerProvider() {
        return null;
    }

    default Function1 getRulers() {
        return null;
    }

    int getWidth();

    default Function1 isRulerProvided() {
        return null;
    }

    void placeChildren();
}
