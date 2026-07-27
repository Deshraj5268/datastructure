package queue.interval.linesweep;

class Event {
    int time;
    int type;// arrival : +1 , Dept : -1

    public Event(int time, int type) {
        this.time = time;
        this.type = type;
    }
}
