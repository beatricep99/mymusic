package com.bpetrean.mymusic.players;

import com.bpetrean.mymusic.players.Playable;

public class DailymotionPlayable implements Playable {
    @Override
    public String getId(String eId) {
        int lastChar = eId.lastIndexOf("/");
        return "" + eId.substring(lastChar + 1);
    }
}
