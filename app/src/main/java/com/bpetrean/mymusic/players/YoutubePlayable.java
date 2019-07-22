package com.bpetrean.mymusic.players;

public class YoutubePlayable implements Playable {

    @Override
    public String getId(String eId) {
        int lastChar = eId.lastIndexOf("/");
        return "vnd.youtube:" + eId.substring(lastChar + 1);
    }
}
