package com.metrolist.innertube.pages;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.GridRenderer;
import com.metrolist.innertube.models.MusicNavigationButtonRenderer;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SectionListRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MoodAndGenres {
    public final ArrayList items;
    public final String title;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        /* JADX WARN: Code duplicated, block: B:36:0x007f  */
        public static MoodAndGenres fromSectionListRendererContent(SectionListRenderer.Content content) {
            GridRenderer.Header header;
            GridRenderer.Header.GridHeaderRenderer gridHeaderRenderer;
            Runs runs;
            List list;
            Run run;
            String str;
            Item item;
            Run run2;
            String str2;
            MusicNavigationButtonRenderer.Solid solid;
            content.getClass();
            GridRenderer gridRenderer = content.gridRenderer;
            if (gridRenderer == null || (header = gridRenderer.header) == null || (gridHeaderRenderer = header.gridHeaderRenderer) == null || (runs = gridHeaderRenderer.title) == null || (list = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list)) == null || (str = run.text) == null) {
                return null;
            }
            List list2 = gridRenderer.items;
            ArrayList arrayList = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                MusicNavigationButtonRenderer musicNavigationButtonRenderer = ((GridRenderer.Item) it.next()).musicNavigationButtonRenderer;
                if (musicNavigationButtonRenderer != null) {
                    arrayList.add(musicNavigationButtonRenderer);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                MusicNavigationButtonRenderer musicNavigationButtonRenderer2 = (MusicNavigationButtonRenderer) obj;
                musicNavigationButtonRenderer2.getClass();
                List list3 = musicNavigationButtonRenderer2.buttonText.runs;
                if (list3 == null || (run2 = (Run) CollectionsKt.firstOrNull(list3)) == null || (str2 = run2.text) == null || (solid = musicNavigationButtonRenderer2.solid) == null) {
                    item = null;
                } else {
                    long j = solid.leftStripeColor;
                    BrowseEndpoint browseEndpoint = musicNavigationButtonRenderer2.clickCommand.browseEndpoint;
                    if (browseEndpoint == null) {
                        item = null;
                    } else {
                        item = new Item(str2, j, browseEndpoint);
                    }
                }
                if (item != null) {
                    arrayList2.add(item);
                }
            }
            return new MoodAndGenres(str, arrayList2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Item {
        public final BrowseEndpoint endpoint;
        public final long stripeColor;
        public final String title;

        public Item(String str, long j, BrowseEndpoint browseEndpoint) {
            str.getClass();
            browseEndpoint.getClass();
            this.title = str;
            this.stripeColor = j;
            this.endpoint = browseEndpoint;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.title, item.title) && this.stripeColor == item.stripeColor && Intrinsics.areEqual(this.endpoint, item.endpoint);
        }

        public final int hashCode() {
            return this.endpoint.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.title.hashCode() * 31, 31, this.stripeColor);
        }

        public final String toString() {
            return "Item(title=" + this.title + ", stripeColor=" + this.stripeColor + ", endpoint=" + this.endpoint + ")";
        }
    }

    public MoodAndGenres(String str, ArrayList arrayList) {
        str.getClass();
        this.title = str;
        this.items = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MoodAndGenres)) {
            return false;
        }
        MoodAndGenres moodAndGenres = (MoodAndGenres) obj;
        return Intrinsics.areEqual(this.title, moodAndGenres.title) && this.items.equals(moodAndGenres.items);
    }

    public final int hashCode() {
        return this.items.hashCode() + (this.title.hashCode() * 31);
    }

    public final String toString() {
        return "MoodAndGenres(title=" + this.title + ", items=" + this.items + ")";
    }
}
