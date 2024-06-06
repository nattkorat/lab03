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
        int peopleTake;
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
            int peopleCounter = 0;

            if (event.getCode() == 'p') {
                for (int i = 0; i < event.getNumOfPeople(); i++) {
                    eventsQueue.add(event);
                }
                System.out.println("Time " + event.getTime().geString() + " " +
                        event.getNumOfPeople()
                        + " people arrive. " + eventsQueue.size() + " people are now on the line.");

            } else if (event.getCode() == 'b') {
                peopleTake = event.getNumOfPeople();
                while (!eventsQueue.isEmpty() && peopleTake > 0) {
                    person = eventsQueue.poll();
                    seconds.add(event.getTime().getTimeDiffInSecond(person.getTime()));
                    peopleTake--;
                    peopleCounter++;
                }
                System.out.println("Time " + event.getTime().geString() + ". " + peopleCounter
                        + " people get on the bus, " + eventsQueue.size() + " people now remain.\n");
            }
        }

        for (int second : seconds) {
            sumSecond += second;
        }
        System.out.println("-----------------------------------");
        System.out.printf("The average waiting time is %.2f seconds.", (float) sumSecond / seconds.size());

    }

}
