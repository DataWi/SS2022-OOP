package MusicLandscape.entities;

public class Concert extends Event {
    private int nextIdx;
    private Track[] setList;

    public boolean addTrack(Track t) {
        if (t == null) return false;
        if (setList == null) {
            setList = new Track[1];
            setList[0] = t;
        } else {
            Track[] temp;
            temp = new Track[setList.length + 1];
            int i = 0;
            for (Track track : setList) temp[i++] = track;
            temp[i] = t;
            setList = temp;
        }
        return true;
    }

    private void ensureCapacity(int length) {

    }

    public Track[] getSetList() {
        Track[] tmp = new Track[setList.length];
        int i = 0;
        for (Track t : setList) tmp[i++] = new Track(t);
        return tmp;
    }

    public void setSetList(Track[] tracks) {
        int max = 0, i = 0;
        for (Track t : tracks) max = t != null ? max + 1 : max;
        setList = new Track[max];
        for (Track t : tracks) {
            if (t == null) continue;
            setList[i] = new Track(t);
            i++;
        }
    }


    public void resetSetList() {
        setList = new Track[0];
        nextIdx = 0;
    }

    public int nrTracks() {
        if (setList == null) return 0;
        return setList.length;
    }

    public int duration() {
        int duration = 0;
        if (setList != null) for (Track t : setList) duration += t.getDuration();
        return duration;
    }

    @Override
    public int impact() {
        int factor = duration() / 60 / 30 + 1;
        return factor * getAttendees();
    }

    @Override
    public String toString() {
        int h = duration() / 60 / 60;
        int m = duration() / 60 % 60;
        return String.format("%s\n%d tracks played, total duration %02d:%02d.", super.toString(), setList.length, h, m);
    }


}
