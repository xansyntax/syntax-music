package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface TextContextMenuDataProvider {
    Rect contentBounds(LayoutCoordinates layoutCoordinates);

    TextContextMenuData data();

    /* JADX INFO: renamed from: position-tuRUvjQ */
    long mo211positiontuRUvjQ(LayoutCoordinates layoutCoordinates);
}
