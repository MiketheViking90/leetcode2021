package algo;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            int count = counts.getOrDefault(task, 0);
            counts.put(task, count + 1);
        }

        PriorityQueue<Job> jobs = getJobs(counts);
        Queue<PendingJob> pending = new LinkedList<>();

        int time = 0;
        while (!jobs.isEmpty() || !pending.isEmpty()) {
            if (!jobs.isEmpty()) {
                Job job = jobs.poll();
                job.count--;
                if (job.count != 0) {
                    pending.offer(new PendingJob(job, n+1));
                }
            }

            if (!pending.isEmpty()) {
                if (pending.peek().wait <= 0) {
                    PendingJob topPending = pending.poll();
                    jobs.offer(new Job(topPending));
                }
                for (PendingJob pendingJob : pending) {
                    pendingJob.wait--;
                }
            }
            time++;
        }
        return time;
    }

    private PriorityQueue<Job> getJobs(Map<Character, Integer> counts) {
        PriorityQueue<Job> jobs = new PriorityQueue<>();
        for (char task : counts.keySet()) {
            Job job = new Job(task, counts.get(task));
            jobs.offer(job);
        }
        return jobs;
    }

    public static void main(String[] args) {
        char[] tasks = {'a', 'a', 'a', 'a', 'a', 'b', 'b', 'b'};
        TaskScheduler ts = new TaskScheduler();
        ts.leastInterval(tasks, 2);
    }
}

class Job implements Comparable<Job> {
    char task;
    int count;

    public Job(char task, int count) {
        this.task = task;
        this.count = count;
    }

    public Job(PendingJob topPending) {
        this.task = topPending.task;
        this.count = topPending.count;
    }

    @Override
    public int compareTo(Job o1) {
        return Integer.compare(o1.count, this.count);
    }
}

class PendingJob implements Comparable<PendingJob> {
    char task;
    int count;
    int wait;

    public PendingJob(Job job, int wait) {
        this.task = job.task;
        this.count = job.count;
        this.wait = wait;
    }

    @Override
    public int compareTo(PendingJob o1) {
        return Integer.compare(this.wait, o1.wait);
    }
}