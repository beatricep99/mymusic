package com.bpetrean.mymusic.players;

public class DeezerPlayable implements Playable {
    @Override
    public String getId(String eId) {
        int lastChar = eId.lastIndexOf("/");
        return "deezer://track/" + eId.substring(lastChar + 1);
    }
}
