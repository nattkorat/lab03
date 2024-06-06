import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.*;

public class Ex6 {
    public static void main(String[] args) {
        Queue<Event> eventsQueue = new LinkedList<>();
        List<Integer> seconds = new ArrayList<>();
        int sumSecond = 0;
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
            // System.out.println(event.geString());
            if (event.getCode() == 'p') {
                for (int i = 0; i < event.getNumOfPeople(); i++) {
                    eventsQueue.add(event);

                }
                System.out.println("Time " + event.getTime().geString() + " " +
                        event.getNumOfPeople()
                        + " people arrive. " + eventsQueue.size() + " people are new on the line.");

            } else if (event.getCode() == 'b') {
                if (event.getNumOfPeople() > eventsQueue.size()) {
                    int size = eventsQueue.size();
                    for (int i = 0; i < size; i++) {
                        person = eventsQueue.poll();
                        seconds.add(event.getTime().getTimeDiffInSecond(person.getTime()));
                    }
                    System.out.println("Time " + event.getTime().geString() + ". " + size
                            + " people get on the bus, 0 people now remain.");
                } else {
                    for (int i = 0; i < event.getNumOfPeople(); i++) {
                        person = eventsQueue.poll();
                        seconds.add(event.getTime().getTimeDiffInSecond(person.getTime()));
                    }
                    System.out.println("Time " + event.getTime().geString() + ". " + event.getNumOfPeople()
                            + " people get on the bus, " + eventsQueue.size() + " people now remain.\n");
                }
            }

        }

        for (int second : seconds) {
            sumSecond += second;
        }
        System.out.println("-----------------------------------");
        System.out.printf("The average waiting time is %.2f seconds.", (float) sumSecond / seconds.size());

    }

}
