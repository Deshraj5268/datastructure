package leetcode.topinterviewquestion150.designproblem.seatreservationsystem_1845;

public interface SeatReservationManager {

    void initialize(int n);

    int reserve();// min seat will be booked

    void unreserve(int seatNumber);
}
