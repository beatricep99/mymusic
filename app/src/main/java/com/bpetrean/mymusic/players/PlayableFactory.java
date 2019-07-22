package com.bpetrean.mymusic.players;

public class PlayableFactory {

    public static Playable getPlayable(String source) {
        switch (source) {
            case "/yt":
                return new YoutubePlayable();
            case "/sc":
                return new SoundCloudPlayable();
            case "/vi":
                return new VimeoPlayable();
            case "/dz":
                return new DeezerPlayable();
            case"/dm":
                return new DailymotionPlayable();
            default:
                return new Playable() {

                    @Override
                    public String getId(String eId) {
                        return "";
                    }
                };
        }
    }
}
