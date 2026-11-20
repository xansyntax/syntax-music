package com.metrolist.innertube.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MusicShelfRendererKt {
    public static final String getContinuation(List list) {
        Object next;
        ContinuationItemRenderer continuationItemRenderer;
        ContinuationItemRenderer.ContinuationEndpoint continuationEndpoint;
        ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand continuationCommand;
        list.getClass();
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((MusicShelfRenderer.Content) next).continuationItemRenderer == null);
        MusicShelfRenderer.Content content = (MusicShelfRenderer.Content) next;
        if (content == null || (continuationItemRenderer = content.continuationItemRenderer) == null || (continuationEndpoint = continuationItemRenderer.continuationEndpoint) == null || (continuationCommand = continuationEndpoint.continuationCommand) == null) {
            return null;
        }
        return continuationCommand.token;
    }

    public static final ArrayList getItems(List list) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = ((MusicShelfRenderer.Content) it.next()).musicResponsiveListItemRenderer;
            if (musicResponsiveListItemRenderer != null) {
                arrayList.add(musicResponsiveListItemRenderer);
            }
        }
        return arrayList;
    }
}
