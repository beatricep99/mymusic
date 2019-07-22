package com.bpetrean.mymusic.players;

import com.bpetrean.mymusic.players.Playable;

public class SoundCloudPlayable implements Playable {

    @Override
    public String getId(String eId) {
        return "soundcloud://tracks:" + eId.substring(eId.lastIndexOf("/") + 1);
    }
}
