package com.bpetrean.mymusic.players;

public class VimeoPlayable implements Playable {
    @Override
    public String getId(String eId) {
            int lastChar = eId.lastIndexOf("/");
            return "vimeo://app.vimeo.com/videos/" + eId.substring(lastChar + 1);
    }
}
