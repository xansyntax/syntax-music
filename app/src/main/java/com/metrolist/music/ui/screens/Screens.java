package com.metrolist.music.ui.screens;

import com.yalantis.ucrop.R;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Screens {
    public static final List MainScreens = CollectionsKt__IterablesKt.listOf((Object[]) new Screens[]{Home.INSTANCE, Search.INSTANCE, ListenTogether.INSTANCE, Library.INSTANCE});
    public final int iconIdActive;
    public final int iconIdInactive;
    public final String route;
    public final int titleId;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Home extends Screens {
        public static final Home INSTANCE = new Home(R.string.home, R.drawable.home_outlined, R.drawable.home_filled, "home");
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Library extends Screens {
        public static final Library INSTANCE = new Library(R.string.filter_library, R.drawable.library_music_outlined, R.drawable.library_music_filled, "library");
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ListenTogether extends Screens {
        public static final ListenTogether INSTANCE = new ListenTogether(R.string.together, R.drawable.group_outlined, R.drawable.group_filled, "listen_together");
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Search extends Screens {
        public static final Search INSTANCE = new Search(R.string.search, R.drawable.search, R.drawable.search, "search_input");
    }

    public Screens(int i, int i2, int i3, String str) {
        this.titleId = i;
        this.iconIdInactive = i2;
        this.iconIdActive = i3;
        this.route = str;
    }
}
