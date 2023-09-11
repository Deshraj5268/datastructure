package leetcode.topinterviewquestion150.designproblem.seatreservationsystem_1845;

public class SeatReservationDriver {

    public static void main(String[] args) {
        SeatReservationManager seatReservationManager = new SeatReservationQueueAlgo();
        seatReservationManager.initialize(5);
        System.out.println(seatReservationManager.reserve());
        System.out.println(seatReservationManager.reserve());
        seatReservationManager.unreserve(2);
        System.out.println(seatReservationManager.reserve());
        System.out.println(seatReservationManager.reserve());
        System.out.println(seatReservationManager.reserve());
        System.out.println(seatReservationManager.reserve());
        seatReservationManager.unreserve(5);
    }
}
