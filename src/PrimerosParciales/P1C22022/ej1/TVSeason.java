package PrimerosParciales.P1C22022.ej1;

import java.util.Comparator;

public class TVSeason {
    private final TVEpisode[] episodes;
    private final int nEpisodes;

    public TVSeason(TVEpisode[] episodes) {
        this.episodes = episodes;
        this.nEpisodes = episodes.length;
    }

    public TVEpisode[] getEpisodes() {
        return episodes;
    }

    public TVEpisode[] getOrderedEpisodes(Comparator<TVEpisode> comparator) {
        TVEpisode[] copy = new TVEpisode[nEpisodes];
        System.arraycopy(episodes, 0, copy, 0, nEpisodes);
        java.util.Arrays.sort(copy, comparator);
        return copy;
    }

    public TVEpisode[] getDateOrderCopy() {
        Comparator<TVEpisode> comparator = new Comparator<TVEpisode>() {
            @Override
            public int compare(TVEpisode o1, TVEpisode o2) {
                int ans = o2.getAiredDate().compareTo(o1.getAiredDate());
                if(ans == 0){
                    return o1.getId() - o2.getId();
                } else {
                    return ans;
                }
            }
        };
        return getOrderedEpisodes(comparator);
    }

    public TVEpisode[] getNameOrderCopy() {
        Comparator<TVEpisode> comparator = new Comparator<TVEpisode>() {
            @Override
            public int compare(TVEpisode o1, TVEpisode o2) {
                int ans = o1.getTitle().compareTo(o2.getTitle());
                if(ans == 0){
                    return o1.getId() - o2.getId();
                } else {
                    return ans;
                }
            }
        };
        return getOrderedEpisodes(comparator);
    }

    public TVEpisode[] getRatingOrderCopy() {
        Comparator<TVEpisode> comparator = new Comparator<TVEpisode>() {
            @Override
            public int compare(TVEpisode o1, TVEpisode o2) {
                double ans = o2.getRating() - o1.getRating();
                if (ans > 0) {
                    return 1;
                } else if (ans < 0) {
                    return -1;
                } else {
                    return o1.getId() - o2.getId();
                }
            }
        };

        return getOrderedEpisodes(comparator);
    }

    public int getNumberOfEpisodes() {
        return nEpisodes;
    }
}
