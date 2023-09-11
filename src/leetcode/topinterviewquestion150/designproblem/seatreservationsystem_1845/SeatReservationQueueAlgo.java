package leetcode.topinterviewquestion150.designproblem.seatreservationsystem_1845;

import java.util.PriorityQueue;

public class SeatReservationQueueAlgo implements SeatReservationManager {

    private PriorityQueue<Integer> seats;

    @Override
    public void initialize(int n) { // nlogn
        seats = new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            seats.add(i);
        }
    }

    @Override
    public int reserve() {
        return seats.poll(); // logn
    }

    @Override
    public void unreserve(int seatNumber) {
        seats.add(seatNumber);// logn
    }
}
