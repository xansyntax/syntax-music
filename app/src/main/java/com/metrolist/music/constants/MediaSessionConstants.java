package com.metrolist.music.constants;

import android.os.Bundle;
import androidx.media3.session.SessionCommand;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaSessionConstants {
    public static final SessionCommand CommandAddToTargetPlaylist;
    public static final SessionCommand CommandToggleLibrary;
    public static final SessionCommand CommandToggleLike;
    public static final SessionCommand CommandToggleRepeatMode;
    public static final SessionCommand CommandToggleShuffle;
    public static final SessionCommand CommandToggleStartRadio;

    static {
        Bundle bundle = Bundle.EMPTY;
        CommandToggleLibrary = new SessionCommand("TOGGLE_LIBRARY", bundle);
        CommandToggleLike = new SessionCommand("TOGGLE_LIKE", bundle);
        CommandToggleStartRadio = new SessionCommand("TOGGLE_START_RADIO", bundle);
        CommandToggleShuffle = new SessionCommand("TOGGLE_SHUFFLE", bundle);
        CommandToggleRepeatMode = new SessionCommand("TOGGLE_REPEAT_MODE", bundle);
        CommandAddToTargetPlaylist = new SessionCommand("ADD_TO_TARGET_PLAYLIST", bundle);
    }
}
