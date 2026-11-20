package com.metrolist.music.db.entities;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EventWithSong {
    public final Event event;
    public final Song song;

    public EventWithSong(Event event, Song song) {
        this.event = event;
        this.song = song;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventWithSong)) {
            return false;
        }
        EventWithSong eventWithSong = (EventWithSong) obj;
        return this.event.equals(eventWithSong.event) && this.song.equals(eventWithSong.song);
    }

    public final int hashCode() {
        return this.song.hashCode() + (this.event.hashCode() * 31);
    }

    public final String toString() {
        return "EventWithSong(event=" + this.event + ", song=" + this.song + ")";
    }
}
