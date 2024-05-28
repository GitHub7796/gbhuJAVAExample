package main.gbhu.dateLearn;

public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    public void end() {
        this.endTime = System.currentTimeMillis();
    }

    public long getTotalTime() {
        return this.endTime - this.startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
