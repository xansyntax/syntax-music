package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HomeSection {
    public final String id;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AccountPlaylists extends HomeSection {
        public static final AccountPlaylists INSTANCE = new AccountPlaylists("account_playlists");

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof AccountPlaylists);
        }

        public final int hashCode() {
            return -1592429872;
        }

        public final String toString() {
            return "AccountPlaylists";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DailyDiscover extends HomeSection {
        public static final DailyDiscover INSTANCE = new DailyDiscover("daily_discover");

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof DailyDiscover);
        }

        public final int hashCode() {
            return -276409082;
        }

        public final String toString() {
            return "DailyDiscover";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ForgottenFavorites extends HomeSection {
        public static final ForgottenFavorites INSTANCE = new ForgottenFavorites("forgotten_favorites");

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof ForgottenFavorites);
        }

        public final int hashCode() {
            return -552735751;
        }

        public final String toString() {
            return "ForgottenFavorites";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FromTheCommunity extends HomeSection {
        public static final FromTheCommunity INSTANCE = new FromTheCommunity("from_the_community");

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof FromTheCommunity);
        }

        public final int hashCode() {
            return 1368702174;
        }

        public final String toString() {
            return "FromTheCommunity";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class HomePageSection extends HomeSection {
        public final int index;

        public HomePageSection(int i) {
            super(IntIntPair$$ExternalSyntheticOutline0.m(i, "home_page_section_"));
            this.index = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HomePageSection) && this.index == ((HomePageSection) obj).index;
        }

        public final int hashCode() {
            return Integer.hashCode(this.index);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(this.index, "HomePageSection(index=", ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeepListening extends HomeSection {
        public static final KeepListening INSTANCE = new KeepListening("keep_listening");

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof KeepListening);
        }

        public final int hashCode() {
            return 398966426;
        }

        public final String toString() {
            return "KeepListening";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MoodAndGenres extends HomeSection {
        public static final MoodAndGenres INSTANCE = new MoodAndGenres("mood_and_genres");

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof MoodAndGenres);
        }

        public final int hashCode() {
            return -513171788;
        }

        public final String toString() {
            return "MoodAndGenres";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class QuickPicks extends HomeSection {
        public static final QuickPicks INSTANCE = new QuickPicks("quick_picks");

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof QuickPicks);
        }

        public final int hashCode() {
            return 1300660513;
        }

        public final String toString() {
            return "QuickPicks";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SimilarRecommendation extends HomeSection {
        public final int index;

        public SimilarRecommendation(int i) {
            super(IntIntPair$$ExternalSyntheticOutline0.m(i, "similar_recommendation_"));
            this.index = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SimilarRecommendation) && this.index == ((SimilarRecommendation) obj).index;
        }

        public final int hashCode() {
            return Integer.hashCode(this.index);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(this.index, "SimilarRecommendation(index=", ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SpeedDial extends HomeSection {
        public static final SpeedDial INSTANCE = new SpeedDial("speed_dial");

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof SpeedDial);
        }

        public final int hashCode() {
            return 284908091;
        }

        public final String toString() {
            return "SpeedDial";
        }
    }

    public HomeSection(String str) {
        this.id = str;
    }
}
