package leetcode.topinterviewquestion150.designproblem.seatreservationsystem_1845;

import java.util.TreeSet;

public class SeatReservationManagerTreeSet implements SeatReservationManager{

    private TreeSet<Integer> seats;

    @Override
    public void initialize(int n) {
        seats = new TreeSet<>();
        for(int i=1;i<=n;i++){
            seats.add(i);
        }
    }

    public int reserve() {
        return seats.pollFirst();
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}
