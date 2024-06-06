import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.*;

public class Ex7 {
    public static void main(String[] args) {
        int sumSecond = 0;
        int takeFromFront, takeFromBack;

        Queue<Event> eventsQueueFront = new LinkedList<>();
        Queue<Event> eventsQueueBack = new LinkedList<>();
        List<Integer> seconds = new ArrayList<>();
        Event person;

        Event events[] = {
                new Event(new Time(7, 30, 0), 'p', 10),
                new Event(new Time(8, 5, 30), 'p', 15),
                new Event(new Time(8, 20, 45), 'b', 18),
                new Event(new Time(9, 0, 25), 'p', 22),
                new Event(new Time(9, 10, 55), 'b', 20),
                new Event(new Time(10, 5, 0), 'p', 5),
                new Event(new Time(10, 30, 15), 'b', 30)
        };

        for (Event event : events) {
            int frontCount = 0; // refresh for every event
            int backCount = 0; // refresh for every event

            if (event.getCode() == 'p') {
                if (eventsQueueFront.size() <= eventsQueueBack.size()) {
                    for (int i = 0; i < event.getNumOfPeople(); i++) {
                        eventsQueueFront.add(event);
                    }
                    System.out.println("Time " + event.getTime().geString() + ". " +
                            event.getNumOfPeople()
                            + " people arrive. " + eventsQueueFront.size() + " people are now on the FRONT line.");
                } else {
                    for (int i = 0; i < event.getNumOfPeople(); i++) {
                        eventsQueueBack.add(event);
                    }
                    System.out.println("Time " + event.getTime().geString() + ". " +
                            event.getNumOfPeople()
                            + " people arrive. " + eventsQueueBack.size() + " people are now on the BACK line.");
                }

            } else if (event.getCode() == 'b') {
                takeFromFront = takeFromBack = event.getNumOfPeople() / 2;
                takeFromFront += (event.getNumOfPeople() % 2 != 0) ? 1 : 0; // for odd, increase 1 to front

                if (takeFromFront > eventsQueueFront.size()) {
                    takeFromBack += takeFromFront - eventsQueueFront.size();
                } else if (takeFromBack > eventsQueueBack.size()) {
                    takeFromFront += takeFromBack - eventsQueueBack.size();
                }

                while (!eventsQueueFront.isEmpty() && takeFromFront > 0) {
                    person = eventsQueueFront.poll();
                    seconds.add(event.getTime().getTimeDiffInSecond(person.getTime()));
                    takeFromFront--;
                    frontCount++;
                }
                while (!eventsQueueBack.isEmpty() && takeFromBack > 0) {
                    person = eventsQueueBack.poll();
                    seconds.add(event.getTime().getTimeDiffInSecond(person.getTime()));
                    takeFromBack--;
                    backCount++;
                }
                System.out.println(
                        "Time " + event.getTime().geString() + ". " + frontCount + " from FRONT and " + backCount
                                + " from BACK get on the bus, " + eventsQueueFront.size() + " in the FRONT and "
                                + eventsQueueBack.size() + " in the BACK now remain.");
            }
        }
        for (int second : seconds) {
            sumSecond += second;
        }
        System.out.println("-----------------------------------");
        System.out.printf("The average waiting time is %.2f seconds.", (float) sumSecond / seconds.size());
    }
}
